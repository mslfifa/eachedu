package com.eachedu.web.actions;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dao.pojo.OperatorInfo;
import com.eachedu.dao.pojo.StudentInfo;
import com.eachedu.dao.pojo.TeacherInfo;
import com.eachedu.dict.AccountType;
import com.eachedu.exception.ActionException;
import com.eachedu.service.AccountManagerLogService;
import com.eachedu.service.OperatorInfoService;
import com.eachedu.service.StudentInfoService;
import com.eachedu.service.TeacherInfoService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.vo.UserVO;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction{
	private static final Logger log = LoggerFactory.getLogger(LoginAction.class);
	
	private String username;
	private String password;
	private String accountType;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	@Resource
	private OperatorInfoService operatorInfoService;
	@Resource
	private StudentInfoService studentInfoService;
	@Resource
	private TeacherInfoService teacherInfoService;
	@Resource
	private AccountManagerLogService accountManagerLogService;
	
	public String login() throws ActionException{
		
		try {
			
			UserVO user = null;
			//student_type:学生  teacher_type:老师  operator_type:运营人员
			if(AccountType.student_type.name().equals(accountType)){
				List<StudentInfo> students = studentInfoService.findStudentFromLogin(username, password);
				StudentInfo student = students.get(0);
				user=new UserVO();
				user.setId(student.getSiId());
				user.setAccount(student.getAccount());
				user.setName(student.getName());
				user.setAccountType(AccountType.operator_type.name());
				user.setMobile(student.getEmail());
				user.setQq(student.getQq());
				user.setMobile(student.getMobile());
			}else if(AccountType.teacher_type.name().equals(accountType)){
				List<TeacherInfo> teachers = teacherInfoService.findTeacherFromLogin(username, password);
				TeacherInfo teacher = teachers.get(0);
				user=new UserVO();
				user.setId(teacher.getTiId());
				user.setAccount(teacher.getAccount());
				user.setName(teacher.getName());
				user.setAccountType(AccountType.operator_type.name());
				user.setMobile(teacher.getEmail());
				user.setQq(teacher.getQq());
				user.setMobile(teacher.getMobile());
			}else if(AccountType.operator_type.name().equals(accountType)){
				List<OperatorInfo> operators = operatorInfoService.findOperatorFromLogin(username, password);
				OperatorInfo operator = operators.get(0);
				user=new UserVO();
				user.setId(operator.getOiId());
				user.setAccount(operator.getAccount());
				user.setName(operator.getName());
				user.setAccountType(AccountType.operator_type.name());
				user.setMobile(operator.getEmail());
				user.setQq(operator.getQq());
				user.setMobile(operator.getMobile());
			}else{
				throw new Exception("accountType值没有设置对，请联系管理员!");
			}
			
			ServletActionContext.getRequest().getSession().setAttribute(ConstUtils.USER_LOGIN, user);
			return "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			setAttribute("loginErr", "登录失败!，请重新检查登录信息!");
			return "needLogin";
		}
		
	}

}
