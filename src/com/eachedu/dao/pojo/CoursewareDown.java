package com.eachedu.dao.pojo;

import java.util.Date;

public class CoursewareDown {
	 private Long cdId;
	 //student_type:学生  teacher_type:老师
	 private String accountType;
	 private Long accountId;
	 private Long ciId;
	 private Date downTime;
	public Long getCdId() {
		return cdId;
	}
	public void setCdId(Long cdId) {
		this.cdId = cdId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getCiId() {
		return ciId;
	}
	public void setCiId(Long ciId) {
		this.ciId = ciId;
	}
	public Date getDownTime() {
		return downTime;
	}
	public void setDownTime(Date downTime) {
		this.downTime = downTime;
	}
	 
}
