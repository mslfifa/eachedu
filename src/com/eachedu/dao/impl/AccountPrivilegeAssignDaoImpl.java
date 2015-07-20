package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.AccountPrivilegeAssignDao;
import com.eachedu.dao.pojo.AccountPrivilegeAssign;

@Repository("accountPrivilegeAssignDao")
public class AccountPrivilegeAssignDaoImpl extends BaseDaoImpl<AccountPrivilegeAssign, Long> implements AccountPrivilegeAssignDao {

}
