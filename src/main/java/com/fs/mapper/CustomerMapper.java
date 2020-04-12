package com.fs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fs.model.Customer;

public interface CustomerMapper {

	List<Customer> client_info2(@Param(value="start")int start,@Param(value="row")int row);
	List<Customer> client_info();

	void Q_updatecusMessage(int cus_id);

	Customer Q_selectCustomer(int cus_id);

	void Q_CusUpdateByMess(Customer cus);

	void Q_CusInsertByMess(Customer cus);

	List<Customer> Q_SelectMessage(String messageSt);

	Integer client_infoPageCount();

}
