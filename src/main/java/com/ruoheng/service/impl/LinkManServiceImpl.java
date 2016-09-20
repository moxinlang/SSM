package com.ruoheng.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruoheng.dao.LinkManMapper;
import com.ruoheng.model.LinkMan;
import com.ruoheng.service.LinkManService;

/**
 * 联系人Service实现类
 * @author Administrator
 *
 */
@Service("linkManService")
public class LinkManServiceImpl implements LinkManService{

	@Resource
	private LinkManMapper linkManMapper;
	
	@Override
	public List<LinkMan> find(Map<String, Object> map) {
		return linkManMapper.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return linkManMapper.getTotal(map);
	}

	@Override
	public int update(LinkMan linkMan) {
		return linkManMapper.updateByPrimaryKey(linkMan);
	}

	@Override
	public int add(LinkMan linkMan) {
		return linkManMapper.insert(linkMan);
	}

	@Override
	public int delete(Integer id) {
		return linkManMapper.deleteByPrimaryKey(id);
	}


}
