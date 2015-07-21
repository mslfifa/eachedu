package com.eachedu.service;

import java.util.List;

import com.eachedu.dao.pojo.OperatorInfo;
import com.eachedu.exception.ServiceException;

public interface OperatorInfoService extends BaseService<OperatorInfo, Long> {
	List<OperatorInfo> findOperatorFromLogin(String username,String password) throws ServiceException;
}
