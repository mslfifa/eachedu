package com.eachedu.dao.pojo;

public class SummaryCfg {
	private Long scId;
	private Long ccId;
	private String summaryTemplateDesc;
	//max_min:描述最大与最小 top_n:描述排名靠前TOP3 change_trend:描述变化趋势
	private String summaryType;
	private Boolean numericed;
	private Boolean percented;
	//对应于 summary_type:top_n  指明n的值是多少
	private Integer topVal;
	//在summaryTemplateDesc中的占位符
	private String placeholder;
	public Long getScId() {
		return scId;
	}
	public void setScId(Long scId) {
		this.scId = scId;
	}
	public Long getCcId() {
		return ccId;
	}
	public void setCcId(Long ccId) {
		this.ccId = ccId;
	}
	public String getSummaryTemplateDesc() {
		return summaryTemplateDesc;
	}
	public void setSummaryTemplateDesc(String summaryTemplateDesc) {
		this.summaryTemplateDesc = summaryTemplateDesc;
	}
	public String getSummaryType() {
		return summaryType;
	}
	public void setSummaryType(String summaryType) {
		this.summaryType = summaryType;
	}
	public Boolean getNumericed() {
		return numericed;
	}
	public void setNumericed(Boolean numericed) {
		this.numericed = numericed;
	}
	public Boolean getPercented() {
		return percented;
	}
	public void setPercented(Boolean percented) {
		this.percented = percented;
	}
	public Integer getTopVal() {
		return topVal;
	}
	public void setTopVal(Integer topVal) {
		this.topVal = topVal;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
}
