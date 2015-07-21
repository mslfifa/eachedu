package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.pojo.PlatFinance;
import com.eachedu.dao.pojo.PlatFinanceDao;
@Repository("platFinanceDao")
public class PlatFinanceDaoImpl extends BaseDaoImpl<PlatFinance, Long>implements PlatFinanceDao {

}
