package com.eachedu.dao.pojo;

import java.util.Date;

public class DataSourceCfg {
	private Long dscId;
	private String tableDbName;
	private String tableBusName;
	private String createId;
	private Date createTime;
	public Long getDscId() {
		return dscId;
	}
	public void setDscId(Long dscId) {
		this.dscId = dscId;
	}
	public String getTableDbName() {
		return tableDbName;
	}
	public void setTableDbName(String tableDbName) {
		this.tableDbName = tableDbName;
	}
	public String getTableBusName() {
		return tableBusName;
	}
	public void setTableBusName(String tableBusName) {
		this.tableBusName = tableBusName;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
