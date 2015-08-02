package com.eachedu.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.MessageNoticeDao;
import com.eachedu.dao.OrderInfoDao;
import com.eachedu.dao.PrivilegeGroupInfoDao;
import com.eachedu.dao.pojo.ComplainSolve;
import com.eachedu.dao.pojo.MessageNotice;
import com.eachedu.dao.pojo.OrderInfo;
import com.eachedu.dict.AccountType;
import com.eachedu.dict.ComplainStatus;
import com.eachedu.dict.ComplainType;
import com.eachedu.dict.MessageBusType;
import com.eachedu.dict.MessageStatus;
import com.eachedu.dict.OrderType;
import com.eachedu.dict.PrivilegeGroup;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.ComplainSolveService;

@Service("complainSolveService")
public class ComplainSolveServiceImpl extends BaseServiceImpl<ComplainSolve, Long>implements ComplainSolveService {
	
	private static final Logger log = LoggerFactory.getLogger(ComplainSolveServiceImpl.class);
	
	@Resource(name="messageNoticeDao")
	private MessageNoticeDao messageNoticeDao;
	
	@Resource(name="orderInfoDao")
	private OrderInfoDao orderInfoDao;
	
	@Resource(name="privilegeGroupInfoDao")
	private PrivilegeGroupInfoDao privilegeGroupInfoDao;
	
	@Resource(name="complainSolveDao")
	@Override
	public void setDao(BaseDao<ComplainSolve, Long> dao) {
		this.dao = dao;
	}

	@Override
	public Long saveComplain(String orderNo, String complainType, String complainContext, Long userId) throws ServiceException {
		try {
			
			log.debug("@@@ para -> orderNo:"+orderNo+"|complainType:"+complainType+"|complainContext:"+complainContext+"|userId:"+userId);
			
			if(StringUtils.isEmpty(orderNo)){
				throw new Exception("订单号不能为空!");
			}
			if (complainType==null) {
				throw new Exception("打分不能为空!");
			}
			if(StringUtils.isEmpty(complainType)){
				throw new Exception("投诉类型不能为空!");
			}
			
			boolean flag = false;
			for (ComplainType ct : ComplainType.values()) {
				if(ct.name().equals(complainType)){
					flag=true;
					break;
				}
			}
			if(!flag){
				throw new Exception("投诉类型["+complainType+"]不在值域范围内!"); 
			}
			
			StringBuffer csExistsSql = new StringBuffer(300);
			csExistsSql .append(" SELECT                            ")
						.append("  oi.`order_no`                    ")
						.append(" FROM order_info oi                ")
						.append("   JOIN question_info qi           ")
						.append("     ON oi.bus_id=qi.qi_id         ")
						.append("       AND oi.order_type='ASK_PAY' ")
						.append("   JOIN complain_solve cs          ")
						.append("     ON cs.qi_id=qi.qi_id          ")
						.append("  WHERE oi.order_no=?              ");
			
			List<Map<String, Object>> list = dao.findBySQL(csExistsSql.toString(), orderNo);
			if(list!=null && !list.isEmpty()){
				throw new Exception("订单号["+orderNo+"]已经投诉过了,请不要重复投诉.");
			}
			
			OrderInfo o = orderInfoDao.get(orderNo);
			
			ComplainSolve cs = new ComplainSolve();
			
			if(OrderType.ASK_PAY.name().equals(o.getOrderType())){
				//建立与问题的关联
				cs.setQiId(o.getBusId());
			}else{
				throw new Exception("订单类型不是提问类型!");
			}
			
			cs.setComplainType(complainType);
			cs.setComplainContext(complainContext);
			cs.setComplanStatus(ComplainStatus.CHARGE.name());
			cs.setComplanTime(new Date());
			dao.save(cs);
			log.debug("@@@@ 投诉保存成功!");
			
			//发系统消息给学生
			MessageNotice studentMessage = new MessageNotice();
			studentMessage.setAccountId(userId);
			studentMessage.setAccountType(AccountType.STUDENT_TYPE.name());
			studentMessage.setBusId(cs.getCsId());
			studentMessage.setBusType(MessageBusType.COMPLAIN_BUS.name());
			studentMessage.setSendTime(new Date());
			studentMessage.setStatus(MessageStatus.UNREAD.name());
			messageNoticeDao.save(studentMessage );
			log.debug("@@@@@ 学生消息新增成功");
			
			String pgiSql = "select pgi_id from privilege_group_info where group_name = ? ";
			List<Map<String, Object>> pgis = privilegeGroupInfoDao.findBySQL(pgiSql, PrivilegeGroup.OPERATION_MANAGER.name());
			//发送系统消息给运营组
			if(pgis!=null && !pgis.isEmpty()){
				Long pgiId = Long.parseLong(pgis.get(0).get("pgi_id").toString()) ;
				
				MessageNotice operatorMessage = new MessageNotice();
				operatorMessage.setPrivilegeId(pgiId);
				operatorMessage.setAccountType(AccountType.OPERATOR_TYPE.name());
				operatorMessage.setBusId(cs.getCsId());
				operatorMessage.setBusType(MessageBusType.COMPLAIN_BUS.name());
				operatorMessage.setSendTime(new Date());
				operatorMessage.setStatus(MessageStatus.UNREAD.name());
				messageNoticeDao.save(operatorMessage );
				log.debug("@@@@@ 运营组消息新增成功");
			}
			
			log.info("#####投诉完成，返回 ciId:"+cs.getCsId());
			return cs.getCsId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
		
		
		
	}

}
