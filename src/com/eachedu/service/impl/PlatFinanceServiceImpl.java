package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.PlatFinance;
import com.eachedu.service.PlatFinanceService;
@Service("platFinanceService")
public class PlatFinanceServiceImpl extends BaseServiceImpl<PlatFinance, Long>implements PlatFinanceService {
	@Resource(name="platFinanceDao")
	@Override
	public void setDao(BaseDao<PlatFinance, Long> dao) {
		this.dao=dao;
	}


}
