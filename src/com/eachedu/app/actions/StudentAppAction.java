package com.eachedu.app.actions;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.service.StudentInfoService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.PagerVO;
import com.eachedu.web.vo.UserVO;

@Controller("studentAppAction")
@Scope("prototype")
public class StudentAppAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(StudentAppAction.class);
	
	@Resource(name="studentInfoService")
	private StudentInfoService studentInfoService;
	
	private String mobile;
	private String password;
	private String verifyCode;
	private Integer appPageNo;
	private Integer appPageSize;
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	

	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}

	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}

	public Integer getAppPageNo() {
		return appPageNo;
	}

	public void setAppPageNo(Integer appPageNo) {
		this.appPageNo = appPageNo;
	}

	public Integer getAppPageSize() {
		return appPageSize;
	}

	public void setAppPageSize(Integer appPageSize) {
		this.appPageSize = appPageSize;
	}

	public void viewUserInfo(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			
			UserVO userVO = (UserVO) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
			Map<String,Object> data = studentInfoService.findUserInfo(userVO.getId());
			result.put("data",data);
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.put("http_status", false);
			result.put("http_msg", "查找失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
	public void findBuyCourseware(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			
			UserVO userVO = (UserVO) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
			PagerVO page = studentInfoService.findBuyCourseware(userVO.getId(),appPageNo,appPageSize);
			result.put("page",page);
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.put("http_status", false);
			result.put("http_msg", "查找失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
}
