package com.fs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fs.model.Customer;
import com.fs.model.Supplier;

public interface SupplierMapper {
    int deleteByPrimaryKey(Integer supplierId);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer supplierId);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

	//List<Supplier> supplier_info();

	void Q_deleteSupMessage(int supplierId);

	Supplier Q_selectSupplier(int supplierId);

	void Q_SupUpdateByMess(Supplier supplier);

	void Q_SuppInsertByMess(Supplier supplier);

	List<Supplier> Q_SupSelectMessage(String messageSt);

	List<Customer> supplier_info(@Param(value="start")int start, @Param(value="row")int row);

	Integer supplier_infoPageCount();

	List<Supplier> supplier_info2();
}