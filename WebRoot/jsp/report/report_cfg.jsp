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
<script type="text/javascript">

function checkForm(){
	var flag = true;
	var msg = '';
	
	//饼图不能选择分组序列
	if($("input[name='chartType']:checked").val()=='pie' && $('#seriesId').val()!=''){
		msg+=' 选择饼图后不能再设置"分组系列"\n';
		$('#seriesId').focus();
		flag = false;
	}
	
	//维度与系列不能相同
	if($('#dimensionId').val()!='' && ($('#dimensionId').val()==$('#seriesId').val())){
		msg+='维度与分组序列不能相同!\n';
		$('#seriesId').focus();
		flag = false;
	}
	
	var summaryType = $('input[name="summary.summaryType"]:checked').val();
	var topVal = $('#topVal').val();
	if(summaryType=='top_n' && topVal==''){
		msg+='概述类型是前几时，前几栏不能为空!\n';
		$('#topVal').focus();
		flag = false;
		
	}
	
	
	if(msg!=''){
		alert(msg);
	}
	return flag;
}


function submitFn(){
	if(checkForm()==true){
		alert('form submit')
		$('#reportForm').submit();
	}
}


$(function(){
	
	/* 级联数据源与维度指标序列的联动选择 begin */
	$('#dscId').bind('change',function(){
		$.getJSON(
			'<%=path%>/dimensionIndexInfo!findDiiByDscId.action'
			,{'dii.dscId':$('#dscId').val()}
			,function(data, textStatus, jqXHR){
				/* result.put("dimensions", dimensions);
				result.put("indexs", indexs); */
				
				if(data.status==true){
					$('#dimensionId').empty();
					$.each(data.dimensions,function(index,item){
						$('#dimensionId').append("<option value='"+item.diiId+"'>"+item.fieldBusName+"</option>");
					});
					
					$('#indexId').empty();
					$.each(data.indexs,function(index,item){
						$('#indexId').append("<option value='"+item.diiId+"'>"+item.fieldBusName+"</option>");
					});
					
					$('#seriesId').empty();
					//序列可以不选，设置默认空值
					$('#seriesId').append("<option value=''>请选择</option>");
					//序列与维度下拉内容一致
					$.each(data.dimensions,function(index,item){
						$('#seriesId').append("<option value='"+item.diiId+"'>"+item.fieldBusName+"</option>");
					});
					
				}else{
					alert(data.info);
				}
			}
		);
	});
	/* 级联数据源与维度指标序列的联动选择 end */
	
	$('#layoutCenter').bind('click',function(){
		$('#chartRenderSeq').empty();
		$('#chartRenderSeq').append("<option value='0'>居中</option>");
	});
	
	$('#layoutLeftRight').bind('click',function(){
		$('#chartRenderSeq').empty();
		$('#chartRenderSeq').append("<option value='11'>左边</option>");
		$('#chartRenderSeq').append("<option value='12'>右边</option>");
	});
	
	
	$('#layoutUpDown').bind('click',function(){
		$('#chartRenderSeq').empty();
		$('#chartRenderSeq').append("<option value='21'>上边</option>");
		$('#chartRenderSeq').append("<option value='22'>下边</option>");
	});
	
	$('input [name="summary.summaryType"]').bind('change',function(){
		if($(this).val()=='top_n'){
			$('#topVal').removeAttr('disabled');			
		}else{
			$('#topVal').attr('disabled','disabled');
		}
	});
	
});





</script>
<body>
<div class="lefter">
    <div class="logo"><a href="<%=path %>" target="_self"><img src="images/logo.png" alt="后台管理系统" /></a></div>
</div>

<jsp:include page="${path}/common/navigation_bar.jsp" flush="true" />	


