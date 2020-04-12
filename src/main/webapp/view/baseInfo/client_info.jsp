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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	
<body>
<p class="lead">客户信息</p><br>




<form class="form-inline">
  
  <div class="form-group">
   
    <input type="text" class="form-control" id="message" placeholder="输入查询内容" >
  </div>
  <button type="button" class="btn btn-info"  onclick="demo13()">搜索</button>
   <button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myModal3">增加</button>
</form>
 

<table class="table table-hover" border="1px" id="tab1" >
<tbody align="center">
<tr >
<th  style="text-align:center;">公司名称</th><th style="text-align:center;">代理人</th><th style="text-align:center;">性别</th><th style="text-align:center;">电话</th><th style="text-align:center;">邮箱</th><th style="text-align:center;">公司地址</th><th style="text-align:center;">历史记录</th><th colspan="1"  style="text-align:center;">操作</th>

</tr>
<c:forEach items="${Cumap.list}" var="customer">
<tr >
<td  >${customer.cus_company_name }  </td><td >${customer.cus_username }</td><td >${customer.cus_sex }</td><td >${customer.cus_tel }</td><td >${customer.cus_email }</td><td >${customer.cus_address }</td>
<td><a href="queryOrderByName?name=${customer.cus_username } ">购买记录</a>
</td>
<td><button  type="button" class="btn btn-danger" id="button2" onclick="button2(${customer.cus_id})">删除</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button  type="button" class="btn btn-warning" onclick="button4(${customer.cus_id})" data-toggle="modal" data-target="#myModal">修改</button></td>
</tr>
</c:forEach>

</tbody>
</table>
<div class="col-xs-6 col-sm-4" id="divbutt">
 	<button onclick="prev()" class="btn btn-info" >上一页</button>  <button onclick="next()" class="btn btn-info">下一页</button>
 共<span >${Cumap.totalPage}</span>页
  一共<span>${Cumap.total}</span>条
  
  </div >
  
  <input type="hidden" id="currentPage" value="${Cumap.currentPage }">
<input type="hidden" id="totalPage" value="${Cumap.totalPage }">
<script >
//当前页
var page=$("#currentPage").val();
//总页数
var totalPage=$("#totalPage").val();


	//上一页设置
	function prev() {
		 page--;
		if (page==0) {
			page=1;
		}
		window.location.href="client_info?page="+page; 
		
	}
	//下一页设置
	function next() {
		page++;
		if (page>totalPage) {
			page=totalPage;
		}
		window.location.href="client_info?page="+page; 
	}
	




	function demo13() {
		var message = $("#message").val();
	
		$.ajax({
			type:"post",
			url:"Q_SelectMessage",
			data:{"message":message}, 
			dataType:"text",
			success:function(result){
				if (result=="err") {
					alert("查询条件不能为空")
				}else {
					alert("查询成功");
					$("#divbutt").hide();
					$("#tab1 tr td").remove();
					var customer =eval(result);
					$(customer).each(function(i,m) {
						
						$("#tab1").append(
							"<tr>"+"<td>"+m.cus_company_name+"</td>"+
							"<td>"+m.cus_username+"</td>"+
							"<td>"+m.cus_sex+"</td>"+
							"<td>"+m.cus_tel+"</td>"+
							"<td>"+m.cus_email+"</td>"+
							"<td>"+m.cus_address+"</td>"+
							
							"<td>"+"<a href='queryOrderByName?name="+m.cus_username+"'>"+"购买记录"+"</a>"+"</td>"+
							"<td>"+"<button type='button' class='btn btn-danger' id='button2' onclick='button2"+"("+m.cus_id +")"+"'>"+"删除"+"</button>"+
							"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+
							"<button type='button' class='btn btn-warning' data-toggle='modal' data-target='#myModal' onclick='button4"+"("+m.cus_id +")'>"+"修改"+"</button>"+"</td>"+
							"</tr>"
						
						)
						
					})
					
					
				}
				
				//window.location.reload(true);
				
			},
			error:function(){
				alert("查询失败")
			}
			
			
		})
		
		
	}






	function button2(m) {
		if(confirm("确定是否删除")){
			var cus_id = m;
			
			$.ajax({
				type:"post",
				url:"Q_updatecusMessage?time=new Date().getTime()",
				data:{"cus_id":cus_id}, 
				dataType:"text",
				success:function(result){
					alert("删除成功")
					
					$("#tab1 tr td").remove();
					
					var customer =eval(result);
					$(customer).each(function(i,m) {
						
						$("#tab1").append(
							"<tr>"+"<td>"+m.cus_company_name+"</td>"+
							"<td>"+m.cus_username+"</td>"+
							"<td>"+m.cus_sex+"</td>"+
							"<td>"+m.cus_tel+"</td>"+
							"<td>"+m.cus_email+"</td>"+
							"<td>"+m.cus_address+"</td>"+
							
							"<td>"+"<a href='queryOrderByName?name="+m.cus_username+"'>"+"购买记录"+"</a>"+"</td>"+
							"<td>"+"<button type='button' class='btn btn-danger' id='button2' onclick='button2"+"("+m.cus_id +")"+"'>"+"删除"+"</button>"+
							"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+
							"<button type='button' class='btn btn-warning' data-toggle='modal' data-target='#myModal' onclick='button4"+"("+m.cus_id +")'>"+"修改"+"</button>"+"</td>"+
							"</tr>"
						
						)
						
					})
					window.location.reload(true);
					
				},error:function(){
					alert("出现异常");
				}
				
				
			})
		}
	}
	function button4(q) {
		
		var cus_id = q;
		
		
		 $.ajax({
			type:"POST",
			url:"Q_selectCustomer",
			data:{"cus_id":cus_id},
			 
			dataType:"json",
			success:function(result){
			
				var customer = JSON.stringify(result);
				var json = eval("("+customer+")");
				
				
				$("#cus_id").val(json.cus_id);
				$("#cus_company_name").val(json.cus_company_name);
				$("#cus_username").val(json.cus_username);
				$("#cus_sex").val(json.cus_sex);
				$("#cus_tel").val(json.cus_tel);
				$("#cus_email").val(json.cus_email);
				$("#cus_address").val(json.cus_address);
				 
			}
			
			
		})
		
		
		
	}


