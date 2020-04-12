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
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/skin_/nav.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<title>底部内容页</title>
</head>

<body>
<div id="container">
	<div id="bd">
    	<div class="sidebar">
        	<div class="sidebar-bg"></div>
            <i class="sidebar-hide"></i>
            <h2><a href="javascript:;"><i class="h2-icon" title="切换到树型结构"></i><span>切换视图</span></a></h2>
            <ul class="nav">
                <li class="nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">基本信息</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" href="product_info" data-id="1"><a href="product_info" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">产品信息</span></a></li>
                        <li class="subnav-li" href="client_info" data-id="2"><a href="client_info" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">客户信息</span></a></li>
                        <li class="subnav-li" href="supplier_info" data-id="3"><a href="supplier_info" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">供应商信息</span></a></li>
                    </ul>
                </li>
                <li class="nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">库存管理</span></a>
                	<ul class="subnav">
                    	<li class="subnav-li current" href="allGoods" data-id="4"><a href="allGoods" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">所有商品</span></a></li>
                        <li class="subnav-li" href="inventory_check" data-id="5"><a href="inventory_check" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">审核</span></a></li>
                        <li class="subnav-li" href="productLog" data-id="6"><a href="productLog" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">出库管理</span></a></li>
                    </ul>
                </li>
                <li class="nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">销售管理</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" href="order_query" data-id="7"><a href="order_query" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">订单查询</span></a></li>
                        <li class="subnav-li" href="sales_statistic" data-id="8"><a href="sales_statistic" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">销售统计</span></a></li>
                        <li class="subnav-li" href="sales_manage" data-id="9"><a href="sales_manage" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">销售管理</span></a></li>
                    </ul>
                </li>

                <li class="nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">财务管理</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" href="commercial_cost" data-id="10"><a href="commercial_cost" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">商品信息</span></a></li>
                        <li class="subnav-li" href="commercial_check" data-id="11"><a href="commercial_check" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">订单审核</span></a></li>
                        <li class="subnav-li" href="<%=basePath%>view/financialManage/commercial_revenue_statistic_1.jsp" data-id="12"><a href="<%=basePath%>view/financialManage/commercial_revenue_statistic_1.jsp" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">营业额</span></a></li>
                    </ul>
                </li>
                <li class="nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">行政管理</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" href="employee_info" data-id="13"><a href="employee_info" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">员工信息</span></a></li>
                        <li class="subnav-li" href="department_info" data-id="14"><a href="department_info" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">部门信息</span></a></li>
                        <li class="subnav-li" href="role_manage" data-id="15"><a href="role_manage" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">角色管理</span></a></li>
                    </ul>
                </li>
                <li class="nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">BOSS权限</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" href="#" data-id="16"><a href="#" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">操作日志</span></a></li>
                        <li class="subnav-li" href="check_info" data-id="17"><a href="check_info" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">审核信息</span></a></li>
                    </ul>
                </li>
            </ul>
            <div class="tree-list outwindow">
            	<div class="tree ztree"></div>
            </div>
        </div>
        <div class="main">
        	<div class="title">
                <i class="sidebar-show"></i>
                <ul class="tab ue-clear">
                   
                </ul>
                <i class="tab-more"></i>
                <i class="tab-close"></i>
            </div>
            <div class="content">
            </div>
        </div>
    </div>
</div>

<div class="more-bab-list">
	<ul></ul>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
    <div class="opt-panel-bl"></div>
</div>
</body>
<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript" src="js/Menu.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
	var menu = new Menu({
		defaultSelect: $('.nav').find('li[data-id="1"]')	
	});
	
	// 左侧树结构加载
	var setting = {};

		var zNodes =[
			{ name:"基本信息",
			   children: [
				 { name:"产品信息",icon:'img/skin_/leftlist.png'},
				 { name:"客户信息",icon:'img/skin_/leftlist.png'},
				 { name:"供应商信息",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"库存管理", open:true,
			   children: [
				 { name:"所有商品", checked:true,icon:'img/skin_/leftlist.png'},
				 { name:"审核",icon:'img/skin_/leftlist.png'},
				 { name:"出库管理",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"销售管理",
			   children: [
				 { name:"订单查询",icon:'img/skin_/leftlist.png'},
				 { name:"销售统计",icon:'img/skin_/leftlist.png'},
				 { name:"销售查询",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"财务管理",
			   children: [
				 { name:"商业成本",icon:'img/skin_/leftlist.png'},
				 { name:"审核",icon:'img/skin_/leftlist.png'},
				 { name:"营业额",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"行政管理",
				   children: [
					 { name:"员工信息",icon:'img/skin_/leftlist.png'},
					 { name:"部门信息",icon:'img/skin_/leftlist.png'},
					 { name:"角色管理",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"BOSS权限",
				   children: [
					 { name:"操作日志",icon:'img/skin_/leftlist.png'},
					 { name:"审核信息",icon:'img/skin_/leftlist.png'},
			]}
		];

	$.fn.zTree.init($(".tree"), setting, zNodes);
	
	
	$('.sidebar h2').click(function(e) {
        $('.tree-list').toggleClass('outwindow');
		$('.nav').toggleClass('outwindow');
    });
	
	$(document).click(function(e) {
		if(!$(e.target).is('.tab-more')){
			 $('.tab-more').removeClass('active');
			 $('.more-bab-list').hide();
		}
    });
</script>
</html>