/**  
* @Title: UserService.java  
* @Package com.luyubo.hgshop.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月3日  
* @version V1.0  
*/  
package com.luyubo.hgshop.service;

/**  
* @ClassName: UserService  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月3日    
*/
public interface UserService {
	//登录
	boolean login(String username,String password);
}
