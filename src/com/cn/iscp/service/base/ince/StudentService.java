package com.cn.iscp.service.base.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Student;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;

public interface StudentService {
    
	/*List<Student> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);*/
	
	/**
	 * PC-绑定家长手机号
	 */
	void handleBindPhone(Student model);
	
	/**
	 * PC-批量绑定学生学号
	 */
	void handleStudentNum(Student model);
	
	PageModel findPage(Map<String, Object> map);
	
	Student findById(Long studentId);
	
	List<Student> findByClass(Long classNum);
	
	String getStudentNamesByClass(Long classNum);
	
	List<Student> findByHasCard(Long classEntityId);
	
	Student findFinal();
	
	boolean update(Student model);
	
	Student addStudent(Student model);
	
	Student insertStudent(Map<String, Object> map);
	
	boolean delStudent(Long studentId);
	
	StateModel login(String account, String password);
	
	void changeClass(Map<String, Object> map);
	
	void emptyStudentByClassNum(Long classNum);
	
	/**
	 * 根据家长编号获取学生信息
	 */
	List<Student> findByPatriarch(String mobile);
	
	/**
	 * 根据姓名和身份证匹配学生
	 */
	List<Student> findByNameAndCard(Student model);
	
	/**
	 * 修改学生详细信息
	 */
	void updateStudentInfo(Map<String, Object> map);

	/**
	 * 缴费-分页获取学生列表
	 */
	PageModel findPageByPay(Map<String, Object> map);

	/**
	 * PC-批量绑定学生入学日期
	 */
	void handleAdmissionDate(String studentIds);
	
	/**
	 * PC-导出缴费学生信息
	 */
	List<Student> findExcelByPay(int gradeId,int classNum,int hasAdmissionDate,int isNewborn );
}