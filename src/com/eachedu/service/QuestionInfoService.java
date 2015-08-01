package com.eachedu.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eachedu.dao.pojo.QuestionInfo;
import com.eachedu.exception.ServiceException;
import com.eachedu.web.vo.PagerVO;

public interface QuestionInfoService extends BaseService<QuestionInfo, Long> {
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

	
	/**
	 * 事务管理问题信息与问题图片资源的保存
	 * @param siId 当前提问的学生ID
	 * @param askMobile 提问手机
	 * @param grade 年级
	 * @param course 课程
	 * @param communicateWay 沟通方式
	 * @param questionDesc 补充描述
	 * @param askPic 问题图片
	 * @param askPicFileName 问题图片文件名
	 * @param askPicContentType html 正文类型
	 * @param askPicCaption 标题
	 * @param tiId 老师ID 可选
	 * @param prise 费用
	 * @param bonus 赏金
	 * @return TODO
	 * @throws ServiceException TODO
	 */
	public Map<String, Object> saveAsk(Long siId, String askMobile, String grade, String course, String communicateWay,
			String questionDesc, File askPic, String askPicFileName, String askPicContentType, String askPicCaption, Long tiId, BigDecimal prise, BigDecimal bonus) throws ServiceException;
	
	
	
	
	
}
