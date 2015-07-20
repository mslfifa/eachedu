package com.eachedu.web.actions;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.service.OperatorInfoService;
import com.eachedu.service.StudentInfoService;
import com.eachedu.service.TeacherInfoService;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction{
	
	private String userName;
	private String passWord;
	private String accountType;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	@Resource
	private OperatorInfoService operatorInfoService;
	@Resource
	private StudentInfoService studentInfoService;
	@Resource
	private TeacherInfoService teacherInfoService;
	
	public String login(){
		

		//student_type:学生  teacher_type:老师  operator_type:运营人员
		if("student_type".equals(accountType)){
			
		}else if("teacher_type".equals(accountType)){
			
		}else if("operator_type".equals(accountType)){
		}
		return "";
	}

}
