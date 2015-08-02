package com.eachedu.app.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dict.QuestionStatus;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.CoursewareInfoService;
import com.eachedu.service.QuestionInfoService;
import com.eachedu.service.TeacherInfoService;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.PagerVO;


@Controller("visitAppAction")
@Scope("prototype")
public class VisitAppAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(VisitAppAction.class);
	
	
	private Integer appPageNo;
	private Integer appPageSize;
	private String name;
	private String grade;
	private String course;
	//课件搜索关键字
	private String courseTitle;
	private Long tiId;
	private String orderField;
	private String orderDirect;
	
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirect() {
		return orderDirect;
	}

	public void setOrderDirect(String orderDirect) {
		this.orderDirect = orderDirect;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}



	@Resource(name="teacherInfoService")
	private TeacherInfoService teacherInfoService;
	
	@Resource(name="questionInfoService")
	private QuestionInfoService questionInfoService;
	
	@Resource(name="coursewareInfoService")
	private CoursewareInfoService coursewareInfoService;
	
	/**
	 * 查询老师主页
	 */
	public void findTeacherPage(){
		/*Map<String,Object> result = new HashMap<String,Object>();
		try {
			PagerVO page = teacherInfoService.findTeacherPage(name,grade,course,appPageNo,appPageSize);
			result.put("data", page.getDatas());
			result.put("http_status", true);
			result.put("http_msg", "查询分页成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("http_status", false);
			result.put("http_msg", "查询分页失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);*/
		
		
		
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			log.debug("@@@@ param -> name:"+name +"|grade:"+grade+"|course:"+course);
			PagerVO page = teacherInfoService.findTeacherPage(name,grade,course, appPageNo, appPageSize);
			result.put("data", page);
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
	
	/**
	 * 学生 我的提问 名师推荐
	 */
	public void findTeacherRecommend(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Long countNum = questionInfoService.findQuestionedByStatus(QuestionStatus.SOLVED.name());
			log.debug("@@@@@ countNum:"+countNum);
			result.put("countNum", countNum);
			
			List<Map<String, Object>> teachers = teacherInfoService.findTopAnswerTeachers(4);
			result.put("teachers", teachers);
			
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg",  "查找失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
	
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
			result.clear();
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
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "查询分页失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
		
	}
	
	public void findCoursewarePage(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			PagerVO page = coursewareInfoService.findCoursewarePage(appPageNo, appPageSize, null, courseTitle, course, grade, orderField, orderDirect);
			result.put("data", page);
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
