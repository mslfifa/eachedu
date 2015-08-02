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
import com.eachedu.service.OrderInfoService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.UserVO;

@Controller("orderInfoAppAction")
@Scope("prototype")
public class OrderInfoAppAction extends BaseAction{
	
	private static final Logger log = LoggerFactory.getLogger(OrderInfoAppAction.class);
	
	@Resource(name="orderInfoService")
	private OrderInfoService orderInfoService;
	
	private Long ciId;
	public Long getCiId() {
		return ciId;
	}
	public void setCiId(Long ciId) {
		this.ciId = ciId;
	}

	public void buyCourseware(){
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			UserVO userVO = (UserVO) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
			
			Map<String,Object> data = orderInfoService.saveBuy(ciId, userVO.getAccountType(), userVO.getId());
			result.put("data", data);
			result.put("http_status", true);
			result.put("http_msg", "购买成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "购买失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
		
		
	}
	
}
