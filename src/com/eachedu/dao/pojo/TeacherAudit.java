package com.eachedu.dao.pojo;

import java.util.Date;

public class TeacherAudit {
	  private Long taId;
	  private Boolean passed;
	  private String rejectReason;
	  private Date auditTime;
	  private Long auditorId;
	public Long getTaId() {
		return taId;
	}
	public void setTaId(Long taId) {
		this.taId = taId;
	}
	public Boolean getPassed() {
		return passed;
	}
	public void setPassed(Boolean passed) {
		this.passed = passed;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public Long getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(Long auditorId) {
		this.auditorId = auditorId;
	}
	  
	  
}
