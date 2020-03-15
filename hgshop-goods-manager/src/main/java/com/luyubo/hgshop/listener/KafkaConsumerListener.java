
package com.luyubo.hgshop.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.luyubo.hgshop.pojo.SpuEsVo;
import com.luyubo.hgshop.utils.ElSearchUtil;

public class KafkaConsumerListener implements MessageListener<String, String>{
	
	//@Autowired	
	//private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	ElSearchUtil<SpuEsVo> elSearchUtil;

	/**
	 *  日志对象
	 */
	private Logger logger = Logger.getLogger(KafkaConsumerListener.class);
	
	{
		System.out.println("》》》》》》》》》》》》》》》》》》》》这里被实例化了。。。。。。。。。。。。。");
	}
	
	
	public void onMessage(ConsumerRecord<String, String> data) {
		
		 System.out.println("get a message .......... "  );
		//获取key值
		String key = data.key();
		
		if(key!=null) {
			 //判断
			 System.out.println("key is "  + key);
			 String value = data.value();
			 System.out.println("value is "  + value);
			 if(key.contains("addspu")) {
				  value = data.value();
				  Gson gson=new Gson();
				  SpuEsVo spuEsVo = gson.fromJson(value, SpuEsVo.class);
				 try {
					 System.out.println(spuEsVo);
					// 做某些事情
					//将数据保存在es中
					elSearchUtil.saveObject(spuEsVo.getId().toString(),spuEsVo);		
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }else if(key.contains("")) {
				 
			 }
		}else {
			logger.info("key未null值");
		}
		
	}

}
