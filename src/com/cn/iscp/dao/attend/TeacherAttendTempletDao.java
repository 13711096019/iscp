package com.cn.iscp.dao.attend;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.TeacherAttendTemplet;

public interface TeacherAttendTempletDao {
	
	/**
	 * 根据老师编号获取考勤班次模板
	 */
	List<Map<String, Object>> findByUser(TeacherAttendTemplet model);

	/**
	 * 根据角色编号获取考勤班次模板
	 */
	TeacherAttendTemplet updateTemplet(TeacherAttendTemplet model);

	/**
	 * 根据周期修改考勤班次模板
	 */
	void updateByCycle(TeacherAttendTemplet model);
	
	/**
	 * PC-批量修改考勤班次模板
	 */
	boolean update(TeacherAttendTemplet model);
}
