package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.CoursewareInfoDao;
import com.eachedu.dao.pojo.CoursewareInfo;

@Repository("coursewareInfoDao")
public class CoursewareInfoDaoImpl extends BaseDaoImpl<CoursewareInfo, Long>implements CoursewareInfoDao {


}
