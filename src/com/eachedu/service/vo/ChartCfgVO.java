package com.eachedu.service.vo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.eachedu.dao.pojo.ChartCfg;

public class ChartCfgVO extends ChartCfg {
	private String dimensionDbName;
	private String dimensionBusName;
	private String indexDbName;
	private String indexBusName;
	private String seriesDbName;
	private String seriesBusName;
	private String tableDbName;
	private String tableBusName;
	private String sql;
	//各序列名称
	private List<String> legendData;
	//坐标category名
	private List<String> axisData;
	private List<Map<String,Object>> groupData;
	//多序列时 一个序列对应一组数据
	private LinkedHashMap<String,List<BigDecimal>> allSeriesData;
	//一序列的数据
	private List<BigDecimal> serisData;
	
	//多个序列的数据组
	private LinkedHashMap<String, List<BigDecimal>> multiSeriesData;
	
	//多系列概述渲染时使用。
	private LinkedHashMap<String, BigDecimal>multiBusNameData;
	
	private List<SummaryCfgVO> summaryCfgVOs;
	
	public String getDimensionDbName() {
		return dimensionDbName;
	}
	public void setDimensionDbName(String dimensionDbName) {
		this.dimensionDbName = dimensionDbName;
	}
	public String getDimensionBusName() {
		return dimensionBusName;
	}
	public void setDimensionBusName(String dimensionBusName) {
		this.dimensionBusName = dimensionBusName;
	}
	public String getIndexDbName() {
		return indexDbName;
	}
	public void setIndexDbName(String indexDbName) {
		this.indexDbName = indexDbName;
	}
	public String getIndexBusName() {
		return indexBusName;
	}
	public void setIndexBusName(String indexBusName) {
		this.indexBusName = indexBusName;
	}
	public String getSeriesDbName() {
		return seriesDbName;
	}
	public void setSeriesDbName(String seriesDbName) {
		this.seriesDbName = seriesDbName;
	}
	public String getSeriesBusName() {
		return seriesBusName;
	}
	public void setSeriesBusName(String seriesBusName) {
		this.seriesBusName = seriesBusName;
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
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public List<String> getLegendData() {
		return legendData;
	}
	public void setLegendData(List<String> legendData) {
		this.legendData = legendData;
	}
	public List<String> getAxisData() {
		return axisData;
	}
	public void setAxisData(List<String> axisData) {
		this.axisData = axisData;
	}
	
	public List<Map<String, Object>> getGroupData() {
		return groupData;
	}
	public void setGroupData(List<Map<String, Object>> groupData) {
		this.groupData = groupData;
	}
	public List<BigDecimal> getSerisData() {
		return serisData;
	}
	public void setSerisData(List<BigDecimal> serisData) {
		this.serisData = serisData;
	}
	public LinkedHashMap<String, List<BigDecimal>> getAllSeriesData() {
		return allSeriesData;
	}
	public void setAllSeriesData(
			LinkedHashMap<String, List<BigDecimal>> allSeriesData) {
		this.allSeriesData = allSeriesData;
	}
	public List<SummaryCfgVO> getSummaryCfgVOs() {
		return summaryCfgVOs;
	}
	public void setSummaryCfgVOs(List<SummaryCfgVO> summaryCfgVOs) {
		this.summaryCfgVOs = summaryCfgVOs;
	}
	public LinkedHashMap<String, List<BigDecimal>> getMultiSeriesData() {
		return multiSeriesData;
	}
	public void setMultiSeriesData(
			LinkedHashMap<String, List<BigDecimal>> multiSeriesData) {
		this.multiSeriesData = multiSeriesData;
	}
	public LinkedHashMap<String, BigDecimal> getMultiBusNameData() {
		return multiBusNameData;
	}
	public void setMultiBusNameData(
			LinkedHashMap<String, BigDecimal> multiBusNameData) {
		this.multiBusNameData = multiBusNameData;
	}
	
}
