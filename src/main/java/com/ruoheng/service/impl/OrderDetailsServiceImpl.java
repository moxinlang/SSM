package com.ruoheng.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruoheng.dao.OrderDetailsMapper;
import com.ruoheng.model.OrderDetails;
import com.ruoheng.service.OrderDetailsService;

/**
 * 订单详情Service实现类
 * @author Administrator
 *
 */
@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Resource
	private OrderDetailsMapper orderDetailsMapper;
	
	@Override
	public List<OrderDetails> find(Map<String, Object> map) {
		return orderDetailsMapper.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return orderDetailsMapper.getTotal(map);
	}

	@Override
	public float getTotalPriceByOrderId(Integer orderId) {
		return orderDetailsMapper.getTotalPriceByOrderId(orderId);
	}

}
