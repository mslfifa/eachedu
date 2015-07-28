package com.eachedu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.StudentInfoService;
@Service("studentInfoService")
public class StudentInfoServiceImpl extends BaseServiceImpl<StudentInfo, Long>implements StudentInfoService {
	
	private static final Logger log = LoggerFactory.getLogger(StudentInfoServiceImpl.class);
	
	@Resource(name="studentInfoDao")
	@Override
	public void setDao(BaseDao<StudentInfo, Long> dao) {
		this.dao=dao;
	}

	@Override
	public List<StudentInfo> findStudentFromLogin(String username, String password) throws ServiceException {
		try {
			StringBuffer hql = new StringBuffer(100);
			List param = new ArrayList();
			hql.append("from StudentInfo where 1=1 ");
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
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public StudentInfo findByMobile(String mobile, String password) throws ServiceException {
		try {
			String hql ="from StudentInfo where mobile = ? and password=? ";
			List list = dao.findByHql(hql, mobile,password);
			if(list!=null && !list.isEmpty()){
				return (StudentInfo) list.get(0);
			}else{
				throw new Exception("查不到手机号["+mobile+"]的学生账号");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public boolean findExistByMobile(String mobile) throws ServiceException {
		try {
			String hql = "from StudentInfo where mobile = ? ";
			List list = dao.findByHql(hql, mobile);
			StudentInfo s = null;
			if(list!=null && !list.isEmpty()){
				s = (StudentInfo) list.get(0);
			}
			
			return s!=null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public StudentInfo findBySns(String qq, String weixin, String weibo) throws ServiceException {
		try {
			StringBuffer sql = new StringBuffer(100);
			List param = new ArrayList();
			sql.append("from StudentInfo where 1=0 ");
			if(StringUtils.isNotEmpty(qq)){
				sql.append(" or qq = ? ");
				param.add(qq);
			}
			if(StringUtils.isEmpty(weixin)){
				sql.append(" or weixin = ? ");
				param.add(weixin);
			}
			if (StringUtils.isNotEmpty(weibo)) {
				sql.append(" or weibo = ? ");
				param.add(weibo);
			}
			List list = dao.findByHql(sql.toString(), param.toArray(new Object[0]));
			
			StudentInfo s = null;
			if(list!=null && !list.isEmpty()){
				s = (StudentInfo) list.get(0);
			}
			
			return s;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
		
	}

	@Override
	public void updatePwd(String mobile, String password) throws ServiceException {
		try {
			String hql = "from StudentInfo where mobile = ? ";
			List list = dao.findByHql(hql, mobile);
			StudentInfo s = null;
			if(list!=null && !list.isEmpty()){
				s = (StudentInfo) list.get(0);
			}else{
				throw new Exception("找不到手机号为["+mobile+"]");
			}
			
			s.setPassword(password);
			s.setCreateTime(new Date());
			dao.update(s);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

}
