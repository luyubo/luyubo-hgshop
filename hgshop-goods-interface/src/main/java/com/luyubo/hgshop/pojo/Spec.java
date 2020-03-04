/**  
* @Title: Spec.java  
* @Package com.luyubo.hgshop.pojo  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月4日  
* @version V1.0  
*/  
package com.luyubo.hgshop.pojo;

import java.io.Serializable;
import java.util.List;

/**  
* @ClassName: Spec  
* @Description: TODO(规格实体类)  
* @author luyubo 
* @date 2020年3月4日    
*/
public class Spec implements Serializable{

	/**  
	* @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	*/  
	private static final long serialVersionUID = 3840313661577471709L;
	private Integer id;
	private String specName;
	//规格里所有的属性
	private List<SpecOption> specOptions;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public List<SpecOption> getSpecOptions() {
		return specOptions;
	}
	public void setSpecOptions(List<SpecOption> specOptions) {
		this.specOptions = specOptions;
	}
	public Spec(Integer id, String specName, List<SpecOption> specOptions) {
		super();
		this.id = id;
		this.specName = specName;
		this.specOptions = specOptions;
	}
	public Spec() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Spec [id=" + id + ", specName=" + specName + ", specOptions=" + specOptions + "]";
	}
}
