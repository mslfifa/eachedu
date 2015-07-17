//echart配置对象，远程服务器上异步初始化，本地同步初始化
var echart_config = null;

//映射对象 key(dom_id)->value(chart_opt);
var dom_id_opt_mapper = {};

//软询定时器，检查 echart_config是否初始化成非空状态。
var intervalId = null;

function intervalCallbackFn(){
	//初始为非空时，清定时器
	if(echart_config){
		window.clearInterval(intervalId);
		
		for(var prop in dom_id_opt_mapper){
			//初始化图表dom
			var bus_chart = echart_config.init(document.getElementById(prop));
			//设置图表配置
			bus_chart.setOption(dom_id_opt_mapper[prop]);
		}
	}
}

$(function(){
	require.config({
		paths : {
			echarts : _ctx_path+'/echarts-2.2.3/build/dist/'
		}
	});

	require([ 
	          'echarts'
	           ,'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
	          ,'echarts/chart/bar' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/line' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/chord' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/eventRiver' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/funnel' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/gauge' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/k' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/map' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/radar' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/scatter' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/tree' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/treemap' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/venn' // 使用柱状图就加载模块，按需加载
	          ,'echarts/chart/wordCloud' // 使用柱状图就加载模块，按需加载
	        ]
		,function(ec) {
			echart_config = ec;
		}
	);

	intervalId = window.setInterval(
		intervalCallbackFn
		,500
	);
});