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

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyubo.hgshop.dao.BrandDao;
import com.luyubo.hgshop.dao.CategoryDao;
import com.luyubo.hgshop.dao.SkuDao;
import com.luyubo.hgshop.dao.SpuDao;
import com.luyubo.hgshop.pojo.Brand;
import com.luyubo.hgshop.pojo.Category;
import com.luyubo.hgshop.pojo.Sku;
import com.luyubo.hgshop.pojo.SpecOption;
import com.luyubo.hgshop.pojo.Spu;
import com.luyubo.hgshop.pojo.SpuVo;
import com.luyubo.hgshop.service.GoodsService;

/**  
* @ClassName: GoodsServiceImpl  
* @Description: TODO(商品接口实现类)  
* @author luyubo 
* @date 2020年3月3日    
*/
@Service(interfaceClass = GoodsService.class)
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	CategoryDao catDao;
	@Autowired
	SpuDao spuDao;
	@Autowired
	SkuDao skuDao;
	@Autowired
	BrandDao brandDao;

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
		return catDao.add(category);
	}
 
	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return catDao.update(category);
	}

	@Override
	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return catDao.delete(id);
	}

	/**
	 * 
	 */
	@Override
	public PageInfo<Category> listCategory(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Brand> getAllBrands() {
		// TODO Auto-generated method stub
		return brandDao.listAll();
	}

	@Override
	public List<Category> treeCategory() {
		// TODO Auto-generated method stub
		return catDao.tree();
	}

	@Override
	public PageInfo<Spu> listSpu(int page, SpuVo vo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		return new PageInfo<Spu>(spuDao.list(vo));
	}

	@Override
	public int addSpu(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.add(spu);
	}

	@Override
	public int updateSpu(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.update(spu);
	}

	@Override
	public int deleteSpu(int id) {
		// TODO Auto-generated method stub
		return spuDao.delete(id);
	}

	@Override
	public Spu getSpu(int id) {
		// TODO Auto-generated method stub
		return spuDao.get(id);
	}

	@Override
	public int deleteSpuBatch(int[] ids) {
		// TODO Auto-generated method stub
		return spuDao.deleteSpuBatch(ids);
	}

	@Override
	public PageInfo<Sku> listSku(int page, Sku sku) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		return new PageInfo<Sku>(skuDao.list(sku));
	}

	@Override
	public int addSku(Sku sku) {
		// TODO Auto-generated method stub
		//先加主表
		int cnt = skuDao.addSku(sku);
		List<SpecOption> specs = sku.getSpecs();
		for (SpecOption specOption : specs) {
			cnt += skuDao.addSkuSpec(sku.getId(),specOption);
		}
		
		return cnt;
	}

	@Override
	public Sku getSku(int id) {
		// TODO Auto-generated method stub
		return skuDao.get(id);
	}

	@Override
	public int updateSku(Sku sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSku(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSkuBatch(int[] id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Sku> listSkuBySpu(int spuId) {
		// TODO Auto-generated method stub
		return skuDao.listBySpu(spuId);
	}

}
