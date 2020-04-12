package com.fs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.mapper.FinancialMapper;
import com.fs.model.Audit;
import com.fs.model.Product;
import com.fs.service.FinancialService;

/**
 * @author Mr-Yang
 *
 */
@Service
public class FinancialServiceImpl implements FinancialService {
	@Autowired
	private FinancialMapper financialMapper;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------

	@Override
	public List<Product> queryProductBycatagory(String catagorg) {
		
		return financialMapper.queryProductBycatagory(catagorg);
	}

	@Override
	public List<Audit> queryAllAudit() {
		
		return financialMapper.queryAllAudit();
	}

	@Override
	public List<Audit> queryAuditByCatagorg(String catagorg) {
		
		return financialMapper.queryAuditByCatagorg(catagorg);
	}

	@Override
	public List<Audit> queryAllOutAudit() {
		
		return financialMapper.queryAllOutAudit();
	}

	


	@Override
	public int querySingleCostByName(int id) {
		
		return financialMapper.querySingleCostByName(id);
	}

	@Override
	public List<Audit> queryAllOutAuditByCatagorg(String catagorg) {
		
		return financialMapper.queryAllOutAuditByCatagorg(catagorg);
	}

	@Override
	public List<Product> queryAllProduct() {
		
		return financialMapper.queryAllProduct();
	}

	@Override
	public List<Audit> queryAuditSecondCheck() {
		
		return financialMapper.queryAuditSecondCheck();
	}

	@Override
	public Audit queryAuditById(int id) {
		
		return financialMapper.queryAuditById(id);
	}

	@Override
	public int updateAuditByName(String name,int id) {
		
		return financialMapper.updateAuditByName(name,id);
	}

	@Override
	public Product queryProductByProductName(String productName) {
		
		return financialMapper.queryProductByProductName(productName);
	}

	@Override
	public int updateProductByPriceAndNumber(double newprice, double newnumber,int pro_id) {
		int price=(int)newprice;
		String cost=String.valueOf(price);
		int number=(int)newnumber;
		return financialMapper.updateProductByPriceAndNumber(cost,number,pro_id);
	}

	@Override
	public int updateProductByNumber(double newnumber,int id) {
		int number=(int)newnumber;
		return financialMapper.updateProductByNumber(number,id);
	}

	@Override
	public int noPass(int id,String name) {
		
		return financialMapper.noPass(id,name);
	}


	@Override
	public List<Audit> queryAuditByName(String name,String timeType) {
		
		return financialMapper.queryAuditByName(name,timeType);
	}

	@Override
	public List<String> queryAllBround() {
		
		return financialMapper.queryAllBround();
	}

//	@Override
//	public List<Product> queryProductByBround(String string) {
//		
//		return financialMapper.queryProductByBround(string);
//	}

	@Override
	public List<Audit> queryAllAuditByBround(String string) {
		
		return financialMapper.queryAllAuditByBround(string);
	}

	@Override
	public List<Audit> queryAllOutAuditByBround(String string) {
		
		return financialMapper.queryAllOutAuditByBround(string);
	}

	@Override
	public List<Product> queryAllProductByGoodsType(String goodsType) {
		
		return financialMapper.queryAllProductByGoodsType(goodsType);
	}

	@Override
	public List<Audit> queryAllAuditByBround_Statistic(String string,String timeType) {
		
		return financialMapper.queryAllAuditByBround_Statistic(string,timeType);
	}

	@Override
	public List<Audit> queryAllAuditByBround_ChuKu(String string) {
		
		return financialMapper.queryAllAuditByBround_ChuKu(string);
	}

	@Override
	public String queryCostByName(String productName) {
		
		return financialMapper.queryCostByName(productName);
	}

	@Override
	public String queryBroundById(int id) {
		
		return financialMapper.queryBroundById(id);
	}

	@Override
	public List<String> quertAllProductByBround(String bround) {
		
		return financialMapper.quertAllProductByBround(bround);
	}

	@Override
	public List<Audit> queryAuditByProName(String string) {
		
		return financialMapper.queryAuditByProName(string);
	}

