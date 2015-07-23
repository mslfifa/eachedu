package com.eachedu.app.actions;

import javax.annotation.Resource;

import com.eachedu.exception.ServiceException;
import com.eachedu.service.TeacherInfoService;

public class TeacherAppAction {
	
	private Integer appPageNo;
	private Integer appPageSize;
	public Integer getAppPageNo() {
		return appPageNo;
	}
	public void setAppPageNo(Integer appPageNo) {
		this.appPageNo = appPageNo;
	}
	public Integer getAppPageSize() {
		return appPageSize;
	}
	public void setAppPageSize(Integer appPageSize) {
		this.appPageSize = appPageSize;
	}
	
	@Resource(name="teacherInfoService")
	private TeacherInfoService teacherInfoService;
	
	public void findTeacherPage(){
		try {
			teacherInfoService.findTeacherPage(appPageNo,appPageSize);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
