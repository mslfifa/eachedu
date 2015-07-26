package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.AnswerComment;
@Service("answerCommentService")
public class AnswerCommentServiceImpl extends BaseServiceImpl<AnswerComment, Long> {
	@Resource(name="answerCommentDao")
	@Override
	public void setDao(BaseDao<AnswerComment, Long> dao) {
		this.dao=dao;
	}

}
