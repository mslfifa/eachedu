package com.eachedu.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.MessageNoticeDao;
import com.eachedu.dao.pojo.MessageNotice;
@Repository("messageNoticeDao")
public class MessageNoticeDaoImpl extends BaseDaoImpl<MessageNotice, Long>implements MessageNoticeDao {

}
