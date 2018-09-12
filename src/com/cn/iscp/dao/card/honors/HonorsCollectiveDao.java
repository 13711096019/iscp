package com.cn.iscp.dao.card.honors;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.card.honors.HonorsCollective;
import com.cn.iscp.model.StateModel;

public interface HonorsCollectiveDao {

	/**
	 * PC-分页获取集体荣誉信息
	 */
	List<List<?>> findPage(Map<String, Object> map);
	
	/**
	 * 根据编号获取集体荣誉对象
	 */
	HonorsCollective findById(Long collectiveId);
	
	/**
	 * 终端-获取最新集体荣誉列表
	 */
	List<HonorsCollective> findByFresh(Integer dataCount);
	
	/**
	 * 新增集体荣誉
	 */
	HonorsCollective insertHonors(HonorsCollective model);
	
	/**
	 * 编辑集体荣誉
	 */
	HonorsCollective updateHonors(HonorsCollective model);
	
	/**
	 * 删除集体荣誉
	 */
	StateModel deleteHonors(Long collectiveId);
	
}
