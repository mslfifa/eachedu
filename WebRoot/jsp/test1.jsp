<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="keywords" content="常用元件" />
<meta name="description"
	content="常见的、可重复使用的样式组合，图标、标签、下拉菜单、按钮组、媒体对象、表单、面板等。" />
<title>元件,常用元件-拼图Pintuer</title>
<link href="<%=path%>/css/pintuer.css" rel="stylesheet">
<link href="<%=path%>/css/style.css" rel="stylesheet">
<script src="<%=path%>/js/jquery.js"></script>
<script src="<%=path%>/js/pintuer.js"></script>
<script src="<%=path%>/js/respond.js"></script>
<link type="image/x-icon" href="<%=path%>/images/favicon.ico"
	rel="shortcut icon" />
<link href="<%=path%>/images/favicon.ico" rel="bookmark icon" />
</head>

<body>
	<div class="layout doc-header fixed">
		<div class="layout doc-toper">
			<div class="container">
				<div class="line">
					<div class="x8">欢迎使用拼图响应式前端框架</div>
					<div class="x4 text-right">
						<span class="hidden-l"><a target="_blank"
							href="http://xiangying.pintuer.com/">响应式在线测试</a> | </span><a
							target="_blank"
							href="http://wpa.qq.com/msgrd?v=3&uin=106967808&site=Pintuer&menu=yes">合作洽谈</a>
					</div>
				</div>
			</div>
		</div>

		<div class="container doc-naver">
			<div class="line">
				<div class="xs3 xm3 xb3 doc-logo">
					<button class="button icon-navicon margin-top float-right"
						data-target="#doc-header-pintuer"></button>
					<a href="/"><img src="/images/logo.png" width="180" height="40"
						alt="拼图" class="ring-hover" /></a>
				</div>
				<div class="xl12 xs9 xm9 xb9 doc-nav">
					<ul class="nav nav-inline nav-navicon padding-small-top"
						id="doc-header-pintuer">
						<li><a href="/">首页</a></li>
						<li><a href="/style/index/id/1">起步</a></li>
						<li><a href="/style/index/id/2">CSS</a></li>
						<li class="active"><a href="/style/index/id/3">元件</a></li>
						<li><a href="/style/index/id/4">JS组件</a></li>
						<li><a href="/style/index/id/5">模块</a></li>
						<li><a target="_blank" href="http://faxian.pintuer.com">发现</a></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="bg-main doc-intro">
			<div class="container">
				<h1 class="fadein-top">常用元件</h1>
				<p class="fadein-bottom">常见的、可重复使用的样式组合，图标、标签、下拉菜单、按钮组、媒体对象、表单、面板等。</p>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="line">
			<div class="xl12 xs12 xm9 xb9">
				<!--list.start-->
				<div class="doc-right">
					<h2 class="doc-h2" id="overview">概述</h2>
					<p class="doc-lead">元件是由一系列的HTML和CSS元素灵活组合而成的代码，同时元件也是供使用者灵活组合使用，前端设计开发就像玩游戏一样简单而又富有乐趣。</p>
					<br />
					<br />
					<h2 class="doc-h2" id="gridsystem">网格系统</h2>
					<p class="doc-lead">拼图框架内置一套响应式网格系统是，不同分辨率或设备可自动适应大小，使得页面在不同设备上都有良好的表现。</p>
					<h3 class="doc-h3" id="grad-intro">简介</h3>
					<p class="doc-readme">网格系统用于通过一系列的行与格子的组合创建页面布局，将每行分成12个格式而形成网格系统。</p>
					<div class="doc-input">
						<ul>
							<li>行.line必须包含在.container中；当使用100%的页面宽度时，也可以包含在.container-layout中；</li>
							<li>格式.x(*)必须包含在.line中；</li>
							<li>.x(*)可以随意组合，满行.line内的.x(*)数值的总和等于12；大于12则另起一行显示；</li>
							<li>使用.line时，格子的间距为0px；也可以使用.line-small(4px)、.line-middle(10px)、.line-big(20px)来改变格子的间距。</li>
							<li>x：水平方向的格子；</li>
							<li>数字(*)：包含格子的数量；</li>
							<li>l：手机-超小屏幕(little)；</li>
							<li>s：平板-小屏幕(small)；</li>
							<li>m：桌面-中屏幕(middle)；</li>
							<li>b：桌面宽屏-大屏幕(big)；</li>
						</ul>
					</div>
					<h3 class="doc-h3" id="grid-default">常规布局</h3>
					<p class="doc-readme">常规布局即为非响应式布局，即为在任何屏幕格子比例上都一样的排列方式，不会随着屏幕不同而展示不同的布局。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="doc-grid">

								<div class="line">
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
									<div class="x1">
										<span>x1</span>
									</div>
								</div>

								<div class="line-small clearfix">
									<div class="x3">
										<span>x3</span>
									</div>
									<div class="x9">
										<span>x9</span>
									</div>
								</div>

								<div class="line-middle clearfix">
									<div class="x4">
										<span>x4</span>
									</div>
									<div class="x4">
										<span>x4</span>
									</div>
									<div class="x4">
										<span>x4</span>
									</div>
								</div>

								<div class="line-big clearfix">
									<div class="x6">
										<span>x6</span>
									</div>
									<div class="x6">
										<span>x6</span>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line">
							<div class="x1">x1</div>
							<div class="x1">x1</div>
							<div class="x1">x1</div>
							<div class="x1">x1</div>
							<div class="x1">x1</div>
							<div class="x1">x1</div>
							<div class="x1">x1</div>
							<div class="x1">x1</div>
							<div class="x1">x1</div>
							<div class="x1">x1</div>
							<div class="x1">x1</div>
							<div class="x1">x1</div>
						</div>
						<div class="line-small">
							<div class="x3">x3</div>
							<div class="x9">x9</div>
						</div>
						<div class="line-middle">
							<div class="x4">x4</div>
							<div class="x4">x4</div>
							<div class="x4">x4</div>
						</div>
						<div class="line-big">
							<div class="x6">x6</div>
							<div class="x6">x6</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">水平移动</h4>
					<div class="doc-input">给例添加.x(*)-move样式，可以快速实现元素的水平方向移动。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="doc-grid">
								<div class="line">
									<div class="x3 x5-move">
										<span>x3 x5-move 3格-移动5格</span>
									</div>
								</div>
								<div class="line">
									<div class="x5 x2-move">
										<span>x5 x2-move 5格-移动2格</span>
									</div>
								</div>
								<div class="line">
									<div class="x4 x1-move">
										<span>x4 x1-move 4格-移动1格</span>
									</div>
									<div class="x3 x2-move">
										<span>x3 x2-move 3格-移动2格</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line">
							<div class="x3 x5-move">x3 x5-move 3格-移动5格</div>
						</div>
						<div class="line">
							<div class="x5 x2-move">x5 x2-move 5格-移动2格</div>
						</div>
						<div class="line">
							<div class="x4 x1-move">x4 x1-move 4格-移动1格</div>
							<div class="x3 x2-move">x3 x2-move 4格-移动2格</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">内嵌套</h4>
					<div class="doc-input">大格子里面包含小格子，12个格子为一整行，超出则为换行。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="doc-grid">
								<div class="line">
									<div class="x6"
										style="border: solid 1px #ddd; border-radius: 2em;">
										<div class="x3">
											<span>x3</span>
										</div>
										<div class="x3">
											<span>x3</span>
										</div>
										<div class="x3">
											<span>x3</span>
										</div>
										<div class="x3">
											<span>x3</span>
										</div>
									</div>
								</div>
								<div class="line">
									<div class="x9"
										style="border: solid 1px #ddd; border-radius: 2em;">
										<div class="x6">
											<span>x6</span>
										</div>
										<div class="x6">
											<span>x6</span>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line">
							<div class="x6">
								<div class="x3">x3</div>
								<div class="x3">x3</div>
								<div class="x3">x3</div>
								<div class="x3">x3</div>
							</div>
						</div>
						<div class="line">
							<div class="x9">
								<div class="x6">x6</div>
								<div class="x6">x6</div>
							</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">格子排序</h4>
					<div class="doc-input">使用.x(*)-left和.x(*)-right样式，可以改变格子的排序显示。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="doc-grid">
								<div class="line">
									<div class="x4 x8-left">
										<span>x4 x8-left</span>
									</div>
									<div class="x8 x4-right">
										<span>x8 x4-right</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line">
							<div class="x4 x8-left">x4 x8-left</div>
							<div class="x8 x4-right">x8 x4-right</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="grid-responsive">跨屏响应式布局</h3>
					<p class="doc-readme">跨屏响应式布局，分为两种方式，在支持CSS3的浏览器中，拼图采用的是媒体查询(media
						query)，当不支持css3的浏览器IE8时，拼图引入Respond.js来实现媒体查询。</p>
					<h4 class="doc-title">媒体查询方式</h4>
					<div class="doc-code">
						<xmp>超小屏幕(手机，小于 760px) 没有任何媒体查询相关的代码，因为这在 拼图 中是默认的

						小屏幕(平板，大于等于 760px) @media (min-width: 760px) { ... }

						中等屏幕(桌面显示器，大于等于 1000px) @media (min-width: 1000px) { ... }

						大屏幕(宽屏显示器，大于等于 1200px) @media (min-width: 1200px) { ... }</xmp>
					</div>
					<h4 class="doc-title">跨屏响应参数</h4>
					<div class="doc-input">
						<div class="table-responsive">
							<table class="table table-bordered">
								<tr>
									<th>&nbsp</th>
									<th>超小屏幕 <small>(手机<760px)</small></th>
									<th>小屏幕 <small>(平板≥760px)</small></th>
									<th>中屏幕 <small>(桌面≥1000px)</small></th>
									<th>大屏幕 <small>(宽屏≥1200px)</small></th>
								</tr>
								<tr>
									<td>.container最大值</td>
									<td>自动</td>
									<td>740px</td>
									<td>980px</td>
									<td>1180px</td>
								</tr>
								<tr>
									<td>格子样式</td>
									<td>.xl-(*)</td>
									<td>.xs-(*)</td>
									<td>.xm-(*)</td>
									<td>.xb-(*)</td>
								</tr>
								<tr>
									<td>响应效果</td>
									<td>总是水平排列</td>
									<td colspan="3">水平排列，当屏幕小于这些阈值时堆叠在一起</td>
								</tr>
								<tr>
									<td>格子数</td>
									<td colspan="4">12</td>
								</tr>
								<tr>
									<td colspan="5" align="center"><strong>响应显示及隐藏：</strong>控制在对应屏幕下的显示和隐藏</td>
								</tr>
								<tr>
									<td>显示响应</td>
									<td>.show-l</td>
									<td>.show-s</td>
									<td>.show-m</td>
									<td>.show-b</td>
								</tr>
								<tr>
									<td>隐藏响应</td>
									<td>.hidden-l</td>
									<td>.hidden-s</td>
									<td>.hidden-m</td>
									<td>.hidden-b</td>
								</tr>
							</table>
						</div>
						<br />
						<br />

						<div class="table-responsive">
							<table class="table table-bordered">
								<tr>
									<th colspan="5"><strong>格子间距</strong></th>
								</tr>
								<tr>
									<td>行样式</td>
									<td>.line</td>
									<td>.line-small</td>
									<td>.line-middle</td>
									<td>.line-big</td>
								</tr>
								<tr>
									<td>间距</td>
									<td>0px</td>
									<td>4px</td>
									<td>10px</td>
									<td>20px</td>
								</tr>
							</table>
						</div>
					</div>
					<blockquote class="quote border-yellow doc-quoteyellow">
						<strong>水平移动、嵌套和格子排序</strong>
						和常规布局一样，跨屏响应式布局也可以使用水平移动、内嵌套和格子排序；使用的样式分别为移动：.x(*)-move；排序：.x(*)-left，.x(*)-right样式。
					</blockquote>
					<h4 class="doc-title">响应示例</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="doc-grid">

								<div class="line-small">
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
									<div class="xl1">
										<span>xl1</span>
									</div>
								</div>
								<div class="line-big">
									<div class="xs3">
										<span>xs3</span>
									</div>
									<div class="xs9">
										<span>xs9</span>
									</div>
								</div>
								<div class="line-middle">
									<div class="xm4">
										<span>xm4</span>
									</div>
									<div class="xm4">
										<span>xm4</span>
									</div>
									<div class="xm4">
										<span>xm4</span>
									</div>
								</div>
								<div class="line">
									<div class="xb6">
										<span>xb6</span>
									</div>
									<div class="xb6">
										<span>xb6</span>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line-small">
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
							<div class="xl1">xl1</div>
						</div>
						<div class="line-big">
							<div class="xs3">xs3</div>
							<div class="xs9">xs9</div>
						</div>
						<div class="line-middle">
							<div class="xm4">xm4</div>
							<div class="xm4">xm4</div>

							<div class="xm4">xm4</div>
						</div>
						<div class="line">
							<div class="xb6">xb6</div>
							<div class="xb6">xb6</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">水平移动</h4>
					<div class="doc-input">给例添加.xl(*)-move,.xs(*)-move,.xm(*)-move,.xb(*)-move样式，可以快速实现元素的水平方向移动。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="doc-grid">
								<div class="line">
									<div class="xl3 xl5-move">
										<span>xl3 xl5-move 3格-移动5格</span>
									</div>
								</div>
								<div class="line">
									<div class="xs5 xs2-move">
										<span>xs5 xs2-move 5格-移动2格</span>
									</div>
								</div>
								<div class="line">
									<div class="xm4 xm1-move">
										<span>xm4 xm1-move 4格-移动1格</span>
									</div>
									<div class="xm3 xm2-move">
										<span>xm4 xm2-move 4格-移动2格</span>
									</div>
								</div>
								<div class="line">
									<div class="xb3 xb1-move">
										<span>xb3 xb1-move 3格-移动1格</span>
									</div>
									<div class="xb3 xb1-move">
										<span>xb3 xb1-move 3格-移动1格</span>
									</div>
									<div class="xb3 xb1-move">
										<span>xb3 xb1-move 3格-移动1格</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line">
							<div class="xl3 xl5-move">xl3 xl5-move 3格-移动5格</div>
						</div>
						<div class="line">
							<div class="xs5 xs2-move">xs5 xs2-move 5格-移动2格</div>
						</div>
						<div class="line">
							<div class="xm4 xm1-move">xm4 xm1-move 4格-移动1格</div>
							<div class="xm3 xm2-move">xm4 xm2-move 4格-移动2格</div>
						</div>
						<div class="line">
							<div class="xb3 xb1-move">xb3 xb1-move 3格-移动1格</div>
							<div class="xb3 xb1-move">xb3 xb1-move 3格-移动1格</div>
							<div class="xb3 xb1-move">xb3 xb1-move 3格-移动1格</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">内嵌套</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="doc-grid">
								<div class="line">
									<div class="xl6"
										style="border: solid 1px #ddd; border-radius: 2em;">
										<div class="xl3">
											<span>xl3</span>
										</div>
										<div class="xl3">
											<span>xl3</span>
										</div>
										<div class="xl3">
											<span>xl3</span>
										</div>
										<div class="xl3">
											<span>xl3</span>
										</div>
									</div>
								</div>
								<div class="line">
									<div class="xs8"
										style="border: solid 1px #ddd; border-radius: 2em;">
										<div class="xs6">
											<span>xs6</span>
										</div>
										<div class="xs6">
											<span>xs6</span>
										</div>
									</div>
								</div>
								<div class="line">
									<div class="xm10"
										style="border: solid 1px #ddd; border-radius: 2em;">
										<div class="xm4">
											<span>xm4</span>
										</div>
										<div class="xm4">
											<span>xm4</span>
										</div>
										<div class="xm4">
											<span>xm4</span>
										</div>
									</div>
								</div>
								<div class="line">
									<div class="xb12"
										style="border: solid 1px #ddd; border-radius: 2em;">
										<div class="xb3">
											<span>xb3</span>
										</div>
										<div class="xb3">
											<span>xb3</span>
										</div>
										<div class="xb3">
											<span>xb3</span>
										</div>
										<div class="xb3">
											<span>xb3</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line">
							<div class="xl6">
								<div class="xl3">xl3</div>
								<div class="xl3">xl3</div>
								<div class="xl3">xl3</div>
								<div class="xl3">xl3</div>
							</div>
						</div>
						<div class="line">
							<div class="xs8">
								<div class="xs6">xs6</div>
								<div class="xs6">xs6</div>
							</div>
						</div>
						<div class="line">
							<div class="xm10">
								<div class="xm4">xm4</div>
								<div class="xm4">xm4</div>
								<div class="xm4">xm4</div>
							</div>
						</div>
						<div class="line">
							<div class="xb12">
								<div class="xb3">xb3</div>
								<div class="xb3">xb3</div>
								<div class="xb3">xb3</div>
								<div class="xb3">xb3</div>
							</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">格子排序</h4>
					<div class="doc-input">使用.xl(*)-left和.xl(*)-right、.xs(*)-left和.xs(*)-right、.xm(*)-left和.xm(*)-right、.xb(*)-left和.xb(*)-right样式，可以改变格子的排序显示。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="doc-grid">
								<div class="line">
									<div class="xl2 xl10-left">
										<span>xl2 xl10-left</span>
									</div>
									<div class="xl10 xl2-right">
										<span>xl10 xl2-right</span>
									</div>
								</div>
								<div class="line">
									<div class="xs4 xs8-left">
										<span>xs4 xs8-left</span>
									</div>
									<div class="xs8 xs4-right">
										<span>xs8 xs4-right</span>
									</div>
								</div>
								<div class="line">
									<div class="xm6 xm6-left">
										<span>xm6 xm6-left</span>
									</div>
									<div class="xm6 xm6-right">
										<span>xm6 xm6-right</span>
									</div>
								</div>
								<div class="line">

									<div class="xb8 xb4-left">
										<span>xb8 xb4-left</span>
									</div>
									<div class="xb4 xb8-right">
										<span>xb4 xb8-right</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line">
							<div class="xl2 xl10-left">xl2 xl10-left</div>
							<div class="xl10 xl2-right">xl10 xl2-right</div>
						</div>
						<div class="line">
							<div class="xs4 xs8-left">xs4 xs8-left</div>
							<div class="xs8 xs4-right">xs8 xs4-right</div>
						</div>
						<div class="line">
							<div class="xm6 xm6-left">xm6 xm6-left</div>
							<div class="xm6 xm6-right">xm6 xm6-right</div>
						</div>
						<div class="line">
							<div class="xb8 xb4-left">xb8 xb4-left</div>
							<div class="xb4 xb8-right">xb4 xb8-right</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">显示及隐藏</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="doc-grid">

								<div class="line">
									<div class="xs4 hidden-l">
										<span>hidden-l超小屏幕下隐藏</span>
									</div>
									<div class="xs8 show-b" style="display: none;">
										<span>show-b 宽屏下显示</span>
									</div>
								</div>
								<div class="line">
									<div class="xm4 hidden-s">
										<span>小屏幕下隐藏</span>
									</div>
									<div class="xm4 hidden-m">
										<span>中屏幕下隐藏</span>
									</div>
									<div class="xm4 show-l" style="display: none;">
										<span>超小屏幕下显示</span>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line">
							<div class="xs4 hidden-l">hidden-l超小屏幕下隐藏</div>
							<div class="xs8 show-b" style="display: none;">show-b 宽屏下显示</div>
						</div>
						<div class="line">
							<div class="xm4 hidden-s">小屏幕下隐藏</div>
							<div class="xm4 hidden-m">中屏幕下隐藏</div>
							<div class="xm4 show-l" style="display: none;">超小屏幕下显示</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="grid-demo">综合实例</h3>
					<p class="doc-readme">手机、平板、桌面、大屏幕跨屏转换实例。</p>
					<h4 class="doc-title">从手机、平板、桌面的媒体查询</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="doc-grid">
								<div class="line-big">
									<div class="xs6 xm3">
										<span>xs6 xm3</span>
									</div>
									<div class="xs6 xm9">
										<span>xs6 xm9</span>
									</div>
								</div>
								<div class="line">
									<div class="xs12 xm6 xb4">
										<span>xs12 xm6 xb4</span>
									</div>
									<div class="xs12 xm6 xb4">
										<span>xs12 xm6 xb4</span>
									</div>
									<div class="xs12 xm6 xb4">
										<span>xs12 xm6 xb4</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line-big">
							<div class="xs6 xm3">xs6 xm3</div>
							<div class="xs6 xm9">xs6 xm9</div>
						</div>
						<div class="line">
							<div class="xs12 xm6 xb4">xs12 xm6 xb4</div>
							<div class="xs12 xm6 xb4">xs12 xm6 xb4</div>
							<div class="xs12 xm6 xb4">xs12 xm6 xb4</div>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="icon">图标</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="icon-small">CSS小图标</h3>
					<p class="doc-readme">关闭按钮、向左、向右、上箭头，下箭头等常用小按钮。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<span class="close"></span> <span class="leftward"></span> <span
								class="rightward"></span> <span class="upward"></span> <span
								class="downward"></span>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<span class="close"></span> <span class="leftward"></span> <span
							class="rightward"></span> <span class="upward"></span> <span
							class="downward"></span></xmp>
					</div>
					<blockquote class="quote border-yellow doc-quoteyellow">
						<strong>浏览器兼容</strong> 上、下、左、右的箭头在IE6下不支持显示，需要对其支持慎用，也可以自己改用图片样式。
					</blockquote>
					<h3 class="doc-h3" id="icons">字体图标</h3>
					<p class="doc-readme">500多个Font Awesome字体图标。</p>
					<h4 class="doc-title">网络应用图标</h4>
					<div class="doc-input">
						<ul class="doc-icons">
							<li><span class="icon-adjust"></span><span>icon-adjust</span></li>
							<li><span class="icon-anchor"></span><span>icon-anchor</span></li>
							<li><span class="icon-archive"></span><span>icon-archive</span></li>
							<li><span class="icon-arrows"></span><span>icon-arrows</span></li>
							<li><span class="icon-arrows-h"></span><span>icon-arrows-h</span></li>
							<li><span class="icon-arrows-v"></span><span>icon-arrows-v</span></li>
							<li><span class="icon-asterisk"></span><span>icon-asterisk</span></li>
							<li><span class="icon-automobile"></span><span>icon-automobile
									(alias)</span></li>
							<li><span class="icon-ban"></span><span>icon-ban</span></li>
							<li><span class="icon-bank"></span><span>icon-bank
									(alias)</span></li>
							<li><span class="icon-bar-chart-o"></span><span>icon-bar-chart-o</span></li>
							<li><span class="icon-barcode"></span><span>icon-barcode</span></li>
							<li><span class="icon-bars"></span><span>icon-bars</span></li>
							<li><span class="icon-beer"></span><span>icon-beer</span></li>
							<li><span class="icon-bell"></span><span>icon-bell</span></li>
							<li><span class="icon-bell-o"></span><span>icon-bell-o</span></li>
							<li><span class="icon-bolt"></span><span>icon-bolt</span></li>
							<li><span class="icon-bomb"></span><span>icon-bomb</span></li>
							<li><span class="icon-book"></span><span>icon-book</span></li>
							<li><span class="icon-bookmark"></span><span>icon-bookmark</span></li>
							<li><span class="icon-bookmark-o"></span><span>icon-bookmark-o</span></li>
							<li><span class="icon-briefcase"></span><span>icon-briefcase</span></li>
							<li><span class="icon-bug"></span><span>icon-bug</span></li>
							<li><span class="icon-building"></span><span>icon-building</span></li>
							<li><span class="icon-building-o"></span><span>icon-building-o</span></li>
							<li><span class="icon-bullhorn"></span><span>icon-bullhorn</span></li>
							<li><span class="icon-bullseye"></span><span>icon-bullseye</span></li>
							<li><span class="icon-cab"></span><span>icon-cab
									(alias)</span></li>
							<li><span class="icon-calendar"></span><span>icon-calendar</span></li>
							<li><span class="icon-calendar-o"></span><span>icon-calendar-o</span></li>
							<li><span class="icon-camera"></span><span>icon-camera</span></li>
							<li><span class="icon-camera-retro"></span><span>icon-camera-retro</span></li>
							<li><span class="icon-car"></span><span>icon-car</span></li>
							<li><span class="icon-caret-square-o-down"></span><span>icon-caret-square-o-down</span></li>
							<li><span class="icon-caret-square-o-left"></span><span>icon-square-o-left</span></li>
							<li><span class="icon-caret-square-o-right"></span><span>icon-square-o-right</span></li>
							<li><span class="icon-caret-square-o-up"></span><span>icon-caret-square-o-up</span></li>
							<li><span class="icon-certificate"></span><span>icon-certificate</span></li>
							<li><span class="icon-check"></span><span>icon-check</span></li>
							<li><span class="icon-check-circle"></span><span>icon-check-circle</span></li>
							<li><span class="icon-check-circle-o"></span><span>icon-check-circle-o</span></li>
							<li><span class="icon-check-square"></span><span>icon-check-square</span></li>
							<li><span class="icon-check-square-o"></span><span>icon-check-square-o</span></li>
							<li><span class="icon-child"></span><span>icon-child</span></li>
							<li><span class="icon-circle"></span><span>icon-circle</span></li>
							<li><span class="icon-circle-o"></span><span>icon-circle-o</span></li>
							<li><span class="icon-circle-o-notch"></span><span>icon-circle-o-notch</span></li>
							<li><span class="icon-circle-thin"></span><span>icon-circle-thin</span></li>
							<li><span class="icon-clock-o"></span><span>icon-clock-o</span></li>
							<li><span class="icon-cloud"></span><span>icon-cloud</span></li>
							<li><span class="icon-cloud-download"></span><span>icon-cloud-download</span></li>
							<li><span class="icon-cloud-upload"></span><span>icon-cloud-upload</span></li>
							<li><span class="icon-code"></span><span>icon-code</span></li>
							<li><span class="icon-code-fork"></span><span>icon-code-fork</span></li>
							<li><span class="icon-coffee"></span><span>icon-coffee</span></li>
							<li><span class="icon-cog"></span><span>icon-cog</span></li>
							<li><span class="icon-cogs"></span><span>icon-cogs</span></li>
							<li><span class="icon-comment"></span><span>icon-comment</span></li>
							<li><span class="icon-comment-o"></span><span>icon-comment-o</span></li>
							<li><span class="icon-comments"></span><span>icon-comments</span></li>
							<li><span class="icon-comments-o"></span><span>icon-comments-o</span></li>
							<li><span class="icon-compass"></span><span>icon-compass</span></li>
							<li><span class="icon-credit-card"></span><span>icon-credit-card</span></li>
							<li><span class="icon-crop"></span><span>icon-crop</span></li>
							<li><span class="icon-crosshairs"></span><span>icon-crosshairs</span></li>
							<li><span class="icon-cube"></span><span>icon-cube</span></li>
							<li><span class="icon-cubes"></span><span>icon-cubes</span></li>
							<li><span class="icon-cutlery"></span><span>icon-cutlery</span></li>
							<li><span class="icon-dashboard"></span><span>icon-dashboard
									(alias)</span></li>
							<li><span class="icon-database"></span><span>icon-database</span></li>
							<li><span class="icon-desktop"></span><span>icon-desktop</span></li>
							<li><span class="icon-dot-circle-o"></span><span>icon-dot-circle-o</span></li>
							<li><span class="icon-download"></span><span>icon-download</span></li>
							<li><span class="icon-edit"></span><span>icon-edit
									(alias)</span></li>
							<li><span class="icon-ellipsis-h"></span><span>icon-ellipsis-h</span></li>
							<li><span class="icon-ellipsis-v"></span><span>icon-ellipsis-v</span></li>
							<li><span class="icon-envelope"></span><span>icon-envelope</span></li>
							<li><span class="icon-envelope-o"></span><span>icon-envelope-o</span></li>
							<li><span class="icon-envelope-square"></span><span>icon-envelope-square</span></li>
							<li><span class="icon-eraser"></span><span>icon-eraser</span></li>
							<li><span class="icon-exchange"></span><span>icon-exchange</span></li>
							<li><span class="icon-exclamation"></span><span>icon-exclamation</span></li>
							<li><span class="icon-exclamation-circle"></span><span>icon-exclamation-circle</span></li>
							<li><span class="icon-exclamation-triangle"></span><span>icon-exclamation-triangle</span></li>
							<li><span class="icon-external-link"></span><span>icon-external-link</span></li>
							<li><span class="icon-external-link-square"></span><span>icon-external-link-square</span></li>
							<li><span class="icon-eye"></span><span>icon-eye</span></li>
							<li><span class="icon-eye-slash"></span><span>icon-eye-slash</span></li>
							<li><span class="icon-fax"></span><span>icon-fax</span></li>
							<li><span class="icon-female"></span><span>icon-female</span></li>
							<li><span class="icon-fighter-jet"></span><span>icon-fighter-jet</span></li>
							<li><span class="icon-file-archive-o"></span><span>icon-file-archive-o</span></li>
							<li><span class="icon-file-audio-o"></span><span>icon-file-audio-o</span></li>
							<li><span class="icon-file-code-o"></span><span>icon-file-code-o</span></li>
							<li><span class="icon-file-excel-o"></span><span>icon-file-excel-o</span></li>
							<li><span class="icon-file-image-o"></span><span>icon-file-image-o</span></li>
							<li><span class="icon-file-movie-o"></span><span>icon-file-movie-o
									(alias)</span></li>
							<li><span class="icon-file-pdf-o"></span><span>icon-file-pdf-o</span></li>
							<li><span class="icon-file-photo-o"></span><span>icon-file-photo-o
									(alias)</span></li>
							<li><span class="icon-file-picture-o"></span><span>icon-file-picture-o
									(alias)</span></li>
							<li><span class="icon-file-powerpoint-o"></span><span>icon-file-powerpoint-o</span></li>
							<li><span class="icon-file-sound-o"></span><span>icon-file-sound-o
									(alias)</span></li>
							<li><span class="icon-file-video-o"></span><span>icon-file-video-o</span></li>
							<li><span class="icon-file-word-o"></span><span>icon-file-word-o</span></li>
							<li><span class="icon-file-zip-o"></span><span>icon-file-zip-o
									(alias)</span></li>
							<li><span class="icon-film"></span><span>icon-film</span></li>
							<li><span class="icon-filter"></span><span>icon-filter</span></li>
							<li><span class="icon-fire"></span><span>icon-fire</span></li>
							<li><span class="icon-fire-extinguisher"></span><span>icon-fire-extinguisher</span></li>
							<li><span class="icon-flag"></span><span>icon-flag</span></li>
							<li><span class="icon-flag-checkered"></span><span>icon-flag-checkered</span></li>
							<li><span class="icon-flag-o"></span><span>icon-flag-o</span></li>
							<li><span class="icon-flash"></span><span>icon-flash
									(alias)</span></li>
							<li><span class="icon-flask"></span><span>icon-flask</span></li>
							<li><span class="icon-folder"></span><span>icon-folder</span></li>
							<li><span class="icon-folder-o"></span><span>icon-folder-o</span></li>
							<li><span class="icon-folder-open"></span><span>icon-folder-open</span></li>
							<li><span class="icon-folder-open-o"></span><span>icon-folder-open-o</span></li>
							<li><span class="icon-frown-o"></span><span>icon-frown-o</span></li>
							<li><span class="icon-gamepad"></span><span>icon-gamepad</span></li>
							<li><span class="icon-gavel"></span><span>icon-gavel</span></li>
							<li><span class="icon-gear"></span><span>icon-gear
									(alias)</span></li>
							<li><span class="icon-gears"></span><span>icon-gears
									(alias)</span></li>
							<li><span class="icon-gift"></span><span>icon-gift</span></li>
							<li><span class="icon-glass"></span><span>icon-glass</span></li>
							<li><span class="icon-globe"></span><span>icon-globe</span></li>
							<li><span class="icon-graduation-cap"></span><span>icon-graduation-cap</span></li>
							<li><span class="icon-group"></span><span>icon-group
									(alias)</span></li>
							<li><span class="icon-hdd-o"></span><span>icon-hdd-o</span></li>
							<li><span class="icon-headphones"></span><span>icon-headphones</span></li>
							<li><span class="icon-heart"></span><span>icon-heart</span></li>
							<li><span class="icon-heart-o"></span><span>icon-heart-o</span></li>
							<li><span class="icon-history"></span><span>icon-history</span></li>
							<li><span class="icon-home"></span><span>icon-home</span></li>
							<li><span class="icon-image"></span><span>icon-image
									(alias)</span></li>
							<li><span class="icon-inbox"></span><span>icon-inbox</span></li>
							<li><span class="icon-info"></span><span>icon-info</span></li>
							<li><span class="icon-info-circle"></span><span>icon-info-circle</span></li>
							<li><span class="icon-institution"></span><span>icon-institution
									(alias)</span></li>
							<li><span class="icon-key"></span><span>icon-key</span></li>
							<li><span class="icon-keyboard-o"></span><span>icon-keyboard-o</span></li>
							<li><span class="icon-language"></span><span>icon-language</span></li>
							<li><span class="icon-laptop"></span><span>icon-laptop</span></li>
							<li><span class="icon-leaf"></span><span>icon-leaf</span></li>
							<li><span class="icon-legal"></span><span>icon-legal
									(alias)</span></li>
							<li><span class="icon-lemon-o"></span><span>icon-lemon-o</span></li>
							<li><span class="icon-level-down"></span><span>icon-level-down</span></li>
							<li><span class="icon-level-up"></span><span>icon-level-up</span></li>
							<li><span class="icon-life-bouy"></span><span>icon-life-bouy
									(alias)</span></li>
							<li><span class="icon-life-ring"></span><span>icon-life-ring</span></li>
							<li><span class="icon-life-saver"></span><span>icon-life-saver
									(alias)</span></li>
							<li><span class="icon-lightbulb-o"></span><span>icon-lightbulb-o</span></li>
							<li><span class="icon-location-arrow"></span><span>icon-location-arrow</span></li>
							<li><span class="icon-lock"></span><span>icon-lock</span></li>
							<li><span class="icon-magic"></span><span>icon-magic</span></li>
							<li><span class="icon-magnet"></span><span>icon-magnet</span></li>
							<li><span class="icon-mail-forward"></span><span>icon-mail-forward
									(alias)</span></li>
							<li><span class="icon-mail-reply"></span><span>icon-mail-reply
									(alias)</span></li>
							<li><span class="icon-mail-reply-all"></span><span>icon-mail-reply-all
									(alias)</span></li>
							<li><span class="icon-male"></span><span>icon-male</span></li>
							<li><span class="icon-map-marker"></span><span>icon-map-marker</span></li>
							<li><span class="icon-meh-o"></span><span>icon-meh-o</span></li>
							<li><span class="icon-microphone"></span><span>icon-microphone</span></li>
							<li><span class="icon-microphone-slash"></span><span>icon-microphone-slash</span></li>
							<li><span class="icon-minus"></span><span>icon-minus</span></li>
							<li><span class="icon-minus-circle"></span><span>icon-minus-circle</span></li>
							<li><span class="icon-minus-square"></span><span>icon-minus-square</span></li>
							<li><span class="icon-minus-square-o"></span><span>icon-minus-square-o</span></li>
							<li><span class="icon-mobile"></span><span>icon-mobile</span></li>
							<li><span class="icon-mobile-phone"></span><span>icon-mobile-phone
									(alias)</span></li>
							<li><span class="icon-money"></span><span>icon-money</span></li>
							<li><span class="icon-moon-o"></span><span>icon-moon-o</span></li>
							<li><span class="icon-mortar-board"></span><span>icon-mortar-board
									(alias)</span></li>
							<li><span class="icon-music"></span><span>icon-music</span></li>
							<li><span class="icon-navicon"></span><span>icon-navicon
									(alias)</span></li>
							<li><span class="icon-paper-plane"></span><span>icon-paper-plane</span></li>
							<li><span class="icon-paper-plane-o"></span><span>icon-paper-plane-o</span></li>
							<li><span class="icon-paw"></span><span>icon-paw</span></li>
							<li><span class="icon-pencil"></span><span>icon-pencil</span></li>
							<li><span class="icon-pencil-square"></span><span>icon-pencil-square</span></li>
							<li><span class="icon-pencil-square-o"></span><span>icon-pencil-square-o</span></li>
							<li><span class="icon-phone"></span><span>icon-phone</span></li>
							<li><span class="icon-phone-square"></span><span>icon-phone-square</span></li>
							<li><span class="icon-photo"></span><span>icon-photo
									(alias)</span></li>
							<li><span class="icon-picture-o"></span><span>icon-picture-o</span></li>
							<li><span class="icon-plane"></span><span>icon-plane</span></li>
							<li><span class="icon-plus"></span><span>icon-plus</span></li>
							<li><span class="icon-plus-circle"></span><span>icon-plus-circle</span></li>
							<li><span class="icon-plus-square"></span><span>icon-plus-square</span></li>
							<li><span class="icon-plus-square-o"></span><span>icon-plus-square-o</span></li>
							<li><span class="icon-power-off"></span><span>icon-power-off</span></li>
							<li><span class="icon-print"></span><span>icon-print</span></li>
							<li><span class="icon-puzzle-piece"></span><span>icon-puzzle-piece</span></li>
							<li><span class="icon-qrcode"></span><span>icon-qrcode</span></li>
							<li><span class="icon-question"></span><span>icon-question</span></li>
							<li><span class="icon-question-circle"></span><span>icon-question-circle</span></li>
							<li><span class="icon-quote-left"></span><span>icon-quote-left</span></li>
							<li><span class="icon-quote-right"></span><span>icon-quote-right</span></li>
							<li><span class="icon-random"></span><span>icon-random</span></li>
							<li><span class="icon-recycle"></span><span>icon-</span></li>
							<li><span class="icon-refresh"></span><span>icon-refresh</span></li>
							<li><span class="icon-reorder"></span><span>icon-reorder
									(alias)</span></li>
							<li><span class="icon-reply"></span><span>icon-reply</span></li>
							<li><span class="icon-reply-all"></span><span>icon-reply-all</span></li>
							<li><span class="icon-retweet"></span><span>icon-retweet</span></li>
							<li><span class="icon-road"></span><span>icon-road</span></li>
							<li><span class="icon-rocket"></span><span>icon-rocket</span></li>
							<li><span class="icon-rss"></span><span>icon-rss</span></li>
							<li><span class="icon-rss-square"></span><span>icon-rss-square</span></li>
							<li><span class="icon-search"></span><span>icon-search</span></li>
							<li><span class="icon-search-minus"></span><span>icon-search-minus</span></li>
							<li><span class="icon-search-plus"></span><span>icon-search-plus</span></li>
							<li><span class="icon-send"></span><span>icon-send
									(alias)</span></li>
							<li><span class="icon-send-o"></span><span>icon-send-o
									(alias)</span></li>
							<li><span class="icon-share"></span><span>icon-share</span></li>
							<li><span class="icon-share-alt"></span><span>icon-share-alt</span></li>
							<li><span class="icon-share-alt-square"></span><span>icon-</span></li>
							<li><span class="icon-share-square"></span><span>icon-share-square</span></li>
							<li><span class="icon-share-square-o"></span><span>icon-share-square-o</span></li>
							<li><span class="icon-shield"></span><span>icon-shield</span></li>
							<li><span class="icon-shopping-cart"></span><span>icon-shopping-cart</span></li>
							<li><span class="icon-sign-in"></span><span>icon-sign-in</span></li>
							<li><span class="icon-sign-out"></span><span>icon-sign-out</span></li>
							<li><span class="icon-signal"></span><span>icon-signal</span></li>
							<li><span class="icon-sitemap"></span><span>icon-sitemap</span></li>
							<li><span class="icon-sliders"></span><span>icon-sliders</span></li>
							<li><span class="icon-smile-o"></span><span>icon-smile-o</span></li>
							<li><span class="icon-sort"></span><span>icon-sort</span></li>
							<li><span class="icon-sort-alpha-asc"></span><span>icon-sort-alpha-asc</span></li>
							<li><span class="icon-sort-alpha-desc"></span><span>icon-sort-alpha-desc</span></li>
							<li><span class="icon-sort-amount-asc"></span><span>icon-sort-amount-asc</span></li>
							<li><span class="icon-sort-amount-desc"></span><span>icon-sort-amount-desc</span></li>
							<li><span class="icon-sort-asc"></span><span>icon-sort-asc</span></li>
							<li><span class="icon-sort-desc"></span><span>icon-sort-desc</span></li>
							<li><span class="icon-sort-down"></span><span>icon-sort-down
									(alias)</span></li>
							<li><span class="icon-sort-numeric-asc"></span><span>icon-sort-numeric-asc</span></li>
							<li><span class="icon-sort-numeric-desc"></span><span>icon-sort-numeric-desc</span></li>
							<li><span class="icon-sort-up"></span><span>icon-sort-up
									(alias)</span></li>
							<li><span class="icon-space-shuttle"></span><span>icon-space-shuttle</span></li>
							<li><span class="icon-spinner"></span><span>icon-spinner</span></li>
							<li><span class="icon-spoon"></span><span>icon-spoon</span></li>
							<li><span class="icon-square"></span><span>icon-square</span></li>
							<li><span class="icon-square-o"></span><span>icon-square-o</span></li>
							<li><span class="icon-star"></span><span>icon-star</span></li>
							<li><span class="icon-star-half"></span><span>icon-star-half</span></li>
							<li><span class="icon-star-half-empty"></span><span>icon-star-half-empty
									(alias)</span></li>
							<li><span class="icon-star-half-full"></span><span>icon-star-half-full
									(alias)</span></li>
							<li><span class="icon-star-half-o"></span><span>icon-star-half-o</span></li>
							<li><span class="icon-star-o"></span><span>icon-star-o</span></li>
							<li><span class="icon-suitcase"></span><span>icon-suitcase</span></li>
							<li><span class="icon-sun-o"></span><span>icon-sun-o</span></li>
							<li><span class="icon-support"></span><span>icon-support
									(alias)</span></li>
							<li><span class="icon-tablet"></span><span>icon-tablet</span></li>
							<li><span class="icon-tachometer"></span><span>icon-tachometer</span></li>
							<li><span class="icon-tag"></span><span>icon-tag</span></li>
							<li><span class="icon-tags"></span><span>icon-tags</span></li>
							<li><span class="icon-tasks"></span><span>icon-tasks</span></li>
							<li><span class="icon-taxi"></span><span>icon-taxi</span></li>
							<li><span class="icon-terminal"></span><span>icon-terminal</span></li>
							<li><span class="icon-thumb-tack"></span><span>icon-thumb-tack</span></li>
							<li><span class="icon-thumbs-down"></span><span>icon-thumbs-down</span></li>
							<li><span class="icon-thumbs-o-down"></span><span>icon-thumbs-o-down</span></li>
							<li><span class="icon-thumbs-o-up"></span><span>icon-thumbs-o-up</span></li>
							<li><span class="icon-thumbs-up"></span><span>icon-thumbs-up</span></li>
							<li><span class="icon-ticket"></span><span>icon-ticket</span></li>
							<li><span class="icon-times"></span><span>icon-times</span></li>
							<li><span class="icon-times-circle"></span><span>icon-times-circle</span></li>
							<li><span class="icon-times-circle-o"></span><span>icon-times-circle-o</span></li>
							<li><span class="icon-tint"></span><span>icon-tint</span></li>
							<li><span class="icon-toggle-down"></span><span>icon-toggle-down
									(alias)</span></li>
							<li><span class="icon-toggle-left"></span><span>icon-toggle-right
									(alias)</span></li>
							<li><span class="icon-toggle-right"></span><span>icon-toggle-right
									(alias)</span></li>
							<li><span class="icon-toggle-up"></span><span>icon-toggle-up
									(alias)</span></li>
							<li><span class="icon-trash-o"></span><span>icon-trash-o</span></li>
							<li><span class="icon-tree"></span><span>icon-tree</span></li>
							<li><span class="icon-trophy"></span><span>icon-trophy</span></li>
							<li><span class="icon-truck"></span><span>icon-truck</span></li>
							<li><span class="icon-umbrella"></span><span>icon-umbrella</span></li>
							<li><span class="icon-university"></span><span>icon-university</span></li>
							<li><span class="icon-unlock"></span><span>icon-unlock</span></li>
							<li><span class="icon-unlock-alt"></span><span>icon-unlock-alt</span></li>
							<li><span class="icon-unsorted"></span><span>icon-unsorted
									(alias)</span></li>
							<li><span class="icon-upload"></span><span>icon-upload</span></li>
							<li><span class="icon-user"></span><span>icon-user</span></li>
							<li><span class="icon-users"></span><span>icon-users</span></li>
							<li><span class="icon-video-camera"></span><span>icon-video-camera</span></li>
							<li><span class="icon-volume-down"></span><span>icon-volume-down</span></li>
							<li><span class="icon-volume-off"></span><span>icon-volume-off</span></li>
							<li><span class="icon-volume-up"></span><span>icon-volume-up</span></li>
							<li><span class="icon-warning"></span><span>icon-warning
									(alias)</span></li>
							<li><span class="icon-wheelchair"></span><span>icon-wheelchair</span></li>
							<li><span class="icon-wrench"></span><span>icon-wrench</span></li>
						</ul>
					</div>
					<h4 class="doc-title">文件类型图标</h4>
					<div class="doc-input">
						<ul class="doc-icons">
							<li><span class="icon-file"></span><span>icon-file</span></li>
							<li><span class="icon-file-archive-o"></span><span>icon-file-archive-o</span></li>
							<li><span class="icon-file-audio-o"></span><span>icon-file-audio-o</span></li>
							<li><span class="icon-file-code-o"></span><span>icon-file-code-o</span></li>
							<li><span class="icon-file-excel-o"></span><span>icon-file-excel-o</span></li>
							<li><span class="icon-file-image-o"></span><span>icon-file-image-o</span></li>
							<li><span class="icon-file-movie-o"></span><span>icon-file-movie-o(alias)</span></li>
							<li><span class="icon-file-o"></span><span>icon-file-o</span></li>
							<li><span class="icon-file-pdf-o"></span><span>icon-file-pdf-o</span></li>
							<li><span class="icon-file-photo-o"></span><span>icon-file-photo-o(alias)</span></li>
							<li><span class="icon-file-picture-o"></span><span>icon-file-picture-o(alias)</span></li>
							<li><span class="icon-file-powerpoint-o"></span><span>icon-file-powerpoint-o</span></li>
							<li><span class="icon-file-sound-o"></span><span>icon-file-sound-o(alias)</span></li>
							<li><span class="icon-file-text"></span><span>icon-file-text</span></li>
							<li><span class="icon-file-text-o"></span><span>icon-file-text-o</span></li>
							<li><span class="icon-file-video-o"></span><span>icon-file-video-o</span></li>
							<li><span class="icon-file-word-o"></span><span>icon-file-word-o</span></li>
							<li><span class="icon-file-zip-o"></span><span>icon-file-zip-o(alias)</span></li>
						</ul>
					</div>
					<h4 class="doc-title">旋转图标</h4>
					<div class="doc-input">
						<ul class="doc-icons">
							<li><span class="icon-circle-o-notch"></span><span>icon-circle-o-notch</span></li>
							<li><span class="icon-cog"></span><span>icon-cog</span></li>
							<li><span class="icon-gear"></span><span>icon-gear
									(alias)</span></li>
							<li><span class="icon-refresh"></span><span>icon-refresh</span></li>
							<li><span class="icon-spinner"></span><span>icon-spinner</span></li>
						</ul>
					</div>
					<h4 class="doc-title">表单控制图标</h4>
					<div class="doc-input">
						<ul class="doc-icons">
							<li><span class="icon-check-square"></span><span>icon-check-square</span></li>
							<li><span class="icon-check-square-o"></span><span>icon-check-square-o</span></li>
							<li><span class="icon-circle"></span><span>icon-circle</span></li>
							<li><span class="icon-circle-o"></span><span>icon-circle-o</span></li>
							<li><span class="icon-dot-circle-o"></span><span>icon-dot-circle-o</span></li>
							<li><span class="icon-minus-square"></span><span>icon-minus-square</span></li>
							<li><span class="icon-minus-square-o"></span><span>icon-minus-square-o</span></li>
							<li><span class="icon-plus-square"></span><span>icon-plus-square</span></li>
							<li><span class="icon-plus-square-o"></span><span>icon-plus-square-o</span></li>
							<li><span class="icon-square"></span><span>icon-square</span></li>
							<li><span class="icon-square-o"></span><span>icon-square-o</span></li>
						</ul>
					</div>
					<h4 class="doc-title">货币图标</h4>
					<div class="doc-input">
						<ul class="doc-icons">
							<li><span class="icon-bitcoin"></span><span>icon-icon-bitcoin
									(alias)</span></li>
							<li><span class="icon-btc"></span><span>icon-btc</span></li>
							<li><span class="icon-cny"></span><span>icon-cny
									(alias)</span></li>
							<li><span class="icon-dollar"></span><span>icon-dollar
									(alias)</span></li>
							<li><span class="icon-eur"></span><span>icon-</span></li>
							<li><span class="icon-euro"></span><span>icon-euro
									(alias)</span></li>
							<li><span class="icon-gbp"></span><span>icon-gbp</span></li>
							<li><span class="icon-inr"></span><span>icon-inr</span></li>
							<li><span class="icon-jpy"></span><span>icon-jpy</span></li>
							<li><span class="icon-krw"></span><span>icon-krw</span></li>
							<li><span class="icon-money"></span><span>icon-money</span></li>
							<li><span class="icon-rmb"></span><span>icon-rmb
									(alias)</span></li>
							<li><span class="icon-rouble"></span><span>icon-rouble
									(alias)</span></li>
							<li><span class="icon-rub"></span><span>icon-rub</span></li>
							<li><span class="icon-ruble"></span><span>icon-ruble
									(alias)</span></li>
							<li><span class="icon-rupee"></span><span>icon-rupee
									(alias)</span></li>
							<li><span class="icon-try"></span><span>icon-try</span></li>
							<li><span class="icon-turkish-lira"></span><span>icon-turkish-lira
									(alias)</span></li>
							<li><span class="icon-usd"></span><span>icon-usd</span></li>
							<li><span class="icon-won"></span><span>icon-won
									(alias)</span></li>
							<li><span class="icon-yen"></span><span>icon-yen
									(alias)</span></li>
						</ul>
					</div>
					<h4 class="doc-title">编辑图标</h4>
					<div class="doc-input">
						<ul class="doc-icons">
							<li><span class="icon-align-center"></span><span>icon-align-center</span></li>
							<li><span class="icon-align-justify"></span><span>icon-align-justify</span></li>
							<li><span class="icon-align-left"></span><span>icon-align-left</span></li>
							<li><span class="icon-align-right"></span><span>icon-align-right</span></li>
							<li><span class="icon-bold"></span><span>icon-bold</span></li>
							<li><span class="icon-chain"></span><span>icon-chain
									(alias)</span></li>
							<li><span class="icon-chain-broken"></span><span>icon-chain-broken</span></li>
							<li><span class="icon-clipboard"></span><span>icon-clipboard</span></li>
							<li><span class="icon-columns"></span><span>icon-columns</span></li>
							<li><span class="icon-copy"></span><span>icon-copy
									(alias)</span></li>
							<li><span class="icon-cut"></span><span>icon-cut
									(alias)</span></li>
							<li><span class="icon-dedent"></span><span>icon-dedent
									(alias)</span></li>
							<li><span class="icon-eraser"></span><span>icon-eraser</span></li>
							<li><span class="icon-file"></span><span>icon-file</span></li>
							<li><span class="icon-file-o"></span><span>icon-file-o</span></li>
							<li><span class="icon-file-text"></span><span>icon-file-text</span></li>
							<li><span class="icon-file-text-o"></span><span>icon-file-text-o</span></li>
							<li><span class="icon-files-o"></span><span>icon-files-o</span></li>
							<li><span class="icon-floppy-o"></span><span>icon-floppy-o</span></li>
							<li><span class="icon-font"></span><span>icon-font</span></li>
							<li><span class="icon-header"></span><span>icon-header</span></li>
							<li><span class="icon-indent"></span><span>icon-indent</span></li>
							<li><span class="icon-italic"></span><span>icon-italic</span></li>
							<li><span class="icon-link"></span><span>icon-link</span></li>
							<li><span class="icon-list"></span><span>icon-list</span></li>
							<li><span class="icon-list-alt"></span><span>icon-list-alt</span></li>
							<li><span class="icon-list-ol"></span><span>icon-list-ol</span></li>
							<li><span class="icon-list-ul"></span><span>icon-list-ul</span></li>
							<li><span class="icon-outdent"></span><span>icon-outdent</span></li>
							<li><span class="icon-paperclip"></span><span>icon-paperclip</span></li>
							<li><span class="icon-paragraph"></span><span>icon-paragraph</span></li>
							<li><span class="icon-paste"></span><span>icon-paste
									(alias)</span></li>
							<li><span class="icon-repeat"></span><span>icon-repeat</span></li>
							<li><span class="icon-rotate-left"></span><span>icon-rotate-left
									(alias)</span></li>
							<li><span class="icon-rotate-right"></span><span>icon-rotate-right
									(alias)</span></li>
							<li><span class="icon-save"></span><span>icon-save
									(alias)</span></li>
							<li><span class="icon-scissors"></span><span>icon-scissors</span></li>
							<li><span class="icon-strikethrough"></span><span>icon-strikethrough</span></li>
							<li><span class="icon-subscript"></span><span>icon-subscript</span></li>
							<li><span class="icon-superscript"></span><span>icon-superscript</span></li>
							<li><span class="icon-table"></span><span>icon-table</span></li>
							<li><span class="icon-text-height"></span><span>icon-text-height</span></li>
							<li><span class="icon-text-width"></span><span>icon-text-width</span></li>
							<li><span class="icon-th"></span><span>icon-th</span></li>
							<li><span class="icon-th-large"></span><span>icon-th-large</span></li>
							<li><span class="icon-th-list"></span><span>icon-th-list</span></li>
							<li><span class="icon-underline"></span><span>icon-underline</span></li>
							<li><span class="icon-undo"></span><span>icon-undo</span></li>
							<li><span class="icon-unlink"></span><span>icon-unlink
									(alias)</span></li>
						</ul>
					</div>
					<h4 class="doc-title">指向图标</h4>
					<div class="doc-input">
						<ul class="doc-icons">
							<li><span class="icon-angle-double-down"></span><span>icon-angle-double-down</span></li>
							<li><span class="icon-angle-double-left"></span><span>icon-angle-double-left</span></li>
							<li><span class="icon-angle-double-right"></span><span>icon-angle-double-right</span></li>
							<li><span class="icon-angle-double-up"></span><span>icon-angle-double-up</span></li>
							<li><span class="icon-angle-down"></span><span>icon-angle-down</span></li>
							<li><span class="icon-angle-left"></span><span>icon-angle-left</span></li>
							<li><span class="icon-angle-right"></span><span>icon-angle-right</span></li>
							<li><span class="icon-angle-up"></span><span>icon-angle-up</span></li>
							<li><span class="icon-arrow-circle-down"></span><span>icon-arrow-circle-down</span></li>
							<li><span class="icon-arrow-circle-left"></span><span>icon-arrow-circle-left</span></li>
							<li><span class="icon-arrow-circle-o-down"></span><span>icon-arrow-circle-o-down</span></li>
							<li><span class="icon-arrow-circle-o-left"></span><span>icon-arrow-circle-o-left</span></li>
							<li><span class="icon-arrow-circle-o-right"></span><span>icon-arrow-circle-o-right</span></li>
							<li><span class="icon-arrow-circle-o-up"></span><span>icon-arrow-circle-o-up</span></li>
							<li><span class="icon-arrow-circle-right"></span><span>icon-arrow-circle-right</span></li>
							<li><span class="icon-arrow-circle-up"></span><span>icon-arrow-circle-up</span></li>
							<li><span class="icon-arrow-down"></span><span>icon-arrow-down</span></li>
							<li><span class="icon-arrow-left"></span><span>icon-arrow-left</span></li>
							<li><span class="icon-arrow-right"></span><span>icon-arrow-right</span></li>
							<li><span class="icon-arrow-up"></span><span>icon-arrow-up</span></li>
							<li><span class="icon-arrows"></span><span>icon-arrows</span></li>
							<li><span class="icon-arrows-alt"></span><span>icon-arrows-alt</span></li>
							<li><span class="icon-arrows-h"></span><span>icon-arrows-h</span></li>
							<li><span class="icon-arrows-v"></span><span>icon-arrows-v</span></li>
							<li><span class="icon-caret-down"></span><span>icon-caret-down</span></li>
							<li><span class="icon-caret-left"></span><span>icon-caret-left</span></li>
							<li><span class="icon-caret-right"></span><span>icon-caret-right</span></li>
							<li><span class="icon-caret-square-o-down"></span><span>icon-caret-square-o-down</span></li>
							<li><span class="icon-caret-square-o-left"></span><span>icon-caret-square-o-left</span></li>
							<li><span class="icon-caret-square-o-right"></span><span>icon-caret-square-o-right</span></li>
							<li><span class="icon-caret-square-o-up"></span><span>icon-caret-square-o-up</span></li>
							<li><span class="icon-caret-up"></span><span>icon-caret-up</span></li>
							<li><span class="icon-chevron-circle-down"></span><span>icon-chevron-circle-down</span></li>
							<li><span class="icon-chevron-circle-left"></span><span>icon-chevron-circle-left</span></li>
							<li><span class="icon-chevron-circle-right"></span><span>icon-chevron-circle-right</span></li>
							<li><span class="icon-chevron-circle-up"></span><span>icon-chevron-circle-up</span></li>
							<li><span class="icon-chevron-down"></span><span>icon-chevron-down</span></li>
							<li><span class="icon-chevron-left"></span><span>icon-chevron-left</span></li>
							<li><span class="icon-chevron-right"></span><span>icon-chevron-right</span></li>
							<li><span class="icon-chevron-up"></span><span>icon-chevron-up</span></li>
							<li><span class="icon-hand-o-down"></span><span>icon-hand-o-down</span></li>
							<li><span class="icon-hand-o-left"></span><span>icon-hand-o-left</span></li>
							<li><span class="icon-hand-o-right"></span><span>icon-hand-o-right</span></li>
							<li><span class="icon-hand-o-up"></span><span>icon-hand-o-up</span></li>
							<li><span class="icon-long-arrow-down"></span><span>icon-long-arrow-down</span></li>
							<li><span class="icon-long-arrow-left"></span><span>icon-long-arrow-left</span></li>
							<li><span class="icon-long-arrow-right"></span><span>icon-long-arrow-right</span></li>
							<li><span class="icon-long-arrow-up"></span><span>icon-long-arrow-up</span></li>
							<li><span class="icon-toggle-down"></span><span>icon-toggle-down
									(alias)</span></li>
							<li><span class="icon-toggle-left"></span><span>icon-toggle-left
									(alias)</span></li>
							<li><span class="icon-toggle-right"></span><span>icon-toggle-right
									(alias)</span></li>
							<li><span class="icon-toggle-up"></span><span>icon-toggle-up
									(alias)</span></li>
						</ul>
					</div>
					<h4 class="doc-title">播放图标</h4>
					<div class="doc-input">
						<ul class="doc-icons">
							<li><span class="icon-arrows-alt"></span><span>icon-arrows-alt</span></li>
							<li><span class="icon-backward"></span><span>icon-backward</span></li>
							<li><span class="icon-compress"></span><span>icon-compress</span></li>
							<li><span class="icon-eject"></span><span>icon-eject</span></li>
							<li><span class="icon-expand"></span><span>icon-expand</span></li>
							<li><span class="icon-fast-backward"></span><span>icon-fast-backward</span></li>
							<li><span class="icon-fast-forward"></span><span>icon-fast-forward</span></li>
							<li><span class="icon-forward"></span><span>icon-forward</span></li>
							<li><span class="icon-pause"></span><span>icon-pause</span></li>
							<li><span class="icon-play"></span><span>icon-play</span></li>
							<li><span class="icon-play-circle"></span><span>icon-play-circle</span></li>
							<li><span class="icon-play-circle-o"></span><span>icon-play-circle-o</span></li>
							<li><span class="icon-step-backward"></span><span>icon-step-backward</span></li>
							<li><span class="icon-step-forward"></span><span>icon-step-forward</span></li>
							<li><span class="icon-stop"></span><span>icon-stop</span></li>
							<li><span class="icon-youtube-play"></span><span>icon-youtube-play</span></li>
						</ul>
					</div>
					<h4 class="doc-title">医疗图标</h4>
					<div class="doc-input">
						<ul class="doc-icons">
							<li><span class="icon-ambulance"></span><span>icon-ambulance</span></li>
							<li><span class="icon-h-square"></span><span>icon-h-square</span></li>
							<li><span class="icon-hospital-o"></span><span>icon-hospital-o</span></li>
							<li><span class="icon-medkit"></span><span>icon-medkit</span></li>
							<li><span class="icon-plus-square"></span><span>icon-plus-square</span></li>
							<li><span class="icon-stethoscope"></span><span>icon-stethoscope</span></li>
							<li><span class="icon-user-md"></span><span>icon-user-md</span></li>
							<li><span class="icon-wheelchair"></span><span>icon-wheelchair</span></li>
						</ul>
					</div>
					<h4 class="doc-title">品牌图标</h4>
					<div class="doc-input">
						<ul class="doc-icons">
							<li><span class="icon-adn"></span><span>icon-adn</span></li>
							<li><span class="icon-android"></span><span>icon-android</span></li>
							<li><span class="icon-apple"></span><span>icon-apple</span></li>
							<li><span class="icon-behance"></span><span>icon-behance</span></li>
							<li><span class="icon-behance-square"></span><span>icon-behance-square</span></li>
							<li><span class="icon-bitbucket"></span><span>icon-bitbucket</span></li>
							<li><span class="icon-bitbucket-square"></span><span>icon-bitbucket-square</span></li>
							<li><span class="icon-bitcoin"></span><span>icon-bitcoin
									(alias)</span></li>
							<li><span class="icon-btc"></span><span>icon-btc</span></li>
							<li><span class="icon-codepen"></span><span>icon-codepen</span></li>
							<li><span class="icon-css3"></span><span>icon-css3</span></li>
							<li><span class="icon-delicious"></span><span>icon-delicious</span></li>
							<li><span class="icon-deviantart"></span><span>icon-deviantart</span></li>
							<li><span class="icon-digg"></span><span>icon-digg</span></li>
							<li><span class="icon-dribbble"></span><span>icon-dribbble</span></li>
							<li><span class="icon-dropbox"></span><span>icon-dropbox</span></li>
							<li><span class="icon-drupal"></span><span>icon-drupal</span></li>
							<li><span class="icon-empire"></span><span>icon-empire</span></li>
							<li><span class="icon-facebook"></span><span>icon-facebook</span></li>
							<li><span class="icon-facebook-square"></span><span>icon-facebook-square</span></li>
							<li><span class="icon-flickr"></span><span>icon-flickr</span></li>
							<li><span class="icon-foursquare"></span><span>icon-foursquare</span></li>
							<li><span class="icon-ge"></span><span>icon-ge
									(alias)</span></li>
							<li><span class="icon-git"></span><span>icon-git</span></li>
							<li><span class="icon-git-square"></span><span>icon-git-square</span></li>
							<li><span class="icon-github"></span><span>icon-github</span></li>
							<li><span class="icon-github-alt"></span><span>icon-github-alt</span></li>
							<li><span class="icon-github-square"></span><span>icon-github-square</span></li>
							<li><span class="icon-gittip"></span><span>icon-gittip</span></li>
							<li><span class="icon-google"></span><span>icon-google</span></li>
							<li><span class="icon-google-plus"></span><span>icon-google-plus</span></li>
							<li><span class="icon-google-plus-square"></span><span>icon-</span></li>
							<li><span class="icon-hacker-news"></span><span>icon-hacker-news</span></li>
							<li><span class="icon-html5"></span><span>icon-html5</span></li>
							<li><span class="icon-instagram"></span><span>icon-instagram</span></li>
							<li><span class="icon-joomla"></span><span>icon-joomla</span></li>
							<li><span class="icon-jsfiddle"></span><span>icon-jsfiddle</span></li>
							<li><span class="icon-linkedin"></span><span>icon-linkedin</span></li>
							<li><span class="icon-linkedin-square"></span><span>icon-linkedin-square</span></li>
							<li><span class="icon-linux"></span><span>icon-linux</span></li>
							<li><span class="icon-maxcdn"></span><span>icon-maxcdn</span></li>
							<li><span class="icon-openid"></span><span>icon-openid</span></li>
							<li><span class="icon-pagelines"></span><span>icon-pagelines</span></li>
							<li><span class="icon-pied-piper"></span><span>icon-pied-piper</span></li>
							<li><span class="icon-pied-piper-alt"></span><span>icon-pied-piper-alt</span></li>
							<li><span class="icon-pied-piper-square"></span><span>icon-pied-piper-square
									(alias)</span></li>
							<li><span class="icon-pinterest"></span><span>icon-pinterest</span></li>
							<li><span class="icon-pinterest-square"></span><span>icon-pinterest-square</span></li>
							<li><span class="icon-qq"></span><span>icon-qq</span></li>
							<li><span class="icon-ra"></span><span>icon-ra
									(alias)</span></li>
							<li><span class="icon-rebel"></span><span>icon-rebel</span></li>
							<li><span class="icon-reddit"></span><span>icon-reddit</span></li>
							<li><span class="icon-reddit-square"></span><span>icon-reddit-square</span></li>
							<li><span class="icon-renren"></span><span>icon-renren</span></li>
							<li><span class="icon-share-alt"></span><span>icon-share-alt</span></li>
							<li><span class="icon-share-alt-square"></span><span>icon-share-alt-square</span></li>
							<li><span class="icon-skype"></span><span>icon-skype</span></li>
							<li><span class="icon-slack"></span><span>icon-slack</span></li>
							<li><span class="icon-soundcloud"></span><span>icon-soundcloud</span></li>
							<li><span class="icon-spotify"></span><span>icon-spotify</span></li>
							<li><span class="icon-stack-exchange"></span><span>icon-stack-exchange</span></li>
							<li><span class="icon-stack-overflow"></span><span>icon-stack-overflow</span></li>
							<li><span class="icon-steam"></span><span>icon-steam</span></li>
							<li><span class="icon-steam-square"></span><span>icon-steam-square</span></li>
							<li><span class="icon-stumbleupon"></span><span>icon-stumbleupon</span></li>
							<li><span class="icon-stumbleupon-circle"></span><span>icon-stumbleupon-circle</span></li>
							<li><span class="icon-tencent-weibo"></span><span>icon-tencent-weibo</span></li>
							<li><span class="icon-trello"></span><span>icon-trello</span></li>
							<li><span class="icon-tumblr"></span><span>icon-tumblr</span></li>
							<li><span class="icon-tumblr-square"></span><span>icon-tumblr-square</span></li>
							<li><span class="icon-twitter"></span><span>icon-twitter</span></li>
							<li><span class="icon-twitter-square"></span><span>icon-twitter-square</span></li>
							<li><span class="icon-vimeo-square"></span><span>icon-vimeo-square</span></li>
							<li><span class="icon-vine"></span><span>icon-vine</span></li>
							<li><span class="icon-vk"></span><span>icon-vk</span></li>
							<li><span class="icon-wechat"></span><span>icon-wechat
									(alias)</span></li>
							<li><span class="icon-weibo"></span><span>icon-weibo</span></li>
							<li><span class="icon-weixin"></span><span>icon-weixin</span></li>
							<li><span class="icon-windows"></span><span>icon-windows</span></li>
							<li><span class="icon-wordpress"></span><span>icon-wordpress</span></li>
							<li><span class="icon-xing"></span><span>icon-xing</span></li>
							<li><span class="icon-xing-square"></span><span>icon-xing-square</span></li>
							<li><span class="icon-yahoo"></span><span>icon-yahoo</span></li>
							<li><span class="icon-youtube"></span><span>icon-youtube</span></li>
							<li><span class="icon-youtube-play"></span><span>icon-youtube-play</span></li>
							<li><span class="icon-youtube-square"></span><span>icon-youtube-square</span></li>
						</ul>
					</div>
					<h4 class="doc-title">使用方法</h4>
					<div class="doc-input">给元素添加.icon-(*)样式，即可添加图标，同时添加text-(size)系列样式，可改变文字大小，添加text-(color)系列样式，可以改变图标颜色。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<span class="icon-star"></span> <span class="icon-star text-big"></span>
							<span class="icon-star text-large text-red"></span>

							<button class="button button-little">
								<span class="icon-star"></span> 按钮
							</button>
							<button class="button button-small">
								<span class="icon-star"></span> 按钮
							</button>
							<button class="button">
								<span class="icon-star"></span> 按钮
							</button>
							<button class="button button-big">
								<span class="icon-star"></span> 按钮
							</button>
							<button class="button button-large">
								<span class="icon-star"></span> 按钮
							</button>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<span class="icon-star"></span> <span class="icon-star text-big"></span>
						<span class="icon-star text-large text-red"></span>


						<button class="button button-little">
							<span class="icon-star"></span> 按钮
						</button>
						<button class="button button-small">
							<span class="icon-star"></span> 按钮
						</button>
						<button class="button">
							<span class="icon-star"></span> 按钮
						</button>
						<button class="button button-big">
							<span class="icon-star"></span> 按钮
						</button>
						<button class="button button-large">
							<span class="icon-star"></span> 按钮
						</button>
						</xmp>
					</div>
					<h4 class="doc-title">字体文件</h4>
					<div class="doc-input">
						拼图使用的字体文件存放于百度CDN库，如需在本机使用，请下载字体文件后，打开pintuer.css，搜索libs.baidu.com，找到5处字体文件路径并修改。
						<br />
						<br /> <a class="button border-blue"
							href="/plugins/FontAwesome-4.1.0.zip" target="_blank">本地下载
							FontAwesome v4.1.0</a>
					</div>
					<h3 class="doc-h3" id="icon-photoshop">在Photoshop中使用图标</h3>
					<p class="doc-readme">Font
						Awesome是一款非常流行和免费的图标字体。图标字体是非常适合用在网页设计中，因为它们可以用作图标显示在屏幕上，同时由于是用字体的，可以缩放和渲染，是一个非常高效的解决方案。</p>
					<div class="doc-input">
						<ol class="height">
							<li>首先关闭现在正在使用的photoshop。</li>
							<li>下载Font Awesome OTF格式的字体。把他保存在本地上。</li>
							<li>在你的电脑上安装这个.otf的字体，删除掉刚才保存的字体。</li>
							<li>打开你的photoshop，然后创建一个空白的文档。使用这个font awesome的字体格式。</li>
							<li>打开网站上的图标，复制上面的图标（注意要复制它的内容，然后粘贴到你的ps里面）</li>
							<li>像修改其他字体那样修改它的大小和颜色吧。你会喜欢上它的。</li>
						</ol>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="tags">标签</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="tag-style">标签样式</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<h1>
								h1. 拼图前端框架标题 <span class="tag">标签</span>
							</h1>
							<hr />
							<h2>
								h2. 拼图前端框架标题 <span class="tag">标签</span>
							</h2>
							<hr />
							<h3>
								h3. 拼图前端框架标题 <span class="tag">标签</span>
							</h3>
							<hr />
							<h4>
								h4. 拼图前端框架标题 <span class="tag">标签</span>
							</h4>
							<hr />
							<h5>
								h5. 拼图前端框架标题 <span class="tag">标签</span>
							</h5>
							<hr />
							<h6>
								h6. 拼图前端框架标题 <span class="tag">标签</span>
							</h6>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<h1>
							h1. 拼图前端框架标题 <span class="tag">标签</span>
						</h1>
						<h2>
							h2. 拼图前端框架标题 <span class="tag">标签</span>
						</h2>
						<h3>
							h3. 拼图前端框架标题 <span class="tag">标签</span>
						</h3>
						<h4>
							h4. 拼图前端框架标题 <span class="tag">标签</span>
						</h4>
						<h5>
							h5. 拼图前端框架标题 <span class="tag">标签</span>
						</h5>
						<h6>
							h6. 拼图前端框架标题 <span class="tag">标签</span>
						</h6>
						</xmp>
					</div>
					<h3 class="doc-h3" id="tag-colors">标签颜色</h3>
					<p class="doc-readme">改变标签的颜色。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<span class="tag bg-main">主色</span> <span class="tag bg-sub">辅色</span>
							<span class="tag bg-back">背景色</span> <span class="tag bg-mix">融合色</span>
							<span class="tag bg-dot">点缀色</span> <span class="tag bg-black">黑色</span>
							<span class="tag bg-gray">灰色</span> <span class="tag bg-white">白色</span>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<span class="tag bg-main">主色</span> <span class="tag bg-sub">辅色</span>
						<span class="tag bg-back">背景色</span> <span class="tag bg-mix">融合色</span>
						<span class="tag bg-dot">点缀色</span> <span class="tag bg-black">黑色</span>
						<span class="tag bg-gray">灰色</span> <span class="tag bg-white">白色</span></xmp>
					</div>
					<h4 class="doc-title">提示标签</h4>
					<div class="doc-input">包含红色、黄色、蓝色、绿色，分别代表危险、警告、主要、成功信息。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<span class="tag bg-red">危险</span> <span class="tag bg-yellow">警告</span>
							<span class="tag bg-blue">主要</span> <span class="tag bg-green">成功</span>

							<span class="tag bg-red-light">危险</span> <span
								class="tag bg-yellow-light">警告</span> <span
								class="tag bg-blue-light">主要</span> <span
								class="tag bg-green-light">成功</span>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<span class="tag bg-red">危险</span> <span class="tag bg-yellow">警告</span>
						<span class="tag bg-blue">主要</span> <span class="tag bg-green">成功</span>

						<span class="tag bg-red-light">危险</span> <span
							class="tag bg-yellow-light">警告</span> <span
							class="tag bg-blue-light">主要</span> <span
							class="tag bg-green-light">成功</span></xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="badge">徽章</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="badge-style">提示徽章</h3>
					<p class="doc-readme">给文本或链接添加span标签，使用class="badge"，可快速设置提示的文字或数字。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<p>
								未读 <span class="badge">8</span>
							</p>
							<a href="#">已读 <span class="badge">99+</span></a>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<p>
							未读 <span class="badge">8</span>
						</p>
						<a href="#">已读 <span class="badge">99+</span></a></xmp>
					</div>
					<h4 class="doc-title">自动消失</h4>
					<div class="doc-input">当span内没内容时，徽章会自动消失（通过CSS的:empty选择器实现）。</div>
					<blockquote class="quote border-yellow doc-quoteyellow">
						<strong>IE6,7,8兼容</strong> 在Internet Explorer
						6,7,8中不会自动消失，因为它们对:empty选择器不支持。
					</blockquote>
					<h4 class="doc-title">徽章颜色</h4>
					<div class="doc-input">添加bg-*系列样式，可以快速改变背景颜色。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<span class="badge">默认</span> <span class="badge bg-main">主色</span>
							<span class="badge bg-sub">辅色</span> <span class="badge bg-back">背景色</span>
							<span class="badge bg-mix">融合色</span> <span class="badge bg-dot">点缀色</span>
							<span class="badge bg-black">黑色</span> <span
								class="badge bg-gray">灰色</span> <span class="badge bg-white">白色</span>

							<span class="badge bg-red">红色</span> <span
								class="badge bg-yellow">黄色</span> <span class="badge bg-blue">蓝色</span>
							<span class="badge bg-green">绿色</span> <span
								class="badge bg-red-light">淡红</span> <span
								class="badge bg-yellow-light">淡黄</span> <span
								class="badge bg-blue-light">淡蓝</span> <span
								class="badge bg-green-light">淡绿</span>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<span class="badge">默认</span> <span class="badge bg-main">主色</span>
						<span class="badge bg-sub">辅色</span> <span class="badge bg-back">背景色</span>
						<span class="badge bg-mix">融合色</span> <span class="badge bg-dot">点缀色</span>
						<span class="badge bg-black">黑色</span> <span class="badge bg-gray">灰色</span>
						<span class="badge bg-white">白色</span> <span class="badge bg-red">红色</span>
						<span class="badge bg-yellow">黄色</span> <span
							class="badge bg-blue">蓝色</span> <span class="badge bg-green">绿色</span>

						<span class="badge bg-red-light">淡红</span> <span
							class="badge bg-yellow-light">淡黄</span> <span
							class="badge bg-blue-light">淡蓝</span> <span
							class="badge bg-green-light">淡绿</span></xmp>
					</div>
					<h3 class="doc-h3" id="badge-show">导航或背景上显示</h3>
					<p class="doc-readme">当在深色背景显示时，徽章的背景为白色。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<a href="#" class="button bg-main">新邮件 <span
								class="badge bg-white">5</span></a>
							<button class="button bg-red">
								新邮件 <span class="badge bg-red-light">5</span>
							</button>
							<br />
							<br />
							<div class="doc-bg-color">
								<p class="bg-main bg-inverse">
									新邮件 <span class="badge bg-white">18</span>
								</p>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<a href="#" class="button bg-main">新邮件 <span
							class="badge bg-white">5</span></a>
						<button class="button bg-red">
							新邮件 <span class="badge bg-red-light">5</span>
						</button>
						<p class="bg-main bg-inverse">
							新邮件 <span class="badge bg-white">18</span>
						</p>
						</xmp>
					</div>
					<h3 class="doc-h3" id="badge-corner">角标</h3>
					<p class="doc-readme">右上角显示的徽章</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<a href="#" class="button border-main badge-corner">未读<span
								class="badge bg-sub">5</span></a>

							<div class="button bg-main badge-corner">
								消息<span class="badge bg-red">8</span>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<a href="#" class="button border-main badge-corner">未读<span
							class="badge bg-sub">5</span></a>
						<div class="button bg-main badge-corner">
							消息<span class="badge bg-red">8</span>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="dropmenu">下拉菜单</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="drop-style">下拉样式</h3>
					<p class="doc-readme">将下拉菜单触发器和下拉菜单都包裹在.drop里，或者另一个声明了position:relative;的元素。然后添加组成菜单的HTML代码。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="clearfix" style="height: 180px;">

								<div class="drop doc-drop-open">
									<ul class="drop-menu">
										<li><a href="#">起步</a></li>
										<li><a href="#">CSS</a></li>
										<li><a href="#">元件</a></li>
										<li class="divider"></li>
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="drop open">
							<ul class="drop-menu">
								<li><a href="#">起步</a></li>
								<li><a href="#">CSS</a></li>
								<li><a href="#">元件</a></li>
								<li class="divider"></li>
								<li><a href="#">动画</a></li>
								<li><a href="#">模块</a></li>
							</ul>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">右对齐</h4>
					<div class="doc-input">给.dorp-menu增加.pull-right样式，可使下拉菜单向右显示。</div>
					<div class="doc-code">
						<xmp>
						<ul class="drop-menu pull-right">...
						</ul>
						</xmp>
					</div>
					<h3 class="doc-h3" id="drop-head">菜单标题及禁用链接</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="clearfix" style="height: 260px;">

								<div class="drop doc-drop-open">
									<ul class="drop-menu">
										<li class="drop-meun-head">菜单标题</li>
										<li><a href="#">起步</a></li>
										<li><a href="#">CSS</a></li>
										<li><a href="#">元件</a></li>
										<li class="divider"></li>
										<li class="drop-meun-head">菜单标题</li>
										<li><a href="#">动画</a></li>
										<li class="disabled"><a href="#">禁用链接</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="drop open">
							<ul class="drop-menu">
								<li class="drop-meun-head">菜单标题</li>
								<li><a href="#">起步</a></li>
								<li><a href="#">CSS</a></li>
								<li><a href="#">元件</a></li>
								<li class="divider"></li>
								<li class="drop-meun-head">菜单标题</li>
								<li><a href="#">动画</a></li>
								<li class="disabled"><a href="#">禁用链接</a></li>
								<li><a href="#">模块</a></li>
							</ul>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="nav">导航</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="nav-default">默认导航</h3>
					<p class="doc-readme">所有的导航都包含.nav样式，及特定导航的样式。</p>
					<h4 class="doc-title">基本导航样式</h4>
					<div class="doc-input">基本的导航效果，可用于侧导航或垂直方向上的文本导航。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding container-layout">
								<div class="line">
									<div class="xs4 xm3 xb3">

										<button class="button icon-navicon" data-target="#nav-link1"></button>
										<ul class="nav nav-navicon" id="nav-link1">
											<li class="nav-head">拼图</li>
											<li><a href="#">首页</a></li>
											<li><a href="#">CSS</a></li>
											<li class="active"><a href="#">元件</a></li>
											<li class="nav-more"><a href="#">更多</a></li>
										</ul>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-link1"></button>
						<ul class="nav nav-navicon" id="nav-link1">
							<li class="nav-head">拼图</li>
							<li><a href="#">首页</a></li>
							<li><a href="#">CSS</a></li>
							<li class="active"><a href="#">元件</a></li>
							<li class="nav-more"><a href="#">更多</a></li>
						</ul>
						</xmp>
					</div>
					<blockquote class="quote border-yellow doc-quoteyellow">
						<strong>手机列表显示</strong>
						如下代码，添加列表含.icon-navicon样式的导航按钮，data-target为指定的对象，在指定显示导航的对象上添加.nav-navicon样式，即能实现手机列表显示导航。
					</blockquote>
					<div class="doc-code">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-link1"></button>
						<ul class="nav nav-navicon" id="nav-link1">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">包含子菜单</h4>
					<div class="doc-input">在.nav的基本上，添加.nav-menu样式，同时为了方便在手机上使用，需在子菜单上添加.drop-menu样式。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding container-layout">
								<div class="line">
									<div class="xs4 xm3 xb2">

										<button class="button icon-navicon" data-target="#nav-link2"></button>
										<ul class="nav nav-menu nav-navicon" id="nav-link2">
											<li class="nav-head">拼图</li>
											<li><a href="#">首页</a></li>
											<li><a href="#">CSS</a></li>
											<li class="active"><a href="#">元件<span class="arrow"></span></a>
												<ul class="drop-menu">
													<li><a href="#">概述</a></li>
													<li><a href="#">网格系统<span class="arrow"></span></a>
														<ul>
															<li><a href="#">响应式布局</a></li>
															<li><a href="#">非响应式布局</a></li>
														</ul></li>
													<li><a href="#">图标</a></li>
												</ul></li>
											<li class="nav-more"><a href="#">更多<span
													class="arrow"></span></a>
												<ul class="drop-menu">
													<li><a href="#">组件</a></li>
													<li><a href="#">模块<span class="arrow"></span></a>
														<ul>
															<li><a href="#">头部</a></li>
															<li><a href="#">导航</a></li>
															<li><a href="#">底部</a></li>
														</ul></li>
												</ul></li>
										</ul>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-link2"></button>
						<ul class="nav nav-menu nav-navicon" id="nav-link2">
							<li class="nav-head">拼图</li>
							<li><a href="#">首页</a></li>
							<li><a href="#">CSS</a></li>
							<li class="active"><a href="#">元件<span class="arrow"></span></a>
								<ul class="drop-menu">
									<li><a href="#">概述</a></li>
									<li><a href="#">网格系统<span class="arrow"></span></a>
										<ul>
											<li><a href="#">响应式布局</a></li>
											<li><a href="#">非响应式布局</a></li>
										</ul></li>
									<li><a href="#">图标</a></li>
								</ul></li>
							<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
								<ul class="drop-menu">
									<li><a href="#">组件</a></li>
									<li><a href="#">模块<span class="arrow"></span></a>
										<ul>
											<li><a href="#">头部</a></li>
											<li><a href="#">导航</a></li>
											<li><a href="#">底部</a></li>
										</ul></li>
								</ul></li>
						</ul>
						</xmp>
					</div>
					<blockquote class="quote border-green doc-quote">
						<strong>附加信息</strong>
						在含子菜单的链接内，可以添加.arrow样式，用作子菜单标识作用。同时标题.nav-head和更多.nav-more可以根据实际应用可删除。
					</blockquote>
					<h4 class="doc-title">内联导航</h4>
					<div class="doc-input">实际应用中，更多的是使用一行内的导航，这时只需给.nav加上.nav-inline即可。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-link3"></button>
								<ul class="nav nav-menu nav-inline nav-navicon" id="nav-link3">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-link3"></button>
						<ul class="nav nav-menu nav-inline nav-navicon" id="nav-link3">
							...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">加上分隔线或居右</h4>
					<div class="doc-input">给.nav加上.nav-split，可以将导航的链接用竖线分隔，加上.nav-right，可以让导航链接右对齐。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-link4"></button>
								<ul
									class="nav nav-menu nav-inline nav-split nav-right nav-navicon"
									id="nav-link4">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-link4"></button>
						<ul
							class="nav nav-menu nav-inline nav-split nav-right nav-navicon"
							id="nav-link4">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">两端对齐的导航</h4>
					<div class="doc-input">给导航添加.nav-justified样式，可使导航向两端对齐。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-link5"></button>
								<ul
									class="nav nav-menu nav-inline nav-split nav-justified nav-navicon"
									id="nav-link5">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-link5"></button>
						<ul
							class="nav nav-menu nav-inline nav-split nav-justified nav-navicon"
							id="nav-link5">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">大号导航</h4>
					<div class="doc-input">给.nav样式添加.nav-big，可以改变导航条的大小。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-link6"></button>
								<ul
									class="nav nav-menu nav-inline nav-split nav-justified nav-big nav-navicon"
									id="nav-link6">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-link6"></button>
						<ul
							class="nav nav-menu nav-inline nav-split nav-justified nav-big nav-navicon"
							id="nav-link6">...
						</ul>
						</xmp>
					</div>
					<h3 class="doc-h3" id="nav-main">主要导航</h3>
					<p class="doc-readme">在.nav的基础上，添加.nav-main样式，实现主要导航的效果。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding container-layout">
								<div class="line">
									<div class="xs4 xm3 xb3">

										<button class="button icon-navicon" data-target="#nav-main1"></button>
										<ul class="nav nav-main nav-navicon" id="nav-main1">
											<li class="nav-head">拼图</li>
											<li><a href="#">首页</a></li>
											<li><a href="#">CSS</a></li>
											<li class="active"><a href="#">元件</a></li>
											<li class="nav-more"><a href="#">更多</a></li>
										</ul>

									</div>
								</div>
							</div>


							<div class="padding container-layout">
								<div class="line">
									<div class="xs4 xm3 xb3">

										<button class="button icon-navicon" data-target="#nav-main2"></button>
										<ul class="nav nav-menu nav-main nav-navicon" id="nav-main2">
											<li class="nav-head">拼图</li>
											<li><a href="#">首页</a></li>
											<li><a href="#">CSS</a></li>
											<li class="active"><a href="#">元件<span class="arrow"></span></a>
												<ul class="drop-menu">
													<li><a href="#">概述</a></li>
													<li><a href="#">网格系统<span class="arrow"></span></a>
														<ul>
															<li><a href="#">响应式布局</a></li>
															<li><a href="#">非响应式布局</a></li>
														</ul></li>
													<li><a href="#">图标</a></li>
												</ul></li>
											<li class="nav-more"><a href="#">更多<span
													class="arrow"></span></a>
												<ul class="drop-menu">
													<li><a href="#">组件</a></li>
													<li><a href="#">模块<span class="arrow"></span></a>
														<ul>
															<li><a href="#">头部</a></li>
															<li><a href="#">导航</a></li>
															<li><a href="#">底部</a></li>
														</ul></li>
												</ul></li>
										</ul>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-main1"></button>
						<ul class="nav nav-main nav-navicon" id="nav-main1">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-main2"></button>
						<ul class="nav nav-menu nav-main nav-navicon" id="nav-main2">
							...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">内联样式及两端对齐</h4>
					<div class="doc-input">给.nav加上.nav-inline，让主要导航在一行内显示。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-main3"></button>
								<ul class="nav nav-menu nav-inline nav-main nav-navicon"
									id="nav-main3">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-main4"></button>
								<ul
									class="nav nav-menu nav-inline nav-main nav-justified nav-navicon"
									id="nav-main4">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-main3"></button>
						<ul class="nav nav-menu nav-inline nav-main nav-navicon"
							id="nav-main3">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-main4"></button>
						<ul
							class="nav nav-menu nav-inline nav-main nav-justified nav-navicon"
							id="nav-main4">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">大号导航</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-main5"></button>
								<ul class="nav nav-menu nav-inline nav-main nav-big nav-navicon"
									id="nav-main5">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-main5"></button>
						<ul class="nav nav-menu nav-inline nav-main nav-big nav-navicon"
							id="nav-main5">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">导航颜色</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-main6"></button>
								<ul
									class="nav nav-menu nav-inline nav-main nav-navicon border-main"
									id="nav-main6">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>

											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-main7"></button>
								<ul
									class="nav nav-menu nav-inline nav-main nav-justified nav-navicon border-red"
									id="nav-main7">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-main6"></button>
						<ul
							class="nav nav-menu nav-inline nav-main nav-navicon border-main"
							id="nav-main6">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-main7"></button>
						<ul
							class="nav nav-menu nav-inline nav-main nav-justified nav-navicon border-red"
							id="nav-main7">...
						</ul>
						</xmp>
					</div>
					<h3 class="doc-h3" id="nav-sub">辅助导航</h3>
					<p class="doc-readme">给.nav加上.nav-sub样式，实现辅助导航样式。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding container-layout">
								<div class="line">
									<div class="xs4 xm3 xb3">

										<button class="button icon-navicon" data-target="#nav-sub1"></button>
										<ul class="nav nav-sub nav-navicon" id="nav-sub1">
											<li class="nav-head">拼图</li>
											<li><a href="#">首页</a></li>
											<li><a href="#">CSS</a></li>
											<li class="active"><a href="#">元件</a></li>
											<li class="nav-more"><a href="#">更多</a></li>
										</ul>

									</div>
								</div>
							</div>


							<div class="padding container-layout">
								<div class="line">
									<div class="xs4 xm3 xb3">

										<button class="button icon-navicon" data-target="#nav-sub2"></button>
										<ul class="nav nav-menu nav-sub nav-navicon" id="nav-sub2">
											<li class="nav-head">拼图</li>
											<li><a href="#">首页</a></li>
											<li><a href="#">CSS</a></li>
											<li class="active"><a href="#">元件<span class="arrow"></span></a>
												<ul class="drop-menu">
													<li><a href="#">概述</a></li>
													<li><a href="#">网格系统<span class="arrow"></span></a>
														<ul>
															<li><a href="#">响应式布局</a></li>
															<li><a href="#">非响应式布局</a></li>
														</ul></li>
													<li><a href="#">图标</a></li>
												</ul></li>
											<li class="nav-more"><a href="#">更多<span
													class="arrow"></span></a>
												<ul class="drop-menu">
													<li><a href="#">组件</a></li>
													<li><a href="#">模块<span class="arrow"></span></a>
														<ul>
															<li><a href="#">头部</a></li>
															<li><a href="#">导航</a></li>
															<li><a href="#">底部</a></li>
														</ul></li>
												</ul></li>
										</ul>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-sub1"></button>
						<ul class="nav nav-sub nav-navicon" id="nav-sub1">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-sub2"></button>
						<ul class="nav nav-menu nav-sub nav-navicon" id="nav-sub2">
							...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">内联样式及两端对齐</h4>
					<div class="doc-input">在.nav-sub上添加.nav-inline或.nav-justified样式，实现导航的内联或两端对齐样式。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-sub3"></button>
								<ul class="nav nav-menu nav-inline nav-sub nav-navicon"
									id="nav-sub3">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-sub4"></button>
								<ul
									class="nav nav-menu nav-inline nav-sub nav-justified nav-navicon"
									id="nav-sub4">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-sub3"></button>
						<ul class="nav nav-menu nav-inline nav-sub nav-navicon"
							id="nav-sub3">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-sub4"></button>
						<ul
							class="nav nav-menu nav-inline nav-sub nav-justified nav-navicon"
							id="nav-sub4">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">大号导航</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-sub5"></button>
								<ul class="nav nav-menu nav-inline nav-sub nav-big nav-navicon"
									id="nav-sub5">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-sub5"></button>
						<ul class="nav nav-menu nav-inline nav-sub nav-big nav-navicon"
							id="nav-sub5">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">导航颜色</h4>
					<div class="doc-input">使用.border-(*)系列样式，可以快速改变辅助导航的颜色。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-sub6"></button>
								<ul
									class="nav nav-menu nav-inline nav-sub border-red nav-navicon"
									id="nav-sub6">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-sub7"></button>
								<ul
									class="nav nav-menu nav-inline nav-sub border-main nav-navicon"
									id="nav-sub7">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-sub8"></button>
								<ul
									class="nav nav-menu nav-inline nav-sub nav-justified border-back nav-navicon"
									id="nav-sub8">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-sub6"></button>
						<ul class="nav nav-menu nav-inline nav-sub border-red nav-navicon"
							id="nav-sub6">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-sub7"></button>
						<ul
							class="nav nav-menu nav-inline nav-sub border-main nav-navicon"
							id="nav-sub7">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-sub8"></button>
						<ul
							class="nav nav-menu nav-inline nav-sub nav-justified border-back nav-navicon"
							id="nav-sub8">...
						</ul>
						</xmp>
					</div>
					<h3 class="doc-h3" id="nav-tabs">标签导航</h3>
					<p class="doc-readme">标签导航基本样式，基于.nav样式，添加.nav-tabs样式。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding container-layout">
								<div class="line">
									<div class="xs4 xm3 xb3">

										<button class="button icon-navicon" data-target="#nav-tabs1"></button>
										<ul class="nav nav-tabs nav-navicon" id="nav-tabs1">
											<li class="nav-head">拼图</li>
											<li><a href="#">首页</a></li>
											<li><a href="#">CSS</a></li>
											<li class="active"><a href="#">元件</a></li>
											<li class="nav-more"><a href="#">更多</a></li>
										</ul>

									</div>
								</div>
							</div>


							<div class="padding container-layout">
								<div class="line">
									<div class="xs4 xm3 xb3">

										<button class="button icon-navicon" data-target="#nav-tabs2"></button>
										<ul class="nav nav-menu nav-tabs nav-navicon" id="nav-tabs2">
											<li class="nav-head">拼图</li>
											<li><a href="#">首页</a></li>
											<li><a href="#">CSS</a></li>
											<li class="active"><a href="#">元件<span class="arrow"></span></a>
												<ul class="drop-menu">
													<li><a href="#">概述</a></li>
													<li><a href="#">网格系统<span class="arrow"></span></a>
														<ul>
															<li><a href="#">响应式布局</a></li>
															<li><a href="#">非响应式布局</a></li>
														</ul></li>
													<li><a href="#">图标</a></li>
												</ul></li>
											<li class="nav-more"><a href="#">更多<span
													class="arrow"></span></a>
												<ul class="drop-menu">
													<li><a href="#">组件</a></li>
													<li><a href="#">模块<span class="arrow"></span></a>
														<ul>
															<li><a href="#">头部</a></li>
															<li><a href="#">导航</a></li>
															<li><a href="#">底部</a></li>
														</ul></li>
												</ul></li>
										</ul>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-tabs1"></button>
						<ul class="nav nav-tabs nav-navicon" id="nav-tabs1">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-tabs2"></button>
						<ul class="nav nav-menu nav-tabs nav-navicon" id="nav-tabs2">
							...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">内联样式、右对齐及两端对齐</h4>
					<div class="doc-input">在.nav-tabs上添加.nav-inline或.nav-justified样式，实现内联及两端对齐的效果，同时使用.nav-right，可以使内容右对齐显示。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-tabs3"></button>
								<ul class="nav nav-menu nav-inline nav-tabs nav-navicon"
									id="nav-tabs3">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-tabs4"></button>
								<ul
									class="nav nav-menu nav-inline nav-tabs nav-right nav-navicon"
									id="nav-tabs4">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-tabs5"></button>
								<ul
									class="nav nav-menu nav-inline nav-tabs nav-justified nav-navicon"
									id="nav-tabs5">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-tabs3"></button>
						<ul class="nav nav-menu nav-inline nav-tabs nav-navicon"
							id="nav-tabs3">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-tabs4"></button>
						<ul class="nav nav-menu nav-inline nav-tabs nav-right nav-navicon"
							id="nav-tabs4">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-tabs5"></button>
						<ul
							class="nav nav-menu nav-inline nav-tabs nav-justified nav-navicon"
							id="nav-tabs5">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">大尺寸标签导航</h4>
					<div class="doc-input">给.nav-tabs，添加.nav-big，可以使用大尺寸的标签导航。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-tabs6"></button>
								<ul
									class="nav nav-menu nav-inline nav-tabs nav-justified nav-big nav-navicon"
									id="nav-tabs6">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-tabs6"></button>
						<ul
							class="nav nav-menu nav-inline nav-tabs nav-justified nav-big nav-navicon"
							id="nav-tabs6">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">导航颜色</h4>
					<div class="doc-input">同样，使用border-(*)系列样式，可以改变标签导航的颜色。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-tabs7"></button>
								<ul
									class="nav nav-menu nav-inline nav-tabs border-main nav-navicon"
									id="nav-tabs7">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-tabs8"></button>
								<ul
									class="nav nav-menu nav-inline nav-tabs nav-big border-red-light nav-navicon"
									id="nav-tabs8">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-tabs7"></button>
						<ul
							class="nav nav-menu nav-inline nav-tabs border-main nav-navicon"
							id="nav-tabs7">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-tabs8"></button>
						<ul
							class="nav nav-menu nav-inline nav-tabs nav-big border-red-light nav-navicon"
							id="nav-tabs8">...
						</ul>
						</xmp>
					</div>
					<h3 class="doc-h3" id="nav-pills">胶囊导航</h3>
					<p class="doc-readme">基于.nav，添加.nav-pills样式，可实现胶囊导航效果。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding container-layout">
								<div class="line">
									<div class="xs4 xm3 xb3">

										<button class="button icon-navicon" data-target="#nav-pills1"></button>
										<ul class="nav nav-pills nav-navicon" id="nav-pills1">
											<li class="nav-head">拼图</li>
											<li><a href="#">首页</a></li>
											<li><a href="#">CSS</a></li>
											<li class="active"><a href="#">元件</a></li>
											<li class="nav-more"><a href="#">更多</a></li>
										</ul>

									</div>
								</div>
							</div>


							<div class="padding container-layout">
								<div class="line">
									<div class="xs4 xm3 xb3">

										<button class="button icon-navicon" data-target="#nav-pills2"></button>
										<ul class="nav nav-menu nav-pills nav-navicon" id="nav-pills2">
											<li class="nav-head">拼图</li>
											<li><a href="#">首页</a></li>
											<li><a href="#">CSS</a></li>
											<li class="active"><a href="#">元件<span class="arrow"></span></a>
												<ul class="drop-menu">
													<li><a href="#">概述</a></li>
													<li><a href="#">网格系统<span class="arrow"></span></a>
														<ul>
															<li><a href="#">响应式布局</a></li>
															<li><a href="#">非响应式布局</a></li>
														</ul></li>
													<li><a href="#">图标</a></li>
												</ul></li>
											<li class="nav-more"><a href="#">更多<span
													class="arrow"></span></a>
												<ul class="drop-menu">
													<li><a href="#">组件</a></li>
													<li><a href="#">模块<span class="arrow"></span></a>
														<ul>
															<li><a href="#">头部</a></li>
															<li><a href="#">导航</a></li>
															<li><a href="#">底部</a></li>
														</ul></li>
												</ul></li>
										</ul>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-pills1"></button>
						<ul class="nav nav-pills nav-navicon" id="nav-pills1">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-pills2"></button>
						<ul class="nav nav-menu nav-pills nav-navicon" id="nav-pills2">
							...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">内联样式、右对齐及两端对齐</h4>
					<div class="doc-input">在.nav-pills上添加.nav-inline、.nav-right或.nav-justified样式，实现导航的内联或两端对齐样式。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-pills3"></button>
								<ul class="nav nav-menu nav-inline nav-pills nav-navicon"
									id="nav-pills3">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-pills4"></button>
								<ul
									class="nav nav-menu nav-inline nav-pills nav-right nav-navicon"
									id="nav-pills4">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-pills5"></button>
								<ul
									class="nav nav-menu nav-inline nav-pills nav-justified nav-navicon"
									id="nav-pills5">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-pills3"></button>
						<ul class="nav nav-menu nav-inline nav-pills nav-navicon"
							id="nav-pills3">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-pills4"></button>
						<ul
							class="nav nav-menu nav-inline nav-pills nav-right nav-navicon"
							id="nav-pills4">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-pills5"></button>
						<ul
							class="nav nav-menu nav-inline nav-pills nav-justified nav-navicon"
							id="nav-pills5">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">大号导航条</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-pills6"></button>
								<ul
									class="nav nav-menu nav-inline nav-pills nav-justified nav-big nav-navicon"
									id="nav-pills6">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-pills6"></button>
						<ul
							class="nav nav-menu nav-inline nav-pills nav-justified nav-big nav-navicon"
							id="nav-pills6">...
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">导航颜色</h4>
					<div class="doc-input">使用.border-(*)系列样式，可以改变导航的颜色。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-pills7"></button>
								<ul
									class="nav nav-menu nav-inline nav-pills nav-navicon border-yellow"
									id="nav-pills7">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<div class="padding">

								<button class="button icon-navicon" data-target="#nav-pills8"></button>
								<ul
									class="nav nav-menu nav-inline nav-pills nav-right nav-navicon border-yellow-light"
									id="nav-pills8">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon" data-target="#nav-pills7"></button>
						<ul
							class="nav nav-menu nav-inline nav-pills nav-navicon border-yellow"
							id="nav-pills7">...
						</ul>

						<button class="button icon-navicon" data-target="#nav-pills8"></button>
						<ul
							class="nav nav-menu nav-inline nav-pills nav-right nav-navicon border-yellow-light"
							id="nav-pills8">...
						</ul>
						</xmp>
					</div>
					<h3 class="doc-h3" id="nav-sitemap">站点导航</h3>
					<p class="doc-readme">添加.nav-sitemap样式，两端对齐显示，显示为站点地图类导航，常用于站点地图或网站底部。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="table-responsive">
								<div class="padding">

									<ul class="nav nav-sitemap">
										<li><a href="#">起步</a>
											<ul>
												<li><a href="#">下载前端框架</a></li>
												<li><a href="#">框架包含的文件</a></li>
												<li><a href="#">基本页面</a></li>
											</ul></li>
										<li><a href="#">CSS</a>
											<ul>
												<li><a href="#">文本</a></li>
												<li><a href="#">图片</a></li>
												<li><a href="#">水平线</a></li>
											</ul></li>
										<li><a href="#">元件</a>
											<ul>
												<li><a href="#">网格系统</a></li>
												<li><a href="#">图标</a></li>
												<li><a href="#">标签</a></li>
											</ul></li>
										<li><a href="#">JS组件</a>
											<ul>
												<li><a href="#">窗口工具</a></li>
												<li><a href="#">选项标签</a></li>
												<li><a href="#">进度及区间值</a></li>
											</ul></li>
										<li><a href="#">模块</a>
											<ul>
												<li><a href="#">框架</a></li>
												<li><a href="#">头部</a></li>
												<li><a href="#">导航条</a></li>
											</ul></li>
									</ul>

								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<ul class="nav nav-sitemap">
							<li><a href="#">起步</a>
								<ul>
									<li><a href="#">下载前端框架</a></li>
									<li><a href="#">框架包含的文件</a></li>
									<li><a href="#">基本页面</a></li>
								</ul></li> ...
						</ul>
						</xmp>
					</div>
					<h3 class="doc-h3" id="nav-bg">背景反色导航</h3>
					<p class="doc-readme">当使用.bg-(*)系列样式时，背景色与文字的反色效果。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<button class="button icon-navicon margin-small-bottom"
								data-target="#nav-bg1"></button>
							<div class="bg-red bg-inverse radius nav-navicon" id="nav-bg1">

								<ul class="nav nav-inline nav-menu clearfix">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<button class="button icon-navicon margin-small-bottom"
								data-target="#nav-bg2"></button>
							<div class="bg-yellow bg-inverse radius nav-navicon" id="nav-bg2">

								<ul class="nav nav-inline nav-menu nav-split clearfix">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<button class="button icon-navicon margin-small-bottom"
								data-target="#nav-bg3"></button>
							<div class="bg-blue bg-inverse radius nav-navicon" id="nav-bg3">

								<ul class="nav nav-inline nav-menu nav-split nav-justified">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<button class="button icon-navicon margin-small-bottom"
								data-target="#nav-bg4"></button>
							<div class="bg-green bg-inverse radius nav-navicon" id="nav-bg4">

								<ul
									class="nav nav-inline nav-menu nav-split nav-big nav-justified">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon margin-small-bottom"
							data-target="#nav-bg1"></button>
						<div class="bg-red bg-inverse radius nav-navicon" id="nav-bg1">
							<ul class="nav nav-inline nav-menu clearfix">...
							</ul>
						</div>

						<button class="button icon-navicon margin-small-bottom"
							data-target="#nav-bg2"></button>
						<div class="bg-yellow bg-inverse radius nav-navicon" id="nav-bg2">
							<ul class="nav nav-inline nav-menu nav-split clearfix">...
							</ul>
						</div>

						<button class="button icon-navicon margin-small-bottom"
							data-target="#nav-bg3"></button>
						<div class="bg-blue bg-inverse radius nav-navicon" id="nav-bg3">

							<ul class="nav nav-inline nav-menu nav-split nav-justified">
								...
							</ul>
						</div>

						<button class="button icon-navicon margin-small-bottom"
							data-target="#nav-bg4"></button>
						<div class="bg-green bg-inverse radius nav-navicon" id="nav-bg4">
							<ul
								class="nav nav-inline nav-menu nav-split nav-big nav-justified">
								...
							</ul>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">标签导航</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<button class="button icon-navicon margin-small-bottom"
								data-target="#nav-bg5"></button>
							<div class="bg-red bg-inverse radius nav-navicon" id="nav-bg5">

								<ul class="nav nav-inline nav-menu nav-tabs clearfix">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<button class="button icon-navicon margin-small-bottom"
								data-target="#nav-bg6"></button>
							<div class="bg-green bg-inverse radius nav-navicon" id="nav-bg6">

								<ul
									class="nav nav-inline nav-menu nav-tabs nav-big nav-justified">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon margin-small-bottom"
							data-target="#nav-bg5"></button>
						<div class="bg-red bg-inverse radius nav-navicon" id="nav-bg5">
							<ul class="nav nav-inline nav-menu nav-tabs clearfix">...
							</ul>
						</div>

						<button class="button icon-navicon margin-small-bottom"
							data-target="#nav-bg6"></button>
						<div class="bg-green bg-inverse radius nav-navicon" id="nav-bg6">
							<ul
								class="nav nav-inline nav-menu nav-tabs nav-big nav-justified">
								...
							</ul>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">胶囊导航</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<button class="button icon-navicon margin-small-bottom"
								data-target="#nav-bg7"></button>
							<div class="bg-yellow bg-inverse radius nav-navicon" id="nav-bg7">

								<ul class="nav nav-inline nav-menu nav-pills clearfix">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>

							<br />
							<br />

							<button class="button icon-navicon margin-small-bottom"
								data-target="#nav-bg8"></button>
							<div class="bg-blue bg-inverse radius nav-navicon" id="nav-bg8">

								<ul
									class="nav nav-inline nav-menu nav-pills nav-big nav-justified">
									<li class="nav-head">拼图</li>
									<li><a href="#">首页</a></li>
									<li><a href="#">CSS</a></li>
									<li class="active"><a href="#">元件<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">概述</a></li>
											<li><a href="#">网格系统<span class="arrow"></span></a>
												<ul>
													<li><a href="#">响应式布局</a></li>
													<li><a href="#">非响应式布局</a></li>
												</ul></li>
											<li><a href="#">图标</a></li>
										</ul></li>
									<li class="nav-more"><a href="#">更多<span class="arrow"></span></a>
										<ul class="drop-menu">
											<li><a href="#">组件</a></li>
											<li><a href="#">模块<span class="arrow"></span></a>
												<ul>
													<li><a href="#">头部</a></li>
													<li><a href="#">导航</a></li>
													<li><a href="#">底部</a></li>
												</ul></li>
										</ul></li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<button class="button icon-navicon margin-small-bottom"
							data-target="#nav-bg7"></button>
						<div class="bg-yellow bg-inverse radius nav-navicon" id="nav-bg7">
							<ul class="nav nav-inline nav-menu nav-pills clearfix">...
							</ul>
						</div>

						<button class="button icon-navicon margin-small-bottom"
							data-target="#nav-bg8"></button>
						<div class="bg-blue bg-inverse radius nav-navicon" id="nav-bg8">
							<ul
								class="nav nav-inline nav-menu nav-pills nav-big nav-justified">
								...
							</ul>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="progress">进度条</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="progress-style">默认进度条样式</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="progress">
								<div class="progress-bar" style="width: 50%;">进度：50%</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="progress">
							<div class="progress-bar" style="width: 50%;">进度：50%</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">大号进度条</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="progress progress-big">
								<div class="progress-bar" style="width: 50%;">进度：50%</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="progress progress-big">
							<div class="progress-bar" style="width: 50%;">进度：50%</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">小号进度条</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="progress progress-small">
								<div class="progress-bar bg-yellow" style="width: 50%;"></div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="progress progress-small">
							<div class="progress-bar bg-yellow" style="width: 50%;"></div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="progress-color">进度条颜色</h3>
					<p class="doc-readme">使用bg-*样式，可以快速改变进度条的背景色。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="progress">
								<div class="progress-bar bg-main" style="width: 10%;">10%</div>
							</div>
							<br />
							<div class="progress">
								<div class="progress-bar bg-sub" style="width: 20%;">进度：20%</div>
							</div>
							<br />
							<div class="progress">
								<div class="progress-bar bg-back" style="width: 30%;">进度：30%</div>
							</div>
							<br />
							<div class="progress">
								<div class="progress-bar bg-mix" style="width: 40%;">进度：40%</div>
							</div>
							<br />
							<div class="progress">
								<div class="progress-bar bg-dot" style="width: 50%;">进度：50%</div>
							</div>
							<br />
							<div class="progress">
								<div class="progress-bar bg-black" style="width: 60%;">进度：60%</div>
							</div>
							<br />
							<div class="progress">
								<div class="progress-bar bg-gray" style="width: 70%;">进度：70%</div>
							</div>
							<br />
							<div class="bg-black" style="padding: 10px;">
								<div class="progress bg-main">
									<div class="progress-bar bg-white" style="width: 80%;">进度：80%</div>
								</div>
							</div>
							<br />
							<div class="progress">
								<div class="progress-bar bg-red" style="width: 90%;">进度：90%</div>
							</div>
							<br />
							<div class="progress">
								<div class="progress-bar bg-yellow" style="width: 100%;">进度：100%</div>
							</div>
							<br />
							<div class="progress">
								<div class="progress-bar bg-blue" style="width: 50%;">进度：50%</div>
							</div>
							<br />
							<div class="progress">
								<div class="progress-bar bg-green" style="width: 50%;">进度：50%</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="progress">
							<div class="progress-bar bg-main" style="width: 10%;">10%</div>
						</div>
						<div class="progress">
							<div class="progress-bar bg-sub" style="width: 20%;">进度：20%</div>
						</div>
						<div class="progress">
							<div class="progress-bar bg-back" style="width: 30%;">进度：30%</div>
						</div>
						<div class="progress">
							<div class="progress-bar bg-mix" style="width: 40%;">进度：40%</div>
						</div>
						<div class="progress">
							<div class="progress-bar bg-dot" style="width: 50%;">进度：50%</div>
						</div>
						<div class="progress">
							<div class="progress-bar bg-black" style="width: 60%;">进度：60%</div>
						</div>
						<div class="progress">
							<div class="progress-bar bg-gray" style="width: 70%;">进度：70%</div>
						</div>
						<div class="progress bg-main">
							<div class="progress-bar bg-white" style="width: 80%;">进度：80%</div>
						</div>
						<div class="progress">
							<div class="progress-bar bg-red" style="width: 90%;">进度：90%</div>
						</div>
						<div class="progress">
							<div class="progress-bar bg-yellow" style="width: 100%;">进度：100%</div>
						</div>
						<div class="progress">
							<div class="progress-bar bg-blue" style="width: 50%;">进度：50%</div>
						</div>
						<div class="progress">
							<div class="progress-bar bg-green" style="width: 50%;">进度：50%</div>
						</div>
						</xmp>
					</div>
					<blockquote class="quote border-green doc-quote">
						<strong>背景色组合</strong> 与上一节CSS定义的背景色组合，可以随意改变进度条的背景色。
					</blockquote>
					<h3 class="doc-h3" id="progress-effect">进度条效果</h3>
					<p class="doc-readme"></p>
					<h4 class="doc-title">条纹效果</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="progress progress-striped">
								<div class="progress-bar bg-main" style="width: 50%;">进度：50%</div>
							</div>
							<br />
							<div class="progress progress-striped">
								<div class="progress-bar bg-sub" style="width: 80%;">进度：80%</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="progress progress-striped">
							<div class="progress-bar bg-main" style="width: 50%;">进度：50%</div>
						</div>

						<div class="progress progress-striped">
							<div class="progress-bar bg-sub" style="width: 80%;">进度：80%</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">运动效果</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="progress progress-striped active">
								<div class="progress-bar bg-main" style="width: 50%;">进度：50%</div>
							</div>
							<br />
							<div class="progress progress-striped active">
								<div class="progress-bar bg-sub" style="width: 80%;">进度：80%</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="progress progress-striped active">
							<div class="progress-bar bg-main" style="width: 50%;">进度：50%</div>
						</div>

						<div class="progress progress-striped active">
							<div class="progress-bar bg-sub" style="width: 80%;">进度：80%</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">叠加效果</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="progress progress-big progress-striped active">
								<div class="progress-bar bg-green" style="width: 40%;">进度：40%</div>
								<div class="progress-bar bg-blue" style="width: 30%;">进度：30%</div>
								<div class="progress-bar bg-yellow" style="width: 20%;">进度：20%</div>
								<div class="progress-bar bg-red" style="width: 10%;">进度：10%</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="progress progress-big progress-striped active">
							<div class="progress-bar bg-green" style="width: 40%;">进度：40%</div>
							<div class="progress-bar bg-blue" style="width: 30%;">进度：30%</div>
							<div class="progress-bar bg-yellow" style="width: 20%;">进度：20%</div>
							<div class="progress-bar bg-red" style="width: 10%;">进度：10%</div>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="range">区间</h2>
					<p class="doc-lead">选定区间的某个值，或某个范围，数值的改变请参考js组件效果。</p>
					<h3 class="doc-h3" id="range-scroll">区间选值</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="range">
								<div class="range-bar" style="width: 30%;">
									<span class="range-scroll range-scroll-right bg-dot"></span>
								</div>
							</div>
							<br />
							<div class="range">
								<div class="range-bar bg-main" style="width: 50%;">
									<span class="range-scroll range-scroll-right bg-dot"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="range">
							<div class="range-bar" style="width: 30%;">
								<span class="range-scroll range-scroll-right bg-dot"></span>
							</div>
						</div>

						<div class="range">
							<div class="range-bar bg-main" style="width: 50%;">
								<span class="range-scroll range-scroll-right bg-dot"></span>
							</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="range-select">区间范围</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="range">
								<div class="range-bar bg-mix" style="width: 50%; left: 20%;">
									<span class="range-scroll range-scroll-right bg-main"></span><span
										class="range-scroll range-scroll-left bg-main"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="range">
							<div class="range-bar bg-mix" style="width: 50%; left: 20%;">
								<span class="range-scroll range-scroll-right bg-main"></span><span
									class="range-scroll range-scroll-left bg-main"></span>
							</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="range-color">按钮及区间颜色</h3>
					<p class="doc-readme">使用bg-*系列样式，快速改变按钮及进区间的颜色。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="range">
								<div class="range-bar bg-main" style="width: 40%; left: 0%;">
									<span class="range-scroll range-scroll-right bg-sub"></span><span
										class="range-scroll range-scroll-left bg-sub"></span>
								</div>
							</div>
							<br />
							<div class="range">
								<div class="range-bar bg-red-light"
									style="width: 50%; left: 10%;">
									<span class="range-scroll range-scroll-right bg-red"></span><span
										class="range-scroll range-scroll-left bg-red"></span>
								</div>
							</div>
							<br />
							<div class="range">
								<div class="range-bar bg-yellow-light"
									style="width: 60%; left: 20%;">
									<span class="range-scroll range-scroll-right bg-yellow"></span><span
										class="range-scroll range-scroll-left bg-yellow"></span>
								</div>
							</div>
							<br />
							<div class="range">
								<div class="range-bar bg-green-light"
									style="width: 70%; left: 30%;">
									<span class="range-scroll range-scroll-right bg-green"></span><span
										class="range-scroll range-scroll-left bg-green"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="range">
							<div class="range-bar bg-main" style="width: 40%; left: 0%;">
								<span class="range-scroll range-scroll-right bg-sub"></span><span
									class="range-scroll range-scroll-left bg-sub"></span>
							</div>
						</div>
						<br />
						<div class="range">
							<div class="range-bar bg-red-light"
								style="width: 50%; left: 10%;">
								<span class="range-scroll range-scroll-right bg-red"></span><span
									class="range-scroll range-scroll-left bg-red"></span>
							</div>
						</div>
						<br />
						<div class="range">
							<div class="range-bar bg-yellow-light"
								style="width: 60%; left: 20%;">
								<span class="range-scroll range-scroll-right bg-yellow"></span><span
									class="range-scroll range-scroll-left bg-yellow"></span>
							</div>
						</div>
						<br />
						<div class="range">
							<div class="range-bar bg-green-light"
								style="width: 70%; left: 30%;">
								<span class="range-scroll range-scroll-right bg-green"></span><span
									class="range-scroll range-scroll-left bg-green"></span>
							</div>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="btngroup">按钮组</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="button-group">基本样式</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-group">
								<button type="button" class="button">起步</button>
								<button type="button" class="button">CSS</button>
								<button type="button" class="button">元件</button>
								<button type="button" class="button">模块</button>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group">
							<button type="button" class="button">起步</button>
							<button type="button" class="button">CSS</button>
							<button type="button" class="button">元件</button>
							<button type="button" class="button">模块</button>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="button-group-tools">按钮工具栏</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-toolbar">
								<div class="button-group">
									<button type="button" class="button">起步</button>
									<button type="button" class="button">CSS</button>
								</div>
								<div class="button-group">
									<button type="button" class="button">元件</button>
									<button type="button" class="button">动画</button>
									<button type="button" class="button">模块</button>
								</div>
								<div class="button-group">
									<button type="button" class="button">js组件</button>
									<button type="button" class="button">案例</button>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-toolbar">
							<div class="button-group">
								<button type="button" class="button">起步</button>
								<button type="button" class="button">CSS</button>
							</div>
							<div class="button-group">
								<button type="button" class="button">元件</button>
								<button type="button" class="button">动画</button>
								<button type="button" class="button">模块</button>
							</div>
							<div class="button-group">
								<button type="button" class="button">js组件</button>
								<button type="button" class="button">案例</button>
							</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">添加图标</h4>
					<div class="doc-input">使用icon-(*)系列图标样式，可以给按钮添加图标，同时使用text-(*)颜色样式，可以改变文字及图标的颜色。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-toolbar">
								<div class="button-group">
									<button type="button" class="button">
										<span class="icon-edit text-blue"></span> 修改
									</button>
									<button type="button" class="button">
										<span class="icon-trash-o text-red"></span> 删除
									</button>
								</div>
								<div class="button-group">
									<button type="button" class="button icon-heart-o text-blue">
										收藏</button>
									<button type="button" class="button icon-star-o text-green">
										评价</button>
									<button type="button"
										class="button icon-thumbs-o-up text-yellow">我赞</button>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-toolbar">
							<div class="button-group">
								<button type="button" class="button">
									<span class="icon-edit text-blue"></span> 修改
								</button>
								<button type="button" class="button">
									<span class="icon-trash-o text-red"></span> 删除
								</button>
							</div>
							<div class="button-group">
								<button type="button" class="button icon-heart-o text-blue">
									收藏</button>
								<button type="button" class="button icon-star-o text-green">
									评价</button>
								<button type="button"
									class="button icon-thumbs-o-up text-yellow">我赞</button>
							</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="buttongroup-size">尺寸</h3>
					<p class="doc-readme">通过样式，改变按钮组的大小。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-group button-group-big">
								<button type="button" class="button">起步</button>
								<button type="button" class="button">CSS</button>
								<button type="button" class="button">元件</button>
							</div>
							<br />
							<br />
							<div class="button-group">
								<button type="button" class="button">起步</button>
								<button type="button" class="button">CSS</button>
								<button type="button" class="button">元件</button>
								<button type="button" class="button">模块</button>
							</div>
							<br />
							<br />
							<div class="button-group button-group-small">
								<button type="button" class="button">起步</button>
								<button type="button" class="button">CSS</button>
								<button type="button" class="button">元件</button>
								<button type="button" class="button">动画</button>
								<button type="button" class="button">模块</button>
							</div>
							<br />
							<br />
							<div class="button-group button-group-little">
								<button type="button" class="button">起步</button>
								<button type="button" class="button">CSS</button>
								<button type="button" class="button">元件</button>
								<button type="button" class="button">动画</button>
								<button type="button" class="button">模块</button>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group button-group-big">...</div>
						<div class="button-group">...</div>
						<div class="button-group button-group-small">...</div>
						<div class="button-group button-group-little">...</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="buttongroup-nested">嵌套</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-group">
								<div class="button-group">
									<button type="button" class="button dropdown-toggle">
										起步 <span class="downward"></span>
									</button>
									<ul class="drop-menu">
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>
								<button type="button" class="button">CSS</button>
								<button type="button" class="button">元件</button>
								<div class="button-group">
									<button type="button" class="button dropdown-toggle">
										模块 <span class="downward"></span>
									</button>
									<ul class="drop-menu">
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group">
							<div class="button-group">
								<button type="button" class="button dropdown-toggle">
									起步 <span class="downward"></span>
								</button>
								<ul class="drop-menu">
									<li><a href="#">动画</a></li>
									<li><a href="#">模块</a></li>
								</ul>
							</div>
							<button type="button" class="button">CSS</button>
							...
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="button-group-y">纵向显示</h3>
					<p class="doc-readme">让一组按钮竖直显示而不是水平显示。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-group-y">
								<div class="button-group">
									<button type="button" class="button dropdown-toggle">
										起步 <span class="downward"></span>
									</button>
									<ul class="drop-menu">
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>
								<button type="button" class="button">CSS</button>
								<button type="button" class="button">元件</button>
								<button type="button" class="button active">动画</button>
								<div class="button-group">
									<button type="button" class="button dropdown-toggle">
										javascript组件 <span class="downward"></span>
									</button>
									<ul class="drop-menu">
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>
								<button type="button" class="button">模块</button>
								<div class="button-group">
									<button type="button" class="button dropdown-toggle">
										起步 <span class="downward"></span>
									</button>
									<ul class="drop-menu">
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group-y">
							<div class="button-group">
								<button type="button" class="button dropdown-toggle">
									起步 <span class="downward"></span>
								</button>
								<ul class="drop-menu">
									<li><a href="#">动画</a></li>
									<li><a href="#">模块</a></li>
								</ul>
							</div>
							<button type="button" class="button">CSS</button>
							<button type="button" class="button">元件</button>
							<button type="button" class="button active">动画</button>
							<div class="button-group">
								<button type="button" class="button dropdown-toggle">
									javascript组件 <span class="downward"></span>
								</button>
								<ul class="drop-menu">
									<li><a href="#">动画</a></li>
									<li><a href="#">模块</a></li>
								</ul>
							</div>
							<button type="button" class="button">模块</button>
							<div class="button-group">
								<button type="button" class="button dropdown-toggle">
									起步 <span class="downward"></span>
								</button>
								<ul class="drop-menu">
									<li><a href="#">动画</a></li>
									<li><a href="#">模块</a></li>
								</ul>
							</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="button-group-justified">两端对齐的链接按钮组</h3>
					<p class="doc-readme">让一组按钮拉长为相同的尺寸，适应父元素的宽度。对于按钮组中的按钮下拉菜单也同样适用。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-group button-group-justified">
								<a href="#" class="button">起步</a> <a href="#" class="button">CSS</a>
								<div class="button-group">
									<a class="button dropdown-toggle">元件 <span class="downward"></span></a>
									<ul class="drop-menu">
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group button-group-justified">
							<a href="#" class="button">起步</a> <a href="#" class="button">CSS</a>
							<div class="button-group">
								<a class="button dropdown-toggle">元件 <span class="downward"></span></a>
								<ul class="drop-menu">
									<li><a href="#">动画</a></li>
									<li><a href="#">模块</a></li>
								</ul>
							</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="btngroup-color">颜色</h3>
					<p class="doc-readme">使用border-*系列样式，快速改变边框颜色。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-group border-red">
								<button type="button" class="button">起步</button>
								<button type="button" class="button active">CSS</button>
								<button type="button" class="button">元件</button>
								<button type="button" class="button">模块</button>
							</div>
							<br />
							<br />
							<div class="button-group border-yellow-light">
								<button type="button" class="button">起步</button>
								<button type="button" class="button active">CSS</button>
								<button type="button" class="button">元件</button>
								<button type="button" class="button">模块</button>
							</div>
							<br />
							<br />
							<div class="button-group border-blue">
								<button type="button" class="button">起步</button>
								<button type="button" class="button active">CSS</button>
								<button type="button" class="button">元件</button>
								<button type="button" class="button">模块</button>
							</div>
							<br />
							<br />
							<div class="button-group border-green-light">
								<button type="button" class="button">起步</button>
								<button type="button" class="button active">CSS</button>
								<button type="button" class="button">元件</button>
								<button type="button" class="button">模块</button>
							</div>
							<br />
							<br />
							<div class="button-group">
								<button type="button" class="button">起步</button>
								<button type="button" class="button bg-red">元件</button>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group border-red">
							<button type="button" class="button">起步</button>
							<button type="button" class="button active">CSS</button>
							<button type="button" class="button">元件</button>
							<button type="button" class="button">模块</button>
						</div>

						<div class="button-group border-yellow-light">...</div>

						<div class="button-group border-blue">...</div>

						<div class="button-group border-green-light">...</div>

						<div class="button-group">
							<button type="button" class="button">起步</button>
							<button type="button" class="button bg-red">元件</button>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="dropbutton">下拉式按钮</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="dropbutton-one">单下拉式菜单按钮</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-group">
								<button type="button" class="button dropdown-toggle">
									起步 <span class="downward"></span>
								</button>
								<ul class="drop-menu">
									<li><a href="#">动画</a></li>
									<li><a href="#">模块</a></li>
								</ul>
							</div>

							<br />
							<br />
							<div class="button-toolbar">

								<div class="button-group">
									<button type="button" class="button dropdown-toggle">
										起步 <span class="downward"></span>
									</button>
									<ul class="drop-menu">
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>

								<div class="button-group border-red">
									<button type="button" class="button dropdown-toggle">
										起步 <span class="downward"></span>
									</button>
									<ul class="drop-menu">
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group">
							<button type="button" class="button dropdown-toggle">
								起步 <span class="downward"></span>
							</button>
							<ul class="drop-menu">
								<li><a href="#">动画</a></li>
								<li><a href="#">模块</a></li>
							</ul>
						</div>

						<div class="button-toolbar">
							<div class="button-group">...</div>
							<div class="button-group">...</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="dropbutton-split">分裂式按钮下拉菜单</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-toolbar">

								<div class="button-group">
									<button type="button" class="button">起步</button>
									<button type="button" class="button dropdown-toggle">
										<span class="downward"></span>
									</button>
									<ul class="drop-menu">
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>

								<div class="button-group border-red">
									<button type="button" class="button">起步</button>
									<button type="button" class="button dropdown-toggle">
										<span class="downward"></span>
									</button>
									<ul class="drop-menu">
										<li><a href="#">动画</a></li>
										<li><a href="#">模块</a></li>
									</ul>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group">
							<button type="button" class="button">起步</button>
							<button type="button" class="button dropdown-toggle">
								<span class="downward"></span>
							</button>
							<ul class="drop-menu">
								<li><a href="#">动画</a></li>
								<li><a href="#">模块</a></li>
							</ul>
						</div>

						<div class="button-group border-red">...</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="dropbutton-size">尺寸</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-group">
								<button type="button" class="button button-big dropdown-toggle">
									起步 <span class="downward"></span>
								</button>
								<ul class="drop-menu">
									<li><a href="#">动画</a></li>
									<li><a href="#">模块</a></li>
								</ul>
							</div>
							<br />
							<br />
							<div class="button-group">
								<button type="button"
									class="button button-small dropdown-toggle">
									起步 <span class="downward"></span>
								</button>
								<ul class="drop-menu">
									<li><a href="#">动画</a></li>
									<li><a href="#">模块</a></li>
								</ul>
							</div>
							<br />
							<br />
							<div class="button-group">
								<button type="button"
									class="button button-little dropdown-toggle">
									起步 <span class="downward"></span>
								</button>
								<ul class="drop-menu">
									<li><a href="#">动画</a></li>
									<li><a href="#">模块</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group">
							<button type="button" class="button button-big dropdown-toggle">
								起步 <span class="downward"></span>
							</button>
							<ul class="drop-menu">
								<li><a href="#">动画</a></li>
								<li><a href="#">模块</a></li>
							</ul>
						</div>
						<div class="button-group">
							<button type="button" class="button button-small dropdown-toggle">
								起步 <span class="downward"></span>
							</button>
							<ul class="drop-menu">
								<li><a href="#">动画</a></li>
								<li><a href="#">模块</a></li>
							</ul>
						</div>
						<div class="button-group">
							<button type="button"
								class="button button-little dropdown-toggle">
								起步 <span class="downward"></span>
							</button>
							<ul class="drop-menu">
								<li><a href="#">动画</a></li>
								<li><a href="#">模块</a></li>
							</ul>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="dropbutton-up">向上弹出式菜单</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-group dropup">
								<button type="button" class="button dropdown-toggle">
									起步 <span class="upward"></span>
								</button>
								<ul class="drop-menu">
									<li><a href="#">动画</a></li>
									<li><a href="#">模块</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group dropup">
							<button type="button" class="button dropdown-toggle">
								起步 <span class="upward"></span>
							</button>
							<ul class="drop-menu">
								<li><a href="#">动画</a></li>
								<li><a href="#">模块</a></li>
							</ul>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="selected">选择</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="selected-style">选中样式</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<ul class="selected-inline">
								<li>起步</li>
								<li>CSS</li>
								<li class="selected">元件</li>
							</ul>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<ul class="selected-inline">
							<li>起步</li>
							<li>CSS</li>
							<li class="selected">元件</li>
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">颜色</h4>
					<div class="doc-input">给.selected添加.border-(*)样式，可快速改变选中的颜色。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<ul class="selected-inline">
								<li class="selected border-main">起步</li>
								<li class="selected border-sub">CSS</li>
								<li class="selected border-dot">元件</li>
							</ul>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<ul class="selected-inline">
							<li class="selected border-main">起步</li>
							<li class="selected border-sub">CSS</li>
							<li class="selected border-dot">元件</li>
						</ul>
						</xmp>
					</div>
					<h3 class="doc-h3" id="selected-checked">按钮式选中</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-group border-red check">
								<button type="button" class="button">会员</button>
								<button type="button" class="button active">998</button>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-group border-red check">
							<button type="button" class="button">会员</button>
							<button type="button" class="button active">998</button>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">边框及背景颜色</h4>
					<div class="doc-input">给相关元素添加.border-(*)及.bg-(*)样式，可改变边框及背景颜色。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="button-toolbar">

								<div class="button-group border-main check">
									<button type="button" class="button active">会员</button>
									<button type="button" class="button">998</button>
								</div>

								<div class="button-group button-group-small border-dot check">
									<button type="button" class="button">会员</button>
									<button type="button" class="button active">998</button>
								</div>

								<div
									class="button-group button-group-little border-blue-light check">
									<button type="button" class="button active">会员</button>
									<button type="button" class="button">998</button>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="button-toolbar">

							<div class="button-group border-main check">
								<button type="button" class="button active">会员</button>
								<button type="button" class="button">998</button>
							</div>

							<div class="button-group button-group-small border-dot check">
								<button type="button" class="button">会员</button>
								<button type="button" class="button active">998</button>
							</div>

							<div
								class="button-group button-group-little border-blue-light check">
								<button type="button" class="button active">会员</button>
								<button type="button" class="button">998</button>
							</div>

						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="textbg">文字色块</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="txtcolor-style">基本样式</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="txt radius-small">起步</div>
							<div class="txt radius">样式</div>
							<div class="txt radius-big">元件</div>
							<div class="txt radius-circle">动画</div>

							<div class="txt-border radius-small">
								<div class="txt radius-small">起步</div>
							</div>
							<div class="txt-border radius">
								<div class="txt radius">样式</div>
							</div>
							<div class="txt-border radius-big">
								<div class="txt radius-big">元件</div>
							</div>
							<div class="txt-border radius-circle">
								<div class="txt radius-circle">动画</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="txt radius-small">起步</div>
						<div class="txt radius">样式</div>
						<div class="txt radius-big">元件</div>
						<div class="txt radius-circle">动画</div>

						<div class="txt-border radius-small">
							<div class="txt radius-small">起步</div>
						</div>
						<div class="txt-border radius">
							<div class="txt radius">样式</div>
						</div>
						<div class="txt-border radius-big">
							<div class="txt radius-big">元件</div>
						</div>
						<div class="txt-border radius-circle">
							<div class="txt radius-circle">动画</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="txt-bgborder">背景和边框色</h3>
					<p class="doc-readme">添加.border-*及.bg-*系列样式，可以改变色块的背景和边框。</p>
					<h4 class="doc-title">背景色</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="txt radius-small bg-red">起步</div>
							<div class="txt radius bg-yellow">样式</div>
							<div class="txt radius-big bg-blue">元件</div>
							<div class="txt radius-circle bg-green">动画</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="txt radius-small bg-red">起步</div>
						<div class="txt radius bg-yellow">样式</div>
						<div class="txt radius-big bg-blue">元件</div>
						<div class="txt radius-circle bg-green">动画</div>
						</xmp>
					</div>
					<h4 class="doc-title">边框色</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="txt-border radius-small border-red">
								<div class="txt radius-small bg-red">起步</div>
							</div>
							<div class="txt-border radius border-yellow">
								<div class="txt radius bg-yellow">样式</div>
							</div>
							<div class="txt-border radius-big border-blue">
								<div class="txt radius-big bg-blue">元件</div>
							</div>
							<div class="txt-border radius-circle border-green">
								<div class="txt radius-circle bg-green">动画</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="txt-border radius-small border-red">
							<div class="txt radius-small bg-red">起步</div>
						</div>
						<div class="txt-border radius border-yellow">
							<div class="txt radius bg-yellow">样式</div>
						</div>
						<div class="txt-border radius-big border-blue">
							<div class="txt radius-big bg-blue">元件</div>
						</div>
						<div class="txt-border radius-circle border-green">
							<div class="txt radius-circle bg-green">动画</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="txt-size">尺寸</h3>
					<p class="doc-readme">通过使用.txt-large,.txt-big,.txt-small,.txt-little样式，快速改变色块大小。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							特大 128*128px<br />
							<br />
							<div class="txt txt-large radius-small bg-red">起步</div>
							<div class="txt txt-large radius bg-yellow">样式</div>
							<div class="txt-border txt-large radius-big border-blue">
								<div class="txt radius-big bg-blue">元件</div>
							</div>
							<div class="txt-border txt-large radius-circle border-green">
								<div class="txt radius-circle bg-green">动画</div>
							</div>

							<br />
							<br />
							<hr />
							大号 64*64px <br />
							<br />
							<div class="txt txt-big radius-small bg-red">起步</div>
							<div class="txt txt-big radius bg-yellow">样式</div>
							<div class="txt-border txt-big radius-big border-blue">
								<div class="txt radius-big bg-blue">元件</div>
							</div>
							<div class="txt-border txt-big radius-circle border-green">
								<div class="txt radius-circle bg-green">动画</div>
							</div>

							<br />
							<br />
							<hr />
							默认 48*48px <br />
							<br />
							<div class="txt radius-small bg-red">起步</div>
							<div class="txt radius bg-yellow">样式</div>
							<div class="txt-border radius-big border-blue">
								<div class="txt radius-big bg-blue">元件</div>
							</div>
							<div class="txt-border radius-circle border-green">
								<div class="txt radius-circle bg-green">动画</div>
							</div>

							<br />
							<br />
							<hr />
							小号 32*32px <br />
							<br />
							<div class="txt txt-small radius-small bg-red">1</div>
							<div class="txt txt-small radius bg-yellow">2</div>
							<div class="txt-border txt-small radius-big border-blue">
								<div class="txt radius-big bg-blue">3</div>
							</div>
							<div class="txt-border txt-small radius-circle border-green">
								<div class="txt radius-circle bg-green">4</div>
							</div>
							<br />
							<br />
							<hr />
							特小 16*16px <br />
							<br />
							<div class="txt txt-little radius-small bg-red icon-star"></div>
							<div class="txt txt-little radius bg-yellow icon-yen"></div>
							<div class="txt-border txt-little radius-big border-blue">
								<div class="txt radius-big bg-blue">3</div>
							</div>
							<div class="txt-border txt-little radius-circle border-green">
								<div class="txt radius-circle bg-green">4</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="txt txt-large radius-small bg-red">起步</div>
						<div class="txt txt-large radius bg-yellow">样式</div>
						<div class="txt-border txt-large radius-big border-blue">
							<div class="txt radius-big bg-blue">元件</div>
						</div>
						<div class="txt-border txt-large radius-circle border-green">
							<div class="txt radius-circle bg-green">动画</div>
						</div>

						<div class="txt txt-big radius-small bg-red">起步</div>
						<div class="txt txt-big radius bg-yellow">样式</div>
						<div class="txt-border txt-big radius-big border-blue">
							<div class="txt radius-big bg-blue">元件</div>
						</div>
						<div class="txt-border txt-big radius-circle border-green">
							<div class="txt radius-circle bg-green">动画</div>
						</div>

						<div class="txt radius-small bg-red">起步</div>
						<div class="txt radius bg-yellow">样式</div>
						<div class="txt-border radius-big border-blue">
							<div class="txt radius-big bg-blue">元件</div>
						</div>
						<div class="txt-border radius-circle border-green">
							<div class="txt radius-circle bg-green">动画</div>
						</div>

						<div class="txt txt-small radius-small bg-red">1</div>
						<div class="txt txt-small radius bg-yellow">2</div>
						<div class="txt-border txt-small radius-big border-blue">
							<div class="txt radius-big bg-blue">3</div>
						</div>
						<div class="txt-border txt-small radius-circle border-green">
							<div class="txt radius-circle bg-green">4</div>
						</div>

						<div class="txt txt-little radius-small bg-red icon-star"></div>
						<div class="txt txt-little radius bg-yellow icon-yen"></div>
						<div class="txt-border txt-little radius-big border-blue">
							<div class="txt radius-big bg-blue">3</div>
						</div>
						<div class="txt-border txt-little radius-circle border-green">
							<div class="txt radius-circle bg-green">4</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">使用小文本</h4>
					<div class="doc-input">使用.txt-large及.txt-big可给文字添加span标签，可以使用小文本内容。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							特大<br />
							<br />
							<div class="txt txt-large radius-small bg-red">
								1<span>个</span>
							</div>
							<div class="txt txt-large radius bg-yellow">
								2<span>元</span>
							</div>
							<div class="txt-border txt-large radius-big border-blue">
								<div class="txt radius-big bg-blue">
									3<span>时</span>
								</div>
							</div>
							<div class="txt-border txt-large radius-circle border-green">
								<div class="txt radius-circle bg-green">
									4<span>天</span>
								</div>
							</div>

							<br />
							<br />
							<hr />
							大号 <br />
							<br />
							<div class="txt txt-big radius-small bg-red">
								1<span>个</span>
							</div>
							<div class="txt txt-big radius bg-yellow">
								2<span>元</span>
							</div>
							<div class="txt-border txt-big radius-big border-blue">
								<div class="txt radius-big bg-blue">
									3<span>时</span>
								</div>
							</div>
							<div class="txt-border txt-big radius-circle border-green">
								<div class="txt radius-circle bg-green">
									4<span>天</span>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="txt txt-large radius-small bg-red">
							1<span>个</span>
						</div>
						<div class="txt txt-large radius bg-yellow">
							2<span>元</span>
						</div>
						<div class="txt-border txt-large radius-big border-blue">
							<div class="txt radius-big bg-blue">
								3<span>时</span>
							</div>
						</div>
						<div class="txt-border txt-large radius-circle border-green">
							<div class="txt radius-circle bg-green">
								4<span>天</span>
							</div>
						</div>

						<div class="txt txt-big radius-small bg-red">
							1<span>个</span>
						</div>
						<div class="txt txt-big radius bg-yellow">
							2<span>元</span>
						</div>
						<div class="txt-border txt-big radius-big border-blue">
							<div class="txt radius-big bg-blue">
								3<span>时</span>
							</div>
						</div>
						<div class="txt-border txt-big radius-circle border-green">
							<div class="txt radius-circle bg-green">
								4<span>天</span>
							</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">使用大文本</h4>
					<div class="doc-input">给文字添加strong标签，可使用更大号文本。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							特大<br />
							<br />
							<div class="txt txt-large radius-small bg-red">
								<strong>1</strong><span>个</span>
							</div>
							<div class="txt txt-large radius bg-yellow">
								<strong>2</strong><span>元</span>
							</div>
							<div class="txt-border txt-large radius-big border-blue">
								<div class="txt radius-big bg-blue">
									<strong>3</strong><span>时</span>
								</div>
							</div>
							<div class="txt-border txt-large radius-circle border-green">
								<div class="txt radius-circle bg-green">
									<strong>4</strong><span>天</span>
								</div>
							</div>

							<br />
							<br />
							<hr />
							大号 <br />
							<br />
							<div class="txt txt-big radius-small bg-red">
								<strong>1</strong><span>个</span>
							</div>
							<div class="txt txt-big radius bg-yellow">
								<strong>2</strong><span>元</span>
							</div>
							<div class="txt-border txt-big radius-big border-blue">
								<div class="txt radius-big bg-blue">
									<strong>3</strong><span>时</span>
								</div>
							</div>
							<div class="txt-border txt-big radius-circle border-green">
								<div class="txt radius-circle bg-green">
									<strong>4</strong><span>天</span>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="txt txt-large radius-small bg-red">
							<strong>1</strong><span>个</span>
						</div>
						<div class="txt txt-large radius bg-yellow">
							<strong>2</strong><span>元</span>
						</div>
						<div class="txt-border txt-large radius-big border-blue">
							<div class="txt radius-big bg-blue">
								<strong>3</strong><span>时</span>
							</div>
						</div>
						<div class="txt-border txt-large radius-circle border-green">
							<div class="txt radius-circle bg-green">
								<strong>4</strong><span>天</span>
							</div>
						</div>

						<div class="txt txt-big radius-small bg-red">
							<strong>1</strong><span>个</span>
						</div>
						<div class="txt txt-big radius bg-yellow">
							<strong>2</strong><span>元</span>
						</div>
						<div class="txt-border txt-big radius-big border-blue">
							<div class="txt radius-big bg-blue">
								<strong>3</strong><span>时</span>
							</div>
						</div>
						<div class="txt-border txt-big radius-circle border-green">
							<div class="txt radius-circle bg-green">
								<strong>4</strong><span>天</span>
							</div>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="media">媒体组</h2>
					<p class="doc-lead">色块、图片、视频等媒体信息与文字构成的组合。</p>
					<h3 class="doc-h3" id="midea-style">媒体样式</h3>
					<p class="doc-readme"></p>
					<h4 class="doc-title">默认样式</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="media">
								<a href="#"> <img src="/images/64.png" class="radius"
									alt="...">
								</a>
								<div class="media-body">
									<strong>媒体标题</strong> 拼图，是国内一款开源的专业响应式网页前端框架。
								</div>
							</div>

							<div class="media">
								<a href="#">
									<div class="txt txt-big radius bg-main">1</div>
								</a>
								<div class="media-body">媒体标题</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="media">
							<a href="#"> <img src="/images/64.png" class="radius"
								alt="...">
							</a>
							<div class="media-body">
								<strong>媒体标题</strong> 拼图，是国内一款开源的专业响应式网页前端框架。
							</div>
						</div>

						<div class="media">
							<a href="#">
								<div class="txt txt-big radius bg-main">1</div>
							</a>
							<div class="media-body">媒体标题</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">竖向排列</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="media media-y">
								<a href="#"> <img src="/images/48.png" class="radius"
									alt="...">
								</a>
								<div class="media-body">
									<strong>媒体标题</strong> 拼图，是国内一款开源的专业响应式网页前端框架。
								</div>
							</div>

							<div class="media  media-y">
								<a href="#">
									<div class="txt-border txt-small radius-circle border-green">
										<div class="txt radius-circle bg-green">1</div>
									</div>
								</a>
								<div class="media-body">媒体标题</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="media media-y">
							<a href="#"> <img src="/images/48.png" class="radius"
								alt="...">
							</a>
							<div class="media-body">
								<strong>媒体标题</strong> 拼图，是国内一款开源的专业响应式网页前端框架。
							</div>
						</div>

						<div class="media  media-y">
							<a href="#">
								<div class="txt-border txt-small radius-circle border-green">
									<div class="txt radius-circle bg-green">1</div>
								</div>
							</a>
							<div class="media-body">媒体标题</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">横向排列</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="media media-x">
								<a class="float-left" href="#"> <img src="/images/64.png"
									class="radius" alt="...">
								</a>
								<div class="media-body">
									<strong>媒体标题</strong>
									拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。
								</div>
							</div>

							<div class="media  media-x">
								<a class="float-left" href="#">
									<div class="txt-border txt-little radius-circle border-green">
										<div class="txt radius-circle bg-green">1</div>
									</div>
								</a>
								<div class="media-body">媒体标题</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="media media-x">
							<a class="float-left" href="#"> <img src="..." class="radius"
								alt="...">
							</a>
							<div class="media-body">
								<strong>...</strong> ...
							</div>
						</div>

						<div class="media  media-x">
							<a class="float-left" href="#">
								<div class="txt-border txt-little radius-circle border-green">
									<div class="txt radius-circle bg-green">1</div>
								</div>
							</a>
							<div class="media-body">...</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">向右排列</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="media media-x">
								<a class="float-right" href="#"> <img src="/images/64.png"
									class="radius" alt="...">
								</a>
								<div class="media-body">
									<strong>媒体标题</strong>
									拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="media media-x">
							<a class="float-right" href="#"> <img src="..."
								class="radius" alt="...">
							</a>
							<div class="media-body">
								<strong>...</strong> ...
							</div>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">标题在先的样式</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="media media-x">
								<strong>媒体标题：拼图-中国人自己的前端框架</strong> <a class="float-left"
									href="#"> <img src="/images/64.png" class="radius"
									alt="...">
								</a>
								<div class="media-body">
									拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。<br />不用学习CSS,不用学习HTML，也不用学习Javascrtip，就可以快速的掌握前端开发。
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="media media-x">
							<strong>...</strong> <a class="float-left" href="#"> <img
								src="/images/64.png" class="radius" alt="...">
							</a>
							<div class="media-body">...</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="media-inline">列表显示</h3>
					<p class="doc-readme">媒体信息在一行内显示。</p>
					<h4 class="doc-title">默认样式</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="media-inline">
								<div class="media clearfix">
									<a href="#"> <img src="/images/128.png" class="radius"
										alt="...">
									</a>
									<div class="media-body">
										<strong>媒体标题</strong>
									</div>
								</div>

								<div class="media clearfix">
									<a href="#"> <img src="/images/128.png" class="radius"
										alt="...">
									</a>
									<div class="media-body">
										<strong>媒体标题</strong>
									</div>
								</div>

								<div class="media clearfix">
									<a href="#"> <img src="/images/128.png" class="radius"
										alt="...">
									</a>
									<div class="media-body">
										<strong>媒体标题</strong>
									</div>
								</div>

								<div class="media clearfix">
									<a href="#"> <img src="/images/128.png" class="radius"
										alt="...">
									</a>
									<div class="media-body">
										<strong>媒体标题</strong>
									</div>
								</div>

								<div class="media clearfix">
									<a href="#"> <img src="/images/128.png" class="radius"
										alt="...">
									</a>
									<div class="media-body">
										<strong>媒体标题</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="media-inline">
							<div class="media clearfix">
								<a href="#"> <img src="/images/128.png" class="radius"
									alt="...">
								</a>
								<div class="media-body">
									<strong>媒体标题</strong>
								</div>
							</div>
							...
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">跨屏响应式排列</h4>
					<div class="doc-input">通过拼图的网格系统和响应式图片样式，让水平排列具有跨屏响应式功能。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="line-middle clearfix">

								<div class="xl12 xs6 xm4 xb2">
									<div class="media clearfix">
										<a href="#"><img src="/images/128.png"
											class="radius img-responsive" alt="..."></a>
										<div class="media-body">
											<strong>媒体标题</strong>
											<p>拼图是优秀的响应式前端框架，自动适应电脑、平板、手机等设备，让前端开发更简单、便捷。</p>
										</div>
									</div>
								</div>

								<div class="xl12 xs6 xm4 xb2">
									<div class="media clearfix">
										<a href="#"><img src="/images/128.png"
											class="radius img-responsive" alt="..."></a>
										<div class="media-body">
											<strong>媒体标题</strong>
											<p>拼图是优秀的响应式前端框架，自动适应电脑、平板、手机等设备，让前端开发更简单、便捷。</p>
										</div>
									</div>
								</div>

								<div class="xl12 xs6 xm4 xb2">
									<div class="media clearfix">
										<a href="#"><img src="/images/128.png"
											class="radius img-responsive" alt="..."></a>
										<div class="media-body">
											<strong>媒体标题</strong>
											<p>拼图是优秀的响应式前端框架，自动适应电脑、平板、手机等设备，让前端开发更简单、便捷。</p>
										</div>
									</div>
								</div>

								<div class="xl12 xs6 xm4 xb2">
									<div class="media clearfix">
										<a href="#"><img src="/images/128.png"
											class="radius img-responsive" alt="..."></a>
										<div class="media-body">
											<strong>媒体标题</strong>
											<p>拼图是优秀的响应式前端框架，自动适应电脑、平板、手机等设备，让前端开发更简单、便捷。</p>
										</div>
									</div>
								</div>

								<div class="xl12 xs6 xm4 xb2">
									<div class="media clearfix">
										<a href="#"><img src="/images/128.png"
											class="radius img-responsive" alt="..."></a>
										<div class="media-body">
											<strong>媒体标题</strong>
											<p>拼图是优秀的响应式前端框架，自动适应电脑、平板、手机等设备，让前端开发更简单、便捷。</p>
										</div>
									</div>
								</div>

								<div class="xl12 xs6 xm4 xb2">
									<div class="media clearfix">
										<a href="#"><img src="/images/128.png"
											class="radius img-responsive" alt="..."></a>
										<div class="media-body">
											<strong>媒体标题</strong>
											<p>拼图是优秀的响应式前端框架，自动适应电脑、平板、手机等设备，让前端开发更简单、便捷。</p>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="line-middle">

							<div class="xl12 xs6 xm4 xb2">
								<div class="media clearfix">
									<a href="#"><img src="/images/128.png"
										class="radius img-responsive" alt="..."></a>
									<div class="media-body">
										<strong>媒体标题</strong>
										<p>拼图是优秀的响应式前端框架，自动适应电脑、平板、手机等设备，让前端开发更简单、便捷。</p>
									</div>
								</div>
							</div>
							...

						</div>
						</xmp>
					</div>
					<h4 class="doc-title">竖向排列</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="media-inline">

								<div class="media media-y clearfix">
									<a href="#"><img src="/images/48.png" class="radius"
										alt="..."></a>
									<div class="media-body">
										<strong>媒体标题</strong>
									</div>
								</div>
								<div class="media media-y clearfix">
									<a href="#"><img src="/images/48.png" class="radius"
										alt="..."></a>
									<div class="media-body">
										<strong>媒体标题</strong>
									</div>
								</div>
								<div class="media media-y clearfix">
									<a href="#"><img src="/images/48.png" class="radius"
										alt="..."></a>
									<div class="media-body">
										<strong>媒体标题</strong>
									</div>
								</div>
								<div class="media media-y clearfix">
									<a href="#"><img src="/images/48.png" class="radius"
										alt="..."></a>
									<div class="media-body">
										<strong>媒体标题</strong>
									</div>
								</div>
								<div class="media media-y clearfix">
									<a href="#"><img src="/images/48.png" class="radius"
										alt="..."></a>
									<div class="media-body">
										<strong>媒体标题</strong>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="media-inline">
							<div class="media media-y clearfix">
								<a href="#"><img src="/images/48.png" class="radius"
									alt="..."></a>
								<div class="media-body">
									<strong>媒体标题</strong>
								</div>
							</div>
							...
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">横向排列</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="media-inline">

								<div class="media media-x clearfix">
									<a class="float-left" href="#"><img src="/images/48.png"
										class="radius" alt="..."></a>
									<div class="media-body">
										<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架。
									</div>
								</div>

								<div class="media media-x clearfix">
									<a class="float-left" href="#"><img src="/images/48.png"
										class="radius" alt="..."></a>
									<div class="media-body">
										<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架。
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="media-inline">
							<div class="media media-x clearfix">
								<a class="float-left" href="#"><img src="/images/48.png"
									class="radius" alt="..."></a>
								<div class="media-body">
									<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架。
								</div>
							</div>
							...
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="media-nested">嵌套排列</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="media media-x">
								<a class="float-left" href="#"><img src="/images/64.png"
									class="radius" alt="..."></a>
								<div class="media-body">
									<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。

									<div class="media media-x">
										<a class="float-left" href="#"><img src="/images/64.png"
											class="radius" alt="..."></a>
										<div class="media-body">
											<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。


											<div class="media media-x">
												<a class="float-left" href="#"><img src="/images/64.png"
													class="radius" alt="..."></a>
												<div class="media-body">
													<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。
												</div>
											</div>

										</div>
									</div>

								</div>
							</div>

							<div class="media media-x">
								<a class="float-left" href="#"><img src="/images/64.png"
									class="radius" alt="..."></a>
								<div class="media-body">
									<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。
								</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="media media-x">
							<a class="float-left" href="#"><img src="/images/64.png"
								class="radius" alt="..."></a>
							<div class="media-body">
								<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。

								<div class="media media-x">
									<a class="float-left" href="#"><img src="/images/64.png"
										class="radius" alt="..."></a>
									<div class="media-body">
										<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。


										<div class="media media-x">
											<a class="float-left" href="#"><img src="/images/64.png"
												class="radius" alt="..."></a>
											<div class="media-body">
												<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。
											</div>
										</div>

									</div>
								</div>

							</div>
						</div>

						<div class="media media-x">
							<a class="float-left" href="#"><img src="/images/64.png"
								class="radius" alt="..."></a>
							<div class="media-body">
								<strong>媒体标题</strong>拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。
							</div>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="formgroup">表单组</h2>
					<p class="doc-lead">上一节CSS里，已介绍了表单的基本信息，如输入框，多选，单选，块显示等内容，这一节主要介绍相关的组合，以后提示内容相关的输入框组样式。</p>
					<h3 class="doc-h3" id="inputs-style">基本样式</h3>
					<p class="doc-readme"></p>
					<h4 class="doc-title">默认样式</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<label for="username">账号</label>
									</div>
									<div class="field">
										<input type="text" class="input" id="username" name="username"
											size="30" placeholder="手机/邮箱/账号" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="password">密码</label>
									</div>
									<div class="field">
										<input type="password" class="input" id="password"
											name="password" size="30" placeholder="请输入密码" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="cookies">保留时间</label>
									</div>
									<div class="field">
										<select class="input" name="cookies">
											<option>保留一周</option>
											<option>保留一月</option>
											<option>永久保留</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>记住我</label>
									</div>
									<div class="field">
										<div class="button-group radio">
											<label class="button active"><input name="pintuer"
												value="yes" checked="checked" type="radio"><span
												class="icon icon-check"></span> 记住吧</label> <label class="button"><input
												name="pintuer" value="no" type="radio"><span
												class="icon icon-times"></span> 不想记住</label>
										</div>
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="label">
									<label for="username">账号</label>
								</div>
								<div class="field">
									<input type="text" class="input" id="username" name="username"
										size="30" placeholder="手机/邮箱/账号" />
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="password">密码</label>
								</div>
								<div class="field">
									<input type="password" class="input" id="password"
										name="password" size="30" placeholder="请输入密码" />
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="cookies">保留时间</label>
								</div>
								<div class="field">
									<select class="input" name="cookies">
										<option>保留一周</option>
										<option>保留一月</option>
										<option>永久保留</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label>记住我</label>
								</div>
								<div class="field">
									<div class="button-group radio">
										<label class="button active"><input name="pintuer"
											value="yes" checked="checked" type="radio"><span
											class="icon icon-check"></span> 记住吧</label> <label class="button"><input
											name="pintuer" value="no" type="radio"><span
											class="icon icon-times"></span> 不想记住</label>
									</div>
								</div>
							</div>
							<div class="form-button">
								<button class="button" type="submit">登录</button>
							</div>
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">去掉label</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;">
								<div class="form-group">
									<div class="field">
										<input type="text" class="input" id="username" name="username"
											size="30" placeholder="手机/邮箱/账号" />
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<input type="password" class="input" id="password"
											name="password" size="30" placeholder="请输入密码" />
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<select class="input" name="cookies">
											<option>保留一周</option>
											<option>保留一月</option>
											<option>永久保留</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<div class="button-group button-group-justified radio">
											<label class="button active"><input name="pintuer"
												value="yes" checked="checked" type="radio"><span
												class="icon icon-check"></span> 记住吧</label> <label class="button"><input
												name="pintuer" value="no" type="radio"><span
												class="icon icon-times"></span> 不想记住</label>
										</div>
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="field">
									<input type="text" class="input" id="username" name="username"
										size="30" placeholder="手机/邮箱/账号" />
								</div>
							</div>
							...
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">增加帮助信息</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<label for="username">账号</label>
									</div>
									<div class="field">
										<input type="text" class="input" id="username" name="username"
											size="30" placeholder="手机/邮箱/会员号" />
										<div class="input-note">登录账号包含手机、邮箱和会员号。</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="password">密码</label>
									</div>
									<div class="field">
										<input type="password" class="input" id="password"
											name="password" size="30" placeholder="请输入密码" />
										<div class="input-note">登录会员的密码口令。</div>
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="label">
									<label for="username">账号</label>
								</div>
								<div class="field">
									<input type="text" class="input" id="username" name="username"
										size="30" placeholder="手机/邮箱/会员号" />
									<div class="input-note">登录账号包含手机、邮箱和会员号。</div>
								</div>
							</div>
							...
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">输入框自由宽度</h4>
					<div class="doc-input">给.input添加.input-auto，输入框即为size的宽度，或给form添加form-auto样式，表单内的输入框都按size的宽度显示。</div>
					<h4 class="doc-title">单独设置</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<label for="username">账号</label>
									</div>
									<div class="field">
										<input type="text" class="input input-auto" id="username"
											name="username" size="30" placeholder="手机/邮箱/会员号" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="password">密码</label>
									</div>
									<div class="field">
										<input type="password" class="input input-auto" id="password"
											name="password" size="20" placeholder="请输入密码" />
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="label">
									<label for="username">账号</label>
								</div>
								<div class="field">
									<input type="text" class="input input-auto" id="username"
										name="username" size="30" placeholder="手机/邮箱/会员号" />
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="password">密码</label>
								</div>
								<div class="field">
									<input type="password" class="input input-auto" id="password"
										name="password" size="20" placeholder="请输入密码" />
								</div>
							</div>
							<div class="form-button">
								<button class="button" type="submit">登录</button>
							</div>
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">整体表单设置</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" class="form-auto" onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<label for="username">账号</label>
									</div>
									<div class="field">
										<input type="text" class="input" id="username" name="username"
											size="20" placeholder="手机/邮箱/会员号" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="password">密码</label>
									</div>
									<div class="field">
										<input type="password" class="input" id="money" name="money"
											size="20" placeholder="密码" />
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post" class="form-auto">...</form>
						</xmp>
					</div>
					<div class="doc-input">在移动设备上，自动默认为整行显示，如需将单个输入框设置自由宽度，可通过给输入框加.input-auto样式实现。</div>
					<h4 class="doc-title">添加图标</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;" class="form-auto">
								<div class="form-group">
									<div class="field field-icon">
										<span class="icon icon-user"></span> <input type="text"
											class="input" id="username" name="username" size="30"
											placeholder="手机/邮箱/账号" />
									</div>
								</div>
								<div class="form-group">
									<div class="field field-icon">
										<span class="icon icon-key"></span> <input type="password"
											class="input" id="password" name="password" size="30"
											placeholder="请输入密码" />
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post" class="form-auto">
							<div class="form-group">
								<div class="field field-icon">
									<input type="text" class="input" id="username" name="username"
										size="30" placeholder="手机/邮箱/账号" /> <span
										class="icon icon-user"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon">
									<input type="password" class="input" id="password"
										name="password" size="30" placeholder="请输入密码" /> <span
										class="icon icon-key"></span>
								</div>
							</div>
							<div class="form-button">
								<button class="button" type="submit">登录</button>
							</div>
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">右侧图标</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<span class="float-right">登录账号包含手机、邮箱和会员号。</span> <label
											for="username">账号</label>
									</div>
									<div class="field field-icon-right">
										<span class="icon icon-user"></span> <input type="text"
											class="input" id="username" name="username" size="30"
											placeholder="手机/邮箱/账号" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<span class="float-right">登录会员的密码口令。</span> <label
											for="password">密码</label>
									</div>
									<div class="field field-icon-right">
										<span class="icon icon-key"></span> <input type="password"
											class="input" id="password" name="password" size="30"
											placeholder="请输入密码" />
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="label">
									<span class="float-right">登录账号包含手机、邮箱和会员号。</span> <label
										for="username">账号</label>
								</div>
								<div class="field field-icon-right">
									<span class="icon icon-check"></span> <input type="text"
										class="input" id="username" name="username" size="30"
										placeholder="手机/邮箱/账号" />
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<span class="float-right">登录会员的密码口令。</span> <label
										for="password">密码</label>
								</div>

								<div class="field field-icon-right">
									<span class="icon icon-times"></span> <input type="password"
										class="input" id="password" name="password" size="30"
										placeholder="请输入密码" />
								</div>
							</div>
							<div class="form-button">
								<button class="button" type="submit">登录</button>
							</div>
						</form>
						</xmp>
					</div>
					<blockquote class="quote border-green doc-quote">
						<strong>右侧帮助</strong> 提示放在label里，设置.float-right样式，也可以把帮助放在右侧。
					</blockquote>
					<h3 class="doc-h3" id="inputs-x">水平方向显示</h3>
					<p class="doc-readme">给form添加.form-x，让标签label与输入域field在水平方向上显示。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" class="form-x" onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<label for="username">账号</label>
									</div>
									<div class="field">
										<input type="text" class="input" id="username" name="username"
											size="30" placeholder="手机/邮箱/账号" />
										<div class="input-note">登录账号包含手机、邮箱和会员号。</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="password">密码</label>
									</div>
									<div class="field">
										<input type="password" class="input" id="password"
											name="password" size="30" placeholder="请输入密码" />
										<div class="input-note">登录会员的密码口令。</div>
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post" class="form-x">...</form>
						</xmp>
					</div>
					<h4 class="doc-title">输入框自由宽度</h4>
					<div class="doc-input">给form添加.form-auto或给输入框添加.input-auto，表单内的输入框水平方向上按size的属性显示。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" class="form-x form-auto"
								onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<label for="username">账号</label>
									</div>
									<div class="field">
										<input type="text" class="input input-auto" id="username"
											name="username" size="30" placeholder="手机/邮箱/账号" />
										<div class="input-note">登录账号包含手机、邮箱和会员号。</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="password">密码</label>
									</div>
									<div class="field">
										<input type="password" class="input" id="password"
											name="password" size="30" placeholder="请输入密码" />
										<div class="input-note">登录会员的密码口令。</div>
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post" class="form-x form-auto">
							<input class="input input-auto" /> ...
						</form>
						</xmp>
					</div>
					<h3 class="doc-h3" id="inputs-inline">内联排列</h3>
					<p class="doc-readme">给form添加.form-inline样式，实现输入框的内联模式。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" class="form-inline" onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<label for="username">账号</label>
									</div>
									<div class="field">
										<input type="text" class="input" id="username" name="username"
											size="20" placeholder="手机/邮箱/账号" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="password">密码</label>
									</div>
									<div class="field">
										<input type="text" class="input" id="money" name="money"
											size="20" placeholder="密码" />
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post" class="form-inline">
							<div class="form-group">
								<div class="label">
									<label for="username">账号</label>
								</div>
								<div class="field">
									<input type="text" class="input" id="username" name="username"
										size="20" placeholder="手机/邮箱/账号" />
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="password">密码</label>
								</div>
								<div class="field">
									<input type="text" class="input" id="money" name="money"
										size="20" placeholder="密码" />
								</div>
							</div>
							<div class="form-button">
								<button class="button" type="submit">登录</button>
							</div>
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">也可以去掉label标签</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" class="form-inline" onsubmit="return false;">
								<div class="form-group">
									<div class="field">
										<input type="text" class="input" id="money" name="money"
											size="20" placeholder="邮箱" />
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<input type="text" class="input" id="money" name="money"
											size="20" placeholder="密码" />
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>

							<br />
							<br />

							<form method="post" class="form-inline" onsubmit="return false;">
								<div class="form-group">
									<div class="field">
										<div class="input-group">
											<span class="addon icon-user"></span><input type="text"
												class="input" id="money" name="money" size="20"
												placeholder="用户" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<div class="input-group">
											<span class="addon icon-key"></span><input type="text"
												class="input" id="money" name="money" size="20"
												placeholder="密码" />
										</div>
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post" class="form-inline">
							<div class="form-group">
								<div class="field">
									<input type="text" class="input" id="username" name="username"
										size="20" placeholder="手机/邮箱/账号" />
								</div>
							</div>
							...
						</form>


						<form method="post" class="form-inline" onsubmit="return false;">
							<div class="form-group">
								<div class="field">
									<div class="input-group">
										<span class="addon icon-user"></span><input type="text"
											class="input" id="money" name="money" size="20"
											placeholder="用户" />
									</div>
								</div>
							</div>
							...
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">更亲密一些</h4>
					<div class="doc-input">使用.input-inline样式，可以让一行内的输入框连在一起。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;">
								<div class="input-inline clearfix">
									<input type="text" class="input" id="username" name="username"
										size="20" placeholder="手机/邮箱/账号" /> <input type="password"
										class="input" id="password" name="password" size="20"
										placeholder="请输入密码" /> <input class="button" type="submit"
										value="登录" />
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="input-inline clearfix">
								<input type="text" class="input" id="username" name="username"
									size="20" placeholder="手机/邮箱/账号" /> <input type="password"
									class="input" id="password" name="password" size="20"
									placeholder="请输入密码" /> <input class="button" type="submit"
									value="登录" />
							</div>
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">也有垂直方向上连在一起的</h4>
					<div class="doc-input">使用.input-block样式，可以让一列内的输入框连在一起。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;">
								<div class="input-block">
									<input type="text" class="input" id="username" name="username"
										size="20" placeholder="手机/邮箱/账号" /> <input type="password"
										class="input" id="password" name="password" size="20"
										placeholder="请输入密码" />
								</div>
								<div class="input-block">
									<input type="text" class="input" id="username" name="username"
										size="20" placeholder="手机/邮箱/账号" /> <input type="password"
										class="input" id="password" name="password" size="20"
										placeholder="请输入密码" /> <input type="text" class="input"
										id="username" name="username" size="20" placeholder="验证码" />
									<input class="button button-block" type="submit" value="登录" />
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="input-block">
								<input type="text" class="input" id="username" name="username"
									size="20" placeholder="手机/邮箱/账号" /> <input type="password"
									class="input" id="password" name="password" size="20"
									placeholder="请输入密码" />
								<button class="button" type="submit">登录</button>
							</div>
							<div class="input-block">
								<input type="text" class="input" id="username" name="username"
									size="20" placeholder="手机/邮箱/账号" /> <input type="password"
									class="input" id="password" name="password" size="20"
									placeholder="请输入密码" /> <input class="button button-block"
									type="submit" value="登录" />
							</div>
						</form>
						</xmp>
					</div>
					<h3 class="doc-h3" id="radiocheck">单选多选组合</h3>
					<p class="doc-readme">多个单选或多选时的排列组合。</p>
					<h4 class="doc-title">默认样式</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post">
								<div class="form-group">
									<div class="label">
										<strong>拼图</strong>
									</div>
									<div class="field">
										<label><input name="pintuer" type="checkbox">
											起步</label> <label><input name="pintuer" type="checkbox">
											CSS</label> <label><input name="pintuer" type="checkbox">
											元件</label> <label><input name="pintuer" type="checkbox">
											动画</label> <label><input name="pintuer" type="checkbox">
											js组件</label> <label><input name="pintuer" type="checkbox">
											模块</label>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<strong>拼图</strong>
									</div>
									<div class="field">
										<label><input name="pintuer" type="radio"> 起步</label>
										<label><input name="pintuer" type="radio"> CSS</label>
										<label><input name="pintuer" type="radio"> 元件</label>
										<label><input name="pintuer" type="radio"> 动画</label>
										<label><input name="pintuer" type="radio">
											js组件</label> <label><input name="pintuer" type="radio">
											模块</label>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="label">
									<strong>拼图</strong>
								</div>
								<div class="field">
									<label><input name="pintuer" type="checkbox">...</label>
									...
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<strong>拼图</strong>
								</div>
								<div class="field">
									<label><input name="pintuer" type="radio">...</label>
									...
								</div>
							</div>
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">按钮组显示单选或多选</h4>
					<div class="doc-input">使用按钮组的方式显示单选或多选，效果需要用js配合，详细的使用方法请看"js组件"的单选多选。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post">

								<div class="form-group">
									<div class="label">
										<strong>单选</strong>
									</div>
									<div class="field">
										<div class="button-group radio">
											<label class="button active"><input name="pintuer"
												value="1" checked="checked" type="radio"><span
												class="icon icon-check text-green"></span> 确定</label> <label
												class="button"><input name="pintuer" value="2"
												type="radio"><span class="icon icon-times"></span>
												取消</label>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="label">
										<strong>单选</strong>
									</div>
									<div class="field">
										<div class="button-group radio">
											<label class="button active"><input name="pintuer"
												value="1" checked="checked" type="radio">起步</label> <label
												class="button"><input name="pintuer" value="2"
												type="radio">CSS</label> <label class="button"><input
												name="pintuer" value="3" type="radio">元件</label> <label
												class="button"><input name="pintuer" value="4"
												type="radio">JS组件</label> <label class="button"><input
												name="pintuer" value="5" type="radio">模块</label>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="label">
										<strong>多选</strong>
									</div>
									<div class="field">
										<div class="button-group checkbox">
											<label class="button active"><input name="pintuer"
												value="1" type="checkbox" checked="checked"><span
												class="icon icon-heart"></span> 喜欢</label> <label class="button"><input
												name="pintuer" value="2" type="checkbox"><span
												class="icon icon-star"></span> 收藏</label>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="label">
										<strong>多选</strong>
									</div>
									<div class="field">
										<div class="button-group checkbox">
											<label class="button active"><input name="pintuer"
												value="1" type="checkbox" checked="checked">起步</label> <label
												class="button"><input name="pintuer" value="2"
												type="checkbox">CSS</label> <label class="button"><input
												name="pintuer" value="3" type="checkbox">元件</label> <label
												class="button"><input name="pintuer" value="4"
												type="checkbox">JS组件</label> <label class="button"><input
												name="pintuer" value="5" type="checkbox">模块</label>
										</div>
									</div>
								</div>

							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">

							<div class="form-group">
								<div class="label">
									<strong>单选</strong>
								</div>
								<div class="field">
									<div class="button-group radio">
										<label class="button active"><input name="pintuer"
											value="1" checked="checked" type="radio"><span
											class="icon icon-check text-green"></span> 确定</label> <label
											class="button"><input name="pintuer" value="2"
											type="radio"><span class="icon icon-times"></span> 取消</label>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="label">
									<strong>单选</strong>
								</div>
								<div class="field">
									<div class="button-group radio">
										<label class="button active"><input name="pintuer"
											value="1" checked="checked" type="radio">起步</label> <label
											class="button"><input name="pintuer" value="2"
											type="radio">CSS</label> <label class="button"><input
											name="pintuer" value="3" type="radio">元件</label> <label
											class="button"><input name="pintuer" value="4"
											type="radio">JS组件</label> <label class="button"><input
											name="pintuer" value="5" type="radio">模块</label>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="label">
									<strong>多选</strong>
								</div>
								<div class="field">
									<div class="button-group checkbox">
										<label class="button active"><input name="pintuer"
											value="1" type="checkbox" checked="checked"><span
											class="icon icon-heart"></span> 喜欢</label> <label class="button"><input
											name="pintuer" value="2" type="checkbox"><span
											class="icon icon-star"></span> 收藏</label>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="label">
									<strong>多选</strong>
								</div>
								<div class="field">
									<div class="button-group checkbox">
										<label class="button active"><input name="pintuer"
											value="1" type="checkbox" checked="checked">起步</label> <label
											class="button"><input name="pintuer" value="2"
											type="checkbox">CSS</label> <label class="button"><input
											name="pintuer" value="3" type="checkbox">元件</label> <label
											class="button"><input name="pintuer" value="4"
											type="checkbox">JS组件</label> <label class="button"><input
											name="pintuer" value="5" type="checkbox">模块</label>
									</div>
								</div>
							</div>

						</form>
						</xmp>
					</div>
					<h4 class="doc-title">分行显示</h4>
					<div class="doc-input">给.input添加.label-block样式，可使内容一行一行显示。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post">
								<div class="form-group">
									<div class="label">
										<strong>拼图</strong>
									</div>
									<div class="field label-block">
										<label><input name="pintuer" type="checkbox">
											起步</label> <label><input name="pintuer" type="checkbox">
											CSS</label> <label><input name="pintuer" type="checkbox">
											元件</label> <label><input name="pintuer" type="checkbox">
											动画</label> <label><input name="pintuer" type="checkbox">
											js组件</label> <label><input name="pintuer" type="checkbox">
											模块</label>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<strong>拼图</strong>
									</div>
									<div class="field label-block">
										<label><input name="pintuer" type="radio"> 起步</label>
										<label><input name="pintuer" type="radio"> CSS</label>
										<label><input name="pintuer" type="radio"> 元件</label>
										<label><input name="pintuer" type="radio"> 动画</label>
										<label><input name="pintuer" type="radio">
											js组件</label> <label><input name="pintuer" type="radio">
											模块</label>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="label">
									<strong>拼图</strong>
								</div>
								<div class="field label-block">
									<label><input name="pintuer" type="checkbox">...</label>
									...
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<strong>拼图</strong>
								</div>
								<div class="field label-block">
									<label><input name="pintuer" type="radio">...</label>
									...
								</div>
							</div>
						</form>
						</xmp>
					</div>
					<h3 class="doc-h3" id="input-group">输入框组</h3>
					<p class="doc-readme">多个输入框组合，实现输入框前缀及后缀内容。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post">
								<div class="form-group">
									<div class="label">
										<label for="money">金额</label>
									</div>
									<div class="field">
										<div class="input-group">
											<span class="addon">¥</span><input type="text" class="input"
												id="money" name="money" size="50" placeholder="金额" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="money">金额</label>
									</div>
									<div class="field">
										<div class="input-group">
											<input type="text" class="input" id="money" name="money"
												size="50" placeholder="金额" /><span class="addon">元</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="money">金额</label>
									</div>
									<div class="field">
										<div class="input-group">
											<span class="addon icon-yen"></span><input type="text"
												class="input" id="money" name="money" size="50"
												placeholder="金额" /><span class="addon">元</span>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="label">
									<label for="money">金额</label>
								</div>
								<div class="field">
									<div class="input-group">
										<span class="addon">¥</span><input type="text" class="input"
											id="money" name="money" size="50" placeholder="金额" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="money">金额</label>
								</div>
								<div class="field">
									<div class="input-group">
										<input type="text" class="input" id="money" name="money"
											size="50" placeholder="金额" /><span class="addon">元</span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="money">金额</label>
								</div>
								<div class="field">
									<div class="input-group">
										<span class="addon icon-yen"></span><input type="text"
											class="input" id="money" name="money" size="50"
											placeholder="金额" /><span class="addon">元</span>
									</div>
								</div>
							</div>
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">单选或多选</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post">
								<div class="form-group">
									<div class="field">
										<div class="input-group">
											<span class="addon"><input name="pintuer"
												type="checkbox" /></span> <input type="text" class="input"
												id="money" name="money" size="50" placeholder="多选" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="field">
										<div class="input-group">
											<span class="addon"><input name="pintuer" type="radio" /></span>
											<input type="text" class="input" id="money" name="money"
												size="50" placeholder="单选" />
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="field">
									<div class="input-group">
										<span class="addon"><input name="pintuer"
											type="checkbox" /></span> <input type="text" class="input"
											id="money" name="money" size="50" placeholder="多选" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="field">
									<div class="input-group">
										<span class="addon"><input name="pintuer" type="radio" /></span>
										<input type="text" class="input" id="money" name="money"
											size="50" placeholder="单选" />
									</div>
								</div>
							</div>
						</form>
						</xmp>
					</div>
					<h3 class="doc-h3" id="inputs-button">按钮输入框组</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;">
								<div class="form-group">
									<div class="field">
										<div class="input-group">
											<span class="addbtn"><button type="button"
													class="button">搜:</button></span><input type="text" class="input"
												name="keywords" size="50" placeholder="关键词" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<div class="input-group">
											<input type="text" class="input" name="keywords" size="50"
												placeholder="关键词" /><span class="addbtn"><button
													type="button" class="button">搜!</button></span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<div class="input-group">
											<span class="addbtn"><button type="button"
													class="button icon-search"></button></span><input type="text"
												class="input" name="keywords" size="50" placeholder="关键词" /><span
												class="addbtn"><button type="button" class="button">搜索</button></span>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="field">
									<div class="input-group">
										<span class="addbtn"><button type="button"
												class="button">搜:</button></span><input type="text" class="input"
											name="keywords" size="50" placeholder="关键词" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="field">
									<div class="input-group">
										<input type="text" class="input" name="keywords" size="50"
											placeholder="关键词" /><span class="addbtn"><button
												type="button" class="button">搜!</button></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="field">
									<div class="input-group">
										<span class="addbtn"><button type="button"
												class="button icon-search"></button></span><input type="text"
											class="input" name="keywords" size="50" placeholder="关键词" /><span
											class="addbtn"><button type="button" class="button">搜索</button></span>
									</div>
								</div>
							</div>
						</form>
						</xmp>
					</div>
					<h4 class="doc-title">下拉式按钮</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;">
								<div class="form-group">
									<div class="field">
										<div class="input-group">
											<div class="addbtn">

												<div class="button-group">
													<button type="button" class="button dropdown-toggle">
														起步 <span class="downward"></span>
													</button>
													<ul class="drop-menu">
														<li><a href="#">动画</a></li>
														<li><a href="#">模块</a></li>
													</ul>
												</div>
											</div>
											<input type="text" class="input" name="keywords" size="50"
												placeholder="关键词" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<div class="input-group">
											<input type="text" class="input" name="keywords" size="50"
												placeholder="关键词" />
											<div class="addbtn">

												<div class="button-group">
													<button type="button" class="button dropdown-toggle">
														起步 <span class="downward"></span>
													</button>
													<ul class="drop-menu pull-right">
														<li><a href="#">动画</a></li>
														<li><a href="#">模块</a></li>
													</ul>
												</div>

											</div>

										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<div class="input-group">
											<div class="addbtn">

												<div class="button-group">
													<button type="button" class="button dropdown-toggle">
														起步 <span class="downward"></span>
													</button>
													<ul class="drop-menu">
														<li><a href="#">动画</a></li>
														<li><a href="#">模块</a></li>
													</ul>
												</div>

											</div>
											<input type="text" class="input" name="keywords" size="50"
												placeholder="关键词" />
											<div class="addbtn">

												<div class="button-group">
													<button type="button" class="button dropdown-toggle">
														起步 <span class="downward"></span>
													</button>
													<ul class="drop-menu pull-right">
														<li><a href="#">动画</a></li>
														<li><a href="#">模块</a></li>
													</ul>
												</div>

											</div>

										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="field">
									<div class="input-group">
										<div class="addbtn">

											<div class="button-group">
												<button type="button" class="button dropdown-toggle">
													起步 <span class="downward"></span>
												</button>
												<ul class="drop-menu">
													<li><a href="#">动画</a></li>
													<li><a href="#">模块</a></li>
												</ul>
											</div>

										</div>
										<input type="text" class="input" name="keywords" size="50"
											placeholder="关键词" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="field">
									<div class="input-group">
										<input type="text" class="input" name="keywords" size="50"
											placeholder="关键词" />
										<div class="addbtn">

											<div class="button-group">
												<button type="button" class="button dropdown-toggle">
													起步 <span class="downward"></span>
												</button>
												<ul class="drop-menu pull-right">
													<li><a href="#">动画</a></li>
													<li><a href="#">模块</a></li>
												</ul>
											</div>

										</div>

									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="field">
									<div class="input-group">
										<div class="addbtn">

											<div class="button-group">
												<button type="button" class="button dropdown-toggle">
													起步 <span class="downward"></span>
												</button>
												<ul class="drop-menu">
													<li><a href="#">动画</a></li>
													<li><a href="#">模块</a></li>
												</ul>
											</div>

										</div>
										<input type="text" class="input" name="keywords" size="50"
											placeholder="关键词" />
										<div class="addbtn">

											<div class="button-group">
												<button type="button" class="button dropdown-toggle">
													起步 <span class="downward"></span>
												</button>
												<ul class="drop-menu pull-right">
													<li><a href="#">动画</a></li>
													<li><a href="#">模块</a></li>
												</ul>
											</div>

										</div>

									</div>
								</div>
							</div>
						</form>
						</xmp>
					</div>
					<h3 class="doc-h3" id="inputs-cases">组合案例</h3>
					<p class="doc-readme">经常用到的输入框组合案例。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<label for="username">姓名</label>
									</div>
									<div class="field">
										<input type="text" class="input" id="username" name="username"
											size="50" placeholder="你的真实姓名" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="password">称呼</label>
									</div>
									<div class="field">
										<div class="button-group radio">
											<label class="button active"><input name="gender"
												value="sir" checked="checked" type="radio"><span
												class="icon icon-male"></span> 先生</label> <label class="button"><input
												name="gender" value="miss" type="radio"><span
												class="icon icon-female"></span> 女士</label> <label class="button"><input
												name="gender" value="child" type="radio"><span
												class="icon icon-child"></span> 小朋友</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="income">年收入</label>
									</div>
									<div class="field">
										<div class="input-group">
											<span class="addon">¥</span><input class="input" type="text"
												id="money" name="money" size="50" placeholder="金额" /><span
												class="addon">元</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="favor">兴趣</label>
									</div>
									<div class="field">
										<div class="button-group checkbox">
											<label class="button"><input name="favor" value="旅游"
												type="checkbox"><span class="icon-plane"></span> 旅游</label>
											<label class="button"><input name="favor" value="美食"
												type="checkbox"><span class="icon-glass"></span> 美食</label>
											<label class="button"><input name="favor" value="时尚"
												type="checkbox"><span class="icon-image"></span> 摄影</label>
											<label class="button"><input name="favor" value="游戏"
												type="checkbox"><span class="icon-gamepad"></span>
												游戏</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="face">头像</label>
									</div>
									<div class="field">
										<a class="button input-file" href="javascript:void(0);">+
											浏览文件<input size="100" type="file" />
										</a>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="age">年龄阶段</label>
									</div>
									<div class="field">
										<select class="input" name="age">
											<option>0-18岁</option>
											<option>18-30岁</option>
											<option>30-50岁</option>
											<option>50岁以上</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="readme">简介</label>
									</div>
									<div class="field">
										<textarea class="input" rows="5" cols="50"
											placeholder="介绍一下你自己"></textarea>
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post">
							<div class="form-group">
								<div class="label">
									<label for="username">姓名</label>
								</div>
								<div class="field">
									<input type="text" class="input" id="username" name="username"
										size="50" placeholder="你的真实姓名" />
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="password">称呼</label>
								</div>
								<div class="field">
									<div class="button-group radio">
										<label class="button active"><input name="gender"
											value="sir" checked="checked" type="radio"><span
											class="icon icon-male"></span> 先生</label> <label class="button"><input
											name="gender" value="miss" type="radio"><span
											class="icon icon-female"></span> 女士</label> <label class="button"><input
											name="gender" value="child" type="radio"><span
											class="icon icon-child"></span> 小朋友</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="income">年收入</label>
								</div>
								<div class="field">
									<div class="input-group">
										<span class="addon">¥</span><input class="input" type="text"
											id="money" name="money" size="50" placeholder="金额" /><span
											class="addon">元</span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="favor">兴趣</label>
								</div>
								<div class="field">
									<div class="button-group checkbox">
										<label class="button"><input name="favor" value="旅游"
											type="checkbox"><span class="icon-plane"></span> 旅游</label> <label
											class="button"><input name="favor" value="美食"
											type="checkbox"><span class="icon-glass"></span> 美食</label> <label
											class="button"><input name="favor" value="时尚"
											type="checkbox"><span class="icon-image"></span> 摄影</label> <label
											class="button"><input name="favor" value="游戏"
											type="checkbox"><span class="icon-gamepad"></span> 游戏</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="face">头像</label>
								</div>
								<div class="field">
									<a class="button input-file" href="javascript:void(0);">+
										浏览文件<input size="100" type="file" />
									</a>
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="age">年龄阶段</label>
								</div>
								<div class="field">
									<select class="input" name="age">
										<option>0-18岁</option>
										<option>18-30岁</option>
										<option>30-50岁</option>
										<option>50岁以上</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="readme">简介</label>
								</div>
								<div class="field">
									<textarea class="input" rows="5" cols="50"
										placeholder="介绍一下你自己"></textarea>
								</div>
							</div>
							<div class="form-button">
								<button class="button" type="submit">登录</button>
							</div>
						</form>
						</xmp>
					</div>
					<h3 class="doc-h3" id="inputs-size">尺寸</h3>
					<p class="doc-readme">
					<ul>
						<li>让单个元素大小，使用上一节介绍的.input-big和.input-small样式；</li>
						<li>单个按钮组使用.button-group-big或.button-group-small样式；</li>
						<li>单个输入框组，给.input-group添加.input-big或.input-small样式；</li>
						<li>改变整体表单的大小，给form添加.form-big或.form-small样式。</li>
					</ul>
					</p>
					<h4 class="doc-title">大号</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" class="form-big" onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<label for="username">姓名</label>
									</div>
									<div class="field">
										<input type="text" class="input" id="username" name="username"
											size="50" placeholder="你的真实姓名" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="income">年收入</label>
									</div>
									<div class="field">
										<div class="input-group">
											<span class="addon">¥</span><input type="text" class="input"
												id="money" name="money" size="50" placeholder="金额" /><span
												class="addon">元</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>称呼</label>
									</div>
									<div class="field">
										<div class="button-group radio">
											<label class="button active"><input name="gender"
												value="sir" checked="checked" type="radio">先生</label> <label
												class="button"><input name="gender" value="miss"
												type="radio">女士</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="age">年龄阶段</label>
									</div>
									<div class="field">
										<select class="input" name="age">
											<option>0-18岁</option>
											<option>18-30岁</option>
											<option>30-50岁</option>
											<option>50岁以上</option>
										</select>
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post" class="form-big">....</form>
						</xmp>
					</div>
					<h4 class="doc-title">小号</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<form method="post" class="form-small" onsubmit="return false;">
								<div class="form-group">
									<div class="label">
										<label for="username">姓名</label>
									</div>
									<div class="field">
										<input type="text" class="input" id="username" name="username"
											size="50" placeholder="你的真实姓名" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="income">年收入</label>
									</div>
									<div class="field">
										<div class="input-group">
											<span class="addon">¥</span><input type="text" class="input"
												id="money" name="money" size="50" placeholder="金额" /><span
												class="addon">元</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>称呼</label>
									</div>
									<div class="field">
										<div class="button-group radio">
											<label class="button active"><input name="gender"
												value="sir" checked="checked" type="radio">先生</label> <label
												class="button"><input name="gender" value="miss"
												type="radio">女士</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label for="age">年龄阶段</label>
									</div>
									<div class="field">
										<select class="input" name="age">
											<option>0-18岁</option>
											<option>18-30岁</option>
											<option>30-50岁</option>
											<option>50岁以上</option>
										</select>
									</div>
								</div>
								<div class="form-button">
									<button class="button" type="submit">登录</button>
								</div>
							</form>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<form method="post" class="form-small">...</form>
						</xmp>
					</div>
					<blockquote class="quote border-red doc-quotered">
						<strong>表单验证</strong>
						在javascrip组件里，我们还将进一步介绍表单验证状态、验证方法、验证规则等内容，进一步丰富了表单的操作。
					</blockquote>
					<br />
					<br />
					<h2 class="doc-h2" id="listgroup">列表组</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="list-style">列表样式</h3>
					<p class="doc-readme">常用于文章信息的列表显示，同时也可以组合成复杂的定制化内容。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<ul class="list-group">
								<li>拼图前端框架，是一款开源的专业网页前端UI解决方案。</li>
								<li>是HTML、CSS、Javascrip三者结合的前端框架。</li>
								<li>配合js效果，提供了拼图的CSS、HTML标准。</li>
								<li>方便个性化、人性化的前端设计方法。</li>
								<li>受到设计师、前端工程师、程序员及网页设计初学者的喜爱。</li>
								<li>拼图框架提供了CSS的重定义、元件样式的预设。</li>
								<li>拼图框架提供了CSS的重定义、元件样式的预设、样式组件、风格模块及Javascript效果。</li>
								<li>丰富了页面效果，同时让前端设计简单化、傻瓜化。</li>
								<li>任何初学者都可快速建设美观、简洁的页面。</li>
							</ul>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<ul class="list-group">
							<li>...</li>
						</ul>
						</xmp>
					</div>
					<h4 class="doc-title">条纹列表</h4>
					<div class="doc-input">添加.list-striped样式，列表组条纹状显示。</div>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<ul class="list-group list-striped">
								<li>拼图前端框架，是一款开源的专业网页前端UI解决方案。</li>
								<li>是HTML、CSS、Javascrip三者结合的前端框架。</li>
								<li>配合js效果，提供了拼图的CSS、HTML标准。</li>
								<li>方便个性化、人性化的前端设计方法。</li>
								<li>受到设计师、前端工程师、程序员及网页设计初学者的喜爱。</li>
								<li>拼图框架提供了CSS的重定义、元件样式的预设。</li>
								<li>拼图框架提供了CSS的重定义、元件样式的预设、样式组件、风格模块及Javascript效果。</li>
								<li>丰富了页面效果，同时让前端设计简单化、傻瓜化。</li>
								<li>任何初学者都可快速建设美观、简洁的页面。</li>
							</ul>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<ul class="list-group list-striped">
							<li>...</li>
						</ul>
						</xmp>
					</div>
					<h3 class="doc-h3" id="list-span">标签、徽章或日期</h3>
					<p class="doc-readme">加入徽章或日期，使用float-right样式，自动放在右边。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<ul class="list-group">
								<li><span class="float-right badge">20</span>拼图前端框架，是一款开源的专业网页前端UI解决方案。</li>
								<li><span class="float-right">2010-10-1</span>是HTML、CSS、Javascrip三者结合的前端框架。</li>
								<li><span class="float-right tag">热门</span>配合js效果，提供了拼图的CSS、HTML标准。</li>
							</ul>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<ul class="list-group">
							<li><span class="float-right badge">...</span>...</li>
							<li><span class="float-right">...</span>...</li>
							<li><span class="float-right tag">...</span>...</li>
						</ul>
						</xmp>
					</div>
					<h3 class="doc-h3" id="list-link">链接列表</h3>
					<p class="doc-readme">使用链接组成的列表内容。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="list-link">
								<a href="#">拼图前端框架，是一款开源的专业网页前端UI解决方案。</a> <a href="#"
									class="active"><span class="float-right badge bg-main">99+</span>是HTML、CSS、Javascrip三者结合的前端框架。</a>
								<a href="#">配合js效果，提供了拼图的CSS、HTML标准。</a> <a href="#">方便个性化、人性化的前端设计方法。</a>
								<a href="#">受到设计师、前端工程师、程序员及网页设计初学者的喜爱。</a> <a href="#">拼图框架提供了CSS的重定义、元件样式的预设。</a>
								<a href="#">拼图框架提供了CSS的重定义、元件样式的预设、样式组件、风格模块及Javascript效果。</a> <a
									href="#">丰富了页面效果，同时让前端设计简单化、傻瓜化。</a> <a href="#">任何初学者都可快速建设美观、简洁的页面。</a>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="list-link">
							<a href="#">...</a> <a href="#" class="active"><span
								class="float-right badge bg-main">...</span>...</a>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="list-detail">内容组合</h3>
					<p class="doc-readme">在链接内添加需要的代码，组合成想要的效果。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="list-link">
								<a href="#"><h4>拼图前端框架</h4>拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。
								</a> <a href="#" class="active">

									<div class="media media-x">
										<img src="/images/64.png" class="img-rounded float-left"
											alt="...">
										<div class="media-body">
											<strong>媒体标题</strong>
											拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩游戏一样快速简单而富有乐趣的做前端开发。
										</div>
									</div>

								</a> <a href="#">

									<div class="progress progress-striped active">
										<div class="progress-bar bg-yellow" style="width: 80%;">进度：80%</div>
									</div>

								</a> <a href="#">

									<div class="txt txt-small radius-small bg-red">1</div>
									<div class="txt txt-small radius bg-yellow">2</div>
									<div class="txt-border txt-small radius-big border-blue">
										<div class="txt radius-big bg-blue">3</div>
									</div>

									<div class="txt-border txt-small radius-circle border-green">
										<div class="txt radius-circle bg-green">4</div>
									</div>

								</a> <a href="#">

									<ul class="list-group">
										<li><span class="float-right badge">20</span>拼图前端框架，是一款开源的专业网页前端UI解决方案。</li>
										<li><span class="float-right">2010-10-1</span>是HTML、CSS、Javascrip三者结合的前端框架。</li>
										<li><span class="float-right tag">热门</span>配合js效果，提供了拼图的CSS、HTML标准。</li>
									</ul>

								</a>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="list-link">
							<a href="#">....</a> <a href="#" class="active">
								<div class="media media-x">...</div>
							</a> <a href="#">
								<div class="progress progress-striped active">...</div>
							</a> <a href="#">
								<div class="txt txt-small radius-small bg-red">1</div> ...
							</a> <a href="#">
								<ul class="list-group">...
								</ul>
							</a>
						</div>
						</xmp>
					</div>
					<br />
					<br />
					<h2 class="doc-h2" id="panel">面板</h2>
					<p class="doc-lead"></p>
					<h3 class="doc-h3" id="panel-style">基本样式</h3>
					<p class="doc-readme"></p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="panel">
								<div class="panel-body">面板</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="panel">
							<div class="panel-body">面板</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="panel-detail">含标题或底部的面板</h3>
					<p class="doc-readme">面板可加入含.panel-head或.panel-foot的容器，增加头部或底部信息。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="panel">
								<div class="panel-head">
									<h4>拼图前端框架</h4>
								</div>
								<div class="panel-body">拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。
								</div>
							</div>
							<br />
							<div class="panel">
								<div class="panel-body">拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。
								</div>
								<div class="panel-foot">网址：http://www.pintuer.com</div>
							</div>
							<br />
							<div class="panel">
								<div class="panel-head">
									<strong>拼图前端框架</strong>
								</div>
								<div class="panel-body">拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。
								</div>
								<div class="panel-foot">网址：http://www.pintuer.com</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="panel">
							<div class="panel-head">...</div>
							<div class="panel-body">...</div>
						</div>

						<div class="panel">
							<div class="panel-body">...</div>
							<div class="panel-foot">...</div>
						</div>

						<div class="panel">
							<div class="panel-head">...</div>
							<div class="panel-body">...</div>
							<div class="panel-foot">...</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="panel-color">变换颜色</h3>
					<p class="doc-readme">巧妙使用背景色.bg-*和边框色.border-*样式，可以灵活改变面板的色彩。</p>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="panel border-main">
								<div class="panel-body">主色</div>
							</div>
							<br />
							<div class="panel border-sub">
								<div class="panel-head  border-sub bg-sub">
									<strong>辅色标题</strong>
								</div>
								<div class="panel-body">面板内容</div>
							</div>
							<br />
							<div class="panel border-mix">
								<div class="panel-body">面板内容</div>
								<div class="panel-foot border-mix bg-back">融合色底部</div>
							</div>

							<br />
							<div class="panel border-red-light">
								<div class="panel-head  border-red-light bg-red-light">
									<strong>标题</strong>
								</div>
								<div class="panel-body">内容</div>
								<div class="panel-foot border-red-light bg-red-light">底部</div>
							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="panel border-main">
							<div class="panel-body">主色</div>
						</div>

						<div class="panel border-sub">
							<div class="panel-head  border-sub bg-sub">
								<strong>辅色标题</strong>
							</div>
							<div class="panel-body">面板内容</div>
						</div>

						<div class="panel border-mix">
							<div class="panel-body">面板内容</div>
							<div class="panel-foot border-mix bg-back">融合色底部</div>
						</div>

						<div class="panel border-red-light">
							<div class="panel-head  border-red-light bg-red-light">
								<strong>标题</strong>
							</div>
							<div class="panel-body">内容</div>
							<div class="panel-foot border-red-light bg-red-light">底部</div>
						</div>
						</xmp>
					</div>
					<h3 class="doc-h3" id="panel-content">面板内容</h3>
					<p class="doc-readme">含表格及含列表组的面板。</p>
					<h4 class="doc-title">带表格的面板</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="panel">
								<div class="panel-head">
									<strong>面板表格</strong>
								</div>
								<div class="panel-body">拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。</div>

								<div class="table-responsive">
									<table class="table">
										<tr>
											<th>起步</th>
											<th>CSS</th>
											<th>元件</th>
											<th>模块</th>
										</tr>
										<tr>
											<td>下载前端框架</td>
											<td>文本</td>
											<td>网格系统</td>
											<td>框架</td>
										</tr>
										<tr>
											<td>框架包含的文件</td>
											<td>图片</td>
											<td>图标</td>
											<td>头部</td>
										</tr>
										<tr>
											<td>基本页面</td>
											<td>水平线</td>
											<td>标签</td>
											<td>Banner</td>
										</tr>
										<tr>
											<td>响应式布局</td>
											<td>按钮</td>
											<td>徽章</td>
											<td>导航</td>
										</tr>
										<tr>
											<td>浏览器支持</td>
											<td>列表</td>
											<td>进度条</td>
											<td>面包屑</td>
										</tr>
									</table>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="panel">
							<div class="panel-head">
								<strong>面板表格</strong>
							</div>
							<div class="panel-body">...</div>
							<table class="table">...
							</table>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">不含panel-body的</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="panel">
								<div class="panel-head">
									<strong>面板表格</strong>
								</div>

								<div class="table-responsive">
									<table class="table">
										<tr>
											<th>起步</th>
											<th>CSS</th>
											<th>元件</th>
											<th>模块</th>
										</tr>
										<tr>
											<td>下载前端框架</td>
											<td>文本</td>
											<td>网格系统</td>
											<td>框架</td>
										</tr>
										<tr>
											<td>框架包含的文件</td>
											<td>图片</td>
											<td>图标</td>
											<td>头部</td>
										</tr>
										<tr>
											<td>基本页面</td>
											<td>水平线</td>
											<td>标签</td>
											<td>Banner</td>
										</tr>
										<tr>
											<td>响应式布局</td>
											<td>按钮</td>
											<td>徽章</td>
											<td>导航</td>
										</tr>
										<tr>
											<td>浏览器支持</td>
											<td>列表</td>
											<td>进度条</td>
											<td>面包屑</td>
										</tr>
									</table>
								</div>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="panel">
							<div class="panel-head">
								<strong>面板表格</strong>
							</div>
							<table class="table">...
							</table>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">带列表组的面板</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="panel">
								<div class="panel-head">
									<strong>面板列表</strong>
								</div>
								<div class="panel-body">拼图，是国内一款开源的专业响应式网页前端框架，由HTML、CSS、Javascrip三者组合应用。提供的CSS、元件、动画、组件、模块等样式实现绝大多数的网页特效与响应功能，像玩积木、拼图游戏一样快速简单而富有乐趣的做前端开发。</div>

								<ul class="list-group">
									<li>拼图前端框架，是一款开源的专业网页前端UI解决方案。</li>
									<li>是HTML、CSS、Javascrip三者结合的前端框架。</li>
									<li>配合js效果，提供了拼图的CSS、HTML标准。</li>
									<li>方便个性化、人性化的前端设计方法。</li>
									<li>受到设计师、前端工程师、程序员及网页设计初学者的喜爱。</li>
									<li>拼图框架提供了CSS的重定义、元件样式的预设。</li>
									<li>拼图框架提供了CSS的重定义、元件样式的预设、样式组件、风格模块及Javascript效果。</li>
									<li>丰富了页面效果，同时让前端设计简单化、傻瓜化。</li>
									<li>任何初学者都可快速建设美观、简洁的页面。</li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="panel">
							<div class="panel-head">
								<strong>面板列表</strong>
							</div>
							<div class="panel-body">...</div>
							<ul class="list-group">...
							</ul>
						</div>
						</xmp>
					</div>
					<h4 class="doc-title">不含panel-body的</h4>
					<div class="doc-demoview doc-viewad0 ">
						<div class="view-body">
							<div class="panel">
								<div class="panel-head">
									<strong>面板列表</strong>
								</div>

								<ul class="list-group">
									<li>拼图前端框架，是一款开源的专业网页前端UI解决方案。</li>
									<li>是HTML、CSS、Javascrip三者结合的前端框架。</li>
									<li>配合js效果，提供了拼图的CSS、HTML标准。</li>
									<li>方便个性化、人性化的前端设计方法。</li>
									<li>受到设计师、前端工程师、程序员及网页设计初学者的喜爱。</li>
									<li>拼图框架提供了CSS的重定义、元件样式的预设。</li>
									<li>拼图框架提供了CSS的重定义、元件样式的预设、样式组件、风格模块及Javascript效果。</li>
									<li>丰富了页面效果，同时让前端设计简单化、傻瓜化。</li>
									<li>任何初学者都可快速建设美观、简洁的页面。</li>
								</ul>

							</div>
						</div>
					</div>
					<div class="doc-democode doc-codead0 ">
						<xmp>
						<div class="panel">
							<div class="panel-head">
								<strong>面板列表</strong>
							</div>
							<ul class="list-group">...
							</ul>
						</div>
						</xmp>
					</div>
					<br />
					<br />
				</div>
				<!--list.end-->
			</div>

			<div class="hidden-l hidden-s xm3 xb3">
				<div class="sidebar doc-sidebar fadein-left">
					<ul class="sidenav nav spy fixed" data-offset-fixed="320"
						data-offset-spy="160">
						<li><a href="#overview">概述</a>
							<ul>
							</ul></li>
						<li><a href="#gridsystem">网格系统</a>
							<ul>
								<li><a href="#grad-intro">简介</a></li>
								<li><a href="#grid-default">常规布局</a></li>
								<li><a href="#grid-responsive">跨屏响应式布局</a></li>
								<li><a href="#grid-demo">综合实例</a></li>
							</ul></li>
						<li><a href="#icon">图标</a>
							<ul>
								<li><a href="#icon-small">CSS小图标</a></li>
								<li><a href="#icons">字体图标</a></li>
								<li><a href="#icon-photoshop">在Photoshop中使用图标</a></li>
							</ul></li>
						<li><a href="#tags">标签</a>
							<ul>
								<li><a href="#tag-style">标签样式</a></li>
								<li><a href="#tag-colors">标签颜色</a></li>
							</ul></li>
						<li><a href="#badge">徽章</a>
							<ul>
								<li><a href="#badge-style">提示徽章</a></li>
								<li><a href="#badge-show">导航或背景上显示</a></li>
								<li><a href="#badge-corner">角标</a></li>
							</ul></li>
						<li><a href="#dropmenu">下拉菜单</a>
							<ul>
								<li><a href="#drop-style">下拉样式</a></li>
								<li><a href="#drop-head">菜单标题及禁用链接</a></li>
							</ul></li>
						<li><a href="#nav">导航</a>
							<ul>
								<li><a href="#nav-default">默认导航</a></li>
								<li><a href="#nav-main">主要导航</a></li>
								<li><a href="#nav-sub">辅助导航</a></li>
								<li><a href="#nav-tabs">标签导航</a></li>
								<li><a href="#nav-pills">胶囊导航</a></li>
								<li><a href="#nav-sitemap">站点导航</a></li>
								<li><a href="#nav-bg">背景反色导航</a></li>
							</ul></li>
						<li><a href="#progress">进度条</a>
							<ul>
								<li><a href="#progress-style">默认进度条样式</a></li>
								<li><a href="#progress-color">进度条颜色</a></li>
								<li><a href="#progress-effect">进度条效果</a></li>
							</ul></li>
						<li><a href="#range">区间</a>
							<ul>
								<li><a href="#range-scroll">区间选值</a></li>
								<li><a href="#range-select">区间范围</a></li>
								<li><a href="#range-color">按钮及区间颜色</a></li>
							</ul></li>
						<li><a href="#btngroup">按钮组</a>
							<ul>
								<li><a href="#button-group">基本样式</a></li>
								<li><a href="#button-group-tools">按钮工具栏</a></li>
								<li><a href="#buttongroup-size">尺寸</a></li>
								<li><a href="#buttongroup-nested">嵌套</a></li>
								<li><a href="#button-group-y">纵向显示</a></li>
								<li><a href="#button-group-justified">两端对齐的链接按钮组</a></li>
								<li><a href="#btngroup-color">颜色</a></li>
							</ul></li>
						<li><a href="#dropbutton">下拉式按钮</a>
							<ul>
								<li><a href="#dropbutton-one">单下拉式菜单按钮</a></li>
								<li><a href="#dropbutton-split">分裂式按钮下拉菜单</a></li>
								<li><a href="#dropbutton-size">尺寸</a></li>
								<li><a href="#dropbutton-up">向上弹出式菜单</a></li>
							</ul></li>
						<li><a href="#selected">选择</a>
							<ul>
								<li><a href="#selected-style">选中样式</a></li>
								<li><a href="#selected-checked">按钮式选中</a></li>
							</ul></li>
						<li><a href="#textbg">文字色块</a>
							<ul>
								<li><a href="#txtcolor-style">基本样式</a></li>
								<li><a href="#txt-bgborder">背景和边框色</a></li>
								<li><a href="#txt-size">尺寸</a></li>
							</ul></li>
						<li><a href="#media">媒体组</a>
							<ul>
								<li><a href="#midea-style">媒体样式</a></li>
								<li><a href="#media-inline">列表显示</a></li>
								<li><a href="#media-nested">嵌套排列</a></li>
							</ul></li>
						<li><a href="#formgroup">表单组</a>
							<ul>
								<li><a href="#inputs-style">基本样式</a></li>
								<li><a href="#inputs-x">水平方向显示</a></li>
								<li><a href="#inputs-inline">内联排列</a></li>
								<li><a href="#radiocheck">单选多选组合</a></li>
								<li><a href="#input-group">输入框组</a></li>
								<li><a href="#inputs-button">按钮输入框组</a></li>
								<li><a href="#inputs-cases">组合案例</a></li>
								<li><a href="#inputs-size">尺寸</a></li>
							</ul></li>
						<li><a href="#listgroup">列表组</a>
							<ul>
								<li><a href="#list-style">列表样式</a></li>
								<li><a href="#list-span">标签、徽章或日期</a></li>
								<li><a href="#list-link">链接列表</a></li>
								<li><a href="#list-detail">内容组合</a></li>
							</ul></li>
						<li><a href="#panel">面板</a>
							<ul>
								<li><a href="#panel-style">基本样式</a></li>
								<li><a href="#panel-detail">含标题或底部的面板</a></li>
								<li><a href="#panel-color">变换颜色</a></li>
								<li><a href="#panel-content">面板内容</a></li>
							</ul></li>
					</ul>
				</div>
			</div>

		</div>
	</div>
	<div class="container doc-footer">
		版权所有 &copy; <a href="http://www.pintuer.com">Pintuer.com</a> All
		Rights Reserved.
	</div>
	<div class="doc-backtop win-backtop icon-arrow-circle-up"></div>
	<script type="text/javascript">
		$('.doc-animation').click(function() {
			var e = $(this);
			var style = e.attr("data-style");
			e.addClass(style);
			setTimeout(function() {
				e.removeClass(style)
			}, 1800);
		});
	</script>
	<div class="hidden">
		<script src="http://s4.cnzz.com/stat.php?id=5952475&web_id=5952475"
			language="JavaScript"></script>
	</div>
</body>
</html>