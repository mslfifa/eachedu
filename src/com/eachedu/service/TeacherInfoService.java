package com.eachedu.service;

import java.util.List;
import java.util.Map;

import com.eachedu.dao.pojo.TeacherInfo;
import com.eachedu.exception.ServiceException;

public interface TeacherInfoService extends BaseService<TeacherInfo, Long> {
	List<TeacherInfo> findTeacherFromLogin(String username,String password) throws ServiceException;

	TeacherInfo findByMobile(String mobile, String password)throws ServiceException;

	TeacherInfo findBySns(String qq, String weixin, String weibo)throws ServiceException;

	boolean findExistByMobile(String mobile)throws ServiceException;

	void findTeacherPage(Integer appPageNo, Integer appPageSize)throws ServiceException;

	List<Map<String,Object>> findTopAnswerTeachers(int topNum)throws ServiceException;
}
