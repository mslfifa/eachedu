package com.eachedu.app.actions;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.dao.pojo.TeacherInfo;
import com.eachedu.dict.AccountType;
import com.eachedu.service.StudentInfoService;
import com.eachedu.service.TeacherInfoService;
import com.eachedu.web.actions.BaseAction;
@Controller("loginApp")
@Scope("prototype")
public class LoginAppAction extends BaseAction {
	
	Logger log = LoggerFactory.getLogger(LoginAppAction.class);
	
	private String mobile;
	private String password;
	private String accountType;
	
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
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	@Resource
	private StudentInfoService studentInfoService;
	@Resource
	private TeacherInfoService teacherInfoService;
	
	public void loginByPhone(){
		log.debug("@@@ mobile:"+mobile+"|password:"+password);
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if (AccountType.student_type.name().equals(accountType)) {
				StudentInfo s = studentInfoService.findByMobile(mobile, password);
				result.put("status", true);
				result.put("msg", "查询成功");
				result.put("id", s.getSiId());
				result.put("accountType", "student");
				result.put("nickname", s.getNickname());
				result.put("headShortId", s.getHeadShortId());
				result.put("mobile", s.getMobile());
				result.put("email", s.getEmail());
				result.put("sex", s.getSex());
				result.put("account", s.getAccount());
			}else if (AccountType.teacher_type.name().equals(accountType)) {
				TeacherInfo t = teacherInfoService.findByMobile(mobile, password);
				result.put("status", true);
				result.put("msg", "查询成功");
				result.put("id", t.getTiId());
				result.put("accountType", "student");
				result.put("nickname", t.getNickname());
				result.put("headShortId", t.getHeadShortId());
				result.put("mobile", t.getMobile());
				result.put("email", t.getEmail());
				result.put("sex", t.getSex());
				result.put("account", t.getAccount());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put("status", false);
			result.put("msg", "查询失败，错误["+e.getMessage()+"]");
		}
		
	}
}
