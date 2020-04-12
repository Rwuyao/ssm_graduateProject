package com.fs.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fs.model.User;

/**
 * @author Mr-Yang
 *
 */
public interface UserService {


	String checkUser(String username, String password, HttpServletRequest request);


	/******************************************************************************/
	//显示员工列表
	String employee_info();

	//新增员工信息
	String addEmployee();

	//删除员工信息
	String deleteEmployee();

	//修改员工信息
	String updateEmployee();

	//查询员工信息
	String queryEmployee();

	//自动提示搜索
	String autoUserQuery();


}
