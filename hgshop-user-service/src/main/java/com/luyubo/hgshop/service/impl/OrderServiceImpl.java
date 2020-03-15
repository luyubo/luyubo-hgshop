package com.luyubo.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.luyubo.hgshop.dao.OrderDao;
import com.luyubo.hgshop.pojo.Order;
import com.luyubo.hgshop.pojo.OrderDetail;
import com.luyubo.hgshop.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author zhuzg
 *
 */
@Service(interfaceClass=OrderService.class)
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDao orderDao;

	@Override
	public PageInfo<Order> list(int userId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		
		return new PageInfo<Order>(orderDao.list(userId));
	}

	@Override
	public List<OrderDetail> listDetail(int orderId, int page) {
		// TODO Auto-generated method stub
		return orderDao.listDetail(orderId);
	}
	
}
