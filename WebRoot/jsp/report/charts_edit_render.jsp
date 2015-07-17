<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>    
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>

<script type="text/javascript">
function delLayout(ltcId){
	if(ltcId){
		if(confirm('您确定要删除布局及下属图表?')==true){
			location.href = '<%=path%>/layout!deleteLayout.action?&layout.ltcId='+ltcId;
		}
	}
}

/**
 * 转到修改布局中某个位置上的图表
 */
function editChartBySeq(ltcId,chartRenderSeq){
	if(ltcId && chartRenderSeq){
		location.href = '<%=path%>/report!reportReCfgPage.action?&layout.ltcId='+ltcId+'&chart.chartRenderSeq='+chartRenderSeq;
	}else{
		alert('ltcId['+ltcId+'] | chartRenderSeq['+chartRenderSeq+']不能为空')
	}
}

function editChart(ccId){
	if(ccId){
		location.href = '<%=path%>/report!reportReCfgPage.action?&chart.ccId='+ccId;
	}
}

function delChart(ccId){
	if(ccId){
		if(confirm('您确定要删除图表?')==true){
			location.href = '<%=path%>/chart!deleteChart.action?&chart.ccId='+ccId;
		}
	}
}

</script>
<!-- 布局开始  -->
<c:forEach items="${reportVO.layoutTemplateCfgVOs}" var="layout">

