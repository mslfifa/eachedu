package com.eachedu.service;

import com.eachedu.dao.pojo.ComplainSolve;
import com.eachedu.exception.ServiceException;

public interface ComplainSolveService extends BaseService<ComplainSolve, Long> {

	/**
	 * 生成投诉返回实体ID
	 * @param orderNo 订单号
	 * @param complainType   打分
	 * @param complainContext  投诉正文
	 * @param userId TODO
	 * @return
	 * @throws ServiceException TODO
	 */
	Long saveComplain(String orderNo, String complainType, String complainContext, Long userId) throws ServiceException;

}
