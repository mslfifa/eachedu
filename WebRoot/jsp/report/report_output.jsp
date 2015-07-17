<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>拼图后台管理-后台管理</title>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
	<link rel="stylesheet" href="<%=path %>/css/admin.css">
	<link rel="stylesheet" href="<%=path %>/css/style.css">

	<script type="text/javascript">
		var _ctx_path = '<%=path%>';
	</script>

	<script src="<%=path %>/js/jquery.js"></script>
	<script src="<%=path %>/js/pintuer.js"></script>
	<script src="<%=path %>/js/respond.js"></script>
	<script src="<%=path %>/js/admin.js"></script>
	<script src="<%=path %>/js/admin.js"></script>
	<script src="<%=path %>/echarts-2.2.3/build/dist/echarts.js"></script>
	<script src="<%=path %>/js/echart_options.js"></script>
	<script src="<%=path %>/js/report_chart.js"></script>
    <link type="image/x-icon" href="<%=path %>/images/favicon.ico" rel="shortcut icon" />
    <link href="<%=path %>/images/favicon.ico" rel="bookmark icon" />
</head>

<body>
<div class="lefter">
    <div class="logo"><a href="<%=path %>" target="_self"><img src="images/logo.png" alt="后台管理系统" /></a></div>
</div>

<jsp:include page="${path}/common/navigation_bar.jsp" flush="true" />	


<div class="admin">
	<h1>报告 : ${reportVO.reportName}</h1>
	
		<!-- -----------布局循环 bigin ---------- -->
	
	<jsp:include page="${path}/jsp/report/charts_edit_render.jsp" flush="true" >
    	<jsp:param value="${reportVO}" name="reportVO"/>
    </jsp:include>
	
	<!-- -----------布局循环 end ---------- -->
    <p class="text-right text-gray">基于<a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图前端框架</a>构建</p>
</div>

</body>
</html>