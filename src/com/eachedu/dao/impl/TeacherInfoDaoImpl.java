package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.TeacherInfoDao;
import com.eachedu.dao.pojo.TeacherInfo;
@Repository("teacherInfoDao")
public class TeacherInfoDaoImpl extends BaseDaoImpl<TeacherInfo, Long>implements TeacherInfoDao {

}
