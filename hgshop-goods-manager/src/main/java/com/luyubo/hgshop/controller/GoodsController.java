/**  
* @Title: GoodsController.java  
* @Package com.luyubo.hgshop.controller  
* @Description: TODO(用一句话描述该文件做什么)  
* @author luyubo
* @date 2020年3月12日  
* @version V1.0  
*/  
package com.luyubo.hgshop.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.luyubo.hgshop.pojo.Brand;
import com.luyubo.hgshop.pojo.Sku;
import com.luyubo.hgshop.pojo.Spec;
import com.luyubo.hgshop.pojo.SpecOption;
import com.luyubo.hgshop.pojo.Spu;
import com.luyubo.hgshop.pojo.SpuVo;
import com.luyubo.hgshop.service.GoodsService;
import com.luyubo.hgshop.service.SpecService;

/**  
* @ClassName: GoodsController  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author luyubo 
* @date 2020年3月12日    
*/
@Controller
@RequestMapping("goods")
public class GoodsController {
	@Reference
	GoodsService goodsService;
	
	@Reference
	SpecService specService;
	
	/**
	 * 
	* @Title: list  
	* @Description: TODO(查询)  
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue = "1")int page,
			SpuVo spuVo) {
		PageInfo<Spu> list=goodsService.listSpu(page, spuVo);
		request.setAttribute("pageInfo", list);
		return "goods/list";
	}
	
	@RequestMapping("toadd")
	public String toadd(HttpServletRequest request ) {
		List<Brand> allBrands = goodsService.getAllBrands();
		request.setAttribute("brands", allBrands);
		return "goods/add";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request,Spu spu,@RequestParam(value="file")MultipartFile file) throws IllegalStateException, IOException {
		//设置商品默认为上架
		spu.setIsMarketable("1");
		/**
		 * 返回的上传文件存放的物理地址
		 */
		String filePath=processFile(file);
		// 可以根据 这个地址下载
		spu.setSmallPic(filePath);
		int result = goodsService.addSpu(spu);
		return result>0?"success":"failed";
	}
	
	@RequestMapping("down")
	public void download(HttpServletResponse response,String filename) throws FileNotFoundException {
		/* // 下载本地文件
	    String fileName = "Operator.doc".toString(); // 文件的默认保存名
*/	    // 读到流中
	    InputStream inStream = new FileInputStream("d:\\pic\\"+filename);// 文件的存放路径
	    // 设置输出的格式
	    response.reset();
	    response.setContentType("bin");
	    response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
	   
	    // 循环取出流中的数据
	    byte[] b = new byte[1024];
	    int len;
	    try {
	      while ((len = inStream.read(b)) > 0)
	        response.getOutputStream().write(b, 0, len);
	      inStream.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	/**
	 *  上传文件
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	private String processFile(MultipartFile file) throws IllegalStateException, IOException {

		// 原来的文件名称
		System.out.println("file.isEmpty() :" + file.isEmpty()  );
		System.out.println("file.name :" + file.getOriginalFilename());
		
		if(file.isEmpty()||"".equals(file.getOriginalFilename()) || file.getOriginalFilename().lastIndexOf('.')<0 ) {
			return "";
		}
			
		String originName = file.getOriginalFilename();
		String suffixName = originName.substring(originName.lastIndexOf('.'));
		SimpleDateFormat sdf=  new SimpleDateFormat("yyyyMMdd");
		String path = "d:/pic/" + sdf.format(new Date());
		File pathFile = new File(path);
		if(!pathFile.exists()) {
			pathFile.mkdir();
		}
		String destFileName = 		path + "/" +  UUID.randomUUID().toString() + suffixName;
		File distFile = new File( destFileName);
		file.transferTo(distFile);//文件另存到这个目录下边
		return destFileName.substring(7);
	}
	
	@RequestMapping("skulist")
	public String skulist(HttpServletRequest request,Sku sku,
			@RequestParam(defaultValue = "1")int page) {
		PageInfo<Sku> listSku = goodsService.listSku(page, sku);
		request.setAttribute("pageInfo",listSku);
		return "sku/list";
	}
	
	@RequestMapping("skuDetail")
	public String skuDetail(HttpServletRequest request,int id){
		Sku sku = goodsService.getSku(id);
		request.setAttribute("sku", sku);
		return "sku/detail";
	}
	
	@RequestMapping("toaddSku")
	public String toaddSku(HttpServletRequest request,int spuId){
		//获取要添加的商品
		Spu spu = goodsService.getSpu(spuId);
		/*
		 * //获取所有的品牌 List<Brand> brands = goodsService.getAllBrands();
		 */
		//获取所有的属性名称
		List<Spec> specs=specService.listAll();
		
		request.setAttribute("spu", spu);
		request.setAttribute("specs", specs);
		return "sku/add";
	}
	
	/**
	 * 添加sku
	* @Title: addSku  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param request
	* @param @param sku
	* @param @param specIds
	* @param @param specOptionIds
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	@RequestMapping("addSku")
	@ResponseBody
	public String addSku(HttpServletRequest request,Sku sku,int[] specIds,
			@RequestParam("specOptionIds")int[] specOptionIds) {
		List<SpecOption> specs=new ArrayList<SpecOption>();
		for(int i=0;i<specIds.length && i<specOptionIds.length;i++) {
			SpecOption specOption=new SpecOption();
			specOption.setSpecId(specIds[i]);
			//具体的属性值的id
			specOption.setId(specOptionIds[i]);
			specs.add(specOption);
		}
		sku.setSpecs(specs);
		int addSku = goodsService.addSku(sku);
		return addSku>0?"success":"failed";
	}
}
