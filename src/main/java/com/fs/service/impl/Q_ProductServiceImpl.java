package com.fs.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.mapper.Q_ProductMapper;
import com.fs.model.Customer;
import com.fs.model.Product;
import com.fs.service.Q_ProductService;
import com.google.gson.Gson;

//import net.sf.json.JSONArray;

/**
 * @author Mr-Yang
 *
 */
@Service
public class Q_ProductServiceImpl implements Q_ProductService {
	@Autowired
	private Q_ProductMapper productMapper;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------
	//跳转到产品信息
	@Override
	public HashMap<String, Object> product_info(HttpServletRequest request, HttpServletResponse response,int page,int row) {
		HashMap<String, Object> map = new LinkedHashMap<>();
		//计算mysql数据库查询的起始位置
		int start = row * (page-1);
		//查询当前页的结果集
		List<Product> list = productMapper.Q_ProselectPage(start,row);
		//查询总条数
		int total = productMapper.Q_ProselectPageCount();
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
		
		/*List<Product> alist = productMapper.product_info();
		System.out.println("---------------------------获取产品数据成功-----------"+alist);
		request.setAttribute("alist", alist);*/
		
		
		
		
		
		
		
		return map;
	}
	//通过多字段模糊查询
	@Override
	public HashMap<String, Object> Q_selectMess(HttpServletRequest request, HttpServletResponse response,int page,int row) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			String selectMess = request.getParameter("message");
			if (selectMess=="" || selectMess==null) {
				pw.print("erro");
			}else{
				
				
				
				
				//计算mysql数据库查询的起始位置   -------------------------------------------分页
				int start = row * (page-1);
				HashMap<String, Object> map = new LinkedHashMap<>();
				String selectMess2 = "%"+selectMess+"%";
				//查询结果
				List<Product> Slist =  productMapper.Q_selectMess(selectMess2,start,row);
				//查询条数
				int total = productMapper.Q_selectMessPageCount(selectMess2,start,row);
				int m =total%row;
				int totalPage = (int) Math.ceil(total/row);
				if (m!=0) {
					totalPage = totalPage+1;
				}
				request.getSession().setAttribute("currentPage",page);
				request.getSession().setAttribute("totalPage", totalPage);
				
			System.out.println(total+"----------"+Slist);
				map.put("list", Slist);
				
				map.put("total", total);
				
				//map.put("currentPage", page);
				
			//	map.put("totalPage", totalPage);
				
				
				System.out.println("模糊查询成功");
				Gson gson = new Gson();
				String SlistGS = gson.toJson(map);
				
				pw.print(SlistGS);
				
			}
			
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
		
		
		/*int start = row * (page-1);
	
		String selectMess2 = "%"+selectMess+"%";
		
		List<Product> Slist =  productMapper.Q_selectMess(selectMess2);
		
		System.out.println("模糊查询成功"+Slist);
		Gson gson = new Gson();
		String SlistGS = gson.toJson(Slist);
		
		pw.print(SlistGS);
	}
	
	} catch (IOException e) {
	
	e.printStackTrace();
}
return null;	*/
		
		
	}
/*	//自动补全
	@Override
	public String autoPrompting(HttpServletRequest request,HttpServletResponse response) {

        try {
        	request.setCharacterEncoding("utf-8");
        	response.setCharacterEncoding("utf-8");
			
			
			//模拟数据
			List<String> list = new ArrayList<>();
			
		 	list.add("薛傻逼");
	        list.add("薛之谦");
	        list.add("java 是是世界上最好的语言");
	        list.add("Java web");
	        list.add("ajax");
	        list.add("ajax 教程");
	        
	        
			
			*//************真实数据库数据************//*
			//查询数据库
			List<String> sList = productMapper.queryOrderId();
			
			*//************真实数据库数据************//*
			String keyword = request.getParameter("message");
			List<String> res = new ArrayList<>();
			
			for(String string:sList){
				if (string.contains(keyword)) {
					res.add(string);
				}
			}
			
			JSONArray jsonArray = JSONArray.fromObject(res);
			response.setContentType("text/html");
			
			try {
				response.getWriter().print(jsonArray.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
			 
			 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		return null;
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	

}
