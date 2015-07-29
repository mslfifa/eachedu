package com.eachedu.service;

import java.util.List;
import java.util.Map;

import com.eachedu.dao.pojo.TeacherInfo;
import com.eachedu.exception.ServiceException;
import com.eachedu.web.vo.PagerVO;

public interface TeacherInfoService extends BaseService<TeacherInfo, Long> {
	List<TeacherInfo> findTeacherFromLogin(String username,String password) throws ServiceException;

	TeacherInfo findByMobile(String mobile, String password)throws ServiceException;

	Map<String, Object> findBySns(String qq, String weixin, String weibo)throws ServiceException;

	/**
	 * 手机号对应的老师是否存在
	 * @param mobile
	 * @return
	 * @throws ServiceException
	 */
	boolean findExistByMobile(String mobile)throws ServiceException;

	/**
	 * 查找老师分页列表 年级与课都是可选的
	 * @param name TODO
	 * @param grade
	 * @param course
	 * @param appPageNo
	 * @param appPageSize
	 * @return TODO
	 * @throws ServiceException
	 *//*
	PagerVO findTeacherPage(String name, String grade, String course, Integer appPageNo, Integer appPageSize)throws ServiceException;*/
	
	/**
	 * 查找答题最多前几名的老师列表
	 * @param topNum
	 * @return
	 * @throws ServiceException
	 */

	List<Map<String,Object>> findTopAnswerTeachers(int topNum)throws ServiceException;
	
	/**
	 * 查找对老师最近的评论 包括 comment_num:老师总被评论数  teacher_info:老师信息 comment_relate_info:评论及评论者信息 三块数据结构分别放在不同的key  
	 * @param tiId
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> findTeacherRecentComment(Long tiId) throws ServiceException;
	
	/**
	 * 查找全部关于指定老师的评论
	 * @param tiId
	 * @return
	 * @throws ServiceException
	 */
	List<Map<String, Object>> findTeacherComments(Long tiId) throws ServiceException;
	
	/**
	 * 根据老师名字关键字查找老师信息
	 * @param name 老师名字 模糊匹配
	 * @param grade TODO
	 * @param course TODO
	 * @param appPageNo TODO
	 * @param appPageSize TODO
	 * @return
	 * @throws ServiceException
	 */
	PagerVO findTeacherPage(String name, String grade, String course, Integer appPageNo, Integer appPageSize) throws ServiceException;
	
	/**
	 * 查找老师擅长的年级课程
	 * @param tiId
	 * @return
	 * @throws ServiceException
	 */
	List<Map<String,Object>> findTeacherExper(Long tiId)throws ServiceException;
}
