package com.fs.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.mapper.OrderMapper;
import com.fs.model.Order;
import com.fs.model.User;
import com.fs.service.OrderService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

//import net.sf.json.JSONArray;


@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private HttpServletRequest req;
	@Autowired
	private HttpServletResponse resp;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------

	//查询订单列表
	@Override
	public String queryOrderList() {
		List<Order> oList = orderMapper.queryOrderList();
		req.setAttribute("oList", oList);
		
		return "view/salesManage/order_query";
	}

	
	//新增订单信息
	@Override
	public String addOrder() {
		//产品名称
		String productName = req.getParameter("product_name");
		//产品价格
		String price = req.getParameter("price");
		//购买数量
		String numberStr = req.getParameter("number");
		int number = Integer.parseInt(numberStr);
		//销售人员
		String people = req.getParameter("people");
		//顾客信息
		String custmer = req.getParameter("custmer");
		//下单时间
	/*	Date date = new Date();
		String fDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);*/
		//随机数生成订单号
		int orderId = (int) ((Math.random() * 9 + 1) * 100000);
		//设置订单申请状态
		String state = "待审核";
		//备注
		String becauser = req.getParameter("becauser");
		
		//添加进数据库
		int s = orderMapper.addOrder(orderId,productName,price,number,people,custmer,state,becauser);
		
		//添加到仓库审核列表
		User user = (User) req.getSession().getAttribute("USER");
		String people_send = user.getName();
		String dep_send = "销售部";
		String dep_recv = "仓库部";
		String sta = "0";
		int i = orderMapper.insertIntoAudit(dep_send,dep_recv,people_send,state,becauser,productName,price,number,custmer,orderId,sta);
		
		//添加数据后再次查询，更新页面
		List<Order> oList = orderMapper.queryOrderList();
		req.setAttribute("oList", oList);
		return "view/salesManage/sales_manage";
	}


	//删除订单
	@Override
	public String deleteOrder() {
		String orderIdStr = req.getParameter("orderId");
		int orderId = Integer.parseInt(orderIdStr);
		PrintWriter pw;
		try {
			pw = resp.getWriter();
			Gson gson = new Gson();
			String result = gson.toJson(orderId);
			pw.print(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Ajax传值ID成功，调用删除方法
		int s = orderMapper.deleteOrder(orderId);
		
		//删除成功，返回页面
		List<Order> oList = orderMapper.queryOrderList();
		req.setAttribute("oList", oList);
		return "view/salesManage/sales_manage";
	}


	//修改订单信息
	@Override
	public String renewOrder() {
		
		//得到修改后的信息
		String orderIdStr = req.getParameter("updateOrderId");
		int orderId = Integer.parseInt(orderIdStr);
		String productName = req.getParameter("updateproductName");
		String price = req.getParameter("updateprice");
		String numberStr = req.getParameter("updatenumber");
		int number = Integer.parseInt(numberStr);
		String people = req.getParameter("updatepeople");
		String custmer = req.getParameter("updatecustmer");
		String becauser = req.getParameter("updatebecauser");
		
		
		//修改数据库
		int i = orderMapper.renewOrder(orderId,productName,price,number,people,custmer,becauser);
		//将修改信息提交到仓库审核
		int s = orderMapper.updateOrder(orderId,productName,price,number,custmer,becauser);
		
		//修改成功，返回页面
		List<Order> oList = orderMapper.queryOrderList();
		req.setAttribute("oList", oList);
		return "view/salesManage/sales_manage";
	}


	//销售管理主页
	@Override
	public String querySaleList() {
		
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int pageNo = 1;
		int pageSize = 5;
		int total = 72;
		int fromPage = (pageNo-1)*pageSize+1;
		try {
			PrintWriter pw = resp.getWriter();
			Gson gson = new Gson();
			List<Integer> list = new ArrayList<>();
			list.add(pageNo);
			list.add(pageSize);
			list.add(total);
			list.add(fromPage);
			String data = gson.toJson(list);
			pw.print(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		List<Order> oList = orderMapper.queryOrderList();
		req.setAttribute("oList", oList);
		return "view/salesManage/sales_manage";
	}


	//销售管理模块：根据具体订单号查询到数据
	@Override
	public String queryOrderById() {
		String orderIdStr = req.getParameter("keyword");
		if (orderIdStr==null || orderIdStr=="") {
			List<Order> oList = orderMapper.queryOrderList();
			req.setAttribute("oList", oList);
			return "view/salesManage/sales_manage";
			}
		else{
			int orderId = Integer.parseInt(orderIdStr);
			List<Order> oList = orderMapper.queryOrderById(orderId);
			req.setAttribute("oList", oList);
			return "view/salesManage/sales_manage";
		}
		
	}


	//订单查询模块：根据客户名
	@Override
	public String queryOrderByName(String name) {
	
		List<Order> oList = orderMapper.queryOrderByName(name);
		req.setAttribute("oList", oList);
		return "view/salesManage/order_query";
	}


	//订单查询模块：根据产品名称、下单人、顾客、审核状态查询
	@Override
	public String queryOrderByInput() {
		String inputMessage = req.getParameter("inputMessage");
		String inputOrderIdStr = req.getParameter("inputOrderId");
		
		String sdate = getRadio();
		
		
		//日期为空时
		if(sdate == null || sdate ==""){
			//订单号为空时
			if (inputOrderIdStr == null || inputOrderIdStr == "") {
				//其他输入信息为空时
				if (inputMessage == null || inputMessage =="") {
					//查询全部
					List<Order> oList = orderMapper.queryOrderList();
					req.setAttribute("oList", oList);
					return "view/salesManage/order_query";
				}else{
					//查询其他输入信息
					inputMessage = "%"+inputMessage+"%";
					List<Order> oList = orderMapper.queryOrderByInput(inputMessage);
					req.setAttribute("oList", oList);
					return "view/salesManage/order_query";
				}
			}else{
				//订单和其他输入信息都不为空时，根据两种输入查询
				int inputOrderId = Integer.parseInt(inputOrderIdStr);
				inputMessage = "%"+inputMessage+"%";
				List<Order> oList = orderMapper.queryOrderByInputTwo(inputOrderId,inputMessage);
				req.setAttribute("oList", oList);
				
				return "view/salesManage/order_query";
			}
	
		}else {
			//日期不为空,根据日期来查询信息（待完善）
			List<Order> oList = orderMapper.queryOrderByTime(sdate);
			req.setAttribute("oList", oList);
			
			return "view/salesManage/order_query";
		}
			
		
		
	}
	

	//拿到前端radio框选择的值
	public String getRadio(){
		String timeall = req.getParameter("timeall");
		String timethree = req.getParameter("timethree");
		String timeweek = req.getParameter("timeweek");
		String timemonth = req.getParameter("timemonth");
		if (timeall !=null && timeall !="") {
			timeall = "INTERVAL 9999 DAY";
			return timeall;
		}
		if (timethree !=null && timethree !="") {
			timethree = "INTERVAL 3 DAY";
			return timethree;
		}
		if (timeweek !=null && timeweek !="") {
			timeweek = "INTERVAL 7 DAY";
			return timeweek;
		}
		if (timemonth !=null && timemonth !="") {
			timemonth = "INTERVAL 30 DAY";
			return timemonth;
		}
		
		return null;
		
	}


	//根据订单状态查询数据
	@Override
	public String queryOrderByCheckBox() {
		String checkBoxName = req.getParameter("checkBoxName");
		
		//根据checkBox的条件查询数据库，返回集合
		List<Order> oList = orderMapper.queryOrderByChckBox(checkBoxName);
		req.setAttribute("oList", oList);
			
			
		return "view/salesManage/order_query";
	}
	
	
	
	//动态生成销售统计图
	@Override
	public String sales_statistic() {
		
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//生成业务处理进度柱状图、饼状图
		List<Order> oList = orderMapper.queryStaticData();
		req.setAttribute("待审核", oList.get(0).getState());
		req.setAttribute("stateNum0", oList.get(0).getStateCount());
		
		req.setAttribute("审核中", oList.get(1).getState());
		req.setAttribute("stateNum1", oList.get(1).getStateCount());
		
		req.setAttribute("审核通过", oList.get(2).getState());
		req.setAttribute("stateNum2", oList.get(2).getStateCount());
		
		req.setAttribute("审核失败", oList.get(3).getState());
		req.setAttribute("stateNum3", oList.get(3).getStateCount());
		
		//生成产品销量柱状图
		List<Order> oList2 = orderMapper.queryStaticData2();
		req.setAttribute("name0", oList2.get(0).getProductName());
		req.setAttribute("num0", oList2.get(0).getSumNum());
		
		req.setAttribute("name1", oList2.get(1).getProductName());
		req.setAttribute("num1", oList2.get(1).getSumNum());
		
		req.setAttribute("name2", oList2.get(2).getProductName());
		req.setAttribute("num2", oList2.get(2).getSumNum());
		
		req.setAttribute("name3", oList2.get(3).getProductName());
		req.setAttribute("num3", oList2.get(3).getSumNum());
		
		req.setAttribute("name4", oList2.get(4).getProductName());
		req.setAttribute("num4", oList2.get(4).getSumNum());
		
	
		//生成总销售额的折现图，通过时间分类（按一个月计算）
		List<Order> oList4 = orderMapper.queryStaticData3();
		req.setAttribute("orderMonth0", oList4.get(0).getSumMoney());
		req.setAttribute("orderMonth1", oList4.get(1).getSumMoney());
		req.setAttribute("orderMonth2", oList4.get(2).getSumMoney());
		req.setAttribute("orderMonth3", oList4.get(3).getSumMoney());
		
		//生成总订单数的折现图，通过时间分类（最近四周？，一个月内）
		List<Order> oList3 = orderMapper.queryStaticData4();
		req.setAttribute("orderNum0", oList3.get(0).getSumNum());
		req.setAttribute("orderNum1", oList3.get(1).getSumNum());
		req.setAttribute("orderNum2", oList3.get(2).getSumNum());
		req.setAttribute("orderNum3", oList3.get(3).getSumNum());
		
		
		
		return "view/salesManage/sales_statistic";
	}
	
	
	
	/*************************测试搜索补全代码**********************************/
	//根据订单状态查询数据,自动补全
	
	  @Override public String autoPrompting() {
	  
	//  try { req.setCharacterEncoding("utf-8"); resp.setCharacterEncoding("utf-8");
	  
	  
	  
	  //查询数据库 List<String> sList = orderMapper.queryOrderId();
	  
	  
		/*
		 * String keyword = req.getParameter("keyword"); List<String> res = new
		 * ArrayList<>();
		 * 
		 * for(String string:sList){ if (string.contains(keyword)) { res.add(string); }
		 * }
		 * 
		 * JSONArray jsonArray = JSONArray.fromObject(res);
		 * resp.setContentType("text/html");
		 * 
		 * try { resp.getWriter().print(jsonArray.toString()); } catch (IOException e) {
		 * e.printStackTrace(); }
		 * 
		 * 
		 * 
		 * } catch (UnsupportedEncodingException e) { e.printStackTrace(); } return
		 * null;
		 */
	  
	  
	  
	 
	  return "view/salesManage/testAutoQuery";
	  }
	 
	
	/*************************测试搜索补全代码**********************************/
}


