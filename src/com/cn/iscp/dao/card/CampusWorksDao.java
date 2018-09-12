package com.cn.iscp.dao.card;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.card.CampusWorks;

public interface CampusWorksDao {
	
	/**
	 * 终端-获取风采作品列表 
	 */
	List<CampusWorks> findCampusWorks(Map<String, Object> map);
	
	/**
	 * 后台-操作界面部分
	 */
    List<CampusWorks> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	//有效作品
	List<CampusWorks> findByValid(Map<String, Object> map);
	
	CampusWorks findById(Long worksId);
	
	boolean insert(CampusWorks model);
	
	boolean update(CampusWorks model);
}
