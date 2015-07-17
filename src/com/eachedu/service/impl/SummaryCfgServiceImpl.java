package com.eachedu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eachedu.dao.SummaryCfgDao;
import com.eachedu.dao.pojo.SummaryCfg;
import com.eachedu.service.SummaryCfgService;

@Service("summaryCfgService")
public class SummaryCfgServiceImpl implements SummaryCfgService {
	@Autowired
	private SummaryCfgDao dao;
	@Override
	public Long saveSummaryCfg(SummaryCfg bean) {
		// TODO Auto-generated method stub
		return dao.saveSummaryCfg(bean);
	}
	@Override
	public void update(SummaryCfg bean) {
		dao.update(bean);
		
	}

}
