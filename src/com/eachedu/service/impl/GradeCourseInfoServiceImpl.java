package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.GradeCourseInfo;
@Service("gradeCourseInfoService")
public class GradeCourseInfoServiceImpl extends BaseServiceImpl<GradeCourseInfo, Long> {
	@Resource(name="gradeCourseInfoDao")
	@Override
	public void setDao(BaseDao<GradeCourseInfo, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

}
