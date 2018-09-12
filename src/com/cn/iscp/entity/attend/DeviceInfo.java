package com.cn.iscp.entity.attend;

/**
 * 设备信息表
 * @author 10011037@qq.com
 * 2018-06-07
 */
public class DeviceInfo {

	// 自增编号
    private Long leaveId;
	// 设备编号
    private Integer deviceNo;
	// 安装位置（1=校门，2=班门口，3=校车）
    private Integer positionId;
    
    public DeviceInfo(){};
    
	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}
	public Integer getDeviceNo() {
		return deviceNo;
	}
	public void setDeviceNo(Integer deviceNo) {
		this.deviceNo = deviceNo;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	
	
}
