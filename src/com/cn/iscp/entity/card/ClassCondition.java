package com.cn.iscp.entity.card;

import com.cn.common._Tool;

/**
 * 班级情况对象
 * @author 10011037@qq.com
 * 2017-07-13
 */
public class ClassCondition {
	
	// 自增编号
    private Long condId;
	// 班主体动态年级编号
    private Long classNum;
	// 当天日期
    private String studyDate;
	// 班主任编号
    private Long teacherId;
	// 班长编号
    private Long monitorId;
	// 班级应到人数
    private Integer should;
	// 班级实到人数
    private Integer arrival;
	// 请假人数
    private Integer leave;
	// 迟到人数
    private Integer late;
	// 旷课人数
    private Integer truant;
    
	// 班主任姓名
    private String teacherName;
	// 班长姓名
    private String monitorName;
	// 当前学年度
    private Integer termId;
    
    
	public Long getCondId() {
		return condId;
	}
	public void setCondId(Long condId) {
		this.condId = condId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public String getStudyDate() {
		return studyDate;
	}
	public void setStudyDate(String studyDate) {
		this.studyDate = studyDate;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public Long getMonitorId() {
		return monitorId;
	}
	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}
	public Integer getShould() {
		return should;
	}
	public void setShould(Integer should) {
		this.should = should;
	}
	public Integer getArrival() {
		return arrival;
	}
	public void setArrival(Integer arrival) {
		this.arrival = arrival;
	}
	public Integer getLeave() {
		return leave;
	}
	public void setLeave(Integer leave) {
		this.leave = leave;
	}
	public Integer getLate() {
		return late;
	}
	public void setLate(Integer late) {
		this.late = late;
	}
	public Integer getTruant() {
		return truant;
	}
	public void setTruant(Integer truant) {
		this.truant = truant;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = _Tool.toStr(teacherName);
	}
	public String getMonitorName() {
		return monitorName;
	}
	public void setMonitorName(String monitorName) {
		this.monitorName = _Tool.toStr(monitorName);
	}
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
    
	
}
