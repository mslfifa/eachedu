package com.eachedu.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.TeacherAuditDao;
import com.eachedu.dao.pojo.TeacherAudit;
import com.eachedu.exception.DaoException;
import com.eachedu.web.vo.PagerVO;
@Repository("teacherAuditDao")
public class TeacherAuditDaoImpl extends BaseDaoImpl<TeacherAudit, Long>implements TeacherAuditDao {


}
