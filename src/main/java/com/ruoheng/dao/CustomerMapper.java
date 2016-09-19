package com.ruoheng.dao;

import java.util.List;
import java.util.Map;

import com.ruoheng.model.Customer;
import com.ruoheng.model.CustomerFw;
import com.ruoheng.model.CustomerGc;
import com.ruoheng.model.CustomerGx;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    /**
	 * 查询客户集合
	 * @param map
	 * @return
	 */
	public List<Customer> find(Map<String,Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 查找流失的客户 6个月未下单的客户
	 * @return
	 */
	public List<Customer> findLossCustomer();
	
	/**
	 * 查询客户贡献
	 * @param map
	 * @return
	 */
	public List<CustomerGx> findCustomerGx(Map<String,Object> map);
	
	/**
	 * 查询客户贡献记录数
	 * @param map
	 * @return
	 */
	public Long getTotalCustomerGx(Map<String,Object> map);
	
	/**
	 * 查询客户构成
	 * @return
	 */
	public List<CustomerGc> findCustomerGc();
	
	/**
	 * 查询客户服务分析
	 * @return
	 */
	public List<CustomerFw> findCustomerFw();
}