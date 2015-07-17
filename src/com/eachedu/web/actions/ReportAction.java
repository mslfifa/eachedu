package com.eachedu.web.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import com.eachedu.service.LayoutTemplateCfgService;
import com.eachedu.service.ReportService;
import com.eachedu.service.SummaryCfgService;
import com.eachedu.service.vo.LayoutTemplateCfgVO;
import com.eachedu.service.vo.ReportInfoVO;
import com.eachedu.web.vo.OptionVO;
import com.eachedu.web.vo.PagerVO;

@Controller("reportAction")
@Scope("prototype")
public class ReportAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(ReportAction.class);
	
	private ReportInfo report;
	private LayoutTemplateCfg layout;
	private ChartCfg chart;
	private SummaryCfg summary;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private DataSourceCfgService dataSourceCfgService;
	
	@Autowired
	private LayoutTemplateCfgService layoutTemplateCfgService;
	@Autowired
	private ChartCfgService chartCfgService;
	@Autowired
	private SummaryCfgService summaryCfgService;
	@Autowired
	private DimensionIndexInfoService dimensionIndexInfoService;
	
	
	public ReportInfo getReport() {
		return report;
	}

	public void setReport(ReportInfo report) {
		this.report = report;
	}

	public LayoutTemplateCfg getLayout() {
		return layout;
	}

	public void setLayout(LayoutTemplateCfg layout) {
		this.layout = layout;
	}

	public ChartCfg getChart() {
		return chart;
	}

	public void setChart(ChartCfg chart) {
		this.chart = chart;
	}

	public SummaryCfg getSummary() {
		return summary;
	}

	public void setSummary(SummaryCfg summary) {
		this.summary = summary;
	}


	/**
	 * 转到配置报告内容页面
	 * @return
	 */
	public String reportCfgPage(){
		setAttribute("modifyPage", true);
		String busType = "cfgBus";
		return buildReportPage(busType);
	}

	
	
	
	public String reportOutput(){
		setAttribute("modifyPage", false);
		String busType = "ouputBus";
		return buildReportPage(busType);
	}
	
	private String buildReportPage(String busType) {
		report = (ReportInfo) reportService.getReport(report.getRiId());
		setAttribute("report", report);
		
		if(layout==null){
			layout = new LayoutTemplateCfg();
		}
		layout.setRiId(report.getRiId());
		setAttribute("layout", layout);
		
		List<DataSourceCfg> dataSourceCfgs = dataSourceCfgService.findAll();
		setAttribute("dataSourceCfgs", dataSourceCfgs);
		
		ReportInfoVO reportVO = reportService.findReportVoByRiId(report.getRiId());
		setAttribute("reportVO", reportVO);
		if("cfgBus".equals(busType)){
			return "report_cfg_page";
		}else{
			return "report_output_page";
		}
	}
	
	public void submitReportCfg(){
		log.debug(">>>>>> 配置提交开始 >>>>>>>>>>>>");
		try {
		
			layout.setCreateTime(new Date());
			Long ltcId=layoutTemplateCfgService.saveLayoutTemplateCfg(layout);
			log.debug("##### save layoutTemplateCfg success. ltcId:"+ltcId);
			
			
			
			//与布局外键联系
			chart.setLtcId(ltcId);
			chart.setChartDomId("chart_"+new Date().getTime());
			Long ccId = chartCfgService.saveChartCfg(chart);
			log.debug("##### save chartCfg success. ccId:"+ccId);
			
			//与图表配置外键联系上
			summary.setCcId(ccId);
			Long scId = summaryCfgService.saveSummaryCfg(summary);
			log.debug("##### save summaryCfg success. scId:"+scId);
			
			log.debug(">>>>>> 配置提交结束 >>>>>>>>>>>>");
			
			getResponse().sendRedirect("report!reportCfgPage.action?report.riId="+report.getRiId());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().setContentType("text/html; charset=UTF-8");
			String scriptStr = "<script type='text/javascript'>";
			scriptStr+=" if(confirm('操作出错！是否重新回退上一页面?')){history.back();}; ";
			scriptStr+="</script>";
			try {
				ServletActionContext.getResponse().getWriter().println(scriptStr);
				ServletActionContext.getResponse().getWriter().flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public String exportPage(){
		return "report_export_page";
	}
	
	/**
	 * 转发到分页页面
	 * @return
	 */
	public String listReportPage(){
		PagerVO page = reportService.findReportPageByUserId(currentUser().getUserid());
		ServletActionContext.getRequest().setAttribute("pv", page);
		ServletActionContext.getRequest().setAttribute("user", currentUser());
		return "report_list_page";
	}
	
	/**
	 * 转发到新增修改页面
	 * @return
	 */
	public String modifyReportPage(){
		if(report.getRiId()!=null){
			report = reportService.getReport(report.getRiId());
		}
		setAttribute("report", report);
		return "modify_report_page";
	}
	
	/**
	 * 新增修改操作
	 */
	public void persist(){
		boolean flag = true;
		String opStr = "";
		try {
			
			if(report.getRiId()==null){
				report.setUserid(currentUser().getUserid());
				report.setCreateTime(new Date());
				reportService.saveReport(report);
				
			}else{
				reportService.updateReport(report);
			}
			opStr="操作成功!";
		} catch (Exception e) {
			flag=false;
			opStr="操作失败!原因["+e.getMessage()+"]";
			e.printStackTrace();
		}finally{
			try {
				ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
				ServletActionContext.getResponse().setContentType("text/html; charset=UTF-8");
				String scriptStr = "<script type='text/javascript'>";
				if(flag==true){
					scriptStr += "window.opener.reloadReport();";
				}
				
				scriptStr += "alert('"+opStr+"');window.close();</script>";
				ServletActionContext.getResponse().getWriter().println(scriptStr);
				ServletActionContext.getResponse().getWriter().flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
	
	
	/**
	 * 从layout/chart转入修改页面
	 * @return
	 * @throws Exception
	 */
	public String reportReCfgPage() throws Exception{
		setAttribute("modifyPage", true);
		Object[] objArr = null;
		if (chart.getCcId()!=null) {
			objArr = chartCfgService.findCascadeByCcId(chart.getCcId());
		}else if(layout.getLtcId()!=null && chart.getChartRenderSeq()!=null){
			objArr = layoutTemplateCfgService.findCascadeByLtcId(layout.getLtcId(), chart.getChartRenderSeq());
		}else{
			throw new Exception("修改请求参数不对，请联系管理员");
		}
		
		ReportInfo report1 = (ReportInfo) objArr[0];
		setAttribute("report", report1);
		LayoutTemplateCfg layout1 = (LayoutTemplateCfg)objArr[1];
		setAttribute("layout", layout1);
		ChartCfg chart1 = (ChartCfg)objArr[2];
		//当从布局转入时，可能指定位置没有图表，则使用请求参数
		if(chart1.getChartRenderSeq()==null){
			chart1.setChartRenderSeq(chart.getChartRenderSeq());
		}
		setAttribute("chart", chart1);
		SummaryCfg summary1 = (SummaryCfg)objArr[3];
		setAttribute("summary", summary1);
		
		List<DataSourceCfg> dataSourceCfgs = dataSourceCfgService.findAll();
		setAttribute("dataSourceCfgs", dataSourceCfgs);
		
		List dimensions=null;
		if(chart1.getDimensionId()!=null){
			dimensions = dimensionIndexInfoService.findDiiSiblingsByDiiId(chart1.getDimensionId(),"dimensioned");
		}else{
			dimensions = new ArrayList();
		}
		
		setAttribute("dimensions", dimensions);
		
		Long dscId = null;
		if(!dimensions.isEmpty()){
			dscId = ((DimensionIndexInfo)dimensions.get(0)).getDscId();
		}
		setAttribute("dscId", dscId);
		
		
		List indexs = null;
		if(chart1.getIndexId()!=null){
			indexs = dimensionIndexInfoService.findDiiSiblingsByDiiId(chart1.getIndexId(),"indexed");
		}
		setAttribute("indexs", indexs);
				
		ReportInfoVO reportVO = reportService.findReportVoByRiId(report1.getRiId());
		setAttribute("reportVO", reportVO);
		
		List<OptionVO> chartRenderSeqs = new ArrayList<OptionVO>();
		if ("center".equals(layout1.getLayoutRenderType())) {
			chartRenderSeqs.add(new OptionVO(0,"居中"));
		}else if("left_right".equals(layout1.getLayoutRenderType())){
			chartRenderSeqs.add(new OptionVO(11,"左边"));
			chartRenderSeqs.add(new OptionVO(12,"右边"));
		}else if ("up_down".equals(layout1.getLayoutRenderType())) {
			chartRenderSeqs.add(new OptionVO(21,"上边"));
			chartRenderSeqs.add(new OptionVO(22,"下边"));
		}
		setAttribute("chartRenderSeqs", chartRenderSeqs);
		
		return "report_reconfig";
	}
	
	
	public void reportReconfigSubmit() throws Exception{
		
		reportService.updateCascase(layout,chart,summary);
		log.debug("#### update success");
		
		ServletActionContext.getResponse().sendRedirect("report!reportCfgPage.action?&report.riId="+report.getRiId());
	}
}
