package com.eachedu.service;

import com.eachedu.dao.pojo.AnswerComment;
import com.eachedu.exception.ServiceException;

public interface AnswerCommentService extends BaseService<AnswerComment, Long> {
	/**
	 * 评价老师的回答
	 * @param orderId 问题订单
	 * @param score 打分
	 * @param remark 备注
	 * @return 评论ID
	 * @throws ServiceException
	 */
	Long addComment(Long orderId,Integer score,String remark)throws ServiceException;
}
