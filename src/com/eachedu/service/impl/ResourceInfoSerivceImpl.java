package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.ResourceInfo;
import com.eachedu.service.ResourceInfoSerivce;
@Service("resourceInfoService")
public class ResourceInfoSerivceImpl extends BaseServiceImpl<ResourceInfo, Long>implements ResourceInfoSerivce {
	@Resource(name="resourceInfoDao")
	@Override
	public void setDao(BaseDao<ResourceInfo, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}
}
