package com.eachedu.service;

import java.util.List;
import java.util.Map;

import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.exception.ServiceException;

public interface StudentInfoService extends BaseService<StudentInfo, Long> {
	List<StudentInfo> findStudentFromLogin(String username,String password) throws ServiceException;

	StudentInfo findByMobile(String mobile, String password) throws ServiceException;

	boolean findExistByMobile(String mobile)throws ServiceException;

	/**
	 * 第三账号查询用户信息 包括头像 remote_url
	 * @param qq
	 * @param weixin
	 * @param weibo
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> findBySns(String qq, String weixin, String weibo)throws ServiceException;

	/**
	 * 重置密码
	 * @param mobile
	 * @param password
	 * @throws ServiceException
	 */
	void updatePwd(String mobile, String password)throws ServiceException;
}
