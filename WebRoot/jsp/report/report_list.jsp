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
    <title>平台配置工具-报告列表管理</title>
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
<script type="text/javascript">
	function openEditReportWin(id){
		alert('id:'+id)
		if(!id){
			id='';
		}
		var url='<%=path%>/report!modifyReportPage.action?report.riId='+id;
	
		var styleStr = 'width=450,height=350,location=yes,channelmode=yes,status=no,scrollbars=no';
		window.open(url,'编辑报告页面',styleStr);
	}
	
	function reloadReport(){
		$('#reportForm').submit();
	}
</script>
<body>
<div class="lefter">
    <div class="logo"><a href="http://www.pintuer.com" target="_blank"><img src="images/logo.png" alt="后台管理系统" /></a></div>
</div>

<jsp:include page="${path}/common/navigation_bar.jsp" flush="true" />

<div class="admin">
	<form id="reportForm" method="post" action="<%=path%>/report!listReportPage.action">
	<input type="hidden" name="userid" value="${user.userid}"/>
    <div class="panel admin-panel">
    	<div class="panel-head"><strong>报告列表</strong></div>
        <div class="padding border-bottom">
            <input type="button" class="button button-small checkall" name="checkall" checkfor="id" value="全选" />
            <input type="button" class="button button-small border-green" onclick="openEditReportWin();" value="添加报告" />
            <input type="button" class="button button-small border-yellow" value="批量删除" />
            <input type="button" class="button button-small border-blue" value="回收站" />
        </div>
        <table class="table table-hover">
        	<tr><th width="15%">选择</th><th width="35%">名称</th><th width="*">版本</th><th width="30%">创建时间</th><th width="20%">操作</th></tr>
        	
        	<c:forEach items="${pv.datas }" var="report">
			<tr>
				<td><input type="checkbox" name="riIds" value="${report.riId}" /></td>
				<td>${report.reportName}</td>
				<td>${report.reportVersion}</td>
				<td><fmt:formatDate value="${ report.createTime}" pattern="yyyy-MM-dd"/></td>
				<td>
					<a class="button border-blue button-little" href="javascript:openEditReportWin(${report.riId});">修改</a>&nbsp;&nbsp;
					<a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a>&nbsp;&nbsp;
					<a class="button border-blue button-little" href="<%=path%>/report!reportCfgPage.action?report.riId=${report.riId}">配置报告</a>&nbsp;&nbsp;
					<a class="button border-blue button-little" href="<%=path%>/report!reportOutput.action?report.riId=${report.riId}">输出报告</a>
				</td>
			</tr>
			</c:forEach>
            
            <!-- <tr><td><input type="checkbox" name="riId" value="2" /></td><td>起步</td><td>框架包含的文件</td><td>2014-9-20</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
            <tr><td><input type="checkbox" name="riId" value="3" /></td><td>起步</td><td>浏览器支持</td><td>2014-9-10</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
            <tr><td><input type="checkbox" name="riId" value="4" /></td><td>起步</td><td>移动优先、跨屏响应</td><td>2014-9-1</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
            <tr><td><input type="checkbox" name="riId" value="5" /></td><td>起步</td><td>基本页面</td><td>2014-8-20</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
            <tr><td><input type="checkbox" name="riId" value="6" /></td><td>起步</td><td>第三方应用支持</td><td>2014-8-10</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
            <tr><td><input type="checkbox" name="riId" value="7" /></td><td>起步</td><td>业务合作</td><td>2014-8-1</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
            <tr><td><input type="checkbox" name="riId" value="8" /></td><td>起步</td><td>使用许可</td><td>2014-7-20</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
            <tr><td><input type="checkbox" name="riId" value="9" /></td><td>CSS</td><td>文本</td><td>2014-7-10</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
            <tr><td><input type="checkbox" name="riId" value="10" /></td><td>CSS</td><td>背景、边框、圆角</td><td>2014-7-1</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
            <tr><td><input type="checkbox" name="riId" value="11" /></td><td>CSS</td><td>边界、填充</td><td>2014-6-20</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
            <tr><td><input type="checkbox" name="riId" value="12" /></td><td>CSS</td><td>CSS动画</td><td>2014-6-10</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr> -->
        </table>
        <div class="panel-foot text-center">
            <!-- <ul class="pagination"><li><a href="#">上一页</a></li></ul>
            <ul class="pagination pagination-group">
                <li><a href="#">1</a></li>
                <li class="active"><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
            </ul>
            <ul class="pagination"><li><a href="#">下一页</a></li></ul> -->
            
            <jsp:include page="/common/pager.jsp">
				<jsp:param name="url" value="report!listReportPage.action"/>
				<jsp:param name="params" value="userid"/>
			</jsp:include>
            
        </div>
    </div>
    </form>
    <br />
    <p class="text-right text-gray">基于<a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图前端框架</a>构建</p>
</div>

<div class="hidden"><script src="http://s4.cnzz.com/stat.php?id=5952475&web_id=5952475" language="JavaScript"></script></div>




</body>
</html>