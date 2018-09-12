package com.cn.iscp.entity.dbase;

import com.cn.common._Tool;

/**
 * 教员科目关系
 * @author 10011037@qq.com
 * 2017-07-31
 */
public class TeacherSubject {

	// 自增编号
	private Long tsId;
	// 动态班级编号
	private Long classNum;
	// 教员编号
	private Long teacherId;
	// 课程编号
	private Long subjectId;
	// 创建时间
	private String createDate;
	// 状态
	private Integer status;

	// 班级名称
	private String className;
	// 教员姓名
	private String teacherName;
	// 教员电话
	private String teacherMobile;
	// 科目名称
	private String subjectName;
	// 年级编号
	private Long gradeId;
	// 年级名称
	private String gradeName;
	
	
	public TeacherSubject(){};
	
	public TeacherSubject(Long gradeId, Long classNum, Long teacherId, Long subjectId){
		this.gradeId = gradeId;
		this.classNum = classNum;
		this.teacherId = teacherId;
		this.subjectId = subjectId;
	}
	
	public TeacherSubject(Long teacherId){
		this.teacherId = teacherId;
	}
	
	
	public Long getTsId() {
		return tsId;
	}
	public void setTsId(Long tsId) {
		this.tsId = tsId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = _Tool.toStr(createDate);
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = _Tool.toStr(className);
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = _Tool.toStr(teacherName);
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = _Tool.toStr(subjectName);
	}
	public String getTeacherMobile() {
		return teacherMobile;
	}
	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = _Tool.toStr(teacherMobile);
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
}
