package com.eachedu.app.actions;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.service.AnswerCommentService;
import com.eachedu.web.actions.BaseAction;
/**
 * 评论action
 * @author Administrator
 *
 */
@Controller("answerCommentAppAction")
@Scope("prototype")
public class AnswerCommentAppAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(AnswerCommentAppAction.class);
	
	@Resource(name="answerCommentService")
	private AnswerCommentService answerCommentService;
	//订单号
	private Long qiId;
	//评分
	private Integer score;
	//备注
	private String remark;
	
	public Long getQiId() {
		return qiId;
	}
	public void setQiId(Long qiId) {
		this.qiId = qiId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	/**
	 * 学生对老师的回答进度评论打分
	 */
	public void comment(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			log.debug("@@@@@ para-> qiId:"+qiId+"|score:"+score+"|remark:"+remark);
			Long acId = answerCommentService.addComment(qiId, score, remark);
			result.put("acId", acId);
			result.put("http_status", true);
			result.put("http_msg", "查询分页成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "查询分页失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
}
