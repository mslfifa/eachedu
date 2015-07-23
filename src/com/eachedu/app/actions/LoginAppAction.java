package com.eachedu.app.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dao.pojo.ResourceInfo;
import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.dao.pojo.TeacherInfo;
import com.eachedu.dict.AccountType;
import com.eachedu.dict.ResourceType;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.ResourceInfoSerivce;
import com.eachedu.service.StudentInfoService;
import com.eachedu.service.TeacherInfoService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.utils.PropUtils;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.UserVO;
@Controller("loginAppAction")
@Scope("prototype")
public class LoginAppAction extends BaseAction {
	
	Logger log = LoggerFactory.getLogger(LoginAppAction.class);
	
	private String mobile;
	private String password;
	private String accountType;
	private String qq;
	private String weixin;
	private String weibo;
	private String nickname;
	private String sex;
	private File headShort;
	//头像文件名
	private String headShortFileName;
	//头像文件类型
	private String headShortContentType;
	private String headShortCaption;
	//验证码，后台生成
	private String verifyCode;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public File getHeadShort() {
		return headShort;
	}
	public void setHeadShort(File headShort) {
		this.headShort = headShort;
	}
	public String getHeadShortFileName() {
		return headShortFileName;
	}
	public void setHeadShortFileName(String headShortFileName) {
		this.headShortFileName = headShortFileName;
	}
	public String getHeadShortContentType() {
		return headShortContentType;
	}
	public void setHeadShortContentType(String headShortContentType) {
		this.headShortContentType = headShortContentType;
	}

	public String getHeadShortCaption() {
		return headShortCaption;
	}
	public void setHeadShortCaption(String headShortCaption) {
		this.headShortCaption = headShortCaption;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}




	@Resource(name="studentInfoService")
	private StudentInfoService studentInfoService;
	@Resource(name="teacherInfoService")
	private TeacherInfoService teacherInfoService;
	@Resource(name="resourceInfoService")
	private ResourceInfoSerivce resourceInfoSerivce;
	
