package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.TeacherExpert;
import com.eachedu.service.TeacherExpertService;
@Service("teacherExpertService")
public class TeacherExpertServiceImpl extends BaseServiceImpl<TeacherExpert, Long>implements TeacherExpertService {
	@Resource(name="teacherExpertDao")
	@Override
	public void setDao(BaseDao<TeacherExpert, Long> dao) {
		this.dao=dao;
	}
}
