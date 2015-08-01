package com.eachedu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.CoursewareInfo;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.CoursewareInfoService;
import com.eachedu.web.vo.PagerVO;

@Service("coursewareInfoService")
public class CoursewareInfoServiceImpl extends BaseServiceImpl<CoursewareInfo,Long>implements CoursewareInfoService {
	
	private static final Logger log = LoggerFactory.getLogger(CoursewareInfoServiceImpl.class);
	
	@Resource(name="coursewareInfoDao")
	@Override
	public void setDao(BaseDao<CoursewareInfo, Long> dao) {
		this.dao=dao;
		
	}

	@Override
	public PagerVO findCoursewarePage(Integer pageNo, Integer pageSize, String courseTitle, String course, String grade, String orderField, String orderDirect) throws ServiceException {
		try {
			
			log.debug("$$$$ pageNo:"+pageNo+"|course:"+course+"|grade:"+grade+"|orderField:"+orderField+"|orderDirect:"+orderDirect);
			StringBuffer sql = new StringBuffer(400);
			List param = new ArrayList();
			
			pageNo = pageNo==null?0:pageNo;
			pageSize = pageSize==null?10:pageSize;
			int offset = pageNo==0?0:(pageNo-1)*pageSize;
			
			
			sql .append(" SELECT                             ")  
				.append("   ci.ci_id,file_id,prise           ")  
				.append("   ,introduce,courseware_title      ")  
				.append("   ,t_d.down_num                    ")  
				.append(" FROM courseware_info ci            ")  
				.append("   JOIN grade_course_info gci       ")  
				.append("     ON gci.gci_id=ci.gci_id        ")  
				.append("   LEFT JOIN                        ")  
				.append("   (                                ")  
				.append("     SELECT cd.ci_id                ")  
				.append("       ,COUNT(cd.ci_id) AS down_num ")  
				.append("     FROM  courseware_down cd       ")  
				.append("     GROUP BY cd.ci_id              ")  
				.append("   ) t_d                            ")  
				.append("     ON ci.ci_id=t_d.ci_id          ")  
				.append(" WHERE 1=1                          ");
			
			
			if(StringUtils.isNotEmpty(courseTitle)){
				sql.append(" AND ci.courseware_title LIKE ? ") ;
				param.add("%"+courseTitle+"%");
			}else{
				if(StringUtils.isNotEmpty(grade)){
					sql.append(" AND gci.grade = ? ") ;
					param.add(grade);
				}
				if(StringUtils.isNotEmpty(course)){
					sql.append(" AND gci.course = ? ");
					param.add(course);
				}
			}
			
			if("down_num".equals(orderField)){
				sql.append(" ORDER BY t_d.down_num ");
			}else if ("grade".equals(orderField)) {
				sql.append(" ORDER BY gci.grade ");
			}else if ("prise".equals(orderField)) {
				sql.append(" ORDER BY ci.prise ");
			}else{
				sql.append(" ORDER BY ci.prise ");
			}
			
			if("asc".equals(orderDirect)){
				sql.append(" ASC ");
			}else if("desc".equals(orderDirect)){
				sql.append(" DESC ");
			}else{
				sql.append(" DESC ");
			}
			
			return dao.findBySqlPage(sql.toString(), offset, pageSize, param.toArray(new Object[0]));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public Long findByGradeCourse(String grade, String course) throws ServiceException {
		
		try {
			
			log.debug("$$$$ grade:"+grade+"|course:"+course);
			
			Long ciId = null;
			if(StringUtils.isEmpty(grade)){
				throw new Exception("年级不能为空");
			}
			
			if(StringUtils.isEmpty(course)){
				throw new Exception("课程不能为空");
			}
			
			StringBuffer sql = new StringBuffer(200);
			sql .append(" SELECT gci_id          ")    
				.append(" FROM grade_course_info ")    
				.append(" WHERE grade = ?        ")    
				.append("   AND course = ?       ");
			List<Map<String, Object>> list = dao.findBySQL(sql.toString(), grade,course);
			if(list!=null && !list.isEmpty()){
				Map<String, Object> m = list.get(0);
				ciId = Long.parseLong(m.get("gci_id").toString());
			}else{
				throw new Exception("年级["+grade+"]课程["+course+"]对应没有课件信息,请与管理员联系");
			}
			return ciId;
			
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}


	

	

}
