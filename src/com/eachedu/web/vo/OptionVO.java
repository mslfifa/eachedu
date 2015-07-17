package com.eachedu.web.vo;

import java.io.Serializable;

/**
 * 封闭HTML SELECT OPTION的键值对
 * @author Administrator
 *
 */
public class OptionVO {
	private Serializable value;
	private String title;
	public Serializable getValue() {
		return value;
	}
	public void setValue(Serializable value) {
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public OptionVO(Serializable value, String title) {
		super();
		this.value = value;
		this.title = title;
	}
	
}
