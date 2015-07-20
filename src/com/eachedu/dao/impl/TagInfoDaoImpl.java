package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.TagInfoDao;
import com.eachedu.dao.pojo.TagInfo;
@Repository("tagInfoDao")
public class TagInfoDaoImpl extends BaseDaoImpl<TagInfo, Long>implements TagInfoDao {

}
