package com.fs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fs.model.Customer;
import com.fs.model.Product;

public interface Q_ProductMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

	List<Product> product_info();

	List<Product> Q_selectMess(@Param(value="selectMess2")String selectMess2, @Param(value="start")int start, @Param(value="row")int row);
	
	List<Product> Q_ProselectPage(@Param(value="start")int start, @Param(value="row")int row);

	
	
	Integer Q_ProselectPageCount();

	Integer Q_selectMessPageCount(@Param(value="selectMess2")String selectMess2, @Param(value="start")int start, @Param(value="row")int row);

	List<String> queryOrderId();

	
}