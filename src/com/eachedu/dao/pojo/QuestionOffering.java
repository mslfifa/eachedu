package com.eachedu.dao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class QuestionOffering {
	  private Long orderId;
	  //业务流水号
	  private String orderNo;
	  //年级课程外键
	  private Long gciId;
	  //学生外键
	  private Long siId;
	  private String questionDesc;
	  private String picPath;
	  //悬赏金
	  private BigDecimal offerPrise;
	  //提问时间
	  private Date askTime;
	  private String status;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public BigDecimal getOfferPrise() {
		return offerPrise;
	}
	public void setOfferPrise(BigDecimal offerPrise) {
		this.offerPrise = offerPrise;
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
	  
	  
}
