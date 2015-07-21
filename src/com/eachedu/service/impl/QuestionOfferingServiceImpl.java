package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.QuestionOffering;
import com.eachedu.service.QuestionOfferingService;
@Service("questionOfferingService")
public class QuestionOfferingServiceImpl extends BaseServiceImpl<QuestionOffering, Long>
		implements QuestionOfferingService {
	@Resource(name="questionOfferingDao")
	@Override
	public void setDao(BaseDao<QuestionOffering, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}


}
