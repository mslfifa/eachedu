package com.eachedu.app.actions;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.service.CoursewareInfoService;
import com.eachedu.service.QuestionInfoService;
import com.eachedu.service.ResourceInfoService;
import com.eachedu.service.TeacherInfoService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.PagerVO;
import com.eachedu.web.vo.UserVO;
@Controller("questionAppAction")
@Scope("prototype")
public class QuestionAppAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(QuestionAppAction.class);
	
	private Long siId;
	private String status;
	private int topNum=1;
	
	private Integer pageNo;
	private Integer pageSize;
	
	//订单号 查询使用，要新增时不能传入，按规则生成
	private String orderNo;
	
	private Long tiId;
	private String mobile;
	private String grade;
	private String course;
	private String questionDesc;
	private String communicateWay;
	private BigDecimal prise;
	private BigDecimal bonus;
	
	//问题图片文件
	private File askPic;
	//问题图片文件名
	private String askPicFileName;
	//问题图片正文类型
	private String askPicContentType;
	////问题图片标题
	private String askPicCaption;
	
	
	public Long getSiId() {
		return siId;
	}

	public void setSiId(Long siId) {
		this.siId = siId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTopNum() {
		return topNum;
	}

	public void setTopNum(int topNum) {
		this.topNum = topNum;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public File getAskPic() {
		return askPic;
	}

	public void setAskPic(File askPic) {
		this.askPic = askPic;
	}

	public String getAskPicFileName() {
		return askPicFileName;
	}

	public void setAskPicFileName(String askPicFileName) {
		this.askPicFileName = askPicFileName;
	}

	public String getAskPicContentType() {
		return askPicContentType;
	}

	public void setAskPicContentType(String askPicContentType) {
		this.askPicContentType = askPicContentType;
	}

	public String getAskPicCaption() {
		return askPicCaption;
	}

	public void setAskPicCaption(String askPicCaption) {
		this.askPicCaption = askPicCaption;
	}

	public Long getTiId() {
		return tiId;
	}

	public void setTiId(Long tiId) {
		this.tiId = tiId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public String getCommunicateWay() {
		return communicateWay;
	}

	public void setCommunicateWay(String communicateWay) {
		this.communicateWay = communicateWay;
	}
	
	public BigDecimal getPrise() {
		return prise;
	}

	public void setPrise(BigDecimal prise) {
		this.prise = prise;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}





	@Resource(name="questionInfoService")
	private QuestionInfoService questionInfoService;
	
	@Resource(name="teacherInfoService")
	private TeacherInfoService teacherInfoService;
	
	@Resource(name="resourceInfoService")
	private ResourceInfoService resourceInfoService;
	
	@Resource(name="coursewareInfoService")
	private CoursewareInfoService coursewareInfoService;

	public void findQuestionPageByStudent(){
		
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			PagerVO page = questionInfoService.findQuestionPageByStudent(siId, pageNo, pageSize);
			result.put("data", page.getDatas());
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg",  "查找失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
		
	}
	
	/**
	 * 根据订单号查询问题及回答信息
	 */
	public void findQuetionByOrderNo(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Map<String, Object> data = questionInfoService.findQuetionByOrderNo(orderNo);
			
			result.put("data", data);
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "查找失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
	/**
	 * 学生提问产生订单
	 */
	public void ask(){
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			UserVO userVO =  (UserVO) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
			Long siId = userVO.getId();
			Map data = questionInfoService.saveAsk(siId,mobile,grade,course,communicateWay,questionDesc,askPic,askPicFileName,askPicContentType,askPicCaption, tiId, prise, bonus);
			result.put("data", data);
			result.put("http_status", true);
			result.put("http_msg", "提问成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "提问失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
		
	}
	
}
