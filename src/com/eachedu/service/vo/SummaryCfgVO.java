package com.eachedu.service.vo;

import com.eachedu.dao.pojo.SummaryCfg;

public class SummaryCfgVO extends SummaryCfg {
	//根据各个动态的配置最终生成的概述字符串
	private String finalSummaryStr;

	public String getFinalSummaryStr() {
		return finalSummaryStr;
	}

	public void setFinalSummaryStr(String finalSummaryStr) {
		this.finalSummaryStr = finalSummaryStr;
	}
	
}
