package com.eachedu.service;

import com.eachedu.dao.pojo.AnswerComment;
import com.eachedu.exception.ServiceException;

public interface AnswerCommentService extends BaseService<AnswerComment, Long> {
	/**
	 * 评价老师的回答
	 * @param qiId 问题ID
	 * @param score 打分
	 * @param remark 备注
	 * @return 评论ID
	 * @throws ServiceException
	 */
	Long addComment(Long qiId,Integer score,String remark)throws ServiceException;
}
