package com.eachedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.StudentInfoService;
@Service("studentInfoService")
public class StudentInfoServiceImpl extends BaseServiceImpl<StudentInfo, Long>implements StudentInfoService {
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

}
