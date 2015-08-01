package com.eachedu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.AnswerComment;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.AnswerCommentService;
@Service("answerCommentService")
public class AnswerCommentServiceImpl extends BaseServiceImpl<AnswerComment, Long> implements AnswerCommentService{
	private static final Logger log = LoggerFactory.getLogger(AnswerCommentServiceImpl.class);
	
	@Resource(name="answerCommentDao")
	@Override
	public void setDao(BaseDao<AnswerComment, Long> dao) {
		this.dao=dao;
	}

	
	@Override
	public Long addComment(Long qiId, Integer score, String remark) throws ServiceException {
		try {
			log.debug("@@@@@ para-> qiId:"+qiId+"|score:"+score+"|remark:"+remark);
			if(qiId==null){
				throw new Exception("订单号不能为空");
			}
			if(score==null){
				throw new Exception("评分不能为空");
			}
			if(score<1||score>5){
				throw new Exception("评分只能在[1-5]范围内");
			}
			
			String hql = "from AnswerComment where qiId = ? ";
			List list = dao.findByHql(hql, qiId);
			// 如果以前评论过就出错
			if(list!=null && !list.isEmpty()){
				throw new Exception("订单号已经评论过了,不能重复评论!");
			}
			
			AnswerComment comment = new AnswerComment();
			comment.setQiId(qiId);
			comment.setRemark(remark);
			comment.setCommentTime(new Date());
			dao.save(comment);
			return comment.getAcId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
		
	}
	
}
