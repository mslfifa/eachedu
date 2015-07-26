package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.AnswerCommentDao;
import com.eachedu.dao.pojo.AnswerComment;
@Repository("answerCommentDao")
public class AnswerCommentDaoImpl extends BaseDaoImpl<AnswerComment, Long>implements AnswerCommentDao {

}
