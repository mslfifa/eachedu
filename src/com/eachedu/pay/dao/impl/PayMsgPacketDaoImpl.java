package com.eachedu.pay.dao.impl;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.impl.BaseDaoImpl;
import com.eachedu.pay.dao.IPayMsgPacketDao;
import com.eachedu.pay.model.PayMsgPacket;

@Repository("payMsgPacketDao")
public class PayMsgPacketDaoImpl extends BaseDaoImpl<PayMsgPacket, Long> implements IPayMsgPacketDao {

}
