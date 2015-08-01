package com.eachedu.dao.pojo;

import java.util.Date;

public class ComplainSolve {
	private Long csId;
	private Long qiId;
	private String complainType;
	private String complainContext;
	private String complanStatus;
	private Date complanTime;
	private Date solveTime;
	private String solve_result;

	public Long getCsId() {
		return csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Long getQiId() {
		return qiId;
	}

	public void setQiId(Long qiId) {
		this.qiId = qiId;
	}

	public String getSolve_result() {
		return solve_result;
	}

	public void setSolve_result(String solve_result) {
		this.solve_result = solve_result;
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

}
