package com.eachedu.dao.pojo;

import java.math.BigDecimal;

public class CoursewareInfo {
	private Long ciId;
	private Long gciId;
	private String courseTitle;
	private String introduce;
	private String picPath;
	private BigDecimal prise;
	//USING:启用  FREEZE:停用 CANCEL:撤销
	private String status;
	public Long getCiId() {
		return ciId;
	}
	public void setCiId(Long ciId) {
		this.ciId = ciId;
	}
	public Long getGciId() {
		return gciId;
	}
	public void setGciId(Long gciId) {
		this.gciId = gciId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public BigDecimal getPrise() {
		return prise;
	}
	public void setPrise(BigDecimal prise) {
		this.prise = prise;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
	
}
