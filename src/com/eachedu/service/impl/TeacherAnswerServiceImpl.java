package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.TeacherAnswer;
import com.eachedu.service.TeacherAnswerService;
@Service("teacherAnswerService")
public class TeacherAnswerServiceImpl extends BaseServiceImpl<TeacherAnswer, Long>implements TeacherAnswerService {
	@Resource(name="teacherAnswerDao")
	@Override
	public void setDao(BaseDao<TeacherAnswer, Long> dao) {
		this.dao=dao;
	}


}
