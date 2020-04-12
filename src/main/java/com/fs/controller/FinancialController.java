package com.fs.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fs.model.Audit;
import com.fs.model.Goods;
import com.fs.model.Product;
import com.fs.model.Product1;
import com.fs.model.Statistic;
import com.fs.model.User;
import com.fs.service.FinancialService;
import com.sun.mail.util.MailSSLSocketFactory;

//import jdk.management.resource.internal.TotalResourceContext;

/**
 * @author Mr-Yang
 *
 */
@Controller
public class FinancialController {
	
	@Autowired
	private FinancialService financialService;
	
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------
	
	//跳转到财务管理的审核
	@RequestMapping("commercial_check")
	public String commercial_check(HttpServletRequest request,HttpServletResponse response) {
		
		List<Audit> auditList=new ArrayList<Audit>();
		
		auditList=financialService.queryAuditSecondCheck();
		request.setAttribute("auditList",auditList);
		
		
		return "view/financialManage/commercial_check";
	}
	
	@RequestMapping("commercial_cost")
	public String commer(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "2") int row) {
		
		//1:拿到所有商品品牌
		List<String> broundList=new ArrayList<>();
		broundList=financialService.queryAllBround();
		
		HashMap<String,Object> map=financialService.queryProductByBround("华为",page,row);
		request.setAttribute("info",map);
		
		//拿到所有时间
//				List<String> time=new ArrayList<String>();
//				time.add("一周内");
//				time.add("一月内");
//				time.add("三月内");
//				time.add("一年内");
//				String timeType="一周内";
//				request.setAttribute("time",time);
//				request.setAttribute("timeType",timeType);    //默认选中一周内
		
		//List<Product> product_list=new ArrayList<>();
	//	product_list=financialService.queryProductByBround("华为",page,row);
//		double totalCost=0;
//		double totalPrice=0;
//		double totalProfit=0;
//		for(int i=0;i<product_list.size();i++) {
//			totalCost+=Integer.parseInt(product_list.get(i).getCost());
//			totalPrice+=Integer.parseInt(product_list.get(i).getPrice());
//			
//		}
//		totalProfit=totalPrice-totalCost;
//		request.setAttribute("product_list",product_list);
//		request.setAttribute("totalCost",totalCost);
//		request.setAttribute("totalPrice",totalPrice);
//		request.setAttribute("totalProfit",totalProfit);
		
		request.setAttribute("catagorg","华为");
		request.setAttribute("broundList",broundList);
		
		return "view/financialManage/commercial_cost";
	}
	
	
	
	//跳转到财务管理的商业成本
	@RequestMapping("commercial_cost_1")
	public String commercial_cost(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "2") int row) {
		//1:拿到所有商品品牌
		List<String> broundList=new ArrayList<>();
		broundList=financialService.queryAllBround();

		String catagorg=request.getParameter("catagorg");
		String mohu=request.getParameter("mohu");

		if(mohu!="" && mohu!=null) {
			HashMap<String,Object> map=financialService.queryProductByBround_1(catagorg,mohu,page,row);

			request.setAttribute("info",map);
		}else {
			HashMap<String,Object> map=financialService.queryProductByBround(catagorg,page,row);

			request.setAttribute("info",map);
		}
		// List<Product> product_list=new ArrayList<>();
		
		//request.setAttribute("mohu",mohu);
		
	//	product_list=financialService.queryProductByBround_1(catagorg,page,row);
//		System.out.println(product_list);
//		double totalCost=0;
//		double totalPrice=0;
//		double totalProfit=0;
//		for(int i=0;i<product_list.size();i++) {
//			totalCost+=Integer.parseInt(product_list.get(i).getCost());
//			totalPrice+=Integer.parseInt(product_list.get(i).getPrice());
//			
//		}
//		totalProfit=totalPrice-totalCost;
//		request.setAttribute("product_list",product_list);
//		request.setAttribute("totalCost",totalCost);
//		request.setAttribute("totalPrice",totalPrice);
//		request.setAttribute("totalProfit",totalProfit);
		request.setAttribute("catagorg",catagorg);
		
		request.setAttribute("broundList",broundList);
		request.setAttribute("mohu",mohu);
		return "view/financialManage/commercial_cost";
	}
	
	
	//跳转到财务管理的营业额
	@RequestMapping("commercial_revenue")
	public String commercial_revenue(HttpServletRequest request,HttpServletResponse response) {
		
		//1:拿到所有商品品牌
		List<String> broundList=new ArrayList<>();
		broundList=financialService.queryAllBround();
		String catagorg="华为";
		request.setAttribute("broundList",broundList);
		request.setAttribute("catagorg",catagorg);     //默认选中华为
		
		//拿到所有时间
		List<String> time=new ArrayList<String>();
		time.add("一周内");
		time.add("一月内");
		time.add("三月内");
		time.add("一年内");
		String timeType="一周内";
		request.setAttribute("time",time);
		request.setAttribute("timeType",timeType);    //默认选中一周内
		
		
		List<Product> lists=new ArrayList<>();
		
		lists=financialService.queryAllProductByGoodsType(catagorg);
		System.out.println(lists);
		List<Goods> goodList=new ArrayList<Goods>();
		for(int i=0;i<lists.size();i++) {
			Goods goods=new Goods();
			goods.setGoods_name(lists.get(i).getName());
			
			//接下来计算每个商品的售出总成本
			//1:根据商品名称找到所有售出的审核，然后将成本相加
			List<Audit> auditList=new ArrayList<Audit>();
			auditList=financialService.queryAuditByName(lists.get(i).getName(),timeType);
			long sellTotalCost=0;
			long sellTotalPrice=0;
			for(int j=0;j<auditList.size();j++) {
				sellTotalCost+=Integer.parseInt(lists.get(i).getCost())*auditList.get(j).getNumber();    //售出总成本
				sellTotalPrice+=Integer.parseInt(auditList.get(j).getPrice())*auditList.get(j).getNumber();  //售出总金额
			}
			goods.setGoodsTotalCost(sellTotalCost);
			goods.setGoodsTotalPrice(sellTotalPrice);
			goods.setGoodsTotalProfit(sellTotalPrice-sellTotalCost);
			goods.setFreeNumber(lists.get(i).getNumber());
			goodList.add(goods);
			
		}
		
		//Set<Product> pro_list=new HashSet<Product>();
		request.setAttribute("goodList",goodList);
		
		//System.out.println(timeType+"---------------------"+goodsType);
		return "view/financialManage/commercial_revenue";
		
	}
	
	@RequestMapping("financial_catagory")
	@ResponseBody
	public String financial_catagory(HttpServletRequest request,HttpServletResponse response) {
		String catagory=request.getParameter("catagory");
		List<Product> product_list=new ArrayList<>();

		product_list=financialService.queryProductBycatagory(catagory);

		double totalCost=0;
		double totalPrice=0;
		double totalProfit=0;
		for(int i=0;i<product_list.size();i++) {
			totalCost+=Integer.parseInt(product_list.get(i).getCost());
			totalPrice+=Integer.parseInt(product_list.get(i).getPrice());
			
		}
		totalProfit=totalPrice-totalCost;
		request.setAttribute("product_list",product_list);
		request.setAttribute("totalCost",totalCost);
		request.setAttribute("totalPrice",totalPrice);
		request.setAttribute("totalProfit",totalProfit);
		request.setAttribute("catagorg",catagory);
		
		return "success";
	}
	
	
	
	@RequestMapping("goInInventoryMain")
	public void goinmain(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		//拿到所有时间
//				List<String> time=new ArrayList<String>();
//				time.add("一周内");
//				time.add("一月内");
//				time.add("三月内");
//				time.add("一年内");
				String timeType="一月内";
//				request.setAttribute("time",time);
//				request.setAttribute("timeType",timeType);    //默认选中一周内
		//入库统计首页是统计出不同类别商品在一个月内的总入库数量，入库的总成本
		//1:首先根据产品表来找出所有的类别
		List<String> bround_list=new ArrayList<>();
		bround_list=financialService.queryAllBround();
		System.out.println("进入了goInvenMain方法，拿到全部品牌");
		System.out.println(bround_list);
		//bround_list.add("全部");


		List<Statistic> stList=new ArrayList<>();

		//2:然后根据类别找出所有产品，将所有产品的一个月内的入库数量相加得到总入库数量，成本相加得到总成本
		//将商品类别，总入库，总价格（成本或者销售），写在另外一个实体中
		
		for(int i=0;i<bround_list.size();i++) {
			Statistic st=new Statistic();
			List<Audit> auditList=new ArrayList<>();
			long totalRuKuCost=0;    
			long totalRuKuNumber=0;
			auditList=financialService.queryAllAuditByBround_Statistic(bround_list.get(i),timeType);    //根据品牌查询出所有一周内入库的商品
			st.setBround(bround_list.get(i));
			for(int j=0;j<auditList.size();j++) {
				totalRuKuCost+=(Integer.parseInt(auditList.get(j).getPrice()))*auditList.get(j).getNumber();  //入库总成本
				totalRuKuNumber+=auditList.get(j).getNumber();
				
			}
			st.setTotalRuKuCost(totalRuKuCost);
			st.setTotalRuKuNumber(totalRuKuNumber);
			System.out.println(totalRuKuCost+" "+totalRuKuNumber );
			stList.add(st);
		}
		System.out.println("下面打印stList");
		System.out.println(stList);

		//将数据转化为json对象
		ObjectMapper mapper=new ObjectMapper();

			String json=mapper.writeValueAsString(stList);
			response.setContentType("text/html;charset=utf-8");

				response.getWriter().write(json);		
		
		//return "view/financialManage/goInInventoryMain";
	}
	
	
	@RequestMapping("goOutInventoryMain")
	public void gooutmain(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		//拿到所有时间
//				List<String> time=new ArrayList<String>();
//				time.add("一周内");
//				time.add("一月内");
//				time.add("三月内");
//				time.add("一年内");
//				String timeType="一周内";
//				request.setAttribute("time",time);
//				request.setAttribute("timeType",timeType);    //默认选中一周内
		//出库统计首页是统计出不同类别商品在一个月内的总出库数量，入库的总售价
		//1:首先根据产品表来找出所有的类别
		String timeType="一月内";
		List<String> bround_list=new ArrayList<>();
		bround_list=financialService.queryAllBround();


		List<Statistic> stList=new ArrayList<>();

		//2:然后根据类别找出所有产品，将所有产品的一个月内的出库数量相加得到总出库数量，价格相加得到总售价
		//将商品类别，总入库，总价格（成本或者销售），写在另外一个实体中
		
		for(int i=0;i<bround_list.size();i++) {
			Statistic st=new Statistic();
			List<Audit> auditList=new ArrayList<>();
			long totalChuKuPrice=0;    
			long totalChuKuNumber=0;
			auditList=financialService.queryAuditByTimeAndBround(bround_list.get(i),timeType);    //根据品牌查询出所有已经出库的商品
			st.setBround(bround_list.get(i));
			for(int j=0;j<auditList.size();j++) {
				totalChuKuPrice+=(Integer.parseInt(auditList.get(j).getPrice()))*auditList.get(j).getNumber();  //出库总售价
				totalChuKuNumber+=auditList.get(j).getNumber();
				
			}
			st.setTotalChuKuPrice(totalChuKuPrice);
			st.setTotalChuKuNumber(totalChuKuNumber);
			stList.add(st);
		}

		//将数据转化为json对象
		ObjectMapper mapper=new ObjectMapper();

			String json=mapper.writeValueAsString(stList);
			response.setContentType("text/html;charset=utf-8");

				response.getWriter().write(json);		
		
		//return "view/financialManage/goInInventoryMain";
	}
	
	@RequestMapping("commercial_revenue_statistic")
	public void gostatisticmain(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		//拿到所有时间
//				List<String> time=new ArrayList<String>();
//				time.add("一周内");
//				time.add("一月内");
//				time.add("三月内");
//				time.add("一年内");
//				String timeType="一周内";
//				request.setAttribute("time",time);
//				request.setAttribute("timeType",timeType);    //默认选中一周内
		//出库统计首页是统计出不同类别商品在一个月内的总出库数量，入库的总售价
		//1:首先根据产品表来找出所有的类别
		List<String> bround_list=new ArrayList<>();
		bround_list=financialService.queryAllBround();


		List<Statistic> stList=new ArrayList<>();

		//2:然后根据类别找出所有产品，将所有产品的一个月内的出库数量相加得到总出库数量，价格相加得到总售价
		//将商品类别，总入库，总价格（成本或者销售），写在另外一个实体中
		
		for(int i=0;i<bround_list.size();i++) {
			Statistic st=new Statistic();
			List<Audit> auditList=new ArrayList<>();   
			long totalProfit=0;
			int cost=0;
			auditList=financialService.queryAllAuditByBround_ChuKu(bround_list.get(i));    //根据品牌查询出所有已经出库的商品
			st.setBround(bround_list.get(i));
			for(int j=0;j<auditList.size();j++) {
				cost=Integer.parseInt(financialService.queryCostByName(auditList.get(j).getProductName()));
				totalProfit+=((Integer.parseInt(auditList.get(j).getPrice()))*auditList.get(j).getNumber()-cost*auditList.get(j).getNumber());  //出库总售价-总成本
				
			}
			st.setTotalProfit(totalProfit);

			stList.add(st);
		}
		
		
		//要做两件事，将四个月之内公司的盈利状况收集起来，name=月，value=盈利金额；要跳转到页面.
				//收集1,2,3,4内个营利
				List<Long> Profit=new ArrayList<>();
				for(int j=1;j<4;j++) {
					List<Audit> audit_list=new ArrayList<>();
					audit_list=financialService.queryAllAuditByMonth(j);
					long totalProfit=0;
					for(int i=0;i<audit_list.size();i++) {
						String proName=audit_list.get(i).getProductName();
						int cost=Integer.parseInt(financialService.queryCostByName(proName));
						totalProfit+=(Integer.parseInt(audit_list.get(i).getPrice())*audit_list.get(i).getNumber()-cost*audit_list.get(i).getNumber());   
					}
					Profit.add(totalProfit);
				}
				//request.setAttribute("num", Profit);

				
				Calendar date = Calendar.getInstance();
				int year = Integer.parseInt(String.valueOf(date.get(Calendar.YEAR)));
				int month=Integer.parseInt(String.valueOf(date.get(Calendar.MONTH)));
				List<String> timeNumber=new ArrayList<>();
				
				for(int m=0;m<3;m++) {
					if(month==0) {
						year--;
						month=12;
						String monthYue = month+"月";
						String yearNian=year+"年";
						timeNumber.add(yearNian+""+monthYue);
						month--;
						
					}else {
						String monthYue=month+"月";
						String yearNian=year+"年";
						timeNumber.add(yearNian+""+monthYue);	
						month--;
					}	
				}
				//request.setAttribute("name",timeNumber);
				for(int i=0;i<3;i++) {
					Statistic st=new Statistic();
					stList.get(i).setTimeType(timeNumber.get(i));
					stList.get(i).setMoneyCompare(Profit.get(i));
				}
				
				

		//将数据转化为json对象
		ObjectMapper mapper=new ObjectMapper();

			String json=mapper.writeValueAsString(stList);
			response.setContentType("text/html;charset=utf-8");

				response.getWriter().write(json);		
		
		//return "view/financialManage/goInInventoryMain";
	}
	
	
	@RequestMapping("goInInventory")               //入库统计
	public String goIn(HttpServletRequest request,HttpServletResponse response) {
		
		//1:拿到所有商品品牌
		List<String> broundList=new ArrayList<>();
		broundList=financialService.queryAllBround();
		
		List<Audit> auditList =new ArrayList<>();
		auditList=financialService.queryAllAuditByBround("华为");
		double totalCost=0;
		for(int i=0;i<auditList.size();i++) {
			totalCost+=(Integer.parseInt(auditList.get(i).getPrice()))*(auditList.get(i).getNumber());
			auditList.get(i).setStatisticCost((Integer.parseInt(auditList.get(i).getPrice()))*(auditList.get(i).getNumber()));
		}
		request.setAttribute("totalCost",totalCost);
		request.setAttribute("auditList",auditList);
		request.setAttribute("broundList",broundList);
		request.setAttribute("catagorg","华为");
		return "view/financialManage/goInInventory";
	}
	
	//根据选中的商品对入库流水进行统计
	@RequestMapping("ruku_catagorg")              //这里有问题
	public String rukusta(HttpServletRequest request,HttpServletResponse response) {
		
		//1:拿到所有商品品牌
		List<String> broundList=new ArrayList<>();
		broundList=financialService.queryAllBround();
		String catagorg=request.getParameter("catagorg");

		List<Audit> auditList=new ArrayList<>();
		auditList=financialService.queryAuditByCatagorg(catagorg);

		double totalCost=0;
		for(int i=0;i<auditList.size();i++) {
			totalCost+=(Integer.parseInt(auditList.get(i).getPrice()))*(auditList.get(i).getNumber());
			auditList.get(i).setStatisticCost((Integer.parseInt(auditList.get(i).getPrice()))*(auditList.get(i).getNumber()));
		}
		request.setAttribute("auditList",auditList);
		request.setAttribute("totalCost",totalCost);
		request.setAttribute("broundList",broundList);
		request.setAttribute("catagorg",catagorg);
		return "view/financialManage/goInInventory";
		
	}
	
	@RequestMapping("goOutInventory")
	public String goOut(HttpServletRequest request,HttpServletResponse response) {
		
		//1:拿到所有商品品牌
		List<String> broundList=new ArrayList<>();
		broundList=financialService.queryAllBround();
		
		List<Audit> auditList =new ArrayList<>();
		auditList=financialService.queryAllOutAuditByBround("华为");
		double totalCost=0;                                    //所有商品总成本
		double totalPrice=0;                                   //所有商品总价格
		double totalProfit=0;                                  //所有商品总利润
		int singleCost=0;                                      //单个商品的成本，对应goodsCost
		for(int i=0;i<auditList.size();i++) {
			singleCost=financialService.querySingleCostByName(auditList.get(i).getAuditId());
			auditList.get(i).setGoodsCost(singleCost);
			auditList.get(i).setStatisticCost(singleCost*(auditList.get(i).getNumber()));   //单个商品总成本
			auditList.get(i).setStatisticPrice(Integer.parseInt(auditList.get(i).getPrice())*auditList.get(i).getNumber()); //单个商品总售价
			auditList.get(i).setStaticticProfit(Integer.parseInt(auditList.get(i).getPrice())*auditList.get(i).getNumber()-singleCost*(auditList.get(i).getNumber()));  //单个商品总利润	
			totalCost+=auditList.get(i).getStatisticCost();
			totalPrice+=auditList.get(i).getStatisticPrice();
			totalProfit+=auditList.get(i).getStaticticProfit();
		}
		request.setAttribute("totalCost",totalCost);
		request.setAttribute("totalPrice",totalPrice);
		request.setAttribute("totalProfit",totalProfit);
		request.setAttribute("auditList",auditList);
		request.setAttribute("broundList",broundList);
		request.setAttribute("catagorg","华为");
		return "view/financialManage/goOutInventory";
	}
	
	@RequestMapping("goOutCatagorg")
	public String goOutCatagorg(HttpServletRequest request,HttpServletResponse response) {
		
		//1:拿到所有商品品牌
		List<String> broundList=new ArrayList<>();
		broundList=financialService.queryAllBround();
		
		String catagorg=request.getParameter("catagorg");
		List<Audit> auditList =new ArrayList<>();
		auditList=financialService.queryAllOutAuditByCatagorg(catagorg);
		double totalCost=0;                                    //所有商品总成本
		double totalPrice=0;                                   //所有商品总价格
		double totalProfit=0;                                  //所有商品总利润
		int singleCost=0;                                      //单个商品的成本，对应goodsCost
		for(int i=0;i<auditList.size();i++) {
			singleCost=financialService.querySingleCostByName(auditList.get(i).getAuditId());
			auditList.get(i).setGoodsCost(singleCost);
			auditList.get(i).setStatisticCost(singleCost*(auditList.get(i).getNumber()));   //单个商品总成本
			auditList.get(i).setStatisticPrice(Integer.parseInt(auditList.get(i).getPrice())*auditList.get(i).getNumber()); //单个商品总售价
			auditList.get(i).setStaticticProfit(Integer.parseInt(auditList.get(i).getPrice())*auditList.get(i).getNumber()-singleCost*(auditList.get(i).getNumber()));  //单个商品总利润	
			totalCost+=auditList.get(i).getStatisticCost();
			totalPrice+=auditList.get(i).getStatisticPrice();
			totalProfit+=auditList.get(i).getStaticticProfit();
		}
		request.setAttribute("totalCost",totalCost);
		request.setAttribute("totalPrice",totalPrice);
		request.setAttribute("totalProfit",totalProfit);
		request.setAttribute("auditList",auditList);
		request.setAttribute("broundList",broundList);
		request.setAttribute("catagorg",catagorg);
		return "view/financialManage/goOutInventory";
	}
	
	@RequestMapping("moneyStatistic")
	public String moneyStatistic(HttpServletRequest request,HttpServletResponse response) {
		List<Product> product=new ArrayList<>();
		product=financialService.queryAllProduct();    //每个商品的成本
		List<Map> mapList=new ArrayList<Map>();
		Set<String> nameList=new HashSet<String>();
		for(int i=0;i<product.size();i++) {
			nameList.add(product.get(i).getCatagorg());

		}

		
		Iterator i=nameList.iterator();
		while(i.hasNext()) {
			String catagorg=(String)i.next();
			double totalCost=0;
			for(int m=0;m<product.size();m++) {
				if(product.get(m).getCatagorg().equals(catagorg)) {
					totalCost+=Integer.parseInt(product.get(m).getCost());
				}
			}
			Map<String,Double> map=new HashMap<String,Double>();
			map.put(catagorg,totalCost);
			mapList.add(map);
		}
		
		//System.out.println(mapList);
		request.setAttribute("mapList",mapList);
		

		
		return "view/financialManage/moneyStatistic";
	}
	
	@RequestMapping("passCheck")                        
	public String passCheckaop(HttpServletRequest request,HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		Audit audit=financialService.queryAuditById(id);

		if(audit!=null) {                                               //这里可以考虑下是否可以用事务
			User user=(User)request.getSession().getAttribute("USER");
			String name=user.getName();          //得到真实姓名 
			int m=financialService.updateAuditByName(name,id);
			
			
			
			if(audit.getDepSend().equals("invenDep")) {
				String productName=audit.getProductName();
				double oneprice=(Integer.parseInt(audit.getPrice()));
				int onenumber =audit.getNumber();
				
				Product product=financialService.queryProductByProductName(productName);
				int pro_id=product.getProId();
				double twoprice=Integer.parseInt(product.getCost());
				double twonumber=product.getNumber();
				double newprice=0;
				double newnumber=0;
				if(twoprice>oneprice) {
					newprice=twoprice;
				}else {
					newprice=oneprice;
				}
				newnumber=onenumber+twonumber;
				int n=financialService.updateProductByPriceAndNumber(newprice,newnumber,pro_id);
				
			}else if(audit.getDepSend().equals("sellDep")) {
				String productName=audit.getProductName();
				int onenumber =audit.getNumber();
				Product product=financialService.queryProductByProductName(productName);
				int p_id=product.getProId();
				double twonumber=product.getNumber();
				double newnumber=twonumber-onenumber;
				int a=financialService.updateProductByNumber(newnumber,p_id);
				
			}

		}
		return commercial_check(request,response);

		
		
		
	}
	
	@RequestMapping("nopassCheck")
	public String onpassCheckaop(HttpServletRequest request,HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id========================="+id);
		User  user=(User)request.getSession().getAttribute("USER");
		String name=user.getName();

			int m=financialService.noPass(id,name);
			return commercial_check(request,response);

		
		
				

}
	
	
	
	@RequestMapping("businessValue")
	public String businessValue(HttpServletRequest request,HttpServletResponse response) {
		String timeType=request.getParameter("timeType");
		String goodsType=request.getParameter("goodsType");
		
		//1:拿到所有商品品牌
				List<String> broundList=new ArrayList<>();
				broundList=financialService.queryAllBround();
				String catagorg=request.getParameter("goodsType");
				request.setAttribute("broundList",broundList);
				request.setAttribute("catagorg",catagorg);     //默认选中华为
				
				//拿到所有时间
				List<String> time=new ArrayList<String>();
				time.add("一周内");
				time.add("一月内");
				time.add("三月内");
				time.add("一年内");
				request.setAttribute("time",time);
				request.setAttribute("timeType",timeType);    //默认选中一周内
		

		List<Product> lists=new ArrayList<>();
		
		lists=financialService.queryAllProductByGoodsType(goodsType);
		System.out.println(lists);
		List<Goods> goodList=new ArrayList<Goods>();
		for(int i=0;i<lists.size();i++) {
			Goods goods=new Goods();
			goods.setGoods_name(lists.get(i).getName());
			
			//接下来计算每个商品的售出总成本
			//1:根据商品名称找到所有售出的审核，然后将成本相加
			List<Audit> auditList=new ArrayList<Audit>();
			auditList=financialService.queryAuditByName(lists.get(i).getName(),timeType);
			long sellTotalCost=0;
			long sellTotalPrice=0;
			for(int j=0;j<auditList.size();j++) {
				sellTotalCost+=Integer.parseInt(lists.get(i).getCost())*auditList.get(j).getNumber();    //售出总成本
				sellTotalPrice+=Integer.parseInt(auditList.get(j).getPrice())*auditList.get(j).getNumber();  //售出总金额
			}
			goods.setGoodsTotalCost(sellTotalCost);
			goods.setGoodsTotalPrice(sellTotalPrice);
			goods.setGoodsTotalProfit(sellTotalPrice-sellTotalCost);
			goods.setFreeNumber(lists.get(i).getNumber());
			goodList.add(goods);
			
		}
		
		//Set<Product> pro_list=new HashSet<Product>();
		request.setAttribute("goodList",goodList);
		
		//System.out.println(timeType+"---------------------"+goodsType);
		return "view/financialManage/commercial_revenue";
		
	}
	
	
	
	
	@RequestMapping("productCheckStatistic")
	public void productCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id=Integer.parseInt(request.getParameter("audit_id"));
		System.out.println(id);
		//1:根据Id拿到对应商品,然后根据商品名称拿到对应类别的所有商品
		String bround=financialService.queryBroundById(id);
		List<String> proList=new ArrayList<>();
		System.out.println("-----------------------------------------------------------------------");
		proList=financialService.quertAllProductByBround(bround);
		System.out.println(proList);
		List<Statistic> stList=new ArrayList<>();
		long totalPrice=0;     //所有商品的总利润
		for(int i=0;i<proList.size();i++) {
			long totalProfit=0;
			List<Audit> auditList=new ArrayList<>();
			auditList=financialService.queryAuditByProName(proList.get(i));   //拿到所有审核单
			for(int j=0;j<auditList.size();j++) {
				int cost=Integer.parseInt(financialService.queryCostByName(auditList.get(j).getProductName()));
				totalProfit+=(Integer.parseInt(auditList.get(j).getPrice())*auditList.get(j).getNumber()-cost*auditList.get(j).getNumber());
			}
			totalPrice+=totalProfit;
		}
		System.out.println("totalPrice=================="+totalPrice);
		//2::根据商品名称拿到所有出库的营业额
		for(int i=0;i<proList.size();i++) {
			Statistic st=new Statistic();
			st.setProductName(proList.get(i));
			List<Audit> auditList=new ArrayList<>();
			auditList=financialService.queryAuditByProName(proList.get(i));   //拿到所有审核单
			//double profitRadio=0.0;
			
			long totalProfit=0;
			int cost=0;
			for(int j=0;j<auditList.size();j++) {
				cost=Integer.parseInt(financialService.queryCostByName(auditList.get(j).getProductName()));
				totalProfit+=(Integer.parseInt(auditList.get(j).getPrice())*auditList.get(j).getNumber()-cost*auditList.get(j).getNumber());
			}
			st.setTotalProfit(totalProfit);
			st.setProfitRadio(totalProfit/(double)totalPrice);
			stList.add(st);
			
		}
					ObjectMapper mapper = new ObjectMapper(); 	
					String json = mapper.writeValueAsString(stList); // 将list中的对象转换为Json字符串
		
					System.out.println(json);
		
					// 将json字符串数据返回给前端
					response.setContentType("text/html; charset=utf-8");
					response.getWriter().write(json);
					
					
