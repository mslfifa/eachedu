package com.eachedu.dao.pojo;

import java.util.Date;

public class GradeCourseInfo {
	private Long gci_id;
	// junior_1:初一;junior_2:初二;junior_3:初三; senior_1:高一;senior_2:高二;senior_3:高三;
	private String grade;
	// chinese:语文 math:数学 english:英语 politics:政治 physics:物理 chymist:化学
	// biology:生物 geography:地理 history:历史
	private String course;
	private Date createTime;
	private Long createId;

	public Long getGci_id() {
		return gci_id;
	}

	public void setGci_id(Long gci_id) {
		this.gci_id = gci_id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

}
