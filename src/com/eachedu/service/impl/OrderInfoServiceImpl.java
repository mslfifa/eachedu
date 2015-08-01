package com.eachedu.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.OrderInfo;
import com.eachedu.dict.AccountType;
import com.eachedu.dict.CodeType;
import com.eachedu.dict.OrderStatus;
import com.eachedu.dict.OrderType;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.OrderInfoService;
import com.eachedu.utils.GenerateStrUtils;

@Service("orderInfoService")
public class OrderInfoServiceImpl extends BaseServiceImpl<OrderInfo, String>implements OrderInfoService {

	private static final Logger log = LoggerFactory.getLogger(OrderInfoServiceImpl.class);
	
	@Resource(name="orderInfoDao")
	@Override
	public void setDao(BaseDao<OrderInfo, String> dao) {
		this.dao=dao;
		
	}

	@Override
	public Map<String, Object> saveBuy(Long ciId, String accountType, Long accountId) throws ServiceException {
		try {
			log.debug("$$$$ para -> ciId:"+ciId+"|accountType:"+accountType+"|accountId:"+accountId);
			if(ciId==null){
				throw new Exception("课件不能为空!");
			}
			
			if(StringUtils.isEmpty(accountType)){
				throw new Exception("账户类型不能为空!");
			}else{
				boolean flag = false;
				for (AccountType at : AccountType.values()) {
					if(at.name().equals(accountType)){
						flag = true;
						break;
					}
					
				}
				if(flag==false){
					throw new Exception("accountType["+accountType+"]不在值域范围内");
				}
			}
			
			
			
			if(accountId==null){
				throw new Exception("购买者ID不能为空!");
			}
			
			
			StringBuffer sql = new StringBuffer(400); 
			sql	.append(" SELECT ci_id,courseware_title ")
				.append("   ,ci.prise,o.order_no        ")
				.append("   ,o.sum_money,o.create_time  ")
				.append(" FROM courseware_info ci       ")
				.append("   LEFT JOIN                   ")
				.append("   (                           ")
				.append("     SELECT *                  ")
				.append("     FROM order_info oi        ")
				.append("     WHERE oi.account_type=?   ")
				.append("       AND oi.buyer_id=?       ")
				.append("       AND oi.order_type='DOWNLOAD_PAY' ")
				.append("   ) o                    ") 
				.append("     ON ci.ci_id=o.bus_id ")
				.append(" WHERE ci_id=?            ");
			List ciList = dao.findBySQL(sql.toString(),accountType,accountId,ciId);
			Map<String,Object> ciMap = null;
			if(ciList!=null && !ciList.isEmpty()){
				ciMap = (Map<String, Object>) ciList.get(0);
				
				//如果已经购买过就抛错提示
				if(StringUtils.isNotEmpty((String) ciMap.get("order_no"))){
					throw new Exception("您已经于"+ciMap.get("create_time")+"花"+ciMap.get("sum_money")+"元购买了'"+ciMap.get("courseware_title")+"'课件");
				}
			}else{
				throw new Exception("数据库不存在ID["+ciId+"]的课件");
			}
			
			OrderInfo o = new OrderInfo();
			String orderNo = GenerateStrUtils.generateOrderNo(CodeType.COURSEWARE_DOWN.name());
			log.debug("###generate orderNo:"+orderNo);
			o.setOrderNo(orderNo);
			o.setOrderType(OrderType.DOWNLOAD_PAY.name());
			o.setAccountType(accountType);
			o.setBuyerId(accountId);
			BigDecimal prise = (BigDecimal) ciMap.get("prise");
			o.setPrise(prise);
			o.setSumMoney(prise);
			o.setStatus(OrderStatus.TRADE_CLOSED.name());
			o.setBusId(ciId);
			o.setOrderDesc("购买课件"+ciMap.get("courseware_title"));
			o.setCreateTime(new Date());
			dao.save(o);
			log.info("@@@@购买成功,orderNo:"+orderNo);
			
			
			Map<String,Object> result = new HashMap<String,Object>();
			
			result.put("orderNo", orderNo);
			result.put("courseware_title", ciMap.get("courseware_title"));
			result.put("sum_money", o.getSumMoney());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	

}