	@Override
	public HashMap<String, Object> queryProductByBround(String string, int page, int row) {
		
         HashMap<String,Object> map=new LinkedHashMap<>();
		
			//每一页的起始位置
			int start=row*(page-1);
			
			
			
			 List<Product> products= new ArrayList<>();
			
			int total=financialMapper.selectCountByString(string);
			
			int totalPage;
			
			if(total%row==0) {
				totalPage=total/row;
			}else {
				totalPage=total/row+1;
			}
			
			
			
			//如果当前页比总页数还大，就还原到第一页
			if(totalPage<page) {
				start=0;
			    products=financialMapper.queryProductByBround(string,start,row);
			    map.put("list",products);
				map.put("total",total);
				map.put("totalPage",totalPage);
				map.put("currentPage",page);
				return map;
			}else {
				
				int restCount=total-start;
				if(restCount<row) {
					products=financialMapper.queryProductByBround(string,start,restCount);
				    map.put("list",products);
					map.put("total",total);
					map.put("totalPage",totalPage);
					map.put("currentPage",page);
				}else {
					System.out.println("这里进入queryProductByBround方法");
					System.out.println("catagorg:"+string+ "page:"+page+" row:"+row);
					products=financialMapper.queryProductByBround(string,start,row);
				    map.put("list",products);
					map.put("total",total);
					map.put("totalPage",totalPage);
					map.put("currentPage",page);
				}

				
			}
					
			
			return map;
		//每一页的起始位置
//		int start=row*(page-1);
//		
//		List<Product> products=financialMapper.queryProductByBround(string,start,row);
//		
//		int total=financialMapper.selectCount(string);
//		
//		int totalPage;
//		
//		if(total%row==0) {
//			totalPage=total/row;
//		}else {
//			totalPage=total/row+1;
//		}
//		
//		System.out.println(totalPage);
//		
//		map.put("list",products);
//		map.put("total",total);
//		map.put("totalPage",totalPage);
//		map.put("currentPage",page);
//		
//		
//		return map;
	}

	@Override
	public HashMap<String, Object> queryProductByBround_1(String catagorg,String mohu, int page, int row) {
		
		
		 HashMap<String,Object> map=new HashMap<>();
			
			String sear="%"+mohu+"%";
			//每一页的起始位置
			int start=row*(page-1);
			
			
			
			 List<Product> products= new ArrayList<>();
			
			int total=financialMapper.selectCount(catagorg,sear);
			
			int totalPage;
			
			if(total%row==0) {
				totalPage=total/row;
			}else {
				totalPage=total/row+1;
			}
			
			
			
			//如果当前页比总页数还大，就还原到第一页
			if(totalPage<page) {
				start=0;
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println(catagorg+" "+sear+" "+start+" "+row);
			    products=financialMapper.queryProductByBround_1(catagorg,sear,start,row);
			    map.put("list",products);
				map.put("total",total);
				map.put("totalPage",totalPage);
				map.put("currentPage",page);
				return map;
			}else {
				
				int restCount=total-start;
				if(restCount<row) {
					products=financialMapper.queryProductByBround_1(catagorg,sear,start,restCount);
				    map.put("list",products);
					map.put("total",total);
					map.put("totalPage",totalPage);
					map.put("currentPage",page);
				}else {
					System.out.println("这里进入queryProductByBround_1方法");
					System.out.println("catagorg:"+catagorg+" mohu:"+mohu+" page:"+page+" row:"+row);
					products=financialMapper.queryProductByBround_1(catagorg,sear,start,row);
				    map.put("list",products);
					map.put("total",total);
					map.put("totalPage",totalPage);
					map.put("currentPage",page);
				}

				
			}
					
			
			return map;
	}

	@Override
	public List<Audit> queryAllAuditByProName(String name, String timeType) {
		
		return financialMapper.queryAllAuditByProName(name, timeType);
	}

	@Override
	public List<String> queryAllProductByGoods(String goodsType) {
		
		return financialMapper.queryAllProductByGoods(goodsType);
	}

	@Override
	public List<String> queryAllBroundNoCondition() {
		
		return financialMapper.queryAllBroundNoCondition();
	}

	@Override
	public List<String> searAllProduct(String goodsType) {
		
		return financialMapper.searAllProduct(goodsType);
	}

	@Override
	public List<Audit> queryAuditByTimeAndBround(String string, String timeType) {
		
		return financialMapper.queryAuditByTimeAndBround(string,timeType);
	}

	@Override
	public List<Audit> queryAllSellAuditByProName(String string, String timeType) {
		
		return financialMapper.queryAllSellAuditByProName(string, timeType);
	}

	@Override
	public List<Audit> queryAuditSecondCheck_Success() {
		
		return financialMapper.queryAuditSecondCheck_Success();
	}

	@Override
	public List<Audit> queryAuditSecondCheck_SuccessByCondition(String timeType, String catagorg) {
		
		return financialMapper.queryAuditSecondCheck_SuccessByCondition(timeType,catagorg);
	}

	@Override
	public List<Audit> queryAllAuditByMonth(int month) {
		
		return financialMapper.queryAllAuditByMonth(month);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
