package com.cn.iscp.dao.card;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.card.OndutyColumn;
import com.cn.iscp.entity.prepare.Topic;
import com.cn.iscp.entity.task.PlanContent;

public interface OndutyColumnDao {
	
	/**
	 * 终端-获取所有栏目信息
	 */
	List<OndutyColumn> findAll();
	
	/**
	 * PC-分页获取对象
	 */
    List<OndutyColumn> findPage(Map<String, Object> map);
    
    /**
	 * PC-获取分页总数
	 */
	Long getPageCount(Map<String, Object> map);

	/**
	 * PC-编辑
	 */
	boolean update(OndutyColumn model);
	
	/**
 	 * PC-根据编号获取对象
 	 */
	OndutyColumn findById(Long columnId);
}
