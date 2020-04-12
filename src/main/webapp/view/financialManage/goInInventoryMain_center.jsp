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
		 

		function explore(){
			
/* 			1:拿到select对象： var myselect=document.getElementById(“test”);

			2：拿到选中项的索引：var index=myselect.selectedIndex ; // selectedIndex代表的是你所选中项的index

			3:拿到选中项options的value： myselect.options[index].value;

			4:拿到选中项options的text： myselect.options[index].text; */
			var myselect1=document.getElementById("sel1");    //这是商品类别
			var index1=myselect1.selectedIndex;
			var selects1=myselect1.options[index1].value;
			
			var myselect2=document.getElementById("sel2");    //这是时间
			var index2=myselect2.selectedIndex;
			var selects2=myselect2.options[index2].value;
			
			var myselect3=document.getElementById("sel3");    //这是方式
			var index3=myselect3.selectedIndex;
			var selects3=myselect3.options[index3].value;
				
			alert( "selects1="+selects1+"selects2="+selects2+"selects3="+selects3);
			window.location.href="goInInventoryMain_center?timeType="+selects2+"&goodsType="+selects1+"&modeType="+selects3;			
			
		}
		
		function exit(){
			top.window.location.href="main.jsp";
		}
	</script>


<body>
<div id="container">
	<div id="hd">
    <div id="bd">
    	<div id="main">
              <div class="search-box ue-clear">
            	 <div class="search-area" >
                   
                    <div class="kv-item ue-clear" >
                        <label>选择时间段:</label>
                        <div class="kv-item-content">
                            <select id="sel2">
                            	<!-- <option name="op1" value="一周内" selected="selected"></option>
                            	<option name="op1" value="一月内"></option>
                            	<option name="op1" value="三月内"></option>
                            	<option name="op1" value="一年内"></option> -->
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
                    <div class="kv-item ue-clear" >
                        <label>选择类别:</label>
                        <div class="kv-item-content">
                            <select id="sel1">
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
                     <div class="kv-item ue-clear" >
                        <label>显示方式:</label>
                        <div class="kv-item-content">
                            <select id="sel3">
                           	   <c:forEach items="${modelList}" var="mode">
                            		<c:if test="${mode==selectMode}">
										<option  value="${mode}"
										selected="selected">${mode}</option>
									</c:if>
									<c:if test="${mode!=selectMode}">
										<option value="${mode}">${mode}</option>
									</c:if>
								</c:forEach>
                            </select>
                        </div>
                    </div>
                    <%-- <div class="kv-item ue-clear" >
                        <label>模糊查询:</label>
                        <div class="kv-item-content">
                            <input  type="text" placeholder="自定义检索" id="mohu" value="${mohu}"/>
                        </div>
                    </div> --%>
	                <div class="search-button" style="margin-left: 200px">
	                	<input class="button" type="button" value="搜索一下" onclick="explore()" />
	                </div>
                </div>

             </div>   
             <hr />
            <!--********************************************************************************************************* -->
            
            <ul class="content-list">
            	<li class="content-item system" style="width: 100%;height: 500px">
                	<h2 class="content-hd">
                    	<span class="title"><center><h1>入库数量</h1></center></span>
                    </h2>
                    <div style="width: 100%;height: 500px" class="content-bd" id="chartmain1">
                    	
                    </div>
                </li>
            </ul>
            <ul class="content-list">
            	<li class="content-item system" style="width: 100%;height: 500px">
                	<h2 class="content-hd">
                    	<span class="title"><center><h1>入库成本</h1></center></span>
                    </h2>
                    <div style="width: 100%;height: 500px" class="content-bd" id="chartmain2">
                    	
                    </div>
                </li>
            </ul>

            

</div>
               
</div>
</div>


</body>




<script type="text/javascript">
var myChart = echarts.init(document.getElementById('chartmain1'));
/* var mode1=null;
var selectMode1=${selectMode};
if(selectMode1=='柱状图'){
	mode1='bar';
}else{
	mode1='line';
} */

//3.初始化，默认显示标题，图例和xy空坐标轴
myChart.setOption({

	title : {
		text : '商品入库数量比较'
	},
	tooltip : {},

	legend : {

		data : [ '入库数量' ]
	},
	xAxis : {
		data : []
	},
	yAxis : {},
	series : [ {
		name : '入库数量',
		type : '${myMode}',
		data : []
	} ]
});

//4.设置加载动画(非必须)
myChart.showLoading(); //数据加载完之前先显示一段简单的loading动画

//5.定义数据存放数组(动态变)
var names = []; //建立一个类别数组（实际用来盛放X轴坐标值）
var nums = []; //建立一个销量数组（实际用来盛放Y坐标值）

/* var timeType1=${timeType};
var goodsType1=${catagorg}; */
//6.ajax发起数据请求
$.ajax({
	type : "post",
	async : true, //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
	url : "goInInventoryMain_last?timeType=${timeType}&&goodsType=${catagorg}",
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
				nums.push(result[i].totalRuKuNumber); //迭代取出销量并填入销量数组
			}

			myChart.hideLoading(); //隐藏加载动画

			//9.覆盖操作-根据数据加载数据图表
			myChart.setOption({
				xAxis : {
					data : names
				},
				series : [ {
					// 根据名字对应到相应的数据
					name : '入库数量',
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
/* var mode2=null;
var selectMode2=${selectMode};
if(selectMode2=='柱状图'){
	mode2='bar';
}else{
	mode2='line';
} */
//3.初始化，默认显示标题，图例和xy空坐标轴
myChart2.setOption({

	title : {
		text :'商品入库成本比较'
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
		type : '${myMode}',
		data : []
	} ]
});

//4.设置加载动画(非必须)
myChart2.showLoading(); //数据加载完之前先显示一段简单的loading动画

//5.定义数据存放数组(动态变)
var names2 = []; //建立一个类别数组（实际用来盛放X轴坐标值）
var nums2 = []; //建立一个销量数组（实际用来盛放Y坐标值）
/* var timeType2=${timeType};
var goodsType2=${catagorg}; */
//6.ajax发起数据请求
$.ajax({
	type : "post",
	async : true, //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
	url : "goInInventoryMain_last?timeType=${timeType}&&goodsType=${catagorg}", //请求发送到TestServlet
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


</script>




</html>