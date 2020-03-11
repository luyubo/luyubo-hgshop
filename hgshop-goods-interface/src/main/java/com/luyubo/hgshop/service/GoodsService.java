/**  
* @Title: GoodsService.java  
* @Package com.luyubo.hgshop.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月3日  
* @version V1.0  
*/  
package com.luyubo.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.luyubo.hgshop.pojo.Brand;
import com.luyubo.hgshop.pojo.Category;
import com.luyubo.hgshop.pojo.Sku;
import com.luyubo.hgshop.pojo.Spu;
import com.luyubo.hgshop.pojo.SpuVo;

/**  
* @ClassName: GoodsService  
* @Description: TODO(商品接口)  
* @author luyubo 
* @date 2020年3月3日    
*/
public interface GoodsService {
	//以下是品牌管理
	/**
	 * 
	* @Title: addBrand  
	* @Description: TODO(添加品牌)  
	* @param @param brand brand的对象
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	int addBrand(Brand brand);
	/**
	 * 
	* @Title: updateBrand  
	* @Description: TODO(修改品牌)  
	* @param @param brand brand的对象
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	int updateBrand(Brand brand);
	/**
	 * 
	* @Title: deleteBrand  
	* @Description: TODO(删除品牌表)  
	* @param @param id 根据id删除
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	int deleteBrand(Integer id);
	/**
	 * 
	* @Title: listBrand  
	* @Description: TODO(查询品牌表)  
	* @param @param firstChar 首字母模糊查询条件
	* @param @param page
	* @param @return    参数  
	* @return PageInfo<Brand>    返回类型  pageInfo分页
	* @throws
	 */
	PageInfo<Brand> listBrand( String firstChar,int page); 
	List<Brand> getAllBrands( ); 
	//以下是category类目表的管理
	/**
	 *  
	* @Title: addCategory  
	* @Description: TODO(类目表的添加)  
	* @param @param category category对象添加
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	int addCategory(Category category);
	/**
	 * 
	* @Title: updateCategory  
	* @Description: TODO(类目表的修改)  
	* @param @param category category的对象
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	int updateCategory(Category category);
	/**
	 * 
	* @Title: deleteCategory  
	* @Description: TODO(根据id删除类目数据)  
	* @param @param id
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	int deleteCategory(Integer id);
	/**
	 * 
	* @Title: listCategory  
	* @Description: TODO(分页查询类目表)  
	* @param @param firstChar
	* @param @param page
	* @param @return    参数  
	* @return PageInfo<Category>    返回类型  pageInfo的分页类目表查询  
	* @throws
	 */
	PageInfo<Category> listCategory( String firstChar,int page); 
	/**
	 * 
	* @Title: treeCategory  
	* @Description: TODO(以树的形式显示列表)  
	* @param @return    参数  
	* @return List<Category>    返回类型   类目表的list集合 
	* @throws
	 */
	List<Category> treeCategory(); 
	
	
	//以下是spu商品的管理
	/**
	 * 
	* @Title: listSpu  
	* @Description: TODO(分页查询spu商品表)  
	* @param @param page
	* @param @param vo
	* @param @return    参数  
	* @return PageInfo<Spu>    返回类型     分页查询数据返回
	* @throws
	 */
	PageInfo<Spu> listSpu(int page,SpuVo vo);
	/**
	 * 
	* @Title: addSpu  
	* @Description: TODO(添加商品表信息)  
	* @param @param spu
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	int addSpu(Spu spu);
	/**
	 * 
	* @Title: updateSpu  
	* @Description: TODO(修改商品表信息)  
	* @param @param spu
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	int updateSpu(Spu spu);
	/**
	 * 
	* @Title: deleteSpu  
	* @Description: TODO(根据id删除商品表信息)  
	* @param @param id
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	int deleteSpu(int id);
	/**
	 * 
	* @Title: getSpu  
	* @Description: TODO(根据id获得商品的对象)  
	* @param @param id
	* @param @return    参数  
	* @return Spu    返回类型    返回一个spu对象
	* @throws
	 */
	Spu getSpu(int id);
	/**
	 * 
	* @Title: deleteSpuBatch  
	* @Description: TODO(批量删除spu数据)  
	* @param @param id
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	int deleteSpuBatch(int[] id);
	
	PageInfo<Sku>  listSku(int page,Sku sku);
	int addSku(Sku sku);
	Sku getSku(int id);//获取详情
	int updateSku(Sku sku);
	int deleteSku(int id);
	int deleteSkuBatch(int[] id);
	/**
	 * 根据spu 获取所有的sku
	 * @param spuId
	 * @return
	 */
	List<Sku>  listSkuBySpu(int spuId);
}