<div class="container" style="margin-top:20px;padding:20px; width:${layout.layoutWidth}px; height:${layout.layoutHeight}px; border:1px solid #DDECFD; outline:2px solid #F0F5FB;overflow:auto;">
	<h2 id="catalog_layout_${layout.ltcId}"  style="padding:5px 0;border-bottom:2px solid blue;font-weight: bold;font-size: 24px;">${layout.layoutTitle}&nbsp;
	  <c:if test="${modifyPage==true}">
		布局中位置:
		<select onchange="editChartBySeq(${layout.ltcId},this.value);" style="display: inline-block;">
				<option value="">请选择</option>
			<c:choose>
			  <c:when test="${layout.layoutRenderType=='center'}">
			  	<option value="0">居中</option>
			  </c:when>
			  <c:when test="${layout.layoutRenderType=='left_right'}">
			  	<option value="11">左边</option>
			  	<option value="12">右边</option>
			  </c:when>
			  <c:when test="${layout.layoutRenderType=='up_down'}">
			  	<option value="21">上边</option>
			  	<option value="22">下边</option>
			  </c:when>
			  <c:otherwise><option value="">请选择</option> </c:otherwise>
			</c:choose>
		</select>
		<a class="first-title"  href="javascript:void(0);" onclick="delLayout(${layout.ltcId});" style="display: inline-block;text-align: left;">删除</a>
	  </c:if>
	</h2>
	
	<!-- ------------- 每个图表 begin ---------------- -->	
	<c:forEach items="${layout.chartCfgVOs}" var="chart">
	
		<c:choose>
		   <c:when test="${chart.chartRenderSeq==0}">  <!-- 居中位置 -->
		   	  <div class="center-chart" style="margin:0 auto; width:90%;">
		   		<h4 id="catalog_chart_${chart.ccId}" style="font-weight: bold;font-size: 18px;">${chart.chartTitle }&nbsp;
		   			<a href="javascript:void(0);" onclick="editChart(${chart.ccId});" class="second-title" style="display: inline-block;text-align: left;padding:15px;">修改</a>&nbsp;
		   			<a href="javascript:void(0);" onclick="delChart(${chart.ccId});" class="second-title" style="display: inline-block;text-align: left;padding:15px;">删除</a>
		   		</h4>
		   		<!-- 图表 div -->
				<div id="${chart.chartDomId}" class="center-chart" id="centerChart" style="margin:0 auto;text-align: center; width:${chart.chartWidth}px; height:${chart.chartHeight}px;  border:1px solid #DDECFD; outline:2px solid #F0F5FB;">
				</div>
				
			<c:forEach items="${chart.summaryCfgVOs}" var="summary">
				<!-- 概述 -->
				<p class="desc-center" style="font-size: 14px; color:#333;text-align: left;text-indent: 2em;font-family: Microsoft Yahei;background: #eee;line-height: 18px;padding:15px;margin:10px 0;width:100%;">
				${summary.finalSummaryStr}
				</p>
			</c:forEach>
				
			  </div>	
		   </c:when>
		   <c:when test="${chart.chartRenderSeq==11}">  <!-- 左边位置 -->
		      <div class="left-chart" style="margin-left:15px; width:48%; display: inline-block;">
				<h4 id="catalog_chart_${chart.ccId}" class="second-title" style="font-weight: bold;font-size: 18px;padding:15px;">${chart.chartTitle }&nbsp;
					<a href="javascript:void(0);" onclick="editChart(${chart.ccId});" class="second-title" style="display: inline-block;text-align: left;padding:15px;">修改</a>&nbsp;
					<a href="javascript:void(0);" onclick="delChart(${chart.ccId});" class="second-title" style="display: inline-block;text-align: left;padding:15px;">删除</a>
			    </h4>
				<!-- 图表 div -->
				<div id="${chart.chartDomId}" style="text-align: center; width:100%; height:350px;  border:1px solid #DDECFD; outline:2px solid #F0F5FB;"></div>
				
			<c:forEach items="${chart.summaryCfgVOs}" var="summary">
				<!-- 概述 -->
				<p class="desc-center" style="font-size: 14px; color:#333;text-align: left;text-indent: 2em;font-family: Microsoft Yahei;background: #eee;line-height: 18px;padding:15px;margin:10px 0;width:100%;">
				${summary.finalSummaryStr}
				</p>
			</c:forEach>
				
				
			  </div>
		   </c:when>
		   <c:when test="${chart.chartRenderSeq==12}">  <!-- 右边位置 -->
		      <div class="downright-chart" style="margin-right:15px; width:48%;float:right;"><!-- 两个图的总宽度需等于100% -->
				<h4 id="catalog_chart_${chart.ccId}" class="second-title" style="font-weight: bold;font-size: 18px;padding:8px;">${chart.chartTitle }&nbsp;
					<a href="javascript:void(0);" onclick="editChart(${chart.ccId});" class="second-title" style="display: inline-block;text-align: left;padding:15px;">修改</a>&nbsp;
					<a href="javascript:void(0);" onclick="delChart(${chart.ccId});" class="second-title" style="display: inline-block;text-align: left;padding:15px;">删除</a>
				</h4>
				<!-- 图表 div -->
				<div id="${chart.chartDomId}" style="text-align: center; width:100%; height:240px;  border:1px solid #DDECFD; outline:2px solid #F0F5FB;margin:0 15px;"></div>
			    
			<c:forEach items="${chart.summaryCfgVOs}" var="summary">
				<!-- 概述 -->
			    <p class="desc-center" style="font-size: 14px; color:#333;text-align: left;text-indent: 2em;font-family: Microsoft Yahei;background: #eee;line-height: 18px;padding:15px;margin:10px 0;width:100%;">
				${summary.finalSummaryStr}
				</p>
			</c:forEach>			    
			  </div>  
		   </c:when>
		   <c:when test="${chart.chartRenderSeq==21}">  <!-- 上边位置 -->
		      <div class="up-left-chart" style="width:100%;float:left;"><!-- 两个图的总宽度需等于100% -->
				<h4 id="catalog_chart_${chart.ccId}" class="second-title" style="font-weight: bold;font-size: 18px;padding:8px;">${chart.chartTitle }&nbsp;
					<a href="javascript:void(0);" onclick="editChart(${chart.ccId});" class="second-title" style="display: inline-block;text-align: left;padding:15px;">修改</a>&nbsp;
					<a href="javascript:void(0);" onclick="delChart(${chart.ccId});" class="second-title" style="display: inline-block;text-align: left;padding:15px;">删除</a>
				</h4>
				<!-- 图表 div -->
				<div id="${chart.chartDomId}" style="text-align: center; width:100%; height:240px;  border:1px solid #DDECFD; outline:2px solid #F0F5FB;margin:0 15px;"></div>
			   
			    
			<c:forEach items="${chart.summaryCfgVOs}" var="summary">
				 <!-- 概述 -->
			    <p style="font-size: 14px; color:#333;text-align: left;text-indent: 2em;font-family: Microsoft Yahei;background: #eee;line-height: 18px;padding:15px;margin:10px 15px;width:100%;" class="desc-center">
				${summary.finalSummaryStr}
				</p>
				
			</c:forEach>			    
			   </div>	
		   </c:when>
		   <c:when test="${chart.chartRenderSeq==22}">  <!-- 下边位置 -->
		      <div class="down-right-chart" style="width:100%;float:right;"><!-- 两个图的总宽度需等于100% -->
				<h4 id="catalog_chart_${chart.ccId}" class="second-title" style="font-weight: bold;font-size: 18px;padding:8px;">${chart.chartTitle }&nbsp;
				  <c:if test="${modifyPage==true}">
					<a href="javascript:void(0);" onclick="editChart(${chart.ccId});" class="second-title" style="display: inline-block;text-align: left;padding:15px;">修改</a>&nbsp;
					<a href="javascript:void(0);" onclick="delChart(${chart.ccId});" class="second-title" style="display: inline-block;text-align: left;padding:15px;">删除</a>
				  </c:if>	
				</h4>
				<!-- 图表 div -->
				<div id="${chart.chartDomId}" style="text-align: center; width:100%; height:240px;  border:1px solid #DDECFD; outline:2px solid #F0F5FB;margin:0 15px;"></div>
			    
			<c:forEach items="${chart.summaryCfgVOs}" var="summary">
				<!-- 概述 -->
			    <p style="font-size: 14px; color:#333;text-align: left;text-indent: 2em;font-family: Microsoft Yahei;background: #eee;line-height: 18px;padding:15px;margin:10px 15px;width:100%;" class="desc-center">
				${summary.finalSummaryStr}
				</p>
			</c:forEach>			    
			  </div>  
		   </c:when>
		   <c:otherwise></c:otherwise>
		</c:choose>
		
		<script type="text/javascript">
			//DOM加载完自动运行图表渲染函数
			$(
				function (){
					//默认空的图表配置对象
					var chart_opt = {};
					
					var legend_data_arr = [];
					var axis_data_arr = [];
					var series_data_arr = [];
					var pie_data_arr = [];
					
					var series_data_map = {};
				
				<c:forEach items="${chart.legendData}" var="l">
					legend_data_arr.push('${l}');
			    </c:forEach >	
					
				<c:forEach items="${chart.axisData}" var="a">
					axis_data_arr.push('${a}');
			    </c:forEach >	
					
				<c:forEach items="${chart.serisData}" var="s">
					series_data_arr.push(${s});
			    </c:forEach >	
					
				<c:forEach items="${chart.groupData}" var="map">
					pie_data_arr.push({ name:'${map.name}' , value:${map.value} });
			    </c:forEach >
			    
			    <c:forEach items="${chart.multiSeriesData}" var="ms">
			    	series_data_map['${ms.key}'] = ${ms.value};
				</c:forEach >

				<c:choose>
				    <c:when test="${empty chart.seriesDbName}">
				    
				      <c:choose>
					    <c:when test="${chart.chartType=='line'}">
					    	$.extend(true,chart_opt,line_option);
					    	chart_opt.title.text='${chart.chartTitle}';
					    	chart_opt.legend.data=legend_data_arr;
					    	chart_opt.xAxis[0].data=axis_data_arr
					    	chart_opt.series[0].data=series_data_arr;
						</c:when>
						 <c:when test="${chart.chartType=='bar'}">
							$.extend(true,chart_opt,bar_option);
							chart_opt.title.text='${chart.chartTitle}';
					    	chart_opt.legend.data=legend_data_arr;
					    	chart_opt.xAxis[0].data=axis_data_arr
					    	chart_opt.series[0].data=series_data_arr;
						</c:when>
						 <c:when test="${chart.chartType=='pie'}">
						 
						 	$.extend(true,chart_opt,pie_option);
						 	chart_opt.title.text='${chart.chartTitle}';
					    	chart_opt.legend.data=legend_data_arr;
					    	chart_opt.series[0].data=pie_data_arr;
				
						</c:when>
						<c:otherwise></c:otherwise>
					  </c:choose>
					  
				    </c:when>
				    
				    <c:otherwise>
				    	<c:choose>
						    <c:when test="${chart.chartType=='line'}">
						    $.extend(true,chart_opt,line_option);
							</c:when>
							<c:when test="${chart.chartType=='bar' }">
							$.extend(true,chart_opt,bar_option);
							</c:when>
							
							<c:otherwise></c:otherwise>
					  	</c:choose>
				    			
						  	chart_opt.title.text='${chart.chartTitle}';
					    	chart_opt.legend.data=legend_data_arr;
					    	chart_opt.xAxis[0].data=axis_data_arr
					    	
					    	var chart_opt_multi_series = [];
					    	//循环每个序列，构造一个数据结构，
					    	for(var prop in series_data_map){
					    		var chart_opt_item = {};
					    		$.extend(true,chart_opt_item,chart_opt.series[0]);
					    		//序列名称
					    		chart_opt_item.name=prop;
					    		//序列数据
					    		chart_opt_item.data=series_data_map[prop];
					    		//追加到chart_opt_multi_series
					    		chart_opt_multi_series.push(chart_opt_item);
					    	}
					    	//多个序列一起赋值
					    	chart_opt.series = chart_opt_multi_series;	
					  	
				    </c:otherwise>
			    </c:choose>
			  
			    //每个图表配置，都放入到映射数组，以便 echart_config初始化完成后，设置图表配置信息。
			  		dom_id_opt_mapper.${chart.chartDomId} = chart_opt;
			  		
				}	
			);
					  	
		</script>
		
	
	</c:forEach>
	<!-- -----------图表循环 end ---------- -->
	
</div>
<!-- 布局结束  -->	
</c:forEach>		