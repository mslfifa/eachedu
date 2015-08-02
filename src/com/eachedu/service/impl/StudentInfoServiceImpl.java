package com.eachedu.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.ResourceInfoDao;
import com.eachedu.dao.pojo.ResourceInfo;
import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.dict.ResourceType;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.StudentInfoService;
import com.eachedu.utils.PropUtils;
import com.eachedu.web.vo.PagerVO;
@Service("studentInfoService")
public class StudentInfoServiceImpl extends BaseServiceImpl<StudentInfo, Long>implements StudentInfoService {
	
	private static final Logger log = LoggerFactory.getLogger(StudentInfoServiceImpl.class);
	
	@Resource(name="resourceInfoDao")
	private ResourceInfoDao resourceInfoDao;
	
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
			sql .append(" SELECT si_id,account,nickname,sex ")
				.append("   ,'STUDENT_TYPE' AS account_type ")
				.append("   ,weibo,qq,weixin,grade          ")
				.append("   ,ri.remote_url,mobile,ri.ri_id  ")
				.append(" FROM student_info si              ")
				.append("  LEFT JOIN resource_info ri       ")
				.append("    ON si.head_short_id=ri.ri_id   ")
				.append(" WHERE 1=2                         ");
			if(StringUtils.isNotEmpty(qq)){
				sql.append(" or qq = ? ");
				param.add(qq);
			}
			if(StringUtils.isNotEmpty(weixin)){
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
				return new HashMap<String,Object>();
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

	@Override
	public Map<String, Object> findUserInfo(Long siId) throws ServiceException {
		try {
			if(siId==null){
				throw new Exception("学生ID不能为空");
			}
			
			StringBuffer userSql = new StringBuffer(300);
			userSql .append(" SELECT si_id,nickname       ")
					.append("   ,sex,grade,mobile         ")
					.append("   ,ri.ri_id,ri.remote_url   ")
					.append(" FROM student_info si        ")
					.append("   LEFT JOIN resource_info ri ")
					.append("     ON si.head_short_id=ri.ri_id ")
					.append(" WHERE si_id=?  ");
			List users = dao.findBySQL(userSql.toString(), siId);
			Map<String, Object> uMap = null;
			if(users!=null && !users.isEmpty()){
				uMap = (Map<String,Object>) users.get(0);
			}else{
				throw new Exception("找不到ID["+siId+"]的学生");
			}
			
			
			//查消息条数
			StringBuffer msgSql = new StringBuffer(300);
			msgSql .append(" SELECT                ")
					.append("   COUNT(1) AS msg_num ")
					.append(" FROM message_notice   ")
					.append(" WHERE account_id = ?  ")
					.append("   AND account_type='STUDENT_TYPE' ");
			List<Map<String, Object>> msgs = dao.findBySQL(msgSql.toString(), siId);
			Integer msgNum = null;
			if(msgs!=null && !msgs.isEmpty()){
				Map<String, Object> msgMap = msgs.get(0);
				msgNum = Integer.parseInt(""+msgMap.get("msg_num"));
			}
			uMap.put("msg_num", msgNum);
			
			return uMap;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public PagerVO findBuyCourseware(Long siId, Integer appPageNo, Integer appPageSize) throws ServiceException {
		try {
			appPageSize = appPageSize==null?10:appPageSize;
			int appOffset = (appPageNo==null||appPageNo<=0)?0:(appPageNo-1)*appPageSize;
			
			if(siId==null){
				throw new Exception("学生ID不能为空");
			}
			
			
			
			StringBuffer sql = new StringBuffer();
			sql .append(" SELECT ci_id,file_id,ci.prise          ")
				.append("   ,courseware_title,introduce          ")
				.append("   ,gci.grade,gci.course                ")
				.append("   ,ri.ri_id,ri.resource_size           ")
				.append("   ,(                                   ")
				.append("      SELECT                            ")
				.append("        COUNT(cd.ci_id) AS down_num     ")
				.append("      FROM courseware_down cd           ")
				.append("      WHERE cd.ci_id=ci.ci_id           ")
				.append("      GROUP BY cd.ci_id                 ")
				.append("    ) AS down_num                       ")
				.append("    ,oi.order_no,oi.create_time         ")
				.append(" FROM courseware_info ci                ")
				.append("   JOIN order_info oi                   ")
				.append("     ON oi.bus_id=ci.ci_id              ")
				.append("       AND oi.order_type='DOWNLOAD_PAY' ")
				.append("   JOIN grade_course_info gci           ")
				.append("     ON ci.gci_id=gci.gci_id            ")
				.append("   JOIN resource_info ri                ")
				.append("     ON ri.ri_id=ci.file_id             ")
				.append(" WHERE oi.account_type='STUDENT_TYPE'   ")
				.append("   AND oi.buyer_id = ?                  ");
;
			
			PagerVO page = dao.findBySqlPage(sql.toString(), appOffset, appPageSize, siId);
			return page;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public boolean findExistMobile(String mobile) throws ServiceException {
		
		try {
			boolean flag = false;
			log.debug("@@@@ mobile:"+mobile);
			if (StringUtils.isEmpty(mobile)) {
				throw new Exception("电话号码不能为空!");
			}
			String sql = "select mobile from student_info where mobile = ? ";
			List<Map<String, Object>> list = dao.findBySQL(sql, mobile);
			flag = (list!=null && !list.isEmpty());
			log.debug("$$$$ exist by mobile["+mobile+"]:"+flag);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public boolean updateStudent(Long siId, File headShortPic, String headShortPicFileName,
			String headShortPicContentType, String headShortPicCaption, String nickname, String sex, String grade,
			String qq, String weixin, String weibo, Boolean qqEmpty, Boolean weixinEmpty, Boolean weiboEmpty) throws ServiceException {
		try {
			
			log.debug("$$$$ para -> siId:"+siId+"|headShortPic:"+headShortPic+"|headShortPicFileName:"+headShortPicFileName+"|headShortPicContentType:"+headShortPicContentType
					+"|headShortPicCaption:"+headShortPicCaption+"|nickname:"+nickname+"|sex:"+sex+"|grade:"+grade+"|qq:"+qq+"|weixin:"+weixin+"|qqEmpty:"+qqEmpty
					+"|weixinEmpty:"+weixinEmpty+"|weiboEmpty:"+weiboEmpty);
			
			if(siId==null){
				throw new Exception("学生ID不能为空!");
			}
			
			Long newRiId = null;
			
			if(headShortPic!=null){
				String relativeDir =PropUtils.get("dir_head_short_pic");
				String resourceRealName = UUID.randomUUID().toString();
				//如果有后缀名，追加到新文件名后
				if(headShortPicFileName.lastIndexOf(".")!=-1);{
					resourceRealName+=headShortPicFileName.substring(headShortPicFileName.lastIndexOf("."), headShortPicFileName.length());
				}
				
				
				//写文件
				String filePath = PropUtils.get("dir_upload_root")+"/"+relativeDir+"/"+resourceRealName;
				File file = new File(filePath);
				if(!file.getParentFile().exists()){
					boolean f = file.getParentFile().mkdirs();
					log.debug("### 目录生成:"+f+" |path:"+file.getParentFile().getPath());
				}
				FileUtils.copyFile(headShortPic, file);
				log.info("@@@@ 写文件成功");
				
				
				//保存资源
				ResourceInfo r = new ResourceInfo();
				FileInputStream fis = new FileInputStream(headShortPic);
				r.setResourceSize(fis.available());
				
				r.setRelativeDir(relativeDir);
				r.setResourceType(ResourceType.HEAD_SHORT_TYPE.name());
				r.setContentType(headShortPicContentType);
				
				headShortPicFileName = StringUtils.isEmpty(headShortPicFileName)?headShortPic.getName():headShortPicFileName;
				r.setResouceOriginName(headShortPicFileName);
				
				log.debug("@@@@ resourceRealName:"+resourceRealName);
				r.setResourceRealName(resourceRealName);
				r.setCreateTime(new Date());
				//保存资源信息 
				resourceInfoDao.save(r);
				
				newRiId = r.getRiId();
				log.debug("$$$$ 保存资源对象成功");
			}
			
			
			
			
			StudentInfo student = dao.get(siId);
			//如果保存资源成功后
			if(newRiId!=null){
				student.setHeadShortId(newRiId);
			}
			
			if(StringUtils.isNotEmpty(sex)){
				student.setSex(sex);
			}
			
			if(StringUtils.isNotEmpty(nickname)){
				student.setNickname(nickname);
			}
			
			if (StringUtils.isNotEmpty(grade)) {
				student.setGrade(grade);
			}
			
			
			if(qqEmpty){
				student.setQq(null);
			}else if(StringUtils.isNotEmpty(qq)){
				student.setQq(qq);
			}
			
			if(weiboEmpty){
				student.setWeibo(null);
			}else if (StringUtils.isNotEmpty(weibo)) {
				student.setWeibo(weibo);
			}
			
			if (weixinEmpty) {
				student.setWeixin(null);
			}else if (StringUtils.isNotEmpty(weixin)) {
				student.setWeixin(weixin);
			}
			dao.update(student);
			log.info("#### 修改学生成功!");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

}
