package com.eachedu.web.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dao.pojo.MasaUserV;
import com.eachedu.service.MasaUserVService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.vo.LoginInfoVO;

@Controller("loginAction")
@Scope("prototype")
public class LogninAction extends BaseAction {
	@Autowired
	private MasaUserVService userService;
	
	private String userid;
	private String password;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login(){
		
		MasaUserV user = userService.findUser(userid, password);
		
		if(user!=null){
			
			LoginInfoVO userVO = new LoginInfoVO();
			userVO.setUserid(user.getUserid());
			userVO.setUsername(user.getUsername());
			userVO.setLoginTime(new Date());
			userVO.setIp(getRemortIP(ServletActionContext.getRequest()));
			setSession(ConstUtils.USER_LOGIN, userVO);
			return "success";
		}else{
			return "fail";
		}
		
	}
	
	private String getRemortIP(HttpServletRequest request) {
	       if (request.getHeader("x-forwarded-for") == null) {
	           return request.getRemoteAddr();
	       }
	       return request.getHeader("x-forwarded-for");
	}
}
