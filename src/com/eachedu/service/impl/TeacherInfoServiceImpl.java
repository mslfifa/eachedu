package com.eachedu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.app.actions.LoginAppAction;
import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.TeacherInfo;
import com.eachedu.exception.DaoException;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.TeacherInfoService;
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
	public void findTeacherPage(Integer appPageNo, Integer appPageSize) throws ServiceException {
		String hql = "select t from TeacherInfo t order by tiId desc ";
	}

	@Override
	public List<Map<String,Object>> findTopAnswerTeachers(int topNum) throws ServiceException {
		try {
			StringBuffer sql = new StringBuffer();
			sql .append(" SELECT                                          ")
				.append("   ti.ti_id,  account,  PASSWORD,  STATUS,       ")
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


}
