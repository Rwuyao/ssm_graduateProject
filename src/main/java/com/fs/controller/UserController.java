package com.fs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fs.model.User;
import com.fs.service.UserService;

/**
 * @author Mr-Yang
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------
	
	//登陆用户验证
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("这里进入登录方法");
		
		return userService.checkUser(username,password,request);

	}
	
	
	
	@RequestMapping("check_info")
	public String check_info(HttpServletRequest request,HttpServletResponse response) {
		return "view/BossPermission/check_info";
	}
	
	
	/******************************************************************************/
	
	//显示员工列表
	@RequestMapping("employee_info")
	public String employee_info(HttpServletRequest request,HttpServletResponse response) {
		return userService.employee_info();
	}
	
	//新增员工信息
	@RequestMapping("addEmployee")
	public String addEmployee(HttpServletRequest request,HttpServletResponse response) {
		return userService.addEmployee();
	}
	
	//删除员工信息
	@RequestMapping("deleteEmployee")
	public String deleteEmployee(HttpServletRequest request,HttpServletResponse response) {
		return userService.deleteEmployee();
	}
	
	//修改员工信息
	@RequestMapping("updateEmployee")
	public String updateEmployee(HttpServletRequest request,HttpServletResponse response) {
		return userService.updateEmployee();
	}
	
	
	//查询员工信息
	@RequestMapping("queryEmployee")
	public String queryEmployee(HttpServletRequest request,HttpServletResponse response) {
		return userService.queryEmployee();
	}
	
	//自动补全
	@RequestMapping("autoUserQuery")
	public String autoUserQuery(HttpServletRequest request,HttpServletResponse response) {
					
		return userService.autoUserQuery();
						
		}
	
	
	
	
	
	
	
	
}
