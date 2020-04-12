
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored ="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="./lib/bootstrap.min.css"></link>
<script type="text/javascript" src="./lib/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./lib/bootstrap.js"></script>
<script  language="javascript" type="text/javascript" src="./My97DatePicker/WdatePicker.js"> </script>

<title>表格</title>
<script>

</script> 
</head>



<body  >

	<div class="col-md-12">
	<br>
	<hr>
	<h1>仓库进出库记录</h1>
		<table class="table table-hover table-bordered">
			<tr class="info" style="color: red">
				
				<td style="width: 30px">编号</td>
				<td>产品名字</td>
				<td>数量</td>
				<td>状态</td>
				<td>操作人</td>
				<td>时间</td>
				<td>申请单号</td>
		
			</tr>
			<c:forEach items="${ list}" var="list">
				<tr>
					<td><br> ${list.id}</td>
					<td><br> ${list.name}</td>
					<td><br> ${list.number}</td>
					<td><br> ${list.state}</td>
					<td><br> ${list.persson}</td>
					<td><br> <fmt:formatDate value='${list.date}' pattern='yyyy-MM-dd ' /></td>
								

					<td ><br> ${list.audit_id} </td>
				
          
				</tr>
			</c:forEach>
		</table>
	</div>










</body>

</html>
