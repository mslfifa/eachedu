package com.eachedu.dao.pojo;

import java.util.Date;

public class MessageNotice {
	private Long mnId;
	private Long accountId;
	private String accountType;
	private String privilegeId;
	// system_message:系统消息 answering: 抢答题信息 complaining:投诉中 complained:投诉成立
	private String messageType;
	private String messageText;
	private Date sendTime;
	// unread:未读 readed:已读
	private String status;
	private Long busId;
	//指定业务ID要关联哪类具体业务。 answer_bus:抢答业务  complain_bus:投诉业务
	private String busType;
	public Long getMnId() {
		return mnId;
	}
	public void setMnId(Long mnId) {
		this.mnId = mnId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getBusId() {
		return busId;
	}
	public void setBusId(Long busId) {
		this.busId = busId;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
}
