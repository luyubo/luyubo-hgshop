/**  
* @Title: SpecController.java  
* @Package com.luyubo.hgshop.controller  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月4日  
* @version V1.0  
*/  
package com.luyubo.hgshop.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.luyubo.hgshop.pojo.Spec;
import com.luyubo.hgshop.service.SpecService;

/**  
* @ClassName: SpecController  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月4日    
*/
@Controller
@RequestMapping("spec")
public class SpecController {
	
	@Reference
	SpecService specService;
	
	/**
	 * 
	* @Title: list  
	* @Description: TODO(进入规格的列表)  
	* @param @param page
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	@RequestMapping("list")
	public String list(Model model,
					   @RequestParam(defaultValue = "1")int page,
					   @RequestParam(defaultValue = "")String name) {
		PageInfo<Spec> pageInfo = specService.list(name, page);
		model.addAttribute("pageInfo", pageInfo);
		return "spec/list";
	}
}
