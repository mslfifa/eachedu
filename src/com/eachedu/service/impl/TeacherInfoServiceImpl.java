package com.eachedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.TeacherInfo;
import com.eachedu.exception.DaoException;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.TeacherInfoService;
@Service("teacherInfoService")
public class TeacherInfoServiceImpl extends BaseServiceImpl<TeacherInfo, Long>implements TeacherInfoService {
	@Resource(name="teacherInfoDao")
	@Override
	public void setDao(BaseDao<TeacherInfo, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

	@Override
	public List<TeacherInfo> findTeacherFromLogin(String username, String password) throws ServiceException {
		try {
			StringBuffer hql = new StringBuffer(100);
			List param = new ArrayList();
			hql.append("from TeacherInfo where 1=1 ");
			if(StringUtils.isNotEmpty(username)){
				hql.append(" and account = ? ");
				param.add(username);
			}
			
			if (StringUtils.isNotEmpty(password)) {
				hql.append(" and passWord = ? ");
				param.add(password);
			}
			return dao.findByHql(hql.toString(), param.toArray(new Object[0]));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public TeacherInfo findByMobile(String mobile, String password) throws ServiceException {
		try {
			String hql = "from TeacherInfo where mobile=? and password = ? ";
			List list = dao.findByHql(hql, mobile,password);
			if(list!=null && !password.isEmpty()){
				return (TeacherInfo) list.get(0);
			}else{
				throw new Exception("没有找到手机号["+mobile+"]的老师");
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		} 
	}

	@Override
	public TeacherInfo findBySns(String qq, String weixin, String weibo) throws ServiceException {
		
		try {
			StringBuffer hql = new StringBuffer(100);
			List param = new ArrayList();
			hql.append("from TeacherInfo where 1=0 ");
			if(StringUtils.isNotEmpty(qq)){
				hql.append(" or qq = ? ");
				param.add(qq);
			}
			if(StringUtils.isEmpty(weixin)){
				hql.append(" or weixin = ? ");
				param.add(weixin);
			}
			if(StringUtils.isNotEmpty(weibo)){
				hql.append(" or weibo = ? ");
				param.add("weibo");
			}
			List list = dao.findByHql(hql.toString(), param.toArray(new Object[0]));
			
			TeacherInfo t = null;
			if(list!=null && !list.isEmpty()){
				t = (TeacherInfo) list.get(0);
			}
			return t;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
		
	}

	@Override
	public boolean findExistByMobile(String mobile) throws ServiceException {
		try {
			boolean flag = false;
			if(StringUtils.isEmpty(mobile)){
				throw new Exception("mobile不能为空!");
			}
			String hql = "from TeacherInfo where mobile = ? ";
			List list = dao.findByHql(hql, mobile);
			TeacherInfo t = null;
			if(list!=null && !list.isEmpty()){
				t=(TeacherInfo) list.get(0);
			}
			
			return t!=null;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public void findTeacherPage(Integer appPageNo, Integer appPageSize) throws ServiceException {
		String hql = "select t from TeacherInfo t, order by ";
	}


}
