package com.ruoheng.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruoheng.dao.UserMapper;
import com.ruoheng.model.User;
import com.ruoheng.service.UserService;

/**
 * 用户Service实现类
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper usermapper;

	@Override
	public User login(User user) {
		return usermapper.login(user);
	}

	@Override
	public List<User> find(Map<String, Object> map) {
		return usermapper.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return usermapper.getTotal(map);
	}

	@Override
	public int update(User user) {
		return usermapper.updateByPrimaryKey(user);
	}

	@Override
	public int add(User user) {
		return usermapper.insert(user);
	}

	@Override
	public int delete(Integer id) {
		return usermapper.deleteByPrimaryKey(id);
	}
}
