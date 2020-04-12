package com.fs.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.jni.Lock;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.model.Audit;
import com.fs.model.Product;
import com.fs.model.Supplier;
import com.fs.model.User;
import com.fs.service.ProductService;
import com.fs.utils.AllBean;
import com.google.gson.Gson;

import sun.net.www.content.image.jpeg;

/**
 * @author Mr-Yang
 *
 */
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------
	
	
	
	
	//跳转到所有商品
	@RequestMapping("allGoods")
	public synchronized String allGoods(HttpServletRequest request,HttpServletResponse response) {
		
		test te=new test();
		
		 //1.执行FutureTask,需要FutureTask实现类的支持，用于接收运算结果
        FutureTask<List<Product>> result = new FutureTask<List<Product>>(te);
        new Thread(result).start();
      
		System.out.println("启动了线程");
		 try {
			List<Product>  list =result.get();
			request.setAttribute("list",list);
			return "view/inventory_manage/allGoods";
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * List <Product> list = productService.queryAllProduct();
		 * 
		 * 
		 * request.setAttribute("list", list);
		 * 
		 * 
		 * 
		 * return "view/inventory_manage/allGoods";
		 */
	}
	
	//跳转到库存审核
	@RequestMapping("inventory_check")
	public String inventory_check(HttpServletRequest request,HttpServletResponse response) {
		return "view/inventory_manage/inventory_check";
	}
	
	//跳转到出库管理
	@RequestMapping("inventory_out")
	public String inventory_out(HttpServletRequest request,HttpServletResponse response) {
		return "view/inventory_manage/inventory_out";
	}
	
	//跳转产品申请界面
		@RequestMapping("apllyui")

		public String apllyui(HttpServletRequest request,HttpServletResponse response) {
		
			List<Product> list=productService.queryAllsupplier();
			String name=request.getParameter("name");
			if(name==null ||name==""){
				request.setAttribute("list", list);
				return "view/inventory_manage/applyui";
				
			}
			else{
			request.setAttribute("name",name);
			request.setAttribute("list", list);
			return "view/inventory_manage/applyui";
			}
		
			
			
		}
		
		//入库申请
				@RequestMapping("aplly")

				public String aplly(HttpServletRequest request,HttpServletResponse response) {
					User User=(User) request.getSession().getAttribute("USER");
					String name=User.getName();
					
					
					String product_name=request.getParameter("pname");
					String numberstr=request.getParameter("number");
					int number=Integer.parseInt(numberstr);
				    String price=request.getParameter("price") ;
				    
				    int a=productService.addproductApply(name,product_name,number,price);
					
					
				   try {
					response.sendRedirect("view/inventory_manage/addCG.jsp");
				} catch (IOException e) {
				System.out.println("没找到页面");
				}
				   
				return null;
				
				
				
			
	
	
	
				}
	
	
	
				//跳转产品申请界面
				@RequestMapping("addproduct")

				public String addproduct(HttpServletRequest request,HttpServletResponse response) {
					
					response.setContentType("text/html;charset=utf-8");
					String auditIdstr=request.getParameter("auditId");
					HttpSession session=request.getSession();
					session.setAttribute("auditId", auditIdstr);
					
					
					
					try {
						PrintWriter pw=response.getWriter();
						Gson gson=new Gson();
					if(auditIdstr==null||auditIdstr==""){
						
						String info=null;
						String ret2=gson.toJson(info);
						pw.println(ret2);
						return null;
					}
					
					int auditId=Integer.parseInt(auditIdstr);
					List<Product> list=productService.queryAuditByid(auditId);
				
						System.out.println(list);
						if (list.isEmpty()){
							String info=null;
							String ret1=gson.toJson(info);
							pw.println(ret1);
							
						}
						else {
							String ret=gson.toJson(list);
							pw.print(ret);
							
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
					return null;
				}
	
	
				//查询所有供货商
				@RequestMapping("qureysupplier")

				public String qureysupplier(HttpServletRequest request,HttpServletResponse response) {
				
					response.setContentType("text/html;charset=utf-8");
					List<Supplier> list=productService.queryAllsupplier2();
					System.out.println(list);
					PrintWriter pw;
					try {
						pw = response.getWriter();
						Gson gson=new Gson();
						
						String ret=gson.toJson(list);
						pw.println(ret);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
					return null;
					
				}
				
				//入库操作
				@RequestMapping("addpro")
                @ResponseBody
				public String addpro(HttpServletRequest request,HttpServletResponse response,Product product) {
					
					HttpSession session=request.getSession();
	                   String auditIdstr=  (String) session.getAttribute("auditId");	
	                   int audit_id=Integer.parseInt(auditIdstr);
	                   
	                   User user=(User) session.getAttribute("USER");
	                   String username=user.getName();
						
						
						
					List<Product> list2=productService.queryProductIsNOTorYes(product);
					 
				
					
					
					if(list2.isEmpty()){
					
					
					FileInputStream fileInputStream=null;
					FileOutputStream fileOutputStream=null;
					
					String picturename=RandomStringUtils.randomAlphanumeric(10);
					
					String picturestr=request.getParameter("picture");
					
					String  picture=picturename+".jpg";
					
					
					
					
					int a=productService.insertintoproduct(product,picture,audit_id,username);
					
					
				
					
					
					try {
						fileInputStream=new FileInputStream(picturestr);
						fileOutputStream=new FileOutputStream("D:\\tupian\\"+picturename+".jpg");
						try {
							byte[]b= new byte[fileInputStream.available()];
							while(fileInputStream.read(b)!=-1) {
								fileOutputStream.write(b);
							
							}
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					
						
						
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally{
						try {
							fileInputStream.close();
							fileOutputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					
					
					
					
					
					return null;
					
					
				}
					
					else{
						
			
						
						int number1=list2.get(0).getNumber();
						int  number2=product.getNumber();
						int number=number1+number2;
						
						int a=productService.addnumberfromprodecut(product,number,audit_id,username);
						
					}
					return null;
				}
			
				
				//商品下架
				@RequestMapping("deletepro")

				public String deletepro(HttpServletRequest request,HttpServletResponse response) {
					
					String proIdstr=request.getParameter("id");
					int proId=Integer.parseInt(proIdstr);
					System.out.println(proId);
					int a=productService.deleteproduct(proId);
					
					List <Product> list =	productService.queryAllProduct();
				       request.setAttribute("list", list);
				       return "view/inventory_manage/allGoods";
					
				}
				
				//商品上架
				@RequestMapping("addpro22")

				public String addpro(HttpServletRequest request,HttpServletResponse response) {
					
					String proIdstr=request.getParameter("id");
					int proId=Integer.parseInt(proIdstr);
					int a=productService.addproduct(proId);
					
					List <Product> list =	productService.queryAllProduct();
				       request.setAttribute("list", list);
				       return "view/inventory_manage/allGoods";
					
				}
				
				//商品出库
				@RequestMapping("outpro")

				public String outpro(HttpServletRequest request,HttpServletResponse response) {
					
					List<Product> list=productService.queryAuditbyxiaoshoubu();
					request.setAttribute("list", list);
					System.out.println(list);
				
				
				       return "view/inventory_manage/outproduct";
					
				}
	
				//商品出库操作
				@RequestMapping("outproduct")
				
				public String outproduct(HttpServletRequest request,HttpServletResponse response) {
					response.setContentType("text/html;charset=utf-8");
					System.out.println("出库了");
					
					String cnumberstr=request.getParameter("cnumber");
					String numberstr=request.getParameter("number");
					String name=request.getParameter("name");
					String auditIdstr=request.getParameter("auditId");
					int auditId=Integer.parseInt(auditIdstr);
					
					int cnumber=Integer.parseInt(cnumberstr);
					int number2=Integer.parseInt(numberstr);
					int  number=cnumber-number2;
				
			
					HttpSession session=request.getSession();
	                   
	                   User user=(User) session.getAttribute("USER");
	                   String username=user.getName();
							
	                   try {
	                	   return productService.updateProductByName(number,name,auditId,username, request, response);
					} catch (Exception e) {
						
						System.out.println("抛出了异常");
						  List<Product> list=productService.queryAuditbyxiaoshoubu();
						  
						  request.setAttribute("list",list); 
						  request.setAttribute("info", "1");
						  return "view/inventory_manage/outproduct";
						 
					}
							
		
						           
				
					
					
				}
				
				
				//商品查询操作
				@RequestMapping("selectpqoduct")

				public String selectpqoduct(HttpServletRequest request,HttpServletResponse response) {
					
					
					return  productService.selectprodunct(request);
					
					
					
				}
				
				//出库查询操作
				@RequestMapping("selectoutproduct")

				public String selectoutproduct(HttpServletRequest request,HttpServletResponse response) {
					
					
					return  productService.selectoutproduct(request);
					
					
					
				}
				
				//仓库记录
				@RequestMapping("productLog")

				public String productLog(HttpServletRequest request,HttpServletResponse response) {
					 System.out.println("来方法了");
					
					return  productService.productLog(request);
					
					
					
				}
				
				//仓库审核记录
				@RequestMapping("check")

				public String check(HttpServletRequest request,HttpServletResponse response) {
					
					
					return  "view/inventory_manage/inventory_check";
					
					
					
				}
				
				//仓库记录
				@RequestMapping("selestAudit")

				public String selestAudit(HttpServletRequest request,HttpServletResponse response) {
					
					
					return  productService.selectmyAudit(request);
					
					
					
				}
				
				//仓库记录
				@RequestMapping("selestheAudit")

				public String   selestheAudit(HttpServletRequest request,HttpServletResponse response) {
					
					taskExecutor.submit(new Callable<HashMap<String, List<Audit>>>() {

				@Override
				public HashMap<String, List<Audit>> call() throws Exception {
					test t=new test();
					HashMap<String, List<Audit>>  map=t.show(request);
					  List<Audit>list=map.get("list"); List<Audit>list2=map.get("list2");
					  System.out.println("controller1"+list);
					  System.out.println("controller2"+list2);
					//  request.setAttribute("list", list); request.setAttribute("list2", list2);
					
					return map;
				}
				
					
				});
					return  "view/inventory_manage/heAuditui";
		         
		     }
				
				//仓库记录
				@RequestMapping("yespass")

				public String yesspass(HttpServletRequest request,HttpServletResponse response) {
					
					
					return  productService.yespass(request,response);
					
					
					
				}
				//仓库记录
				@RequestMapping("nopass")

				public String nopass(HttpServletRequest request,HttpServletResponse response) {
					
					
					return  productService.nopass(request,response);
					
					
					
				}
				
				//编辑产品ui
				@RequestMapping("updatepro")

				public String updatepro(HttpServletRequest request,HttpServletResponse response) {
					
					
					return  productService.updatepro(request,response);
					
					
					
				}
				
				//修改产品
			
				@RequestMapping("doupdate")

				public String doupdate(HttpServletRequest request,HttpServletResponse response) throws Exception {
					
					try {
						return  productService.doupdate(request,response);
					} catch (Exception e) {
						List <Product> list =	productService.queryAllProduct();
						
						
					       request.setAttribute("list", list);
						
						request.setAttribute("info", "1");
						
						return "view/inventory_manage/allGoods";
						
					}
					
					
					
					
				}

				
	
	
	
	
	
	
	
}
