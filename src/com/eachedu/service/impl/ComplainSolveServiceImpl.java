package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.ComplainSolve;
import com.eachedu.service.ComplainSolveService;

@Service("complainSolveService")
public class ComplainSolveServiceImpl extends BaseServiceImpl<ComplainSolve, Long>implements ComplainSolveService {
	@Resource(name="complainSolveDao")
	@Override
	public void setDao(BaseDao<ComplainSolve, Long> dao) {
		this.dao = dao;
	}

}
