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
	
	
	function chuan(id){
		
		$("#auditid2").val(id)
		
		
	}
	
	
			function show1(){
				document.getElementById("div1").style.display="block";
			}
	
	</script>
	<script type="text/javascript">
			function show2(){
				document.getElementById("div2").style.display="block";
			}
	
	</script>
	
	<script type="text/javascript">
	var num="";
		function sendAuth(){
			document.getElementById("firstAuthCode").style.display="block";
			var mail=document.getElementById("mail").value;
			for(var i=0;i<6;i++){
				num+=Math.floor(Math.random()*10);
			}
			//alert("mail="+mail+" num="+num);
			
			$.ajax({
				type:"post",
				url:"sendMail",
				data:{
					auth:num,
					mail:mail
				},
				success:function(result){
					console.log(result);
				},
				error:function(){
					console.log("失败");
				}
			});
			
			//这里是倒计时
			var timer_num = 180;
		    timeClock=setInterval(function(){
		        timer_num--;
		        $("#timeDecline").html(timer_num);
		       
		        if (timer_num == 0) {
		        	clearInterval(timeClock);
		            window.location.href="commercial_check";
		        } 
		    },1000)
		
		}
		</script>
	

	
	 <script type="text/javascript">
	var num2="";
	function sendAuth2(){
		document.getElementById("authCode2").style.display="block";
		var mail2=document.getElementById("mail2").value;
		for(var i=0;i<6;i++){
			num2+=Math.floor(Math.random()*10);
		}
		alert("mail="+mail2+" num="+num2);
		
		$.ajax({
			type:"post",
			url:"sendMail",
			data:{
				auth:num2,
				mail:mail2
			},
			success:function(result){
				console.log(result)
			},
			error:function(){
				console.log("失败")
			}
		});
		
		//这里是倒计时
		var timer_num2= 180;
	    timeClock2=setInterval(function(){
	        timer_num2--;
	        $("#timeDecline2").html(timer_num2);
	       
	        if (timer_num2 == 0) {
	        	clearInterval(timeClock2);
	            window.location.href="commercial_check";
	        } 
	    },1000)
	
	}
	
	
	

	</script> 

 	<script type="text/javascript">
		function checkInfo(obj){
			var audit_id=$(obj).parent().parent().find("td").eq(0).text();
			// alert(audit_id);
			window.location.href="checkProInfo?audit_id="+audit_id;
		}
	</script> 
	
	<script type="text/javascript">
	function pass(){

		var inputResult=document.getElementById("firstAuthCode").value;
		
			$.ajax({
				type:"post",
				url:"checkCode",
				data:{
					auth:inputResult
				},
				success:function(result){
					if(result=="success"){
						var audit=$("#auditid2").val();
						window.location.href="passCheck?id="+audit;
						//alert("成功提交");
						//window.location.href="commercial_check";
					}else{
						alert("验证失败");
						window.location.href="commercial_check";
					}
					
				},
				error:function(data){
					alert("验证失败");
					window.location.href="commercial_check";
				}
			});
	}
					 

	</script>
	
	<script type="text/javascript">
	function nopass(){
		var inputResult=document.getElementById("authCode2").value;
		$.ajax({
			type:"post",
			url:"checkCode",
			data:{
				auth:inputResult
			},
			success:function(result){
				if(result=="success"){
					var id=$("#check2").parent().parent().find("td").eq(0).text();
					window.location.href="nopassCheck?id="+id;
					//alert("成功提交");
					//window.location.href="commercial_check";
				}else{
					alert("验证失败");
					window.location.href="commercial_check";
				}
				
			},
			error:function(data){
				alert("验证失败");
				window.location.href="commercial_check";
			}
		});
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
                    <li class="active"><a href="commercial_check">未审核</a>
                    </li>
                    <li ><a href="commercial_check_success">已审核</a>
                    </li>

                </ul>
            </div>
        </nav>
    </div> 
<!-- *******************************************************************************************************************8 -->

             
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
                		<th colspan="3"><font size="3" color="red">操作</font></th>
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
                		<td><button class="btn btn-primary" onclick="checkInfo(this)">查看详情</button></td>
                		<td><button class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="check1"  onclick="chuan(${audit.auditId })" >同意通过</button></td>
                		<td><button class="btn btn-primary" data-toggle="modal" data-target="#myModal2" id="check2">拒绝通过</button></td>
                	</tr>
                	</c:forEach>
                </table>
                <div>
                
                    
                
                
                <!-- model -->
                <div class="update_modal">
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog model-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<center>你确定要审核<font size="4" color="red">通过</font>吗</center>
				</h4>
			</div>
			<div style="display: none" id="div1">
				<center>请输入邮箱:<input type="text" id="mail" placeholder="填入邮箱"><input type="button" onclick="sendAuth()" value="发送验证码"></center>
				<br />
				<center>下方输入验证码<input type="text" name="firstAuth" id="firstAuthCode" style="display: none" placeholder="请输入">剩余时间:<span id="timeDecline">180</span>秒</center>
				<br />
				<input type="hidden" id="auditid2" value="">
				<center><input type="button" value="确定" onclick="pass()"></center>
				
			</div>
			<div class="modal-footer">
			<center>
				<button type="button" class="btn btn-primary" data-dismiss="modal">取消
				</button>
				<button type="button" class="btn btn-primary" onclick="show1()">
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
			<div style="display: none" id="div2">
				<center>请输入邮箱:<input type="text" id="mail2" placeholder="填入邮箱"><input type="button" onclick="sendAuth2()" value="发送验证码"></center>
				<br />
				<center>下方输入验证码<input type="text" id="authCode2" style="display: none" placeholder="请输入">剩余时间:<span id="timeDecline2">180</span>秒</center>
				<br />
				<center><input type="button" value="确定" onclick="nopass()"></center>
				
			</div>
			<div class="modal-footer">
			<center>
				<button type="button" class="btn btn-primary" data-dismiss="modal">取消
				</button>
				<button type="button" class="btn btn-primary" onclick="show2()">
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