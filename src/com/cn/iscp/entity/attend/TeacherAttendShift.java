package com.cn.iscp.entity.attend;

import java.util.List;

/**
 * 考勤班次表
 * @author 10011037@qq.com
 * 2018-07-10
 */
public class TeacherAttendShift {
	
	// 自增编号
    private Long shiftId;
	// 考勤组编号
    private Long groupId;
	// 班次名称
    private String shiftName;
	// 类型（0:休息，1:1天1次上下班，2:1天2次上下班，3:1天3次上下班）
    private Integer shiftType;
	// 超过N分钟视为严重迟到（-1为关闭）
    private Integer severeLateness;
	// 超过N分钟视为旷工（-1为关闭）
    private Integer absent;
	// 状态(0删除,1正常)
    protected Integer status;
    
	// 上下班时间轴Json列表
    private String axisJson;
    // 打卡时间轴列表
    private List<TeacherAttendAxis> axisList;
    
    public TeacherAttendShift(){};
    
    public TeacherAttendShift(Long shiftId, Long groupId, String shiftName, 
    		Integer shiftType, Integer severeLateness, Integer absent, String axisJson){
    	this.shiftId = shiftId;
    	this.groupId = groupId;
    	this.shiftName = shiftName;
    	this.shiftType = shiftType;
    	this.severeLateness = severeLateness;
    	this.absent = absent;
    	this.axisJson = axisJson;
    }
    
	public Long getShiftId() {
		return shiftId;
	}
	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getShiftName() {
		return shiftName;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
	public Integer getShiftType() {
		return shiftType;
	}
	public void setShiftType(Integer shiftType) {
		this.shiftType = shiftType;
	}
	public Integer getSevereLateness() {
		return severeLateness;
	}
	public void setSevereLateness(Integer severeLateness) {
		this.severeLateness = severeLateness;
	}
	public Integer getAbsent() {
		return absent;
	}
	public void setAbsent(Integer absent) {
		this.absent = absent;
	}
	public String getAxisJson() {
		return axisJson;
	}
	public void setAxisJson(String axisJson) {
		this.axisJson = axisJson;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<TeacherAttendAxis> getAxisList() {
		return axisList;
	}
	public void setAxisList(List<TeacherAttendAxis> axisList) {
		this.axisList = axisList;
	}
	
}
