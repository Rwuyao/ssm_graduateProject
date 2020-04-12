package com.fs.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fs.mapper.ProductMapper;
import com.fs.model.Audit;
import com.fs.model.Product;
import com.fs.model.Supplier;
import com.fs.model.User;
import com.fs.model.Warehouse_log;
import com.fs.service.ProductService;
import com.google.gson.Gson;


/**
 * @author Mr-Yang
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	HttpServletResponse response;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------

	@Override
	public List<Product> queryAllProduct() {
		
		return productMapper.queryAllProduct() ;
	}

	@Override
	public List<Product> queryAllsupplier() {
		// TODO Auto-generated method stub
		return productMapper.queryAllsupplier();
	}

	@Override
	public int addproductApply(String name, String product_name, int number, String price) {
		// TODO Auto-generated method stub
		return productMapper.addproductApply( name,  product_name,  number,  price);
	}

	@Override
	public List<Product> queryAuditByid(int auditId) {
		// TODO Auto-generated method stub
		return productMapper. queryAuditByid( auditId);
	}

	@Override
	public List<Supplier> queryAllsupplier2() {
		// TODO Auto-generated method stub
		return productMapper.queryAllsupplier2();
	
	
	
	
	}

	@Override
	public int insertintoproduct(Product product, String picture,int audit_id,String username) {
		// TODO Auto-generated method stub
		return productMapper.insertintoproduct( product,  picture) ;
	}

	@Override
	public int deleteproduct(int proId) {
		// TODO Auto-generated method stub
		return productMapper.deleteproduct( proId);
	}

	@Override
	public int addproduct(int proId) {
		// TODO Auto-generated method stub
		return productMapper.addproduct( proId) ;
	}

	@Override
	public List<Product> queryAuditbyxiaoshoubu() {
		// TODO Auto-generated method stub
		return productMapper.queryAuditbyxiaoshoubu() ;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String updateProductByName(int number, String name,int auditId,String username,HttpServletRequest request,HttpServletResponse response)  {
		// TODO Auto-generated method stub
		
		int a= productMapper.updateProductByName( number,name);
		List<Product> list=productMapper.queryAuditbyxiaoshoubu();
        request.setAttribute("list",list);
        System.out.println(list);
        System.out.println("出库了产品哈哈");
        return "view/inventory_manage/outproduct";
		
		
	}

	@Override
	public int xiugaichukuzhuangtai(String name,int auditId) {
		// TODO Auto-generated method stub
		return productMapper.xiugaichukuzhuangtai( name, auditId) ;
	}

	@Override
	public List<Product> queryProductIsNOTorYes(Product product) {
		// TODO Auto-generated method stub
		return productMapper.queryProductIsNOTorYes( product);
	}

	@Override
	public int addnumberfromprodecut(Product product,int number,int audit_id,String username) {
		// TODO Auto-generated method stub
		return productMapper.addnumberfromprodecut( product, number);
	}

	@Override
	public String selectprodunct(HttpServletRequest request) {
		
		String state1=request.getParameter("state1");
		String state2=request.getParameter("state2");
		String time1=request.getParameter("time1");
		String  time2=request.getParameter("time2");
		String state=null;
		if (state1!=null&&state1!="") {
			state=state1;
			List<Product> list=productMapper.selectprodunct(state,time1,time2);
			
			System.out.println(list);
			
			request.setAttribute("list", list);
			request.setAttribute("info", "1");
			request.setAttribute("time1", time1);
			request.setAttribute("time2", time2);
			request.setAttribute("dd", "供应商");
			
			
			return "view/inventory_manage/allGoods";
			
		}else if(state2!=null&&state2!=""){
			state=state2;
			List<Product> list=productMapper.selectprodunct(state,time1,time2);
			System.out.println(list);
			request.setAttribute("list", list);
			
			request.setAttribute("info", "2");
			request.setAttribute("time1", time1);
			request.setAttribute("time2", time2);
			request.setAttribute("dd", "供应商");
			return "view/inventory_manage/allGoods";
			
		}else if(state1==null||state1==""&&state2==null||state2==""){
			
			List<Product> list=productMapper.selectprodunct2(time1,time2);
			request.setAttribute("list", list);
			request.setAttribute("dd", "供应商");
			request.setAttribute("info", "3");
			request.setAttribute("time1", time1);
			request.setAttribute("time2", time2);
			System.out.println("查询结果为"+list);
			return "view/inventory_manage/allGoods";
		}
		
		
		
		
		
		
		return null;
	}

	@Override
	public String selectoutproduct(HttpServletRequest request) {


		String sta1=request.getParameter("sta1");
		String sta2=request.getParameter("sta2");
		String time1=request.getParameter("time1");
		String  time2=request.getParameter("time2");
		String sta=null;
		if (sta1!=null&&sta1!="") {
			sta=sta1;
			List<Product> list=productMapper.selectoutproduct(sta,time1,time2);
			
			System.out.println(list);
			
			request.setAttribute("list", list);
			request.setAttribute("info", "1");
			request.setAttribute("time1", time1);
			request.setAttribute("time2", time2);
			
			
			return "view/inventory_manage/outproduct";
			
		}else if(sta2!=null&&sta2!=""){
			sta=sta2;
			List<Product> list=productMapper.selectoutproduct(sta,time1,time2);
			System.out.println(list);
			request.setAttribute("list", list);
			
			request.setAttribute("info", "2");
			request.setAttribute("time1", time1);
			request.setAttribute("time2", time2);
			
			return "view/inventory_manage/outproduct";
			
		}else if(sta1==null||sta1==""&&sta2==null||sta2==""){
			
			List<Product> list=productMapper.selectoutproduct2(time1,time2);
			request.setAttribute("list", list);
			
			request.setAttribute("info", "3");
			request.setAttribute("time1", time1);
			request.setAttribute("time2", time2);
			return "view/inventory_manage/outproduct";
		}
		
		
		return null;
		
		
	}

	@Override
	public int insertIntoWIfeLog(Product product, String username, int audii_id) {


		return productMapper.insertIntoWIfeLog( product,  username,  audii_id);
	}

	@Override
	public int insertIntoWIfeLog2(int number, String name, int auditid, String username) {
		// TODO Auto-generated method stub
		return productMapper.insertIntoWIfeLog2( number,  name,  auditid,  username);
	}

	@Override
	public String productLog(HttpServletRequest request) {
		
		List<Warehouse_log> list=productMapper.queryAllLog();
		System.out.println(list);
		
		request.setAttribute("list", list);
		return "view/inventory_manage/inventory_out";
		
		
	}

	@Override
	public String selectmyAudit(HttpServletRequest request) {
		
		List<Audit> list=productMapper.selectmyAudit();
		request.setAttribute("list", list);
	
		return "view/inventory_manage/myauditui";
	}

	@Override
	public HashMap<String, List<Audit>> selectheAudit(HttpServletRequest request) {
		HashMap<String , List<Audit>> map=new HashMap<>();
		List<Audit> list=productMapper.selectheAudit();
		List<Audit> list2=productMapper.selectheAudit2();
		System.out.println("到service来了1"+list+list2);
		System.out.println("到service来了2"+list2);
		
		 request.setAttribute("list", list); request.setAttribute("list2", list2); 
		
		
		  map.put("list", list); map.put("list2", list2);
		 
		
		
		return map;
		}

	@Override
	public String yespass(HttpServletRequest request,HttpServletResponse response) {
		String auditidstr=request.getParameter("id");
		int audit_id=Integer.parseInt(auditidstr);
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("USER");
		String username=user.getName();
		
		int a =productMapper.yespass(username,audit_id);
		
		List<Audit> list=productMapper.selectheAudit();
		List<Audit> list2=productMapper.selectheAudit2();
		
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		
		return "view/inventory_manage/heAuditui";
	}

	@Override
	public String nopass(HttpServletRequest request, HttpServletResponse response) {
		String auditidstr=request.getParameter("id");
		int audit_id=Integer.parseInt(auditidstr);
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("USER");
		String username=user.getName();
		
		int a =productMapper.nopass(username,audit_id);
		
		List<Audit> list=productMapper.selectheAudit();
		List<Audit> list2=productMapper.selectheAudit2();
		
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		
		return "view/inventory_manage/heAuditui";
	}

	@Override
	public String updatepro(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		
		String pro_idstr=request.getParameter("id");
		int pro_id=Integer.parseInt(pro_idstr);
		
		List<Product> list=productMapper.queryProductByProId(pro_id);
		
	System.out.println(list);
		try {
			PrintWriter pw=response.getWriter();
			Gson gson=new Gson();
			String ret=gson.toJson(list);
			pw.print(ret);
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	
	 @Override
     @Transactional(rollbackFor = Exception.class)
	public String doupdate (HttpServletRequest request, HttpServletResponse response) throws Exception{
		
	String proidstr=	request.getParameter("id");
	int pro_id=Integer.parseInt(proidstr);
	String name=request.getParameter("name");
	String des=request.getParameter("des");
	String  price=request.getParameter("price");


		System.out.println("到修改这个方法前面了");
		int d =productMapper.updateProductByProId(pro_id, name,des,price);
		
	
	 List<Product> list=productMapper.queryAllProduct() ;
	 request.setAttribute("list", list);
	
		return "view/inventory_manage/allGoods";
	

	
	}

	@Override
	public int updateAuditSta(int audii_id) {
		// TODO Auto-generated method stub
		return productMapper.updateAuditSta( audii_id);
	}
	

	
	
	
	
	
	
	
	

}
