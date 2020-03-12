package com.luyubo.hgshop.service;

import com.luyubo.hgshop.pojo.User;

/**
 * 
 * @author zhuzg
 *
 */
public interface WebUserService {
	
	/**
	 * 用户登录
	 * @param username
	 * @param pwd
	 * @return
	 */
	User login(String username,String pwd);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	User register(User user);
	
	
	
}
