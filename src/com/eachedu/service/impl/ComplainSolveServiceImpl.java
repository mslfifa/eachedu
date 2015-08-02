package com.eachedu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.MessageNoticeDao;
import com.eachedu.dao.pojo.AnswerComment;
import com.eachedu.dao.pojo.ComplainSolve;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.ComplainSolveService;

@Service("complainSolveService")
public class ComplainSolveServiceImpl extends BaseServiceImpl<ComplainSolve, Long>implements ComplainSolveService {
	
	@Resource(name="messageNoticeDao")
	private MessageNoticeDao messageNoticeDao;
	
	@Resource(name="complainSolveDao")
	@Override
	public void setDao(BaseDao<ComplainSolve, Long> dao) {
		this.dao = dao;
	}

	@Override
	public Long saveComplain(String orderNo, Integer score, String remark) throws ServiceException {
		try {
			
			if(StringUtils.isEmpty(orderNo)){
				throw new Exception("订单号不能为空!");
			}
			if (score==null) {
				throw new Exception("打分不能为空!");
			}
			if(score<1|| score>5){
				throw new Exception("评分["+score+"]超出[1-5]的范围!");
			}
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
		
		
		
	}

}
