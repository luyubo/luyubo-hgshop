/**  
* @Title: UserServiceImpl.java  
* @Package com.luyubo.hgshop.service.impl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月3日  
* @version V1.0  
*/  
package com.luyubo.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.luyubo.hgshop.config.AdminProperties;
import com.luyubo.hgshop.service.UserService;

/**  
* @ClassName: UserServiceImpl  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月3日    
*/
@Service(interfaceClass=UserService.class,version="1.0.0")
public class UserServiceImpl implements UserService{

	//得到管理员的信息
	@Autowired
	AdminProperties adminProperties;
	@Override
	public boolean login(String userName, String passWord) {
		// TODO Auto-generated method stub
		//判断用户和密码是否与配置文件一致
		return adminProperties.getAdminName().equals(userName) && adminProperties.getPassword().equals(passWord);
	}
}
