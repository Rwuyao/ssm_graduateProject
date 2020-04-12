
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="./lib/bootstrap.min.css"></link>
<script type="text/javascript" src="./lib/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./lib/bootstrap.js"></script>

<title>表格</title>
<script >
function sum(){
	
	var dd1=$("#dd1").val()
	var dd2=$("#dd2").val()
	var dd3=dd1*dd2;
	
	 $("#dd3").attr("value",dd3) 
	/* document.getElementById("dd3").value=dd3;
	 两种方法都可以
	 */
	
	
}

function info(){
	alert("你只能通过改变产品数量或者单价来改变总价！！")
	
}</script>

</head>

<body>
<form action="aplly " method="post">
	<div align="center">
	<div style="width: 800px">
	<div style="background-color: #0097e6;height: 120px;width: 800px">
	<div></div>
	<br>
	<h1 >入库申请</h1>
	
	</div>
	<div  style="background-color: #b3e4ff;height: 500px;width: 800px">
	      <br >
		<br >
	<div align="center">
	 
	
    <br>
  
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1">产品名字</span>
    
      <input type="text" name="pname" class="form-control"  value="${name }"  placeholder="请输入产品名字" aria-describedby="basic-addon1">
    </div><br>
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1">品牌</span> 
     <input type="text"  class="form-control" placeholder="请输入品牌" aria-describedby="basic-addon1">
    </div><br>
    <div class="input-group col-md-5">
    <span  class="input-group-addon" id="basic-addon1" >价格</span>  
      <input  id=dd1  type="text" class="form-control" placeholder="请输入价格" aria-describedby="basic-addon1">
    </div><br>
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1" >数量</span> 
      <input  id=dd2 type="text"  name="number" class="form-control" placeholder="请输入数量" aria-describedby="basic-addon1" onblur="sum()">
    </div>
    <br>
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1" value="">总价</span> 
      <input id=dd3  type="text" name="price" class="form-control" placeholder="请输入总价" aria-describedby="basic-addon1" onkeydown="info()">
    </div>
    <br>
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1">供应商</span> 
      <select  name="supplierId" style="border-width: 10px">
      <c:forEach items="${list }" var="list">
      <option supplierId= ${list.supplierId} > ${list.company} </option>
      </c:forEach>
      </select>
    </div>
    <div>
    <br>
    <br>
     <button type="submit" class="btn btn-success">确认申请</button>
  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp

                      <button type="button" class="btn btn-danger"  onclick="location.href='allGoods'">取消申请</button>
	
	
	
	</div>
	
	</div>
	
	
	</div>

		



	</div>

</form>
</body>

</html>
