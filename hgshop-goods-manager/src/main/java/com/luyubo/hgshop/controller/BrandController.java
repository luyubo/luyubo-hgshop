/**  
* @Title: BrandController.java  
* @Package com.luyubo.hgshop.controller  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月4日  
* @version V1.0  
*/  
package com.luyubo.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.luyubo.hgshop.pojo.Brand;
import com.luyubo.hgshop.service.BrandService;

/**  
* @ClassName: BrandController  
* @Description: TODO(品牌管理)  
* @author luyubo 
* @date 2020年3月4日    
*/
@Controller
@RequestMapping("brand")
public class BrandController {
	@Reference
	BrandService brandService;

	/**
	 * 
	* @Title: list  
	* @Description: TODO(品牌管理列表)  
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "") String name,
			Model model) {
		PageInfo<Brand> list = brandService.list(name, page);
		model.addAttribute("pageInfo", list);
		model.addAttribute("queryName", name);
		return "brand/list";
	}
	
	/**
	 * 删除规格
	 * @param request
	 * @param id  规格的id
	 * @return
	 */
	@RequestMapping("delBrand")
	@ResponseBody
	public String delSpec(HttpServletRequest request,int id) {
		System.out.println(id);
		//调用服务
		int delNum = brandService.delete(id);
		return delNum>0?"success":"false";
	}
	
	/**
	 * 删除规格
	 * @param request
	 * @param id  规格的id
	 * @return
	 */
	@RequestMapping("delBrandBatch")
	@ResponseBody
	public String delSpecBatch(HttpServletRequest request,@RequestParam(name="ids[]") int[] ids) {
		//调用服务
		int delNum = brandService.deleteBatch(ids);
		return delNum>0?"success":"false";
	}
}
