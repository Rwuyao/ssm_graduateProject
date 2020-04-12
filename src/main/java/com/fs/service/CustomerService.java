package com.fs.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fs.model.Customer;

public interface CustomerService {

	HashMap<String, Object> client_info(HttpServletRequest request, HttpServletResponse response,int page,int row);

	String Q_updatecusMessage(HttpServletRequest request, HttpServletResponse response);

	String Q_selectCustomer(HttpServletRequest request, HttpServletResponse response);

/*	String Q_CusUpdateByMess(HttpServletRequest request, HttpServletResponse response);*/

	/*String Q_CusInsertByMess(HttpServletRequest request, HttpServletResponse response, Customer customer);*/

	String Q_SelectMessage(HttpServletRequest request, HttpServletResponse response, Customer customer);

	HashMap<String, Object> Q_CusUpdateByMess(HttpServletRequest request, HttpServletResponse response, int page,
			int row);

	HashMap<String, Object> Q_CusInsertByMess(HttpServletRequest request, HttpServletResponse response, int page,
			int row, Customer customer);

}
