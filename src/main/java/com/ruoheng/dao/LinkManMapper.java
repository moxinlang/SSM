package com.ruoheng.dao;

import java.util.List;
import java.util.Map;

import com.ruoheng.model.LinkMan;

public interface LinkManMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LinkMan record);

    int insertSelective(LinkMan record);

    LinkMan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LinkMan record);

    int updateByPrimaryKey(LinkMan record);
    
    /**
	 * 查询联系人集合
	 * @param map
	 * @return
	 */
	public List<LinkMan> find(Map<String,Object> map);
	
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
}