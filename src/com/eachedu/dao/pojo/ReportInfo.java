package com.eachedu.dao.pojo;

import java.util.Date;

public class ReportInfo {
	private Long riId;
	private String userid;
	private String reportName;
	private String reportVersion;
	private String reportDataPeriod;
	private Date createTime;
	public Long getRiId() {
		return riId;
	}
	public void setRiId(Long riId) {
		this.riId = riId;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportVersion() {
		return reportVersion;
	}
	public void setReportVersion(String reportVersion) {
		this.reportVersion = reportVersion;
	}
	public String getReportDataPeriod() {
		return reportDataPeriod;
	}
	public void setReportDataPeriod(String reportDataPeriod) {
		this.reportDataPeriod = reportDataPeriod;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
