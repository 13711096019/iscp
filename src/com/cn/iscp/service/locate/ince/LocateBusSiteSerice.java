package com.cn.iscp.service.locate.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.locate.LocateBus;
import com.cn.iscp.entity.locate.LocateBusSite;

public interface LocateBusSiteSerice {

	/**
	 * 根据编号获取站点信息
	 */
	LocateBusSite findById(Long siteId);

	/**
	 * 获取所有站点信息
	 */
	List<LocateBus> findAll();

	/**
	 * PC-分页获取列表数据
	 */
	List<LocateBusSite> findPage(Map<String, Object> map);

	/**
	 * PC-获取分页总数
	 */
	Long getPageCount(Map<String, Object> map);

	/**
	 * PC-更新
	 */
	boolean update(LocateBusSite model);

	/**
	 * PC-新增
	 */
	boolean insert(LocateBusSite model);

	/**
	 * PC-获取最后的分布顺序
	 */
	LocateBusSite findFinal();
}
