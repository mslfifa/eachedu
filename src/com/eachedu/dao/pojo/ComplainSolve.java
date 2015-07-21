package com.eachedu.dao.pojo;

import java.util.Date;

public class ComplainSolve {
	  private Long csId;
	  private Long orderId;
	  private String complainType;
	  private String complainContext;
	  private String complanStatus;
	  private Date complanTime;
	  private Date solveTime;
	  private String solveContent;
	  private Integer score;
	  private String  evaluationContent;
	public Long getCsId() {
		return csId;
	}
	public void setCsId(Long csId) {
		this.csId = csId;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	public String getComplanStatus() {
		return complanStatus;
	}
	public void setComplanStatus(String complanStatus) {
		this.complanStatus = complanStatus;
	}
	public Date getComplanTime() {
		return complanTime;
	}
	public void setComplanTime(Date complanTime) {
		this.complanTime = complanTime;
	}
	public Date getSolveTime() {
		return solveTime;
	}
	public void setSolveTime(Date solveTime) {
		this.solveTime = solveTime;
	}
	public String getSolveContent() {
		return solveContent;
	}
	public void setSolveContent(String solveContent) {
		this.solveContent = solveContent;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getEvaluationContent() {
		return evaluationContent;
	}
	public void setEvaluationContent(String evaluationContent) {
		this.evaluationContent = evaluationContent;
	}
	  
	  
}
