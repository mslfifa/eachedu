package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.CoursewareDown;
@Service("coursewareDownService")
public class CoursewareDownServiceImpl extends BaseServiceImpl<CoursewareDown, Long> {
	@Resource(name="coursewareDownDao")
	@Override
	public void setDao(BaseDao<CoursewareDown, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

}
