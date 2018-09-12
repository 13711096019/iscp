package com.cn.iscp.entity.dbase;

import com.cn.common._Tool;

/**
 * 课程信息对象
 * @author 10011037@qq.com
 * 2017-07-11
 */
public class CourseTable {
	
	// 自增编号
	private Long courseId;
	// 星期几
	private Integer week;
	// 校历日
	private Integer day;
	// 上课日期
	private String studyDate;
	// 班主体编号（主标识）
	private Long classNum;
	// 年级主体编号（主标识）
	private Long gradeId;
	// 班别编号（含了对应的年级）
	private Long classId;
	// 节次编号（ID，排序一般1-9）
	private Long sessionId;
	// 科目编号
	private Long subjectId;
	// 老师编号
	private Long teacherId;
	// 状态
	private Integer status;
	// 备注
	private String note;
	
	// 星期几
	private String weekName;
	// 班级名称
	private String className;
	// 科目名称
	private String subjectName;
	// 科目名称列表
	private String subjectNames;
	
	public CourseTable(){};
	

	public CourseTable(Long classNum, String subjectNames){
		this.classNum = classNum;
		this.subjectNames = subjectNames;
	}
	
	
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getStudyDate() {
		return studyDate;
	}
	public void setStudyDate(String studyDate) {
		this.studyDate = _Tool.toStr(studyDate);
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getWeekName() {
		return weekName;
	}
	public void setWeekName(String weekName) {
		this.weekName = _Tool.toStr(weekName);
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = _Tool.toStr(subjectName);
	}
	public String getSubjectNames() {
		return subjectNames;
	}
	public void setSubjectNames(String subjectNames) {
		this.subjectNames = _Tool.toStr(subjectNames);
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
