package com.fs.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fs.model.Audit;
import com.fs.model.Product;
import com.fs.model.Supplier;

/**
 * @author Mr-Yang
 *
 */
public interface ProductService {

	List<Product> queryAllProduct();

	List<Product> queryAllsupplier();

	int addproductApply(String name, String product_name, int number, String price);

	List<Product> queryAuditByid(int auditId);

	List<Supplier> queryAllsupplier2();

	int insertintoproduct(Product product, String picture,int audit_id,String username);

	int deleteproduct(int proId);

	int addproduct(int proId);

	List<Product> queryAuditbyxiaoshoubu();

	String updateProductByName(int number, String name,int auditId,String username,HttpServletRequest request,HttpServletResponse response) ;

	int xiugaichukuzhuangtai(String name,int auditId);

	List<Product> queryProductIsNOTorYes(Product product);

	int addnumberfromprodecut(Product product,int number,int audit_id,String username);

	String selectprodunct(HttpServletRequest request);

	String selectoutproduct(HttpServletRequest request);

	int insertIntoWIfeLog(Product product, String username, int audii_id);

	int insertIntoWIfeLog2(int number, String name, int auditid, String username);

	String productLog(HttpServletRequest request);


	String selectmyAudit(HttpServletRequest request);

	HashMap<String, List<Audit>> selectheAudit(HttpServletRequest request);

	String yespass(HttpServletRequest request,HttpServletResponse response);

	String nopass(HttpServletRequest request, HttpServletResponse response);

	String updatepro(HttpServletRequest request, HttpServletResponse response);

	String doupdate(HttpServletRequest request, HttpServletResponse response) throws Exception;

	int updateAuditSta(int audii_id);



}
