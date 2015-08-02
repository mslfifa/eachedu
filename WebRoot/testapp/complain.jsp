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
  <title>投诉</title>
 </head>
 <body>
 <h1>学生投诉订单</h1>
  <form method="POST" action="<%=path %>/app/complainSolveApp!complain.action">
		订单ID:
		<select name="orderNo">
			<option value="DH201508010401154282">DH201508010401154282</option>
			<option value="DH201508010403168426">DH201508010403168426</option>
			<option value="DH201508011049555660">DH201508011049555660</option>
			<option value="DH201508011056349592">DH201508011056349592</option>
			<option value="DH201508011058565506">DH201508011058565506</option>
			<option value="DH201508020312187619">DH201508020312187619</option>
			<option value="DH201508020315125990">DH201508020315125990</option>
			<option value="DH201508020316337865">DH201508020316337865</option>
			<option value="TW201508010154143664">TW201508010154143664</option>
			<option value="TW201508010411523688">TW201508010411523688</option>
			<option value="TW201508010430418930">TW201508010430418930</option>
			<option value="TW201508010452296280">TW201508010452296280</option>
			<option value="TW201508010504535217">TW201508010504535217</option>
			<option value="TW201508010506348960">TW201508010506348960</option>
			<option value="TW201508010506565718">TW201508010506565718</option>
			<option value="TW201508010508058182">TW201508010508058182</option>
			<option value="TW201508011048101545">TW201508011048101545</option>
		</select>
		<br/>
	
		投诉类型: 
		<input type="radio" name="complainType" value="ERROR_TYPE">答案错误&nbsp;
		<input type="radio" name="complainType" value="INDISTINCT_TYPE">图片模糊&nbsp;<br/>
		投诉内容:<textarea name="complainContext" rows="4" cols="60"></textarea><br/>
		<input type="submit" value="提交">
  </form>
 </body>
</html>
