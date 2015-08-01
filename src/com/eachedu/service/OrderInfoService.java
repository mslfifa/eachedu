package com.eachedu.service;

import java.util.Map;

import com.eachedu.dao.pojo.OrderInfo;
import com.eachedu.exception.ServiceException;

public interface OrderInfoService extends BaseService<OrderInfo, String> {
	
	/**
	 * 购买课件
	 * @param ciId  课件ID
	 * @param accountType 账户类型
	 * @param accountId 账户ID
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> saveBuy(Long ciId, String accountType, Long accountId) throws ServiceException;

}
