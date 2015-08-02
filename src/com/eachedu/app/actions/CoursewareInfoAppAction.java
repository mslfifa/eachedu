package com.eachedu.app.actions;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.service.CoursewareInfoService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.PagerVO;
import com.eachedu.web.vo.UserVO;

@Controller("coursewareInfoAppAction")
@Scope("prototype")
public class CoursewareInfoAppAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(CoursewareInfoAppAction.class);
	
	@Resource(name="coursewareInfoService")
	private CoursewareInfoService coursewareInfoService;
	
	private Integer appPageNo;
	private Integer appPageSize;
	private String grade;
	private String course;
	//课件搜索关键字
	private String courseTitle;
	private String orderField;
	private String orderDirect;
	
	public CoursewareInfoService getCoursewareInfoService() {
		return coursewareInfoService;
	}
	public void setCoursewareInfoService(CoursewareInfoService coursewareInfoService) {
		this.coursewareInfoService = coursewareInfoService;
	}
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
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
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
	
	/**
	 * 分页查找课件列表
	 */
	public void findCoursewarePage(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			UserVO currentUser = (UserVO)ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
			
			if(currentUser.getId()==null){
				throw new Exception("当前用户没有ID,请联系管理员");
			}
			
			PagerVO page = coursewareInfoService.findCoursewarePage(appPageNo, appPageSize, currentUser.getId(), courseTitle, course, grade, orderField, orderDirect);
			result.put("page",page);
			result.put("http_status", true);
			result.put("http_msg", "查询分页成功!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "查询分页失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
}
