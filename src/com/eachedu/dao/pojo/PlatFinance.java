package com.eachedu.dao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PlatFinance {
	private Long pfId;
	private String busType;
	private Long busId;
	private String accountType;
	private Long accountId;
	private BigDecimal amount;
	//是否退款
	private Boolean refunded;
	private String cashFlow;
	private Date opTime;
	public Long getPfId() {
		return pfId;
	}
	public void setPfId(Long pfId) {
		this.pfId = pfId;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public Long getBusId() {
		return busId;
	}
	public void setBusId(Long busId) {
		this.busId = busId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Boolean getRefunded() {
		return refunded;
	}
	public void setRefunded(Boolean refunded) {
		this.refunded = refunded;
	}
	public String getCashFlow() {
		return cashFlow;
	}
	public void setCashFlow(String cashFlow) {
		this.cashFlow = cashFlow;
	}
	public Date getOpTime() {
		return opTime;
	}
	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}
	
	
}
