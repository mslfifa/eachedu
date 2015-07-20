package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.TeacherAnswerDao;
import com.eachedu.dao.pojo.TeacherAnswer;
@Repository("teacherAnswerDao")
public class TeacherAnswerDaoImpl extends BaseDaoImpl<TeacherAnswer, Long>implements TeacherAnswerDao {


}
