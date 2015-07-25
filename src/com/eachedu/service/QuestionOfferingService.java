package com.eachedu.service;

import com.eachedu.dao.pojo.QuestionOffering;
import com.eachedu.exception.ServiceException;

public interface QuestionOfferingService extends BaseService<QuestionOffering, Long> {
	public Long findQuestionedByStatus(String status) throws ServiceException;
}
