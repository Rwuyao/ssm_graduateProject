package com.fs.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.mapper.CustomerMapper;
import com.fs.model.Customer;
import com.fs.service.CustomerService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	//客户信息查询
	@Override
	public HashMap<String, Object> client_info(HttpServletRequest request, HttpServletResponse response,int page,int row) {
		HashMap<String, Object> map = new LinkedHashMap<>();
		//计算mysql数据库查询的起始位置
				int start = row * (page-1);
				//查询当前页的结果集
		List<Customer> list = customerMapper.client_info2(start,row);
		//查询总条数
				int total = customerMapper.client_infoPageCount();
				//计算总页数
				int m =total%row;
				int totalPage = (int) Math.ceil(total/row);
				if (m!=0) {
					totalPage = totalPage+1;
				}
				System.out.println("-------------***----"+m);
				
				
				map.put("list", list);
				
				map.put("total", total);
				
				map.put("currentPage", page);
				
				map.put("totalPage", totalPage);
		
		
		
		System.out.println("客户查询信息成功");
	
		
		
		return map;
	}

	//客户信息删除
	@Override
	public String Q_updatecusMessage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			
			String cus_idST = request.getParameter("cus_id");
			System.out.println(cus_idST);
			PrintWriter pw;
			try {
				int cus_id = Integer.parseInt(cus_idST);
				customerMapper.Q_updatecusMessage(cus_id);
				System.out.println("-------删除客户数据成功-----");
				pw = response.getWriter();
				List<Customer> list = customerMapper.client_info();
				
				Gson gson = new Gson();
				
				String customerSt = gson.toJson(list);
				pw.print(customerSt);
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return null;
	}

	//查询客户信息通过cus_id
	@Override
	public String Q_selectCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			String cus_idST = request.getParameter("cus_id");
			int cus_id = Integer.parseInt(cus_idST);
			Customer customer = customerMapper.Q_selectCustomer(cus_id);
			System.out.println("查询客户信息通过cus_id成功");
			System.out.println(customer);
			Gson gson = new Gson();
			
			String customerSt = gson.toJson(customer);
			pw.println(customerSt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	//客户信息修改
	@Override
	public HashMap<String, Object> Q_CusUpdateByMess(HttpServletRequest request, HttpServletResponse response,int page,
			int row) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			int cus_id = Integer.parseInt(request.getParameter("cus_id"));
			String  cus_company_name = request.getParameter("cus_company_name");
			String  cus_username = request.getParameter("cus_username");
			String  cus_sex = request.getParameter("cus_sex");
			String  cus_tel = request.getParameter("cus_tel");
			String  cus_email = request.getParameter("cus_email");
			String  cus_address = request.getParameter("cus_address");
			Customer cus = new Customer();
			cus.setCus_id(cus_id);
			cus.setCus_company_name(cus_company_name);
			cus.setCus_username(cus_username);
			cus.setCus_sex(cus_sex);
			cus.setCus_tel(cus_tel);
			cus.setCus_email(cus_email);
			cus.setCus_address(cus_address);
			customerMapper.Q_CusUpdateByMess(cus);
			System.out.println("-------------客户信息修改成功-----------");
			
			
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		System.out.println("-----------------------------------分页");
		HashMap<String, Object> map = new LinkedHashMap<>();
		//计算mysql数据库查询的起始位置
				int start = row * (page-1);
				//查询当前页的结果集
		List<Customer> list = customerMapper.client_info2(start,row);
		//查询总条数
				int total = customerMapper.client_infoPageCount();
				//计算总页数
				int m =total%row;
				int totalPage = (int) Math.ceil(total/row);
				if (m!=0) {
					totalPage = totalPage+1;
				}
				System.out.println("-------------***----"+m);
				
				
				map.put("list", list);
				
				map.put("total", total);
				
				map.put("currentPage", page);
				
				map.put("totalPage", totalPage);
		
	
		
		/*List<Customer> list = customerMapper.client_info();
		
		request.setAttribute("list", list);*/
		return map;
	}

	//客户信息增加
	@Override
	public HashMap<String, Object> Q_CusInsertByMess(HttpServletRequest request, HttpServletResponse response,int page,int row, Customer cus) {
		String  cus_company_name = request.getParameter("cus_company_name2");
		String  cus_username = request.getParameter("cus_username2");
		String  cus_sex = request.getParameter("cus_sex2");
		String  cus_tel = request.getParameter("cus_tel2");
		String  cus_email = request.getParameter("cus_email2");
		String  cus_address = request.getParameter("cus_address2");
		cus.setCus_company_name(cus_company_name);
		cus.setCus_username(cus_username);
		cus.setCus_sex(cus_sex);
		cus.setCus_tel(cus_tel);
		cus.setCus_email(cus_email);
		cus.setCus_address(cus_address);
		
		customerMapper.Q_CusInsertByMess(cus);
		System.out.println("------------客户信息增加成功------------");
		
		System.out.println("--------------------------分页");
		HashMap<String, Object> map = new LinkedHashMap<>();
		//计算mysql数据库查询的起始位置
				int start = row * (page-1);
				//查询当前页的结果集
		List<Customer> list = customerMapper.client_info2(start,row);
		//查询总条数
				int total = customerMapper.client_infoPageCount();
				//计算总页数
				int m =total%row;
				int totalPage = (int) Math.ceil(total/row);
				if (m!=0) {
					totalPage = totalPage+1;
				}
				System.out.println("-------------***----"+m);
				
				
				map.put("list", list);
				
				map.put("total", total);
				
				map.put("currentPage", page);
				
				map.put("totalPage", totalPage);
		
	/*	List<Customer> list = customerMapper.client_info();
		request.setAttribute("list", list);*/
		return map;
	}
	
	//多字段模糊查询客户信息
	@Override
	public String Q_SelectMessage(HttpServletRequest request, HttpServletResponse response, Customer customer) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			String message = request.getParameter("message");
			
			if (message==""||message==null) {
				pw.print("err");
			}else{
				String messageSt = "%"+message+"%";
				List<Customer> Cu_list = customerMapper.Q_SelectMessage(messageSt);
				System.out.println("--多字段模糊查询客户信息成功-------------"+Cu_list);
				Gson gson = new Gson();
				String Cu_listST = gson.toJson(Cu_list);
				
				
				pw.print(Cu_listST);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
