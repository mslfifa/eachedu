package com.eachedu.app.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.dao.pojo.TeacherInfo;
import com.eachedu.dict.AccountType;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.StudentInfoService;
import com.eachedu.service.TeacherInfoService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.UserVO;
@Controller("loginAppAction")
@Scope("prototype")
public class LoginAppAction extends BaseAction {
	
	Logger log = LoggerFactory.getLogger(LoginAppAction.class);
	
	private String mobile;
	private String password;
	private String accountType;
	private String nickname;
	private String sex;
	private File headShort;
	private String headShortFileName;
	private String headShortContentType;
	private String headShortCaption;
	
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




	@Resource(name="studentInfoService")
	private StudentInfoService studentInfoService;
	@Resource(name="teacherInfoService")
	private TeacherInfoService teacherInfoService;
	
	/**
	 * 学生 / 老师(使用accountType来区分 ) 手机 密码登录
	 */
	public void loginByMobile(){
		log.debug("@@@ mobile:"+mobile+"|password:"+password);
		Map<String,Object> result = new HashMap<String,Object>();
		UserVO user = null;
		try {
			if (AccountType.student_type.name().equals(accountType)) {
				StudentInfo s = studentInfoService.findByMobile(mobile, password);
				user = new UserVO();
				user = new UserVO();
				user.setId(s.getSiId());
				user.setAccount(s.getAccount());
				user.setAccountType(AccountType.student_type.name());
				user.setEmail(s.getEmail());
				user.setMobile(s.getMobile());
				user.setName(s.getName());
				user.setQq(s.getQq());
				
				result.put("status", true);
				result.put("msg", "查询成功");
				result.put("id", s.getSiId());
				result.put("accountType", AccountType.student_type.name());
				result.put("nickname", s.getNickname());
				result.put("headShortId", s.getHeadShortId());
				result.put("mobile", s.getMobile());
				result.put("email", s.getEmail());
				result.put("sex", s.getSex());
				result.put("account", s.getAccount());
			}else if (AccountType.teacher_type.name().equals(accountType)) {
				TeacherInfo t = teacherInfoService.findByMobile(mobile, password);
				user = new UserVO();
				user.setId(t.getTiId());
				user.setAccount(t.getAccount());
				user.setAccountType(AccountType.teacher_type.name());
				user.setEmail(t.getEmail());
				user.setMobile(t.getMobile());
				user.setName(t.getName());
				user.setQq(t.getQq());
				
				result.put("status", true);
				result.put("msg", "查询成功");
				result.put("id", t.getTiId());
				result.put("accountType", AccountType.teacher_type.name());
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
			boolean existFlag = studentInfoService.findExistByMobile(mobile);
			if(existFlag){
				result.put("status",true);
				result.put("msg","生成验证码成功!");
				String randomStr = new Random().nextInt(10000)+"0000";
				String code = (randomStr).substring(0, 4);
				
				result.put("code", code);
			}else{
				result.put("status",false);
				result.put("msg","生成验证码失败,未能找学生号码["+mobile+"]!");
			}
		} catch (ServiceException e) {
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
			String uploadDir = "/data/upload";
			File dir = new File(uploadDir +"/headShort/student");
			if(!dir.exists()){
				dir.createNewFile();
			}
			String uuidStr = UUID.randomUUID().toString();
			File destFile = new File(dir.getAbsolutePath()+"/"+uuidStr+"."+headShortContentType);
			FileUtils.copyFile(headShort, destFile);
			result.put("status",true);
			result.put("msg","第三方登录成功!上传文件保存为:"+destFile.getAbsolutePath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			
			result.put("status",false);
			result.put("msg","第三方登录失败["+e.getMessage()+"]!");
		}
		
		this.ajaxWriteOutJSON(result);
	}
}