</script>


<!--修改模态框开始  -->
<form action="Q_CusUpdateByMess" method="post">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					修改页面
				</h4>
			</div>
			<input type="hidden" id="cus_id" name="cus_id" value="">
			<div class="modal-body">
				<div align="center">
						<table>
							<tr><td><span>公司名称</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_company_name" name="cus_company_name" type="text" class="form-control" placeholder="公司名称" aria-describedby="basic-addon1" value="" ></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>代理人</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_username" name="cus_username" type="text" class="form-control" placeholder="代理人" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>性别</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_sex" name="cus_sex" type="text" class="form-control" placeholder="性别" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>电话</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_tel" name="cus_tel" type="text" class="form-control" placeholder="电话" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>邮箱</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_email" name="cus_email" type="text" class="form-control" placeholder="邮箱" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>公司地址</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_address" name="cus_address" type="text" class="form-control" placeholder="公司地址" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="submit" class="btn btn-primary">
					确定
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
</form>
<!--修改模态框结束  -->

<!--增加模态框开始  -->
<form action="Q_CusInsertByMess" method="post">
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					增加页面
				</h4>
			</div>
			
			<div class="modal-body">
				<div align="center">
						<table>
							<tr><td><span>公司名称</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_company_name2" name="cus_company_name2" type="text" class="form-control" placeholder="公司名称" aria-describedby="basic-addon1" value="" ></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>代理人</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_username2" name="cus_username2" type="text" class="form-control" placeholder="代理人" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>性别</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_sex2" name="cus_sex2" type="text" class="form-control" placeholder="性别" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>电话</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_tel2" name="cus_tel2" type="text" class="form-control" placeholder="电话" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>邮箱</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_email2" name="cus_email2" type="text" class="form-control" placeholder="邮箱" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>公司地址</span></td>
							<td><span id="basic-addon1"></span> <input id="cus_address2" name="cus_address2" type="text" class="form-control" placeholder="公司地址" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="submit" class="btn btn-primary">
					确定
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
</form>
<!--增加模态框结束  -->
</body>
</html>