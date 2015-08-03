package com.eachedu.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.exception.ServiceException;
import com.eachedu.web.vo.PagerVO;

public interface StudentInfoService extends BaseService<StudentInfo, Long> {
	List<StudentInfo> findStudentFromLogin(String username,String password) throws ServiceException;

	Map<String, Object> findByMobile(String mobile, String password) throws ServiceException;

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

	/**
	 * 查看学生个人账户信息
	 * @param siId
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> findUserInfo(Long siId)throws ServiceException;
	
	/**
	 * 查找学生购买课件分页信息
	 * @param siId
	 * @param appPageNo
	 * @param appPageSize
	 * @return
	 * @throws ServiceException TODO
	 */
	PagerVO findBuyCourseware(Long siId, Integer appPageNo, Integer appPageSize) throws ServiceException;
	
	
	boolean findExistMobile(String mobile) throws ServiceException;

	/**
	 * 
	 * @param siId 学生ID
	 * @param headShortPic 头像图片
	 * @param headShortPicFileName  头像图片文件名
	 * @param headShortPicContentType 头像图片正文类型
	 * @param headShortPicCaption  头像图片标题
	 * @param nickname 昵称
	 * @param sex 性别
	 * @param grade 年级
	 * @param qq   QQ
	 * @param weixin 微信
	 * @param weibo  微博
	 * @param qqEmpty QQ是否空
	 * @param weixinEmpty  微信是否空
	 * @param weiboEmpty   微博是否空
	 * @return
	 * @throws ServiceException TODO
	 */
	Map<String, Object> updateStudent(Long siId, File headShortPic, String headShortPicFileName, String headShortPicContentType,
			String headShortPicCaption, String nickname, String sex, String grade, String qq, String weixin,
			String weibo, Boolean qqEmpty, Boolean weixinEmpty, Boolean weiboEmpty) throws ServiceException;
	
	
}
