package com.fs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.model.Order;
import com.fs.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------
	
	
	//跳转到订单查询
	@RequestMapping("orderList")
	public String order_query(HttpServletRequest request,HttpServletResponse response) {
		return "view/salesManage/order_query";
	}
	
	
	//跳转到销售管理
	@RequestMapping("sales_manage")
	public String sales_manage(HttpServletRequest request,HttpServletResponse response) {
		return orderService.querySaleList();
	}
	
	//跳转到销售统计，生成统计图
	@RequestMapping("sales_statistic")
	public String sales_statistic(HttpServletRequest request,HttpServletResponse response) {
		return orderService.sales_statistic();
		
	}
	
	
	//显示订单列表，分页显示
	@RequestMapping("order_query")
	public String orderList(HttpServletRequest request,HttpServletResponse response) {
		
		return orderService.queryOrderList();
			
		}
	
	
	//新增订单列表
	@RequestMapping("addOrder")
	public String addOrder(HttpServletRequest request,HttpServletResponse response) {
			
		return orderService.addOrder();
				
		}
	
	//删除订单列表
	@RequestMapping("deleteOrder")
	public String deleteOrder(HttpServletRequest request,HttpServletResponse response) {
				
		return orderService.deleteOrder();
					
		}
	
	
	//修改订单列表
	@RequestMapping("renewOrder")
	public String renewOrder(HttpServletRequest request,HttpServletResponse response) {
					
		return orderService.renewOrder();
						
		}
	
	//销售管理模块：根据具体订单号查询到数据
	@RequestMapping("queryOrderById")
	public String queryOrderById(HttpServletRequest request,HttpServletResponse response) {
					
		return orderService.queryOrderById();
						
		}
	
	//订单查询模块：根据客户名
	@RequestMapping("queryOrderByName")
	public String queryOrderByName(String name) {
					
		name = "廖先生";
		return orderService.queryOrderByName(name);
						
		}
	
	//订单查询模块：根据订单状态
	@RequestMapping("queryOrderByCheckBox")
	public String queryOrderByCheckBox() {
		
		return orderService.queryOrderByCheckBox();
							
	}
	
	//订单查询模块：根据产品名称、下单人、顾客、审核状态查询
	@RequestMapping("queryOrderByInput")
	public String queryOrderByInput() {
					
		return orderService.queryOrderByInput();
						
		}
	
	//搜索自动补全
	@RequestMapping("autoPrompting")
	public String autoPrompting(HttpServletRequest request,HttpServletResponse response) {
					
		return orderService.autoPrompting();
						
		}
	
	
}
