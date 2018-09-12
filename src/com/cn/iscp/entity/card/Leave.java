package com.cn.iscp.entity.card;

import com.cn.common._Tool;

/**
 * 学生请假信息对象
 * @author 10011037@qq.com
 * 2017-08-19
 */
public class Leave {
	
	// 自增编号
    private Long leaveId;
	// 动态班级编号
    private Long classNum;
	// 学生编号
    private Long studentId;
	// 请假时段[Const.LEAVE_PERIOD]
    private Integer periodId;
	// 录入日期
    private String leaveDate;
	// 请假开始日期
    private String leaveStartDate;
	// 请假截止日期
    private String leaveEndDate;
	// 创建时间
    private String createTime;
	// 请假天数(半天算0)
    private Integer leaveDayCount;
	// 请假小时数
    private Integer leaveHourCount;
	// 请假原因
    private String leaveReason;

	// 学生姓名
    private String studentName;
	// 学生头像
    private String headPortrait;
	// 请假时段名称
    private String itemFileName;
    
    public Leave(){};
    
    public Leave(Long studentId){
    	this.studentId = studentId;
    }
    
    public Leave(Long classNum, String leaveDate){
    	this.classNum = classNum;
    	this.leaveDate = leaveDate;
    }
    
    public Leave(Long classNum, Long studentId, Integer periodId, String leaveStartDate,
    		String leaveEndDate, Integer leaveDayCount, String leaveReason){
    	this.classNum = classNum;
    	this.studentId = studentId;
    	this.periodId = periodId;
    	this.leaveStartDate = leaveStartDate;
    	this.leaveEndDate = leaveEndDate;
    	this.leaveDayCount = leaveDayCount;
    	this.leaveReason = leaveReason;
    }
    
    
	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Integer getPeriodId() {
		return periodId;
	}
	public void setPeriodId(Integer periodId) {
		this.periodId = periodId;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = _Tool.toStr(leaveDate);
	}
	public Integer getLeaveHourCount() {
		return leaveHourCount;
	}
	public void setLeaveHourCount(Integer leaveHourCount) {
		this.leaveHourCount = leaveHourCount;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = _Tool.toStr(leaveReason);
	}
	public Integer getLeaveDayCount() {
		return leaveDayCount;
	}
	public void setLeaveDayCount(Integer leaveDayCount) {
		this.leaveDayCount = leaveDayCount;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = _Tool.toStr(studentName);
	}
	public String getItemFileName() {
		return itemFileName;
	}
	public void setItemFileName(String itemFileName) {
		this.itemFileName = _Tool.toStr(itemFileName);
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = _Tool.toStr(headPortrait);
	}
	public String getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(String leaveStartDate) {
		this.leaveStartDate = _Tool.toStr(leaveStartDate);
	}
	public String getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(String leaveEndDate) {
		this.leaveEndDate = _Tool.toStr(leaveEndDate);
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = _Tool.toStr(createTime);
	}
	
}
