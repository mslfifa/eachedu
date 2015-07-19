package com.eachedu.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.eachedu.exception.DaoException;
import com.eachedu.web.vo.PagerVO;

public interface BaseDao<T ,PK extends Serializable> {
	
	/**
	 * 保存实体
	 * @param entity
	 * @throws DaoException TODO
	 */
	public void save(T entity) throws DaoException;
	
	/**
	 * 删除实体
	 * @param entity
	 * @throws DaoException TODO
	 */
	public void del(T entity) throws DaoException;
	
	/**
	 * 更新实体
	 * @param entity
	 * @throws DaoException TODO
	 */
	public void update(T entity) throws DaoException;
	
	/**
	 * 通过ID获得实体
	 * @param id
	 * @return
	 * @throws DaoException TODO
	 */
	public T get(PK id) throws DaoException;
	
	/**
	 * 返回表中全部实体
	 * @return
	 * @throws DaoException TODO
	 */
	public List<T> findAll() throws DaoException;
	
	
	/**
	 * HQL分页查询
	 * @param hql
	 * @param offset 开始页数
	 * @param pagesize 页大小
	 * @param paras 参数数组
	 * @return
	 * @throws DaoException TODO
	 */
	public PagerVO findByHqlPage(String hql,int offset,int pagesize,Object... paras) throws DaoException;
	
	
	/**
	 * 根据MAP参数查询SQL分页
	 * @param sql
	 * @param offset
	 * @param pagesize
	 * @param paras
	 * @return
	 * @throws DaoException TODO
	 */
	public PagerVO findBySqlPage(String sql,int offset,int pagesize,Object... paras) throws DaoException;
		
	/**
	 * 根据MAP参数查询SQL，结果返回List<Map<String,Object>>
	 * @param sql
	 * @param paras
	 * @return
	 * @throws DaoException TODO
	 */
	public List<Map<String,Object>> findBySQL(String sql, Object... paras) throws DaoException;
	
	/**
	 * 根据MAP参数查询HQL，结果返回List
	 * @param hql
	 * @param paras
	 * @return
	 * @throws DaoException TODO
	 */
	public List findByHql(String hql,Object... paras) throws DaoException;
	
	/**
	 * 根据Map参数执行DML的SQL
	 * @param sql
	 * @param paras
	 * @return
	 * @throws DaoException TODO
	 */
	public int executeSql(String sql,Object... paras) throws DaoException;
}
