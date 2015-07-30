package com.eachedu.service;

import java.io.File;

import com.eachedu.dao.pojo.ResourceInfo;
import com.eachedu.exception.ServiceException;

public interface ResourceInfoSerivce extends BaseService<ResourceInfo, Long> {
	public Long saveResourceByFile(String resourceType,File file,String fileName, String contentType) throws ServiceException; 
}
