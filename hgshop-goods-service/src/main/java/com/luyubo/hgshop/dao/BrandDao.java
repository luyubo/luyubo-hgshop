/**  
* @Title: BrandDao.java  
* @Package com.luyubo.hgshop.dao  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月6日  
* @version V1.0  
*/  
package com.luyubo.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.luyubo.hgshop.pojo.Brand;

/**  
* @ClassName: BrandDao  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月6日    
*/
public interface BrandDao {

	/**  
	* @Title: list  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param name
	* @param @param firstChar
	* @param @return    参数  
	* @return List<Brand>    返回类型  
	* @throws  
	*/  
	List<Brand> list(String firstChar);

	/**  
	* @Title: delete  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	*/  
	int delete(int id);

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
	* @Title: listAll  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @return    参数  
	* @return List<Brand>    返回类型  
	* @throws  
	*/  
	@Select("SELECT id,name,first_char as firstChar "
			+ " FROM hg_brand "
			+ "where deleted_flag=0"
			+ " ORDER BY name ")
	List<Brand> listAll();

}
