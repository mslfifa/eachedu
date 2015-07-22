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
 * app��¼��֤������
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
		
		//����Ự��û���û����󣬾����أ����ص��÷�һ��json�ṹ {status:xxx,msg:yyy}
		if(currentUser == null){
			Map<String,Object> result = new HashMap<String,Object>();
			result.put("status", false);
			result.put("msg", "APPû�е�¼");
			HttpServletResponse resposne = ServletActionContext.getResponse();
			resposne.setCharacterEncoding("text/json;charset=utf-8");
			//����json��ʽ
			resposne.setContentType("application/json");
			//��Ӧjson��
			ServletActionContext.getResponse().getWriter().println(JSONMapper.toJSON(result).render(false));
		}
		return null;
	}

}
