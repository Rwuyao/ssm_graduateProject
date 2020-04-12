package com.fs.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
//自定义shiro过滤器，实现的是角色或的关系 myRoles[角色1，角色2]
public class MyRoles extends AuthorizationFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		//获取shiro的用户对象
		Subject subject = getSubject(request, response);
		//获取用户定义的角色参数
		String[] roleParam= (String[]) mappedValue;
		//
		if(roleParam==null || roleParam.length==0){
			return true;
		}
			
		for(String s:roleParam){
			System.err.println("用户定义的权限参数是"+s);
		}
		//判断用户定义的角色参数和授权的角色是否一致
		for(String s:roleParam){
			//subject.isPermitted判断权限或的关系
			
			if (subject.hasRole(s)){
				System.err.println("用户授权了"+s+"权限，允许访问");
				return true;
			}
		}
		
		return false;
	}

}
