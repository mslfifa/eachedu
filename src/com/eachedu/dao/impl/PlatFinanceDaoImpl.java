package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.PlatFinanceDao;
import com.eachedu.dao.pojo.PlatFinance;
@Repository("platFinanceDao")
public class PlatFinanceDaoImpl extends BaseDaoImpl<PlatFinance, Long>implements PlatFinanceDao {

}
