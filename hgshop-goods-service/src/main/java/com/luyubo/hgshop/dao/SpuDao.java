/**  
* @Title: SpuDao.java  
* @Package com.luyubo.hgshop.dao  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月11日  
* @version V1.0  
*/  
package com.luyubo.hgshop.dao;

import java.util.List;

import com.luyubo.hgshop.pojo.Spu;
import com.luyubo.hgshop.pojo.SpuVo;

/**  
* @ClassName: SpuDao  
* @Description: TODO(商品的Dao层)  
* @author luyubo 
* @date 2020年3月11日    
*/
public interface SpuDao {

	/**  
	* @Title: list  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param vo
	* @param @return    参数  
	* @return List<Spu>    返回类型  
	* @throws  
	*/  
	List<Spu> list(SpuVo vo);

	/**  
	* @Title: add  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param spu
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	*/  
	int add(Spu spu);

	/**  
	* @Title: update  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param spu
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	*/  
	int update(Spu spu);

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
	* @Title: get  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id
	* @param @return    参数  
	* @return Spu    返回类型  
	* @throws  
	*/  
	Spu get(int id);

	/**  
	* @Title: deleteSpuBatch  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param ids
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	*/  
	int deleteSpuBatch(int[] ids);

	/**  
	* @Title: findById  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id
	* @param @return    参数  
	* @return Spu    返回类型  
	* @throws  
	*/  
	Spu findById(int id);

}
