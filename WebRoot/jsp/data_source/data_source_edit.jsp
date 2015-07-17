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
    <title>平台配置工具-数据源修改管理</title>
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
			<form method="post" action="<%=path%>/dataSource!persistDsc.action" class="form form-block">
				<input type="hidden" name="dsc.dscId" value="${dsc.dscId}" />
				<div class="form-group">
					<div class="label">
						<label for="dsc.tableDbName">表DB名称</label>
					</div>
					<div class="field">
						<input type="text" placeholder="英文字母开头的字母下划线数字" size="50" name="dsc.tableDbName" id="dsc.tableDbName" class="input" value="${dsc.tableDbName}" data-validate="required:必填,username:英文字母开头的字母下划线数字">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="dsc.tableBusName">表业务名</label>
					</div>
					<div class="field">
						<input type="text" placeholder="中文" size="50" name="dsc.tableBusName" id="dsc.tableBusName" class="input" value="${dsc.tableBusName}" data-validate="required:必填,chinese:汉字">
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