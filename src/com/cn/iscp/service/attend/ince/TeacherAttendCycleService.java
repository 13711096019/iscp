package com.cn.iscp.service.attend.ince;

import java.util.List;

import com.cn.iscp.entity.attend.TeacherAttendCycle;
import com.cn.iscp.model.StateModel;

public interface TeacherAttendCycleService {

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
	StateModel deleteCycle(Long cycleId);
	
	/**
	 * PC根据编号获取周期排班模板
	 */
	TeacherAttendCycle findById(Long cycleId);

}
