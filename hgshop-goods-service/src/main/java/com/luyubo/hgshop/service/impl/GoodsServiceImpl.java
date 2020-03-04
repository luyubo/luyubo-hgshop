/**  
* @Title: GoodsServiceImpl.java  
* @Package com.luyubo.hgshop.service.impl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月3日  
* @version V1.0  
*/  
package com.luyubo.hgshop.service.impl;

import java.util.List;


import com.github.pagehelper.PageInfo;
import com.luyubo.hgshop.pojo.Brand;
import com.luyubo.hgshop.pojo.Category;
import com.luyubo.hgshop.service.GoodsService;

/**  
* @ClassName: GoodsServiceImpl  
* @Description: TODO(商品接口实现类)  
* @author luyubo 
* @date 2020年3月3日    
*/
public class GoodsServiceImpl implements GoodsService {

	@Override
	public int addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBrand(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Brand> listBrand(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Category> listCategory(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> treeCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
