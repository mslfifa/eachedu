package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.ResourceInfoDao;
import com.eachedu.dao.pojo.ResourceInfo;
@Repository("resourceInfoDao")
public class ResourceInfoDaoImpl extends BaseDaoImpl<ResourceInfo, Long>implements ResourceInfoDao {


}
