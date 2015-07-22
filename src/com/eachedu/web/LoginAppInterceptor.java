package com.eachedu.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.eachedu.utils.ConstUtils;
import com.eachedu.web.vo.UserVO;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sdicons.json.mapper.JSONMapper;

/**
 * app登录认证拦截器
 * @author Administrator
 *
 */
public class LoginAppInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2942321433917771892L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		UserVO currentUser = (UserVO)ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
		
		//如果会话内没有用户对象，就拦截，返回调用方一个json结构 {status:xxx,msg:yyy}
		if(currentUser == null){
			Map<String,Object> result = new HashMap<String,Object>();
			result.put("status", false);
			result.put("msg", "APP没有登录");
			HttpServletResponse resposne = ServletActionContext.getResponse();
			resposne.setCharacterEncoding("text/json;charset=utf-8");
			//设置json格式
			resposne.setContentType("application/json");
			//响应json流
			ServletActionContext.getResponse().getWriter().println(JSONMapper.toJSON(result).render(false));
		}
		return null;
	}

}
