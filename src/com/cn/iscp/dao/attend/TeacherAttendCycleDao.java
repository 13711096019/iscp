package com.cn.iscp.dao.attend;

import java.util.List;

import com.cn.iscp.entity.attend.TeacherAttendCycle;

public interface TeacherAttendCycleDao {

	/**
	 * 根据考勤组获取周期排班模板
	 */
	List<TeacherAttendCycle> findByGroup(Long groupId);

	/**
	 * 自动生成模板和排班
	 */
	void isFirstCycle(Long groupId);
	
	/**
	 * 新增周期排班模板
	 */
	TeacherAttendCycle insertCycle(TeacherAttendCycle model);
	
	/**
	 * 编辑周期排班模板
	 */
	TeacherAttendCycle updateCycle(TeacherAttendCycle model);
	
	/**
	 * 删除周期排班模板
	 */
	TeacherAttendCycle deleteCycle(Long cycleId);
	
	/**
	 * PC根据编号获取周期排班模板
	 */
	TeacherAttendCycle findById(Long cycleId);

}
