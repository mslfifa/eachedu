package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.AnswerEvaluate;
@Service("answerEvaluateService")
public class AnswerEvaluateServiceImpl extends BaseServiceImpl<AnswerEvaluate, Long> {
	@Resource(name="answerEvaluateDao")
	@Override
	public void setDao(BaseDao<AnswerEvaluate, Long> dao) {
		this.dao=dao;
	}

}
