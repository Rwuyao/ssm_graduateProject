package com.fs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fs.model.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //查询所有订单列表
	List<Order> queryOrderList();

	//新增订单
	int addOrder(@Param("orderId")int orderId,@Param("productName")String productName,@Param("price")String price,@Param("number")int number,@Param("people")String people,@Param("custmer")String custmer,@Param("state")String state,@Param("becauser")String becauser);

	//通过orderId删除订单信息
	int deleteOrder(int orderId);

	//修改订单信息
	int renewOrder(@Param("orderId")int orderId, @Param("productName")String productName, @Param("price")String price, @Param("number")int number, @Param("people")String people, @Param("custmer")String custmer,
			@Param("becauser")String becauser);
	
	//将修改信息提交到仓库审核
	int updateOrder(@Param("orderId")int orderId,@Param("productName")String productName, @Param("price")String price,
			@Param("number")int number, @Param("custmer")String custmer, @Param("becauser")String becauser);

	//销售管理模块：根据具体订单号查询到数据
	List<Order> queryOrderById(int orderId);

	//订单查询模块：根据客户名
	List<Order> queryOrderByName(String name);

	//订单查询模块：根据产品名称、下单人、顾客、审核状态查询;多字段模糊查询
	List<Order> queryOrderByInput(String inputMessage);

	//订单查询模块：根据产品名称、下单人、顾客、审核状态查询;多字段模糊查询
	List<Order> queryOrderByInputTwo(@Param("inputOrderId")int inputOrderId, @Param("inputMessage")String inputMessage);

	//订单查询模块:日期不为空时，查询
	List<Order> queryOrderByTime(@Param("sdate")String sdate);

	//根据订单状态查询数据
	List<Order> queryOrderByChckBox(String checkBoxName);

	//生成业务处理进度柱状图、饼状图
	List<Order> queryStaticData();

	//生成产品销量柱状图
	List<Order> queryStaticData2();

	//添加到仓库审核列表
	int insertIntoAudit(@Param("dep_send")String dep_send, @Param("dep_recv")String dep_recv, @Param("people_send")String people_send, 
			@Param("state")String state, @Param("becauser")String becauser,
			@Param("productName")String productName,@Param("price") String price,
			@Param("number")int number, @Param("custmer")String custmer, 
			@Param("orderId")int orderId, @Param("sta")String sta);

	//生成总订单数的折线图，通过时间分类（最近四周？，一个月内）
	List<Order> queryStaticData4();

	//生成总销售额的折现图，通过时间分类（按一个月计算）
	List<Order> queryStaticData3();

	//搜索框自动补全orderId
	List<String> queryOrderId();

	

	
}