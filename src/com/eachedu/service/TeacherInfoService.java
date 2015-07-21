package com.eachedu.service;

import java.util.List;

import com.eachedu.dao.pojo.TeacherInfo;
import com.eachedu.exception.ServiceException;

public interface TeacherInfoService extends BaseService<TeacherInfo, Long> {
	List<TeacherInfo> findTeacherFromLogin(String username,String password) throws ServiceException;
}
