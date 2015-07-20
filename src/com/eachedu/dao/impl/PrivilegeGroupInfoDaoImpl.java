package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.PrivilegeGroupInfoDao;
import com.eachedu.dao.pojo.PrivilegeGroupInfo;
@Repository("privilegeGroupInfoDao")
public class PrivilegeGroupInfoDaoImpl extends BaseDaoImpl<PrivilegeGroupInfo, Long>implements PrivilegeGroupInfoDao {

}
