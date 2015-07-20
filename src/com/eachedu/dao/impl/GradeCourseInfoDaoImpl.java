package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.GradeCourseInfoDao;
import com.eachedu.dao.pojo.GradeCourseInfo;
@Repository("gradeCourseInfoDao")
public class GradeCourseInfoDaoImpl extends BaseDaoImpl<GradeCourseInfo, Long>implements GradeCourseInfoDao {


}
