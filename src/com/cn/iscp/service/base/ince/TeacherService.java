package com.cn.iscp.service.base.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Teacher;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;

public interface TeacherService {
	
	/*List<Teacher> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);*/
	
	PageModel findPage(Map<String, Object> map);
    
	Teacher findById(Long teacherId);
	//获取所有老师的列表
	List<Teacher> findBytotal();
	
	List<Teacher> findBySubject(Long subjectId);
	
	Teacher addTeacher(Teacher model);
	
	Teacher editTeacher(Teacher model);
	
	boolean delTeacher(Long teacherId);
	
	boolean updateFlagtime(Teacher model);
	
	boolean updateHeadPortrait(Teacher model);

	void handleTeacherSubject(Teacher model);
	
	List<Teacher> login(String account, String password);
	
	StateModel mt_login(String account, String password);
	
	Teacher pc_login(String account, String password);
	
	List<Teacher> findPhoneBook(Long roleId);
	
	Teacher findNameByIds(String userIds);

	
}
