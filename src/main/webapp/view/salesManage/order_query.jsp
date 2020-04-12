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
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.grid.css" />
<link rel="stylesheet" href="./lib/bootstrap.min.css">
<script type="text/javascript" src="./lib/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./lib/bootstrap.js"></script>

</head>
<body>
<div id="container">
	<div id="hd"></div>
    <div id="bd">
   
    	<div id="main">
    	 <form action="queryOrderByInput" method="post">
        	<div class="search-box ue-clear">
            	<div class="search-area">
                    <div class="kv-item ue-clear">
                        <label>选择时间：</label>
                        <div class="kv-item-content ue-clear">
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="timeall" value="all" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">全部</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="timethree" value="three" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近3天</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="timeweek"  value="week"/>
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一周</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="timemonth" value="month"/>
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一月</span>
                            </span>
                           
                              <div class="col-lg-3">
    							<table>
    							<tr>
    							<td><input type="text" style="width:200px; height:26px;" class="form-control" name="inputOrderId" placeholder="输入订单号..."></td>
    							<td><input type="text" style="width:200px; height:26px;" class="form-control" name="inputMessage" placeholder="输入订单信息查询..."></td>
    							</tr>
    							</table>
    						</div>
    						
    					</div>
                    </div>
                   
                </div>
                <div class="search-button">
                	<input class="btn-group btn-group-xs" type="submit"  value="搜索" />
                </div>
                </form>
             
               <form action="queryOrderByCheckBox">
                <div align="right" class="kv-item ue-clear">
                <table>
                <tr>
                	<td> <label>选择状态：</label></td>
                	<td>
                	<select name="checkBoxName">
                		<option>待审核</option>
                		<option>审核中</option>
                		<option>审核通过</option>
                		<option>审核失败</option>
                	</select>
                	</td>
                	<td><button class="btn-group btn-group-xs" type="submit">查询</button></td>
                	</tr>
                		
                </table>
               
                			
                			
                </div> 
                </form>
                
              
                
                
             </div>
            
             
             
            	<div class="table">
                <div class="grid"></div>
              <!--   <div class="pagination"></div> -->
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

<script type="text/javascript">
	$('select').select();
	var head = [{
				label: '订单编号',
				width: 100,
			},{
				label:'产品名称',
				width: 150,
			},{
				label:'销售价格',
				width:150	
			},{
				label: '数量',
				width: 150	
			},{
				label: '经手人',
				width: 200
			},{
				label: '客户',
				width:100
			},{
				label: '审核状态',
				width:120	
			},{
				label: '备注',
				minWidth:100	
			},{
				label: '审核时间',
				width: 200
			}];
			
	
	var tbody = [
				
				<c:forEach items="${oList}" var="oList">
				
					["${oList.orderId}","${oList.productName}","${oList.price}","${oList.number}",
					 "${oList.people}","${oList.custmer}","${oList.state}","${oList.becauser}","<fmt:formatDate value='${oList.time }' pattern='yyyy-MM-dd HH:mm:ss'/>"
					
					],
					
				</c:forEach>		
				]
	

	
	
					
		$('.grid').Grid({
			thead: head,
			tbody: null,
			height:400,
			checkbox: {
				single:true	
			},
			operator: {
				type : "normal",
				width : 100	
			},
			sortCallBack : function(name,index,type){
				alert(name+","+index+','+type);
			}
			
		});
	
	$('.grid').Grid('addLoading');
	
	/// 模拟异步
	setTimeout(function(){
		$('.grid').Grid('setData',tbody, head);
	},100)
	
	
	$('.pagination').pagination(100,{
		callback: function(page){
			alert(page);	
		},
		display_msg: false
	});
	
	$('.search-box input[type=radio]').click(function(e) {
        if($(this).prop('checked')){
			if($(this).attr('data-define') === 'define'){
				$('.define-input').show();
			}else{
				$('.define-input').hide();
			}
		}
    });
</script>


	
	
<!-- 测试 -->
<a href="queryOrderByName?name='廖先生' ">测试</a>  
<a href="view/salesManage/testAutoQuery.jsp">百度搜索自动补全功能测试</a>
<!-- 测试 -->
	
</html>
