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
			var selects2=myselect.options[index].value;
			
			window.location.href="goOutCatagorg?catagorg="+selects2;
			
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
                        <label ><font size="2">选择类型:</font></label>
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
                </div>
                <div class="search-button">
                	<input class="button" type="button" value="搜索" onclick="explore()" style="width: 100px;height:32px; margin-top: 0px;margin-left: 10px" />
                </div>
                <div class="pull-right">
                	<input class="button" type="button" value="退出" onclick="exit()" style="width: 100px;height:32px; margin-top: 0px;margin-left: 10px" />
                </div>
             </div>
             <div >
             
                
                <table class="col-sm-12 table-bordered table-hover">
                	<tr>
                		<th>商品名称</th>
                		<th>出库原因</th>
                		<th>成本价</th>
                		<th>售价</th>
                		<th>售出数量</th>
                		<th>总成本</th>
                		<th>总售价</th>
                		<th>总利润</th>
                	</tr>
                	<c:forEach items="${auditList }" var="audit">
                	<tr>
                		<td>${audit.productName}</td>
                		<td>${audit.becauser}</td>
                		<td>${audit.goodsCost }</td>
                		<td>${audit.price}</td>
                		<td>${audit.number}</td>
                		<td>${audit.statisticCost}</td>
                		<td>${audit.statisticPrice }</td>
                		<td>${audit.staticticProfit }</td>
                	</tr>
                	</c:forEach>
                	<tr>
                		<td colspan="6"><center><h3>总成本价</h3></center></td>
                		<td colspan="2"><center><font size="2" color="red">${totalCost }</font></center></td>
                	</tr>
                	<tr>
                		<td colspan="6"><center><h3>总售价</h3></center></td>
                		<td colspan="2"><center><font size="2" color="red">${totalPrice }</font></center></td>
                	</tr>
                	<tr>
                		<td colspan="6"><center><h3>总利润</h3></center></td>
                		<td colspan="2"><center><font size="2" color="red">${totalProfit }</font></center></td>
                	</tr>
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