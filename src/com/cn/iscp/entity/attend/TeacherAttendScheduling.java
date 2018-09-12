package com.cn.iscp.entity.attend;

/**
 * 人员排班
 * @author 10011037@qq.com
 * 2018-07-10
 */
public class TeacherAttendScheduling {

	// 自增编号
    private Long schedulingId;
	// 人员编号
    private Long userId;
	// 考勤组编号
    private Long groupId;
	// 考勤班次编号
    private Long shiftId;
	// 星期（1星期一.....7星期日）
    private Integer weekNum;
	// 打卡日期
    private String attendDate;
	// 旷工次数（1旷工，0没旷工）
    private Integer isAbsenteeism;
	// 正常次数
    private Integer normalCount;
	// 迟到次数
    private Integer lateCount;
	// 早退次数
    private Integer leaveEarlyCount;
	// 缺卡次数
    private Integer absentCount;
	// 外勤次数
    private Integer outdoorCount;
	// 状态(0删除,1正常)
    protected Integer status;
    
	// 考勤班次名称
    private String shiftName;
    
    public TeacherAttendScheduling(){};
    
    public TeacherAttendScheduling(Long userId, Long groupId, String attendDate){
    	this.userId = userId;
    	this.groupId = groupId;
    	this.attendDate = attendDate;
    }
    
    public TeacherAttendScheduling(Long userId, Long groupId,Long shiftId, String attendDate){
    	this.userId = userId;
    	this.groupId = groupId;
    	this.shiftId = shiftId;
    	this.attendDate = attendDate;
    }
    
	public Long getSchedulingId() {
		return schedulingId;
	}
	public void setSchedulingId(Long schedulingId) {
		this.schedulingId = schedulingId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getShiftId() {
		return shiftId;
	}
	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}
	public Integer getWeekNum() {
		return weekNum;
	}
	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
	}
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
	}
	public Integer getNormalCount() {
		return normalCount;
	}
	public void setNormalCount(Integer normalCount) {
		this.normalCount = normalCount;
	}
	public Integer getLateCount() {
		return lateCount;
	}
	public void setLateCount(Integer lateCount) {
		this.lateCount = lateCount;
	}
	public Integer getLeaveEarlyCount() {
		return leaveEarlyCount;
	}
	public void setLeaveEarlyCount(Integer leaveEarlyCount) {
		this.leaveEarlyCount = leaveEarlyCount;
	}
	public Integer getAbsentCount() {
		return absentCount;
	}
	public void setAbsentCount(Integer absentCount) {
		this.absentCount = absentCount;
	}
	public Integer getIsAbsenteeism() {
		return isAbsenteeism;
	}
	public void setIsAbsenteeism(Integer isAbsenteeism) {
		this.isAbsenteeism = isAbsenteeism;
	}
	public Integer getOutdoorCount() {
		return outdoorCount;
	}
	public void setOutdoorCount(Integer outdoorCount) {
		this.outdoorCount = outdoorCount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getShiftName() {
		return shiftName;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
    
}
