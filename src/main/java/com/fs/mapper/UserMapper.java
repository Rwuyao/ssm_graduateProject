package com.fs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Md5Hash;


import com.fs.model.Customer;

import com.fs.model.Order;

import com.fs.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


	User getUserByUserName(String username);


	List<String> searchRole(String userName);


	


	/************************************/
	//显示员工列表
	List<User> queryAllUser();

	//新增员工信息
	int addEmployee(@Param("userId")int userId, @Param("username")String username, @Param("md5")String md5, 
			@Param("name")String name, @Param("depId")Integer depId, @Param("email")String email, @Param("tel")String tel,
			@Param("address")String address);

	//动用数据库，删除对应id 的员工
	int deleteEmployeeById(@Param("userId")int userId);

	
	//修改员工信息
	int updateEmployee(@Param("updateuserId")int updateuserId, @Param("updateusername")String updateusername, @Param("updatename")String updatename, 
			@Param("updatedepId")int updatedepId,
			@Param("updatetelephone")String updatetelephone,@Param("updateemail") String updateemail, @Param("updateadress")String updateadress);

	//查询员工信息
	List<User> queryEmployee(String keyword);

	//自动搜索提示
	List<String> queryName();

}