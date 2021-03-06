package com.eachedu.dao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class QuestionInfo {
	private Long qiId;
	// 业务流水号
	// 年级课程外键
	private Long gciId;
	// 学生外键
	private Long siId;
	private String communicateWay;
	private String questionDesc;
	private Long picId;
	//提问手机
	private String mobile;
	// 价格
	private BigDecimal prise;
	// 追加赏金
	private BigDecimal bonus;
	// 提问时间
	private Date askTime;
	private String status;
	private String remark;
	
	

	public Long getQiId() {
		return qiId;
	}

	public void setQiId(Long qiId) {
		this.qiId = qiId;
	}

	public Long getGciId() {
		return gciId;
	}

	public void setGciId(Long gciId) {
		this.gciId = gciId;
	}

	public Long getSiId() {
		return siId;
	}

	public void setSiId(Long siId) {
		this.siId = siId;
	}

	public String getCommunicateWay() {
		return communicateWay;
	}

	public void setCommunicateWay(String communicateWay) {
		this.communicateWay = communicateWay;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	
	public Long getPicId() {
		return picId;
	}

	public void setPicId(Long picId) {
		this.picId = picId;
	}

	public BigDecimal getPrise() {
		return prise;
	}

	public void setPrise(BigDecimal prise) {
		this.prise = prise;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public Date getAskTime() {
		return askTime;
	}

	public void setAskTime(Date askTime) {
		this.askTime = askTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
