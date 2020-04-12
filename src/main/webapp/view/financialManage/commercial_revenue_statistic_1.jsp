<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/index.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="container">
	<div id="hd">
    </div>
    <div id="bd">
    	<div id="main">
            <ul class="nav-list ue-clear">
            	<li class="nav-item desk">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">我的桌面</p>
                    </a>
                </li>
                <li class="nav-item news">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">新闻资讯</p>
                    </a>
                </li>
                <li class="nav-item notice">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">公告通知</p>
                    </a>
                </li>
                
                <li class="nav-item plan">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">工作计划</p>
                    </a>
                </li>
                <li class="nav-item contacts">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">通讯录</p>
                    </a>
                </li>
                <li class="nav-item mail">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">我的邮件</p>
                    </a>
                </li>
                <li class="nav-item logs">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">我的日志</p>
                    </a>
                </li>
                <li class="nav-item dosthings">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">待办事宜</p>
                    </a>
                </li>
                <li class="nav-item fav">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">收藏夹</p>
                    </a>
                </li>
                
                <li class="nav-item browser">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">浏览器</p>
                    </a>
                </li>
            </ul>
            
            <ul class="content-list">
            	<li class="content-item system col-sm-4">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">营利概况</span>
                        
                    </h2>
                    <div class="content-bd" id="chartmain1">
                    	<img src="img/skin_/pic1.png" />
                    </div>
                </li>
                
                
                <li class="content-item system col-sm-4">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">利润对比</span>
                    </h2>
                    <div class="content-bd" id="chartmain2">
                    	<img src="img/skin_/pic2.png" />
                    </div>
                </li>
                <br />
                
                <li class="content-item news col-sm-4">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">新闻资讯</span>
                    </h2>
                    <div class="content-bd">
                    	<ul class="content-list things">
                        	<li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">查干湖冬捕壮观景象</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">江西新余：一座城为重病男童圆梦</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">学生建4.5平米1室1厅1厨1卫 欲申请专利</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">央视直播曝光中纪委办公区</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">盘点那些年曾“脱光光”的十大女星</a>
                            </li>
                        </ul>
                    </div>
                </li>
                
                <li class="content-item news col-sm-4">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">我的邮件</span>
                    </h2>
                    <div class="content-bd">
                    	<ul class="content-list things">
                        	<li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">查干湖冬捕壮观景象</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">江西新余：一座城为重病男童圆梦</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">学生建4.5平米1室1厅1厨1卫 欲申请专利</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">央视直播曝光中纪委办公区</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">盘点那些年曾“脱光光”的十大女星</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
	var minwidth = 282;
	resizeWidth();
	$(top.window).resize(function(e) {
       resizeWidth();
    });
	$(function() {
		$( ".content-list" ).sortable({
		  revert: true,
		  handle:'h2'
		});
		
	});
	
function resizeWidth (){
	if($('#main').width() / 3 < minwidth){
		$('.content-item').width(($('#main').width() / 2) - 15);
	}else{
		$('.content-item').width(($('#main').width() / 3) - 15);	
	}
		
}
</script>
<!-- 测试  -->
<script type="text/javascript" src="js/echarts.min.js"></script>


    <!-- 审核进度饼状图 -->  
    <!-- <script type="text/javascript">
    
    
    var option = {
            series:[{
                type:'line',    
                radius:'60%', 
                data:[
                    {value:"${profit1}",name:'${time1}'},
                    {value:"${profit2}",name:'${time2}'},
                    {value:"${profit3}",name:'${time3}'},
                    {value:"${profit4}",name:'${time4}'}
                ]
            }]
        };
    var myChart = echarts.init(document.getElementById('chartmain1'));

    //使用制定的配置项和数据显示图表
    myChart.setOption(option);
    </script> -->
    
     <script type="text/javascript">
var myChart1 = echarts.init(document.getElementById('chartmain1'));

//3.初始化，默认显示标题，图例和xy空坐标轴
myChart1.setOption({

	title : {
		text : '前三个月利润对比'
	},
	tooltip : {},

	legend : {

		data : [ '利润' ]
	},
	xAxis : {
		data : []
	},
	yAxis : {},
	series : [ {
		name : '利润',
		type : 'bar',
		data : []
		    
	} ]
});

//4.设置加载动画(非必须)
myChart1.showLoading(); //数据加载完之前先显示一段简单的loading动画

//5.定义数据存放数组(动态变)
var names1 = []; //建立一个类别数组（实际用来盛放X轴坐标值）
var nums1 = []; //建立一个销量数组（实际用来盛放Y坐标值）

//6.ajax发起数据请求
$.ajax({
	type : "post",
	async : true, //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
	url : "commercial_revenue_statistic", //请求发送到TestServlet
	data : {},
	dataType : "json", //返回数据形式为json

	//7.请求成功后接收数据name+num两组数据
	success : function(result) {
		//result为服务器返回的json对象
		if (result) {
			//8.取出数据存入数组
			for (var i = 0; i < 3; i++) {
				names1.push(result[i].timeType); //迭代取出类别数据并填入类别数组
			}
			for (var i = 0; i < 3; i++) {
				nums1.push(result[i].moneyCompare); //迭代取出销量并填入销量数组
			}

			myChart1.hideLoading(); //隐藏加载动画

			//9.覆盖操作-根据数据加载数据图表
			myChart1.setOption({
				xAxis : {
					data : names1
				},
				series : [ {
					// 根据名字对应到相应的数据
					name : '利润',
					data : nums1
				} ]
			});

		}

	},
	error : function(errorMsg) {
		//请求失败时执行该函数
		alert("图表请求数据失败!");
		myChart1.hideLoading();
	}
})


</script>
    
    <script type="text/javascript">
var myChart = echarts.init(document.getElementById('chartmain2'));

//3.初始化，默认显示标题，图例和xy空坐标轴
myChart.setOption({

	title : {
		text : '商品总利润比较'
	},
	tooltip : {},

	legend : {

		data : [ '利润' ]
	},
	xAxis : {
		data : []
	},
	yAxis : {},
	series : [ {
		name : '利润',
		type : 'bar',
		data : []
		    
	} ]
});

//4.设置加载动画(非必须)
myChart.showLoading(); //数据加载完之前先显示一段简单的loading动画

//5.定义数据存放数组(动态变)
var names = []; //建立一个类别数组（实际用来盛放X轴坐标值）
var nums = []; //建立一个销量数组（实际用来盛放Y坐标值）

//6.ajax发起数据请求
$.ajax({
	type : "post",
	async : true, //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
	url : "commercial_revenue_statistic", //请求发送到TestServlet
	data : {},
	dataType : "json", //返回数据形式为json

	//7.请求成功后接收数据name+num两组数据
	success : function(result) {
		//result为服务器返回的json对象
		if (result) {
			//8.取出数据存入数组
			for (var i = 0; i < result.length; i++) {
				names.push(result[i].bround); //迭代取出类别数据并填入类别数组
			}
			for (var i = 0; i < result.length; i++) {
				nums.push(result[i].totalProfit); //迭代取出销量并填入销量数组
			}

			myChart.hideLoading(); //隐藏加载动画

			//9.覆盖操作-根据数据加载数据图表
			myChart.setOption({
				xAxis : {
					data : names
				},
				series : [ {
					// 根据名字对应到相应的数据
					name : '总利润',
					data : nums
				} ]
			});

		}

	},
	error : function(errorMsg) {
		//请求失败时执行该函数
		alert("图表请求数据失败!");
		myChart.hideLoading();
	}
})


</script>

</html>