package com.cn.iscp.dao.attend;

import java.util.List;

import com.cn.iscp.entity.attend.TeacherAttendSite;

public interface TeacherAttendSiteDao {

	/**
	 * 根据考勤组获取考勤地点
	 */
	List<TeacherAttendSite> findByGroup(Long groupId);
	
	/**
	 * 新增考勤地点
	 */
	TeacherAttendSite insertSite(TeacherAttendSite model);
	
	/**
	 * 编辑考勤地点
	 */
	TeacherAttendSite updateSite(TeacherAttendSite model);
	
	/**
	 * 删除考勤地点
	 */
	TeacherAttendSite deleteSite(Long siteId);

	/**
	 * 根据考勤组删除考勤地点
	 */
	void deleteByGroup(Long groupId);
	
}
