package com.cn.iscp.service.locate.ince;

import com.cn.iscp.entity.locate.LocateTeacherBus;

public interface LocateTeacherBusSerice {
	
	/**
	 * 根据校车编号获取跟车老师信息
	 */
	LocateTeacherBus findByBus(Long busId);
	
}
