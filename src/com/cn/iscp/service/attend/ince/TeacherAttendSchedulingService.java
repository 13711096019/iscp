package com.cn.iscp.service.attend.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.TeacherAttendScheduling;
import com.cn.iscp.model.StateModel;

public interface TeacherAttendSchedulingService {
	
	/**
	 * 获取排班信息列表
	 */
	List<Map<String, Object>> findByRole(Long groupId, Long roleId, String startDate, String endDate);
	
	/**
	 * 修改考勤排班
	 */
	StateModel updateScheduling(TeacherAttendScheduling model);
	
	/**
	 * 根据日期获取排班信息
	 */
	Map<String, Object> findByDate(TeacherAttendScheduling model);
	
	/**
	 * 生成考勤排班
	 */
	void createScheduling(String startDate);
	
	/**
	 * 统计人员排班表信息
	 */
	void censusCountByDate(String attendDate);
	
	/**
	 * 获取各考勤状态下的日期
	 */
	List<Map<String, Object>> censusDateByMonth(TeacherAttendScheduling model);
	
	/**
	 * 根据月份统计报表
	 */
	Map<String, Integer> censusCountByMonth(TeacherAttendScheduling model);
	
}
