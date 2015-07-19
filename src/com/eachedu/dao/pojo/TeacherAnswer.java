package com.eachedu.dao.pojo;

import java.util.Date;

public class TeacherAnswer {
	private Long taId;
	private Long taiId;
	private Long orderId;
	private String answerContent;
	private String picUrl;
	private Date answerTime;
	public Long getTaId() {
		return taId;
	}
	public void setTaId(Long taId) {
		this.taId = taId;
	}
	public Long getTaiId() {
		return taiId;
	}
	public void setTaiId(Long taiId) {
		this.taiId = taiId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Date getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}
	
	
	
}
