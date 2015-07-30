<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
 </head>
 <body>
  <form method="POST" action="<%=path %>/app/answerCommentApp!comment.action">
		订单ID:<input type="text" name="orderId" value="1"><br/>
	
		评分: 
		<input type="radio" name="score" value="1">1分&nbsp;
		<input type="radio" name="score" value="2">2分&nbsp;
		<input type="radio" name="score" value="3">3分&nbsp;
		<input type="radio" name="score" value="4">4分&nbsp;
		<input type="radio" name="score" value="5">5分&nbsp;<br/>
		备注:<textarea name="remark" rows="4" cols="60"></textarea><br/>
		<input type="submit" value="提交">
  </form>
 </body>
</html>
