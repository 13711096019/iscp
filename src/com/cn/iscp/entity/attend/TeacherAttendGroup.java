package com.cn.iscp.entity.attend;

import java.util.List;

/**
 * 考勤组信息
 * @author 10011037@qq.com
 * 2018-07-10
 */
public class TeacherAttendGroup {
	
	// 自增编号
    private Long groupId;
	// 组名称
    private String groupName;
	// 负责任编号列表
    private String principalIds;
	// 状态(0删除,1正常)
    protected Integer status;
	// 创建人编号
    private Long createUserId;
	// 创建时间
    private String createTime;
    
	// 负责任姓名列表
    private String principalNames;
    // 考勤班次列表
    private List<TeacherAttendShift> shiftList;
    // 周期列表
    private List<TeacherAttendCycle> cycleList;
    // 考勤位置列表
    private List<TeacherAttendSite> siteList;
    // 考勤wifi列表
    private List<TeacherAttendWifi> wifiList;
    
    
    
    public TeacherAttendGroup(){};
    
    public TeacherAttendGroup(Long groupId, String groupName, String principalIds, Long createUserId){
    	this.groupId = groupId;
    	this.groupName = groupName;
    	this.principalIds = principalIds;
    	this.createUserId = createUserId;
    }
    
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getPrincipalIds() {
		return principalIds;
	}
	public void setPrincipalIds(String principalIds) {
		this.principalIds = principalIds;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPrincipalNames() {
		return principalNames;
	}
	public void setPrincipalNames(String principalNames) {
		this.principalNames = principalNames;
	}
	public List<TeacherAttendShift> getShiftList() {
		return shiftList;
	}
	public void setShiftList(List<TeacherAttendShift> shiftList) {
		this.shiftList = shiftList;
	}
	public List<TeacherAttendCycle> getCycleList() {
		return cycleList;
	}
	public void setCycleList(List<TeacherAttendCycle> cycleList) {
		this.cycleList = cycleList;
	}
	public List<TeacherAttendSite> getSiteList() {
		return siteList;
	}
	public void setSiteList(List<TeacherAttendSite> siteList) {
		this.siteList = siteList;
	}
	public List<TeacherAttendWifi> getWifiList() {
		return wifiList;
	}
	public void setWifiList(List<TeacherAttendWifi> wifiList) {
		this.wifiList = wifiList;
	}
	
    
}
