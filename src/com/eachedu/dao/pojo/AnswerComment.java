package com.eachedu.dao.pojo;

import java.util.Date;

public class AnswerComment {
	private Long acId;
	private Long orderId;
	//打分
	private Integer score;
	//评语
	private String remark;
	
	private Date commentTime;
	
	public Long getAcId() {
		return acId;
	}
	public void setAcId(Long acId) {
		this.acId = acId;
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
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	
	
}
