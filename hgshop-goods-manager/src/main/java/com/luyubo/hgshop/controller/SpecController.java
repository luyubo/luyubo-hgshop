/**  
* @Title: SpecController.java  
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
	
	/**
	 * 添加
	 * @param request
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request,Spec spec) {
		System.out.println("spec" + spec);
		//System.out.println();
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		//System.out.println("spec 处理后：" + spec);
		//调用服务
		int add = specService.add(spec);
		return add>0?"success":"false";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request,Spec spec) {
		System.out.println("spec" + spec);
		//System.out.println();
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		System.out.println("spec 处理后：" + spec);
		//调用服务1
		int add = specService.update(spec);  
		//return add>0?"success":"false";
		return "fail";
	}
	
	
	
	/**
	 * 用于修改数据时候的回显
	 * @param request
	 * @param id 规格id
	 * @return
	 */
	@RequestMapping("getSpec")
	@ResponseBody
	public Spec getSpec(HttpServletRequest request, int id){
		return specService.findById(id);
		
	}
	
	
	/**
	 * 删除规格
	 * @param request
	 * @param id  规格的id
	 * @return
	 */
	@RequestMapping("delSpec")
	@ResponseBody
	public String delSpec(HttpServletRequest request,int id) {
		//调用服务
		int delNum = specService.delete(id);
		return delNum>0?"success":"false";
	}
	
	/**
	 * 删除规格
	 * @param request
	 * @param id  规格的id
	 * @return
	 */
	@RequestMapping("delSpecBatch")
	@ResponseBody
	public String delSpecBatch(HttpServletRequest request,@RequestParam(name="ids[]") int[] ids) {
		System.out.println("要删除的额数据");
		for (int i : ids) {
			System.out.println(" i is " + i  );
		}
		//调用服务
		int delNum = specService.deleteBatch(ids);
		return delNum>0?"success":"false";
	}
}
