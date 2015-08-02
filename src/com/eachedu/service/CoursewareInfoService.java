package com.eachedu.service;

import com.eachedu.dao.pojo.CoursewareInfo;
import com.eachedu.exception.ServiceException;
import com.eachedu.web.vo.PagerVO;

public interface CoursewareInfoService extends BaseService<CoursewareInfo, Long> {
	
	/**
	 * 
	 * @param appPageNo  页序号
	 * @param appPageSize 页大小
	 * @param userId  当前用户ID
	 * @param courseTitle 课件标题
	 * @param course 课程
	 * @param grade  年级
	 * @param orderField 排序字段 
	 * @param orderDirect TODO 排序方向 升序:ASC   降序:DESC
	 * @return
	 * @throws ServiceException
	 */
	public PagerVO findCoursewarePage(Integer appPageNo, Integer appPageSize, Long userId, String courseTitle, String course, String grade, String orderField, String orderDirect) throws ServiceException;

	/**
	 * 通过年级 课程查找课件信息
	 * @param grade 年级
	 * @param course 课程
	 * @return
	 * @throws ServiceException TODO
	 */
	public Long findByGradeCourse(String grade, String course) throws ServiceException;
}
