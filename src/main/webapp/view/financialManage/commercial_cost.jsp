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
		    var mohu=document.getElementById("mohu").value;	
			//alert("mohu="+mohu+" selects1="+selects1);
			window.location.href="commercial_cost_1?catagorg="+selects1+"&mohu="+mohu;			
			
		}
		
		function exit(){
			top.window.location.href="main.jsp";
		}
	</script>
</head>

<body>



 <div id="container" >
	<div id="hd" ></div>
    <div id="bd" >
    <div id="main" >
              <div class="search-box ue-clear">
            	<%-- <div class="search-area" >
                   
                    <div class="kv-item ue-clear" style="margin-left: 500px">
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
                    </div> --%>
                    <div class="kv-item ue-clear" >
                        <label>选择类别:</label>
                        <div class="kv-item-content">
                            <select id="sel1">
                           	   <c:forEach items="${broundList }" var="bround">
                            		<c:if test="${bround==catagorg}">
										<option  value="${bround}"
										selected="selected">${bround}</option>
									</c:if>
									<c:if test="${bround!=catagorg}">
										<option value="${bround}">${bround}</option>
									</c:if>
								</c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="kv-item ue-clear" >
                        <label>模糊查询:</label>
                        <div class="kv-item-content">
                            <input  type="text" style="width: 398px;height: 28px" placeholder="自定义检索" id="mohu" value="${mohu}"/>
                        </div>
                    </div>
	                <div class="search-button" style="margin-left: 200px">
	                	<input class="button" type="button" value="搜索一下" onclick="explore()" />
	                </div>

                </div>

              </div>  
             
             <hr />
             
              <div class="table" style="width: 100%;">
             <div class="table" style="width: 100%;">
             	<div class="opt ue-clear">
             	<span class="optarea">
                        <%-- <a href="<%=basePath%>view/financialManage/goInInventoryMain.jsp" class="add"> --%>
                        <a href="goInInventoryMain_start" class="add">
                            <i class="subnav-icon"></i>
                            <span class="text">入库统计</span>
                        </a>
                        <a href="goOutInventoryMain_start" class="delete">
                            <i class="subnav-icon"></i>
                            <span class="text">出库统计</span>
                        </a>
                        <span class="pull-right">
                        	<a href="javascript:void(0)" onclick="exit()">退出</a>
                        </span>
                        

                    </span>
                    
                   </div>
             </div> 
            <!--********************************************************************************************************* -->
            
    
    	
          
                
                <table class="col-sm-12 table-bordered table-hover">
                	<tr>
                		<th><font size="3" color="red">商品ID</font></th>
                		<th><font size="3" color="red">商品名称</font></th>
                		<th><font size="3" color="red">商品类别</font></th>
                		<th><font size="3" color="red">商品成本价</font></th>
                		<th><font size="3" color="red">商品销售价</font></th>
                		<th><font size="3" color="red">供应商ID</font></th>
                		<th><font size="3" color="red">商品数量</font></th>
                	</tr>
                	<c:forEach items="${info.list}" var="product">
                	<tr style="height: 50px" class="success">
                		<td>${product.proId}</td>
                		<td>${product.name }</td>
                		<td>${product.bround }</td>
                		<td>${product.cost }</td>
                		<td>${product.price }</td>
                		<td>${product.supplierId }</td>
                		<td>${product.number}</td>
                	</tr>
                	</c:forEach>
                </table>
                <br />
                <button onclick="prev()" id="page1">上一页</button><button onclick="next()" id="page2">下一页</button>
				共<span >${info.totalPage }</span>页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 第<span >${info.currentPage}</span>页

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
<script  type="text/javascript">
		//当前页
		var page=${info.currentPage}
		//总页数
		var totalPage=${info.totalPage}
		
		console.log(page)
		//上一页
		function prev(){
			var myselect=document.getElementById("sel1");
			var index=myselect.selectedIndex;
			var selects2=myselect.options[index].value;
			var mohu=document.getElementById("mohu").value;	
			page--;
			if(page==0){
				page=1;
			} 
			window.location.href="commercial_cost_1?page="+page+"&catagorg="+selects2+"&mohu="+mohu;
		}
		//下一页
		function next(){
			var myselect=document.getElementById("sel1");
			var index=myselect.selectedIndex;
			var selects2=myselect.options[index].value;
			var mohu=document.getElementById("mohu").value;	
			console.log(mohu);
			page++;
			 if (page>totalPage){
				page=totalPage;
			}
			 if(mohu!=""&& nohu!=null){
				 window.location.href="commercial_cost_1?page="+page+"&catagorg="+selects2+"&mohu="+mohu;
			 }else{
				 window.location.href="commercial_cost_1?page="+page+"&catagorg="+selects2;
			 }
			
		}
</script>

</html>