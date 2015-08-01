package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.OrderInfo;
import com.eachedu.service.OrderInfoService;

@Service("orderInfoService")
public class OrderInfoServiceImpl extends BaseServiceImpl<OrderInfo, String>implements OrderInfoService {

	@Resource(name="orderInfoDao")
	@Override
	public void setDao(BaseDao<OrderInfo, String> dao) {
		this.dao=dao;
		
	}

	

}
