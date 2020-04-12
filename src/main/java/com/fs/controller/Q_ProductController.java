package com.fs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fs.service.ProductService;
import com.fs.service.Q_ProductService;
import com.google.gson.Gson;

/**
 * @author Mr-Yang
 *
 */
@Controller
public class Q_ProductController {
	@Autowired
	private Q_ProductService productService;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------
	
	
	//跳转到产品信息
	@RequestMapping("product_info")
	public String product_info(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="3")int row) {
		
		
		HashMap<String, Object>  map =productService.product_info(request,response,page,row);
		
		request.setAttribute("alist", map);
		
		return "view/baseInfo/product_info";
		/*return productService.product_info(request,response,page,row);*/
	}
	//通过多字段模糊查询
	@RequestMapping("Q_selectMesssage")
	public String Q_selectMess(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="3")int row) {
		
			
			HashMap<String, Object>  map =productService.Q_selectMess(request,response,page,row);
				
		
		
		
		return null;
	}
	
	
	
	
	
	
	
	
		
	
	
}
