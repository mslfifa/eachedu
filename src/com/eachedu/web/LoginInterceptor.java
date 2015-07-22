package com.eachedu.web;

import org.apache.struts2.ServletActionContext;

import com.eachedu.utils.ConstUtils;
import com.eachedu.web.vo.UserVO;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * webҳ���¼��Ϣ������
 * @author Administrator
 *
 */
public class LoginInterceptor extends AbstractInterceptor {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7944533607899180050L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		UserVO currentUser = (UserVO)ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
		if(currentUser == null){
			ServletActionContext.getRequest().getSession().setAttribute(ConstUtils.ERROR_MSG, "�����µ�¼ϵͳ");
			return "needLogin";
		}
		
		return invocation.invoke();
	}

}
