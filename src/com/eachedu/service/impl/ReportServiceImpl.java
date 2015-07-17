package com.eachedu.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eachedu.dao.ChartCfgDao;
import com.eachedu.dao.LayoutTemplateCfgDao;
import com.eachedu.dao.ReportDao;
import com.eachedu.dao.SummaryCfgDao;
import com.eachedu.dao.pojo.ChartCfg;
import com.eachedu.dao.pojo.LayoutTemplateCfg;
import com.eachedu.dao.pojo.ReportInfo;
import com.eachedu.dao.pojo.SummaryCfg;
import com.eachedu.service.ReportService;
import com.eachedu.service.vo.ChartCfgVO;
import com.eachedu.service.vo.LayoutTemplateCfgVO;
import com.eachedu.service.vo.ReportInfoVO;
import com.eachedu.service.vo.SummaryCfgVO;
import com.eachedu.web.vo.PagerVO;

@Service("reportService")
public class ReportServiceImpl implements ReportService{
	private static final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	@Autowired
	private ReportDao dao;
	
	@Autowired
	private LayoutTemplateCfgDao layoutDao;
	@Autowired
	private ChartCfgDao chartDao;
	@Autowired
	private SummaryCfgDao summaryDao;
	
	@Override
	public List findReportCascadeById(Long riId) {
		return dao.findReportCascadeById(riId);
	}

	@Override
	public ReportInfoVO findReportVoByRiId(Long riId) {
		ReportInfoVO bean = new ReportInfoVO();
		List list = dao.findReportCascadeById(riId);
		
		/*处理级联查询结果  begin =============*/
		if(list!=null && !list.isEmpty()){
			
			LinkedHashMap<Long,Object> layoutMap = new LinkedHashMap<Long,Object>();
			LinkedHashMap<Long,Object> chartMap = new LinkedHashMap<Long,Object>();
			LinkedHashMap<Long,Object> summaryMap = new LinkedHashMap<Long,Object>();
			
			/*循环将结果的集合到 layoutMap  chartMap begin --------------*/
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				
				Map<String,Object> rowMap = (Map<String,Object>) iterator.next();
				bean.setReportName((String)rowMap.get("report_name"));
				
				buildLayoutVOs(layoutMap, rowMap);
				
				
				/*设置图表信息，并拼接SQL，查询返回结果 begin ---------*/
				buildChartVOs(chartMap, rowMap);
				/*设置图表信息，并拼接SQL，查询返回结果 begin ---------*/
				
				/*设置概述 begin -------------*/
				buildSummaryVOs(chartMap, summaryMap, rowMap);
				/*设置概述 end -------------*/
				
			}
			/*循环将结果的集合到 layoutMap  chartMap end --------------*/
			
			
			for (Iterator cir = chartMap.values().iterator(); cir.hasNext();) {
				ChartCfgVO chart = (ChartCfgVO) cir.next();
				if(layoutMap.containsKey(chart.getLtcId())){
					LayoutTemplateCfgVO layout = (LayoutTemplateCfgVO)layoutMap.get(chart.getLtcId());
					layout.getChartCfgVOs().add(chart);
				}
				for (Iterator sir = summaryMap.values().iterator(); sir.hasNext();) {
					SummaryCfgVO summary = (SummaryCfgVO) sir.next();
					if(chart.getCcId().equals(summary.getCcId())){
						chart.getSummaryCfgVOs().add(summary);
					}
				}
			}
			
			List layouts = new ArrayList();
			layouts.addAll(layoutMap.values());
			bean.setLayoutTemplateCfgVOs(layouts);
			
		}
		/*处理级联查询结果  end =============*/
		
