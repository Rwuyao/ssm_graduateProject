package com.fs.config;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fs.realm.MyRealm;
import com.fs.realm.MyRoles;

@Configuration
public class ShiroConfig {

	// 配置密码匹配器

	@Bean(name = { "myHashed" })
	public HashedCredentialsMatcher getHashedCredential() {
		HashedCredentialsMatcher hcd = new HashedCredentialsMatcher();
		hcd.setHashAlgorithmName("md5");
		hcd.setHashIterations(1);
		return hcd;
	}

	// 配置自定义myrealm

	@Bean(name = { "myRealm" })
	public MyRealm getMyrealm(@Qualifier("myHashed") HashedCredentialsMatcher hs) {
		MyRealm realm = new MyRealm();
		realm.setCredentialsMatcher(hs);
		return realm;
	}

	// 配置安全管理器

	@Bean(name = { "manager" })
	public DefaultWebSecurityManager getManager(@Qualifier("myRealm") MyRealm realm) {
		DefaultWebSecurityManager dws = new DefaultWebSecurityManager();
		dws.setRealm(realm);

		return dws;
	}

	@Bean(name = { "lifecy" })
	public LifecycleBeanPostProcessor getLife() {
		return new LifecycleBeanPostProcessor();
	}

	// 配置过滤器

	@Bean(name = {"shiroFilter"}) 
	public ShiroFilterFactoryBean
	  getShiroBean(@Qualifier("manager") DefaultWebSecurityManager securityManager)
	  {
	  
	  ShiroFilterFactoryBean shiriFilterbean = new ShiroFilterFactoryBean();
	  
	  shiriFilterbean.setSecurityManager(securityManager); 
	  shiriFilterbean.setLoginUrl("/login.jsp");
	  shiriFilterbean.setUnauthorizedUrl("/NoPermission.jsp"); 
	  //配置自定义的过滤器
	  Map<String,Filter> myFilterMap = new LinkedHashMap<String,Filter>();
	  myFilterMap.put("dd", new MyRoles());
	  shiriFilterbean.setFilters(myFilterMap);
	  
	  Map<String,String> map = new LinkedHashMap<String,String>();
	  //要访问该页面，必须要认证通过才能访问
	  map.put("/main.html", "authc");
	  
	  //基本信息,所有人都可以查看
	  map.put("/product_info","dd[manager,maintainer,employee]");
	  map.put("/client_info","dd[manager,maintainer,employee]");
	  map.put("/supplier_info","dd[manager,maintainer,employee]");
	  
	  //库存管理,经理或者运维人员可以查看
	  map.put("/allGoods","dd[manager,maintainer]");
	  map.put("/inventory_check","dd[manager,maintainer]");
	  map.put("/inventory_out","dd[manager,maintainer]");
	  
	  //销售管理,只有经理可以查看
	  map.put("/order_query","roles[manager]");
	  map.put("/sales_statistic","roles[manager]");
	  map.put("/sales_manage","roles[manager]");
	  
	  //财务管理,只有经理可以查看
	  map.put("/commercial_cost","roles[manager]");
	  map.put("/commercial_check","roles[manager]");
	  map.put("/commercial_revenue","roles[manager]");
	  
	  //行政管理,只有经理可以查看
	  map.put("/employee_info","roles[manager]");
	  map.put("/department_info","roles[manager]");
	  map.put("/role_manage","roles[manager]");
	  
	  //Boss权限,只有经理有权限
	  map.put("/check_info","roles[manager]");
	  
	  shiriFilterbean.setFilterChainDefinitionMap(map);
	  
	  return shiriFilterbean; 
	  }

}
