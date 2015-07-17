package com.eachedu.dao.pojo;

public class ChartCfg {
	private Long ccId;
	private Long ltcId;
	//指标外键
	private Long indexId;
	//渲染dom的ID
	private String chartDomId;
	//指标的聚合运算
	private String aggregationOpType;
	//维度外键
	private Long dimensionId;
	//序列外键
	private Long seriesId;
	private String chartType;
	private Integer chartRenderSeq;
	private Integer chartHeight;
	private Integer chartWidth;
	private String chartTitle;
	public Long getCcId() {
		return ccId;
	}
	public void setCcId(Long ccId) {
		this.ccId = ccId;
	}
	public Long getLtcId() {
		return ltcId;
	}
	public void setLtcId(Long ltcId) {
		this.ltcId = ltcId;
	}
	
	public Long getIndexId() {
		return indexId;
	}
	public void setIndexId(Long indexId) {
		this.indexId = indexId;
	}
	
	public String getChartDomId() {
		return chartDomId;
	}
	public void setChartDomId(String chartDomId) {
		this.chartDomId = chartDomId;
	}
	public String getAggregationOpType() {
		return aggregationOpType;
	}
	public void setAggregationOpType(String aggregationOpType) {
		this.aggregationOpType = aggregationOpType;
	}
	public Long getDimensionId() {
		return dimensionId;
	}
	public void setDimensionId(Long dimensionId) {
		this.dimensionId = dimensionId;
	}
	
	public Long getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(Long seriesId) {
		this.seriesId = seriesId;
	}
	public String getChartType() {
		return chartType;
	}
	public void setChartType(String chartType) {
		this.chartType = chartType;
	}
	
	public Integer getChartRenderSeq() {
		return chartRenderSeq;
	}
	public void setChartRenderSeq(Integer chartRenderSeq) {
		this.chartRenderSeq = chartRenderSeq;
	}
	public Integer getChartHeight() {
		return chartHeight;
	}
	public void setChartHeight(Integer chartHeight) {
		this.chartHeight = chartHeight;
	}
	public Integer getChartWidth() {
		return chartWidth;
	}
	public void setChartWidth(Integer chartWidth) {
		this.chartWidth = chartWidth;
	}
	public String getChartTitle() {
		return chartTitle;
	}
	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}
	
}
