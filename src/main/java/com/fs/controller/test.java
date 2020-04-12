package com.fs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.Lock;

import com.fs.model.Audit;
import com.fs.model.Product;
import com.fs.service.ProductService;
import com.fs.utils.AllBean;
public class test implements Callable<List<Product> > {
	
	
	
	ProductService productService=(ProductService) AllBean.getBeanByClass(ProductService.class);



	 // private HttpServletRequest request;
	/*
	 * @Autowired private ProductService productService;
	 */
	
	@Override
	public  List<Product>  call() throws Exception {
		
		 
		//new Thread().sleep(10000);
		System.out.println("启动了线程22");
		List <Product> list=productService.queryAllProduct();
		System.out.println(list);
		System.out.println("启动了线程33");
		
		return list;
	}
	public HashMap<String, List<Audit>> show(HttpServletRequest request) {
		
		System.out.println("金线程了");
		HashMap<String, List<Audit>> map=(HashMap<String, List<Audit>>) productService.selectheAudit(request);
		List<Audit>list=map.get("list");
		List<Audit>list2=map.get("list2");
		 request.setAttribute("list", list); request.setAttribute("list2", list2);
		System.out.println("线程1"+list);
		System.out.println("线程2"+list2);
		return map;
		
		
		
	}

	
	
	

}
