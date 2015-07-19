package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.OperatorInfo;
import com.eachedu.service.OperatorInfoService;
@Service("operatorInfoService")
public class OperatorInfoServiceImpl extends BaseServiceImpl<OperatorInfo, Long>implements OperatorInfoService {

	@Resource(name="operatorInfoDao")
	@Override
	public void setDao(BaseDao<OperatorInfo, Long> dao) {
		this.dao=dao;
	}
}
