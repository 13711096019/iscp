package com.cn.iscp.entity.attend;

import java.util.List;
import java.util.Map;

/**
 * 每日考勤人数统计表
 * @author 10011037@qq.com
 * 2018-08-17
 */
public class DailyStatistics {

	// 自增编号
    private Long statisticsId;
	// 考勤日期
    private String attendDate;
	// 时间段(1上午，2下午)
    private Integer timeType;
	// 全部考勤老师人数
    private Integer teacherOverallCount;
	// 休息老师人数
    private Integer teacherRecessCount;
	// 老师应到人数
    private Integer teacherApplicantCount;
	// 老师实到人数
    private Integer teacherAttendeesCount;
	// 老师缺勤人数
    private Integer teacherAbsenteesCount;
	// 老师请假人数
    private Integer teacherLeaveCount;
	// 全部学生人数
    private Integer studentOverallCount;
	// 学生应到人数
    private Integer studentApplicantCount;
	// 学生实到人数
    private Integer studentAttendeesCount;
	// 学生缺勤人数
    private Integer studentAbsenteesCount;
	// 学生请假人数
    private Integer studentLeaveCount;
    
	// 学生明细列表
    private List<Map<String,Object>> studentDetailList;
	// 老师明细列表
    private List<Map<String,Object>> teacherDetailList;
    
    
	public Long getStatisticsId() {
		return statisticsId;
	}
	public void setStatisticsId(Long statisticsId) {
		this.statisticsId = statisticsId;
	}
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
	}
	public Integer getTimeType() {
		return timeType;
	}
	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}
	public Integer getTeacherOverallCount() {
		return teacherOverallCount;
	}
	public void setTeacherOverallCount(Integer teacherOverallCount) {
		this.teacherOverallCount = teacherOverallCount;
	}
	public Integer getTeacherRecessCount() {
		return teacherRecessCount;
	}
	public void setTeacherRecessCount(Integer teacherRecessCount) {
		this.teacherRecessCount = teacherRecessCount;
	}
	public Integer getTeacherApplicantCount() {
		return teacherApplicantCount;
	}
	public void setTeacherApplicantCount(Integer teacherApplicantCount) {
		this.teacherApplicantCount = teacherApplicantCount;
	}
	public Integer getTeacherAttendeesCount() {
		return teacherAttendeesCount;
	}
	public void setTeacherAttendeesCount(Integer teacherAttendeesCount) {
		this.teacherAttendeesCount = teacherAttendeesCount;
	}
	public Integer getTeacherAbsenteesCount() {
		return teacherAbsenteesCount;
	}
	public void setTeacherAbsenteesCount(Integer teacherAbsenteesCount) {
		this.teacherAbsenteesCount = teacherAbsenteesCount;
	}
	public Integer getTeacherLeaveCount() {
		return teacherLeaveCount;
	}
	public void setTeacherLeaveCount(Integer teacherLeaveCount) {
		this.teacherLeaveCount = teacherLeaveCount;
	}
	public Integer getStudentOverallCount() {
		return studentOverallCount;
	}
	public void setStudentOverallCount(Integer studentOverallCount) {
		this.studentOverallCount = studentOverallCount;
	}
	public Integer getStudentApplicantCount() {
		return studentApplicantCount;
	}
	public void setStudentApplicantCount(Integer studentApplicantCount) {
		this.studentApplicantCount = studentApplicantCount;
	}
	public Integer getStudentAttendeesCount() {
		return studentAttendeesCount;
	}
	public void setStudentAttendeesCount(Integer studentAttendeesCount) {
		this.studentAttendeesCount = studentAttendeesCount;
	}
	public Integer getStudentAbsenteesCount() {
		return studentAbsenteesCount;
	}
	public void setStudentAbsenteesCount(Integer studentAbsenteesCount) {
		this.studentAbsenteesCount = studentAbsenteesCount;
	}
	public Integer getStudentLeaveCount() {
		return studentLeaveCount;
	}
	public void setStudentLeaveCount(Integer studentLeaveCount) {
		this.studentLeaveCount = studentLeaveCount;
	}
	public List<Map<String, Object>> getStudentDetailList() {
		return studentDetailList;
	}
	public void setStudentDetailList(List<Map<String, Object>> studentDetailList) {
		this.studentDetailList = studentDetailList;
	}
	public List<Map<String, Object>> getTeacherDetailList() {
		return teacherDetailList;
	}
	public void setTeacherDetailList(List<Map<String, Object>> teacherDetailList) {
		this.teacherDetailList = teacherDetailList;
	}
	
}
