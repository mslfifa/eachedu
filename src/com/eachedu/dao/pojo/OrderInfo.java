package com.eachedu.dao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo {
	//订单号 GenerateStrUtils.generateOrder 生成
	private String orderNo;
	//订单类型  ASK_PAY : 提问支付 COMPLAIN_REFUND : 投诉退款  DOWNLOAD_PAY 下载支付  DOWNLOAD_REFUND : 下载退款
	private String orderType;
	//业务表主键 quiton_info  course_download
	private Long busId;
	private String orderDesc;
	private BigDecimal prise;
	private BigDecimal bonus;
	private BigDecimal sumMoney;
	//TRADE_SUCCESS : 交易成功 TRADE_FAIL : 交易失败  TRADE_CLOSED : 交易关闭
	private String status;
	private String remark;
	//识别账号所属类型  OPER_TYPE:运营账号 STUDENT_TYPE:学生账号  TEACHER_TYPE:老师账号
	private String accountType;
	private Long buyerId;
	private Date createTime;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Long getBusId() {
		return busId;
	}
	public void setBusId(Long busId) {
		this.busId = busId;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	public BigDecimal getPrise() {
		return prise;
	}
	public void setPrise(BigDecimal prise) {
		this.prise = prise;
	}
	public BigDecimal getBonus() {
		return bonus;
	}
	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}
	public BigDecimal getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
}
