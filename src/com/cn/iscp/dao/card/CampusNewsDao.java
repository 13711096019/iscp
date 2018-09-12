package com.cn.iscp.dao.card;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.card.CampusNews;

public interface CampusNewsDao {
    
	List<CampusNews> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	CampusNews findById(Map<String, Object> map);
	
	boolean insert(CampusNews model);
	
	boolean update(CampusNews model);
	
	/**
	 * 终端-根据类别获取最近6条信息
	 */
	List<CampusNews> findNewsBySix(Integer newsMold);
	
	/**
	 * 终端-根据类别获取最近8条信息
	 */
	List<CampusNews> findNewsByEight(Integer newsMold);
	
	/**
	 * 终端-根据类别获取最近信息
	 */
	List<CampusNews> findNewsByAll(Integer newsMold);
	
	/**
	 * 终端-根据类别获取信息
	 */
	List<CampusNews> findNewsByMold(Integer newsMold);
	
	
}
