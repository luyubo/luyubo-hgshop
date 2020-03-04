/**  
* @Title: SpecOption.java  
* @Package com.luyubo.hgshop.pojo  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月4日  
* @version V1.0  
*/
package com.luyubo.hgshop.pojo;

import java.io.Serializable;

/**
 * @ClassName: SpecOption
 * @Description: TODO(规格选项实体类)
 * @author luyubo
 * @date 2020年3月4日
 */
public class SpecOption implements Serializable{
	/**  
	* @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	*/  
	private static final long serialVersionUID = -3151997881033202736L;
	private Integer id;
	private String optionName;
	private Integer specId;
	private Integer orders=0;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Integer getSpecId() {
		return specId;
	}
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	public Integer getOrders() {
		return orders;
	}
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	public SpecOption(Integer id, String optionName, Integer specId, Integer orders) {
		super();
		this.id = id;
		this.optionName = optionName;
		this.specId = specId;
		this.orders = orders;
	}
	public SpecOption() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpecOption other = (SpecOption) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
