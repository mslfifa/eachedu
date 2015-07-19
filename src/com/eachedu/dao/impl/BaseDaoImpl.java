package com.eachedu.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.eachedu.dao.BaseDao;
import com.eachedu.exception.DaoException;
import com.eachedu.web.vo.PagerVO;


public abstract class  BaseDaoImpl<T ,PK extends Serializable> implements BaseDao<T ,PK> {

	@Resource
	private SessionFactory sessionFactory;
	
	protected Class<T> entityClass;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public BaseDaoImpl() {
		entityClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void save(T entity) throws DaoException {
		
		try {
			getSession().save(entity);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
		
	}

	@Override
	public void del(T entity) throws DaoException {
		try {
			getSession().delete(entity);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
		
	}

	@Override
	public void update(T entity) throws DaoException {
		try {
			getSession().update(entity);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
		
	}

	

	@Override
	public List findAll() throws DaoException {
		try {
			return getSession().createCriteria(entityClass).list();
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
		
	}

	@Override
	public PagerVO findByHqlPage(String hql, int offset, int pagesize, Object... paras) throws DaoException {
		try {
			PagerVO page = new PagerVO();
			
			String countHql = "select count(1) as total from (  "+hql+"  )  ";
			Query countQuery = getSession().createQuery(countHql);
			Query query = getSession().createQuery(hql);
			if(paras!=null && paras.length>0){
				for (int i = 0; i < paras.length; i++) {
					countQuery.setParameter(i, paras[i]);
					query.setParameter(i, paras[i]);
				}
			}
			int total = ((Long)countQuery.uniqueResult()).intValue();
			
			List datas = query.list();
			
			page.setTotal(total);
			page.setDatas(datas);
			return page;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
		
		
	}

	@Override
	public PagerVO findBySqlPage(String sql, int offset, int pagesize, Object... paras) throws DaoException {
		try {
			PagerVO page = new PagerVO();
			
			String countSql = "select count(1) as total from ( "+sql+" )";
			SQLQuery countQuery = getSession().createSQLQuery(sql);
			SQLQuery query = getSession().createSQLQuery(sql);
			if(paras!=null && paras.length>0){
				for (int i = 0; i < paras.length; i++) {
					countQuery.setParameter(i, paras[i]);
					query.setParameter(i, paras[i]);
				}
			}
			
			List counts = countQuery.addEntity(Long.class).list();
			int total = ((Long)counts.get(0)).intValue();
			page.setTotal(total);
			List datas = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			page.setDatas(datas);
			return page;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
		
	}

	@Override
	public List findBySQL(String sql, Object... paras) throws DaoException {
		
		try {
			SQLQuery query = getSession().createSQLQuery(sql);
			if(paras!=null && paras.length>0){
				for (int i = 0; i < paras.length; i++) {
					query.setParameter(i, paras[i]);
				}
			}
			List datas = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			return datas;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
		
		
	}

	@Override
	public List findByHql(String hql, Object... paras) throws DaoException {
		try {
			Query query = getSession().createQuery(hql);
			if(paras!=null && paras.length>0){
				for (int i = 0; i < paras.length; i++) {
					query.setParameter(i, paras[i]);
				}
			}
			return query.list();
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public int executeSql(String sql, Object... paras) throws DaoException {
		
		try {
			SQLQuery executeQuery = getSession().createSQLQuery(sql);
			if(paras!=null && paras.length>0){
				for (int i = 0; i < paras.length; i++) {
					executeQuery.setParameter(i, paras[i]);
				}
			}
			
			int reusltNum = executeQuery.executeUpdate();
			return reusltNum;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
		
		
	}

	@Override
	public T get(PK id) throws DaoException {
		try {
			return (T) getSession().get(entityClass, id);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
	}
	
	
}
