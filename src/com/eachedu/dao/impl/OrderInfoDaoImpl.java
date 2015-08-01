package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.OrderInfoDao;
import com.eachedu.dao.pojo.OrderInfo;


@Repository("orderInfoDao")
public class OrderInfoDaoImpl extends BaseDaoImpl<OrderInfo,String> implements OrderInfoDao{

}
