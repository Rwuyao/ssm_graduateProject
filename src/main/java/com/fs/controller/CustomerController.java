package com.fs.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fs.model.Customer;
import com.fs.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
		//客户信息查询
		@RequestMapping("client_info")
		public String client_info(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="3")int row) {
			
			HashMap<String, Object>  map =customerService.client_info(request,response,page,row);
			
			request.setAttribute("Cumap", map);
			return "view/baseInfo/client_info";
		}
		
		//客户信息删除
		@RequestMapping("Q_updatecusMessage")
		public String Q_updatecusMessage(HttpServletRequest request,HttpServletResponse response) {
			
			
			
			
			return customerService.Q_updatecusMessage(request,response);
		}
		//客户信息查询通过cus_id
		@RequestMapping("Q_selectCustomer")
		public String Q_selectCustomer(HttpServletRequest request,HttpServletResponse response) {
			
			
			
			
			return customerService.Q_selectCustomer(request,response);
		}
		//客户信息修改
		@RequestMapping("Q_CusUpdateByMess")
		public String Q_CusUpdateByMess(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="3")int row) {
			 
			HashMap<String, Object>  map =customerService.Q_CusUpdateByMess(request,response,page,row);
			
			request.setAttribute("Cumap", map);
			
			
			return "view/baseInfo/client_info";
		}
		//客户信息增加
		@RequestMapping("Q_CusInsertByMess")
		public String Q_CusInsertByMess(HttpServletRequest request,HttpServletResponse response,Customer customer,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="3")int row) {
			
			HashMap<String, Object>  map =customerService.Q_CusInsertByMess(request,response,page,row,customer);
			
			request.setAttribute("Cumap", map);
			return "view/baseInfo/client_info";
		}
		
		//多字段模糊查询客户信息
		@RequestMapping("Q_SelectMessage")
		public String Q_SelectMessage(HttpServletRequest request,HttpServletResponse response,Customer customer) {
			
			
			
			
			return customerService.Q_SelectMessage(request,response,customer);
		}

}
