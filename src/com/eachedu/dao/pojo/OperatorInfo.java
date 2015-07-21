package com.eachedu.dao.pojo;

import java.util.Date;

public class OperatorInfo {
	  private Long oiId;
	  private String account;
	  private String name;
	  private String password;
	  private String mobile;
	  private String email;
	  private String qq;
	  private Date createTime;
	public Long getOiId() {
		return oiId;
	}
	public void setOiId(Long oiId) {
		this.oiId = oiId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	  
	  
}
