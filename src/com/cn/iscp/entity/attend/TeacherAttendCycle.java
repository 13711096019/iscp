package com.cn.iscp.entity.attend;

/**
 * 周期排班模板
 * @author 10011037@qq.com
 * 2018-07-10
 */
public class TeacherAttendCycle {
	
	// 自增编号
    private Long cycleId;
	// 考勤组编号
    private Long groupId;
	// 周期名称
    private String cycleName;
	// 星期一班次编号
    private Long monShiftId;
	// 星期二班次编号
    private Long tueShiftId;
	// 星期三班次编号
    private Long wedShiftId;
	// 星期四班次编号
    private Long thurShiftId;
	// 星期五班次编号
    private Long friShiftId;
	// 星期六班次编号
    private Long satShiftId;
	// 星期日班次编号
    private Long sunShiftId;
	// 状态(0删除,1正常)
    protected Integer status;

	// 星期一班次名称
    private String monShiftName;
	// 星期二班次名称
    private String tueShiftName;
	// 星期三班次名称
    private String wedShiftName;
	// 星期四班次名称
    private String thurShiftName;
	// 星期五班次名称
    private String friShiftName;
	// 星期六班次名称
    private String satShiftName;
	// 星期日班次名称
    private String sunShiftName;
    
    
    public TeacherAttendCycle(){};
    
    public TeacherAttendCycle(Long cycleId, Long groupId, String cycleName, 
    		Long monShiftId, Long tueShiftId, Long wedShiftId, Long thurShiftId, 
    		Long friShiftId, Long satShiftId, Long sunShiftId){
    	this.cycleId = cycleId;
    	this.groupId = groupId;
    	this.cycleName = cycleName;
    	this.monShiftId = monShiftId;
    	this.tueShiftId = tueShiftId;
    	this.wedShiftId = wedShiftId;
    	this.thurShiftId = thurShiftId;
    	this.friShiftId = friShiftId;
    	this.satShiftId = satShiftId;
    	this.sunShiftId = sunShiftId;
    }
    
	public Long getCycleId() {
		return cycleId;
	}
	public void setCycleId(Long cycleId) {
		this.cycleId = cycleId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getCycleName() {
		return cycleName;
	}
	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}
	public Long getMonShiftId() {
		return monShiftId;
	}
	public void setMonShiftId(Long monShiftId) {
		this.monShiftId = monShiftId;
	}
	public Long getTueShiftId() {
		return tueShiftId;
	}
	public void setTueShiftId(Long tueShiftId) {
		this.tueShiftId = tueShiftId;
	}
	public Long getWedShiftId() {
		return wedShiftId;
	}
	public void setWedShiftId(Long wedShiftId) {
		this.wedShiftId = wedShiftId;
	}
	public Long getThurShiftId() {
		return thurShiftId;
	}
	public void setThurShiftId(Long thurShiftId) {
		this.thurShiftId = thurShiftId;
	}
	public Long getFriShiftId() {
		return friShiftId;
	}
	public void setFriShiftId(Long friShiftId) {
		this.friShiftId = friShiftId;
	}
	public Long getSatShiftId() {
		return satShiftId;
	}
	public void setSatShiftId(Long satShiftId) {
		this.satShiftId = satShiftId;
	}
	public Long getSunShiftId() {
		return sunShiftId;
	}
	public void setSunShiftId(Long sunShiftId) {
		this.sunShiftId = sunShiftId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMonShiftName() {
		return monShiftName;
	}
	public void setMonShiftName(String monShiftName) {
		this.monShiftName = monShiftName;
	}
	public String getTueShiftName() {
		return tueShiftName;
	}
	public void setTueShiftName(String tueShiftName) {
		this.tueShiftName = tueShiftName;
	}
	public String getWedShiftName() {
		return wedShiftName;
	}
	public void setWedShiftName(String wedShiftName) {
		this.wedShiftName = wedShiftName;
	}
	public String getThurShiftName() {
		return thurShiftName;
	}
	public void setThurShiftName(String thurShiftName) {
		this.thurShiftName = thurShiftName;
	}
	public String getFriShiftName() {
		return friShiftName;
	}
	public void setFriShiftName(String friShiftName) {
		this.friShiftName = friShiftName;
	}
	public String getSatShiftName() {
		return satShiftName;
	}
	public void setSatShiftName(String satShiftName) {
		this.satShiftName = satShiftName;
	}
	public String getSunShiftName() {
		return sunShiftName;
	}
	public void setSunShiftName(String sunShiftName) {
		this.sunShiftName = sunShiftName;
	}
	
}
