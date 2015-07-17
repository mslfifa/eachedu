<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>中国移动客户价值评估专题</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link type="image/x-icon" href="<%=basePath%>images/logo1.png" rel="shortcut icon" />
		<link href="<%=basePath%>images/logo1.png" rel="bookmark icon" />
		<link href="<%=basePath%>css/pintuer.css" rel="stylesheet">
		<link href="<%=basePath%>css/style.css" rel="stylesheet">
		<script type="text/javascript" src="<%=basePath%>js/time.js"></script>
		<script src="<%=basePath%>js/pintuer.js"></script>
		<script src="<%=basePath%>js/respond.js"></script>
	</head>

	<body>
		<div class="layout doc-header fixed">
			<div class="layout doc-toper" id=topNav>
				<div class="container" style="margin-left:3%;">
					<div class="line">
						<div class="x8 welcomeInfo">
							<label>欢迎使用客户价值评估专题</label>
							<span id="time"> </span>
						</div>
						<div class="x4 text-right">
							<span class="hidden-l"> </span>
						</div>
					</div>
				</div>
			</div>
			
			<div class="layout" style="height: 53px;" >
			    <div class="container-layout">
			    	<div class="navbar">
						<div class="navbar-head" style="margin-left:3%;padding-top:5px;">
							<a href="<%=basePath%>"><img src="<%=basePath%>images/logo.png" /> <strong class="text-big"></strong> </a>
						</div>
					</div>
			    </div>
			</div>
	
			<!-- top nav start -->
			<div class="layout bg-main bg-inverse fixed" id="logoDiv">
				<div class="container">
					<div class="navbar">
						<!--<div class="navbar-head">
							<button class="button bg-white icon-navicon"></button>
							<a href="<%=basePath%>"><img src="<%=basePath%>images/logo.gif" /> <strong
								class="text-big"></strong> </a>
						</div> -->
						<div class="bg-blue bg-inverse radius nav-navicon" id="nav-bg8">
							<ul class="nav nav-inline nav-menu nav-big navbar-left">
								<li class="active">
									<a href="<%=path%>/custval/custValAct!findFrontStatisPage.action" style="line-height: 30px;">
										客户价值评估
										<span class="arrow"></span>
									</a>
									<ul class="nav nav-menu nav-inline nav-pills nav-right nav-navicon nav-ul-inner"
										id="nav-pills4"  style="width: 200px;">
										<li>
											<a href="<%=path %>/custval/highValCustAct!findQueryPage.action?&noQuery=true">高价值客户信息</a>
										</li>
										<li>
											<a href="<%=path %>/custval/potHighValCustAct!findQueryPage.action?&noQuery=true">潜力高价值客户信息</a>
										</li>
										<li>
											<a href="<%=path %>/custval/highCustLossAct!findQueryPage.action?&noQuery=true">高价值客户流失信息</a>
										</li>
									</ul>
								</li>
								<li>
									<a href="<%=basePath%>custval/custLossAct!findFrontStatisPage.action" style="line-height: 30px;">
										客户流失预警
										<span class="arrow"></span>
									</a>
									<ul
										class="nav nav-menu nav-inline nav-pills nav-right nav-navicon"
										id="nav-pills4" style="width: 200px">
										<li>
											<a href="<%=path%>/custval/custLeaveAct!findQueryPage.action?&noQuery=true">客户离网预警信息</a>
										</li>
									</ul>
								</li>
								<li>
									<a href="<%=path %>/custval/flowCustAct!findFrontStatisPage.action" style="line-height: 30px;">
										流动务工人员识别
										<span class="arrow"></span>
									</a>
									<ul
										class="nav nav-menu nav-inline nav-pills nav-right nav-navicon"
										id="nav-pills4" style="width: 200px">
										<li>
											<a href="<%=path %>/custval/flowCustAct!findQueryPage.action?&noQuery=true">流动务工人员信息</a>
										</li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- top nav end -->
			<div align="center">
				<jsp:include page="/common/error.jsp" flush="true" />
			</div>
		</div>
	</body>
</html>
