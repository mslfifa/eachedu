package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.AccountManagerLog;
import com.eachedu.service.AccountManagerLogService;

@Service("accountManagerLogService")
public class AccountManagerLogServiceImpl extends BaseServiceImpl<AccountManagerLog, Long>
		implements AccountManagerLogService {
	@Resource(name="accountManagerLogDao")
	@Override
	public void setDao(BaseDao<AccountManagerLog, Long> dao) {
		this.dao=dao;
	}

}
