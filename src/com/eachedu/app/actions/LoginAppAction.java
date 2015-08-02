package com.eachedu.app.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

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
import com.eachedu.service.ResourceInfoService;
import com.eachedu.service.StudentInfoService;
import com.eachedu.service.TeacherInfoService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.utils.DateUtils;
import com.eachedu.utils.PropUtils;
import com.eachedu.utils.SmSUtils;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.UserVO;
@Controller("loginAppAction")
@Scope("prototype")
public class LoginAppAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(LoginAppAction.class);
	
	private String mobile;
	private String password;
	private String accountType;
	private String qq;
	private String weixin;
	private String weibo;
	private String nickname;
	private String sex;
	private String remoteUrl;
	/*private File headShort;
	//头像文件名
	private String headShortFileName;
	//头像文件类型
	private String headShortContentType;
	private String headShortCaption;*/
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
	/*public File getHeadShort() {
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
	}*/

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
	public String getRemoteUrl() {
		return remoteUrl;
	}
	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}



	@Resource(name="studentInfoService")
	private StudentInfoService studentInfoService;
	@Resource(name="teacherInfoService")
	private TeacherInfoService teacherInfoService;
	@Resource(name="resourceInfoService")
	private ResourceInfoService resourceInfoService;
	
	/**
	 * 学生 / 老师(使用accountType来区分 ) 手机 密码登录
	 */
	public void loginByMobile(){
		log.debug("@@@ mobile:"+mobile+"|password:"+password);
		Map<String,Object> result = new HashMap<String,Object>();
		UserVO user = null;
		try {
			
			if (AccountType.STUDENT_TYPE.name().equals(accountType)) {
				Map<String, Object> s = studentInfoService.findByMobile(mobile, password);
				user = new UserVO();
				user = new UserVO();
				user.setId(Long.parseLong(s.get("si_id").toString()) );
				user.setAccount((String) s.get("account"));
				user.setAccountType((String) s.get("account_type"));
				user.setMobile((String) s.get("mobile"));
				user.setName((String) s.get("name"));
				user.setQq((String) s.get("qq"));
				user.setWeibo((String) s.get("weibo"));
				user.setWeixin((String) s.get("weixin"));
				user.setRemoteUrl((String) s.get("remote_url"));
				user.setSex((String) s.get("sex"));
				user.setNickname((String) s.get("nickname"));
				
				result.put("http_status", true);
				result.put("http_msg", "查询成功");
				result.put("data",s);
			}else if (AccountType.TEACHER_TYPE.name().equals(accountType)) {
				Map<String, Object> t = teacherInfoService.findByMobile(mobile, password);
				user = new UserVO();
				user.setId(Long.parseLong(t.get("ti_id").toString()));
				user.setAccount((String) t.get("account"));
				user.setAccountType((String) t.get("account_type"));
				user.setMobile((String) t.get("mobile"));
				user.setName((String) t.get("name"));
				user.setQq((String) t.get("qq"));
				user.setWeibo((String) t.get("weibo"));
				user.setWeixin((String) t.get("weixin"));
				user.setRemoteUrl((String) t.get("remote_url"));
				user.setSex((String) t.get("sex"));
				user.setNickname((String) t.get("nickname"));
				
				result.put("http_status", true);
				result.put("http_msg", "查询成功");
				
				result.put("data", t);
			}else{
				throw new Exception("没有传入accountType,请联系管理员.");
			}
			//app登录用户信息保存到会话对象中
			ServletActionContext.getRequest().getSession().setAttribute(ConstUtils.USER_LOGIN, user);
		} catch (Exception e) {
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "查询失败，错误["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
	
	
	/**
	 * 获取会话验证码，系统根据配置文件设置超时时间，下次使用判断验证码是否过期
	 */
	public void getSessionValidateCode(){
		log.debug("@@@ mobile:"+mobile);
		Map<String,Object> result = new HashMap<String,Object>();
		
		try {
			
			/*if(StringUtils.isNotEmpty(mobile)){
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
			}*/
			
			String randomStr = new Random().nextInt(1000000)+"000000";
			String tmpVerifyCode = (randomStr).substring(0, 6);
			result.put("verifyCode", tmpVerifyCode);
			log.info("##### verifyCode:"+tmpVerifyCode);
			
			//验证码设置到会话中
			ServletActionContext.getRequest().getSession().setAttribute(ConstUtils.LOGIN_VERIFY_CODE, tmpVerifyCode);
			
			//调用短信平台接口发送模板短信   注册号码13148856443
			HashMap<String, Object> smsResult = SmSUtils.sendSms(mobile,"1",new String[]{tmpVerifyCode,"1"});
			
			System.out.println("SDKTestSendTemplateSMS result=" + smsResult);
			if(ConstUtils.SMS_SEND_SUCCESS_CODE.equals(smsResult.get("statusCode"))){
				//正常返回输出data包体信息（map）
				HashMap<String,Object> data = (HashMap<String, Object>) smsResult.get("data");
				Set<String> keySet = data.keySet();
				for(String key:keySet){
					Object object = data.get(key);
					log.debug("sms result:"+key +" = "+object);
				}
			}else{
				//异常返回输出错误码和错误信息
				String smsErrorMsg = "错误码=" + smsResult.get("statusCode") +" 错误信息= "+smsResult.get("statusMsg");
					
				//如果生产环境上线时 抛异常
				if("true".equals(PropUtils.get("is_product"))){
					throw new Exception(smsErrorMsg);
				}
				
			}
			
			//默认超时分钟数
			int period_minute =Integer.parseInt(PropUtils.get("verify_code_period_minute"));
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.MINUTE, period_minute);
			
			Map<String,Date> expireMap = (Map<String, Date>) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.VERIFY_CODE_EXPIRE_TIME);
			if(expireMap==null){
				expireMap = new HashMap<String,Date>();
				ServletActionContext.getRequest().getSession().setAttribute(ConstUtils.VERIFY_CODE_EXPIRE_TIME,expireMap);
			}
			
			//每个验证码有一个超时时间
			expireMap.put(tmpVerifyCode, cal.getTime());
			log.info("@@@@@@ 会话设置验证码:"+tmpVerifyCode+"|超时时间:"+cal.getTime().toLocaleString());
			
			result.put("http_status",true);
			result.put("http_msg","生成验证码成功!");
			
		} catch (Exception e) {
			log.error(e.getMessage());
			result.clear();
			result.put("http_status",false);
			result.put("http_msg","生成验证码失败,原因["+e.getMessage()+"]!");
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
			boolean isLogined=true;;
			
			if(StringUtils.isEmpty(qq) && StringUtils.isEmpty(weibo) && StringUtils.isEmpty(weixin)){
				throw new Exception("第三方账号不能全空,qq微信微博账号必选一!");
			}
			
			Map<String,Object> data =null;
			

			//判断第三方账号对应的用户存在否，存在就登录并返回信息。
			if(AccountType.STUDENT_TYPE.name().equals(accountType)){
				data = studentInfoService.findBySns(qq,weixin,weibo);
			}else if (AccountType.TEACHER_TYPE.name().equals(accountType)) {
				data = teacherInfoService.findBySns(qq,weixin,weibo);
			}else{
				throw new Exception("accountType["+accountType+"]不在值域范围内，请与管理员联系!");
			}
			
			if(data!=null){
				result.put("data", data);
			}else{
				data = new HashMap<String,Object>();
			}
			
			//如果没有注册用户就新注册用户
			if(data.isEmpty()){
				
				//称保存资源
				ResourceInfo r = null;
				if(StringUtils.isNotEmpty(remoteUrl)){
					r = new ResourceInfo();
					r.setRemoteUrl(remoteUrl);
					r.setResourceType(ResourceType.HEAD_SHORT_TYPE.name());
					
					r.setCreateTime(new Date());
					resourceInfoService.save(r);
					log.debug("@@@save ResourceInfo success riId:"+r.getRiId());
				}
				
				
				log.debug("@@@@ 保存资源信息成功!");
				
				if(AccountType.STUDENT_TYPE.name().equals(accountType)){
					StudentInfo s = new StudentInfo();
					s.setNickname(nickname);
					s.setSex(sex);
					s.setHeadShortId(r==null?null:r.getRiId());
					s.setQq(qq);
					s.setWeixin(weixin);
					s.setWeibo(weibo);
					studentInfoService.save(s);
					
					data.put("id", s.getSiId());
					data.put("nickname", s.getNickname());
					data.put("sex", s.getSex());
					data.put("qq", s.getQq());
					data.put("weibo", s.getWeibo());
					data.put("weixin", s.getWeixin());
					data.put("remote_url", (r==null?null:r.getRemoteUrl()));
					
					log.info("#### 注册学生成功");
				}else if (AccountType.TEACHER_TYPE.name().equals(accountType)) {
					TeacherInfo t = new TeacherInfo();
					t.setNickname(nickname);
					t.setSex(sex);
					t.setHeadShortId(r==null?null:r.getRiId());
					t.setQq(qq);
					t.setWeixin(weixin);
					t.setWeibo(weibo);
					teacherInfoService.save(t);
					
					
					data.put("id", t.getTiId());
					data.put("nickname", t.getNickname());
					data.put("sex", t.getSex());
					data.put("qq", t.getQq());
					data.put("weibo", t.getWeibo());
					data.put("weixin", t.getWeixin());
					data.put("remote_url", (r==null?null:r.getRemoteUrl()));
					
					isLogined=false;
					
					log.info("#### 注册老师成功");
				}else{
					throw new Exception("accountType["+accountType+"]不在值域范围内，请与管理员联系!");
				}
			}
			
			
			UserVO userVO = new UserVO();
			
			userVO.setId(Long.parseLong(""+data.get("id")));
			userVO.setAccountType(accountType);
			userVO.setNickname((String) data.get("nickname"));
			userVO.setSex((String) data.get("sex"));
			userVO.setQq((String) data.get("qq"));
			userVO.setWeibo((String) data.get("weibo"));
			userVO.setWeixin((String) data.get("weixin"));
			userVO.setRemoteUrl((String) data.get("remote_url"));
			userVO.setMobile((String) data.get("mobile"));
			//设置用户到会话中
			ServletActionContext.getRequest().getSession().setAttribute(ConstUtils.USER_LOGIN,userVO);
			
			
			result.put("data", data);
			result.put("http_status", true);
			if(isLogined){
				result.put("http_msg", "登录成功!");
			}else{
				result.put("http_msg", "注册成功!");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			result.clear();
			result.put("http_status",false);
			result.put("http_msg","第三方登录失败["+e.getMessage()+"]!");
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
			
			
			Map<String, Date> expireMap = (Map<String, Date>) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.VERIFY_CODE_EXPIRE_TIME);
			//是否超时
			DateUtils.checkVerifyCodeExpire(oldVerifyCode, expireMap );
			
			
			Long pojoId = null;
			if (StringUtils.isNotEmpty(oldVerifyCode)  && oldVerifyCode.equals(verifyCode)) {
				if(AccountType.STUDENT_TYPE.name().equals(accountType)){
					if (studentInfoService.findExistMobile(mobile)) {
						throw new Exception("手机号码["+mobile+"]已经注册过了,请更改号码或直接登录再重试");
					}
					
					StudentInfo s = new StudentInfo();
					s.setMobile(mobile);
					s.setPassword(password);
					studentInfoService.save(s);
					pojoId=s.getSiId();
					
				}else if(AccountType.TEACHER_TYPE.name().equals(accountType)){
					if (teacherInfoService.findExistMobile(mobile)) {
						throw new Exception("手机号码["+mobile+"]已经注册过了,请更改号码或直接登录再重试");
					}
					
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
			
			result.put("http_status", true);
			result.put("http_msg", "注册成功!");
			result.put("id", pojoId);
			result.put("accountType", accountType);
		} catch (Exception e) {
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "注册出错,原因["+e.getMessage()+"]");
		}
		
		this.ajaxWriteOutJSON(result);
	}
	
	
	public void resetPwd(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			String oldVerifyCode =  (String) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.LOGIN_VERIFY_CODE);
			
			Map<String,Date> expireMap = (Map<String, Date>) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.VERIFY_CODE_EXPIRE_TIME);
			//验证码是否超时
			DateUtils.checkVerifyCodeExpire(oldVerifyCode, expireMap);
			
			if(StringUtils.isEmpty(oldVerifyCode)){
				throw new Exception("您还没有获取验证码");
			}
			if(StringUtils.isEmpty(verifyCode)){
				throw new Exception("您没有输入验证码");
			}
			
			if(StringUtils.isEmpty(accountType)){
				throw new Exception("您没有账号类型验证码");
			}
			if(!verifyCode.equals(oldVerifyCode)){
				throw new Exception("您输入验证码的不正确");
			}
			
			if(AccountType.STUDENT_TYPE.name().equals(accountType)){
				studentInfoService.updatePwd(mobile,password);
			}else if (AccountType.TEACHER_TYPE.name().equals(accountType)) {
				teacherInfoService.updatePwd(mobile,password);
			}else{
				throw new Exception("accountType["+accountType+"]不在合法的范围内,请联系管理员!");
			}
			
			
			result.put("http_status", true);
			result.put("http_msg", "修改密码成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "修改密码失败,原因["+e.getMessage()+"]");
			
		} 
		this.ajaxWriteOutJSON(result);
	}
	
	public void logOut(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			ServletActionContext.getRequest().getSession().invalidate();
			
			result.put("http_status", true);
			result.put("http_msg", "退出成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "退出失败,原因["+e.getMessage()+"]");
			
		} 
		this.ajaxWriteOutJSON(result);
		
	}

}
