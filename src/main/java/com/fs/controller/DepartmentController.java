package com.fs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fs.service.DepartmentService;

/**
 * @author Mr-Yang
 *
 */
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	//------------------------------------------------下面写逻辑代码-------------------------------------------------------
	
	
	//跳转到部门信息
	@RequestMapping("department_info")
	public String department_info(HttpServletRequest request,HttpServletResponse response) {
		return "view/administrationManage/department_info";
	}
	
	
	
	

}
