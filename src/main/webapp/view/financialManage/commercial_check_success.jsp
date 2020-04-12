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
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.grid.css" />

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">

<title>表格</title>



	 

	<script type="text/javascript">
	 

	function explore(){
		
/* 			1:拿到select对象： var myselect=document.getElementById(“test”);

		2：拿到选中项的索引：var index=myselect.selectedIndex ; // selectedIndex代表的是你所选中项的index

		3:拿到选中项options的value： myselect.options[index].value;

		4:拿到选中项options的text： myselect.options[index].text; */
		var myselect1=document.getElementById("sel1");
		var index1=myselect1.selectedIndex;
		var selects1=myselect1.options[index1].value;
		
		var myselect2=document.getElementById("sel2");
		var index2=myselect2.selectedIndex;
		var selects2=myselect2.options[index2].value;

		//alert("mohu="+mohu+" selects1="+selects1);
		window.location.href="checkAuditByCondition?catagorg="+selects1+"&timeType="+selects2;			
		
	}
	
	function exit(){
		top.window.location.href="main.jsp";
	}
</script>

	

</head>

<body>  
    <div class="#" style="">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">审核状态</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li ><a href="commercial_check">未审核</a>
                    </li>
                    <li class="active"><a href="commercial_check_success">已审核</a>
                    </li>

                </ul>
            </div>
        </nav>
    </div> 
<!-- *******************************************************************************************************************8 -->
	<<div class="search-box ue-clear">
            	 <div class="search-area" >
                   
                    <div class="kv-item ue-clear" >
                        <label>选择时间段:</label>
                        <div class="kv-item-content">
                            <select id="sel2">
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
                           	   <c:forEach items="${catagorgList }" var="catagorgList">
                            		<c:if test="${catagorgList==catagorg}">
										<option  value="${catagorgList}"
										selected="selected">${catagorgList}</option>
									</c:if>
									<c:if test="${catagorgList!=catagorg}">
										<option value="${catagorgList}">${catagorgList}</option>
									</c:if>
								</c:forEach>
                            </select>
                        </div>
                    </div> 
                    <%-- <div class="kv-item ue-clear" >
                        <label>模糊查询:</label>
                        <div class="kv-item-content">
                            <input  type="text" style="width: 398px;height: 28px" placeholder="自定义检索" id="mohu" value="${mohu}"/>
                        </div>
                    </div> --%>
	                <div class="search-button" style="margin-left: 200px">
	                	<input class="button" type="button" value="搜索一下" onclick="explore()" />
	                </div>

                </div>

              </div>   
             
             <hr />      
                <div style="width: 100%;margin-top: 10px" >
                <table class="col-sm-12 table-bordered table-hover">
                	<tr>
                		<th><font size="3" color="red">审核单号</font></th>
                		<th><font size="3" color="red">发送部门</font></th>
                		<th><font size="3" color="red">第一审核人</font></th>
                		<th><font size="3" color="red">原因</font></th>
                		<th><font size="3" color="red">产品名称</font></th>
                		<th><font size="3" color="red">价格</font></th>
                		<th><font size="3" color="red">商品数量</font></th>
                		<th><font size="3" color="red">日期</font></th>
<!--                 		<th colspan="3"><font size="3" color="red">操作</font></th> -->
                	</tr>
                	<c:forEach items="${auditList}" var="audit">
                	<tr style="height: 50px" class="success">
                		<td>${audit.auditId }</td>
                		<td>${audit.depSend}</td>
                		<td>${audit.firstCheck}</td>
                		<td>${audit.becauser}</td>
                		<td>${audit.productName}</td>
                		<td>${audit.price}</td>
                		<td>${audit.number}</td>
                		<td><fmt:formatDate value="${audit.time}" pattern='yyyy-MM-dd HH:mm:ss'/></td>
                	</tr>
                	</c:forEach>
                </table>
                <div>
                
                
                
                
                
                
                
                <!-- model -->
	<%-- 		<div class="update_modal">
                <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
	<div class="modal-dialog model-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel2">
					<center>审核详情</center>
				</h4>
			</div>
			<hr />
			
			
			<ul class="content-list">
            	<li class="content-item system" style="width: 100%;height: 500px">
                	<h2 class="content-hd">
                    	<span class="title"><center><h1>营业额</h1></center></span>
                    </h2>
                    <div style="width: 100%;height: 500px" class="content-bd" id="chartmain1">
                    	
                    </div>
                </li>
            </ul>
            <ul class="content-list">
            	<li class="content-item system" style="width: 100%;height: 500px">
                	<h2 class="content-hd">
                    	<span class="title"><center><h1>利润占比</h1></center></span>
                    </h2>
                    <div style="width: 100%;height: 500px" class="content-bd" id="chartmain2">
                    	
                    </div>
                </li>
            </ul>
            
            
            <hr />
			
			
			
			<div class="modal-footer">
			<center>
				<button type="button" class="btn btn-primary" data-dismiss="modal">返回
				</button>
				<button type="button" class="btn btn-primary" onclick="pass()">
					审核通过
				</button>
			</center>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal --> --%>
                
                
                
                
          
                
                
                <!-- model -->
                <div class="update_modal">
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog model-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<center>你确定要审核<font size="4" color="red">通过</font>吗</center>
				</h4>
			</div>
			<div class="modal-footer">
			<center>
				<button type="button" class="btn btn-primary" data-dismiss="modal">取消
				</button>
				<button type="button" class="btn btn-primary" onclick="pass()">
					确定
				</button>
			</center>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
	
	
	<!-- model -->
			<div class="update_modal">
                <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
	<div class="modal-dialog model-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel2">
					<center>你确定要<font size="4" color="red">拒绝</font>通过吗</center>
				</h4>
			</div>
			<div class="modal-footer">
			<center>
				<button type="button" class="btn btn-primary" data-dismiss="modal">取消
				</button>
				<button type="button" class="btn btn-primary" onclick="nopass()">
					确定
				</button>
			</center>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
</div>

        </div>
    </div>

</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript" src="js/jquery.grid.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>

<script type="text/javascript">
var myChart = echarts.init(document.getElementById('chartmain1'));

var audit_id=$("#check3").parent().parent().find("td").eq(0).text();
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
	url : "productCheckStatistic?audit_id"=audit_id, //请求发送到TestServlet
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
//var audit_id=$("#check3").parent().parent().find("td").eq(0).text();
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
	url : "productCheckStatistic?audit_id="+audit_id,
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