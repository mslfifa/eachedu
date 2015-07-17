package com.eachedu.web.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dao.pojo.ChartCfg;
import com.eachedu.dao.pojo.DataSourceCfg;
import com.eachedu.dao.pojo.DimensionIndexInfo;
import com.eachedu.dao.pojo.LayoutTemplateCfg;
import com.eachedu.dao.pojo.ReportInfo;
import com.eachedu.dao.pojo.SummaryCfg;
import com.eachedu.service.ChartCfgService;
import com.eachedu.service.DataSourceCfgService;
import com.eachedu.service.DimensionIndexInfoService;
import com.eachedu.service.ReportService;
import com.eachedu.service.vo.ReportInfoVO;
import com.eachedu.web.vo.OptionVO;

@Controller("chartCfgAction")
@Scope("prototype")
public class ChartCfgAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(ChartCfgAction.class);
	
	@Autowired
	private ChartCfgService chartService;
	
	private ChartCfg chart;
	
	public ChartCfg getChart() {
		return chart;
	}

	public void setChart(ChartCfg chart) {
		this.chart = chart;
	}

	public void deleteChart() throws IOException{
		Object[] objArr = chartService.findCascadeByCcId(chart.getCcId());
		log.debug("#### findCascadeByCcId return object [0]:"+objArr[0]+"|1:"+objArr[1]+"|2:"+objArr[2]);
		ReportInfo report = (ReportInfo) objArr[0];
		chartService.delCasecast(chart.getCcId());
		log.debug("$$$$ del chart success!");
		
		String url = "report!reportCfgPage.action?report.riId="+report.getRiId();
		ServletActionContext.getResponse().sendRedirect(url);
		
	}
	
	
	
}
