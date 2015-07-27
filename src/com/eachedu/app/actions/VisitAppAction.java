package com.eachedu.app.actions;

import java.util.HashMap;
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


@Controller("visitAppAction")
@Scope("prototype")
public class VisitAppAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(VisitAppAction.class);
	
	
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

	@Resource(name="teacherInfoService")
	private TeacherInfoService teacherInfoService;
	
	public void findTeacherPage(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			PagerVO page = teacherInfoService.findTeacherPage(grade,course,appPageNo,appPageSize);
			result.put("data", page.getDatas());
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
