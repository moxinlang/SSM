package com.ruoheng.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruoheng.dao.OrderMapper;
import com.ruoheng.model.Order;
import com.ruoheng.service.OrderService;

/**
 * 订单Service实现类
 * @author Administrator
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Resource
	private OrderMapper orderMapper;
	
	@Override
	public List<Order> find(Map<String, Object> map) {
		return orderMapper.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return orderMapper.getTotal(map);
	}

	@Override
	public Order findById(Integer id) {
		return orderMapper.selectByPrimaryKey(id);
	}
}
