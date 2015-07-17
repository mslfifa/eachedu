package com.eachedu.dao;

import java.util.List;

import com.eachedu.dao.pojo.LayoutTemplateCfg;

public interface LayoutTemplateCfgDao extends BaseDao {

	Long saveLayoutTemplateCfg(LayoutTemplateCfg bean);
	
	/**
	 * 根据布局ID及渲染次序,级联查找相关对象
	 * @param ltcId 布局ID
	 * @param chartRenderSeq 渲染
	 * @return
	 */
	Object[] findCascadeByLtcId(Long ltcId, Integer chartRenderSeq);

	Long findReportIdFromLtcId(Long ltcId);
	
	void delCasecast(Long riId);

	/**
	 * 修改布局中一个指定位置，加载该位置原来的配置信息对象组（可能为空）
	 * @param ltcId 布局ID
	 * @param chartRenderSeq 图表渲染位置序号
	 * @return
	 */
	@Deprecated
	List findCascadeByLtcIdChartRenderSeq(Long ltcId, Integer chartRenderSeq);
}
