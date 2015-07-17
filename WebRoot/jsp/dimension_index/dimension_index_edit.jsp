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
    <title>平台配置工具-维度指标修改管理</title>
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
    
    <script type="text/javascript">
    
	
	$(function(){
		//$('input[valgroup="indexed"]');  
		$('input[valgroup="dimensioned"]').on('change',function(){
			
		});
	});
    
    </script>
    
</head>
<body>
	<div class="doc-demoview doc-viewad0 ">
		<div class="view-body">
			<form method="post" action="<%=path%>/dimensionIndexInfo!persistDii.action">
				<input type="hidden" name="dii.diiId" value="${dii.diiId}" />
				<input type="hidden" name="dii.dscId" value="${dii.dscId}" />
				<div class="form-group">
					<div class="label">
						<label for="dii.fieldDbName">字段DB名称</label>
					</div>
					<div class="field">
						<input type="text" placeholder="英文" size="50" name="dii.fieldDbName" id="dii.fieldDbName" class="input" value="${dii.fieldDbName}" data-validate="required:必填,username:英文字母开头的字母下划线数字">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="dii.fieldBusName">字段业务名</label>
					</div>
					<div class="field">
						<input type="text" placeholder="中文" size="50" name="dii.fieldBusName" id="dii.fieldBusName" class="input" value="${dii.fieldBusName}" data-validate="required:必填,chinese:汉字">
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="label">
						<label>字段类型</label>
					</div>
					<div class="field">
						<div class="button-group radio">
							<label <c:choose><c:when test="${dii.fieldType=='dimensioned'}"> class="button active" </c:when><c:otherwise> class="button" </c:otherwise> </c:choose>>
								<input name="dii.fieldType" type="radio" value="dimensioned" <c:choose><c:when test="${dii.fieldType=='dimensioned'}"> checked="checked" </c:when><c:otherwise></c:otherwise> </c:choose> data-validate="radio:请选维度">
								<span class="icon icon-times"></span>
								维度
							</label>
							<label <c:choose><c:when test="${dii.fieldType=='indexed'}"> class="button active" </c:when><c:otherwise> class="button" </c:otherwise> </c:choose>>
								<input name="dii.fieldType" type="radio" value="indexed" <c:choose><c:when test="${dii.fieldType=='indexed'}"> checked="checked" </c:when><c:otherwise></c:otherwise> </c:choose> data-validate="radio:请选维度">
								<span class="icon icon-times"></span>
								指标
							</label>
						</div>
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