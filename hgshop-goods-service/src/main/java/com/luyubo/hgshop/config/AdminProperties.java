/**  
* @Title: Properties.java  
* @Package com.luyubo.hgshop.config  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月4日  
* @version V1.0  
*/  
package com.luyubo.hgshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**  
* @ClassName: Properties  
* @Description: TODO(配置类 读取属性文件)  
* @author luyubo 
* @date 2020年3月4日    
*/
@Configuration
@PropertySource("classpath:hgshop-admin.properties")
public class AdminProperties {
	@Value("${admin.name}")
	String adminName;
	
	@Value("${admin.pwd}")
	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
}
