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
 <h1>学生提问</h1>
  
	
	
	<form id="form1" method="POST" action="<%=path %>/app/questionApp!ask.action" enctype="multipart/form-data">
		沟通方式:
		<input type="radio" name="communicateWay" value="<%=CommunicateWay.PIC_TEXT_TYPE.name() %>">图文方式&nbsp;
		<input type="radio" name="communicateWay" value="<%=CommunicateWay.PHONE_TYPE.name() %>">电话方式<br/>
		
		问题图片:<input type="file" name="askPic" value=""><br/>
	
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
		课程:
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
		</select><br/>
		
		补充描述:<input type="text" name="questionDesc" value=""><br/>
		
		费用:<input type="text" name="prise" value="10"><br/>
		追加赏金:<input type="text" name="bonus" value="0"><br/>
		<input type="submit" value="提交">
	</form>
	
 </body>
</html>
