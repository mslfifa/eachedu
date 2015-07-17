package com.eachedu.web.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dao.pojo.ChartCfg;
import com.eachedu.dao.pojo.DataSourceCfg;
import com.eachedu.dao.pojo.DimensionIndexInfo;
import com.eachedu.dao.pojo.LayoutTemplateCfg;
import com.eachedu.dao.pojo.ReportInfo;
import com.eachedu.dao.pojo.SummaryCfg;
import com.eachedu.service.DataSourceCfgService;
import com.eachedu.service.DimensionIndexInfoService;
import com.eachedu.service.LayoutTemplateCfgService;
import com.eachedu.service.ReportService;
import com.eachedu.service.SummaryCfgService;
import com.eachedu.service.vo.ReportInfoVO;
import com.eachedu.web.vo.OptionVO;

@Controller("layoutAction")
@Scope("prototype")
public class LayoutTemplateCfgAction extends BaseAction {
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private LayoutTemplateCfgService service;
	
	@Autowired
	private DataSourceCfgService dataSourceCfgService;
	
	@Autowired
	private DimensionIndexInfoService dimensionIndexInfoService;
	
	@Autowired
	private SummaryCfgService summaryCfgService;
	
	private LayoutTemplateCfg layout;
	
	private Integer chartRenderSeq;

	public LayoutTemplateCfg getLayout() {
		return layout;
	}


	public void setLayout(LayoutTemplateCfg layout) {
		this.layout = layout;
	}

	public Integer getChartRenderSeq() {
		return chartRenderSeq;
	}


	public void setChartRenderSeq(Integer chartRenderSeq) {
		this.chartRenderSeq = chartRenderSeq;
	}


	public void deleteLayout() throws IOException{
		Long riId = service.findReportIdFromLtcId(layout.getLtcId());
		service.delCasecast(layout.getLtcId());
		ServletActionContext.getResponse().sendRedirect("report!reportCfgPage.action?&report.riId="+riId);
	}
	
	/**
	 * 切换布局中不同位置的图表信息
	 */
	public String switchChartFromLayout(){
		Object[] objArr = service.findCascadeByLtcId(layout.getLtcId(), chartRenderSeq);
		
		ReportInfo report = (ReportInfo) objArr[0];
		setAttribute("report", report);
		LayoutTemplateCfg layout1 = (LayoutTemplateCfg)objArr[1];
		setAttribute("layout", layout1);
		ChartCfg chart = (ChartCfg)objArr[2];
		setAttribute("chart", chart);
		SummaryCfg summary = (SummaryCfg)objArr[3];
		setAttribute("summary", summary);
		
		List<DataSourceCfg> dataSourceCfgs = dataSourceCfgService.findAll();
		setAttribute("dataSourceCfgs", dataSourceCfgs);
		
		
		List dimensions=dimensionIndexInfoService.findDiiSiblingsByDiiId(chart.getDimensionId(),"dimensioned");
		setAttribute("dimensions", dimensions);
		Long dscId = ((DimensionIndexInfo)dimensions.get(0)).getDscId();
		setAttribute("dscId", dscId);
		List indexs = dimensionIndexInfoService.findDiiSiblingsByDiiId(chart.getDimensionId(),"indexed");
		setAttribute("indexs", indexs);
				
		ReportInfoVO reportVO = reportService.findReportVoByRiId(report.getRiId());
		setAttribute("reportVO", reportVO);
		
		List<OptionVO> chartRenderSeqs = new ArrayList<OptionVO>();
		if ("center".equals(layout.getLayoutRenderType())) {
			chartRenderSeqs.add(new OptionVO(0,"居中"));
		}else if("left_right".equals(layout.getLayoutRenderType())){
			chartRenderSeqs.add(new OptionVO(11,"左边"));
			chartRenderSeqs.add(new OptionVO(12,"右边"));
		}else if ("up_down".equals(layout.getLayoutRenderType())) {
			chartRenderSeqs.add(new OptionVO(21,"上边"));
			chartRenderSeqs.add(new OptionVO(22,"下边"));
		}
		setAttribute("chartRenderSeqs", chartRenderSeqs);
		
		return "report_reconfig";
	}
	
}