		return bean;
	}

	private void buildSummaryVOs(LinkedHashMap<Long, Object> chartMap,
			LinkedHashMap<Long, Object> summaryMap, Map<String, Object> rowMap) {
		//如果布局下面的图表全部被删除了,cc_id是空的
		if(rowMap.get("sc_id")==null){
			return;
		}
		
		Long scId = ((BigInteger)rowMap.get("sc_id")).longValue();
		if (!summaryMap.containsKey(scId)) {
			SummaryCfgVO summary = new SummaryCfgVO();
			summary.setScId(scId);
			summary.setCcId(((BigInteger)rowMap.get("cc_id")).longValue());
			summary.setSummaryTemplateDesc((String) rowMap.get("summary_template_desc"));
			summary.setSummaryType((String) rowMap.get("summary_type"));
			summary.setTopVal((Integer)rowMap.get("top_val"));
			summary.setNumericed((Boolean) rowMap.get("is_numericed"));
			summary.setPercented((Boolean) rowMap.get("is_percented"));
			summary.setPlaceholder((String)rowMap.get("placeholder"));
			
			ChartCfgVO chart = (ChartCfgVO) chartMap.get(summary.getCcId());
			summary.setFinalSummaryStr( buildSummary(chart,summary));
			
			summaryMap.put(scId, summary );
		}
	}

	/**
	 * 构造概述字符串
	 * @param chart
	 * @param summary
	 * @return
	 */
	private String buildSummary(ChartCfgVO chart, SummaryCfgVO summary) {
		BigDecimal totalVal = new BigDecimal(0);
		
		class ChartPoint implements Comparable<ChartPoint>{
			private String key;
			private String seriesName;
			private BigDecimal value;
			public String getKey() {
				return key;
			}
			public void setKey(String key) {
				this.key = key;
			}
			public BigDecimal getValue() {
				return value;
			}
			public void setValue(BigDecimal value) {
				this.value = value;
			}
			public String getSeriesName() {
				return seriesName;
			}
			public void setSeriesName(String seriesName) {
				this.seriesName = seriesName;
			}
			
			public ChartPoint(String key, String seriesName, BigDecimal value) {
				this.key = key;
				this.seriesName = seriesName;
				this.value = value;
			}
			@Override
			public int compareTo(ChartPoint o) {
				if(o==null){
					return 0;
				}
				return this.getValue().compareTo(o.getValue());
			}
			
			
		}
		List<ChartPoint> points = new ArrayList<ChartPoint>();
		
		
		Map<String,Object> seriesMap = new HashMap<String,Object>();
		
		if(StringUtils.isEmpty(chart.getSeriesDbName())){
			for (Iterator iterator = chart.getGroupData().iterator(); iterator.hasNext();) {
				Map<String, Object> m = (Map<String, Object>) iterator.next();
				BigDecimal val = (BigDecimal)m.get("value");
				String name = (String)m.get("name");
				
				String serieName= (String)m.get("serie_name");
				//累加总和
				totalVal = totalVal.add(val);
				
				if(StringUtils.isEmpty(chart.getSeriesDbName())){
					points.add(new ChartPoint(name,serieName,val));
				//按序列排序	
				}else{
					//如果没有这个序列名对应的结点，就新加结点
					if (!seriesMap.containsKey(serieName)) {
						ChartPoint np = new ChartPoint(name,serieName,val);
						seriesMap.put(serieName,np);
						points.add(np);
					}
					
					ChartPoint point = (ChartPoint) seriesMap.get(serieName);
					//同一序列，追加数值
					point.setValue(point.getValue().add(val));
					
					
				}
			}
		}else{
			for (Iterator mulKey = chart.getMultiBusNameData().keySet().iterator(); mulKey.hasNext();) {
				String mkBusName = (String) mulKey.next();
				BigDecimal mkval = chart.getMultiBusNameData().get(mkBusName);
				ChartPoint mkPoint = new ChartPoint(mkBusName,null,mkval);
				points.add(mkPoint);
				
				totalVal = totalVal.add(mkval);
			}
		}
		
		
		
		
		//排序
		Collections.sort(points, new Comparator<ChartPoint>() {

			@Override
			public int compare(ChartPoint o1, ChartPoint o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		
		
		String replaceStr = "";
		if("max_min".equals(summary.getSummaryType())){
			ChartPoint maxPoint = points.get(points.size()-1);
			ChartPoint minPoint = points.get(0);
			replaceStr += "最大是"+(StringUtils.isNotEmpty(maxPoint.getKey())?maxPoint.getKey():maxPoint.getSeriesName());
			if(summary.getNumericed()==true){
				replaceStr += "("+maxPoint.getValue();
				if(summary.getPercented()){
					replaceStr += " "+maxPoint.getValue().multiply(new BigDecimal(100)).divide(totalVal, 2, RoundingMode.HALF_UP)+"%";
				}
				replaceStr += ")";
			}
			
			
			replaceStr +=" 最小是"+(StringUtils.isNotEmpty(minPoint.getKey())?minPoint.getKey():minPoint.getSeriesName());
			if(summary.getNumericed()==true){
				replaceStr += "("+minPoint.getValue();
				if(summary.getPercented()){
					replaceStr += " "+minPoint.getValue().multiply(new BigDecimal(100)).divide(totalVal, 2, RoundingMode.HALF_UP)+"%";
				}
				replaceStr += ")";
			}
			
			
			log.debug("##### replaceStr:"+replaceStr);
			
			
			
		}else if("top_n".equals(summary.getSummaryType())){
			Integer topVal = summary.getTopVal();
			int fromIndex = points.size()<topVal?0:points.size()-topVal;
			int toIndex = points.size();
			List<ChartPoint> topPoints = points.subList(fromIndex, toIndex);
			for (int i = topPoints.size()-1; i >=0; i--) {
				ChartPoint curPoint = topPoints.get(i);
				replaceStr += curPoint.getKey();
				if(Boolean.TRUE.equals(summary.getNumericed())){
					replaceStr += "("+curPoint.getValue();
					if(Boolean.TRUE.equals(summary.getPercented())){
						replaceStr += " "+ (new BigDecimal(0).equals(totalVal)?"0%":(curPoint.getValue().multiply(new BigDecimal(100)).divide(totalVal, 2, RoundingMode.HALF_UP)+"%"));
					}
					replaceStr += ")"; 
				}
			}
		}else if("change_trend".equals(summary.getSummaryType())){
			for (Iterator iterator = points.iterator(); iterator.hasNext();) {
				ChartPoint chartPoint = (ChartPoint) iterator.next();
				int trendResult = chartPoint.getValue().compareTo(new BigDecimal(0));
				replaceStr+=" "+chartPoint.getKey()+(trendResult>0?":上升":(trendResult<0?":下降":":持平"));
			}
		}
		String resultStr = summary.getSummaryTemplateDesc().replaceFirst(summary.getPlaceholder(), replaceStr);
		log.debug("##### resultStr:"+resultStr);
		return resultStr;
	}

	private void buildLayoutVOs(LinkedHashMap<Long, Object> layoutMap,
			Map<String, Object> rowMap) {
		Long ltcId = ((BigInteger)rowMap.get("ltc_id")).longValue();
		
		if(!layoutMap.containsKey(ltcId)){
			LayoutTemplateCfgVO ltcVO = new LayoutTemplateCfgVO();
			ltcVO.setLtcId(ltcId);
			ltcVO.setLayoutTitle((String)rowMap.get("layout_title"));
			ltcVO.setLayoutRenderType((String)rowMap.get("layout_render_type"));
			ltcVO.setLayoutRenderSort((Integer)rowMap.get("layout_render_sort"));
			ltcVO.setLayoutWidth((Integer)rowMap.get("layout_width"));
			ltcVO.setLayoutHeight((Integer)rowMap.get("layout_height"));
			ltcVO.setChartCfgVOs(new ArrayList());
			layoutMap.put(ltcId, ltcVO);
		}
	}

	private void buildChartVOs(LinkedHashMap<Long, Object> chartMap,
			Map<String, Object> rowMap) {
		//如果布局下面删除全部的图表，渲染时，图表ID是空的
		if(rowMap.get("cc_id")==null){
			return;
		}
		
		Long ccId = ((BigInteger)rowMap.get("cc_id")).longValue();
		if (!chartMap.containsKey(ccId)) {
			ChartCfgVO ccVO = new ChartCfgVO();
			ccVO.setCcId(ccId);
			ccVO.setLtcId(((BigInteger)rowMap.get("ltc_id")).longValue());
			ccVO.setChartDomId((String)rowMap.get("chart_dom_id"));
			ccVO.setChartTitle((String)rowMap.get("chart_title"));
			ccVO.setChartType((String)rowMap.get("chart_type"));
			ccVO.setChartRenderSeq((Integer)rowMap.get("chart_render_seq"));
			ccVO.setAggregationOpType((String)rowMap.get("aggregation_op_type"));
			ccVO.setChartHeight((Integer)rowMap.get("chart_height"));
			ccVO.setChartWidth((Integer)rowMap.get("chart_width"));
			ccVO.setAggregationOpType((String)rowMap.get("aggregation_op_type"));
			
			ccVO.setDimensionDbName((String)rowMap.get("dimension_db_name"));
			ccVO.setDimensionBusName((String)rowMap.get("dimension_bus_name"));
			ccVO.setIndexDbName((String)rowMap.get("index_db_name"));
			ccVO.setIndexBusName((String)rowMap.get("index_bus_name"));
			
			ccVO.setSeriesDbName((String)rowMap.get("series_db_name"));
			ccVO.setSeriesBusName((String)rowMap.get("series_bus_name"));
			ccVO.setTableDbName((String)rowMap.get("table_db_name"));
			ccVO.setTableBusName((String)rowMap.get("table_bus_name"));
			
			//+(StringUtils.isNotEmpty(ccVO.getSeriesDbName())?"":" , "+ccVO.getSeriesDbName()
			String sql = "select "+ccVO.getAggregationOpType()+"("+ccVO.getIndexDbName()+") as aggreate_num , "+ccVO.getDimensionDbName()+" as bus_name "+(StringUtils.isEmpty(ccVO.getSeriesDbName())?"":" , "+ccVO.getSeriesDbName()+" as series_name ")+" from "+ccVO.getTableDbName()+" group by "+ccVO.getDimensionDbName()+(StringUtils.isEmpty(ccVO.getSeriesDbName())?"":" , "+ccVO.getSeriesDbName());
			log.debug("@@@@@ sql:"+sql);
			
			ccVO.setSql(sql);
			List<String> legendData = new ArrayList<String>();
			List<BigDecimal> serisData = new ArrayList<BigDecimal>();
			List<String> axisData=new ArrayList<String>();
			List<Map<String, Object>> groupData = new ArrayList<Map<String, Object>>();
			
			//分序列 保存分组数据 渲染图表使用该对象
			LinkedHashMap<String, List<BigDecimal>> multiSeriesData = new LinkedHashMap<String, List<BigDecimal>>();
			
			LinkedHashMap<String,BigDecimal> multiBusNameData = new LinkedHashMap<String,BigDecimal>();
			
			List chartList = dao.findBySQL(sql);
			
			if (chartList!=null && !chartList.isEmpty()) {
				
				for (Iterator chartIr = chartList.iterator(); chartIr.hasNext();) {
					Map<String,Object> rowChart = (Map<String,Object>) chartIr.next();
					
					String busName = (String)rowChart.get("bus_name");
					if(StringUtils.isEmpty(busName)){
						System.out.println("busName["+busName+"]不能为空!");
					}
					
					String seriesName = (String)rowChart.get("series_name");
					
					String aggreateNumStr = rowChart.get("aggreate_num")==null?"0":rowChart.get("aggreate_num")+"";
					if(!axisData.contains(busName)){
						axisData.add(busName);
					}
					
					BigDecimal aggreateNum = new BigDecimal(aggreateNumStr);
					
					
					serisData.add(aggreateNum);
					//无坐标轴 存放块信息
					Map<String,Object> groupMap = new HashMap<String,Object>();
					groupMap.put("name", busName);
					groupMap.put("value", aggreateNum);
					groupMap.put("serie_name", seriesName);
					groupData.add(groupMap);
					
					//多序列时，累加每个坐标轴多系列数值。概述渲染时使用
					if(!multiBusNameData.containsKey(busName)){
						multiBusNameData.put(busName,new BigDecimal(0));
					}
					BigDecimal tmpVal = multiBusNameData.get(busName).add(aggreateNum);
					multiBusNameData.put(busName, tmpVal);
					
					
					if(StringUtils.isEmpty(ccVO.getSeriesDbName())){
						String legenStr = "统计数据";
						if(!legendData.contains(legenStr)){
							legendData.add(legenStr);
						}
						
					}else{
						
						if(!legendData.contains(seriesName)){
							legendData.add(seriesName);
						}
						//按序列存放分组数据
						if (!multiSeriesData.containsKey(seriesName)) {
							multiSeriesData.put(seriesName, new ArrayList<BigDecimal>());
						}
						multiSeriesData.get(seriesName).add(aggreateNum);
					}
				}
			}
			
			ccVO.setLegendData(legendData);
			ccVO.setAxisData(axisData);
			ccVO.setSerisData(serisData);
			ccVO.setGroupData(groupData);
			ccVO.setMultiSeriesData(multiSeriesData);
			ccVO.setMultiBusNameData(multiBusNameData);
			
			List<SummaryCfgVO> summaryCfgVOs = new ArrayList<SummaryCfgVO>();
			ccVO.setSummaryCfgVOs(summaryCfgVOs );
			
			//新加入一个 ccId/chart 对
			chartMap.put(ccId, ccVO);
		}
	}
	
	

	@Override
	public void saveReport(ReportInfo bean) {
		dao.save(bean);
	}

	@Override
	public PagerVO findReportPageByUserId(String userid) {
		// TODO Auto-generated method stub
		return dao.findReportPageByUserId(userid);
	}

	@Override
	public ReportInfo getReport(Long riId) {
		// TODO Auto-generated method stub
		return (ReportInfo)dao.findById(ReportInfo.class, riId);
	}

	@Override
	public void updateReport(ReportInfo bean) {
		// TODO Auto-generated method stub
		dao.update(bean);
	}

	@Override
	public void updateCascase(LayoutTemplateCfg layout, ChartCfg chart,
			SummaryCfg summary) {
		layoutDao.update(layout);
		if(chart.getCcId()==null){
			chart.setLtcId(layout.getLtcId());
			chart.setChartDomId("chart_"+new Date().getTime());
			chartDao.save(chart);
		}else{
			chartDao.update(chart);
		}
		if(summary.getScId()==null){
			summary.setCcId(chart.getCcId());
			summaryDao.save(summary);
		}else{
			summaryDao.update(summary);
		}
		
	}

	
}
