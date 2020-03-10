/**  
* @Title: CategoryDao.java  
* @Package com.luyubo.hgshop.dao  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月6日  
* @version V1.0  
*/  
package com.luyubo.hgshop.dao;

import java.util.List;

import com.luyubo.hgshop.pojo.Category;

/**  
* @ClassName: CategoryDao  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月6日    
*/
public interface CategoryDao {

	 List<Category> tree();

		int add(Category category);

		/**
		 * 
		 * @param id
		 * @return
		 */
		int delete(Integer id);

		/**
		 * 修改
		 * @param category
		 * @return
		 */
		int update(Category category);

}
