/**  
* @Title: SpecDao.java  
* @Package com.luyubo.hgshop.dao  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月4日  
* @version V1.0  
*/  
package com.luyubo.hgshop.dao;

import java.util.List;

import com.luyubo.hgshop.pojo.Spec;
import com.luyubo.hgshop.pojo.SpecOption;

/**  
* @ClassName: SpecDao  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月4日    
*/
public interface SpecDao {

	/**  
	* @Title: list  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param name
	* @param @return    参数  
	* @return List<Spec>    返回类型  
	* @throws  
	*/  
	List<Spec> list(String name);

	/**  
	* @Title: addSpec  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param spec    参数  
	* @return void    返回类型  
	* @throws  
	*/  
	int addSpec(Spec spec);

	/**  
	* @Title: addOption  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param specOption    参数  
	* @return void    返回类型  
	* @throws  
	*/  
	int addOption(SpecOption specOption);

	/**  
	* @Title: updateSpec  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param spec
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	*/  
	int updateSpec(Spec spec);

	/**  
	* @Title: deleteSpecOption  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id    参数  
	* @return void    返回类型  
	* @throws  
	*/  
	int deleteSpecOptions(int id);

	/**  
	* @Title: deleteSpec  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id    参数  
	* @return void    返回类型  
	* @throws  
	*/  
	int deleteSpec(int id);

	/**  
	* @Title: findById  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id
	* @param @return    参数  
	* @return Spec    返回类型  
	* @throws  
	*/  
	Spec findById(int id);

	/**  
	* @Title: deleteSpecOptionBatch  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id    参数  
	* @return void    返回类型  
	* @throws  
	*/  
	int deleteSpecOptionBatch(int[] id);

	/**  
	* @Title: deleteSpecBatch  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id    参数  
	* @return void    返回类型  
	* @throws  
	*/  
	int deleteSpecBatch(int[] id);

	/**  
	* @Title: listAll  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @return    参数  
	* @return List<Spec>    返回类型  
	* @throws  
	*/  
	List<Spec> listAll();

}
