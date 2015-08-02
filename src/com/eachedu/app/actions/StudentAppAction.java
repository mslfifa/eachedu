package com.eachedu.app.actions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.service.StudentInfoService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.actions.BaseAction;
import com.eachedu.web.vo.PagerVO;
import com.eachedu.web.vo.UserVO;

@Controller("studentAppAction")
@Scope("prototype")
public class StudentAppAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(StudentAppAction.class);
	
	@Resource(name="studentInfoService")
	private StudentInfoService studentInfoService;
	
	private String mobile;
	private String password;
	private String verifyCode;
	private Integer appPageNo;
	private Integer appPageSize;

	
	/*private String askPicFileName;
	//问题图片正文类型
	private String askPicContentType;
	////问题图片标题
	private String askPicCaption;*/
	private Long siId;
	private File headShortPic;
	private String headShortPicFileName;
	private String headShortPicContentType;
	private String headShortPicCaption;
	
	private String nickname;
	private String sex;
	private String grade;
	private String qq;
	private String weixin;
	private String weibo;
	private boolean qqEmpty=false;
	private boolean weixinEmpty=false;
	private boolean weiboEmpty=false;
	
	
	public Long getSiId() {
		return siId;
	}

	public void setSiId(Long siId) {
		this.siId = siId;
	}

	public File getHeadShortPic() {
		return headShortPic;
	}

	public void setHeadShortPic(File headShortPic) {
		this.headShortPic = headShortPic;
	}

	public String getHeadShortPicFileName() {
		return headShortPicFileName;
	}

	public void setHeadShortPicFileName(String headShortPicFileName) {
		this.headShortPicFileName = headShortPicFileName;
	}

	public String getHeadShortPicContentType() {
		return headShortPicContentType;
	}

	public void setHeadShortPicContentType(String headShortPicContentType) {
		this.headShortPicContentType = headShortPicContentType;
	}

	public String getHeadShortPicCaption() {
		return headShortPicCaption;
	}

	public void setHeadShortPicCaption(String headShortPicCaption) {
		this.headShortPicCaption = headShortPicCaption;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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

	public boolean isQqEmpty() {
		return qqEmpty;
	}

	public void setQqEmpty(boolean qqEmpty) {
		this.qqEmpty = qqEmpty;
	}

	public boolean isWeixinEmpty() {
		return weixinEmpty;
	}

	public void setWeixinEmpty(boolean weixinEmpty) {
		this.weixinEmpty = weixinEmpty;
	}

	public boolean isWeiboEmpty() {
		return weiboEmpty;
	}

	public void setWeiboEmpty(boolean weiboEmpty) {
		this.weiboEmpty = weiboEmpty;
	}

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

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	

	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}

	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}

	public Integer getAppPageNo() {
		return appPageNo;
	}

	public void setAppPageNo(Integer appPageNo) {
		this.appPageNo = appPageNo;
	}

	public Integer getAppPageSize() {
		return appPageSize;
	}

	public void setAppPageSize(Integer appPageSize) {
		this.appPageSize = appPageSize;
	}

	public void viewUserInfo(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			
			UserVO userVO = (UserVO) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
			Map<String,Object> data = studentInfoService.findUserInfo(userVO.getId());
			result.put("data",data);
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "查找失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
	public void findBuyCourseware(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			
			UserVO userVO = (UserVO) ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
			PagerVO page = studentInfoService.findBuyCourseware(userVO.getId(),appPageNo,appPageSize);
			result.put("page",page);
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "查找失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
	public void updateStudent(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			
			UserVO currentUser = (UserVO)ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
			
			boolean flag = studentInfoService.updateStudent(currentUser.getId(), headShortPic, headShortPicFileName,headShortPicContentType,
					 headShortPicCaption, nickname,sex,grade,qq,weixin,weibo,qqEmpty,weixinEmpty,weiboEmpty);
			
			result.put("update_flag",flag);
			result.put("http_status", true);
			result.put("http_msg", "查找成功!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "查找失败!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
}
