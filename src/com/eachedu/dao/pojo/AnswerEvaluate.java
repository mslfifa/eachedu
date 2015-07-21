package com.eachedu.dao.pojo;

public class AnswerEvaluate {
	private Long aeId;
	private Long orderId;
	//打分
	private Integer score;
	//评语
	private String remark;
	public Long getAeId() {
		return aeId;
	}
	public void setAeId(Long aeId) {
		this.aeId = aeId;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	
}
