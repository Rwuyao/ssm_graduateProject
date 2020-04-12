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
    	     <form action="queryOrderById" method="post">
        	<div class="search-box ue-clear">
            	<div class="search-area">
                    <div class="kv-item ue-clear">
                        <div class="kv-item-content ue-clear">
                              <div class="input-group" >
    							<div class="input-group" >
    							<input type="text" name="keyword" id="keyword"  onkeyup="getMoreContents()" onfocus="getMoreContents()" onblur="clearContent()" style="width:200px; height:26px;" placeholder="输入具体订单号查询...">
											<div id="popDiv">
												<table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
													<tbody id="content_table_body">
														<!-- 动态数据在这里显示 -->

													</tbody>
												</table>
											</div>
										</div>
    							
    							
    							
    							
    							
    							
    							</div></div>
                            <div class="row">
                            
                            
  						

                           
                        </div>
                        
                        
                    </div>
                    <div class="kv-item ue-clear">
                        
                    </div>
                </div>
                <div class="search-button">
                	<input class="btn-group btn-group-xs" type="submit" value="搜索" />
                </div>
               
             </div></form>
             
             
             
            <div class="table">
            	<div class="opt ue-clear">
                	<span class="sortarea">
                    	<span class="sort">
                        	
                            <span class="name">
                            	<i class="icon"></i>
                                
                            </span>
                        </span>
                        
                        <i class="list"></i>
                        <i class="card"></i>
                    </span>
                	<span class="optarea">
                        <a href="javascript:;" data-toggle="modal" data-target="#model" class="add">
                            <i class="icon"></i>
                            <span class="text">添加</span>
                        </a>
                        <a href="javascript:;" onclick="deleteAll()" class="delete">
                            <i class="icon"></i>
                            <span class="text">删除</span>
                        </a>
                        
                        <a href="javascript:;" class="statistics">
                            <i class="icon"></i>
                            <span class="text">统计</span>
                        </a>
                        
                     
                    </span>
                </div>
                
                <div class="grid"></div>
                
               <!--  <div class="pagination" id="pagination"></div> -->
                
                
            </div>
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
			
	var oper = [
	            {label:'编辑',onclick:function(){
						alert('编辑');
				}},
				
				{label:'删除',onclick: function (){
					
					alert('删除')
				}}
				]
	var tbody = [
				
				<c:forEach items="${oList}" var="oList">
				
					["${oList.orderId}","${oList.productName}","${oList.price}","${oList.number}",
					 "${oList.people}","${oList.custmer}","${oList.state}","${oList.becauser}","<fmt:formatDate value='${oList.time }' pattern='yyyy-MM-dd HH:mm:ss'/>",
					 [
			            {label:'<span type="button" data-toggle="modal" data-target="#updatemodal">编辑</span>',
			            	onclick:function (){
			            	var orderId = "${oList.orderId}";
			            	var productName = "${oList.productName}";
			            	var price = "${oList.price}";
			            	var number = "${oList.number}";
			            	var people = "${oList.people}";
			            	var custmer = "${oList.custmer}";
			            	var becauser = "${oList.becauser}";
			            	
			            	$('#updateOrderId').val(orderId);
			        		$('#updateproductName').val(productName);
			        		$('#updateprice').val(price);
			        		$('#updatenumber').val(number);
			        		$('#updatepeople').val(people);
			        		$('#updatecustmer').val(custmer);
			        		$('#updatebecauser').val(becauser);
			        		
			            		
						}},
						
						{label:'删除',onclick: function (orderId){
								orderId = ${oList.orderId};
								var ss = confirm("确定要删除吗？")
								if (ss) {
									$.ajax({
										  method: "post",
										  url:"deleteOrder",
										  data : {
											  orderId:orderId
										  },
										  dataType:"text",
										  success : function(map) {
											 alert("成功删除");
											 window.location.reload();
										  },error:function(code){ 
											  alert("删除失败")
										  } 
										
							});
								}else{
									window.location.reload();
								}
								
								
						}}
						]
					 
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

<script>
function getMoreContents() {
    var keyword = document.getElementById("keyword").value;
    if (keyword == "") {
        clearContent();
        return;
    } else {
        var ajax = new XMLHttpRequest();
        var url = "autoPrompting?keyword=" + keyword;
        ajax.open("GET", url, true);
        ajax.send(null);
        ajax.onreadystatechange = function() {
            if (ajax.readyState == 4) {
                if (ajax.status == 200) {
                    var result = ajax.responseText;
                    insertContent(result);
                }
            }
        }
    }
}
function insertContent(content) {
    clearContent();
    setLocation();
    var json = JSON.parse(content);
  
    var len = json.length;
    for (var i = 0; i < len; i++) {
        var value = json[i];
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.setAttribute("bgcolor", "#FFFAFA");
        td.setAttribute("border", "0");
        td.onmouseover = function() {
            this.className = 'mouseOver';
        };
        td.onmouseout = function() {
            this.className = 'mouseOut';
        };
        td.onclick = function() {
            // document.getElementById("keyword").value=this.;
        };
        var text = document.createTextNode(value);
        td.appendChild(text);
        tr.appendChild(td);
        document.getElementById("content_table_body").appendChild(tr);
    }

}

function clearContent() {
    var popNode = document.getElementById("popDiv");
    popNode.style.border = "none";
    var contentNode = document.getElementById("content_table_body");
    var len = contentNode.childNodes.length;
    for (var i = len - 1; i >= 0; i--) {
        contentNode.removeChild(contentNode.childNodes[i]);
    }
}
function setLocation(){
    var inputNode = document.getElementById("keyword");
    var width = inputNode.offsetWidth;
    var left = inputNode["offsetLeft"];
    var top = inputNode.offsetHeight+inputNode["offsetTop"];
    var popNode = document.getElementById("popDiv");
    popNode.style.border = "gray 0.5px solid";
    popNode.style.width = width+"px";
    popNode.style.top = top+"px";
    popNode.style.left = left+"px";
    document.getElementById("content_table").style.width=width+"px";
    
}


</script>

	<!-- 新增订单模态框 -->
<form action="addOrder" method="post">
<div>
	<div class="modal fade" id="model" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">新增订单</h4>
				</div>
				<div class="modal-body">


					<div align="center">
						<table>
							<tr><td><span>产品名称</span></td>
							<td><span id="basic-addon1"></span> <input id="product_name" name="product_name" type="text" class="form-control" placeholder="产品名称" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>

					<div align="center">
						<table>
							<tr><td><span>出售价格</span></td>
							<td><span id="basic-addon1"></span> <input id="price" name="price" type="text" class="form-control" placeholder="出售价格" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>购买数量</span></td>
							<td><span id="basic-addon1"></span> <input id="number" name="number" type="text" class="form-control" placeholder="购买数量" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>下单人员</span></td>
							<td><span id="basic-addon1"></span> <input id="people" name="people" type="text" class="form-control" placeholder="下单人员" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>顾客姓名</span></td>
							<td><span id="basic-addon1"></span> <input id="custmer" name="custmer" type="text" class="form-control" placeholder="顾客姓名" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>

						<br>
					<div align="center">
						<table>
							<tr><td><span>备注记录</span></td>
							<td><span id="basic-addon1"></span> <input id="becauser" name="becauser" type="text" class="form-control" placeholder="顾客姓名" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>

				</div>
				<div class="modal-footer">
					
					<button type="submit" class="btn btn-primary">新增</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					
				</div>
			</div>
		</div>
	</div>
</div></form>
	<!-- 新增订单模态框 -->
	
	<!-- 修改订单模态框开始 -->
<form action="renewOrder" method="post">
<div>
	<div class="modal fade" id="updatemodal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">修改订单</h4>
				</div>
				<div class="modal-body">

					<div align="center">
						<table>
							<tr><td><span>订单编号</span></td>
							<td><span id="basic-addon1"></span> <input id="updateOrderId" name="updateOrderId" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>

					<div align="center">
						<table>
							<tr><td><span>产品名称</span></td>
							<td><span id="basic-addon1"></span> <input id="updateproductName" name="updateproductName" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>销售价格</span></td>
							<td><span id="basic-addon1"></span> <input id="updateprice" name="updateprice" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>购买数量</span></td>
							<td><span id="basic-addon1"></span> <input id="updatenumber" name="updatenumber" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>销售人员</span></td>
							<td><span id="basic-addon1"></span> <input id="updatepeople" name="updatepeople" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>顾客姓名</span></td>
							<td><span id="basic-addon1"></span> <input id="updatecustmer" name="updatecustmer" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
				</div>
					
					<div align="center">
						<table>
							<tr><td><span>订单备注</span></td>
							<td><span id="basic-addon1"></span> <input id="updatebecauser" name="updatebecauser" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<div class="modal-footer">
					
					<button type="submit" class="btn btn-primary">确定</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					
				</div>
				</div>
				
				
			</div>
		</div>
	</div>
</form>
	<!-- 修改订单模态框结束 -->


	
</html>
