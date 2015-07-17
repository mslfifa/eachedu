package com.eachedu.dao.pojo;

import java.util.Date;

public class LayoutTemplateCfg {
	private Long ltcId;
	private Long riId;
	private String layoutTitle;
	private Integer layoutRenderSort;
	private String layoutRenderType;
	private Integer layoutHeight;
	private Integer layoutWidth;
	private Date createTime;
	public Long getLtcId() {
		return ltcId;
	}
	public void setLtcId(Long ltcId) {
		this.ltcId = ltcId;
	}
	
	public Long getRiId() {
		return riId;
	}
	public void setRiId(Long riId) {
		this.riId = riId;
	}
	public String getLayoutTitle() {
		return layoutTitle;
	}
	public void setLayoutTitle(String layoutTitle) {
		this.layoutTitle = layoutTitle;
	}
	
	public Integer getLayoutRenderSort() {
		return layoutRenderSort;
	}
	public void setLayoutRenderSort(Integer layoutRenderSort) {
		this.layoutRenderSort = layoutRenderSort;
	}
	public String getLayoutRenderType() {
		return layoutRenderType;
	}
	public void setLayoutRenderType(String layoutRenderType) {
		this.layoutRenderType = layoutRenderType;
	}
	public Integer getLayoutHeight() {
		return layoutHeight;
	}
	public void setLayoutHeight(Integer layoutHeight) {
		this.layoutHeight = layoutHeight;
	}
	public Integer getLayoutWidth() {
		return layoutWidth;
	}
	public void setLayoutWidth(Integer layoutWidth) {
		this.layoutWidth = layoutWidth;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
}
