package com.ruoheng.dao;

import java.util.List;
import java.util.Map;

import com.ruoheng.model.DataDic;

public interface DataDicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataDic record);

    int insertSelective(DataDic record);

    DataDic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataDic record);

    int updateByPrimaryKey(DataDic record);
    
	/**
	 * 查询数据字典集合
	 * @param map
	 * @return
	 */
	public List<DataDic> find(Map<String,Object> map);
	
	/**
	 * 查询所有的数据字典名称集合
	 * @return
	 */
	public List<DataDic> findAll();
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
}