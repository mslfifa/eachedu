package com.eachedu.service;

import java.util.List;

import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.exception.ServiceException;

public interface StudentInfoService extends BaseService<StudentInfo, Long> {
	List<StudentInfo> findStudentFromLogin(String username,String password) throws ServiceException;
}
