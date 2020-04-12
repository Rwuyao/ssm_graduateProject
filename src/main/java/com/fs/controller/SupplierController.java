package com.fs.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fs.service.SupplierService;

/**
 * @author Mr-Yang
 *
 */
@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------
	
	//跳转到供应商信息
	@RequestMapping("supplier_info")
	public String supplier_info(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="3")int row) {
		HashMap<String, Object>  map =supplierService.supplier_info(request,response,page,row);
		request.setAttribute("map", map);
		//return "view/baseInfo/supplier_info";
		
		return "view/baseInfo/supplier_info";
	}
	//供应商信息删除通过suplier_id
	@RequestMapping("Q_deleteSupMessage")
	public String Q_deleteSupMessage(HttpServletRequest request,HttpServletResponse response) {
		
		
		
		
		return supplierService.Q_deleteSupMessage(request,response);
	}
	//供应商信息查询通过suplier_id
	@RequestMapping("Q_selectSupplier")
	public String Q_selectSupplier(HttpServletRequest request,HttpServletResponse response) {
		
		
		
		
		return supplierService.Q_selectSupplier(request,response);
	}
	//供应商信息修改
	@RequestMapping("Q_SupUpdateByMess")
	public String Q_SupUpdateByMess(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="3")int row) {
		HashMap<String, Object>  map =supplierService.Q_SupUpdateByMess(request,response,page,row);
		
		request.setAttribute("map", map);
		
		return "view/baseInfo/supplier_info";
	}
	//供应商信息增加
	@RequestMapping("Q_SuppInsertByMess")
	public String Q_SuppInsertByMess(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="3")int row) {
		HashMap<String, Object>  map =supplierService.Q_SuppInsertByMess(request,response,page,row);
		
		request.setAttribute("map", map);
		
		
		
		return "view/baseInfo/supplier_info";
	}
	//供应商信息模糊查询--多字段
	@RequestMapping("Q_SupSelectMessage")
	public String Q_SupSelectMessage(HttpServletRequest request,HttpServletResponse response) {
		
		
		
		
		return supplierService.Q_SupSelectMessage(request,response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
