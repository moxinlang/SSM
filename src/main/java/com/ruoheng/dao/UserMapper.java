package com.ruoheng.dao;

import java.util.List;
import java.util.Map;

import com.ruoheng.model.User;

public interface UserMapper {
	User login(User user);
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
	/**
	 * 查询用户集合
	 * @param map
	 * @return
	 */
	public List<User> find(Map<String,Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
}