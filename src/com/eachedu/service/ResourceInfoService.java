package com.eachedu.service;

import java.io.File;

import com.eachedu.dao.pojo.ResourceInfo;
import com.eachedu.exception.ServiceException;

public interface ResourceInfoService extends BaseService<ResourceInfo, Long> {
	public Long saveResourceByFile(String resourceType,File file,String fileName, String contentType) throws ServiceException;

	/**
	 * 
	 * @param userId
	 * @param accountType 账户类型
	 * @param riId
	 * @param resourceType TODO
	 * @throws ServiceException
	 */
	public void checkBuy(Long userId, String accountType, Long riId, String resourceType) throws ServiceException;
}
