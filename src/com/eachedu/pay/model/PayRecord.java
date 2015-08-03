package com.eachedu.pay.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 支付记录信息表
 * @author wzg
 *
 */
public class PayRecord {
	
	/**订单状态: 1-支付处理中**/
	public static int PAY_STATUS_NOTPAY=1;
	/**订单状态: 2-支付成功;*/
	public static int PAY_STATUS_SUCCESS=2;
	/**订单状态: 3-支付失败**/
	public static int PAY_STATUS_FAIL=3;
	/**订单状态: 4-订单关闭**/
	public static int PAY_STATUS_CLOSED=4;
	
	/**支付方式:1:微信支付;***/
	public static int PAY_TYPE_WXPAY=1;
	/**支付方式:2:支付宝支付***/
	public static int PAY_TYPE_ALIPAY=2;
	
	/**支付ID***/
	private Long payId;
	/**订单编号**/
	private String orderNo;
	/**支付方式:1:微信支付;2:支付宝支付***/
	private Integer payType;
	/**支付的金额：单位元,分记录成 0.01元**/
	private BigDecimal payMoney; 
	/**支付申请时间**/
	private Date payTime;
	/**订单状态: 1-支付处理中;2-支付成功;3-支付失败**/
	private Integer payStatus;
	/**支付结果说明**/
	private String resultReasons;
	/**买家帐号**/
	private String buyerAccount;
	/**支付结果回复时间**/
	private Date receiveTime;
	/**平台订单号**/
	private String transactionId;
	
	public PayRecord() {
		super();
	}
	public PayRecord(String orderNo, Integer payType, BigDecimal payMoney,
			Date payTime, Integer payStatus) {
		super();
		this.orderNo = orderNo;
		this.payType = payType;
		this.payMoney = payMoney;
		this.payTime = payTime;
		this.payStatus = payStatus;
	}
	public Long getPayId() {
		return payId;
	}
	public void setPayId(Long payId) {
		this.payId = payId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public BigDecimal getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	public String getResultReasons() {
		return resultReasons;
	}
	public void setResultReasons(String resultReasons) {
		this.resultReasons = resultReasons;
	}
	public String getBuyerAccount() {
		return buyerAccount;
	}
	public void setBuyerAccount(String buyerAccount) {
		this.buyerAccount = buyerAccount;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	} 
	
	
	
}
