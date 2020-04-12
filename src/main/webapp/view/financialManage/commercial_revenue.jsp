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
		 
	$("#select_type option").each(function(){
        var select_val = $('#select_value').val();
        var debit_id = $(this).val();
       // console.log(debit_id);
        if(select_val == debit_id){
            $(this).attr('selected','selected');
        }
    });


		function explore(){
			
/* 			1:拿到select对象： var myselect=document.getElementById(“test”);

			2：拿到选中项的索引：var index=myselect.selectedIndex ; // selectedIndex代表的是你所选中项的index

			3:拿到选中项options的value： myselect.options[index].value;

			4:拿到选中项options的text： myselect.options[index].text; */
			var myselect=document.getElementById("sel1");
			var index=myselect.selectedIndex;
			var timeType=myselect.options[index].value;
			
			var myselect1=document.getElementById("sel2");
			var index1=myselect1.selectedIndex;
			var goodsType=myselect1.options[index1].value;
			alert(timeType+" "+goodsType);
			var hf="businessValue?timeType="+timeType+"&goodsType="+goodsType;
			window.location.href=hf;
			
			//alert(selects2);
/* 			$.ajax({
				type:"post",
				url:"goInven",
				date:{
					catagorg:selects2
				},
				success:function(result){
					if(result=="success"){
						window.location.href="commercial_cost?catagorg="+selects2;
					}
				}
				
			}); */
			
			
		}
		
		function exit(){
			top.window.location.href="main.jsp";
		}
	</script>
</head>

<body>
<div id="container">
	<div id="hd"></div>
    <div id="bd">
    	<div id="main">
        	<div class="search-box ue-clear">
            	<div class="search-area">
                   
                    <div class="kv-item ue-clear">
                        <label>选择时间段:</label>
                        <div class="kv-item-content">
                            <select id="sel1">
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
                    </div>
                    <div class="kv-item ue-clear">
                        <label>选择类别:</label>
                        <div class="kv-item-content">
                            <select id="sel2">
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
	                <div class="search-button" style="margin-left: 200px">
	                	<input class="button" type="button" value="搜索一下" onclick="explore()" />
	                </div>
                </div>

                <div class="pull-right">
                    <input class="button" type="button" value="退出" onclick="exit()" />
                </div>
             </div>
             <div >
             
                
                <table class="col-sm-12 table-bordered table-hover">
                	<tr>
                		<th>商品名称</th>
                		<th>售出总成本</th>
                		<th>售出总金额</th>
                		<th>剩余数量</th>
                		<th>所赚利润</th>
                	</tr>
                	<c:forEach items="${goodList }" var="good">
                	<tr>
                		<td>${good.goods_name}</td>
                		<td>${good.goodsTotalCost}</td>
                		<td>${good.goodsTotalPrice }</td>
                		<td>${good.freeNumber}</td>
                		<td>${good.goodsTotalProfit}</td>
                	</tr>
                	</c:forEach>
                </table>

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

</html>