package com.ruoheng.dao;

import java.util.List;
import java.util.Map;

import com.ruoheng.model.Contact;

public interface ContactMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Contact record);

	int insertSelective(Contact record);

	Contact selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Contact record);

	int updateByPrimaryKey(Contact record);

	/**
	 * 查询交往记录集合
	 * 
	 * @param map
	 * @return
	 */
	public List<Contact> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
}