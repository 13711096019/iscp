package com.cn.iscp.entity.attend;

/**
 * wifi考勤
 * @author 10011037@qq.com
 * 2018-07-10
 */
public class TeacherAttendWifi {
	
	// 自增编号
    private Long wifiId;
	// 考勤组编号
    private Long groupId;
	// wifi名称
    private String wifiName;
	// IP地址
    private String wifiIp;
	// MAC
    private String wifiMac;
	// PIN
    private String wifiPin;
	// 状态(0删除,1正常)
    protected Integer status;
    
    public TeacherAttendWifi(){};
    
    public TeacherAttendWifi(Long wifiId, Long groupId, String wifiName, 
    		String wifiIp, String wifiMac, String wifiPin){
    	this.wifiId = wifiId;
    	this.groupId = groupId;
    	this.wifiName = wifiName;
    	this.wifiIp = wifiIp;
    	this.wifiMac = wifiMac;
    	this.wifiPin = wifiPin;
    }
    
	public Long getWifiId() {
		return wifiId;
	}
	public void setWifiId(Long wifiId) {
		this.wifiId = wifiId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getWifiIp() {
		return wifiIp;
	}
	public void setWifiIp(String wifiIp) {
		this.wifiIp = wifiIp;
	}
	public String getWifiName() {
		return wifiName;
	}
	public void setWifiName(String wifiName) {
		this.wifiName = wifiName;
	}
	public String getWifiMac() {
		return wifiMac;
	}
	public void setWifiMac(String wifiMac) {
		this.wifiMac = wifiMac;
	}
	public String getWifiPin() {
		return wifiPin;
	}
	public void setWifiPin(String wifiPin) {
		this.wifiPin = wifiPin;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
