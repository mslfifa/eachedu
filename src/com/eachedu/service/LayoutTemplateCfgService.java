package com.eachedu.service;

import java.util.List;

import com.eachedu.dao.pojo.LayoutTemplateCfg;

public interface LayoutTemplateCfgService {
	Long saveLayoutTemplateCfg(LayoutTemplateCfg bean);
	
	void delLaout(Long ltcId);
	
	void delCasecast(Long ltcId);
	
	LayoutTemplateCfg findLayoutById(Long ltcId);
	
	/**
	 * 根据布局ID级联查询相关对象 (报告 布局 图表 概述 只取第一行)
	 * @param ltcId
	 * @param chartRenderSeq TODO
	 * @return
	 */
	Object[] findCascadeByLtcId(Long ltcId, Integer chartRenderSeq);
	
	/**
	 * 修改布局中一个指定位置，加载该位置原来的配置信息对象组（可能为空）
	 * @param ltcId
	 * @return
	 */
	@Deprecated
	List findCascadeByLtcIdChartRenderSeq(Long ltcId,Integer chartRenderSeq);

	void update(LayoutTemplateCfg layout);
	
	
	Long findReportIdFromLtcId(Long ltcId);

}
