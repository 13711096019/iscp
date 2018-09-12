package com.cn.iscp.entity.attend;

/**
 * 考勤地点
 * @author 10011037@qq.com
 * 2018-07-10
 */
public class TeacherAttendSite {
	
	// 自增编号
    private Long siteId;
	// 考勤组编号
    private Long groupId;
	// 考勤名称
    private String siteName;
	// 考勤位置
    private String address;
	// 考勤位置经度
    private Double siteLng;
	// 考勤位置纬度
    private Double siteLat;
	// 有效范围（N米）
    private Integer availableIn;
	// 状态(0删除,1正常)
    protected Integer status;
    //经纬度距离
    protected double distance;
    
    public TeacherAttendSite(){};
    
    public TeacherAttendSite(Long siteId, Long groupId, String siteName, String address, 
    		Double siteLng, Double siteLat, Integer availableIn){
    	this.siteId = siteId;
    	this.groupId = groupId;
    	this.siteName = siteName;
    	this.address = address;
    	this.siteLng = siteLng;
    	this.siteLat = siteLat;
    	this.availableIn = availableIn;
    }
    
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public Double getSiteLng() {
		return siteLng;
	}
	public void setSiteLng(Double siteLng) {
		this.siteLng = siteLng;
	}
	public Double getSiteLat() {
		return siteLat;
	}
	public void setSiteLat(Double siteLat) {
		this.siteLat = siteLat;
	}
	public Integer getAvailableIn() {
		return availableIn;
	}
	public void setAvailableIn(Integer availableIn) {
		this.availableIn = availableIn;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

    
}
