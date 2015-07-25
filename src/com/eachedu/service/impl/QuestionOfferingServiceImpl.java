package com.eachedu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.QuestionOffering;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.QuestionOfferingService;
@Service("questionOfferingService")
public class QuestionOfferingServiceImpl extends BaseServiceImpl<QuestionOffering, Long>
		implements QuestionOfferingService {
	
	private static final Logger log = LoggerFactory.getLogger(QuestionOfferingServiceImpl.class);
	
	@Resource(name="questionOfferingDao")
	@Override
	public void setDao(BaseDao<QuestionOffering, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

	@Override
	public Long findQuestionedByStatus(String status) throws ServiceException {
		
		Long countNum = null;
		try {
			if(StringUtils.isEmpty(status)){
				throw new Exception("status不能为空");
			}
			String hql = "select count(*) as count_num from QuestionOffering where status = ? ";
			List list = dao.findByHql(hql, status);
			if(list!=null && !list.isEmpty()){
				countNum = (Long) list.get(0);
			}else{
				countNum = 0l;
			}
			return countNum;
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error(e.getMessage());
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

}
