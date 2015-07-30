package com.eachedu.service;

import java.util.List;
import java.util.Map;

import com.eachedu.dao.pojo.QuestionOffering;
import com.eachedu.exception.ServiceException;
import com.eachedu.web.vo.PagerVO;

public interface QuestionOfferingService extends BaseService<QuestionOffering, Long> {
	/**
	 * 查找指定状态的问题总数
	 * @param status
	 * @return
	 * @throws ServiceException
	 */
	public Long findQuestionedByStatus(String status) throws ServiceException;
	
	/**
	 * 分页查找学生所提过的问题集合，如果有回答的，将回答老师信息附带上
	 * @param siId TODO 学生ID
	 * @param pageNo TODO 页序号
	 * @param pageSize TODO 页大小
	 * @return
	 * @throws ServiceException
	 */
	public PagerVO findQuestionPageByStudent(Long siId, Integer pageNo, Integer pageSize) throws ServiceException;
	
	/**
	 * 查找根据订单流水号查找问题详细
	 * @param orderNo 订单号
	 * @return
	 * @throws ServiceException
	 */
	public List<Map<String,Object>> findQuetionByOrderNo(String orderNo) throws ServiceException;
	
}
