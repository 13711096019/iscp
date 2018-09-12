package com.cn.iscp.service.attend.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Tool;
import com.cn.iscp.dao.attend.TeacherAttendGroupDao;
import com.cn.iscp.dao.attend.TeacherAttendTempletDao;
import com.cn.iscp.entity.attend.TeacherAttendTemplet;
import com.cn.iscp.service.attend.ince.TeacherAttendTempletService;
import com.cn.unit.executor.attend.ExecutorUpdTemplet;

@Service("teacherAttendTempletService")
public class TeacherAttendTempletServiceImpl implements TeacherAttendTempletService {
	
	@Resource
	private TeacherAttendTempletDao teacherAttendTempletDao;
	@Resource
	private TeacherAttendGroupDao teacherAttendGroupDao;
	
	@Override
	public List<Map<String, Object>> findByRole(Long groupId, Long roleId, String teacherName){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleId", roleId);
		map.put("teacherName", _Tool.toQuery(teacherName));
		List<Map<String, Object>> revertMap = teacherAttendGroupDao.findTeacher(map);
		
		TeacherAttendTemplet templet = new TeacherAttendTemplet();
		templet.setGroupId(groupId);
		for (Map<String, Object> item : revertMap) {
			templet.setUserId(_Tool.toLong(item.get("teacherId")));
			item.put("shiftList", teacherAttendTempletDao.findByUser(templet));
		}
		return revertMap;
	}
	
	@Override
	public TeacherAttendTemplet updateTemplet(TeacherAttendTemplet model) {
		return teacherAttendTempletDao.updateTemplet(model);
	}

	@Override
	public void updateByCycle(TeacherAttendTemplet model) {
		teacherAttendTempletDao.updateByCycle(model);
	}

	@Override
	public void updateTemplets(Long groupId, String shiftJson, Integer isUpdScheduling) {
		// 批量修改考勤班次模板线程池
		ExecutorUpdTemplet executor = new ExecutorUpdTemplet(groupId, shiftJson, isUpdScheduling);
		try {
			executor.asynTask();
		} catch (InterruptedException e) {
			System.out.println("批量修改考勤班次模板线程池发生异常");
		}
	}

	@Override
	public boolean update(TeacherAttendTemplet model) {
		return teacherAttendTempletDao.update(model);
	}
	
}
