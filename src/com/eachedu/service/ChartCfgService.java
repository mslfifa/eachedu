package com.eachedu.service;

import com.eachedu.dao.pojo.ChartCfg;

public interface ChartCfgService {
	Long saveChartCfg(ChartCfg bean);
	
	/**
	 * 根据图表ID级联查询相关对象 (报告 布局 图表 概述 只取第一行)
	 * @param ccId
	 * @return
	 */
	Object[] findCascadeByCcId(Long ccId);
	
	void delChart(Long ccId);
	
	void delCasecast(Long ccId);
	
	void update(ChartCfg bean);
	
	Long findReportIdFromCcId(Long ccId);
}
