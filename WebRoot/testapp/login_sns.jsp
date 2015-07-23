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
  <form method="post" action="<%=path %>/app/loginApp!loginBySns.action" enctype="multipart/form-data">
		<input type="hidden" name="accountType" value="STUDENT_TYPE">
		<input type="text" name="qq" value="4173849554">qq<br/>
		<input type="text" name="weibo" value="">weibo<br/>
		<input type="text" name="weixin" value="">weixin<br/>
		<input type="file" name="headShort"><br/>
		<input type="submit" value="提交">
  </form>
 </body>
</html>
