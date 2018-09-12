package com.cn.iscp.dao.locate;

import java.util.List;

import com.cn.iscp.entity.locate.LocateStudentSite;

public interface LocateStudentSiteDao {
	
	/**
	 * 根据校车编号获取学生信息 
	 */
	List<LocateStudentSite> findByBus(Long busId);
	
}
