package com.eachedu.dao;

import java.io.Serializable;
import java.util.List;

import com.eachedu.SystemContext;
import com.eachedu.web.vo.PagerVO;

@SuppressWarnings("unchecked")
public interface BaseDao {
	
	/**
	 * ����ʵ�����
	 * @param entity
	 */
	public void save(Object entity);
	
	/**
	 * ɾ��ĳ��ʵ�����
	 * @param entity ������ĳ��ʵ�����
	 */
	public void del(Object entity);
	
	/**
	 * ����ʵ�����
	 * @param entity ������ĳ��ʵ�����
	 */
	public void update(Object entity);
	
	/**
	 * ���ID��ѯʵ�����
	 * @param <T> ĳ��ʵ���������
	 * @param entityClass ʵ������Class
	 * @param id ʵ������ID
	 * @return ��Ӧ��ʵ�����
	 */
	public <T> T findById(Class<T> entityClass,Serializable id);
	
	/**
	 * ��ѯĳ�����͵����е�ʵ����󣨲����κ�������
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findAll(Class<T> entityClass);
	
	/**
	 * ��ʵ����󵱳ɲ�ѯ���������ʵ������а�����ԣ��Զ����SQL����ѯ��Ӧ��ʵ�����
	 * @param entity �������Ĳ��������ĳ��ʵ�����
	 * @return
	 */
	public List find(Object entity);
	
	/**
	 * ��ҳ��ѯ����ѯ��䲻���κ�?����
	 * ����SystemContext��ȡ��offset��pagesize����������з�ҳ��ѯ
	 * @param query ��ѯ��HQL���
	 * @return
	 * @see SystemContext
	 * @see PagerVO
	 */
	public PagerVO findPaginated(String query);
	
	/**
	 * ��ҳ��ѯ����ѯ���ֻ��һ��?����
	 * ����SystemContext��ȡ��offset��pagesize����������з�ҳ��ѯ
	 * @param query HQL��ѯ���
	 * @param param HQL��ѯ����������滻?�Ĳ���ֵ
	 * @return
	 */
	public PagerVO findPaginated(String query,Object param);
	
	/**
	 * ��ҳ��ѯ����ѯ�������ɸ�?����
	 * ����SystemContext��ȡ��offset��pagesize����������з�ҳ��ѯ
	 * @param query HQL��ѯ���
	 * @param params HQL��ѯ��������ɸ�?�������Ӧ��ֵ
	 * @return
	 */
	public PagerVO findPaginated(String query,Object[] params);
	
	/**
	 * ���HQL�����з�ҳ��ѯ����ѯ����в���?����
	 * @param query HQL��ѯ���
	 * @param offset �ӵڼ��п�ʼ��ѯ
	 * @param pagesize ��෵�ض��������
	 * @return
	 */
	public PagerVO findPaginated(String query,int offset,int pagesize);
	
	/**
	 * ���HQL�����з�ҳ��ѯ����ѯ�����ֻ��һ��?����
	 * @param query HQL��ѯ���
	 * @param param HQL��ѯ����������滻?�Ĳ���ֵ
	 * @param offset �ӵڼ��п�ʼ��ѯ
	 * @param pagesize ��෵�ض��������
	 * @return
	 */
	public PagerVO findPaginated(String query,Object param,int offset,int pagesize);
	
	/**
	 * ���HQL�����з�ҳ��ѯ����ѯ����а����ɸ�?����
	 * @param query HQL��ѯ���
	 * @param params HQL��ѯ����������滻?�Ĳ���ֵ
	 * @param offset �ӵڼ��п�ʼ��ѯ
	 * @param pagesize ��෵�ض��������
	 * @return
	 */
	public PagerVO findPaginated(String query,Object[] params,int offset,int pagesize);
	
	
	public List findBySQL(String sql, Object... para);
	
	
	public List findByHql(String hql,Object... para);
	
	public int executeSql(String sql,Object... para);
}
