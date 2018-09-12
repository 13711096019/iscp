package com.cn.iscp.service.locate.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.locate.LocateBus;

public interface LocateBusSerice {

	/**
	 * 根据编号获取校车信息
	 */
	LocateBus findById(Long busId);

	/**
	 * 获取所有校车信息
	 */
	List<LocateBus> findAll();

	/**
	 * PC-分页获取列表数据
	 */
	List<LocateBus> findPage(Map<String, Object> map);

	/**
	 * PC-获取分页总数
	 */
	Long getPageCount(Map<String, Object> map);

	/**
	 * PC-获取分页总数
	 */
	boolean update(LocateBus model);

	/**
	 * PC-获取分页总数
	 */
	boolean insert(LocateBus model);

	/**
	 * PC-获取最后的分布顺序
	 */
	LocateBus findFinal();
}
