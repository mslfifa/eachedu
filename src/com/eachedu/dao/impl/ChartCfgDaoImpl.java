package com.eachedu.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.eachedu.dao.ChartCfgDao;
import com.eachedu.dao.pojo.ChartCfg;
import com.eachedu.dao.pojo.LayoutTemplateCfg;
import com.eachedu.dao.pojo.ReportInfo;
import com.eachedu.dao.pojo.SummaryCfg;

@Repository("chartCfgDao")
public class ChartCfgDaoImpl extends BaseDaoImpl implements ChartCfgDao {
	
	private static final Logger log = LoggerFactory.getLogger(ChartCfgDaoImpl.class);
	
	@Override
	public Long saveChartCfg(ChartCfg bean) {
		save(bean);
		return bean.getCcId();
	}

	@Override
	public void delChartCfgByLtcId(Long ltcId) {
		String hql = "from ChartCfg where ltcId = ? ";
		List list= findByHql(hql, ltcId);
		if(list!=null && !list.isEmpty()){
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				ChartCfg cc = (ChartCfg) iterator.next();
				del(cc);
				log.info("### remove chart id:"+cc.getCcId()+"|ChartTitle:"+cc.getChartTitle());
			}
		}
	}

	@Override
	public Object[] findCascadeByCcId(Long ccId) {
		Object[] objArr = new Object[4];
		StringBuffer sql = new StringBuffer(400);
		sql .append(" SELECT  r.`ri_id`,r.report_name,r.`report_version`             ")
			.append(" 	,l.ltc_id,l.layout_title,l.layout_render_type,l.create_time  ")
			.append(" 	,l.layout_render_sort,l.layout_height,l.layout_width         ")
			.append(" 	,c.cc_id,c.chart_dom_id,c.chart_title,c.chart_render_seq     ")
			.append(" 	,c.dimension_id,c.index_id,c.series_id,c.chart_type          ")
			.append(" 	,c.chart_height,c.chart_width,c.aggregation_op_type          ")
			.append(" 	,s.sc_id,s.summary_template_desc,s.summary_type,s.top_val    ")
			.append(" 	,s.is_numericed,s.is_percented,s.top_val,s.placeholder       ")
			.append(" FROM report_info r                                             ")
			.append("      JOIN layout_template_cfg l ON r.ri_id=l.ri_id             ")
			.append("      JOIN chart_cfg c ON l.ltc_id=c.ltc_id                     ")
			.append("      JOIN summary_cfg s ON s.cc_id=c.cc_id                     ")
			.append(" WHERE c.cc_id=?                                                ");
		List list = (List) findBySQL(sql.toString(), ccId);
		if(list!=null && !list.isEmpty()){
			Map<String,Object> rowMap = (Map<String,Object>) list.get(0);
			ReportInfo report = new ReportInfo();
			report.setRiId(((BigInteger)(rowMap.get("ri_id"))).longValue());
			report.setReportName((String) rowMap.get("report_name"));
			report.setReportVersion((String) rowMap.get("report_version"));
			objArr[0] = report;
			
			LayoutTemplateCfg layout = new LayoutTemplateCfg();
			objArr[1] = layout;
			layout.setLtcId(((BigInteger)rowMap.get("ltc_id")).longValue());
			layout.setRiId(report.getRiId());
			layout.setLayoutTitle((String) rowMap.get("layout_title"));
			layout.setLayoutRenderType((String) rowMap.get("layout_render_type"));
			layout.setLayoutRenderSort((Integer) rowMap.get("chart_render_seq"));
			layout.setLayoutHeight((Integer) rowMap.get("layout_height"));
			layout.setLayoutWidth((Integer) rowMap.get("layout_width"));
			layout.setCreateTime(new Date());
			
			ChartCfg chart = new ChartCfg();
			chart.setCcId(((BigInteger)rowMap.get("cc_id")).longValue());
			chart.setLtcId(layout.getLtcId());
			chart.setChartDomId((String) rowMap.get("chart_dom_id"));
			chart.setChartTitle((String) rowMap.get("chart_title"));
			chart.setChartRenderSeq((Integer) rowMap.get("chart_render_seq"));
			chart.setChartType((String) rowMap.get("chart_type"));
			chart.setDimensionId(((BigInteger) rowMap.get("dimension_id")).longValue());
			chart.setIndexId(((BigInteger) rowMap.get("index_id")).longValue());
			if(rowMap.get("series_id")!=null){
				chart.setSeriesId(((BigInteger) rowMap.get("series_id")).longValue());
			}
			chart.setAggregationOpType((String) rowMap.get("aggregation_op_type"));
			chart.setChartHeight((Integer) rowMap.get("chart_height"));
			chart.setChartWidth((Integer) rowMap.get("chart_width"));
			objArr[2] = chart;
			
			SummaryCfg summary = new SummaryCfg();
			summary.setScId(((BigInteger) rowMap.get("sc_id")).longValue());
			summary.setCcId(chart.getCcId());
			summary.setSummaryTemplateDesc((String) rowMap.get("summary_template_desc"));
			summary.setSummaryType((String) rowMap.get("summary_type"));
			summary.setPlaceholder((String) rowMap.get("placeholder"));
			summary.setNumericed((Boolean) rowMap.get("is_numericed"));
			summary.setPercented((Boolean) rowMap.get("is_percented"));
			summary.setTopVal((Integer) rowMap.get("top_val"));
			objArr[3] = summary;
			
		}
		return objArr;
	}

	@Override
	public Long findReportIdFromCcId(Long ccId) {
		Long riId = null;
		String hql = "select r.riId from ReportInfo r , LayoutTemplateCfg l , ChartCfg c where r.riId=l.riId and l.ltcId=c.ltcId and c.ccId = ? ";
		List list = findByHql(hql, ccId);
		if(list!=null && !list.isEmpty()){
			riId = (Long)list.get(0);
		}
		return riId;
	}

	@Override
	public int delByLtcId(Long ltcId) {
		String sql = " delete from chart_cfg where exists (select 1 from layout_template_cfg l where chart_cfg.ltc_id=l.ltc_id and l.ltc_id = ? ) ";
		return executeSql(sql, ltcId);
	}

}
