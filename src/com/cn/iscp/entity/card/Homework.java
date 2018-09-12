package com.cn.iscp.entity.card;

import com.cn.common._Tool;

/**
 * 班级作业对象
 * @author 10011037@qq.com
 * 2017-07-11
 */
public class Homework {
	
	// 自增编号
    private Long homeworkId;
	// 班主体动态年级编号
    private Long classNum;
	// 课程编号
    private Long subjectId;
	// 教师编号
    private Long teacherId;
	// 功课日期
    private String studyDate;
	// 功课描述
    private String homework;
	// 第几周
    private Integer week;
	// 星期几
    private Integer weekNum;
	// 已查看人数(家长)
    private Integer checkCount;
	// 已经查看的家长编号列表
    private String checkPatriarchIds;

	// 班级学生总人数
    private Integer totalCount;
	// 班级名称
    private String className;
	// 课程名称
    private String subjectName;
	// 用户Key
    private String userKey;
	// 教师名称
    private String teacherName;
	// 教师电话
    private String teacherMobile;
	// 教师头像
    private String headPortrait;
	// 家长编号
    private Long patriarchId;
    
    public Homework(){};
    
    public Homework(String studyDate, Long teacherId){
    	this.teacherId = teacherId;
    	this.studyDate = studyDate;
    }
    
    public Homework(Long homeworkId, Long patriarchId){
    	this.homeworkId = homeworkId;
    	this.patriarchId = patriarchId;
    }
    
    public Homework(Long classNum, String studyDate){
    	this.classNum = classNum;
    	this.studyDate = studyDate;
    }
    
    public Homework(Long classNum, Long subjectId, String studyDate){
    	this.classNum = classNum;
    	this.subjectId = subjectId;
    	this.studyDate = studyDate;
    }

    public Homework(Long homeworkId, Long classNum, Long subjectId, String homework){
    	this.homeworkId = homeworkId;
    	this.classNum = classNum;
    	this.subjectId = subjectId;
    	this.homework = homework;
    }
    
    
	public Long getHomeworkId() {
		return homeworkId;
	}
	public void setHomeworkId(Long homeworkId) {
		this.homeworkId = homeworkId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getStudyDate() {
		return studyDate;
	}
	public void setStudyDate(String studyDate) {
		this.studyDate = _Tool.toStr(studyDate);
	}
	public String getHomework() {
		return homework;
	}
	public void setHomework(String homework) {
		this.homework = _Tool.toStr(homework);
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = _Tool.toStr(subjectName);
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = _Tool.toStr(teacherName);
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = _Tool.toStr(headPortrait);
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Integer getWeekNum() {
		return weekNum;
	}
	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
	}
	public Integer getCheckCount() {
		return checkCount;
	}
	public void setCheckCount(Integer checkCount) {
		this.checkCount = checkCount;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCheckPatriarchIds() {
		return checkPatriarchIds;
	}
	public void setCheckPatriarchIds(String checkPatriarchIds) {
		this.checkPatriarchIds = checkPatriarchIds;
	}
	public Long getPatriarchId() {
		return patriarchId;
	}
	public void setPatriarchId(Long patriarchId) {
		this.patriarchId = patriarchId;
	}
	public String getTeacherMobile() {
		return teacherMobile;
	}
	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
    
}