	/**
	 * 学生 / 老师(使用accountType来区分 ) 手机 密码登录
	 */
	public void loginByMobile(){
		log.debug("@@@ mobile:"+mobile+"|password:"+password);
		Map<String,Object> result = new HashMap<String,Object>();
		UserVO user = null;
		try {
			if (AccountType.STUDENT_TYPE.name().equals(accountType)) {
				StudentInfo s = studentInfoService.findByMobile(mobile, password);
				user = new UserVO();
				user = new UserVO();
				user.setId(s.getSiId());
				user.setAccount(s.getAccount());
				user.setAccountType(accountType);
				user.setEmail(s.getEmail());
				user.setMobile(s.getMobile());
				user.setName(s.getName());
				user.setQq(s.getQq());
				
				result.put("status", true);
				result.put("msg", "查询成功");
				result.put("id", s.getSiId());
				result.put("accountType", accountType);
				result.put("nickname", s.getNickname());
				result.put("headShortId", s.getHeadShortId());
				result.put("mobile", s.getMobile());
				result.put("email", s.getEmail());
				result.put("sex", s.getSex());
				result.put("account", s.getAccount());
			}else if (AccountType.TEACHER_TYPE.name().equals(accountType)) {
				TeacherInfo t = teacherInfoService.findByMobile(mobile, password);
				user = new UserVO();
				user.setId(t.getTiId());
				user.setAccount(t.getAccount());
				user.setAccountType(accountType);
				user.setEmail(t.getEmail());
				user.setMobile(t.getMobile());
				user.setName(t.getName());
				user.setQq(t.getQq());
				
				result.put("status", true);
				result.put("msg", "查询成功");
				result.put("id", t.getTiId());
				result.put("accountType", accountType);
				result.put("nickname", t.getNickname());
				result.put("headShortId", t.getHeadShortId());
				result.put("mobile", t.getMobile());
				result.put("email", t.getEmail());
				result.put("sex", t.getSex());
				result.put("account", t.getAccount());
			}else{
				throw new Exception("没有传入accountType,请联系管理员.");
			}
			//app登录用户信息保存到会话对象中
			ServletActionContext.getRequest().getSession().setAttribute(ConstUtils.USER_LOGIN, user);
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put("status", false);
			result.put("msg", "查询失败，错误["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
	
	public void getValidateCode(){
		log.debug("@@@ mobile:"+mobile);
		Map<String,Object> result = new HashMap<String,Object>();
		
		try {
			
			if(StringUtils.isNotEmpty(mobile)){
				boolean existFlag=true;
				
				if(AccountType.STUDENT_TYPE.name().equals(accountType)){
					existFlag = studentInfoService.findExistByMobile(mobile);
				}else if(AccountType.TEACHER_TYPE.name().equals(accountType)){
					existFlag = teacherInfoService.findExistByMobile(mobile);
				}else{
					throw new Exception("你所传的accountType["+accountType+"]不在系统识别范围内，请与管理员联系!");
				}
				
				if(!existFlag){
					throw new Exception("号码["+mobile+"]不是有效用户");
				}
			}
			
			result.put("status",true);
			result.put("msg","生成验证码成功!");
			String randomStr = new Random().nextInt(10000)+"0000";
			String tmpVerifyCode = (randomStr).substring(0, 4);
			result.put("verifyCode", tmpVerifyCode);
			ServletActionContext.getRequest().getSession().setAttribute(ConstUtils.LOGIN_VERIFY_CODE, tmpVerifyCode);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put("status",false);
			result.put("msg","生成验证码失败["+e.getMessage()+"]!");
		}
		
		this.ajaxWriteOutJSON(result);
	}
	
	
	/**
	 * 通过第三方社交APP登录
	 */
	public void loginBySns(){
		log.debug("@@@ mobile:"+mobile);
		Map<String,Object> result = new HashMap<String,Object>();
		
		try {
			//判断第三方账号对应的用户存在否，存在就登录并返回信息。
			if(AccountType.STUDENT_TYPE.name().equals(accountType)){
				StudentInfo sLogin = studentInfoService.findBySns(qq,weixin,weibo);
				if(sLogin!=null){
					result.put("status", true);
					result.put("msg", "登录成功!");
					result.put("id", sLogin.getSiId());
					result.put("nickname", sLogin.getNickname());
					result.put("sex", sLogin.getSex());
					result.put("accountType", accountType);
					result.put("headShortId", sLogin.getHeadShortId());
					this.ajaxWriteOutJSON(result);
					return;
				}
			}else if (AccountType.TEACHER_TYPE.name().equals(accountType)) {
				TeacherInfo tLogin = teacherInfoService.findBySns(qq,weixin,weibo);
				if(tLogin!=null){
					result.put("status", true);
					result.put("msg", "登录成功!");
					result.put("id", tLogin.getTiId());
					result.put("nickname", tLogin.getNickname());
					result.put("sex", tLogin.getSex());
					result.put("accountType", accountType);
					result.put("headShortId", tLogin.getHeadShortId());
					this.ajaxWriteOutJSON(result);
					return;
				}
				
			}else{
				throw new Exception("accountType["+accountType+"]不在值域范围内，请与管理员联系!");
			}
			
			
			ResourceInfo r = new ResourceInfo();
			r.setResouceOriginName(headShortFileName);
			
			
			//上传根目录
			String uploadDir = PropUtils.readProp("dir_upload_root");
			//相对目录
			String relativeDir = PropUtils.readProp("dir_head_short_pic");
			
			if(AccountType.STUDENT_TYPE.name().equals(accountType)){
				relativeDir+="/student";
				
			}else if (AccountType.TEACHER_TYPE.name().equals(accountType)) {
				relativeDir+="/teacher";
			}else{
				throw new Exception("accountType["+accountType+"]不在值域范围内，请与管理员联系!");
			}
			r.setResourceType(accountType);
			
			String uuidStr = UUID.randomUUID().toString();
			//物理文件名
			String realFileName = uuidStr+headShortFileName.substring(headShortFileName.indexOf("."), headShortFileName.length());
			log.debug("$$$$$ realFileName:"+realFileName);
			//物理文件绝对路径
			String descPath = uploadDir+"/"+relativeDir+"/"+realFileName;
			r.setRelativePath(relativeDir+"/"+realFileName);
			log.debug("##### descPath:"+descPath);
			File destFile = new File(descPath);
			File dir = destFile.getParentFile();
			if(!dir.exists()){
				dir.mkdirs();
			}
			if(!destFile.exists()){
				destFile.createNewFile();
			}
			FileInputStream fis = new FileInputStream(headShort);
			r.setResourceSize(fis.available());
			
			FileUtils.copyFile(headShort, destFile);
			log.info("@@@@ 头像文件保存成功!");
			result.put("status",true);
			result.put("msg","第三方登录成功!上传文件保存为:"+destFile.getAbsolutePath());
			
			r.setCreateTime(new Date());
			resourceInfoSerivce.save(r);
			result.put("headShortId", r.getRiId());
			log.debug("@@@@ 保存资源信息成功!");
			
			if(AccountType.STUDENT_TYPE.name().equals(accountType)){
				StudentInfo s = new StudentInfo();
				s.setAccount(accountType);
				s.setNickname(nickname);
				s.setSex(sex);
				s.setHeadShortId(r.getRiId());
				s.setQq(qq);
				s.setWeixin(weixin);
				s.setWeibo(weibo);
				studentInfoService.save(s);
				result.put("id", s.getSiId());
				log.info("#### 注册学生成功");
			}else if (AccountType.TEACHER_TYPE.name().equals(accountType)) {
				TeacherInfo t = new TeacherInfo();
				t.setAccount(accountType);
				t.setNickname(nickname);
				t.setSex(sex);
				t.setHeadShortId(r.getRiId());
				t.setQq(qq);
				t.setWeixin(weixin);
				t.setWeibo(weibo);
				teacherInfoService.save(t);
				result.put("id", t.getTiId());
				log.info("#### 注册老师成功");
			}else{
				throw new Exception("accountType["+accountType+"]不在值域范围内，请与管理员联系!");
			}
			result.put("nickname", nickname);
			result.put("sex", sex);
			result.put("accountType", accountType);
			result.put("status", true);
			result.put("msg", "注册成功!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			
			result.put("status",false);
			result.put("msg","第三方登录失败["+e.getMessage()+"]!");
		}
		
		this.ajaxWriteOutJSON(result);
	}
	
	public void registerByMobile(){
		log.debug("@@@@@@ mobile:"+mobile+"|verifyCode:"+verifyCode+"|password:"+password);
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			
			if(StringUtils.isEmpty(mobile)){
				throw new Exception("手机号不能为空!");
			}
			
			//取出上次生成的验证码
			String oldVerifyCode = (String) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.LOGIN_VERIFY_CODE);
			Long pojoId = null;
			if (StringUtils.isNotEmpty(oldVerifyCode)  && oldVerifyCode.equals(verifyCode)) {
				if(AccountType.STUDENT_TYPE.name().equals(accountType)){
					StudentInfo s = new StudentInfo();
					s.setMobile(mobile);
					s.setPassword(password);
					studentInfoService.save(s);
					pojoId=s.getSiId();
				}else if(AccountType.TEACHER_TYPE.name().equals(accountType)){
					TeacherInfo t = new TeacherInfo();
					t.setMobile(mobile);
					t.setPassword(password);
					teacherInfoService.save(t);
					pojoId=t.getTiId();
				}else{
					throw new Exception("你所传的accountType["+accountType+"]不在系统识别范围内，请与管理员联系!");
				}
			}else{
				throw new Exception("验证码不对!");
			}
			
			result.put("status", true);
			result.put("msg", "注册成功!");
			result.put("id", pojoId);
			result.put("accountType", accountType);
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put("status", false);
			result.put("msg", "注册出错,原因["+e.getMessage()+"]");
		}
		
		this.ajaxWriteOutJSON(result);
	}
	

}
