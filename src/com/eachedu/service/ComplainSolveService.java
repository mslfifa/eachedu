package com.eachedu.service;

import com.eachedu.dao.pojo.ComplainSolve;
import com.eachedu.exception.ServiceException;

public interface ComplainSolveService extends BaseService<ComplainSolve, Long> {

	/**
	 * 生成投诉返回实体ID
	 * @param orderNo 订单号
	 * @param score   打分
	 * @param remark  投诉备注
	 * @return
	 * @throws ServiceException TODO
	 */
	Long saveComplain(String orderNo, Integer score, String remark) throws ServiceException;

}
