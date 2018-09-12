package com.cn.iscp.service.attend.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.TeacherAttendTemplet;

public interface TeacherAttendTempletService {

	/**
	 * 获取考勤班次模板
	 */
	public List<Map<String, Object>> findByRole(Long groupId, Long roleId, String teacherName);

	/**
	 * 根据角色编号获取考勤班次模板
	 */
	TeacherAttendTemplet updateTemplet(TeacherAttendTemplet model);

	/**
	 * 根据周期修改考勤班次模板
	 */
	void updateByCycle(TeacherAttendTemplet model);

	/**
	 * 批量修改考勤班次模板
	 */
	public void updateTemplets(Long groupId, String shiftJson, Integer isUpdScheduling);
	
	/**
	 * PC-批量修改考勤班次模板
	 */
	boolean update(TeacherAttendTemplet model);
}
