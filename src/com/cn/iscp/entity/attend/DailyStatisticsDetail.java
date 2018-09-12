package com.cn.iscp.entity.attend;

/**
 * 出勤报表明细表
 * @author 10011037@qq.com
 * 2018-08-22
 */
public class DailyStatisticsDetail {
	
	// 自增编号
    private Long detailId;
	// 用户编号
    private Long userId;
	// 考勤日期
    private String attendDate;
	// 时间段(1上午，2下午)
    private Integer timeType;
	// 是否休息
    private Integer isRecess;
	// 是否应到
    private Integer isApplicant;
	// 是否实到
    private Integer isAttendees;
	// 是否缺勤
    private Integer isAbsentees;
	// 是否请假
    private Integer isLeave;
    
	// 用户姓名
    private String userName;
	// 用户类型
    private Integer userType;
    
    public DailyStatisticsDetail(){};
    
    public DailyStatisticsDetail(String attendDate, Integer timeType){
    	this.attendDate = attendDate;
    	this.timeType = timeType;
    }
    
	public Long getDetailId() {
		return detailId;
	}
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public Integer getIsRecess() {
		return isRecess;
	}
	public void setIsRecess(Integer isRecess) {
		this.isRecess = isRecess;
	}
	public Integer getIsApplicant() {
		return isApplicant;
	}
	public void setIsApplicant(Integer isApplicant) {
		this.isApplicant = isApplicant;
	}
	public Integer getIsAttendees() {
		return isAttendees;
	}
	public void setIsAttendees(Integer isAttendees) {
		this.isAttendees = isAttendees;
	}
	public Integer getIsAbsentees() {
		return isAbsentees;
	}
	public void setIsAbsentees(Integer isAbsentees) {
		this.isAbsentees = isAbsentees;
	}
	public Integer getIsLeave() {
		return isLeave;
	}
	public void setIsLeave(Integer isLeave) {
		this.isLeave = isLeave;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
    
    
}
