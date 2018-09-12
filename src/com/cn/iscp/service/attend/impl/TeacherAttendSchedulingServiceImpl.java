package com.cn.iscp.service.attend.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Tool;
import com.cn.iscp.dao.attend.TeacherAttendGroupDao;
import com.cn.iscp.dao.attend.TeacherAttendSchedulingDao;
import com.cn.iscp.entity.attend.TeacherAttendScheduling;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.attend.ince.TeacherAttendSchedulingService;
import com.cn.unit.utils.DateUtil;

@Service("teacherAttendSchedulingService")
public class TeacherAttendSchedulingServiceImpl implements TeacherAttendSchedulingService {
	
	@Resource
	private TeacherAttendSchedulingDao teacherAttendSchedulingDao;
	@Resource
	private TeacherAttendGroupDao teacherAttendGroupDao;

	@Override
	public List<Map<String, Object>> findByRole(Long groupId, Long roleId, String startDate, String endDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleId", roleId);
		map.put("teacherName", _Tool.toQuery(""));
		List<Map<String, Object>> revertMap = teacherAttendGroupDao.findTeacher(map);
		
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("groupId", groupId);
		paraMap.put("startDate", startDate);
		paraMap.put("endDate", endDate);
		for (Map<String, Object> item : revertMap) {
			paraMap.put("userId", _Tool.toLong(item.get("teacherId")));
			item.put("shiftList", teacherAttendSchedulingDao.findByUser(paraMap));
		}
		return revertMap;
	}
	
	@Override
	public StateModel updateScheduling(TeacherAttendScheduling model) {
		return teacherAttendSchedulingDao.updateScheduling(model);
	}

	@Override
	public Map<String, Object> findByDate(TeacherAttendScheduling model) {
		Map<String, Object> revertMap = teacherAttendSchedulingDao.findByDate(model);
		int isNeedAttend = 1;
		if(revertMap == null){
			revertMap = new HashMap<String, Object>();
			isNeedAttend = 0;
		}
		revertMap.put("isNeedAttend", isNeedAttend);
		return revertMap;
	}

	@Override
	public void createScheduling(String startDate) {
		teacherAttendSchedulingDao.createScheduling(startDate);
	}
	
	@Override
	public void censusCountByDate(String attendDate) {
		attendDate = _Tool.isDate(attendDate) ? attendDate : DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD);
		teacherAttendSchedulingDao.censusCountByDate(attendDate);
	}

	@Override
	public List<Map<String, Object>> censusDateByMonth(TeacherAttendScheduling model) {
		return teacherAttendSchedulingDao.censusDateByMonth(model);
	}

	@Override
	public Map<String, Integer> censusCountByMonth(TeacherAttendScheduling model) {
		return teacherAttendSchedulingDao.censusCountByMonth(model);
	}
	
}
