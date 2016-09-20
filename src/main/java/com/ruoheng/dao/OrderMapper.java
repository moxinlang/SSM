package com.ruoheng.dao;

import java.util.List;
import java.util.Map;

import com.ruoheng.model.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    

	/**
	 * 查询订单集合
	 * @param map
	 * @return
	 */
	public List<Order> find(Map<String,Object> map);
	
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	
	/**
	 * 查找指定客户的最近的订单
	 * @param cusId
	 * @return
	 */
	public Order findLastOrderByCusId(int cusId);
}