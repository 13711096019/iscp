package com.cn.iscp.entity.attend;

/**
 * 打卡时间轴
 * @author 10011037@qq.com
 * 2018-07-10
 */
public class TeacherAttendAxis {
	
	// 自增编号
    private Long axisId;
	// 考勤组编号
    private Long groupId;
	// 考勤班次编号
    private Long shiftId;
	// 打卡类型（1上班，2下班）
    private Integer axisType;
	// 标准时间
    private String normalTime;
	// 时段（上班最早打卡分钟数，下班最晚打卡分钟数）
    private Integer timeInterval;
	// 排序
    private Integer sort;
	// 状态(0删除,1正常)
    protected Integer status;
    
    
	public Long getAxisId() {
		return axisId;
	}
	public void setAxisId(Long axisId) {
		this.axisId = axisId;
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
	public Integer getAxisType() {
		return axisType;
	}
	public void setAxisType(Integer axisType) {
		this.axisType = axisType;
	}
	public String getNormalTime() {
		return normalTime;
	}
	public void setNormalTime(String normalTime) {
		this.normalTime = normalTime;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(Integer timeInterval) {
		this.timeInterval = timeInterval;
	}
	
    
}
