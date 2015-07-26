package com.eachedu.app.actions;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.service.StudentInfoService;
import com.eachedu.utils.ConstUtils;
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

	public void resetPwd(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			String oldVerifyCode =  (String) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.LOGIN_VERIFY_CODE);
			if(StringUtils.isEmpty(oldVerifyCode)){
				throw new Exception("您还没有获取验证码");
			}
			if(StringUtils.isEmpty(verifyCode)){
				throw new Exception("您没有输入验证码");
			}
			if(!verifyCode.equals(oldVerifyCode)){
				throw new Exception("您输入验证码的不正确");
			}
			studentInfoService.updatePwd(mobile,password);
			
			result.put("http_status", true);
			result.put("http_msg", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			
			result.put("http_status", false);
			result.put("http_msg", "修改失败,原因["+e.getMessage()+"]");
			
		} 
		this.ajaxWriteOutJSON(result);
	}
}
