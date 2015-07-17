package com.eachedu.dao.pojo;

import java.util.Date;

/**
 * 记录基础数据的表
 * @author Administrator
 *
 */
public class DimensionIndexInfo {
	private Long diiId;
	private Long dscId;
	private String fieldDbName;
	private String fieldBusName;
	private String fieldType;   // dimensioned:维度  indexed:指标
	/*//是否是维度字段
	private Boolean dimensioned;
	//是否指标字段
	private Boolean indexed;*/
	private String createId;
	private Date createTime;
	public Long getDiiId() {
		return diiId;
	}
	public void setDiiId(Long diiId) {
		this.diiId = diiId;
	}
	public Long getDscId() {
		return dscId;
	}
	public void setDscId(Long dscId) {
		this.dscId = dscId;
	}
	public String getFieldDbName() {
		return fieldDbName;
	}
	public void setFieldDbName(String fieldDbName) {
		this.fieldDbName = fieldDbName;
	}
	public String getFieldBusName() {
		return fieldBusName;
	}
	public void setFieldBusName(String fieldBusName) {
		this.fieldBusName = fieldBusName;
	}
	
	/*public Boolean getDimensioned() {
		return dimensioned;
	}
	public void setDimensioned(Boolean dimensioned) {
		this.dimensioned = dimensioned;
	}
	public Boolean getIndexed() {
		return indexed;
	}
	public void setIndexed(Boolean indexed) {
		this.indexed = indexed;
	}*/
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
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	
}
