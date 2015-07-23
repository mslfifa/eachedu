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
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			//锟斤拷锟斤拷json锟斤拷式
			response.setContentType("application/json;charset=itf-8");
			response.setHeader("Pragma", "no-cache"); 
			response.addHeader( "Cache-Control", "no-cache" );
			response.setDateHeader("Expires", 0);
			//锟斤拷应json锟斤拷
			ServletActionContext.getResponse().getWriter().println(JSONMapper.toJSON(result).render(false));
		}
		//璺宠浆涓嬩竴涓嫤鎴櫒
		return invocation.invoke();
	}

}
