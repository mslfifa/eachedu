package com.eachedu.dao.pojo;

import java.util.Date;

public class ResourceInfo {
	private Long riId;
	private String resourceRealName;
	// 资料类型 head_short_type:头像 certificate_type:证书 question_pic_type问题图片  answer_pic_type:答案图片
	private String resourceType;
	// 资料原始名字
	private String resouceOriginName;
	private Integer resourceSize;
	private String relativePath;
	private Date createTime;
	private Long creatorId;
	//远程资源URL 比如存放第三方登录返回的头像URL
	private String remoteUrl;
	//缩略图ID
	private Integer legendId;

	public Long getRiId() {
		return riId;
	}

	public void setRiId(Long riId) {
		this.riId = riId;
	}

	public String getResourceRealName() {
		return resourceRealName;
	}

	public void setResourceRealName(String resourceRealName) {
		this.resourceRealName = resourceRealName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResouceOriginName() {
		return resouceOriginName;
	}

	public void setResouceOriginName(String resouceOriginName) {
		this.resouceOriginName = resouceOriginName;
	}

	public Integer getResourceSize() {
		return resourceSize;
	}

	public void setResourceSize(Integer resourceSize) {
		this.resourceSize = resourceSize;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
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

	public String getRemoteUrl() {
		return remoteUrl;
	}

	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}

	public Integer getLegendId() {
		return legendId;
	}

	public void setLegendId(Integer legendId) {
		this.legendId = legendId;
	}
	
}
