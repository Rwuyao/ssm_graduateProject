package com.fs.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.fs.mapper.UserMapper;
import com.fs.model.User;





/**
 * 自定义的授权realm
 * @author wj
 *
 */
public class MyRealm extends AuthorizingRealm{
	
	//注入用户数据层接口
	@Autowired
	private UserMapper userMapper;
//	@Autowired
//	MdFive mdFive;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		//获取当前的用户名
		//Object userName =principals.fromRealm(this.getName()).iterator().next();
		
		String userName=(String)principals.getPrimaryPrincipal();  //获取当前用户名，唯一
		
		System.err.println("开始给用户"+userName+"授权！！");
		//查询角色
		List<String> listRole = userMapper.searchRole(userName);
		System.out.println(listRole);
	
		//查询权限
//		List<String>  listPower = userMapper.searchPower(userName);
		
		//创建shiro授权对象
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		//给用户赋予角色
		simpleAuthorInfo.addRoles(listRole);
		
		for(String s: listRole){
			System.err.println("赋予角色："+s);
		}
		//给用户赋予权限
//		simpleAuthorInfo.addStringPermissions(listPower);
		
//		for(String s: listPower){
//			System.err.println("赋予权限："+s);
//		}
		
		return simpleAuthorInfo;
	
	}

	/**
	 * 认证
	 * 对登录的用户身份进行认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
		
		//获取登录用户名和密码的token对象
		UsernamePasswordToken t=(UsernamePasswordToken)token;
		//获取用户名
		String userName = (String) t.getPrincipal();
		
		System.out.println("这里进入认证方法");
		System.out.println("认证名字为:"+userName);
		//查询数据库,获取用户对象
		User user =userMapper.getUserByUserName(userName);
	
		//判断用户是否存在
		if(user==null){
			System.out.println("用户不存在");
			throw new UnknownAccountException();
		}
		 //创建用户凭证 ，这个对象会把数据库查询出来的用户信息和登录的用户信息进行比对。
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"MyRealm");
		info.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername())); 
		
		//AuthenticationInfo  info = new SimpleAuthenticationInfo(a.getSysName(),a.getSysPwd(),new Md5Hash(userName), this.getName());
		return info;
	
	}
	


}
