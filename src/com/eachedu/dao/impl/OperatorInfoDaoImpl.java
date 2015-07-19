package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.OperatorInfoDao;
import com.eachedu.dao.pojo.OperatorInfo;

@Repository("operatorInfoDao")
public class OperatorInfoDaoImpl extends BaseDaoImpl<OperatorInfo, Long>implements OperatorInfoDao {

}
