package com.cn.iscp.dao.locate;

import com.cn.iscp.entity.locate.LocateTeacherBus;

public interface LocateTeacherBusDao {
	
	/**
	 * 根据校车编号获取跟车老师信息
	 */
	LocateTeacherBus findByBus(Long busId);
	
}
