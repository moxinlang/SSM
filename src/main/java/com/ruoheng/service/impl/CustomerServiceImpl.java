package com.ruoheng.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruoheng.dao.CustomerMapper;
import com.ruoheng.model.Customer;
import com.ruoheng.model.CustomerFw;
import com.ruoheng.model.CustomerGc;
import com.ruoheng.model.CustomerGx;
import com.ruoheng.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> find(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customerMapper.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customerMapper.getTotal(map);
	}

	@Override
	public int add(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.insert(customer);
	}

	@Override
	public int update(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.updateByPrimaryKey(customer);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return customerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Customer findById(Integer id) {
		// TODO Auto-generated method stub
		return customerMapper.selectByPrimaryKey(id);
	}

	@Override
	public void checkCustomerLoss() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerGx> findCustomerGx(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customerMapper.findCustomerGx(map);
	}

	@Override
	public Long getTotalCustomerGx(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customerMapper.getTotalCustomerGx(map);
	}

	@Override
	public List<CustomerGc> findCustomerGc() {
		// TODO Auto-generated method stub
		return customerMapper.findCustomerGc();
	}

	@Override
	public List<CustomerFw> findCustomerFw() {
		// TODO Auto-generated method stub
		return customerMapper.findCustomerFw();
	}

}
