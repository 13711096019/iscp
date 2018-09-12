package com.cn.iscp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.cn.common._Tool;

/**
 * 分页对象
 * @author 10011037@qq.com
 * 2016-02-12
 */
public class PageModel {

	private static Logger log = Logger.getLogger(PageModel.class);
	/** 分页-默认每页10条 */
	public static final Integer CURRENT_PAGE = 10;
	
	
	private Integer sEcho;
	
	private Integer iTotalRecords;
	
	private Integer iTotalDisplayRecords;
	
	private List<?> aaData;
	
	public PageModel(){};
	
	public PageModel(Integer sEcho, Integer total, List<?> list){
		this.sEcho = sEcho;
		this.iTotalRecords = total;
		this.iTotalDisplayRecords = total;
		this.aaData = list;
	}

	public Integer getSEcho() {
		return sEcho;
	}

	public void setSEcho(Integer sEcho) {
		this.sEcho = sEcho;
	}

	public Integer getITotalRecords() {
		return iTotalRecords;
	}

	public void setITotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Integer getITotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setITotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<?> getAaData() {
		return aaData;
	}

	public void setAaData(List<?> aaData) {
		this.aaData = aaData;
	}
	
	public static Map<String, Object> getPagingMap(String aoData){
		// 搜索关键字
		String statName = null;
		// 记录操作的次数 每次加1
		Integer sEcho = 0;
		// 起始条数
		Integer start = 0;
		// 每页条数
		Integer rows = CURRENT_PAGE;
		// 参数校验
		try {
			JSONObject data = new JSONObject(aoData);
			if(data.has("sEcho")){
				sEcho = _Tool.isInt(data.get("sEcho")) ? _Tool.toInt(data.get("sEcho")) + 1 : sEcho;
			}
			if(data.has("iDisplayStart")){
				start = _Tool.isInt(data.get("iDisplayStart")) ? _Tool.toInt(data.get("iDisplayStart")) : start;
			}
			if(data.has("iDisplayLength")){
				rows = _Tool.isInt(data.get("iDisplayLength")) ? _Tool.toInt(data.get("iDisplayLength")) : rows;
			}
			if(data.has("sSearch")){
				statName = data.get("sSearch").toString();
			}
		} catch (JSONException e) {
			log.info("" + e);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sEcho", sEcho);
		map.put("pageSize", rows);
		map.put("startRecord", start);
		map.put("statName", _Tool.toQuery(statName));
		return map;
	}
}
