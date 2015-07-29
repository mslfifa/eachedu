package com.eachedu.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public PagerVO findCoursewarePage(Integer pageNo, Integer pageSize, String course, String grade, String orderField, String orderDirect) throws ServiceException {
		try {
			
			log.debug("$$$$ pageNo:"+pageNo+"|course:"+course+"|grade:"+grade+"|orderField:"+orderField+"|orderDirect:"+orderDirect);
			StringBuffer sql = new StringBuffer(400);
			List param = new ArrayList();
			
			pageNo = pageNo==null?0:pageNo;
			pageSize = pageSize==null?10:pageSize;
			int offset = pageNo==0?0:(pageNo-1)*pageSize;
			
			
			sql .append(" SELECT                             ")  
				.append("   ci.ci_id,file_id,prise           ")  
				.append("   ,introduce,course_title          ")  
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
			
			if(StringUtils.isNotEmpty(grade)){
				sql.append(" AND gci.grade = ? ") ;
				param.add(grade);
			}
			if(StringUtils.isNotEmpty(course)){
				sql.append(" AND gci.course = ? ");
				param.add(course);
			}
			
			if("down_num".equals(orderField)){
				sql.append(" ORDER BY t_d.down_num ");
			}else if ("course".equals(orderField)) {
				sql.append(" ORDER BY gci.course ");
			}else if ("prise".equals(orderField)) {
				sql.append(" ORDER BY ti.prise ");
			}else{
				sql.append(" ORDER BY ti.prise ");
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


	

	

}
