package com.cn.iscp.service.attend.ince;

import java.util.List;

import com.cn.iscp.entity.attend.TeacherAttendAxis;

public interface TeacherAttendAxisService {
	
	List<TeacherAttendAxis> findByShift(Long shiftId);
	
}
