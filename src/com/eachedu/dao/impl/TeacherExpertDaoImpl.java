package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.TeacherExpertDao;
import com.eachedu.dao.pojo.TeacherExpert;
@Repository("teacherExpertDao")
public class TeacherExpertDaoImpl extends BaseDaoImpl<TeacherExpert, Long>implements TeacherExpertDao {


}
