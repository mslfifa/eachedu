package com.eachedu.web;

import org.apache.struts2.ServletActionContext;
import org.drools.process.command.GetSessionClockCommand;

import com.eachedu.utils.ConstUtils;
import com.eachedu.web.vo.LoginInfoVO;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 259487334501050582L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		LoginInfoVO currentUser = (LoginInfoVO)ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
		if(currentUser == null){
			ServletActionContext.getRequest().getSession().setAttribute(ConstUtils.ERROR_MSG, "��ȡ�������ĵ�¼��Ϣ�������µ�¼��лл��");
			return "needLogin";
		}
		
		return invocation.invoke();
	}

}
