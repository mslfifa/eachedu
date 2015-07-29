package com.eachedu.app.actions;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.service.TeacherInfoService;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.PagerVO;
@Controller("teacherAppAction")
@Scope("prototype")
public class TeacherAppAction extends BaseAction{
	
	private static final Logger log = LoggerFactory.getLogger(TeacherAppAction.class);
	
	private Integer appPageNo;
	private Integer appPageSize;
	private String name;
	private String grade;
	private String course;
	private Long tiId;
	
	
	public Integer getAppPageNo() {
		return appPageNo;
	}

	public void setAppPageNo(Integer appPageNo) {
		this.appPageNo = appPageNo;
	}

	public Integer getAppPageSize() {
		return appPageSize;
	}

	public void setAppPageSize(Integer appPageSize) {
		this.appPageSize = appPageSize;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Long getTiId() {
		return tiId;
	}

	public void setTiId(Long tiId) {
		this.tiId = tiId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Resource(name="teacherInfoService")
	private TeacherInfoService teacherInfoService;
	
	
	
	/**
	 * 老师主页  老师被评论总数 老师信息  最近一次评论信息
	 */
	public void findTeacherRecentComment(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Map<String, Object> map = teacherInfoService.findTeacherRecentComment(tiId);
			result.put("data", map);
			result.put("http_status", true);
			result.put("http_msg", "查询分页成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("http_status", false);
			result.put("http_msg", "查询分页失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
	public void findTeacherComments(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = teacherInfoService.findTeacherComments(tiId);
			result.put("data", list);
			result.put("http_status", true);
			result.put("http_msg", "查询分页成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("http_status", false);
			result.put("http_msg", "查询分页失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
		
	}
	
	
}
