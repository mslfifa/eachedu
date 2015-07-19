package com.eachedu.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.eachedu.dao.BaseDao;
import com.eachedu.exception.DaoException;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.BaseService;

public abstract class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {
	
	protected BaseDao<T,PK> dao; 
	
	public abstract void setDao(BaseDao<T, PK> dao) ;

	@Override
	public void save(T entity) throws ServiceException {
		try {
			dao.save(entity);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public void del(T entity) throws ServiceException {
		try {
			dao.del(entity);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}

	}

	@Override
	public void update(T entity) throws ServiceException {
		try {
			dao.update(entity);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}

	}

	@Override
	public T get(PK id) throws ServiceException {
		try {
			return dao.get(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public List<T> findAll() throws ServiceException {
		try {
			return dao.findAll();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
		
	}



}
