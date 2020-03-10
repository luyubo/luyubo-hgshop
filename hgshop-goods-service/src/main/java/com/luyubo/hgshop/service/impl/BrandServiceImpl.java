/**  
* @Title: BrandServiceImpl.java  
* @Package com.luyubo.hgshop.service.impl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月6日  
* @version V1.0  
*/  
package com.luyubo.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyubo.hgshop.dao.BrandDao;
import com.luyubo.hgshop.pojo.Brand;
import com.luyubo.hgshop.service.BrandService;

/**  
* @ClassName: BrandServiceImpl  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月6日    
*/
@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandDao brandDao;
	
	@Override
	public PageInfo<Brand> list(String name, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 4);
		return new PageInfo<Brand>(brandDao.list(name));
	}

	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		return brandDao.deleteBatch(ids);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return brandDao.delete(id);
	}

}
