package com.eachedu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eachedu.dao.ChartCfgDao;
import com.eachedu.dao.LayoutTemplateCfgDao;
import com.eachedu.dao.SummaryCfgDao;
import com.eachedu.dao.pojo.LayoutTemplateCfg;
import com.eachedu.service.LayoutTemplateCfgService;

@Service("layoutTemplateCfgService")
public class LayoutTemplateCfgServiceImpl implements LayoutTemplateCfgService {
	private static final Logger log = LoggerFactory.getLogger(LayoutTemplateCfgServiceImpl.class);
	
	@Autowired
	private LayoutTemplateCfgDao layoutDao;
	
	@Autowired
	private ChartCfgDao chartDao;
	
	@Autowired
	private SummaryCfgDao summaryDao;
	
	@Override
	public Long saveLayoutTemplateCfg(LayoutTemplateCfg bean) {
		// TODO Auto-generated method stub
		return layoutDao.saveLayoutTemplateCfg(bean);
	}

	@Override
	public void delLaout(Long ltcId) {
		layoutDao.findById(LayoutTemplateCfg.class, ltcId);
	}

	@Override
	public LayoutTemplateCfg findLayoutById(Long ltcId) {
		return layoutDao.findById(LayoutTemplateCfg.class, ltcId);
	}

	@Override
	public Object[] findCascadeByLtcId(Long ltcId, Integer chartRenderSeq) {
		return layoutDao.findCascadeByLtcId(ltcId,chartRenderSeq);
	}

	@Override
	public void update(LayoutTemplateCfg layout) {
		layoutDao.update(layout);
		
	}

	@Override
	public Long findReportIdFromLtcId(Long ltcId) {
		return layoutDao.findReportIdFromLtcId(ltcId);
	}

	@Override
	public void delCasecast(Long ltcId) {
		summaryDao.delByLtcId(ltcId);
		chartDao.delByLtcId(ltcId);
		layoutDao.del(layoutDao.findById(LayoutTemplateCfg.class, ltcId));
		
	}

	@Override
	public List findCascadeByLtcIdChartRenderSeq(Long ltcId,
			Integer chartRenderSeq) {
		return layoutDao.findCascadeByLtcIdChartRenderSeq(ltcId,chartRenderSeq);
	}

}
