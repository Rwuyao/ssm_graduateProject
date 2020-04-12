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
<link rel="stylesheet" href="<%=basePath%>/lib/bootstrap.min.css"></link>
<link rel="stylesheet" href="<%=basePath%>/lib/bootstrap.css"></link>
<script type="text/javascript" src="<%=basePath%>/lib/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/lib/jquery-3.4.1.js"></script>
<script type="text/javascript" src="<%=basePath%> /lib/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath%> /lib/bootstrap.min.js"></script>
<title>Insert title here</title>
<script >
function sum(){
	

	$("#cc option:not(:first)").remove();
	$.ajax({
		type:"post"	,
		url:"qureysupplier",
		dataType:"json",
		scriptCharset:"utf-8",
		success:function(ret){
			var list=eval(ret)
			$(list).each(function(i,m){
				$("#cc").append(
						" <option value= "+m.supplierId+" >"+m.company+"</option>"
				)
				
			})
			
			
		}
	})
	
	var auditId=$("#ind1").val()
	$.ajax({
		type:"post",
		url:"addproduct",
		data:{
			auditId:auditId
		},
		dataType:"json",
		scriptCharset:"UTF-8",
		success:function(ret){
			
			var audit=eval(ret)
			if(ret){
				 $ (audit).each(function(i,m){
					 var price=parseInt(m.price)
					 var number=parseInt(m.number)
					 var sprice=price/number
					 var audit=m.auditId
						$("#ind4").val(sprice)
						$("#ind2").val(m.productName)
						$("#ind3").val(m.number)
						$("#iidd").val(audit)
						
					}) 
			}else{  alert("请输入正确的申请单号")
				
			}
			
	
			
		}
		
	})
	
	
	
	
}

function info(){
	
	
	         
						alert("你不能修改当前数据！！")
	
}




function add(){
	
	
	
	var name=$("#ind2").val()
	var number=$("#ind3").val()
	var price=$("#ind5").val()
	var supplierId=$("#cc").val()
	var picture=$("#pp").val()
	var cost=$("#ind4").val()
	var bround=$("#ind8").val()
	var catagorg=$("#ind9").val()
	var des=$("#ind10").val()
	
	$.ajax({
		type:"post",
		url:"addpro",
		data:{
			name : name,
			number : number,
			price : price,
			supplierId : supplierId,
			picture : picture,
			cost:cost,
			bround:bround,
			catagorg:catagorg,
			des:des
		},
	   datatype:"json",
	   scriptCharset:"utf-8",
	   success:function(){
		  window.location.href='view/inventory_manage/addCG.jsp'
		   },
		
		
	})
	
	
	
	
}

 




</script>

</head>
<base href="<%=basePath%>" />
<body>

<form action="addpro " method="post">
	<div align="center">
	<div style="width: 800px">
	<div style="background-color: #0097e6;height: 120px;width: 800px">
	<div></div>
	<br>
	<h1 >产品入库</h1>
	
	</div>
	<div  style="background-color: #b3e4ff;height: 700px;width: 800px">
	      <br >
		<br >
		
	<div align="center">
	 
	
    <div class="input-group col-md-5">
   
    <span id="dd" ></span>
    <span class="input-group-addon" id="basic-addon1" >申请单号</span> 
      <input  id=ind1 type="text"  name="number" class="form-control" placeholder="请输入申请单号" aria-describedby="basic-addon1" onblur="sum()">
    </div>
    <br>
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1" >型号</span> 
      <input id=ind2  type="text" name="name" class="form-control" placeholder="请输入型号"  valu="" aria-describedby="basic-addon1" onmousedown="info()">
    </div>
     <br>
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1" >数量</span> 
      <input id=ind3  type="text" name="number" class="form-control" placeholder="请输入数量" valu=""  aria-describedby="basic-addon1" onmousedown="info()">
    </div>
     <br>
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1" >成本价</span> 
      <input id=ind4  type="text" name="cost" class="form-control"  valu=""    placeholder="请输入成本价"  aria-describedby="basic-addon1" onmousedown="info()">
    </div>
    <br>
     
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1" >售价</span> 
    
    <input type="hidden" value="" id="iidd" name="audit_id">
    
      <input id=ind5  type="text" name="price" class="form-control" placeholder="请输入售价" valu=""  aria-describedby="basic-addon1" >
    </div>
     <br>
     
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1" >品牌</span> 
      <input id=ind8 type="text" name="bround" class="form-control" placeholder="请输入品牌" valu=""  aria-describedby="basic-addon1" >
    </div>
     <br>
     
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1" >描述</span> 
      <input  id=ind10 type="text" name="des" class="form-control" placeholder="请输入描述" valu=""  aria-describedby="basic-addon1" >
    </div>
    
    <br>
     
    <div class="input-group col-md-5">
    <span class="input-group-addon" id="basic-addon1" >类别</span> 
    <select name="catagorg" id=ind9>
   <option value="手机">手机</option>
    <option value="配件">配件</option>
     <option value="包装">包装</option>
      
     </select>
    </div>
     
    <br>
     <div id=dddd class="input-group col-md-5">
     
    <span  class="input-group-addon" id="basic-addon1">上传图片</span> 
      <input id=pp type="file"  name="picture"  >
  
      
    
    </div>
    
    <br>
    <div class="input-group col-md-5">
    <span   class="input-group-addon" id="basic-addon1">供应商</span> 
      <select  id=cc  name="supplierId"  >
    
      <option value=0 >请选择供应商</option>
      
     
  
      </select>
    </div>
   
    
     <br>
   
    <div>
     <button type="button" class="btn btn-success"  onclick="add()" >确认入库</button>
  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp

                      <button type="button" class="btn btn-danger"  onclick="location.href='allGoods'">取消入库</button>
	
	
	
	</div>
	
	</div>
	
	
	</div>

		



	</div>

</form>



</body>
</html>