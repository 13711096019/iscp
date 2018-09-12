package com.cn.iscp.model;

import com.cn.common._Tool;

/**
 * 课堂信息
 * @author 10011037@qq.com
 * 2017-08-01
 */
public class Classroom {
	
	// 课程名称
	private String subjectName;
	// 教师姓名
	private String teacherName;
	// 教师头像
	private String headPortrait;
	// 开始时间
	private String startTime;
	// 结束时间
	private String endTime;
	// 上课特色
	private String teacherDesc;
	// 教师标签
	private String teacherLabel;
	// 节次名称
	private String sessionName;
	// 职称
    private String vocation;
	// 教学特色
    private String feature;
	// 工作经历
    private String undergo;
	// 教育理念
    private String idea;
	
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = _Tool.toStr(startTime);
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = _Tool.toStr(endTime);
	}
	public String getTeacherDesc() {
		return teacherDesc;
	}
	public void setTeacherDesc(String teacherDesc) {
		this.teacherDesc = _Tool.toStr(teacherDesc);
	}
	public String getTeacherLabel() {
		return teacherLabel;
	}
	public void setTeacherLabel(String teacherLabel) {
		this.teacherLabel = _Tool.toStr(teacherLabel);
	}
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = _Tool.toStr(sessionName);
	}
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getUndergo() {
		return undergo;
	}
	public void setUndergo(String undergo) {
		this.undergo = undergo;
	}
	public String getIdea() {
		return idea;
	}
	public void setIdea(String idea) {
		this.idea = idea;
	}
	
	
}
