package com.cn.iscp.service.push.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.push.Praise;
import com.cn.iscp.entity.push.PraiseRule;

public interface PraiseService {
	
	/**
	 * PC-获取全部有效表扬列表
	 */
	List<Praise> findByValid();
	
	/**
	 * PC-获取无效表扬列表
	 */
	List<Praise> findByInvalid(Map<String, Object> map);
	
	/**
	 * PC-根据编号获取对象
	 */
	Praise findById(Long praiseId);
	
	/**
	 * 推送-修改过期表扬状态
	 */
	boolean updInvalidPraise();
	
	/**
	 * 终端-根据班级获取表扬列表
	 */
	PraiseRule findByClass(Long classNum);
	
	/**
	 * PC-新增表扬
	 */
	Praise insertPraise(Praise model);

	/**
	 * PC-编辑表扬
	 */
	boolean updatePraise(Praise model);
	
}