<div class="admin">
    
    <form id="reportForm" method="post" class="form-inline" action="<%=path%>/report!submitReportCfg.action" onsubmit="return checkForm();">
		<input type="hidden" name="report.riId" value="${report.riId}" />
		<fieldset>
		    <legend><h2 class="doc-h2" id="catalog_config_report">报告配置</h2></legend>
	  		<div class="form-group">
				<div class="label">
					<label>报告名称</label>
				</div>
				<div class="field">
					<input type="text" class="input" id="reportName" readonly="readonly" size="32" placeholder="文字" value="${report.reportName }"/>
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>报告版本号</label>
				</div>
				<div class="field">
					<input type="text" class="input" id="reportVersion" readonly="readonly" size="32" placeholder="文字" value="${report.reportVersion }"/>
				</div>
			</div>
		</fieldset>

		<fieldset>
		    <legend>布局配置</legend>
	  		<div class="form-group">
				<div class="label">
					<label>布局标题</label>
				</div>
				<div class="field">
					<input type="hidden" id="layout_ltcId" name="layout.ltcId" value="${layout.ltcId}" />
					<input type="hidden" name="layout.riId" value="${layout.riId}" />
					<input type="text" class="input" id="layoutTitle" name="layout.layoutTitle" data-validate="required:必填,chinese:必需是汉字"  size="32" placeholder="文字" />
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>布局渲染次序</label>
				</div>
				<div class="field">
					<input type="text" class="input" id="layoutRenderSort" name="layout.layoutRenderSort" value="0" data-validate="required:必填,plusinteger:必需是正整数" size="32" placeholder="正整数" />
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<strong>布局渲染类型</strong>
				</div>
				<div class="field">
					<div class="button-group radio">
						<label class="button active"><input id="layoutCenter" name="layout.layoutRenderType" value="center" type="radio" checked="checked">居中布局</label>
						<label class="button"><input id="layoutLeftRight" name="layout.layoutRenderType" value="left_right" type="radio">左右布局</label>
						<label class="button"><input id="layoutUpDown" name="layout.layoutRenderType" value="up_down" type="radio">上下布局</label>
					</div>
				</div>
			</div>
			<br/>
			<div class="form-group">
				<div class="label">
					<label>布局高度</label>
				</div>
				<div class="field">
					<input type="text" class="input" id="layoutHeight" name="layout.layoutHeight" value="450" data-validate="required:必填,plusinteger:必需是正整数" size="32" placeholder="正整数" />
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>&nbsp;&nbsp;&nbsp;&nbsp;布局宽度</label>
				</div>
				<div class="field">
					<input type="text" class="input" id="layoutWidth" name="layout.layoutWidth" value="1000" data-validate="required:必填,plusinteger:必需是正整数" size="32" placeholder="正整数" />
				</div>
			</div>
			
		</fieldset>
		
		<fieldset>
		    <legend>数据源配置</legend>
	  		<div class="form-group">
				<div class="label">
					<label>业务表</label>
				</div>
				<div class="field">
				    <!-- 数据源不用提交数据，只是控制下面指标与维度的选择，使用级联更新方式 -->
					<select class="input" id="dscId" data-validate="required:必填">
							<option value="">请选择</option>
						<c:forEach items="${dataSourceCfgs}" var="dsc">
							<option value="${dsc.dscId}">${dsc.tableBusName}</option>
						</c:forEach>
						<!-- <option value="1">客户分布统计表</option>
						<option value="2">渠道偏好统计表</option> -->
					</select>
				</div>
			</div>
		</fieldset>
		
		<fieldset>
		    <legend>图表配置</legend>
			<div class="form-group">	
				<div class="label">
					<label>维度</label>
				</div>
				<div class="field">
					<div class="button-group checkbox">
						<input type="hidden" name="chart.ccId" value="${chart.ccId}" /> 
						<input type="hidden" name="chart.ltcId" value="${chart.ltcId}" /> 
						<input type="hidden" name="chart.chartDomId" value="${chart.chartDomId}" /> 
						<select class="input" id="dimensionId" name="chart.dimensionId" data-validate="required:必填">
							<option value="">请选择</option>
						</select>
					</div>
				</div>
			</div>
			
			<div class="form-group">	
				<div class="label">
					<label>指标</label>
				</div>
				<div class="field">
					<div class="button-group checkbox">
						<select class="input" id="indexId" name="chart.indexId" data-validate="required:必填">
							<option value="">请选择</option>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group" >	
				<div class="label">
					<label>指标统计方式</label>
				</div>
				<div class="field">
					<div class="button-group checkbox">
						<select class="input" id="indexAggregationOpType" name="chart.aggregationOpType" data-validate="required:必填">
							<option value="sum">合计sum</option>
							<option value="count">总数count</option>
							<option value="avg">平均avg</option>
							<option value="max">最大max</option>
							<option value="min">最小min</option>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group" >	
				<div class="label">
					<label>分组系列</label>
				</div>
				<div class="field">
					<div class="button-group checkbox">
						<select class="input" id="seriesId" name="chart.seriesId">
							<option value="">请选择</option>
						</select>
					</div>
				</div>
			</div>
			
			<div class="form-group" >	
				<div class="label">
					<label>图表类型</label>
				</div>
				<div class="field">
					<div class="button-group radio">
						<label class="button active"><input id="chartType_pie" name="chart.chartType" value="pie" type="radio" checked="checked" data-validate="radio:必选图表类型">饼图</label>
						<label class="button"><input id="chartType_bar" name="chart.chartType" value="bar" type="radio" data-validate="radio:必选图表类型">柱图</label>
						<label class="button"><input id="chartType_line" name="chart.chartType" value="line" type="radio" data-validate="radio:必选图表类型">线图</label>
					</div>
				</div>
			</div>
			
			<div class="form-group" >	
				<div class="label">
					<label>图表渲染序号</label>
				</div>
				<div class="field">
					<div class="button-group checkbox">
						<select class="input" id="chartRenderSeq" name="chart.chartRenderSeq" data-validate="required:必填">
							<option value="0">居中</option>
						</select>
					</div>
				</div>
			</div>
			<br/>
			<div class="form-group">	
				<div class="label">
					<label>图表标题</label>
				</div>
				<div class="field">
					<div class="button-group checkbox">
						<input type="text" class="input" id="chartTitle" name="chart.chartTitle" value="" data-validate="required:必填,length#>=3:字符串大于3" size="32" placeholder="长度要大于3位" />
					</div>
				</div>
			</div>
			
			<div class="form-group" >	
				<div class="label">
					<label>图表高度</label>
				</div>
				<div class="field">
					<div class="button-group checkbox">
						<input type="text" class="input" id="chartHeight" name="chart.chartHeight" value="380" data-validate="required:必填,plusinteger:必需是正整数" size="32" placeholder="正整数" />
					</div>
				</div>
			</div>
			
			<div class="form-group" >	
				<div class="label">
					<label>图表宽度</label>
				</div>
				<div class="field">
					<div class="button-group checkbox">
						<input type="text" class="input" id="chartWidth" name="chart.chartWidth" value="450" data-validate="required:必填,plusinteger:必需是正整数" size="32" placeholder="正整数" />
					</div>
				</div>
			</div>
			
		</fieldset>
		
		
		<fieldset>
		    <legend>概述配置</legend>
	  		<div class="form-group">
				<div class="label">
					<label>概述描述</label>
				</div>
				<div class="field">
					<input type="hidden" name="summary.scId" value="${summary.scId}" />
					<input type="hidden" name="summary.ccId" value="${summary.ccId}" />
					<input type="text" class="input" id="reportName" name="summary.summaryTemplateDesc" data-validate="required:必填" size="32" placeholder="文字"  />
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>占位符</label>
				</div>
				<div class="field">
					<input type="text" class="input" id="placeholder" name="summary.placeholder" data-validate="required:必填,length#>2:字符长度大于2位" size="5" placeholder="" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="label">
					<label>概述类型</label>
				</div>
				<div class="field">
					<div class="button-group radio">
						<label class="button active">
							<input id="summary_type_max_min" name="summary.summaryType" value="max_min" checked="checked" type="radio" >最大与最小
						</label>
						<label class="button">
							<input id="summary_type_top_n" name="summary.summaryType" value="top_n" type="radio">TOP几
						</label>
						<label class="button">
							<input id="summary_type_change_trend" name="summary.summaryType" value="change_trend" type="radio">描述变化趋势
						</label>
					</div>
				</div>
			</div>
			<br/>
			<div class="form-group">
				<div class="label">
					<label>是否显示数字</label>
				</div>
				<div class="field">
					<div class="button-group radio">
						<label class="button">
							<input name="summary.numericed" value="true" type="radio">是
						</label>
						<label class="button active">
							<input name="summary.numericed" value="false" checked="checked" type="radio">否
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label>是否显示占比</label>
				</div>
				<div class="field">
					<div class="button-group radio">
						<label class="button">
							<input name="summary.percented" value="true" type="radio">是
						</label>
						<label class="button active">
							<input name="summary.percented" value="false"  checked="checked" type="radio">否
						</label>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="label">
					<label>前几</label>
				</div>
				<div class="field">
					<div class="button-group radio">
						<input type="text" id="topVal" name="summary.topVal" value="1" data-validate="plusinteger:必需是正整数">
					</div>
				</div>
			</div>
			
		</fieldset>
		
		
		<div class="form-button">
			<center>
				<input class="button" type="submit" value="提交" />
			</center>
		</div>
	</form>
	
	<br/>
	<h1>${reportVO.reportName}</h1>
	
	
	
	<!-- 渲染图表页面 begin -->
  
    <jsp:include page="${path}/jsp/report/charts_edit_render.jsp" flush="true" >
    	<jsp:param value="${reportVO}" name="reportVO"/>
    </jsp:include>
	
	<!-- 渲染图表页面 end -->
    
    
    <p class="text-right text-gray">基于<a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图前端框架</a>构建</p>
</div>



	<!-- 目录begin -->
	<div style="position:fixed; left:0px;top:70px;" class="sidebar doc-sidebar fadein-left">
		<!-- class="sidebar doc-sidebar fadein-left" -->
		
		<ul class="sidenav spy fixed" data-offset-fixed="320" data-offset-spy="160">
		    
			<li><a href="#catalog_config_report">报告配置</a>
				<ul>
				</ul></li>
				
	  <c:forEach items="${reportVO.layoutTemplateCfgVOs}" var="ly">
	    
	    
	    	<li><a href="#catalog_layout_${ly.ltcId}">${fn:substring(ly.layoutTitle,0,6)}</a>
				<ul>
				  <c:forEach items="${ly.chartCfgVOs}" var="c">
					<li><a href="#catalog_chart_${c.ccId}">${fn:substring(c.chartTitle,0,6)}</a></li>
				  </c:forEach>
				</ul>
			</li>
	  </c:forEach>	
			
		</ul>
	</div>
	<!-- 目录 end -->



</body>
</html>