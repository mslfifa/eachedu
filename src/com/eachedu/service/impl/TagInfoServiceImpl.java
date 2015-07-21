package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.TagInfo;
import com.eachedu.service.TagInfoService;
@Service("tagInfoService")
public class TagInfoServiceImpl extends BaseServiceImpl<TagInfo, Long>implements TagInfoService {
	@Resource(name="tagInfoDao")
	@Override
	public void setDao(BaseDao<TagInfo, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}


}
