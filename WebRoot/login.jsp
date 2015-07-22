<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="keywords" content="个个答登录">
    <meta http-equiv="description" content="个个答登录页面">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  	
    <title>登录</title>
    
    <link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/css/bootstrapValidator.css" rel="stylesheet"/>
	<link href="<%=path%>/css/style.css" rel="stylesheet">
	<script src="<%=path%>/js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="<%=path%>/js/bootstrapValidator.js" type="text/javascript"></script>
	<script src="<%=path%>/js/bootstrap.js" type="text/javascript"></script>
	
  </head>
  
  <body>
  	   <!-- header start -->
	 <div class="navbar login-navbar" role="navigation">
	  		<div class="container">
			    <div class="navbar-header">
				      <a class="navbar-brand" href="javascript:void(0);">
	  						<img src="images/logo.png" class="img-circle img-responsive" style="display:inline-block;width:40px;height:40px;margin-right:20px;"/>
	  						<span>个个答运营管理平台</span>
				      </a>
			    </div>
			</div>
	  </div>
	  <!-- header end -->
	  
	  <!-- login start -->
      <div class="login-container">
      	<div class="container">
        	<form class="login-form" id="loginForm" action="<%=path%>/loginAct!login.action" method="post">
        		<input type="hidden" name="accountType" value="operator_type">
			  <div class="form-group">
			  	<label class="control-label"><strong>登录</strong></label>
			  	<p class="text-warning">登录超时，请重新登录</p>
			  </div>
			  <div class="form-group">
				    <label for="mail" class="control-label hidden" >账号</label>
				    <input type="text" class="form-control" id="email" name="email" placeholder="账号" data-bv-notempty="true" data-bv-notempty-message="用户名不能为空">
			  </div>
			  <div class="form-group">
				    <label for="password" class=" control-label hidden">密码</label>
				    <div class="">
				      <input type="password" class="form-control" id="password" name="password" placeholder="密码" data-bv-notempty="true" data-bv-notempty-message="密码不能为空">
				    </div>
			  </div>
			  <div class="form-group">
			      <div class="checkbox">
			        <label class="remindMe">
			          <input type="checkbox"/> 记住我
			        </label>
			      </div>
			  </div>
			  <div>
			    <font color="red"><strong><c:if test="${not empty loginErr}">${loginErr }</c:if></strong></font>
			  </div>
			  <!-- <div class="form-group">
		        <label for="vercode" class="col-sm-2 control-label hidden">验证码</label>
		        <div class="col-sm-6">
		          <input type="text" class="form-control" id="vercode" check-type="number" range="2.2,5">
		          <button class="btn btn-link" type="button" data-toggle="tooltip" title="验证码会以邮件的方式发送到你的上面填写的邮箱内" data-placement="right" id="getvercode" >获取验证码</button>
		        </div>
		      </div>   -->
			  <div class="form-group">
				  <button type="submit" class="btn btn-login" id="login">登录</button><!-- 在validator.js 中做了校验和跳转 -->
			  </div>
		   </form>
		  </div>
      </div>
      <!-- login end -->
      
      <!-- footer start -->
	 <div class="footer">
      	<div class="container">
	      <ul class="nav">
	        <li>
	           <span class="copy">Copyright &copy;2015 个个答运营管理系统</span>
	           <ul class="foot-help">
				  <li class="">意见反馈</li>
				  <li class="">|</li>
				  <li class="">使用帮助</li>
				  <li class="">|</li>
				  <li class="">联系管理员</li>
				</ul>
	        </li>
	      </ul>
	      </div>
	  </div>
	  <!-- footer end -->

    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/bootstrapValidator.js" type="text/javascript"></script>
    <script src="js/validation.js" type="text/javascript"></script>
  </body>
</html>
