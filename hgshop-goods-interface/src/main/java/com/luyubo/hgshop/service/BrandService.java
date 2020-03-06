/**  
* @Title: BrandService.java  
* @Package com.luyubo.hgshop.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月6日  
* @version V1.0  
*/  
package com.luyubo.hgshop.service;


import com.github.pagehelper.PageInfo;
import com.luyubo.hgshop.pojo.Brand;

/**  
* @ClassName: BrandService  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月6日    
*/
public interface BrandService {
	PageInfo<Brand> list(String name,int page);

	/**  
	* @Title: deleteBatch  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param ids
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	*/  
	int deleteBatch(int[] ids);

	/**  
	* @Title: delete  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	*/  
	int delete(int id);
}
