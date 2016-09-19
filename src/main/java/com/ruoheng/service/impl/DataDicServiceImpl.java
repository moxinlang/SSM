package com.ruoheng.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruoheng.dao.DataDicMapper;
import com.ruoheng.model.DataDic;
import com.ruoheng.service.DataDicService;

/**
 * 数据字典Service实现类
 * @author Administrator
 *
 */
@Service("dataDicService")
public class DataDicServiceImpl implements DataDicService{

	@Resource
	private DataDicMapper dataDicMapper;
	
	@Override
	public List<DataDic> find(Map<String, Object> map) {
		return dataDicMapper.find(map);
	}

	@Override
	public List<DataDic> findAll() {
		return dataDicMapper.findAll();
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return dataDicMapper.getTotal(map);
	}

	@Override
	public int update(DataDic dataDic) {
		return dataDicMapper.updateByPrimaryKey(dataDic);
	}

	@Override
	public int add(DataDic dataDic) {
		return dataDicMapper.insert(dataDic);
	}

	@Override
	public int delete(Integer id) {
		return dataDicMapper.deleteByPrimaryKey(id);
	}

}
