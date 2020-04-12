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

import com.fs.mapper.SupplierMapper;
import com.fs.model.Customer;
import com.fs.model.Supplier;
import com.fs.service.SupplierService;
import com.google.gson.Gson;

/**
 * @author Mr-Yang
 *
 */
@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierMapper supplierMapper;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------

	//查询供应商信息
	@Override
	public HashMap<String, Object> supplier_info(HttpServletRequest request, HttpServletResponse response,int page,int row) {
		HashMap<String, Object> map = new LinkedHashMap<>();
		//计算mysql数据库查询的起始位置
				int start = row * (page-1);
				//查询当前页的结果集
		List<Customer> list = supplierMapper.supplier_info(start,row);
		//查询总条数
				int total = supplierMapper.supplier_infoPageCount();
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
		
		
		
		
		
	
		System.out.println("------查询供应商信息查询成功---------------");
		
		return map;
	}

	//供应商信息删除通过suplier_id
	@Override
	public String Q_deleteSupMessage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			
			e1.printStackTrace();
		}
		response.setContentType("text/html; charset=UTF-8");
		
		int supplierId = Integer.parseInt(request.getParameter("supplierId"));
		System.out.println(supplierId);
		supplierMapper.Q_deleteSupMessage(supplierId);
		System.out.println("-----供应商信息删除成功------------------");
		try {
			PrintWriter pw = response.getWriter();
			List<Supplier> SuList = supplierMapper.supplier_info2();
			Gson gson = new Gson();
			String SuListSt = gson.toJson(SuList);
			
			pw.print(SuListSt);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	//供应商信息查询通过suplier_id
	@Override
	public String Q_selectSupplier(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			
			e1.printStackTrace();
		}
		response.setContentType("text/html; charset=UTF-8");
		int supplierId = Integer.parseInt(request.getParameter("supplier_id"));
		
		Supplier supplier = supplierMapper.Q_selectSupplier(supplierId);
		try {
			PrintWriter pw = response.getWriter();
			Gson gson = new Gson();
			String supplierSt = gson.toJson(supplier);
			
			pw.print(supplierSt);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	//供应商信息修改
	@Override
	public HashMap<String, Object> Q_SupUpdateByMess(HttpServletRequest request, HttpServletResponse response, int page,
			int row) {
		int suplier_id = Integer.parseInt(request.getParameter("supplier_id"));
		String company = request.getParameter("company");
		String wner = request.getParameter("wner");
		String adress = request.getParameter("adress");
		String telephone = request.getParameter("telephone");
		String des = request.getParameter("des");
		Supplier supplier = new Supplier();
		supplier.setDes(des);
		supplier.setAdress(adress);
		supplier.setCompany(company);
		supplier.setSupplierId(suplier_id);
		supplier.setTelephone(telephone);
		supplier.setWner(wner);
		supplierMapper.Q_SupUpdateByMess(supplier);
		System.out.println("-----------供应商信息修改成功-------------");
		System.out.println("----------------------分页");
		HashMap<String, Object> map = new LinkedHashMap<>();
		//计算mysql数据库查询的起始位置
				int start = row * (page-1);
				//查询当前页的结果集
		List<Customer> list = supplierMapper.supplier_info(start,row);
		//查询总条数
				int total = supplierMapper.supplier_infoPageCount();
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
		
		
		
		
		/*List<Supplier> SuList = supplierMapper.supplier_info2();
		request.setAttribute("SuList", SuList);*/
		return map;
	}
	//供应商信息增加
	@Override
	public HashMap<String, Object> Q_SuppInsertByMess(HttpServletRequest request, HttpServletResponse response, int page,
			int row) {
		String company = request.getParameter("company2");
		String wner = request.getParameter("wner2");
		String adress = request.getParameter("adress2");
		String telephone = request.getParameter("telephone2");
		String des = request.getParameter("des2");
		Supplier supplier = new Supplier();
		supplier.setDes(des);
		supplier.setAdress(adress);
		supplier.setCompany(company);
		supplier.setTelephone(telephone);
		supplier.setWner(wner);
		supplierMapper.Q_SuppInsertByMess(supplier);
		System.out.println("------供应商信息增加成功-----------------");
		System.out.println("------------------分页");
		HashMap<String, Object> map = new LinkedHashMap<>();
		//计算mysql数据库查询的起始位置
				int start = row * (page-1);
				//查询当前页的结果集
		List<Customer> list = supplierMapper.supplier_info(start,row);
		//查询总条数
				int total = supplierMapper.supplier_infoPageCount();
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
		
		
		
		
		
	/*	List<Supplier> SuList = supplierMapper.supplier_info();
		request.setAttribute("SuList", SuList);*/
		return map;
	}
	
	//供应商信息模糊查询--多字段
	@Override
	public String Q_SupSelectMessage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			try {
				PrintWriter pw = response.getWriter();
				
				
				String message  = request.getParameter("message");
				if (message=="" || message==null) {
					pw.print("err");
				}else {
					String messageSt = "%"+message+"%";
					List<Supplier> sList = supplierMapper.Q_SupSelectMessage(messageSt);
					System.out.println("-----供应商信息模糊查询成功--------"+sList);
					Gson gson = new Gson();
					String sListSt = gson.toJson(sList);
					pw.print(sListSt);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	

}
