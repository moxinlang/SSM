package com.ruoheng.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruoheng.dao.ContactMapper;
import com.ruoheng.model.Contact;
import com.ruoheng.service.ContactService;

/**
 * 交往记录Service实现类
 * @author Administrator
 *
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService{

	@Resource
	private ContactMapper contactMapper;
	
	@Override
	public List<Contact> find(Map<String, Object> map) {
		return contactMapper.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return contactMapper.getTotal(map);
	}

	@Override
	public int update(Contact contact) {
		return contactMapper.updateByPrimaryKey(contact);
	}

	@Override
	public int add(Contact contact) {
		return contactMapper.insert(contact);
	}

	@Override
	public int delete(Integer id) {
		return contactMapper.deleteByPrimaryKey(id);
	}
}
