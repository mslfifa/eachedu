package com.eachedu.dao.pojo;

public class AccountManagerLog {
	private Long amlId;
	private Long accountId;
	private Long accountName;
	private Long accountType;
	private Long processResult;
	private Long opRemark;
	private Long createTime;
	private Long creatorId;

	public Long getAmlId() {
		return amlId;
	}

	public void setAmlId(Long amlId) {
		this.amlId = amlId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountName() {
		return accountName;
	}

	public void setAccountName(Long accountName) {
		this.accountName = accountName;
	}

	public Long getAccountType() {
		return accountType;
	}

	public void setAccountType(Long accountType) {
		this.accountType = accountType;
	}

	public Long getProcessResult() {
		return processResult;
	}

	public void setProcessResult(Long processResult) {
		this.processResult = processResult;
	}

	public Long getOpRemark() {
		return opRemark;
	}

	public void setOpRemark(Long opRemark) {
		this.opRemark = opRemark;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

}
