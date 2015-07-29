package com.eachedu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.QuestionOffering;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.QuestionOfferingService;
import com.eachedu.web.vo.PagerVO;
@Service("questionOfferingService")
public class QuestionOfferingServiceImpl extends BaseServiceImpl<QuestionOffering, Long>
		implements QuestionOfferingService {
	
	private static final Logger log = LoggerFactory.getLogger(QuestionOfferingServiceImpl.class);
	
	@Resource(name="questionOfferingDao")
	@Override
	public void setDao(BaseDao<QuestionOffering, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

	@Override
	public Long findQuestionedByStatus(String status) throws ServiceException {
		
		
		try {
			Long countNum = null;
			if(StringUtils.isEmpty(status)){
				throw new Exception("status不能为空");
			}
			String hql = "select count(*) as count_num from QuestionOffering where status = ? ";
			List list = dao.findByHql(hql, status);
			if(list!=null && !list.isEmpty()){
				countNum = (Long) list.get(0);
			}else{
				countNum = 0l;
			}
			return countNum;
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error(e.getMessage());
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public PagerVO findQuestionPageByStudent(Long siId, Integer pageNo, Integer pageSize) throws ServiceException {
		
		try {
			int offset = (pageNo==null ||pageNo==0)?0:(pageNo-1)*pageSize;
			pageSize = pageSize==null?20:pageSize;
			log.debug("@@@@ offset:"+offset+"|pagesize:"+pageSize+"|siId:"+siId);
			StringBuffer sql = new StringBuffer();
			sql .append(" SELECT qo.order_id,order_no,   ")
				.append("   question_desc,qo.pic_id,prise   ")
				.append("   ,ti.ti_id,ti.name,ti.school  ")
				.append("   ,ti.head_short_id            ")
				.append(" FROM question_offering qo      ")
				.append("   LEFT JOIN teacher_answer ta  ")
				.append("     ON qo.order_id=ta.order_id ")
				.append("   LEFT JOIN teacher_info ti    ")
				.append("     ON ti.ti_id=ta.ti_id       ")
				.append(" WHERE qo.si_id = ?             ")
				.append(" ORDER BY qo.ask_time DESC      ");
			
			return dao.findBySqlPage(sql.toString(),offset,pageSize, siId);
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error(e.getMessage());
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public List<Map<String, Object>> findQuetionByOrderNo(String orderNo) throws ServiceException {
		
		try {
			log.debug("#### orderNo:"+orderNo);
			StringBuffer sql = new StringBuffer(400);
			sql .append(" SELECT qo.order_id,qo.order_no        ")
				.append("   ,qo.question_desc,qo.prise,qo.bonus ")
				.append("   ,qo.pic_id AS question_pic_id       ")
				.append("   ,gci.course,gci.grade               ")
				.append("   ,ti.ti_id,ti.name                   ")
				.append("   ,ti.school,ti.head_short_id         ")
				.append("   ,ta.pic_id AS answer_pic_id         ")
				.append("   ,ta.`answer_content`                ")
				.append(" FROM question_offering qo             ")
				.append("   JOIN grade_course_info gci          ")
				.append("     ON qo.gci_id=gci.gci_id           ")
				.append("   LEFT JOIN teacher_answer ta         ")
				.append("     ON qo.order_id=ta.order_id        ")
				.append("   LEFT JOIN teacher_info ti           ")
				.append("     ON ta.ti_id=ti.ti_id              ")
				.append(" WHERE qo.order_no = ?                 ")
			    .append(" ORDER BY ta.answer_time desc          ");
			
			return dao.findBySQL(sql.toString(), orderNo);
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error(e.getMessage());
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

}
