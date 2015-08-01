package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.QuestionInfoDao;
import com.eachedu.dao.pojo.QuestionInfo;
@Repository("questionInfoDao")
public class QuestionInfoDaoImpl extends BaseDaoImpl<QuestionInfo, Long>implements QuestionInfoDao {


}
