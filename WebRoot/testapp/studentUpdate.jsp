<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.eachedu.dict.*" %>
<%@ include file="/common/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
 </head>
 <body>
 <h1>学生修改</h1>
  
	
	
	<form id="form1" method="POST" action="<%=path %>/app/studentApp!updateStudent.action" enctype="multipart/form-data">
		
		性别:
		<input type="radio" name="sex" value="<%=SexType.MALE.name() %>">男&nbsp;
		<input type="radio" name="sex" value="<%=SexType.FEMALE.name() %>">女<br/>
	
		年级:
		<select name="grade">
		    <option value="">请选择</option>
		    <option value="JUNIOR_1">初一</option>
			<option value="JUNIOR_2">初二</option>
			<option value="JUNIOR_3">初三</option>
			<option value="SENIOR_1">高一</option>
			<option value="SENIOR_2">高二</option>
			<option value="SENIOR_3">高三</option>
		</select><br/>
		昵称:<input type="text" name="nickname" value=""><br/>
		qq:<input type="text" name="qq" value="">&nbsp;<input type="checkbox" name="qqEmpty" value="true">置空<br/>
		微信:<input type="text" name="weixin" value="">&nbsp;<input type="checkbox" name="weixinEmpty" value="true">置空<br/>
		微博:<input type="text" name="weibo" value="">&nbsp;<input type="checkbox" name="weiboEmpty" value="true">置空<br/>
		
		头像图片:<input type="file" name="headShortPic" value=""><br/>
		<input type="submit" value="提交">
	</form>
	
 </body>
</html>
