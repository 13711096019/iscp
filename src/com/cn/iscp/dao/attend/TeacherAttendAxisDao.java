package com.cn.iscp.dao.attend;

import java.util.List;

import com.cn.iscp.entity.attend.TeacherAttendAxis;

public interface TeacherAttendAxisDao {
	
	List<TeacherAttendAxis> findByShift(Long shiftId);
	
}
