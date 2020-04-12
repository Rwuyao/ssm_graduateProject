
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

function update(){
	var id=$("#asd").val();
	
	$.ajax({
		type:"post",
		url:"updatepro",
		data:{
			id:id
		},
		dataType:"text",
		scriptCharset:"utf-8",
		success:function(ret){
			
			var list=eval(ret)
			$(list).each(function(i,m){
				$("#ii1").val(m.name)
				$("#ii2").val(m.price)
				$("#ii3").val(m.des)
				
				$("#ii4").val(m.proId)
			})
		}
		
		
		
	})
	
	
}



function set (){
	$("#sb").prop("checked", false);
	$("#vc").prop("checked", false);
	
}

function set2 (){
	$("#sb2").prop("checked", false);
	$("#vc").prop("checked", false);
}

function set3 (){
	$("#sb").prop("checked", false);
	$("#sb2").prop("checked", false);
	
}


function set8(){
	var info="${info}"
	if(info==1){
		alert("服务器异常，请稍后在试")
	}
	
	
}



	function addui() {
		

	
		/* $.ajax({
			type : "post",
			url : "addproduct",
			datatype : "json",
			scriptcharset : "utf-8",
			success : function(ret) {
				var list = eval(ret);

				$(list).each(function(i, m) {
					alert(m.supplierId),
					alert(m.company)

				})

			}

		})
 */
	}
</script> 
</head>



<body  onload="set8()" >
<form action="selectpqoduct"  method="post">
	<div class="col-md-10">
	<br>
	
		<table class="col-md-10">
			<tr>
		
				<td class="col-md-3 "><h4>根据销售状态查看：</h4> 销售中：   <input onclick="set2()" name="state1"  id="sb" <c:if test="${info eq '1' }" >checked="checked"</c:if>  value="销售中" type="radio"   />
					 &nbsp &nbsp 暂停销售<input  id="sb2" onclick="set()" <c:if test="${info eq '2' }" >checked="checked"</c:if>
					name="state2" value="暂停销售" type="radio" />
					&nbsp &nbsp 全部<input id="vc" <c:if test="${info eq '3' }" >checked="checked"</c:if>  onclick="set3()" type="radio" /></td> 
					
				<td>
					<h4>根据上市时间查看：</h4> <input type="text" placeholder="选择开始时间" name="time1" value="${time1 }"  onfocus="WdatePicker()" />
					 <input type="text" name="time2"   placeholder="选择结束时间"   value="${time2}"  onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd '})"/>
				</td>
			</tr>
			<br>

			<tr>
				<td><button class="btn btn-info"  type="submit" >查询</button>  </td>
			</tr>
		</table>





	</div>
</form>
	<div>
	<br>
		<table>
			<tr>
				<td><button  class="btn btn-info" type="button" onclick="location.href='apllyui'">入库申请</button></td>
				<td><button type="button" class="btn btn-primary" onclick="location.href='view/inventory_manage/addproduct.jsp'">产品入库</button>
				</td>
				<td>
				<button class="btn btn-warning" type="button" onclick="location.href='outpro'">产品出库</button>
				</td>

			</tr>
		</table>


	</div>


	<div class="col-md-12">
	<br>
	<hr>
		<table class="table table-hover table-bordered">
			<tr class="info" style="color: red">
				<td>选择</td>
				<td style="width: 30px">编号</td>
				<td>图片</td>
				<td>名字</td>
				<td>品牌</td>
				<td>类型</td>
				<td style="width: 250px">描述</td>
				<td>价格</td>
				<td>供应商</td>
				<td>上市日期</td>
				<td>状态</td>
				<td>仓库数量</td>
				<td align="center" style="width: 150px">操作</td>
			</tr>
			<c:forEach items="${ list}" var="list">
				<tr>
					<td><br> <input type="checkbox" /></td>
					<td><br> ${list.proId}
					<input  type="hidden" name=id id="asd" value="${list.proId}"></input>
					
					</td>
					<td><img alt="加载中" src="/tu/${list.picture}"
						style="width: 80px; height: 80px"></td>
					<td><br> ${list.name}</td>
					<td><br> ${list.bround}</td>
					<td><br> ${list.catagorg}</td>
					<td><br> ${list.des}</td>
					<td><br> ￥：${list.price}</td>
					<td><br> <a
							href="https://www.huawei.com/cn/?ic_medium=direct&ic_source=surlent">${dd} ${list.supplier.company}</a></td>
					<td><br> <fmt:formatDate value='${list.date}'
								pattern='yyyy-MM-dd ' /></td>

					<td id="t"><br>
					<c:if test="${list.state eq '销售中'}">
								<font >${list.state}</font>
							</c:if>
							<c:if test="${list.state eq '暂停销售'}">
							<font color=red >${list.state}</font>
							</c:if>


                                          </td>
					<td><br> ${list.number}台</td>
					<td><br>
							<button type="button"  data-toggle="modal" data-target="#model"   onclick="update()"  class="btn btn-info">编辑</button>
							
							<c:if test="${list.state eq '销售中'}">
								<button class="btn btn-danger" type="button" onclick="location.href='deletepro?id=${list.proId}'">下架</button>
							</c:if>
							<c:if test="${list.state eq '暂停销售'}">
							<button type="button" class="btn btn-success"  onclick="location.href='addpro22?id=${list.proId}'">上架</button>
							</c:if>
							
							
						
							
							
							
							
							
							
							
							</td>
				</tr>
			</c:forEach>
		</table>
	</div>


<form action="doupdate" method="post">
<div>
	<div class="modal fade" id="model" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			<div align="center">
			<h2 class="modal-title">编辑产品</h2></div>
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;<tton>
					
				</div>
				<div class="modal-body">


					<div align="center">
						<table>
							<tr><td><span>产品型号</span><input type="hidden" id="ii4" value=""  name="id"/>    </td>
							<td><span id="basic-addon1"></span> <input id="ii1" name="name" type="text" class="form-control"  value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>

					<div align="center">
						<table>
							<tr><td><span>产品售价</span></td>
							
							<td><span id="basic-addon1"></span> <input id="ii2" name="price" type="text" class="form-control"  value="" aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>
					<br>
					
					<div align="center">
						<table>
						
							<tr><td><span>产品描述</span></td>
							<td><span id="basic-addon1"></span> <input id="ii3" name="des" type="text" class="form-control" value=""   aria-describedby="basic-addon1"></td></tr>
						</table>
						
					</div>



				</div>
				<div class="modal-footer">
					
					<button type="submit" class="btn btn-primary">确认修改<tton>
					
					
				</div>
			</div>
			
		</div>
	</div>
</div></form>











</body>

</html>
