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
    	     <form action="queryEmployee" method="post">
        	<div class="search-box ue-clear">
            	<div class="search-area">
                    <div class="kv-item ue-clear">
                        <div class="kv-item-content ue-clear">
                              <div class="input-group" >
    							<div class="input-group" >
    							<input type="text" name="keyword1" id="keyword1"  onkeyup="getMoreContents()" onfocus="getMoreContents()" onblur="clearContent()" style="width:200px; height:26px;" placeholder="输入具体订单号查询...">
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
                        <a href="addEmployee" data-toggle="modal" data-target="#model" class="add">
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
				label: '员工编号',
				width: 100,
			},{
				label:'用户名',
				width: 150,
			},{
				label:'真实姓名',
				width:150	
			},{
				label: '部门',
				width: 150	
			},{
				label: '电话',
				width: 200
			},{
				label: '邮箱',
				width:100
			},{
				label: '地址',
				minwidth:200	
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
				
				<c:forEach items="${uList}" var="uList">
				
					["${uList.userId}","${uList.username}","${uList.name}","${uList.depId}",
					 "${uList.telephone}","${uList.email}","${uList.adress}",
					 [
			            {label:'<span type="button" data-toggle="modal" data-target="#updatemodal">编辑</span>',
			            	onclick:function (){
			            		var userId = "${uList.userId}";
				            	var username = "${uList.username}";
				            	var name = "${uList.name}";
				            	var depId = "${uList.depId}";
				            	var telephone = "${uList.telephone}";
				            	var email = "${uList.email}";
				            	var adress = "${uList.adress}";
				            	
				            	$('#updateuserId').val(userId);
				        		$('#updateusername').val(username);
				        		$('#updatename').val(name);
				        		$('#updatedepId').val(depId);
				        		$('#updatetelephone').val(telephone);
				        		$('#updateemail').val(email);
				        		$('#updateadress').val(adress);
			        		
			            		
						}},
						
						{label:'删除',onclick: function (userId){
							userId = ${uList.userId};
								var ss = confirm("确定要删除吗？")
								if (ss) {
									$.ajax({
										  method: "post",
										  url:"deleteEmployee",
										  data : {
											  userId:userId
										  },
										  dataType:"text",
										  success : function(map) {
											 alert("成功删除");
											 window.location.reload();
										  },error:function(code){ 
											  alert("删除失败")
										  } 
										
							});
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
    var keyword1 = document.getElementById("keyword1").value;
    if (keyword1 == "") {
        clearContent();
        return;
    } else {
        var ajax = new XMLHttpRequest();
        var url = "autoUserQuery?keyword1=" + keyword1;
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
    var inputNode = document.getElementById("keyword1");
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



	<!-- 新增员工模态框 -->
<form action="addEmployee" method="post">
<div>
	<div class="modal fade" id="model" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">新增员工</h4>
				</div>
				<div class="modal-body">


					<div align="center">
						<table>
							<tr><td><span>员工编号</span></td>
							<td><span id="basic-addon1"></span> <input id="userId" name="userId" type="text" class="form-control" placeholder="员工编号" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>

					<div align="center">
						<table>
							<tr><td><span>员工姓名</span></td>
							<td><span id="basic-addon1"></span> <input id="name" name="name" type="text" class="form-control" placeholder="员工姓名" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>登录昵称</span></td>
							<td><span id="basic-addon1"></span> <input id="username" name="username" type="text" class="form-control" placeholder="登录昵称" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>部门编号</span></td>
							<td><span id="basic-addon1"></span> <input id="depId" name="depId" type="text" class="form-control" placeholder="部门编号" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>电子邮箱</span></td>
							<td><span id="basic-addon1"></span> <input id="email" name="email" type="text" class="form-control" placeholder="电子邮箱" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>

						<br>
					<div align="center">
						<table>
							<tr><td><span>联系电话</span></td>
							<td><span id="basic-addon1"></span> <input id="tel" name="tel" type="text" class="form-control" placeholder="联系电话" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					<div align="center">
						<table>
							<tr><td><span>居住地址</span></td>
							<td><span id="basic-addon1"></span> <input id="address" name="address" type="text" class="form-control" placeholder="居住地址" aria-describedby="basic-addon1"></td></tr>
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
<form action="updateEmployee" method="post">
<div>
	<div class="modal fade" id="updatemodal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">修改信息</h4>
				</div>
				<div class="modal-body">
					<div align="center">
						<table>
							<tr><td><span>员工编号</span></td>
							<td><span id="basic-addon1"></span> <input id="updateuserId" name="updateuserId" type="text" class="form-control" value="" aria-describedby="basic-addon1" readonly="true"></td></tr>
						</table>
						
					</div>
					<br>

					<div align="center">
						<table>
							<tr><td><span>员工姓名</span></td>
							<td><span id="basic-addon1"></span> <input id="updatename" name="updatename" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>登录昵称</span></td>
							<td><span id="basic-addon1"></span> <input id="updateusername" name="updateusername" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>部门编号</span></td>
							<td><span id="basic-addon1"></span> <input id="updatedepId" name="updatedepId" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>联系电话</span></td>
							<td><span id="basic-addon1"></span> <input id="updatetelephone" name="updatetelephone" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
							<tr><td><span>电子邮箱</span></td>
							<td><span id="basic-addon1"></span> <input id="updateemail" name="updateemail" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
				</div>
					
					<div align="center">
						<table>
							<tr><td><span>居住地址</span></td>
							<td><span id="basic-addon1"></span> <input id="updateadress" name="updateadress" type="text" class="form-control" value="" aria-describedby="basic-addon1"></td></tr>
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
