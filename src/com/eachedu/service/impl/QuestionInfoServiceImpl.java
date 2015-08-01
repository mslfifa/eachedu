package com.eachedu.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.GradeCourseInfoDao;
import com.eachedu.dao.OrderInfoDao;
import com.eachedu.dao.ResourceInfoDao;
import com.eachedu.dao.TeacherAnswerDao;
import com.eachedu.dao.pojo.GradeCourseInfo;
import com.eachedu.dao.pojo.OrderInfo;
import com.eachedu.dao.pojo.QuestionInfo;
import com.eachedu.dao.pojo.ResourceInfo;
import com.eachedu.dao.pojo.TeacherAnswer;
import com.eachedu.dict.AccountType;
import com.eachedu.dict.AnswerConnectType;
import com.eachedu.dict.CodeType;
import com.eachedu.dict.CommunicateWay;
import com.eachedu.dict.OrderStatus;
import com.eachedu.dict.OrderType;
import com.eachedu.dict.QuestionStatus;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.QuestionInfoService;
import com.eachedu.utils.GenerateStrUtils;
import com.eachedu.utils.PropUtils;
import com.eachedu.web.vo.PagerVO;
@Service("questionInfoService")
public class QuestionInfoServiceImpl extends BaseServiceImpl<QuestionInfo, Long>
		implements QuestionInfoService {
	
	private static final Logger log = LoggerFactory.getLogger(QuestionInfoServiceImpl.class);
	
	@Resource(name="questionInfoDao")
	@Override
	public void setDao(BaseDao<QuestionInfo, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

	@Resource(name="resourceInfoDao")
	private ResourceInfoDao resourceInfoDao; 
	
	@Resource(name="teacherAnswerDao")
	private TeacherAnswerDao teacherAnswerDao;
	
	@Resource(name="gradeCourseInfoDao")
	private GradeCourseInfoDao gradeCourseInfoDao;
	@Resource(name="orderInfoDao")
	private OrderInfoDao orderInfoDao;

	@Override
	public Long findQuestionedByStatus(String status) throws ServiceException {
		
		
		try {
			Long countNum = null;
			if(StringUtils.isEmpty(status)){
				throw new Exception("status不能为空");
			}
			String hql = "select count(*) as count_num from QuestionInfo where status = ? ";
			List list = dao.findByHql(hql, status);
			if(list!=null && !list.isEmpty()){
				countNum = (Long) list.get(0);
			}else{
				countNum = 0l;
			}
			return countNum;
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error(e.getMessage());
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public PagerVO findQuestionPageByStudent(Long siId, Integer pageNo, Integer pageSize) throws ServiceException {
		
		try {
			
			if(siId==null){
				throw new Exception("学生ID["+siId+"]不能为空,请联系管理员!");
			}
			
			int offset = (pageNo==null ||pageNo==0)?0:(pageNo-1)*pageSize;
			pageSize = pageSize==null?20:pageSize;
			log.debug("@@@@ offset:"+offset+"|pagesize:"+pageSize+"|siId:"+siId);
			StringBuffer sql = new StringBuffer();
			sql .append(" SELECT qi.qi_id,order_no      ")
				.append("   ,qi.question_desc,qi.pic_id    ")
				.append("   ,qi.prise,gci.grade,gci.course ")
				.append("   ,ti.ti_id,ti.name,ti.school    ")
				.append("   ,ti.head_short_id              ")
				.append(" FROM question_info qi        ")
				.append("   JOIN grade_course_info gci     ")
				.append("     ON qi.gci_id=gci.gci_id      ")
				.append("   LEFT JOIN teacher_answer ta    ")
				.append("     ON qi.qi_id=ta.qi_id   ")
				.append("   LEFT JOIN teacher_info ti      ")
				.append("     ON ti.ti_id=ta.ti_id         ")
				.append(" WHERE qi.si_id=?                 ")
				.append(" ORDER BY qi.ask_time DESC        ");
			
			return dao.findBySqlPage(sql.toString(),offset,pageSize, siId);
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error(e.getMessage());
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public List<Map<String, Object>> findQuetionByOrderNo(String orderNo) throws ServiceException {
		
		try {
			log.debug("#### orderNo:"+orderNo);
			StringBuffer sql = new StringBuffer(400);
			sql .append(" SELECT qi.qi_id,qi.order_no           ")
				.append("   ,qi.question_desc,qi.prise,qi.bonus ")
				.append("   ,qi.pic_id AS question_pic_id       ")
				.append("   ,gci.course,gci.grade               ")
				.append("   ,ti.ti_id,ti.name                   ")
				.append("   ,ti.school,ti.head_short_id         ")
				.append("   ,ta.pic_id AS answer_pic_id         ")
				.append("   ,ta.`answer_content`                ")
				.append(" FROM question_info qi                 ")
				.append("   JOIN grade_course_info gci          ")
				.append("     ON qi.gci_id=gci.gci_id           ")
				.append("   LEFT JOIN teacher_answer ta         ")
				.append("     ON qi.qi_id=ta.qi_id        ")
				.append("   LEFT JOIN teacher_info ti           ")
				.append("     ON ta.ti_id=ti.ti_id              ")
				.append(" WHERE qi.order_no = ?                 ")
			    .append(" ORDER BY ta.answer_time desc          ");
			
			return dao.findBySQL(sql.toString(), orderNo);
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error(e.getMessage());
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public Map<String, Object> saveAsk(Long siId, String askMobile, String grade, String course, String communicateWay,
			String questionDesc, File askPic, String askPicFileName, String askPicContentType, String askPicCaption, Long tiId, BigDecimal prise, BigDecimal bonus) throws ServiceException {
		try {
			Map<String,Object> result = new HashMap<String,Object>();
			
			log.debug("#### para askMobile:"+askMobile+"|grade:"+grade+"|course:"+course+"|communicateWay:"+communicateWay
					+"|questionDesc:"+"|askPic:"+askPic+"|askPicFileName:"+askPicFileName+"|askPicContentType:"+askPicContentType
					+ "|askPicCaption:"+askPicCaption+"|tiId:"+tiId);
			if(siId==null){
				throw new Exception("提问学生ID不能为空!");
			}
			if(prise==null){
				throw new Exception("费用不能为空!");
			}
			if(askPic==null){
				throw new Exception("问题图片不能为空!");
			}
			if(StringUtils.isEmpty(grade)){
				throw new Exception("年级不能为空!");
			}
			if(StringUtils.isEmpty(course)){
				throw new Exception("课程不能为空!");
			}
			if(StringUtils.isEmpty(communicateWay)){
				throw new Exception("沟通方式不能为空!");
			}
			
			if(StringUtils.isEmpty(communicateWay)){
				throw new Exception("沟通方式不能为空!");
			}
			
			
			StringBuffer hql = new StringBuffer(100);
			hql.append(" FROM GradeCourseInfo WHERE grade = ? AND course = ? ");
			List gciList = gradeCourseInfoDao.findByHql(hql.toString(), grade,course);
			
			Long gciId = null;
			//判断年级课程是否存在
			if(gciList==null ||gciList.isEmpty()){
				throw new Exception("年级["+grade+"]课程["+course+"]不存在,请联系管理员.");
			}else{
				GradeCourseInfo gci =(GradeCourseInfo) gciList.get(0);
				gciId = gci.getGciId();
			}
			
			String relativeDir =PropUtils.get("dir_question_pic");
			String resourceRealName = UUID.randomUUID().toString()+askPicFileName.substring(askPicFileName.indexOf("."), askPicFileName.length());
			
			//写文件
			String filePath = PropUtils.get("dir_upload_root")+"/"+relativeDir+"/"+resourceRealName;
			File file = new File(filePath);
			if(!file.getParentFile().exists()){
				boolean f = file.getParentFile().mkdirs();
				log.debug("### 目录生成:"+f+" |path:"+file.getParentFile().getPath());
			}
			FileUtils.copyFile(askPic, file);
			log.info("@@@@ 写文件成功");
			
			
			//保存资源
			ResourceInfo r = new ResourceInfo();
			FileInputStream fis = new FileInputStream(askPic);
			r.setResourceSize(fis.available());
			
			r.setRelativeDir(relativeDir);
			
			r.setContentType(askPicContentType);
			
			askPicFileName = StringUtils.isEmpty(askPicFileName)?askPic.getName():askPicFileName;
			r.setResouceOriginName(askPicFileName);
			
			log.debug("@@@@ resourceRealName:"+resourceRealName);
			r.setResourceRealName(resourceRealName);
			r.setCreateTime(new Date());
			//保存资源信息 
			resourceInfoDao.save(r);
			log.debug("$$$$ 保存资源对象成功");
			
			QuestionInfo q = new QuestionInfo();
			q.setSiId(siId);
			q.setAskMobile(askMobile);
			q.setAskTime(new Date());
			q.setBonus(bonus);
			q.setCommunicateWay(communicateWay);
			//与课件发生关联
			q.setGciId(gciId);
			
			
			//与图片资源关联
			q.setPicId(r.getRiId());
			q.setQuestionDesc(questionDesc);		
			q.setStatus(QuestionStatus.WATING.name());
			dao.save(q);
			log.debug("@@@ 保存问题订单成功");
			
			
			String orderNo =null;
			if(CommunicateWay.PHONE_TYPE.name().equals(communicateWay)){
				orderNo = GenerateStrUtils.generateOrderNo(CodeType.MOBILE_ASK.name());
			}else if(CommunicateWay.PIC_TEXT_TYPE.name().equals(communicateWay)){
				orderNo = GenerateStrUtils.generateOrderNo(CodeType.TEXT_ASK.name());
			}else{
				throw new Exception("沟通方式不在值域范围内");
			}
			
			log.debug("#### generate orderNo:"+orderNo);
			
			OrderInfo o = new OrderInfo();
			o.setOrderNo(orderNo);
			o.setOrderType(OrderType.ASK_PAY.name());
			o.setPrise(prise);
			o.setBonus(bonus);
			BigDecimal sumMoney = bonus==null?prise:prise.add(bonus);
			o.setSumMoney(sumMoney );
			o.setStatus(OrderStatus.TRADE_APPLY.name());
			o.setBusId(q.getQiId());
			o.setAccountType(AccountType.STUDENT_TYPE.name());
			o.setCreateId(siId);
			o.setCreateTime(new Date());
			//新增订单对象
			orderInfoDao.save(o );
			log.debug("#### 保存订单成功!");
			
			
			//如果指定了老师，还在分配问题给老师，等待老师的回答 
			if(tiId!=null){
				TeacherAnswer ta = new TeacherAnswer();
				//关联订单
				ta.setQiId(q.getQiId());
				ta.setConnectType(AnswerConnectType.ASSIGN_TYPE.name());
				ta.setAssignTime(new Date());
				teacherAnswerDao.save(ta);
				log.debug("$$$$$ 指派老师成功");
			}
			
			log.info("@@@@@@@ 完成问题订单全部操作 qiId"+q.getQiId()+"|orderNo:"+o.getOrderNo());
			result.put("orderNo", o.getOrderNo());
			result.put("grade", grade);
			result.put("course", course);
			result.put("questionDesc", questionDesc);
			result.put("prise", prise);
			result.put("bonus", bonus);
			return result;
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error(e.getMessage());
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
		
	}

}
