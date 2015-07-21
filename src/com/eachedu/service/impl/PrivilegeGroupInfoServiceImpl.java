package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.PrivilegeGroupInfo;
import com.eachedu.service.PrivilegeGroupInfoService;

@Service("privilegeGroupInfoService")
public class PrivilegeGroupInfoServiceImpl extends BaseServiceImpl<PrivilegeGroupInfo, Long>
		implements PrivilegeGroupInfoService {

	@Resource(name="privilegeGroupInfoDao")
	@Override
	public void setDao(BaseDao<PrivilegeGroupInfo, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

}