//					for(int i=0;i<bround_list.size();i++) {
//						Statistic st=new Statistic();
//						List<Audit> auditList=new ArrayList<>();   
//						long totalProfit=0;
//						int cost=0;
//						auditList=financialService.queryAllAuditByBround_ChuKu(bround_list.get(i));    //根据品牌查询出所有已经出库的商品
//						st.setBround(bround_list.get(i));
//						for(int j=0;j<auditList.size();j++) {
//							cost=Integer.parseInt(financialService.queryCostByName(auditList.get(j).getProductName()));
//							totalProfit+=((Integer.parseInt(auditList.get(j).getPrice()))*auditList.get(j).getNumber()-cost*auditList.get(j).getNumber());  //出库总售价-总成本
//							
//						}
//						st.setTotalProfit(totalProfit);
//
//						stList.add(st);
//					}
		
	}
	
	@RequestMapping("checkProInfo")
	public String cheIn(HttpServletRequest request,HttpServletResponse response) {
		int audit_id=Integer.parseInt(request.getParameter("audit_id"));
		request.setAttribute("audit_id",audit_id);
		return "view/financialManage/checkProInfo";
	}
	
	@RequestMapping("goInInventoryMain_start")
	public String mainStart(HttpServletRequest request,HttpServletResponse response) {
		
		//拿到所有时间
		List<String> time=new ArrayList<String>();
		time.add("一周内");
		time.add("一月内");
		time.add("三月内");
		time.add("一年内");
		time.add("全部");
		String timeType="一月内";
		request.setAttribute("time",time);
		request.setAttribute("timeType",timeType);    
		
		//1:拿到所有商品品牌
		List<String> broundList=new ArrayList<>();
		broundList=financialService.queryAllBround();
		//broundList.add("全部");
		request.setAttribute("broundList",broundList);
		request.setAttribute("catagorg","全部");    
		
		//拿到显示方式
		
		List<String> modelList=new ArrayList<>();
		modelList.add("柱状图");
		modelList.add("折线图");
		request.setAttribute("modelList",modelList);
		String selectMode="柱状图";
		request.setAttribute("selectMode",selectMode);   //默认选中柱状图
		
		return "view/financialManage/goInInventoryMain";
		
	}
	
	@RequestMapping("goInInventoryMain_center")
	public String mainCenter(HttpServletRequest request,HttpServletResponse response) {
		//拿到所有时间
				List<String> time=new ArrayList<String>();
				time.add("一周内");
				time.add("一月内");
				time.add("三月内");
				time.add("一年内");
				time.add("全部");
				String timeType=request.getParameter("timeType"); //拿到时间
				request.setAttribute("time",time);
				request.setAttribute("timeType",timeType);   
				
				//1:拿到所有商品品牌
				List<String> broundList=new ArrayList<>();
				broundList=financialService.queryAllBroundNoCondition();
				//broundList.add("全部");
				request.setAttribute("broundList",broundList);
				request.setAttribute("catagorg",request.getParameter("goodsType"));     //默认选中华为
				
				//拿到所有显示方式
				List<String> modelList=new ArrayList<>();
				modelList.add("柱状图");
				modelList.add("折线图");
				String selectMode=request.getParameter("modeType");
				request.setAttribute("selectMode",selectMode);
				if(selectMode.equals("柱状图")) {
					request.setAttribute("myMode","bar");
				}else {
					request.setAttribute("myMode","line");
				}
				request.setAttribute("modelList",modelList);
				System.out.println("进入center方法---------------------------------------------------------");
				System.out.println("timeType="+timeType+"goodsType="+request.getParameter("goodsType")+"modeType="+selectMode);
				return "view/financialManage/goInInventoryMain_center";
	}
	
	@RequestMapping("goInInventoryMain_last")
	public void mainLast(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
				//拿到所有时间
//				List<String> time=new ArrayList<String>();
//				time.add("一周内");
//				time.add("一月内");
//				time.add("三月内");
//				time.add("一年内");
				String timeType=request.getParameter("timeType").toString();
				System.out.println("已经进入last方法");
				System.out.println("timeType="+timeType);
//				request.setAttribute("time",time);
//				request.setAttribute("timeType",timeType);    //默认选中一周内
				String goodsType=request.getParameter("goodsType").toString();
				System.out.println("goodsType="+goodsType);
           List<String> pro_list=new ArrayList<>();
           pro_list=financialService.searAllProduct(goodsType);
			System.out.println(pro_list);
//		List<String> bround_list=new ArrayList<>();
//		bround_list=financialService.queryAllBround();
//		//bround_list.add("全部");
//		System.out.println(bround_list);
		
		List<Statistic> stList=new ArrayList<>();
		
		
		for(int i=0;i<pro_list.size();i++) {
			Statistic st=new Statistic();
			List<Audit> auditList=new ArrayList<>();
			long totalRuKuCost=0;    
			long totalRuKuNumber=0;
			auditList=financialService.queryAllAuditByProName(pro_list.get(i),timeType);    
			st.setProductName(pro_list.get(i));
			for(int j=0;j<auditList.size();j++) {
				totalRuKuCost+=(Integer.parseInt(auditList.get(j).getPrice()))*auditList.get(j).getNumber();  
				totalRuKuNumber+=auditList.get(j).getNumber();
				
			}
			st.setTotalRuKuCost(totalRuKuCost);
			st.setTotalRuKuNumber(totalRuKuNumber);
			stList.add(st);
		}
		System.out.println("下面打印要传输的数据----------");
		System.out.println(stList);
		//将数据转化为json对象
		ObjectMapper mapper=new ObjectMapper();
		
			String json=mapper.writeValueAsString(stList);
			response.setContentType("text/html;charset=utf-8");
		
				response.getWriter().write(json);		
		
		//return "view/financialManage/goInInventoryMain";
	}
	
	@RequestMapping("goOutInventoryMain_start")
	public String goOutMain(HttpServletRequest request,HttpServletResponse response) {
		//拿到所有时间
				List<String> time=new ArrayList<String>();
				time.add("一周内");
				time.add("一月内");
				time.add("三月内");
				time.add("一年内");
				time.add("全部");
				String timeType="一月内";
				request.setAttribute("time",time);
				request.setAttribute("timeType",timeType);    
				
				//1:拿到所有商品品牌
				List<String> broundList=new ArrayList<>();
				broundList=financialService.queryAllBround();
				//broundList.add("全部");
				request.setAttribute("broundList",broundList);
				request.setAttribute("catagorg","全部");    
				
				//拿到显示方式
				
				List<String> modelList=new ArrayList<>();
				modelList.add("柱状图");
				modelList.add("折线图");
				request.setAttribute("modelList",modelList);
				String selectMode="柱状图";
				request.setAttribute("selectMode",selectMode);   //默认选中柱状图
				
				return "view/financialManage/goOutInventoryMain";
	}
	
	@RequestMapping("goOutInventoryMain_center")
	public String gooutmaincenter(HttpServletRequest request,HttpServletResponse response) {
		//拿到所有时间
		List<String> time=new ArrayList<String>();
		time.add("一周内");
		time.add("一月内");
		time.add("三月内");
		time.add("一年内");
		time.add("全部");
		String timeType=request.getParameter("timeType"); //拿到时间
		request.setAttribute("time",time);
		request.setAttribute("timeType",timeType);   
		
		//1:拿到所有商品品牌
		List<String> broundList=new ArrayList<>();
		broundList=financialService.queryAllBroundNoCondition();
		//broundList.add("全部");
		request.setAttribute("broundList",broundList);
		request.setAttribute("catagorg",request.getParameter("goodsType"));     //默认选中华为
		
		//拿到所有显示方式
		List<String> modelList=new ArrayList<>();
		modelList.add("柱状图");
		modelList.add("折线图");
		String selectMode=request.getParameter("modeType");
		request.setAttribute("selectMode",selectMode);
		if(selectMode.equals("柱状图")) {
			request.setAttribute("myMode","bar");
		}else {
			request.setAttribute("myMode","line");
		}
		request.setAttribute("modelList",modelList);
		System.out.println("进入goOut的center方法++++++++++++++++++++++++++++++++++++");
		System.out.println("timeType="+timeType+"goodsType="+request.getParameter("goodsType")+"modeType="+selectMode);
		return "view/financialManage/goOutInventoryMain_center";
	}
	
	@RequestMapping("goOutInventoryMain_last")
	public void gooutliat(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//拿到所有时间
//		List<String> time=new ArrayList<String>();
//		time.add("一周内");
//		time.add("一月内");
//		time.add("三月内");
//		time.add("一年内");
		String timeType=request.getParameter("timeType").toString();
		System.out.println("已经进入goOut的last方法");
		System.out.println("timeType="+timeType);
//		request.setAttribute("time",time);
//		request.setAttribute("timeType",timeType);    //默认选中一周内
		String goodsType=request.getParameter("goodsType").toString();
		System.out.println("goodsType="+goodsType);
   List<String> pro_list=new ArrayList<>();
   pro_list=financialService.searAllProduct(goodsType);
	System.out.println(pro_list);
//List<String> bround_list=new ArrayList<>();
//bround_list=financialService.queryAllBround();
////bround_list.add("全部");
//System.out.println(bround_list);

List<Statistic> stList=new ArrayList<>();


for(int i=0;i<pro_list.size();i++) {
	Statistic st=new Statistic();
	List<Audit> auditList=new ArrayList<>();
	long totalChuKuPrice=0;    
	long totalChuKuNumber=0;
	auditList=financialService.queryAllSellAuditByProName(pro_list.get(i),timeType); 
	System.out.println("这里是测试，打印苹果的审计表");
	st.setProductName(pro_list.get(i));
	for(int j=0;j<auditList.size();j++) {
		totalChuKuPrice+=(Integer.parseInt(auditList.get(j).getPrice()))*auditList.get(j).getNumber();  
		totalChuKuNumber+=auditList.get(j).getNumber();
		
	}
	st.setTotalChuKuPrice(totalChuKuPrice);
	st.setTotalChuKuNumber(totalChuKuNumber);
	stList.add(st);
}
System.out.println("下面打印要传输的数据----------");
System.out.println(stList);
//将数据转化为json对象
ObjectMapper mapper=new ObjectMapper();

	String json=mapper.writeValueAsString(stList);
	response.setContentType("text/html;charset=utf-8");

		response.getWriter().write(json);		

//return "view/financialManage/goInInventoryMain";
	}
	
	@RequestMapping("commercial_check_success")
	public String comCheckSucc(HttpServletRequest request,HttpServletResponse response) {
		
		//这里要分为入库审核和出库审核两类，默认是入库审核，还要根据时间来查询，一周内，一月内，三月内，一年内,默认是一个月
		
		List<String> time=new ArrayList<>();
		time.add("一周内");
		time.add("一月内");
		time.add("三月内");
		time.add("一年内");
		String timeType="一月内";
		
		List<String> catagorgList=new ArrayList<String>();
		catagorgList.add("出库审核");
		catagorgList.add("入库审核");
		String catagorg="入库审核";
		request.setAttribute("time",time);
		request.setAttribute("timeType",timeType);
		request.setAttribute("catagorgList",catagorgList);
		request.setAttribute("catagorg",catagorg);
		
		
		List<Audit> auditList=new ArrayList<Audit>();
		
		auditList=financialService.queryAuditSecondCheck_Success();
		request.setAttribute("auditList",auditList);
		
		
		return "view/financialManage/commercial_check_success";
	}
	
	@RequestMapping("checkAuditByCondition")
	public String checkAuditByCondition(HttpServletRequest request,HttpServletResponse response) {
		List<String> time=new ArrayList<>();
		time.add("一周内");
		time.add("一月内");
		time.add("三月内");
		time.add("一年内");
		String timeType=request.getParameter("timeType");
		
		List<String> catagorgList=new ArrayList<String>();
		catagorgList.add("出库审核");
		catagorgList.add("入库审核");
		String catagorg=request.getParameter("catagorg");
		request.setAttribute("time",time);
		request.setAttribute("timeType",timeType);
		request.setAttribute("catagorgList",catagorgList);
		request.setAttribute("catagorg",catagorg);
		
		
		List<Audit> auditList=new ArrayList<Audit>();
		
		auditList=financialService.queryAuditSecondCheck_SuccessByCondition(timeType,catagorg);
		request.setAttribute("auditList",auditList);
		
		
		return "view/financialManage/commercial_check_success";
	}
	
	@RequestMapping("sendMail")
	@ResponseBody
	public String senfMail(HttpServletRequest request,HttpServletResponse response) {
		String authCode=request.getParameter("auth");
		String mail=request.getParameter("mail");
		//将验证码存入session中
		request.getSession().setAttribute("AUTH",authCode);
		System.out.println("session验证码="+request.getSession().getAttribute("AUTH"));
		//System.out.println("mail="+mail+" auth="+authCode);
		Properties props = new Properties();
        //邮件传输的协议
        props.put("mail.transport.protocol", "smtp");
        //连接的邮件服务器
        props.put("mail.host","smtp.qq.com");
        //发送人
        props.put("mail.from","2658222325@qq.com");

        //第一步：创建session
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", "true");
            //第二步：获取邮件传输对象
            Transport ts= session.getTransport();
            //连接邮件服务器
            ts.connect("2658222325@qq.com", "yakqdzjcxbcedjba");
            //第三步：创建邮件消息体
            MimeMessage message = new MimeMessage(session);
            //设置邮件的内容
            message.setSubject("验证码");
            //设置邮件的内容
            message.setContent(authCode,"text/html;charset=utf-8");
            //第四步：设置发送昵称
			
//			  String nick=""; nick = javax.mail.internet.MimeUtility.encodeText("Miss.ss");
//			  message.setFrom(new InternetAddress(nick+"'<2658222325@qq.com>'"));
			 
            //第五步：设置接收人信息
            ts.sendMessage(message, InternetAddress.parse(mail));

        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }

        return "success";


		
	}
	
	@RequestMapping("checkCode")
	@ResponseBody
	public String checkAuth(HttpServletRequest request,HttpServletResponse response) {
		String checkCode=request.getParameter("auth");
		String auth=(String)request.getSession().getAttribute("AUTH");
		
		System.out.println("进入checkCode方法");
//		System.out.println("session验证码="+request.getSession().getAttribute("AUTH"));
		if(auth.equals(checkCode)) {
			return "success";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("commercial_revenue_statistic_1")
	public void comsta_1(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//要做两件事，将四个月之内公司的盈利状况收集起来，name=月，value=盈利金额；要跳转到页面.
		//收集1,2,3,4内个营利
		List<Long> Profit=new ArrayList<>();
		for(int j=1;j<5;j++) {
			List<Audit> audit_list=new ArrayList<>();
			audit_list=financialService.queryAllAuditByMonth(j);
			long totalProfit=0;
			for(int i=0;i<audit_list.size();i++) {
				String proName=audit_list.get(i).getProductName();
				int cost=Integer.parseInt(financialService.queryCostByName(proName));
				totalProfit+=(Integer.parseInt(audit_list.get(i).getPrice())*audit_list.get(i).getNumber()-cost*audit_list.get(i).getNumber());   
			}
			Profit.add(totalProfit);
		}
		//request.setAttribute("num", Profit);

		
		Calendar date = Calendar.getInstance();
		int year = Integer.parseInt(String.valueOf(date.get(Calendar.YEAR)));
		int month=Integer.parseInt(String.valueOf(date.get(Calendar.MONTH)));
		List<String> timeNumber=new ArrayList<>();
		
		for(int m=0;m<4;m++) {
			if(month==0) {
				year--;
				month=12;
				String monthYue = month+"月";
				String yearNian=year+"年";
				timeNumber.add(yearNian+""+monthYue);
				
			}else {
				String monthYue=month+"月";
				String yearNian=year+"年";
				timeNumber.add(yearNian+""+monthYue);	
			}	
		}
		//request.setAttribute("name",timeNumber);
		List<Statistic> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			Statistic st=new Statistic();
			st.setTimeType(timeNumber.get(i));
			st.setTotalProfit(Profit.get(i));
			lists.add(st);
		}
		
		//将数据转化为json对象
		ObjectMapper mapper=new ObjectMapper();

			String json=mapper.writeValueAsString(lists);
			response.setContentType("text/html;charset=utf-8");

				response.getWriter().write(json);		
		
			
		
		//return "view/financialManage/commercial_revenue_statistic_1";
		
	}
	
}
