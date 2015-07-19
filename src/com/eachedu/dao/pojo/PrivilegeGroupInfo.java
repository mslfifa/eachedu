package com.eachedu.dao.pojo;

import java.util.Date;

public class PrivilegeGroupInfo {
	private Long pgiId;
	private String groupName;
	private Date createTime;
	private Long creatorId;
	public Long getPgiId() {
		return pgiId;
	}
	public void setPgiId(Long pgiId) {
		this.pgiId = pgiId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
}
