package com.eachedu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.eachedu.SystemContext;
import com.eachedu.dao.ReportDao;
import com.eachedu.web.vo.PagerVO;

@Repository("reportDao")
public class ReportDaoImpl extends BaseDaoImpl implements ReportDao{

	@Override
	public List findReportCascadeById(Long riId) {
		StringBuffer sql = new StringBuffer(500);
		List para = new ArrayList();
		
		sql .append(" SELECT  r.report_name                                                                                 ")
			.append(" 	,l.ltc_id,l.layout_title,l.layout_render_type,l.layout_render_sort,l.layout_height,l.layout_width   ")
			.append(" 	,c.cc_id,c.chart_dom_id,c.chart_title,c.chart_type,c.chart_render_seq                               ")
			.append(" 	,c.chart_height,c.chart_width,c.aggregation_op_type                                                 ")
			.append(" 	,d_d.field_db_name AS dimension_db_name,d_d.field_bus_name AS dimension_bus_name                    ")
			.append(" 	,d_i.field_db_name AS index_db_name,d_i.field_bus_name AS index_bus_name                            ")
			.append(" 	,d_s.field_db_name AS series_db_name,d_s.field_bus_name AS series_bus_name                          ")
			.append(" 	,ds.table_db_name,ds.table_bus_name                                                                 ")
			.append(" 	,s.sc_id,s.summary_template_desc,s.summary_type,s.top_val                                           ")
			.append(" 	,s.is_numericed,s.is_percented,s.top_val,s.placeholder                                              ")
			.append(" FROM report_info r                                                                                    ")
			.append("      JOIN layout_template_cfg l ON r.ri_id=l.ri_id                                                    ")
			.append("      LEFT JOIN chart_cfg c ON l.ltc_id=c.ltc_id                                                       ")
			.append("      LEFT JOIN dimension_index_info d_d ON d_d.dii_id=c.dimension_id AND d_d.field_type='dimensioned' ")
			.append("      LEFT JOIN dimension_index_info d_i ON d_i.dii_id=c.index_id AND d_i.field_type='indexed'         ")
			.append("      LEFT JOIN data_source_cfg ds ON ds.dsc_id=d_d.dsc_id AND ds.dsc_id=d_i.dsc_id                    ")
			.append("      LEFT JOIN dimension_index_info d_s ON d_s.dii_id=c.series_id AND d_s.field_type='dimensioned'    ")
			.append("      LEFT JOIN summary_cfg s ON s.cc_id=c.cc_id                                                       ")
			.append(" WHERE r.ri_id=?                                                                                       ")
			.append(" ORDER BY l.layout_render_sort ASC ,c.chart_render_seq ASC                                             ");
		
		para.add(riId);
		return this.findBySQL(sql.toString(), para.toArray(new Object[0]));
	}

	@Override
	public PagerVO findReportPageByUserId(String userid) {
		String queryHql = "from ReportInfo where userid=? order by createTime desc ";
		Object[] params = new Object[]{userid};
		return findPaginated(queryHql, params, SystemContext.getOffset(), SystemContext.getPagesize());
	}


}
