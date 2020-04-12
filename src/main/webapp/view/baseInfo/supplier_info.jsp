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
<p class="lead">供应商信息</p><br>




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
<th  style="text-align:center;">公司名称</th><th  style="text-align:center;">公司经理</th><th  style="text-align:center;">公司电话</th><th  style="text-align:center;">公司地址</th><th style="text-align:center;">主营业务</th><th colspan="1"  style="text-align:center;">操作</th>

</tr>
<c:forEach items="${map.list}" var="list">
<tr id="${list.supplierId }">
<td >${list.company }</td><td >${list.wner }</td><td >${list.telephone }</td><td >${list.adress }</td>
<td> ${list.des} </td>
<td><button  type="button" class="btn btn-danger"  onclick="button2(${list.supplierId})" >删除</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button  type="button" class="btn btn-warning" onclick="button4(${list.supplierId})" data-toggle="modal" data-target="#myModal">修改</button></td>
</tr>
</c:forEach>

</tbody>
</table>
<input type="hidden" id="currentPage" value="${map.currentPage }">
<input type="hidden" id="totalPage" value="${map.totalPage }">
<div class="col-xs-6 col-sm-4" id="divbutt">
 	<button onclick="prev()" class="btn btn-info" >上一页</button>  <button onclick="next()" class="btn btn-info">下一页</button>
 共<span >${map.totalPage}</span>页
  一共<span>${map.total}</span>条
  
  </div >
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
		window.location.href="supplier_info?page="+page; 
		
	}
	//下一页设置
	function next() {
		page++;
		if (page>totalPage) {
			page=totalPage;
		}
		window.location.href="supplier_info?page="+page; 
	}
	




	  function demo13() {
		var message = $("#message").val();
		
		$.ajax({
			type:"post",
			url:"Q_SupSelectMessage",
			data:{"message":message}, 
			dataType:"text",
			success:function(result){
				if (result=="err") {
					alert("查询条件不能为空")
				}else {
					alert("查询成功");
					$("#divbutt").hide();
					$("#tab1 tr td").remove();
					var supplier =eval(result);
					$(supplier).each(function(i,m) {
						alert(m.supplierId);
						$("#tab1").append(
							"<tr>"+"<td>"+m.company+"</td>"+
							"<td>"+m.wner+"</td>"+
							"<td>"+m.telephone+"</td>"+
							"<td>"+m.adress+"</td>"+
							"<td>"+m.des+"</td>"+

							"<td>"+"<button type='button' class='btn btn-danger' id='button2' onclick='button2"+"("+m.supplierId +")"+"'>"+"删除"+"</button>"+
							"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+
							"<button type='button' class='btn btn-warning' data-toggle='modal' data-target='#myModal' onclick='button4"+"("+m.supplierId +")'>"+"修改"+"</button>"+"</td>"+
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
			var supplierId = m;
			
			$.ajax({
				type:"POST",
				url:"Q_deleteSupMessage",
				data:{"supplierId":supplierId}, 
				dataType:"text",
				success:function(result){
					alert("删除成功");
					window.location.reload(true);
					$("#tab1 tr td").remove();
					  var supplier =eval(result);
					 
					 $(supplier).each(function(i,m) {
						 
					$("#tab1").append(
							"<tr>"+"<td>"+m.company+"</td>"+
							"<td>"+m.wner+"</td>"+
							"<td>"+m.telephone+"</td>"+
							"<td>"+m.adress+"</td>"+
							"<td>"+m.des+"</td>"+
							"<td>"+"<button type='button' class='btn btn-danger' id='button2' onclick='button2"+"("+m.supplierId +")"+"'>"+"删除"+"</button>"+
							"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+"&nbsp;"+
							"<button type='button' class='btn btn-warning' data-toggle='modal' data-target='#myModal' onclick='button4"+"("+m.supplierId +")'>"+"修改"+"</button>"+"</td>"+
							"</tr>"
					)
						
						
					})   
					},
					error:function(){
						alert("异常情况，请刷新后重新登录");
					}
					 
					
				})
				
				
			} 
		} 
	
	function button4(q) {
		
		var supplier_id = q;
		$("#supplier_id1").val(supplier_id);
		
		
		 $.ajax({
			type:"POST",
			url:"Q_selectSupplier",
			data:{"supplier_id":supplier_id},
			 
			dataType:"json",
			success:function(result){
			
				var supplier = JSON.stringify(result);
				var json = eval("("+supplier+")");
				
				
				
				$("#company").val(json.company);
				$("#wner").val(json.wner);
				$("#adress").val(json.adress);
				$("#telephone").val(json.telephone);
				$("#des").val(json.des);
				
				 
			}
			
			
		})
		
		
		
	}


</script>


<!--修改模态框开始  -->
<form action="Q_SupUpdateByMess" method="post">
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
			<input type="hidden" id="supplier_id1" name="supplier_id" value="">
			<div class="modal-body">
				<div align="center">
						<table>
							<tr><td><span>公司名称</span></td>
							<td><span id="basic-addon1"></span> <input id="company" name="company" type="text" class="form-control" placeholder="公司名称" aria-describedby="basic-addon1" value="" ></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>公司经理</span></td>
							<td><span id="basic-addon1"></span> <input id="wner" name="wner" type="text" class="form-control" placeholder="公司经理" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>公司电话</span></td>
							<td><span id="basic-addon1"></span> <input id="telephone" name="telephone" type="text" class="form-control" placeholder="公司电话" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>公司地址</span></td>
							<td><span id="basic-addon1"></span> <input id="adress" name="adress" type="text" class="form-control" placeholder="公司地址" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>主营业务</span></td>
							<td><span id="basic-addon1"></span> <input id="des" name="des" type="text" class="form-control" placeholder="主营业务" aria-describedby="basic-addon1"></td></tr>
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
<form action="Q_SuppInsertByMess" method="post">
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
							<td><span id="basic-addon1"></span> <input id="company2" name="company2" type="text" class="form-control" placeholder="公司名称" aria-describedby="basic-addon1" value="" ></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>公司经理</span></td>
							<td><span id="basic-addon1"></span> <input id="wner2" name="wner2" type="text" class="form-control" placeholder="公司经理" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>公司电话</span></td>
							<td><span id="basic-addon1"></span> <input id="telephone2" name="telephone2" type="text" class="form-control" placeholder="公司电话" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>公司地址</span></td>
							<td><span id="basic-addon1"></span> <input id="adress2" name="adress2" type="text" class="form-control" placeholder="公司地址" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div align="center">
						<table>
							<tr><td><span>主营业务</span></td>
							<td><span id="basic-addon1"></span> <input id="des2" name="des2" type="text" class="form-control" placeholder="主营业务" aria-describedby="basic-addon1"></td></tr>
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