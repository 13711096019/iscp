package com.cn.iscp.dao.card;

import java.util.List;

import com.cn.iscp.entity.card.Onduty;

public interface OndutyDao {

	/**
	 * 终端-根据动态班级编号获取一周值日列表
	 */
	List<Onduty> findOndutyByWeek(Long classNum);

	/**
	 * PC-更新
	 */
	boolean update(Onduty model);
}
