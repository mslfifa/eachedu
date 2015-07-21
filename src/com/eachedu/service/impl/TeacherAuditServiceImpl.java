package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.TeacherAudit;
import com.eachedu.service.TeacherAuditService;
@Service("teacherAuditService")
public class TeacherAuditServiceImpl extends BaseServiceImpl<TeacherAudit, Long>implements TeacherAuditService {
	@Resource(name="teacherAuditDao")
	@Override
	public void setDao(BaseDao<TeacherAudit, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}
}
