package com.eachedu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eachedu.dao.ChartCfgDao;
import com.eachedu.dao.SummaryCfgDao;
import com.eachedu.dao.pojo.ChartCfg;
import com.eachedu.service.ChartCfgService;

@Service("chartCfgService")
public class ChartCfgServiceImpl implements ChartCfgService {
	@Autowired
	private ChartCfgDao chartDao;
	@Autowired
	private SummaryCfgDao summaryDao;
	@Override
	public Long saveChartCfg(ChartCfg bean) {
		return chartDao.saveChartCfg(bean);
	}
	
	@Override
	public void delChart(Long ccId) {
		chartDao.del(chartDao.findById(ChartCfg.class, ccId));
	}

	@Override
	public Object[] findCascadeByCcId(Long ccId) {
		return chartDao.findCascadeByCcId(ccId);
	}

	@Override
	public void update(ChartCfg bean) {
		chartDao.update(bean);
	}

	@Override
	public Long findReportIdFromCcId(Long ccId) {
		// TODO Auto-generated method stub
		return chartDao.findReportIdFromCcId(ccId);
	}

	@Override
	public void delCasecast(Long ccId) {
		summaryDao.delByCcId(ccId);
		delChart(ccId);
	}

}
