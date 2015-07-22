package com.eachedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.MessageNotice;
import com.eachedu.service.MessageNoticeService;

@Service("messageNoticeService")
public class MessageNoticeServiceImpl extends BaseServiceImpl<MessageNotice, Long>implements MessageNoticeService {
	@Resource(name="messageNoticeDao")
	@Override
	public void setDao(BaseDao<MessageNotice, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

}
