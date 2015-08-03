package com.eachedu.pay.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.pay.model.PayMsgPacket;
import com.eachedu.pay.service.IPayMsgPacketService;
import com.eachedu.service.impl.BaseServiceImpl;

@Service("payMsgPacketService")
public class PayMsgPacketServiceImpl extends BaseServiceImpl<PayMsgPacket, Long> implements IPayMsgPacketService {

	@Resource(name="payMsgPacketDao")
	@Override
	public void setDao(BaseDao<PayMsgPacket, Long> dao) {
		this.dao=dao;
	}

}
