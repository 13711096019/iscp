package com.cn.iscp.service.attend.ince;

import java.util.List;

import com.cn.iscp.entity.attend.TeacherAttendWifi;
import com.cn.iscp.model.StateModel;

public interface TeacherAttendWifiService {

	/**
	 * 根据考勤组获取考勤wifi
	 */
	List<TeacherAttendWifi> findByGroup(Long groupId);
	
	/**
	 * 新增wifi考勤
	 */
	TeacherAttendWifi insertWifi(TeacherAttendWifi model);
	
	/**
	 * 批量新增考勤wifi
	 */
	Integer insertWifis(Long groupId, String wifiJson);
	
	/**
	 * 编辑wifi考勤
	 */
	TeacherAttendWifi updateWifi(TeacherAttendWifi model);
	
	/**
	 * 批量编辑考勤wifi
	 */
	Integer updateWifis(Long groupId, String wifiJson);
	
	/**
	 * 删除wifi考勤
	 */
	StateModel deleteWifi(Long wifiId);

	/**
	 * 根据考勤组删除考勤wifi
	 */
	void deleteByGroup(Long groupId);
	
}
