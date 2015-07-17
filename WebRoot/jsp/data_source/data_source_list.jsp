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
    <title>平台配置工具-数据源管理</title>
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
	function openEditDataSourceWin(id){
		if(!id){
			id='';
		}
		var url='<%=path%>/dataSource!modifyDscPage.action?dsc.dscId='+id;
	
		var styleStr = 'width=450,height=350,center=yes,location=yes,channelmode=yes,status=no,scrollbars=no';
		window.open(url,'编辑数据源页面',styleStr);
	}
	
	function reloadDataSource(){
		$('#dataSourceForm').submit();
	}
	
	function delDsc(id){
		if(!id|| id==''){
			alert('id不能为空');
			return false;
		}
		if(confirm('确认删除?')){
			$.post(
					'<%=path%>/dataSource!deleteDsc.action'
					,{'dsc.dscId':id}
					,function(data,textStatus,jqXHR){
						if(data.status==true){
							reloadDataSource();
						}
						
						alert(data.info);
					}
					,'json'
			);
			
			return true;
		}else{
			return false;
		}
		
	}
	
</script>
<body>
<div class="lefter">
    <div class="logo"><a href="http://www.pintuer.com" target="_blank"><img src="images/logo.png" alt="后台管理系统" /></a></div>
</div>

<jsp:include page="${path}/common/navigation_bar.jsp" flush="true" />

<div class="admin">

	<div class="tab">
      <div class="tab-head">
        <strong>系统设置</strong>
        <ul class="tab-nav">
          <li class="active"><a href="#tab-datasource">数据源设置</a></li>
          <li><a href="#tab-dimensionIndex">维度指标设置</a></li>
        </ul>
      </div>
      <div class="tab-body">
        <br />
        <div class="tab-panel active" id="tab-datasource">
        	<form id="dataSourceForm" method="post" action="<%=path%>/dataSource!listDscPage.action">
			    <div class="panel admin-panel">
			    	<div class="panel-head"><strong>数据源列表</strong></div>
			        <div class="padding border-bottom">
			        	<input type="text" id="dsc.tableDbName" name="dsc.tableDbName" value="${dsc.tableDbName}" />数据库名称&nbsp;
			        	<input type="text" id="dsc.tableBusName" name="dsc.tableBusName" value="${dsc.tableBusName}" />业务名&nbsp;
			        	<input type="submit" class="button button-small border-yellow" value="查询" />
			            <input type="button" class="button button-small border-green" onclick="openEditDataSourceWin();" value="添加数据源" />
			            <input type="button" class="button button-small border-yellow" value="批量删除" />
			            <input type="button" class="button button-small border-blue" value="回收站" />
			        </div>
			        <table class="table table-hover">
			        	<tr>
			        		<th width="10%">
			        			<input type="checkbox" class="button button-small checkall" name="checkall" checkfor="dscIds" value="全选" />选择
			        		</th>
			        		<th width="25%">数据库名称</th>
			        		<th width="30%">业务名称</th>
			        		<th width="12%">创建时间</th>
			        		<th width="23%">操作</th>
			        	</tr>
			        	
			        	<c:forEach items="${pv.datas }" var="ds">
						<tr>
							<td><input type="checkbox" name="dscIds" value="${ds.dscId}" /></td>
							<td>${ds.tableDbName}</td>
							<td>${ds.tableBusName}</td>
							<td><fmt:formatDate value="${ ds.createTime}" pattern="yyyy-MM-dd"/></td>
							<td>
								<a class="button border-blue button-little" href="javascript:openEditDataSourceWin(${ds.dscId});">修改</a>&nbsp;&nbsp;
								<a class="button border-yellow button-little" href="#" onclick="delDsc(${ds.dscId})">删除</a>&nbsp;&nbsp;
								<a class="button border-blue button-little" href="<%=path%>/dimensionIndexInfo!listDiiPage.action?dii.dscId=${ds.dscId}">配置维度指标</a>
							</td>
						</tr>
						</c:forEach>
			            
			            <!-- <tr><td><input type="checkbox" name="dscId" value="2" /></td><td>起步</td><td>框架包含的文件</td><td>2014-9-20</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
			            <tr><td><input type="checkbox" name="dscId" value="3" /></td><td>起步</td><td>浏览器支持</td><td>2014-9-10</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
			            <tr><td><input type="checkbox" name="dscId" value="4" /></td><td>起步</td><td>移动优先、跨屏响应</td><td>2014-9-1</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
			            <tr><td><input type="checkbox" name="dscId" value="5" /></td><td>起步</td><td>基本页面</td><td>2014-8-20</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
			            <tr><td><input type="checkbox" name="dscId" value="6" /></td><td>起步</td><td>第三方应用支持</td><td>2014-8-10</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
			            <tr><td><input type="checkbox" name="dscId" value="7" /></td><td>起步</td><td>业务合作</td><td>2014-8-1</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
			            <tr><td><input type="checkbox" name="dscId" value="8" /></td><td>起步</td><td>使用许可</td><td>2014-7-20</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
			            <tr><td><input type="checkbox" name="dscId" value="9" /></td><td>CSS</td><td>文本</td><td>2014-7-10</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
			            <tr><td><input type="checkbox" name="dscId" value="10" /></td><td>CSS</td><td>背景、边框、圆角</td><td>2014-7-1</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
			            <tr><td><input type="checkbox" name="dscId" value="11" /></td><td>CSS</td><td>边界、填充</td><td>2014-6-20</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr>
			            <tr><td><input type="checkbox" name="dscId" value="12" /></td><td>CSS</td><td>CSS动画</td><td>2014-6-10</td><td><a class="button border-blue button-little" href="#">修改</a> <a class="button border-yellow button-little" href="#" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a></td></tr> -->
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
							<jsp:param name="url" value="dataSource!listDscPage.action"/>
							<jsp:param name="params" value="dsc.tableDbName,dsc.tableBusName"/>
						</jsp:include>
			            
			        </div>
			    </div>
			    </form>
        	
        
        </div>
        <div class="tab-panel" id="tab-dimensionIndex">维度指标设置</div>
      </div>
    </div>
    
    <br />
    <p class="text-right text-gray">基于<a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图前端框架</a>构建</p>
</div>

<div class="hidden"><script src="http://s4.cnzz.com/stat.php?id=5952475&web_id=5952475" language="JavaScript"></script></div>




</body>
</html>