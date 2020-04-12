package com.fs.service;

import java.util.List;

import com.fs.model.Order;

/**
 * @author Mr-Yang
 *
 */
public interface OrderService {

	//查询订单列表
	String queryOrderList();

	//新增订单信息
	String addOrder();

	//删除订单信息
	String deleteOrder();

	//修改订单信息
	String renewOrder();

	//销售管理主页
	String querySaleList();

	//销售管理模块：根据具体订单号查询到数据
	String queryOrderById();

	//订单查询模块：根据客户名
	String queryOrderByName(String name);

	//订单查询模块：根据产品名称、下单人、顾客、审核状态查询
	String queryOrderByInput();

	//销售统计图
	String sales_statistic();

	//订单查询模块：根据订单状态
	String queryOrderByCheckBox();

	//自动补全测试
	String autoPrompting();

}
