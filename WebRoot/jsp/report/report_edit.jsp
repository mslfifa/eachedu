<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>平台配置工具-报告修改管理</title>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
	<link rel="stylesheet" href="<%=path %>/css/admin.css">
	<link rel="stylesheet" href="<%=path %>/css/style.css">

	<script src="<%=path %>/js/jquery.js"></script>
	<script src="<%=path %>/js/pintuer.js"></script>
	<script src="<%=path %>/js/respond.js"></script>
	<script src="<%=path %>/js/admin.js"></script>
	<script src="<%=path %>/js/admin.js"></script>
	<script src="<%=path %>/echarts-2.2.3/build/source/echarts.js"></script>
    <link type="image/x-icon" href="<%=path %>/images/favicon.ico" rel="shortcut icon" />
    <link href="<%=path %>/images/favicon.ico" rel="bookmark icon" />
</head>
<body>
	<div class="doc-demoview doc-viewad0 ">
		<div class="view-body">
			<form onsubmit="return true;" method="post" action="<%=path%>/report!persist.action">
				<input type="hidden" name="riId" value="${report.riId}" />
				<input type="hidden" name="userid" value="${report.userid}" />
				<input type="hidden" name="createTime" value="${report.createTime}" />
				<input type="hidden" name="reportDataPeriod" value="${report.reportDataPeriod}" />
				<div class="form-group">
					<div class="label">
						<label for="report.reportName">报告名称</label>
					</div>
					<div class="field">
						<input type="text" placeholder="中文名称" size="50" name="report.reportName" id="report.reportName" class="input" value="${report.reportName}">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="report.reportVersione">报告版本</label>
					</div>
					<div class="field">
						<input type="text" placeholder="数字+点" size="50" name="report.reportVersion" id="report.reportVersion" class="input" value="${report.reportVersion}">
					</div>
				</div>
				<div class="form-button">
					<input type="submit" class="button" value="提交"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>