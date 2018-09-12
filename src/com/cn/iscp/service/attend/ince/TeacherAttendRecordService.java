package com.cn.iscp.service.attend.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.TeacherAttendRecord;

public interface TeacherAttendRecordService {
	
	/**
	 * 每天自动生成考勤记录
	 */
	void handleRecord(Long groupId);
	
	/**
	 * 统计打卡记录状态
	 */
	void censusRecord(String attendDate);
	
	/**
	 * 根据日期获取打卡记录
	 */
	List<Map<String, Object>> findByDate(TeacherAttendRecord model);
	
	/**
	 * 获取打卡信息
	 */
	List<Map<String, Object>> findByScheduling(Long schedulingId);

	/**
	 * 新增考勤记录
	 */
	TeacherAttendRecord insertRecord(TeacherAttendRecord model);
	
}
