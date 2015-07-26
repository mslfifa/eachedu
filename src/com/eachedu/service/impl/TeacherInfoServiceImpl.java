package com.eachedu.service.impl;

import java.util.ArrayList;
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
	public TeacherInfo findByMobile(String mobile, String password) throws ServiceException {
		try {
			String hql = "from TeacherInfo where mobile=? and password = ? ";
			List list = dao.findByHql(hql, mobile,password);
			if(list!=null && !password.isEmpty()){
				return (TeacherInfo) list.get(0);
			}else{
				throw new Exception("没有找到手机号["+mobile+"]的老师");
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		} 
	}

	@Override
	public TeacherInfo findBySns(String qq, String weixin, String weibo) throws ServiceException {
		
		try {
			StringBuffer hql = new StringBuffer(100);
			List param = new ArrayList();
			hql.append("from TeacherInfo where 1=0 ");
			if(StringUtils.isNotEmpty(qq)){
				hql.append(" or qq = ? ");
				param.add(qq);
			}
			if(StringUtils.isEmpty(weixin)){
				hql.append(" or weixin = ? ");
				param.add(weixin);
			}
			if(StringUtils.isNotEmpty(weibo)){
				hql.append(" or weibo = ? ");
				param.add("weibo");
			}
			List list = dao.findByHql(hql.toString(), param.toArray(new Object[0]));
			
			TeacherInfo t = null;
			if(list!=null && !list.isEmpty()){
				t = (TeacherInfo) list.get(0);
			}
			return t;
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
			sql .append(" SELECT                                          ")
				.append("   ti.ti_id,  account,  password,  status,       ")
				.append("   NAME,  nickname,  sex,  identification_card,  ")
				.append("   school,  authentication_type,  head_short_id, ")
				.append("   certificate_id,  weixin,  qq,  weibo,  mobile,")
				.append("   email,  tag_id1,  tag_title1,  tag_id2,       ")
				.append("   tag_title2,  tag_id3,  tag_title3,  tag_id4,  ")
				.append("   tag_title4,  tag_id5,  tag_title5,  tag_id6,  ")
				.append("   tag_title6,  create_time                      ")
				.append(" FROM teacher_info ti JOIN                       ")
				.append(" (                                               ")
				.append("   SELECT                                        ")
				.append("     ta.ti_id,COUNT(1) AS total_num              ")
				.append("   FROM teacher_answer ta                        ")
				.append("   GROUP BY ta.ti_id                             ")
				.append("   ORDER BY total_num DESC                       ")
				.append("   LIMIT 0, "+topNum+"                           ")
				.append(" ) t_t ON t_t.ti_id=ti.ti_id                     ")
				.append(" ORDER BY t_t.total_num DESC                     ");
			return dao.findBySQL(sql.toString());
		} catch (DaoException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public PagerVO findTeacherPage(String grade, String course, Integer appPageNo,
			Integer appPageSize) throws ServiceException {
		try {
			StringBuffer sql = new StringBuffer(400);
			List param = new ArrayList();
			sql .append(" SELECT ti.ti_id,account,password,status        ")            
				.append("   ,NAME,nickname,sex,identification_card       ")            
				.append("   ,school,authentication_type,is_certificated  ")            
				.append("   ,head_short_id,certificate_id,weixin,qq      ")            
				.append("   ,weibo,mobile,email,tag_id1,tag_title1       ")            
				.append("   ,tag_id2,tag_title2,tag_id3,tag_title3       ")            
				.append("   ,tag_id4,tag_title4,tag_id5,tag_title5       ")            
				.append("   ,tag_id6,tag_title6,ti.create_time,tag_1     ")            
				.append("   ,tag_2,tag_3,tag_4,tag_5,tag_6               ")            
				.append(" FROM teacher_info ti JOIN                      ")            
				.append(" (                                              ")            
				.append("   SELECT te.`ti_id`                            ")            
				.append("   FROM teacher_expert te                       ")            
				.append("     JOIN grade_course_info gci                 ")            
				.append("       ON te.`gci_id`=gci.`gci_id`              ")            
				.append("   WHERE 1=1                                    ");
				
			if(StringUtils.isNotEmpty(course)){
				sql.append("  AND gci.`course`= ? ");
				param.add(course);
			}
			if (StringUtils.isNotEmpty(grade)) {
				sql.append("  AND gci.`grade`= ? ");
				param.add(grade);
			}
			sql.append("   GROUP BY te.`ti_id` ") 
			   .append(" ) t_t ")
			   .append(" ON ti.`ti_id`=t_t.ti_id ");
			
			int offset=appPageNo==0?0:(appPageNo-1)*appPageSize;
			return dao.findBySqlPage(sql.toString(), offset, appPageSize, param.toArray(new Object[0]));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public Map<String, Object> findTeacherRecentComment(Long tiId) throws ServiceException {
		
		try {
			
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
			
			//老师信息 teacher_info
			TeacherInfo t = dao.get(tiId);
			result.put("teacher_info", t);
			
			
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
	public List<Map<String, Object>> findTeacherByKeyword(String name, String grade, String course) throws ServiceException {
		try {
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
				sql.append("  AND NAME LIKE ? ");
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
			
			List<Map<String, Object>> list = dao.findBySQL(sql.toString(), param.toArray(new Object[0]));
			log.debug("$$$$ 搜索完老师集合"+(list==null?0:list.size()));
			
			if(list!=null && !list.isEmpty()){
				
				//为每位老师添加课程集合  年级集合  复合结构
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					Map<String, Object> teacherMap = (Map<String, Object>) iterator.next();
					
					Long tiId = Long.parseLong(teacherMap.get("ti_id").toString());
					
					StringBuffer courseSql = new StringBuffer(300);
					courseSql   .append(" SELECT                         ") 
								.append("   DISTINCT gci.course          ") 
								.append(" FROM `teacher_expert` te       ") 
								.append("   JOIN `grade_course_info` gci ") 
								.append("     ON te.gci_id=gci.gci_id    ") 
								.append(" WHERE  te.ti_id = ?            ");
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
					gradeSql.append(" SELECT                         ")
							.append("   DISTINCT gci.grade           ")
							.append(" FROM `teacher_expert` te       ")
							.append("   JOIN `grade_course_info` gci ")
							.append("     ON te.gci_id=gci.gci_id    ")
							.append(" WHERE  te.ti_id = ?            ");
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
			
			return list;
			
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


}
