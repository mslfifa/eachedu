package com.eachedu.dao.pojo;

public class ViewMasaArea {
	private String areaId;
	private String areaName;
	private String areaDesc;
	private String parentAreaId;
	private String areaPath;
	private String areaPathCode;
	private String sortOrder;
	private String flagGroup;
	private Boolean regulared;
	private Boolean superusered;
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaDesc() {
		return areaDesc;
	}
	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}
	public String getParentAreaId() {
		return parentAreaId;
	}
	public void setParentAreaId(String parentAreaId) {
		this.parentAreaId = parentAreaId;
	}
	public String getAreaPath() {
		return areaPath;
	}
	public void setAreaPath(String areaPath) {
		this.areaPath = areaPath;
	}
	public String getAreaPathCode() {
		return areaPathCode;
	}
	public void setAreaPathCode(String areaPathCode) {
		this.areaPathCode = areaPathCode;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getFlagGroup() {
		return flagGroup;
	}
	public void setFlagGroup(String flagGroup) {
		this.flagGroup = flagGroup;
	}
	public Boolean getRegulared() {
		return regulared;
	}
	public void setRegulared(Boolean regulared) {
		this.regulared = regulared;
	}
	public Boolean getSuperusered() {
		return superusered;
	}
	public void setSuperusered(Boolean superusered) {
		this.superusered = superusered;
	}
	
}
