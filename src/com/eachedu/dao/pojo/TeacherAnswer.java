package com.eachedu.dao.pojo;

import java.util.Date;

public class TeacherAnswer {
	private Long taId;
	private Long tiId;
	private Long qiId;
	//回答文字描述
	private String answerContent;
	//答案图片资源ID
	private Long picId;
	//状态 FINISHED : 完成回答  EXPIRED : 超时过期   说详见 TeacherAnswerStatus
	private String status;
	// GAIN_TYPE : 老师抢答   ASSIGN_TYPE : 学生指派
	private String connectType;
	//指派时间
	private Date assignTime;
	//抢答时间
	private Date answerTime;
	public Long getTaId() {
		return taId;
	}
	public void setTaId(Long taId) {
		this.taId = taId;
	}

	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	
	public Date getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getPicId() {
		return picId;
	}
	public void setPicId(Long picId) {
		this.picId = picId;
	}
	public String getConnectType() {
		return connectType;
	}
	public void setConnectType(String connectType) {
		this.connectType = connectType;
	}
	public Date getAssignTime() {
		return assignTime;
	}
	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}
	public Long getTiId() {
		return tiId;
	}
	public void setTiId(Long tiId) {
		this.tiId = tiId;
	}
	public Long getQiId() {
		return qiId;
	}
	public void setQiId(Long qiId) {
		this.qiId = qiId;
	}

	
	
}
