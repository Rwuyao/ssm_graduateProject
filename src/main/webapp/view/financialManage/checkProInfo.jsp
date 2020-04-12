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
<script type="text/javascript" src="js/echarts.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<script type="text/javascript">
	function exit(){
		window.location.href="commercial_check";
	}

</script>
<body>
<div id="container">
	<div id="hd">
    <div id="bd">
    	<div id="main">
             
            <!--********************************************************************************************************* -->
            
            <ul class="content-list">
            	<li class="content-item system" style="width: 100%;height: 500px">
                	<h2 class="content-hd">
                    	<span class="title"><center><h1>同类商品营业额比较</h1></center></span>
                    </h2>
                    <div style="width: 100%;height: 500px" class="content-bd" id="chartmain1">
                    	
                    </div>
                </li>
            </ul>
            
            <br />
            <hr />
            <br />
            <ul class="content-list">
            	<li class="content-item system" style="width: 100%;height: 500px">
                	<h2 class="content-hd">
                    	<span class="title"><center><h1>同类商品利润占比</h1></center></span>
                    </h2>
                    <div style="width: 100%;height: 500px" class="content-bd" id="chartmain2">
                    	
                    </div>
                </li>
            </ul>
            <br />
            <hr />
            <br />
			<div align="center">
                	<input class="button" type="button" value="退出" onclick="exit()" style="width: 100px;height:32px; margin-top: 0px;margin-left: 10px" />
                </div>

            

</div>
               
</div>
</div>


</body>


<script type="text/javascript">
var myChart = echarts.init(document.getElementById('chartmain1'));
var audit_id1=${audit_id};
//3.初始化，默认显示标题，图例和xy空坐标轴
myChart.setOption({

	title : {
		text : '营业额比较'
	},
	tooltip : {},

	legend : {

		data : [ '营业额' ]
	},
	xAxis : {
		data : []
	},
	yAxis : {},
	series : [ {
		name : '营业额',
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
	url : "productCheckStatistic?audit_id="+audit_id1, //请求发送到TestServlet
	data : {},
	dataType : "json", //返回数据形式为json

	//7.请求成功后接收数据name+num两组数据
	success : function(result) {
		//result为服务器返回的json对象
		if (result) {
			//8.取出数据存入数组
			for (var i = 0; i < result.length; i++) {
				names.push(result[i].productName); //迭代取出类别数据并填入类别数组
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
					name : '营业额',
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






<script type="text/javascript">
var myChart2 = echarts.init(document.getElementById('chartmain2'));

var audit_id2=${audit_id};
//3.初始化，默认显示标题，图例和xy空坐标轴
myChart2.setOption({

	title : {
		text : '利润比较'
	},
	tooltip : {},

	legend : {

		data : [ '利润占比' ]
	},
	xAxis : {
		data : []
	},
	yAxis : {},
	series : [ {
		name : '利润占比',
		type : 'bar',
		data : []
	} ]
});

//4.设置加载动画(非必须)
myChart2.showLoading(); //数据加载完之前先显示一段简单的loading动画

//5.定义数据存放数组(动态变)
var names2 = []; //建立一个类别数组（实际用来盛放X轴坐标值）
var nums2 = []; //建立一个销量数组（实际用来盛放Y坐标值）

//6.ajax发起数据请求
$.ajax({
	type : "post",
	async : true, //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
	url : "productCheckStatistic?audit_id="+audit_id2,
	data : {},
	dataType : "json", //返回数据形式为json

	//7.请求成功后接收数据name+num两组数据
	success : function(result) {
		//result为服务器返回的json对象
		if (result) {
			//8.取出数据存入数组
			for (var i = 0; i < result.length; i++) {
				names2.push(result[i].productName); //迭代取出类别数据并填入类别数组
			}
			for (var i = 0; i < result.length; i++) {
				nums2.push(result[i].profitRadio); //迭代取出销量并填入销量数组
			}

			myChart2.hideLoading(); //隐藏加载动画

			//9.覆盖操作-根据数据加载数据图表
			myChart2.setOption({
				xAxis : {
					data : names2
				},
				series : [ {
					// 根据名字对应到相应的数据
					name : '利润占比',
					data : nums2
				} ]
			});

		}

	},
	error : function(errorMsg) {
		//请求失败时执行该函数
		alert("图表请求数据失败!");
		myChart2.hideLoading();
	}
})


</script>





</html>