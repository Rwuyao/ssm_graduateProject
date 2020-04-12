package com.fs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fs.model.Product;
import com.fs.service.ProductService;

@Aspect
@Component  
public class Aopcontro {
	@Autowired
	private ProductService productService;
	
	@AfterReturning("execution(* com.fs.service.ProductService.*(..))")
    public void show(JoinPoint point) {
		
	
		
		
		//System.out.println("1"+point.getSignature().getDeclaringTypeName());//调用了那一层
	    String method=	point.getSignature().getName();//获得方法名字
	    
	    if(method.equals("updateProductByName")
	    		){
	    	
	    	Object []objects=point.getArgs();
	    	String name=(String) objects[1];
	    	int auditId=(int) objects[2];
	   
	    	
	    	  int a=productService.xiugaichukuzhuangtai(name,auditId);
			
	    	System.out.println("出库了产品"+auditId);
	 
	    	
	    }
	    if(method.equals("addproductApply")
	    		){
	    	System.out.println("发起了入库申请");
	    	
	    }
	    if(method.equals("addproduct")
	    		){
	    	System.out.println("增加了产品");
	    	
	    }
	    if(method.equals("insertintoproduct")){
	    	Object[] objects=point.getArgs();
		    Product product=(Product) objects[0];
		    String username=(String) objects[3];
		    int audii_id=(int) objects[2];
		    
		    int b =productService.updateAuditSta(audii_id);
		    
		    int a =productService.insertIntoWIfeLog(product,username,audii_id);
	    }
		
	    if(method.equals("addnumberfromprodecut")){
	    	Object[] objects=point.getArgs();
	    Product product=(Product) objects[0];
	    String username=(String) objects[3];
	    int audii_id=(int) objects[2];
	    int b =productService.updateAuditSta(audii_id);
	    
	    int a =productService.insertIntoWIfeLog(product,username,audii_id);
	    	
	    	
	    }
	    
	    if(method.equals("updateProductByName")){
	    	System.out.println("切入aop方法");
	    	Object[] objects=point.getArgs();
	  int number=(int) objects[0];
	  String name=(String) objects[1];
	  int auditid=(int) objects[2];
	  String username=(String) objects[3];
	    
	    
	    int a =productService.insertIntoWIfeLog2(number,name,auditid,username);
	    
	    	
	    	
	    }
		
		
		
		
	}
	
	

}
