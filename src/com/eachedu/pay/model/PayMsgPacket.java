package com.eachedu.pay.model;

import java.util.Date;

/**
 * 支付相关操作报文记录
 * @author wzg
 *
 */
public class PayMsgPacket {

	/**记录ID**/
	private Long packetId;
	/**订单编号**/
	private String orderNo;
	/**发送时间**/
	private Date creatTime;
	/**报文类型**/
	private String msgType;
	/**报文内容**/
	private String msgPacket;
	
	public PayMsgPacket() {
		super();
	}
	
	public PayMsgPacket(String orderNo, Date creatTime, String msgType,
			String msgPacket) {
		super();
		this.orderNo = orderNo;
		this.creatTime = creatTime;
		this.msgType = msgType;
		this.msgPacket = msgPacket;
	}
	public Long getPacketId() {
		return packetId;
	}
	public void setPacketId(Long packetId) {
		this.packetId = packetId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgPacket() {
		return msgPacket;
	}
	public void setMsgPacket(String msgPacket) {
		this.msgPacket = msgPacket;
	}
	
	
	
	
	
}
