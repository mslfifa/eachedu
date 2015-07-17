package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.SummaryCfgDao;
import com.eachedu.dao.pojo.SummaryCfg;

@Repository("summaryCfgDao")
public class SummaryCfgDaoImpl extends BaseDaoImpl implements SummaryCfgDao {

	@Override
	public Long saveSummaryCfg(SummaryCfg bean) {
		save(bean);
		return bean.getScId();
	}

	@Override
	public void delByLtcId(Long ltcId) {
		String sql = "delete from summary_cfg where exists (select 1 from layout_template_cfg l, chart_cfg c  where l.ltc_id=c.ltc_id and summary_cfg.cc_id=c.cc_id and l.ltc_id = ?) ";
		executeSql(sql, ltcId);
	}

	@Override
	public void delByCcId(Long ccId) {
		String sql = "delete from summary_cfg where exists (select 1 from chart_cfg c where c.cc_id=summary_cfg.cc_id and c.cc_id = ?) ";
		executeSql(sql, ccId);
	}

}
