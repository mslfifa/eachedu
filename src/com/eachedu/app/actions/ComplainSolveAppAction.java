package com.eachedu.app.actions;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.service.ComplainSolveService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.UserVO;

@Controller("complainSolveAppAction")
@Scope("prototype")
public class ComplainSolveAppAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(ComplainSolveAppAction.class);
	
	@Resource(name="complainSolveService")
	private ComplainSolveService complainSolveService;
	
	
	private String orderNo;
	//投诉类型 
	private String complainType;
	private String complainContext;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getComplainType() {
		return complainType;
	}
	public void setComplainType(String complainType) {
		this.complainType = complainType;
	}
	public String getComplainContext() {
		return complainContext;
	}
	public void setComplainContext(String complainContext) {
		this.complainContext = complainContext;
	}



	/**
	 * 学生投诉老师回答 
	 */
	public void complain(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			UserVO currentUser = (UserVO)ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
			Long csId = complainSolveService.saveComplain(orderNo,complainType,complainContext, currentUser.getId());
			
			result.put("csId", csId);
			result.put("http_status", true);
			result.put("http_msg", "投诉成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "投诉失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
}
