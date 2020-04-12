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
            	<li class="content-item system">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">热销榜</span>
                    </h2>
                    <div class="content-bd" id="chartmain1">
                    	<img src="img/skin_/pic1.png" />
                    </div>
                </li>
                
                <li class="content-item system">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">处理进度</span>
                    </h2>
                    <div class="content-bd" id="chartmain2">
                    	<img src="img/skin_/pic2.png" />
                    </div>
                </li>
                
                   <li class="content-item system">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">处理进度</span>
                    </h2>
                    <div class="content-bd" id="chartmain3">
                    	<img src="img/skin_/pic2.png" />
                    </div>
                </li>
                
                   <li class="content-item system">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">本月订单</span>
                    </h2>
                    <div class="content-bd" id="chartmain4">
                    	<img src="img/skin_/pic2.png" />
                    </div>
                </li>
                
                
                
                <li class="content-item dothings">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">待办事项</span>
                    </h2>
                    <div class="content-bd">
                    	<ul class="content-list things">
                        	<li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">您有新订单需要处理</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">有两个紧急订单，请处理</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">订单拦截失败，请处理</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">订单号99658的订单已签收</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">订单号92658的订单已签收</a>
                            </li>
                        </ul>
                    </div>
                </li>
               
                   <li class="content-item dothings">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">待办事项</span>
                    </h2>
                    <div class="content-bd">
                    	<ul class="content-list things">
                        	<li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">您有新订单需要处理</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">有两个紧急订单，请处理</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">订单拦截失败，请处理</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">订单号99658的订单已签收</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">订单号92658的订单已签收</a>
                            </li>
                        </ul>
                    </div>
                </li>
                
               
                        </ul>
                    </div>
               
        </div>
    </div>


</body>



<!-- 测试  -->
<script type="text/javascript" src="js/echarts.min.js"></script>

<!-- 主要产品销量柱状图 -->
<script type="text/javascript">
        //指定图标的配置和数据
        var option = {
           
            tooltip:{},
            legend:{
                data:['用户来源']
            },
            xAxis:{
                data:['${name0}','${name1}','${name2}','${name3}','${name4}']
            },
            yAxis:{

            },
            series:[{
                type:'bar',
                data:['${num0}','${num1}','${num2}','${num3}','${num4}']
            }]
        };
        //初始化echarts实例
        var myChart = echarts.init(document.getElementById('chartmain1'));

        //使用制定的配置项和数据显示图表
        myChart.setOption(option);
        
    </script>


<!-- 审核进度柱状图 -->
<script type="text/javascript">
        //指定图标的配置和数据
        var option = {
           
            tooltip:{},
            legend:{
                data:['用户来源']
            },
            xAxis:{
                data:["待审核","审核中","审核通过","审核失败"]
            },
            yAxis:{

            },
            series:[{
                type:'bar',
                data:["${待审核}","${审核中}","${审核通过}","${审核失败}"]
            }]
        };
        //初始化echarts实例
        var myChart = echarts.init(document.getElementById('chartmain2'));

        //使用制定的配置项和数据显示图表
        myChart.setOption(option);
    </script>
    
    
 <!-- 审核进度饼状图 -->  
    <script type="text/javascript">
    var option = {
            series:[{
                type:'pie',    
                radius:'60%', 
                data:[
                    {value:"${待审核}",name:'待审核'},
                    {value:"${审核中}",name:'审核中'},
                    {value:"${审核通过}",name:'审核通过'},
                    {value:"${审核失败}",name:'审核失败'}
                ]
            }]
        };
    var myChart = echarts.init(document.getElementById('chartmain3'));

    //使用制定的配置项和数据显示图表
    myChart.setOption(option);
    </script>
    
    <!-- 主要每周订单统计，记录一个月 -->
<script type="text/javascript">
        //指定图标的配置和数据
        var option = {
           
            tooltip:{},
            legend:{
                data:['用户来源']
            },
            xAxis:{
                data:['第一周','第二周','第三周','第四周']
            },
            yAxis:{

            },
            series:[{
                type:'line',
                data:['${orderNum0}','${orderNum1}','${orderNum2}','${orderNum3}']
            }]
        };
        //初始化echarts实例
        var myChart = echarts.init(document.getElementById('chartmain4'));

        //使用制定的配置项和数据显示图表
        myChart.setOption(option);
        
    </script>
<!-- 测试  -->
</html>