package com.eachedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.OperatorInfo;
import com.eachedu.exception.DaoException;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.OperatorInfoService;
@Service("operatorInfoService")
public class OperatorInfoServiceImpl extends BaseServiceImpl<OperatorInfo, Long>implements OperatorInfoService {

	@Resource(name="operatorInfoDao")
	@Override
	public void setDao(BaseDao<OperatorInfo, Long> dao) {
		this.dao=dao;
	}

	@Override
	public List<OperatorInfo> findOperatorFromLogin(String username, String password) throws ServiceException {
		try {
			StringBuffer hql = new StringBuffer(100);
			List param = new ArrayList();
			hql.append("from OperatorInfo where 1=1 ");
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
