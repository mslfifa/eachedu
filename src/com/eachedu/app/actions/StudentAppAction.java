package com.eachedu.app.actions;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.service.StudentInfoService;
import com.eachedu.web.actions.BaseAction;

@Controller("studentAppAction")
@Scope("prototype")
public class StudentAppAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(StudentAppAction.class);
	
	@Resource(name="studentInfoService")
	private StudentInfoService studentInfoService;
	
	private String mobile;
	private String password;
	private String verifyCode;
	
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

	
}
