package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.AccountPrivilegeAssign;
import com.eachedu.service.AccountPrivilegeAssignService;
@Service("accountPrivilegeAssignService")
public class AccountPrivilegeAssignServiceImpl extends BaseServiceImpl<AccountPrivilegeAssign, Long>
		implements AccountPrivilegeAssignService {
	
	@Resource(name="accountPrivilegeAssignDao")
	@Override
	public void setDao(BaseDao<AccountPrivilegeAssign, Long> dao) {
		this.dao=dao;
	}
}
