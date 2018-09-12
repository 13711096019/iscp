package com.cn.iscp.dao.locate;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.locate.LocateBusSite;

public interface LocateBusSiteDao {

	/**
	 * 根据编号获取站点信息
	 */
	LocateBusSite findById(Long siteId);

	/**
	 * 根据校车获取站点信息
	 */
	List<LocateBusSite> findByBus(Long busId);

	/**
	 * PC-分页获取列表数据
	 */
	List<LocateBusSite> findPage(Map<String, Object> map);

	/**
	 * PC-获取分页总数
	 */
	Long getPageCount(Map<String, Object> map);

	/**
	 * PC-获取分页总数
	 */
	boolean update(LocateBusSite model);

	/**
	 * PC-获取分页总数
	 */
	boolean insert(LocateBusSite model);

	/**
	 * PC-获取最后的分布顺序
	 */
	LocateBusSite findFinal();
}
