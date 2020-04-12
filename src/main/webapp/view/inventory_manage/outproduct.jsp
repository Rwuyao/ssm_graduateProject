<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ page isELIgnored ="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./lib/bootstrap.min.css"></link>
<script type="text/javascript" src="./lib/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./lib/bootstrap.js"></script>
<script  language="javascript" type="text/javascript" src="./My97DatePicker/WdatePicker.js"> </script>
</head>
<script type="text/javascript">

function set (){
	$("#sb").prop("checked", false);
	$("#vc").prop("checked", false);
	
}

function set2 (){
	$("#sb2").prop("checked", false);
	$("#vc").prop("checked", false);
}

function set3 (){
	$("#sb").prop("checked", false);
	$("#sb2").prop("checked", false);
	
}



/* function outproduct(){
	var cnumber=$("#dd1").val()
	var number=$("#dd2").val()
	var name=$("#dd3").val()
	
	$("#tab tr:not(:first)").remove();
	
	$.ajax({
		type:"post",
		url:"outproduct",
		data:{
			cnumber:cnumber,
			number:number,
			name:name
		},
	dataType:"text",
	scriptCharset:"utf-8",
	success:function(ret){
		
		alert(ret)
		var list=eval(ret);
		$(list).each(function(i,m){ 
	 alert(m.audit.time) 
			$("#tab").append(
					
					"<tr>"+
					"<td> <br>"+ m.audit.auditId +"</td>"+
					"<td> <br><img src='/tu/"+m.picture +"' style= 'width: 80px; height: 70px'  / ></td>"+
					"<td> <br>"+ m.audit.productName +"</td>"+
					"<td> <br>"+ m.number+"</td>"+
					"<td> <br>"+ m.audit.peopleSend +"</td>"+
					"<td> <br>"+ m.audit.price +"</td>"+
					"<td> <br>"+ m.audit.number +"</td>"+
					"<td> <br><a href='''>"+m.audit.custmer+"</a></td>"+ 
					 "<td> <br>"+(m.audit.time)+".Format (yyyy-MM-dd HH:mm:ss)</td>"+  
					"</tr>"	
					)
		
		})
		
	}	
	})
	
	
	
}
 */
 function set8(){
		var info="${info}"
		if(info==1){
			alert("服务器异常，请稍后在试")
		}
		
		
	}

 
</script>


<base href="<%=basePath%>" />
<body onload="set8()">
<form action="selectoutproduct"  method="post">
	<div class="col-md-10">
	<br>
	
		<table class="col-md-10">
			<tr>
		
				<td class="col-md-3 "><h4>根据销售状态查看：</h4> 已出库：   <input onclick="set2()" name="sta1"  id="sb" <c:if test="${info eq '1' }" >checked="checked"</c:if>  value="3" type="radio"   />
					 &nbsp &nbsp 未出库<input  id="sb2" onclick="set()" <c:if test="${info eq '2' }" >checked="checked"</c:if>
					name="sta2" value="1" type="radio" />
					&nbsp &nbsp 全部<input id="vc" <c:if test="${info eq '3' }" >checked="checked"</c:if>  onclick="set3()" type="radio" /></td> 
					
				<td>
					<h4>根据时间查看：</h4> <input type="text" placeholder="选择开始时间" name="time1" value="${time1 }"  onfocus="WdatePicker()" />
					 <input type="text" name="time2"   placeholder="选择结束时间"   value="${time2}"  onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd '})"/>
				</td>
			</tr>
			<br>

			<tr>
				<td><button class="btn btn-info"  type="submit" >查询</button>  </td>
			</tr>
		</table>





	</div>
</form>

	


	<div class="col-md-12">
	
	<br>
	<hr>
		<table  id=tab class="table table-hover table-bordered">
			<tr class="info" style="color: red">
				
				<td style="width: 30px">编号</td>
				<td>图片</td>
				<td>型号</td>
				<td>库存</td>
				<td>销售人员</td>
				<td style="width: 100px">价格</td>
				<td>数量</td>
				<td style="width: 100px">客户</td>
				<td>订单号</td>
				<td style="width: 200px">时间</td>
			
				<td align="center" style="width: 150px">操作</td>
			</tr>
			<c:forEach items="${ list}" var="list">
				<tr>
					
					<td><br> ${list.auditId}</td>
					<td><img alt="加载中" src="/tu/${list.product.picture}"
						style="width: 80px; height: 80px"></td>
					<td><br> ${list.productName}</td>
					<td ><br> <font color=red>${list.product.number}台</font> </td>
					<td><br> ${list.peopleSend}</td>
					<td><br> ${list.price}</td>
					<td><br><font color=red> ${list.number}台</font> </td>
					<td><br> <a
							href="https://www.huawei.com/cn/?ic_medium=direct&ic_source=surlent">${list.custmer}</a></td> 
						<td><br>${list.orderId}</td>	
							
					<td><br> <fmt:formatDate value='${list.time}'
								pattern='yyyy-MM-dd HH:mm:ss' /></td>
				
					<td><br>
						<c:if test="${list.sta eq '3'}">
						<font>已出库</font>
						</c:if>
						<c:if test="${list.sta eq '1'}">
						<c:if test="${list.product.number < list.number}">
							<form action="apllyui" method="post">
						<button class="btn btn-default" type="button" >库存不足</button>
					
						<input type="hidden" id=dd3  name=name value="${list.productName} ">
						<button class="btn btn-danger" type="submit" >申请入库</button>
						</form>
						</c:if><c:if test="${list.product.number >=  list.number}">
						
						<form action="outproduct" method="post">
						<input type="hidden" id=dd1 name=auditId value= "${list.auditId}">
						<input type="hidden" id=dd1 name=cnumber value= "${list.product.number}">
						<input type="hidden" id=dd2 name=number value="${list.number}">
						<input type="hidden" id=dd3  name=name value="${list.productName} ">
						
						<button class="btn btn-danger" type="submit" >出库</button></form> 
						</c:if>
						
						
						</c:if>
							
								
							
							</td>
				</tr>
			</c:forEach>
		</table>
	</div>











</body>
</html>