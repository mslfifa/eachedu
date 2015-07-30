package com.eachedu.app.actions;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.service.QuestionOfferingService;
import com.eachedu.service.ResourceInfoSerivce;
import com.eachedu.service.TeacherInfoService;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.PagerVO;
@Controller("questionAppAction")
@Scope("prototype")
public class QuestionAppAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(QuestionAppAction.class);
	
	private Long siId;
	private String status;
	private int topNum=1;
	
	private Integer pageNo;
	private Integer pageSize;
	
	private String orderNo;
	
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



	@Resource(name="questionOfferingService")
	private QuestionOfferingService questionOfferingService;
	
	@Resource(name="teacherInfoService")
	private TeacherInfoService teacherInfoService;
	
	@Resource(name="resourceInfoSerivce")
	private ResourceInfoSerivce resourceInfoSerivce;

	
	public void findQuestionPageByStudent(){
		
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			PagerVO page = questionOfferingService.findQuestionPageByStudent(siId, pageNo, pageSize);
			result.put("data", page.getDatas());
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		}
		this.ajaxWriteOutJSON(result);
		
	}
	
	/**
	 * 根据订单号查询问题及回答信息
	 */
	public void findQuetionByOrderNo(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = questionOfferingService.findQuetionByOrderNo(orderNo);
			
			result.put("data", list);
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		}
		this.ajaxWriteOutJSON(result);
	}
	
	/**
	 * 学生提问产生订单
	 */
	public void askOrder(){
		
	}
	
}
