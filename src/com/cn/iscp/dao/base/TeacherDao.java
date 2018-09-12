package com.cn.iscp.dao.base;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Teacher;

public interface TeacherDao {
	
	/*List<Teacher> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);*/
	
	List<List<?>> findPage(Map<String, Object> map);
    
	Teacher findById(Long teacherId);
	
	//获取所有老师的列表
	List<Teacher> findBytotal();
	
	List<Teacher> findBySubject(Long subjectId);
	
	Teacher addTeacher(Teacher model);
	
	Teacher editTeacher(Teacher model);
	
	Integer delTeacher(Long teacherId);
	
	boolean updateFlagtime(Teacher model);
	
	boolean updateHeadPortrait(Teacher model);
	
	void handleTeacherSubject(Teacher model);
	
	List<Teacher> login(Map<String, Object> map);
	
	List<Teacher> findPhoneBook(Long roleId);
	
	Teacher findNameByIds(String userIds);
	
}