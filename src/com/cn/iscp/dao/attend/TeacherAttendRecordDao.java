package com.cn.iscp.dao.attend;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.TeacherAttendRecord;

public interface TeacherAttendRecordDao {
	
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
	 * 根据排班编号获取打卡记录
	 */
	List<Map<String, Object>> findByScheduling(Long schedulingId);

	/**
	 * 新增考勤记录
	 */
	TeacherAttendRecord insertRecord(TeacherAttendRecord model);
	
}
