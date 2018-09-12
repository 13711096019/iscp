package com.cn.iscp.service.locate.ince;

import java.util.List;

import com.cn.iscp.entity.locate.LocateStudentSite;

public interface LocateStudentSiteSerice {
	
	/**
	 * 根据校车编号获取学生信息 
	 */
	List<LocateStudentSite> findByBus(Long busId);
	
}
