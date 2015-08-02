package com.eachedu.app.actions;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.service.ComplainSolveService;
import com.eachedu.web.actions.BaseAction;

@Controller("complainSolveAppAction")
@Scope("prototype")
public class ComplainSolveAppAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(ComplainSolveAppAction.class);
	
	@Resource(name="complainSolveService")
	private ComplainSolveService complainSolveService;
	
	
	private String orderNo;
	private Integer score;
	private String remark;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 学生投诉老师回答 
	 */
	public void complain(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			
			Long csId = complainSolveService.saveComplain(orderNo,score,remark);
			
			result.put("csId", csId);
			result.put("http_status", true);
			result.put("http_msg", "提问成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "提问失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
}
