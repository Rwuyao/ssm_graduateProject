package com.fs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fs.service.RoleService;

/**
 * @author Mr-Yang
 *
 */
@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------
	
	//跳转到行政管理中的角色管理
	@RequestMapping("role_manage")
	public String role_manage(HttpServletRequest request,HttpServletResponse response) {
		return "view/administrationManage/role_manage";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
