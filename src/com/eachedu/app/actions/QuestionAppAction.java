package com.eachedu.app.actions;

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
import com.eachedu.service.TeacherInfoService;
import com.eachedu.web.actions.BaseAction;
@Controller("questionAppAction")
@Scope("prototype")
public class QuestionAppAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(QuestionAppAction.class);
			
	private String status;
	private int topNum=1;
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


	@Resource(name="questionOfferingService")
	private QuestionOfferingService questionOfferingService;
	@Resource(name="teacherInfoService")
	private TeacherInfoService teacherInfoService;
	
	
	public void findQuestionedByStatus(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Long countNum = questionOfferingService.findQuestionedByStatus(status);
			log.debug("@@@@@ countNum:"+countNum);
			result.put("countNum", countNum);
			
			List<Map<String, Object>> teachers = teacherInfoService.findTopAnswerTeachers(topNum);
			result.put("teachers", teachers);
			
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
	
}
