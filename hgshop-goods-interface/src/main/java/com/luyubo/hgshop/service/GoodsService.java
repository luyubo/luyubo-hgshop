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

/**  
* @ClassName: GoodsService  
* @Description: TODO(商品接口)  
* @author luyubo 
* @date 2020年3月3日    
*/
public interface GoodsService {
	int addBrand(Brand brand);
	int updateBrand(Brand brand);
	int deleteBrand(Integer id);
	/**
	 * 
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Brand> listBrand( String firstChar,int page); 
	
	
	int addCategory(Category category);
	int updateCategory(Category category);
	int deleteCategory(Integer id);
	/**
	 * 
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Category> listCategory( String firstChar,int page); 
	/**
	 * 以树的形式显示列表
	 * @return
	 */
	List<Category> treeCategory(); 
	
}
