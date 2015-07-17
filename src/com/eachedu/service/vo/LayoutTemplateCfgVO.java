package com.eachedu.service.vo;

import java.util.List;

import com.eachedu.dao.pojo.LayoutTemplateCfg;

public class LayoutTemplateCfgVO extends LayoutTemplateCfg {

	private List<ChartCfgVO> chartCfgVOs;

	public List<ChartCfgVO> getChartCfgVOs() {
		return chartCfgVOs;
	}

	public void setChartCfgVOs(List<ChartCfgVO> chartCfgVOs) {
		this.chartCfgVOs = chartCfgVOs;
	}

	
	
}
