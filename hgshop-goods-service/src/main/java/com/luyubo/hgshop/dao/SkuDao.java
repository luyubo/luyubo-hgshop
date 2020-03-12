/**  
* @Title: SkuDao.java  
* @Package com.luyubo.hgshop.dao  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月11日  
* @version V1.0  
*/  
package com.luyubo.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.hgshop.pojo.Sku;
import com.luyubo.hgshop.pojo.SpecOption;

/**  
* @ClassName: SkuDao  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月11日    
*/
public interface SkuDao {

	/**  
	* @Title: listBySpu  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param spuId
	* @param @return    参数  
	* @return List<Sku>    返回类型  
	* @throws  
	*/  
	List<Sku> listBySpu(int spuId);

	/**  
	* @Title: list  
	* @Description: TODO(sku查询)  
	* @param @param sku
	* @param @return    参数  
	* @return List<Sku>    返回类型  
	* @throws  
	*/  
	List<Sku> list(Sku sku);

	/**  
	* @Title: addSku  
	* @Description: TODO(添加sku)  
	* @param @param sku
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	*/  
	int addSku(Sku sku);

	/**  
	* @Title: addSkuSpec  
	* @Description: TODO(添加sku对应的规格表)  
	* @param @param id
	* @param @param specOption
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	*/  
	int addSkuSpec(@Param("skuId") int skuId,@Param("so") SpecOption so);

	/**  
	* @Title: get  
	* @Description: TODO(根据id获得sku商品属性表)  
	* @param @param id
	* @param @return    参数  
	* @return Sku    返回类型  
	* @throws  
	*/  
	Sku get(int id);

}
