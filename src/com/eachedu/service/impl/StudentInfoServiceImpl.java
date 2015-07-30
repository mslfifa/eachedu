package com.eachedu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.StudentInfoService;
@Service("studentInfoService")
public class StudentInfoServiceImpl extends BaseServiceImpl<StudentInfo, Long>implements StudentInfoService {
	
	private static final Logger log = LoggerFactory.getLogger(StudentInfoServiceImpl.class);
	
	@Resource(name="studentInfoDao")
	@Override
	public void setDao(BaseDao<StudentInfo, Long> dao) {
		this.dao=dao;
	}

	@Override
	public List<StudentInfo> findStudentFromLogin(String username, String password) throws ServiceException {
		try {
			
			if(StringUtils.isEmpty(username)){
				throw new Exception("用户不能为空");
			}
			
			if (StringUtils.isEmpty(password)) {
				throw new Exception("密码不能为空");
			}
			
			StringBuffer hql = new StringBuffer(100);
			List param = new ArrayList();
			hql.append("from StudentInfo where 1=1 ");
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
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public Map<String, Object> findByMobile(String mobile, String password) throws ServiceException {
		try {
			
			if(StringUtils.isEmpty(mobile)){
				throw new Exception("手机号不能为空");
			}
			
			if (StringUtils.isEmpty(password)) {
				throw new Exception("密码不能为空");
			}
			
			StringBuffer sql =new StringBuffer(300);
			
			sql .append(" SELECT                                ")
				.append("   si_id,account,nickname              ")
				.append("   ,'STUDENT_TYPE' AS account_type     ")
				.append("   ,grade,NAME,sex,mobile              ")
				.append("   ,qq,weixin,weibo,ri.remote_url      ")
				.append(" FROM student_info si                  ")
				.append("   LEFT JOIN resource_info ri          ")
				.append("     ON si.head_short_id=ri.ri_id      ")
				.append(" WHERE 1=1 AND mobile=? AND PASSWORD=? ");
			List list = dao.findBySQL(sql.toString(), mobile,password);
			if(list!=null && !list.isEmpty()){
				return (Map<String, Object>) list.get(0);
			}else{
				throw new Exception("查不到手机号["+mobile+"]的学生账号");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public boolean findExistByMobile(String mobile) throws ServiceException {
		try {
			
			if(StringUtils.isEmpty(mobile)){
				throw new Exception("手机号不能为空");
			}
			
			String hql = "from StudentInfo where mobile = ? ";
			List list = dao.findByHql(hql, mobile);
			StudentInfo s = null;
			if(list!=null && !list.isEmpty()){
				s = (StudentInfo) list.get(0);
			}
			
			return s!=null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public Map<String,Object> findBySns(String qq, String weixin, String weibo) throws ServiceException {
		try {
			
			if(StringUtils.isEmpty(qq) && StringUtils.isEmpty(weixin) && StringUtils.isEmpty(weibo)){
				throw new Exception("第三方账号不能为空");
			}
			
			StringBuffer sql = new StringBuffer(300);

			List param = new ArrayList();
			sql .append(" SELECT                            ")
				.append("   si_id,account,nickname,sex      ")
				.append("   ,'STUDENT_TYPE' AS account_type ")
				.append("   ,weibo,qq,weixin,grade          ")
				.append("   ,ri.remote_url,mobile           ")
				.append(" FROM student_info si              ")
				.append("  LEFT JOIN resource_info ri       ")
				.append("    ON si.head_short_id=ri.ri_id   ")
				.append(" WHERE 1=2                         ");
			if(StringUtils.isNotEmpty(qq)){
				sql.append(" or qq = ? ");
				param.add(qq);
			}
			if(StringUtils.isEmpty(weixin)){
				sql.append(" or weixin = ? ");
				param.add(weixin);
			}
			if (StringUtils.isNotEmpty(weibo)) {
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
	public void updatePwd(String mobile, String password) throws ServiceException {
		try {
			
			if(StringUtils.isEmpty(mobile)){
				throw new Exception("手机号不能为空");
			}
			
			if (StringUtils.isEmpty(password)) {
				throw new Exception("密码不能为空");
			}
			
			String hql = "from StudentInfo where mobile = ? ";
			List list = dao.findByHql(hql, mobile);
			StudentInfo s = null;
			if(list!=null && !list.isEmpty()){
				s = (StudentInfo) list.get(0);
			}else{
				throw new Exception("找不到手机号为["+mobile+"]");
			}
			
			s.setPassword(password);
			s.setCreateTime(new Date());
			dao.update(s);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

}
