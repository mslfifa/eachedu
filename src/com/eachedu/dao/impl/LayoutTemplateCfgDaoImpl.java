package com.eachedu.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.LayoutTemplateCfgDao;
import com.eachedu.dao.pojo.ChartCfg;
import com.eachedu.dao.pojo.LayoutTemplateCfg;
import com.eachedu.dao.pojo.ReportInfo;
import com.eachedu.dao.pojo.SummaryCfg;

@Repository("layoutTemplateCfgDao")
public class LayoutTemplateCfgDaoImpl extends BaseDaoImpl implements
		LayoutTemplateCfgDao {

	@Override
	public Long saveLayoutTemplateCfg(LayoutTemplateCfg bean) {
		save(bean);
		return bean.getLtcId();
	}

	@Override
	public Object[] findCascadeByLtcId(Long ltcId,Integer chartRenderSeq) {
		Object[] objArr = new Object[4];
		StringBuffer sql = new StringBuffer(400);
		sql .append(" SELECT r.ri_id,r.report_name,r.report_version                          ")
			.append("   ,l.ltc_id,l.layout_title,l.layout_height,l.layout_width              ")
			.append("   ,l.layout_render_sort,l.layout_render_type,l.create_time             ")
			.append("   ,c.cc_id,c.index_id,c.chart_dom_id,c.dimension_id                    ")
			.append("   ,c.aggregation_op_type,c.series_id,c.chart_type                      ")
			.append("   ,c.chart_height,c.chart_width,c.chart_render_seq,c.chart_title       ")
			.append("   ,s.sc_id,s.summary_template_desc,s.summary_type,s.is_numericed       ")
			.append("   ,s.is_percented,s.top_val,s.placeholder                              ")
			.append(" FROM report_info r                                                     ")
			.append("   JOIN layout_template_cfg l ON r.ri_id=l.ri_id                        ")
			.append("   LEFT JOIN chart_cfg c ON l.ltc_id=c.ltc_id AND c.chart_render_seq=?  ")
			.append("   LEFT JOIN summary_cfg s ON c.cc_id=s.cc_id                           ")
			.append(" WHERE l.ltc_id=?                                                       ")
			.append(" ORDER BY l.layout_render_sort asc , c.chart_render_seq asc             ");
		
		List list = (List)findBySQL(sql.toString(),chartRenderSeq,ltcId);
		
		if(list!=null && !list.isEmpty()){
			Map<String,Object> rowMap = (Map<String,Object>) list.get(0);
			ReportInfo report = new ReportInfo();
			report.setRiId(((BigInteger) rowMap.get("ri_id")).longValue());
			report.setReportName((String) rowMap.get("report_name"));
			report.setReportVersion((String) rowMap.get("report_version"));
			objArr[0] = report;
			
			LayoutTemplateCfg layout = new LayoutTemplateCfg();
			layout.setLtcId(((BigInteger) rowMap.get("ltc_id")).longValue());
			layout.setRiId(((BigInteger) rowMap.get("ri_id")).longValue());
			layout.setLayoutTitle((String) rowMap.get("layout_title"));
			layout.setLayoutRenderType((String) rowMap.get("layout_render_type"));
			layout.setLayoutRenderSort((Integer)rowMap.get("layout_render_sort"));
			layout.setLayoutHeight((Integer) rowMap.get("layout_height"));
			layout.setLayoutWidth((Integer) rowMap.get("layout_width"));
			layout.setCreateTime((Date) rowMap.get("create_time"));
			objArr[1] = layout;
			
			ChartCfg chart = new ChartCfg();
			if(rowMap.get("cc_id")!=null){
				chart.setCcId(((BigInteger) rowMap.get("cc_id")).longValue());
				chart.setLtcId(((BigInteger) rowMap.get("ltc_id")).longValue());
				chart.setChartDomId((String) rowMap.get("chart_dom_id"));
				chart.setChartTitle((String) rowMap.get("chart_title"));
				chart.setChartRenderSeq((Integer) rowMap.get("chart_render_seq"));
				chart.setAggregationOpType((String) rowMap.get("aggregation_op_type"));
				chart.setChartType((String) rowMap.get("chart_type"));
				chart.setDimensionId(((BigInteger) rowMap.get("dimension_id")).longValue());
				chart.setIndexId(((BigInteger) rowMap.get("index_id")).longValue());
				if(rowMap.get("series_id")!=null){
					chart.setSeriesId(((BigInteger) rowMap.get("series_id")).longValue());
				}
				chart.setChartWidth((Integer) rowMap.get("chart_width"));
				chart.setChartHeight((Integer) rowMap.get("chart_height"));
			}else{
				chart.setLtcId(layout.getLtcId());
			}
			objArr[2] = chart;
					
			SummaryCfg summary = new SummaryCfg();
			if(rowMap.get("sc_id")!=null){
				summary.setScId(((BigInteger) rowMap.get("sc_id")).longValue());
				summary.setCcId(((BigInteger) rowMap.get("cc_id")).longValue());
				summary.setSummaryTemplateDesc((String) rowMap.get("summary_template_desc"));
				summary.setSummaryType((String) rowMap.get("summary_type"));
				summary.setTopVal((Integer) rowMap.get("top_val"));
				summary.setNumericed((Boolean) rowMap.get("is_numericed"));
				summary.setPercented((Boolean) rowMap.get("is_percented"));
				summary.setPlaceholder((String) rowMap.get("placeholder"));
			}
			objArr[3] = summary;
		}
		return objArr;
	}

	@Override
	public Long findReportIdFromLtcId(Long ltcId) {
		Long riId = null;
		String sql = "select r.ri_id from report_info r , layout_template_cfg l where r.ri_id=l.ri_id and l.ltc_id = ? ";
		List list = findBySQL(sql, ltcId);
		if(list!=null && !list.isEmpty()){
			Map<String,Object> map = (Map<String,Object>) list.get(0);
			riId = ((BigInteger)map.get("ri_id")).longValue();
		}
		return riId;
	}

	@Override
	public void delCasecast(Long riId) {
		String sql = "delete from layout_template_cfg where exists(select 1 from report_info r where r.ri_id=layout_template_cfg.ri_id and r.ri_id = ? )";
		executeSql(sql, riId);
	}

	@Override
	public List findCascadeByLtcIdChartRenderSeq(Long ltcId,
			Integer chartRenderSeq) {
		StringBuffer sql = new StringBuffer(400);
		List para = new ArrayList();
		sql .append(" SELECT  l.ltc_id,c.cc_id,c.chart_dom_id,c.chart_title,c.chart_type,c.chart_render_seq                         ")
			.append(" 	,c.chart_height,c.chart_width,c.aggregation_op_type                                                         ")
			.append(" 	,d_d.dii_id AS dimension_id,d_d.field_db_name AS dimension_db_name,d_d.field_bus_name AS dimension_bus_name ")
			.append(" 	,d_i.dii_id AS index_id,d_i.field_db_name AS index_db_name,d_i.field_bus_name AS index_bus_name             ")
			.append(" 	,d_s.dii_id AS serie_id,d_s.field_db_name AS series_db_name,d_s.field_bus_name AS series_bus_name           ")
			.append(" 	,ds.dsc_id,ds.table_db_name,ds.table_bus_name                                                               ")
			.append(" 	,s.sc_id,s.summary_template_desc,s.summary_type,s.top_val                                                   ")
			.append(" 	,s.is_numericed,s.is_percented,s.top_val,s.placeholder                                                      ")
			.append(" FROM report_info r                                                                                            ")
			.append("      JOIN layout_template_cfg l ON r.ri_id=l.ri_id                                                            ")
			.append("      LEFT JOIN chart_cfg c ON l.ltc_id=c.ltc_id                                                               ")
			.append("      LEFT JOIN dimension_index_info d_d ON d_d.dii_id=c.dimension_id AND d_d.field_type='dimensioned'         ")
			.append("      LEFT JOIN dimension_index_info d_i ON d_i.dii_id=c.index_id AND d_i.field_type='indexed'                 ")
			.append("      LEFT JOIN data_source_cfg ds ON ds.dsc_id=d_d.dsc_id AND ds.dsc_id=d_i.dsc_id                            ")
			.append("      LEFT JOIN dimension_index_info d_s ON d_s.dii_id=c.series_id AND d_s.field_type='dimensioned'            ")
			.append("      LEFT JOIN summary_cfg s ON s.cc_id=c.cc_id                                                               ")
			.append(" WHERE  1=1                                                                                                    ");
		if(ltcId!=null){
			sql.append(" AND l.ltc_id=? ");
			para.add(ltcId);
		}
		if(chartRenderSeq!=null){
			para.add(chartRenderSeq);
		}
		
		return findBySQL(sql.toString(), para.toArray(new Object[0]));
	}

}
