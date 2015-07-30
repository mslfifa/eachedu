package com.eachedu.dao.pojo;

import java.math.BigDecimal;

public class CoursewareInfo {
	private Long ciId;
	private Long gciId;
	private String courseTitle;
	private String introduce;
	//课件文件ID
	private Integer fileId;
	//缩略图ID
	private Integer legendId;
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
	
	public Integer getLegendId() {
		return legendId;
	}
	public void setLegendId(Integer legendId) {
		this.legendId = legendId;
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
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}	
	
}
