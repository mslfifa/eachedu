package com.eachedu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.dao.pojo.TeacherInfo;
import com.eachedu.exception.DaoException;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.TeacherInfoService;
import com.eachedu.web.vo.PagerVO;
@Service("teacherInfoService")
public class TeacherInfoServiceImpl extends BaseServiceImpl<TeacherInfo, Long>implements TeacherInfoService {
	private static final Logger log = LoggerFactory.getLogger(TeacherInfoServiceImpl.class);
	@Resource(name="teacherInfoDao")
	@Override
	public void setDao(BaseDao<TeacherInfo, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

	@Override
	public List<TeacherInfo> findTeacherFromLogin(String username, String password) throws ServiceException {
		try {
			StringBuffer hql = new StringBuffer(100);
			List param = new ArrayList();
			hql.append("from TeacherInfo where 1=1 ");
			if(StringUtils.isNotEmpty(username)){
				hql.append(" and account = ? ");
				param.add(username);
			}
			
			if (StringUtils.isNotEmpty(password)) {
				hql.append(" and passWord = ? ");
				param.add(password);
			}
			return dao.findByHql(hql.toString(), param.toArray(new Object[0]));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public Map<String, Object> findByMobile(String mobile, String password) throws ServiceException {
		try {
			StringBuffer sql = new StringBuffer(300);
			
			sql .append(" SELECT                                ")
				.append("   ti_id,account,nickname              ")
				.append("   ,'TEACHER_TYPE' AS account_type     ")
				.append("   ,NAME,sex,mobile                    ")
				.append("   ,qq,weixin,weibo,ri.remote_url      ")
				.append(" FROM teacher_info ti                  ")
				.append("   LEFT JOIN resource_info ri          ")
				.append("     ON ti.head_short_id=ri.ri_id      ")
				.append(" WHERE 1=1 AND mobile=? AND PASSWORD=? ");
			
			List list = dao.findBySQL(sql.toString(), mobile,password);
			if(list!=null && !list.isEmpty()){
				return (Map<String, Object>) list.get(0);
			}else{
				throw new Exception("没有找到手机号["+mobile+"]的老师");
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		} 
	}

	@Override
	public Map<String, Object> findBySns(String qq, String weixin, String weibo) throws ServiceException {
		
		try {
			StringBuffer sql = new StringBuffer(300);
			List param = new ArrayList();
			sql .append(" SELECT                          ")
				.append("   ti_id,nickname,sex            ")
				.append("   ,weibo,qq,weixin              ")
				.append("   ,ri.remote_url                ")
				.append(" FROM teacher_info ti            ")
				.append("  LEFT JOIN resource_info ri     ")
				.append("    ON ri.ri_id=ti.head_short_id ")
				.append(" WHERE 1=2                       ");
			
			if(StringUtils.isNotEmpty(qq)){
				sql.append(" or qq = ? ");
				param.add(qq);
			}
			if(StringUtils.isEmpty(weixin)){
				sql.append(" or weixin = ? ");
				param.add(weixin);
			}
			if(StringUtils.isNotEmpty(weibo)){
				sql.append(" or weibo = ? ");
				param.add(weibo);
			}
			List list = dao.findBySQL(sql.toString(), param.toArray(new Object[0]));
			
			if(list!=null && !list.isEmpty()){
				return (Map<String, Object>) list.get(0);
			}else{
				return null; 
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
		
	}

	@Override
	public boolean findExistByMobile(String mobile) throws ServiceException {
		try {
			boolean flag = false;
			if(StringUtils.isEmpty(mobile)){
				throw new Exception("mobile不能为空!");
			}
			String hql = "from TeacherInfo where mobile = ? ";
			List list = dao.findByHql(hql, mobile);
			TeacherInfo t = null;
			if(list!=null && !list.isEmpty()){
				t=(TeacherInfo) list.get(0);
			}
			
			return t!=null;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	

	@Override
	public List<Map<String,Object>> findTopAnswerTeachers(int topNum) throws ServiceException {
		try {
			StringBuffer sql = new StringBuffer(400);
			sql .append(" SELECT                               ")          
				.append("   ti.ti_id,name                      ")          
				.append("   ,sex,ri.remote_url               ")          
				.append(" FROM teacher_info ti                 ")          
				.append("   LEFT JOIN resource_info ri         ")          
				.append("     ON ti.head_short_id=ri.ri_id     ")          
				.append("   LEFT JOIN                          ")          
				.append("   (                                  ")          
				.append("     SELECT                           ")          
				.append("       ta.ti_id,COUNT(1) AS total_num ")          
				.append("     FROM teacher_answer ta           ")          
				.append("     GROUP BY ta.ti_id                ")          
				.append("     ORDER BY total_num DESC          ")          
				.append("     LIMIT 0, "+topNum+"              ")          
				.append("   ) t_t ON t_t.ti_id=ti.ti_id        ")          
				.append(" ORDER BY t_t.total_num DESC          ");
			return dao.findBySQL(sql.toString());
		} catch (DaoException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	/*@Override
	public PagerVO findTeacherPage(String name, String grade, String course,
			Integer appPageNo, Integer appPageSize) throws ServiceException {
		try {
			//分页默认参数
			appPageNo=appPageNo==null?1:appPageNo;
			appPageSize=appPageSize==null?10:appPageSize;
			int offset=appPageNo==0?0:(appPageNo-1)*appPageSize;
			
			StringBuffer sql = new StringBuffer(400);
			List param = new ArrayList();
			
			
			sql .append(" SELECT ti.ti_id,authentication_type ")
				.append("   ,school,is_certificated,name      ")
				.append("   ,ri.remote_url,introduce          ")
				//计算每个老师的平均评分
				.append("   ,(SELECT ROUND(AVG(ac.score))     ")
				.append("     FROM answer_comment ac          ")
				.append("       JOIN teacher_answer ta        ")
				.append("         ON ta.order_id=ac.order_id  ")
				.append("     WHERE ta.ti_id=ti.ti_id         ")
				.append("     GROUP BY ta.ti_id               ")
				.append("     ) AS avg_score                  ")
				.append(" FROM teacher_info ti JOIN           ")
				.append(" (                                   ")
				.append("   SELECT te.ti_id                   ")
				.append("   FROM teacher_expert te            ")
				.append("     JOIN grade_course_info gci      ")
				.append("       ON te.gci_id=gci.gci_id       ")
				.append("   WHERE 1=1                         ");
			if(StringUtils.isNotEmpty(name)){
				sql.append(" ti.name like ? ");
				param.add("%"+name+"%");
			}
			if(StringUtils.isNotEmpty(course)){
			     sql.append(" AND gci.course= ? ");
				param.add(course);
			}
			if (StringUtils.isNotEmpty(grade)) {
			    sql.append(" AND gci.grade= ?  ");
				param.add(grade);
			}	
				
			sql	.append("   GROUP BY te.ti_id                 ")
				.append(" ) t_t                               ")
				.append("     ON ti.ti_id=t_t.ti_id           ")
				.append("   LEFT JOIN resource_info ri        ")
				.append("     ON ti.head_short_id=ri.ri_id    ");
				
			
			
			return dao.findBySqlPage(sql.toString(), offset, appPageSize, param.toArray(new Object[0]));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}*/

	@Override
	public Map<String, Object> findTeacherRecentComment(Long tiId) throws ServiceException {
		
		try {
			
			if(tiId==null){
				throw new Exception("老师ID不能为空,请联系管理员!");
			}
			
			Map<String,Object> result = new HashMap<String,Object>();
			
			
			//最近的一条评论 comment_relate_info
			StringBuffer lastCommentSql = new StringBuffer(400);
			lastCommentSql  .append(" SELECT                             ")
							.append("    si.nickname,si.head_short_id    ")
							.append("   ,score,ac.remark,ac.comment_time ")
							.append(" FROM answer_comment ac             ")
							.append("   JOIN question_offering qo        ")
							.append("     ON ac.order_id=qo.order_id     ")
							.append("   JOIN teacher_answer ta           ")
							.append("     ON ta.order_id=ac.order_id     ")
							.append("   JOIN student_info si             ")
							.append("     ON si.si_id=qo.si_id           ")
							.append(" WHERE ta.ti_id=?                   ")
							.append(" ORDER BY ac.comment_time DESC      ")
							.append(" LIMIT 0,1                          ");
			List<Map<String, Object>> lastCommentList = dao.findBySQL(lastCommentSql.toString(), tiId);
			if(lastCommentList!=null && !lastCommentList.isEmpty()){
				log.debug("### lastCommentList size:"+lastCommentList.size());
				result.put("comment_relate_info", lastCommentList.get(0));
			}else{
				log.debug("### lastCommentList size:0");
				result.put("comment_relate_info", null);
			}
			
			//总评论数  comment_num
			StringBuffer totalCommentSql = new StringBuffer(400);
			totalCommentSql .append(" SELECT ta.ti_id,COUNT(1) AS comment_num ")
							.append(" FROM answer_comment ac                  ")
							.append("   JOIN question_offering qo             ")
							.append("     ON ac.order_id=qo.order_id          ")
							.append("   JOIN teacher_answer ta                ")
							.append("     ON ta.order_id=ac.order_id          ")
							.append(" WHERE ta.ti_id=?                        ");
			
			List<Map<String, Object>> totalCommentList = dao.findBySQL(totalCommentSql.toString(), tiId);
			if(totalCommentList!=null && !totalCommentList.isEmpty()){
				Map<String, Object> tcRowMap = totalCommentList.get(0);
				Integer totalComment = Integer.parseInt(tcRowMap.get("comment_num").toString());
				result.put("comment_num", totalComment);
			}else{
				result.put("comment_num", 0);
			}
			
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
		
	}

	@Override
	public PagerVO findTeacherPage(String name, String grade, String course, Integer appPageNo, Integer appPageSize) throws ServiceException {
		try {
			log.debug("@@@@ para -> name:"+name+"|grade:"+grade+"|course:"+course+"|appPageNo:"+appPageNo+"|appPageSize:"+appPageSize);
			
			appPageNo = appPageNo==null?1:appPageNo;
			appPageSize = appPageSize==null?10:appPageSize;
			int pageoff = appPageNo<1?0:(appPageNo-1)*appPageSize;
			
			StringBuffer sql = new StringBuffer(400);
			List param = new ArrayList();
			
			sql .append(" SELECT                               ")
				.append("   ti_id,name,introduce               ")
				.append("   ,sex,is_certificated               ")
				.append("   ,school,head_short_id              ")
				.append("   ,tag_title1,tag_title2             ")
				.append("   ,tag_title3,tag_title4             ")
				.append("   ,tag_title5,tag_title6             ")
				.append(" FROM eachedu.teacher_info ti         ")
				.append(" WHERE 1=1                            ");
			if(StringUtils.isNotEmpty(name)){
				sql.append("  AND name LIKE ? ");
				param.add("%"+name+"%");
			}
			sql	.append("   AND EXISTS(                        ")
				.append("         SELECT 1                     ")
				.append("         FROM teacher_expert te       ")
				.append("           JOIN grade_course_info gci ")
				.append("             ON te.gci_id=gci.gci_id  ")
				.append("         WHERE te.ti_id = ti.ti_id    ");
			if(StringUtils.isNotEmpty(course)){
						sql.append(" AND gci.course=? ");
				param.add(course);
			}
			
			if(StringUtils.isNotEmpty(grade)){
						sql.append("  AND gci.grade = ? ");
				param.add(grade);
			}
			sql	.append("   ) "); 
			
			PagerVO page = dao.findBySqlPage(sql.toString(),pageoff,appPageSize, param.toArray(new Object[0]));
			List data = page.getDatas();
			log.debug("$$$$ 搜索完老师集合"+(data==null?0:data.size()));
			
			if(data!=null && !data.isEmpty()){
				
				//为每位老师添加课程集合  年级集合  复合结构
				for (Iterator iterator = data.iterator(); iterator.hasNext();) {
					Map<String, Object> teacherMap = (Map<String, Object>) iterator.next();
					
					Long tiId = Long.parseLong(teacherMap.get("ti_id").toString());
					
					StringBuffer courseSql = new StringBuffer(300);
					courseSql   .append(" SELECT                       ") 
								.append("   DISTINCT gci.course        ") 
								.append(" FROM teacher_expert te       ") 
								.append("   JOIN grade_course_info gci ") 
								.append("     ON te.gci_id=gci.gci_id  ") 
								.append(" WHERE  te.ti_id = ?          ");
					List<Map<String, Object>> courses = dao.findBySQL(courseSql.toString(), tiId);
					List<String> courseList = new ArrayList<String>();
					for (Iterator courseIr = courses.iterator(); courseIr.hasNext();) {
						Map<String, Object> map = (Map<String, Object>) courseIr.next();
						courseList.add((String) map.get("course"));
					}
					//加课程集合
					teacherMap.put("course_arr", courseList);
					log.debug("@@@ 添加课程集合:"+(courseList==null?0:courseList.size()));
					
					StringBuffer gradeSql = new StringBuffer(300);
					gradeSql.append(" SELECT                       ")
							.append("   DISTINCT gci.grade         ")
							.append(" FROM teacher_expert te       ")
							.append("   JOIN grade_course_info gci ")
							.append("     ON te.gci_id=gci.gci_id  ")
							.append(" WHERE  te.ti_id = ?          ");
					List<Map<String, Object>> grades = dao.findBySQL(gradeSql.toString(), tiId);
					List<String> gradeList = new ArrayList<String>();
					for (Iterator gradeIr = grades.iterator(); gradeIr.hasNext();) {
						Map<String, Object> map = (Map<String, Object>) gradeIr.next();
						gradeList.add((String) map.get("grade"));
						
					}
					//加年级集合
					teacherMap.put("grade_arr", gradeList);
					log.debug("@@@ 添加年级集合:"+(gradeList==null?0:gradeList.size()));
				}
			}
			
			return page;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public List<Map<String, Object>> findTeacherExper(Long tiId) throws ServiceException {
		try {
			StringBuffer sql = new StringBuffer(300);
			sql .append(" SELECT gci.grade,gci.course  ")
				.append(" FROM teacher_expert te       ")
				.append("   JOIN teacher_info ti       ")
				.append("     ON te.ti_id=ti.ti_id     ")
				.append("   JOIN grade_course_info gci ")
				.append("     ON te.gci_id=gci.gci_id  ")
				.append(" WHERE ti.ti_id = ?           ");
			
			return dao.findBySQL(sql.toString(), tiId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public List<Map<String, Object>> findTeacherComments(Long tiId) throws ServiceException {
		try {
			StringBuffer sql = new StringBuffer(300);
			sql .append(" SELECT ac_id,score              ")
				.append("   ,ac.remark,comment_time       ")
				.append("   ,si.nickname,si.head_short_id ")
				.append(" FROM answer_comment ac          ")
				.append("   JOIN question_offering qo     ")
				.append("     ON ac.order_id=qo.order_id  ")
				.append("   JOIN student_info si          ")
				.append("     ON si.si_id=qo.si_id        ")
				.append("   JOIN teacher_answer ta        ")
				.append("     ON ta.order_id=qo.order_id  ")
				.append(" WHERE ta.ti_id = ?              ")
				.append(" ORDER BY ac.comment_time DESC   ");

			return dao.findBySQL(sql.toString(), tiId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public void updatePwd(String mobile, String password) throws ServiceException {
		try {
			
			if(StringUtils.isEmpty(mobile)){
				throw new Exception("手机号不能为空");
			}
			
			if (StringUtils.isEmpty(password)) {
				throw new Exception("密码不能为空");
			}
			
			String hql = "from TeacherInfo where mobile = ? ";
			List list = dao.findByHql(hql, mobile);
			TeacherInfo t = null;
			if(list!=null && !list.isEmpty()){
				t = (TeacherInfo) list.get(0);
			}else{
				throw new Exception("找不到手机号为["+mobile+"]");
			}
			
			t.setPassword(password);
			t.setCreateTime(new Date());
			dao.update(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
		
	}


}
