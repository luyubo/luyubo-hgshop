/**  
* @Title: SpecServiceImpl.java  
* @Package com.luyubo.hgshop.service.impl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月4日  
* @version V1.0  
*/  
package com.luyubo.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyubo.hgshop.dao.SpecDao;
import com.luyubo.hgshop.pojo.Spec;
import com.luyubo.hgshop.pojo.SpecOption;
import com.luyubo.hgshop.service.SpecService;

/**  
* @ClassName: SpecServiceImpl  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月4日    
*/
@Service(interfaceClass = SpecService.class)
public class SpecServiceImpl implements SpecService {

	@Autowired
	SpecDao specDao;
	
	@Override
	public PageInfo<Spec> list(String name, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 3);
		return new PageInfo<Spec>(specDao.list(name));
	}

	@Override
	public int add(Spec spec) {
		// TODO Auto-generated method stub
		specDao.addSpec(spec);
		
		//这里是获得主键ID
		//添加主表
		List<SpecOption> options=spec.getOptions();
		
		//循环变量
		int n=1;
		for (SpecOption specOption : options) {
			//设置主表的id
			specOption.setSpecId(spec.getId());
			specDao.addOption(specOption);
			n++;
		}
		//返回的是影响数据的条数
		return n;
	}

	@Override
	public int update(Spec spec) {
		// TODO Auto-generated method stub
		// 去子表中删除
		specDao.deleteSpecOptions(spec.getId());
		//修改主表
		specDao.updateSpec(spec);
		// 插入子表
		List<SpecOption> options = spec.getOptions();
		for (SpecOption specOption : options) {
			// 设置主表的id
			specOption.setSpecId(spec.getId());
			specDao.addOption(specOption);
		}
		return 1;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		//删除字表
		specDao.deleteSpecOptions(id);
		//删除主表
		specDao.deleteSpec(id);
		return 1;
	}

	@Override
	public Spec findById(int id) {
		// TODO Auto-generated method stub
		return specDao.findById(id);
	}

	@Override
	public int deleteBatch(int[] id) {
		// TODO Auto-generated method stub
		//删除子表
		specDao.deleteSpecOptionBatch(id);
		//删除主表
		specDao.deleteSpecBatch(id);
		return 1;
	}

}
