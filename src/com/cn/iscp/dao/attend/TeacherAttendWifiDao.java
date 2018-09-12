package com.cn.iscp.dao.attend;

import java.util.List;

import com.cn.iscp.entity.attend.TeacherAttendWifi;

public interface TeacherAttendWifiDao {

	/**
	 * 根据考勤组获取考勤wifi
	 */
	List<TeacherAttendWifi> findByGroup(Long groupId);
	
	/**
	 * 新增考勤wifi
	 */
	TeacherAttendWifi insertWifi(TeacherAttendWifi model);
	
	/**
	 * 编辑考勤wifi
	 */
	TeacherAttendWifi updateWifi(TeacherAttendWifi model);
	
	/**
	 * 删除考勤wifi
	 */
	TeacherAttendWifi deleteWifi(Long wifiId);

	/**
	 * 根据考勤组删除考勤wifi
	 */
	void deleteByGroup(Long groupId);
	
}
