package com.eachedu.dao;

import com.eachedu.dao.pojo.ChartCfg;

public interface ChartCfgDao extends BaseDao {

	Long saveChartCfg(ChartCfg bean);
	
	void delChartCfgByLtcId(Long ltcId);

	Object[] findCascadeByCcId(Long ccId);

	Long findReportIdFromCcId(Long ccId);

	int delByLtcId(Long ltcId);
}
