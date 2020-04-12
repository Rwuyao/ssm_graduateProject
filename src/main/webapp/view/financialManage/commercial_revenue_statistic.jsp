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
<body>
<div id="container">
	<div id="hd">
    <div id="bd">
    	<div id="main">
            <%-- <div class="search-box ue-clear">
            	<div class="search-area">
                   
                    <div class="kv-item ue-clear">
                        <label>选择时间段:</label>
                        <div class="kv-item-content">
                            <select id="sel1">
                                <c:forEach items="${time}" var="time">
                            		<c:if test="${time==timeType}">
										<option  value="${time}"
										selected="selected">${time}</option>
									</c:if>
									<c:if test="${time!=timeType}">
										<option value="${time}">${time}</option>
									</c:if>
								</c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="kv-item ue-clear">
                        <label>选择类别:</label>
                        <div class="kv-item-content">
                            <select id="sel2">
                           	   <c:forEach items="${broundList }" var="bround">
                            		<c:if test="${bround==catagorg}">
										<option  value="${bround}"
										selected="selected">${bround}</option>
									</c:if>
									<c:if test="${bround!=catagorg}">
										<option value="${bround}">${bround}</option>
									</c:if>
								</c:forEach>
                            </select>
                        </div>
                    </div>
	                <div class="search-button" style="margin-left: 200px">
	                	<input class="button" type="button" value="搜索一下" onclick="explore()" />
	                </div>
                </div>

                <div class="pull-right">
                    <input class="button" type="button" value="退出" onclick="exit()" />
                </div>
             </div> --%>
            <!--********************************************************************************************************* -->
            
            <ul class="content-list">
            	<li class="content-item system" style="width: 100%;height: 500px">
                	<h2 class="content-hd">
                    	<span class="title"><center><h1>总利润</h1></center></span>
                    </h2>
                    <div style="width: 100%;height: 500px" class="content-bd" id="chartmain1">
                    	
                    </div>
                </li>
            </ul>           

</div>
               
</div>
</div>


</body>




<script type="text/javascript">
var myChart = echarts.init(document.getElementById('chartmain1'));

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






<!-- <script type="text/javascript">
var myChart2 = echarts.init(document.getElementById('chartmain2'));

//3.初始化，默认显示标题，图例和xy空坐标轴
myChart2.setOption({

	title : {
		text : '商品入库成本比较'
	},
	tooltip : {},

	legend : {

		data : [ '总成本' ]
	},
	xAxis : {
		data : []
	},
	yAxis : {},
	series : [ {
		name : '总成本',
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
	url : "goInInventoryMain", //请求发送到TestServlet
	data : {},
	dataType : "json", //返回数据形式为json

	//7.请求成功后接收数据name+num两组数据
	success : function(result) {
		//result为服务器返回的json对象
		if (result) {
			//8.取出数据存入数组
			for (var i = 0; i < result.length; i++) {
				names2.push(result[i].bround); //迭代取出类别数据并填入类别数组
			}
			for (var i = 0; i < result.length; i++) {
				nums2.push(result[i].totalRuKuCost); //迭代取出销量并填入销量数组
			}

			myChart2.hideLoading(); //隐藏加载动画

			//9.覆盖操作-根据数据加载数据图表
			myChart2.setOption({
				xAxis : {
					data : names2
				},
				series : [ {
					// 根据名字对应到相应的数据
					name : '总成本',
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


</script> -->




</html>