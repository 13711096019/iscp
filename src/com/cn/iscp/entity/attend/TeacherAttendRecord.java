package com.cn.iscp.entity.attend;

/**
 * 打卡记录
 * @author 10011037@qq.com
 * 2018-07-10
 */
public class TeacherAttendRecord {
	
	// 自增编号
    private Long recordId;
	// 老师编号
    private Long userId;
	// 考勤组编号
    private Long groupId;
	// 考勤班次编号
    private Long shiftId;
	// 打卡时间轴编号
    private Long axisId;
	// 考勤地址编号
    private Long siteId;
	// 考勤wifi编号
    private Long wifiId;
	// 打卡日期
    private String attendDate;
	// 打卡时间
    private String attendTime;
	// 经度
    private Double attendLng;
	// 纬度
    private Double attendLat;
	// 地址
    private String address;
	// 打卡方式（1打卡，2补卡同意，3补卡被拒绝，4补卡申请中）
    private Integer attendType;
	// 打卡状态（1正常，2迟到，3严重迟到，4早退，5缺卡）
    private Integer attendState;
	// 是否外勤打卡(1外勤打卡，0范围内打卡)
    private Integer exteriorAttend;
	// 状态(0删除,1正常)
    protected Integer status;
    
    public TeacherAttendRecord(){};
    
    public TeacherAttendRecord(Long userId, String attendDate){
    	this.userId = userId;
    	this.attendDate = attendDate;
    }
    
    public TeacherAttendRecord(Long userId, Long groupId, Long axisId, Long siteId, Long wifiId,
    		String attendDate, String attendTime, Double attendLng, Double attendLat,
    		Integer attendType, Integer attendState, Integer exteriorAttend){
    	this.userId = userId;
    	this.groupId = groupId;
    	this.axisId = axisId;
    	this.siteId = siteId;
    	this.wifiId = wifiId;
    	this.attendDate = attendDate;
    	this.attendTime = attendTime;
    	this.attendLng = attendLng;
    	this.attendLat = attendLat;
    	this.attendType = attendType;
    	this.attendState = attendState;
    	this.exteriorAttend = exteriorAttend;
    }
    
	public Long getRecordId() {
		return recordId;
	}
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
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
	public Long getAxisId() {
		return axisId;
	}
	public void setAxisId(Long axisId) {
		this.axisId = axisId;
	}
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
	}
	public String getAttendTime() {
		return attendTime;
	}
	public void setAttendTime(String attendTime) {
		this.attendTime = attendTime;
	}
	public Double getAttendLng() {
		return attendLng;
	}
	public void setAttendLng(Double attendLng) {
		this.attendLng = attendLng;
	}
	public Double getAttendLat() {
		return attendLat;
	}
	public void setAttendLat(Double attendLat) {
		this.attendLat = attendLat;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAttendType() {
		return attendType;
	}
	public void setAttendType(Integer attendType) {
		this.attendType = attendType;
	}
	public Integer getAttendState() {
		return attendState;
	}
	public void setAttendState(Integer attendState) {
		this.attendState = attendState;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public Long getWifiId() {
		return wifiId;
	}
	public void setWifiId(Long wifiId) {
		this.wifiId = wifiId;
	}
	public Integer getExteriorAttend() {
		return exteriorAttend;
	}
	public void setExteriorAttend(Integer exteriorAttend) {
		this.exteriorAttend = exteriorAttend;
	}
    
}
