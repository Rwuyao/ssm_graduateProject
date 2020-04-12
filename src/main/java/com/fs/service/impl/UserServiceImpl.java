package com.fs.service.impl;


import java.util.List;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.mapper.UserMapper;

import com.fs.model.Customer;

import com.fs.model.Order;

import com.fs.model.User;
import com.fs.service.UserService;
import com.google.gson.Gson;

//import net.sf.json.JSONArray;

/**
 * @author Mr-Yang
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private HttpServletRequest req;
	@Autowired
	private HttpServletResponse resp;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------


	@Override
	public String checkUser(String username, String password, HttpServletRequest request) {
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token =new UsernamePasswordToken(username,password);
		System.out.println("这里进入令牌方法");
		
		try {
			System.out.println("这里提交令牌");
			subject.login(token);
			
			User user=userMapper.getUserByUserName(username);
			request.getSession().setAttribute("USER",user);
			return "main";
		} catch (AuthenticationException e) {
				request.setAttribute("info","认证失败");
				return "login";
		}
	}


	/******************************************************************************/

	//显示员工列表
	@Override
	public String employee_info() {
		
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		//查询数据库，获得员工信息列表
		List<User> uList = userMapper.queryAllUser();
		req.setAttribute("uList", uList);
		System.out.println("**uList**"+uList);
		
		
		return "view/administrationManage/employee_info";
	}

	//新增员工信息
	@Override
	public String addEmployee() {
		System.out.println("新增员工信息");
		
		//获得前台输入内容
		String userIdStr = req.getParameter("userId");
		Integer userId = Integer.parseInt(userIdStr);
		
		String username = req.getParameter("username");
		String name = req.getParameter("name");
		
		String depIdStr = req.getParameter("depId");
		int depId = Integer.parseInt(depIdStr);
		
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String address = req.getParameter("address");
		
		//生成默认密码
		Md5Hash md5Str = new Md5Hash("123",username);
		String md5 = md5Str.toString();
		System.out.println(md5.toString());
		
		//将数据存入数据库
		int i = userMapper.addEmployee(userId,username,md5,name,depId,email,tel,address);
		
		List<User> uList = userMapper.queryAllUser();
		req.setAttribute("uList", uList);
		return "view/administrationManage/employee_info";
	}


	//删除员工信息
	@Override
	public String deleteEmployee() {
		
		String userIdStr = req.getParameter("userId");
		int userId = Integer.parseInt(userIdStr);
		PrintWriter pw;
		try {
			pw = resp.getWriter();
			Gson gson = new Gson();
			String result = gson.toJson(userId);
			pw.print(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//动用数据库，删除对应id 的员工
		int i = userMapper.deleteEmployeeById(userId);
		List<User> uList = userMapper.queryAllUser();
		req.setAttribute("uList", uList);
		return "view/administrationManage/employee_info";
	}

	
	
	//修改员工信息
	@Override
	public String updateEmployee() {
		
		//拿到前端修改后的值
		String updateuserIdStr  = req.getParameter("updateuserId");
		int updateuserId = Integer.parseInt(updateuserIdStr);
		
		String updatename= req.getParameter("updatename");
		String updateusername= req.getParameter("updateusername");
		String updatedepIdStr= req.getParameter("updatedepId");
		int updatedepId = Integer.parseInt(updatedepIdStr);
		
		String updatetelephone= req.getParameter("updatetelephone");
		String updateemail= req.getParameter("updateemail");
		String updateadress= req.getParameter("updateadress");
		
		//调用数据库
		int s = userMapper.updateEmployee(updateuserId,updateusername,updatename,updatedepId,updatetelephone,updateemail,updateadress);
				
		List<User> uList = userMapper.queryAllUser();
		req.setAttribute("uList", uList);
		return "view/administrationManage/employee_info";
	}

	
	
	//查询员工信息
	@Override
	public String queryEmployee() {
		
		System.out.println("查询员工信息");
		
		//获得查询输入
		String keyword1 = req.getParameter("keyword1");
		System.out.println(keyword1);
		
		if (keyword1==null || keyword1=="") {
			List<User> uList = userMapper.queryAllUser();
			req.setAttribute("uList", uList);
			return "view/administrationManage/employee_info";
			}
		else{
			List<User> uList = userMapper.queryEmployee(keyword1);
			req.setAttribute("uList", uList);
			return "view/administrationManage/employee_info";
		}
	}
	
	//自动提示
	@Override
	public String autoUserQuery() {
			
		/*
		 * try { req.setCharacterEncoding("utf-8"); resp.setCharacterEncoding("utf-8");
		 * 
		 * 
		 * 
		 * 
		 * //查询数据库 List<String> sList = userMapper.queryName();
		 * System.out.println(sList);
		 * 
		 * String keyword1 = req.getParameter("keyword1"); List<String> res = new
		 * ArrayList<>();
		 * 
		 * for(String string:sList){ if (string.contains(keyword1)) { res.add(string); }
		 * }
		 * 
		 * JSONArray jsonArray = JSONArray.fromObject(res);
		 * resp.setContentType("text/html");
		 * 
		 * try { resp.getWriter().print(jsonArray.toString()); } catch (IOException e) {
		 * e.printStackTrace(); }
		 * 
		 * 
		 * 
		 * } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */
			return null;
	}
	
	
	
	
	
	
	
	
	
	
	

}
