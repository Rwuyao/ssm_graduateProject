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



<body  >
<h1>未审核申请记录</h1>
	<table class="table table-hover table-bordered">
			<tr class="info" style="color: red">
				<td>申请编号</td>
				<td style="width: 120px">部门</td>
				<td>发送人</td>
				<td>第一审核人</td>
				<td>第二审核人</td>
				<td>状态</td>
				<td style="width: 250px">产品型号</td>
				<td>数量</td>
				<td>价格</td>
				<td>客户</td>
				<td>订单号</td>
				<td>时间</td>
					<td colspan=2>操作</td>
					
			</tr>
			<c:forEach items="${list }" var="list">
			
				<tr >
				<td>${list.auditId }</td>
				<td style="width: 30px">${list.depSend }</td>
				<td>${list.peopleSend }</td>
				<td>${list.firstCheck }</td>
				<td>${list. scondCheck}</td>
				<td>
				
				<c:if test="${ list.state eq '已通过'}">
				<font color="green">已通过</font>
				</c:if>
				
				<c:if test="${ list.state eq '审核中'}">
				<font color="blue">审核中</font>
				</c:if>
				
				<c:if test="${ list.state eq '未通过'}">
				<font color="red">未通过</font>
				</c:if>
				
				<c:if test="${ list.state eq '待审核'}">
				<font >待审核</font>
				</c:if>
				
				
				</td>
				<td style="width: 250px">${list.productName }</td>
				<td>${list.number }</td>
				<td>${list. price}</td>
					<td>${list.custmer }</td>
				<td>${list.orderId }</td>
				
			    <td> 
                        <fmt:formatDate value="${list.time}" pattern="yyyy-MM-dd "/>  </td>
                        	<td >
                        
                        	<button   type="button"  onclick="location.href='yespass?id=${list.auditId }'"  class="btn btn-success" >通过</button>
                        	<button    type="button"  onclick="location.href='nopass?id=${list.auditId }'" class="btn btn-danger">   不通过</button>
                        
                        	
                        	
                        	
	
			</tr>
</c:forEach>
</table>


<h1>已审核申请记录</h1>
<table class="table table-hover table-bordered">
			<tr class="info" style="color: red">
				<td>申请编号</td>
				<td style="width: 120px">部门</td>
				<td>发送人</td>
				<td>第一审核人</td>
				<td>第二审核人</td>
				<td>状态</td>
				<td style="width: 250px">产品型号</td>
				<td>数量</td>
				<td>价格</td>
				<td>客户</td>
				<td>订单号</td>
				<td>时间</td>
			
					
			</tr>
			<c:forEach items="${list2 }" var="list">
			
				<tr >
				<td>${list.auditId }</td>
				<td style="width: 30px">${list.depSend }</td>
				<td>${list.peopleSend }</td>
				<td>${list.firstCheck }</td>
				<td>${list. scondCheck}</td>
				<td>
				
				<c:if test="${ list.state eq '已通过'}">
				<font color="green">已通过</font>
				</c:if>
				
				<c:if test="${ list.state eq '审核中'}">
				<font color="blue">审核中</font>
				</c:if>
				
				<c:if test="${ list.state eq '未通过'}">
				<font color="red">未通过</font>
				</c:if>
				
				<c:if test="${ list.state eq '待审核'}">
				<font >待审核</font>
				</c:if>
				
				
				</td>
				<td style="width: 250px">${list.productName }</td>
				<td>${list.number }</td>
				<td>${list. price}</td>
					<td>${list.custmer }</td>
				<td>${list.orderId }</td>
				
			    <td> 
                        <fmt:formatDate value="${list.time}" pattern="yyyy-MM-dd "/>  </td>
                       
			</tr>
</c:forEach>
</table>
</body>

</html>
