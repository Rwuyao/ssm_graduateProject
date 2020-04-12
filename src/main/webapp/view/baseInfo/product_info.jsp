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
<p class="lead">产品信息</p><br>


<form class="form-inline">
  
  <div class="form-group">
   
    <input type="text" class="form-control" name="message" id="message" placeholder="输入查询内容" >
  </div>
  <button type="button" class="btn btn-info"  onclick="demo13()">搜索</button>

</form>

<table class="table table-hover" border="1px" id="tab1">
<tbody align="center">
<tr>
<th style="text-align: center;">产品编号</th><th style="text-align: center;">产品名称</th><th style="text-align: center;">产品品牌</th><th  style="text-align: center;">产品分类</th><th style="text-align: center;">产品价格</th><th style="text-align: center;">产品库存</th><th style="text-align: center;">产品图片</th><th style="text-align: center;">产品描述</th><th style="text-align: center;">供应商</th><th style="text-align: center;">上市时间</th>

</tr>
<c:forEach items="${alist.list}" var="list">
<tr>
<td>${list.proId }</td><td>${list.name }</td><td>${list.bround }</td><td>${list.catagorg }</td><td>${list.price }</td><td>${list.number }</td><td>${list.picture }</td><td>${list.des }</td><td>${list.company }</td><td><fmt:formatDate value='${list.date }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
</tr>
</c:forEach>
</tbody>
</table>
<input type="hidden" id="currentPage" value="${alist.currentPage }">
<input type="hidden" id="totalPage" value="${alist.totalPage }">
<input type="hidden" id="currentPage2" value="${currentPage }">
<input type="hidden" id="totalPage2" value="${totalPage }">
<input type="hidden" id="selectMess" value="">

<div class="col-xs-6 col-sm-4" id="divbutt">
 	<button onclick="prev()" class="btn btn-info" >上一页</button>  <button onclick="next()" class="btn btn-info">下一页</button>
 共<span >${alist.totalPage}</span>页
  一共<span>${alist.total}</span>条
  
  </div >
  <div class="col-xs-6 col-sm-4" id="divbutt2">
  
  </div>
</body>
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
		window.location.href="product_info?page="+page; 
		
	}
	//下一页设置
	function next() {
		page++;
		if (page>totalPage) {
			page=totalPage;
		}
		window.location.href="product_info?page="+page; 
	}
	
//--------------------------查询分页	
//当前页
var page2=$("#currentPage2").val();
//总页数
var totalPage2=$("#totalPage2").val();	

var selectMess ="苹果手机";
	function prev2() {
		/* alert(selectMess)
		  page2--;
		if (page2==0) {
			page2=1;
		}
		window.location.href="Q_selectMesssage?page="+page2+"&message="+selectMess;   */
		
	}
	function next2() {
		/* page2++;
		if (page2>totalPage2) {
			page2=totalPage2;
		}
		window.location.href="Q_selectMesssage?page="+page2+"&message="+selectMess;  */
	}










	function demo13() {

		$("#divbutt").hide();
		var message = $("#message").val();
		alert(message);
		$("#selectMess").val(message);
		$.ajax({
			type:"POST",
			url:"Q_selectMesssage",
			data:{
				"message":message
			}, 
			dataType:"json", 
			success:function (result){
				 
				if (result=="erro") {
					alert("查询条件不能为空");
				}else{
					
					alert("查询成功");
					alert(result.total+"条数据");
					var s1 = result.totalPage +""; 
				
					/* $("#totalPage2").val(s1);
					$("#currentPage2").val(result.currentPage); */
					$("#tab1 tr td").remove();
					jQuery.each(result.list,function(i,m){
						 
						$("#tab1").append(
							"<tr>"+"<td>"+m.proId+"</td>"+"<td>"+m.name+"</td>"+"<td>"+m.bround+"</td>"+"<td>"+m.catagorg+"</td>"+"<td>"+m.price+"</td>"+
							"<td>"+m.number+"</td>"+"<td>"+"</td>"+"<td>"+m.des+"</td>"+"<td>"+m.company+"</td>"+
							"<td>"+
							m.date
							+ 
								"</td>"+
							"</tr>"
						
				 		)   
				 	
					})
					/* var MyDiv =document.getElementById("divbutt2");
					var button = document.createElement("input"); 
					button.setAttribute("type", "button");
					button.setAttribute("value", "上一页");
					button.setAttribute("id", "id1");
					button.setAttribute("class", "btn btn-info");
					button.setAttribute("onclick", "prev2()");
					MyDiv.appendChild(button)
					var MyDiv =document.getElementById("divbutt2");
					var button = document.createElement("input"); 
					button.setAttribute("type", "button");
					button.setAttribute("value", "下一页");
					button.setAttribute("id", "id2");
					button.setAttribute("class", "btn btn-info");
					button.setAttribute("onclick", "next2()");
					MyDiv.appendChild(button); */
					
					 
				 /* 	$("#divbutt").append(
				 			
				 				  "<button onclick='prev()' class='btn btn-info'>"+"上一页"+"</button>"+
				 				  "<button onclick='next()' class='btn btn-info'>"+"下一页"+"</button>"+
				 				  "共"+"<span >"+result.total+"</span>"+"页"+"一共"+"<span>"+result.totalPage+"</span>"+"条"
				 		
				 		)  */
					}
				} 
			
			
			
			
		}) 
		

		}
			　　　　 　　　  　  　   
					
				 		
			 	 		
					
					
			 
				
				
				
	


</script>

</html>