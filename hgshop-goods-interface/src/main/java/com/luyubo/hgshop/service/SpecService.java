/**  
* @Title: SpecService.java  
* @Package com.luyubo.hgshop.service.impl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月4日  
* @version V1.0  
*/  
package com.luyubo.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.luyubo.hgshop.pojo.Spec;

/**  
* @ClassName: SpecService  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月4日    
*/
public interface SpecService {
	/**
	 * 
	* @Title: list  
	* @Description: TODO(分页查询)  
	* @param @param name
	* @param @param page
	* @param @return    参数  
	* @return PageInfo<Spec>    返回类型  
	* @throws
	 */
	PageInfo<Spec> list(String name,int page);
	
	/**  
	* @Title: add  
	* @Description: TODO(添加)  
	* @param     参数  
	* @return void    返回类型  
	* @throws  
	*/
	int add(Spec spec);
	
	/**  
	* @Title: add  
	* @Description: TODO(修改)  
	* @param     参数  
	* @return void    返回类型  
	* @throws  
	*/
	int update(Spec spec);
	/**  
	* @Title: add  
	* @Description: TODO(根据id删除)  
	* @param     参数  
	* @return void    返回类型  
	* @throws  
	*/
	int delete(int id);
	
	/**
	 * 
	* @Title: findById  
	* @Description: TODO(根据id查找)  
	* @param @param id
	* @param @return    参数  
	* @return Spec    返回类型  
	* @throws
	 */
	Spec findById(int id);
	
	/**  
	* @Title: add  
	* @Description: TODO(添加)  
	* @param     参数  
	* @return void    返回类型  
	* @throws  
	*/
	int deleteBatch(int[] id);
}
