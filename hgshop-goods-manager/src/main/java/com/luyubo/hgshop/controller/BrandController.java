/**  
* @Title: BrandController.java  
* @Package com.luyubo.hgshop.controller  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月4日  
* @version V1.0  
*/  
package com.luyubo.hgshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**  
* @ClassName: BrandController  
* @Description: TODO(品牌管理)  
* @author luyubo 
* @date 2020年3月4日    
*/
@Controller
@RequestMapping("brand")
public class BrandController {

	/**
	 * 
	* @Title: list  
	* @Description: TODO(品牌管理列表)  
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue = "1") int page) {
		return "brand/list";
	}
}
