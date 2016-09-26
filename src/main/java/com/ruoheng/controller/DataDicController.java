package com.ruoheng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import jxl.common.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ruoheng.model.DataDic;
import com.ruoheng.model.PageBean;
import com.ruoheng.service.DataDicService;
import com.ruoheng.util.ResponseUtil;
import com.ruoheng.util.StringUtil;

/**
 * 数据字典Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/dataDic")
public class DataDicController {
	Logger logger = Logger.getLogger(DataDicController.class);
	@Resource
	private DataDicService dataDicService;
	
	
	/**
	 * 分页条件查询数据字典
	 * @param page
	 * @param rows
	 * @param s_dataDic
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,DataDic s_dataDic,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("dataDicName", s_dataDic.getDatadicname());
		map.put("dataDicValue", StringUtil.formatLike(s_dataDic.getDatadicvalue()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<DataDic> dataDicList=dataDicService.find(map);
		Long total=dataDicService.getTotal(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(dataDicList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 根据数据字典名称查找，用户下拉框
	 * @param dataDicName
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataDicComboList")
	public String dataDicComboList(String dataDicName,HttpServletResponse response)throws Exception{
		logger.debug("dataDicComboList in dataDicName="+dataDicName);
		JSONArray jsonArray=new JSONArray();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("dataDicName", dataDicName);
		List<DataDic> dataDicList=dataDicService.find(map);
		JSONArray rows=JSONArray.fromObject(dataDicList);
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	
	/**
	 * 查询所有的数据字典名称
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findDataDicName")
	public String dataDicNameComboList(HttpServletResponse response)throws Exception{
		JSONArray jsonArray=new JSONArray();
		List<DataDic> dataDicList=dataDicService.findAll();
		JSONArray rows=JSONArray.fromObject(dataDicList);
		jsonArray.addAll(rows);
		logger.debug("rows="+jsonArray.toString());
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	
	/**
	 * 添加或者修改数据字典
	 * @param dataDic
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(DataDic dataDic,HttpServletResponse response)throws Exception{
		int resultTotal=0; // 操作的记录条数
		
		logger.debug("dataDic sava"+dataDic.toString());
		
		if(dataDic.getId()==null){
			resultTotal=dataDicService.add(dataDic);
		}else{
			resultTotal=dataDicService.update(dataDic);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 删除数据字典
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		logger.debug("delete in ids="+ids);
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			dataDicService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
