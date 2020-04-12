package com.fs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fs.model.Audit;
import com.fs.model.Product;
import com.fs.model.Supplier;
import com.fs.model.Warehouse_log;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

	List<Product> queryAllProduct();

	List<Product> queryAllsupplier();

	int addproductApply(@Param("name")String name, @Param("product_name")String product_name,@Param("number") int number,@Param("price") String price);

	List<Product> queryAuditByid(int auditId);

	List<Supplier> queryAllsupplier2();

	int insertintoproduct(@Param("product")Product product, @Param("picture")String picture);

	int deleteproduct(int proId);

	int addproduct(int proId);

	List<Product> queryAuditbyxiaoshoubu();

	int updateProductByName(@Param("number")int number, @Param("name")String name);

	int xiugaichukuzhuangtai(@Param("name")String name,@Param("auditId")int auditId);

	List<Product> queryProductIsNOTorYes(@Param("product")Product product);

	int addnumberfromprodecut(@Param("product")Product product,@Param("number")int number);

	List<Product> selectprodunct(@Param("state")String state,@Param("time1")String time1,@Param("time2") String time2);

	List<Product> selectprodunct2(@Param("time1")String time1, @Param("time2")String time2);

	List<Product> selectoutproduct(@Param("sta")String sta,@Param("time1") String time1,@Param("time2") String time2);

	List<Product> selectoutproduct2(@Param("time1")String time1, @Param("time2")String time2);

	int insertIntoWIfeLog(@Param("product")Product product, @Param("username")String username,@Param("audii_id") int audii_id);

	int insertIntoWIfeLog2(@Param("number")int number, @Param("name")String name, @Param("auditid")int auditid,@Param("username") String username);

	List<Warehouse_log> queryAllLog();

	List<Audit> selectmyAudit();

	List<Audit> selectheAudit();


	int yespass(@Param("username")String username,  @Param("audit_id") int audit_id);

	List<Audit> selectheAudit2();

	int nopass(@Param("username")String username,@Param("audit_id") int audit_id);

	List<Product> queryProductByProId(int pro_id);

	int updateProductByProId(@Param("pro_id")int pro_id, @Param("name")String name, @Param("des")String des, @Param("price")String price);

	int updateAuditSta(int audii_id);

}