package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.AccountManagerLogDao;
import com.eachedu.dao.pojo.AccountManagerLog;
@Repository("accountManagerLogDao")
public class AccountManagerLogDaoImpl extends BaseDaoImpl<AccountManagerLog, Long>implements AccountManagerLogDao {


}
