package com.cn.iscp.service.attend.ince;

import java.util.List;

import com.cn.iscp.entity.attend.TeacherAttendSite;
import com.cn.iscp.model.StateModel;

public interface TeacherAttendSiteService {

	/**
	 * 根据考勤组获取考勤地点
	 */
	List<TeacherAttendSite> findByGroup(Long groupId);
	
	/**
	 * 新增考勤地点
	 */
	TeacherAttendSite insertSite(TeacherAttendSite model);
	
	/**
	 * 批量新增考勤地点
	 */
	Integer insertSites(Long groupId, String siteJson);
	
	/**
	 * 批量编辑考勤地点
	 */
	Integer updateSites(Long groupId, String siteJson);
	
	/**
	 * 编辑考勤地点
	 */
	TeacherAttendSite updateSite(TeacherAttendSite model);
	
	/**
	 * 删除考勤地点
	 */
	StateModel deleteSite(Long SiteId);

	/**
	 * 根据考勤组删除考勤地点
	 */
	void deleteByGroup(Long groupId);

}
