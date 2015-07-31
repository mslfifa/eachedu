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
  <title>学生接口17</title>
 </head>
 <body>
 <h1>学生接口17-课件列表</h1>
  <form method="POST" action="<%=path %>/app/visitApp!findCoursewarePage.action">
		关键字:<input type="text" name="courseTitle" value=""><br/>
	
		<select name="grade">
		    <option value="">请选择</option>
		    <option value="JUNIOR_1">初一</option>
			<option value="JUNIOR_2">初二</option>
			<option value="JUNIOR_3">初三</option>
			<option value="SENIOR_1">高一</option>
			<option value="SENIOR_2">高二</option>
			<option value="SENIOR_3">高三</option>
		</select>年级<br/>
		<select name="course">
		    <option value="">请选择</option>
		    <option value="CHINESE">语文</option>
		    <option value="ENGLISH">英语</option>
			<option value="MATH">数学</option>
			<option value="POLITICS">政治</option>
			<option value="PHYSICS">物理</option>
			<option value="CHYMIST">化学</option>
			<option value="BIOLOGY">生物</option>
			<option value="GEOGRAPHY">地理</option>
			<option value="HISTORY">历史</option>
		</select>课程<br/>
		
		排序字段:<input type="radio" name="orderField" value="down_num">下载量&nbsp;
		<input type="radio" name="orderField" value="prise">价格&nbsp;
		<input type="radio" name="orderField" value="grade">年级<br/>
		
		排序方向:<input type="radio" name="orderDirect" value="asc">下载量&nbsp;
		<input type="radio" name="orderDirect" value="desc">价格&nbsp;<br/>
		<input type="submit" value="提交">
  </form>

 </body>
</html>
