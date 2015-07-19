package com.eachedu.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.eachedu.exception.ServiceException;
import com.eachedu.web.vo.PagerVO;

public interface BaseService <T,PK extends Serializable>{
	/**
	 * 保存实体
	 * @param entity
	 * @throws ServiceException TODO
	 */
	public void save(T entity) throws ServiceException;
	
	/**
	 * 删除实体
	 * @param entity
	 * @throws ServiceException TODO
	 */
	public void del(T entity) throws ServiceException;
	
	/**
	 * 更新实体
	 * @param entity
	 * @throws ServiceException TODO
	 */
	public void update(T entity) throws ServiceException;
	
	/**
	 * 通过ID获得实体
	 * @param id
	 * @return
	 * @throws ServiceException TODO
	 */
	public T get(PK id) throws ServiceException;
	
	
	/**
	 * 返回表中全部实体
	 * @return
	 * @throws ServiceException TODO
	 */
	public List<T> findAll() throws ServiceException;
	
	
}
