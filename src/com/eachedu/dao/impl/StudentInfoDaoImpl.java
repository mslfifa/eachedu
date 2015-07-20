package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.StudentInfoDao;
import com.eachedu.dao.pojo.StudentInfo;
@Repository("studentInfoDao")
public class StudentInfoDaoImpl extends BaseDaoImpl<StudentInfo, Long>implements StudentInfoDao {


}
