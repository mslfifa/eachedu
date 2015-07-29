<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
 </head>
 <body>
  <form method="POST" action="http://192.168.199.237:8080/eachedu/app/loginApp!loginBySns.action">
		<input type="hidden" name="accountType" value="STUDENT_TYPE">
		<input type="text" name="nickname" value="">昵称<br/>
		<select name="sex">
		    <option value="">请选择</option>
		    <option value="MALE">男</option>
			<option value="FEMALE">女</option>
		</select>性别<br/>
		<input type="text" name="qq" value="33849554">qq<br/>
		<input type="text" name="weibo" value="">weibo<br/>
		<input type="text" name="weixin" value="">weixin<br/>
		<input type="text" name="remoteUrl" value="">远程头像地址<br/>
		<input type="submit" value="提交">
  </form>
 </body>
</html>
