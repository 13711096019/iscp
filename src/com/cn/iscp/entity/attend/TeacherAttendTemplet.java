package com.cn.iscp.entity.attend;

/**
 * 老师考勤班次模板表
 * @author 10011037@qq.com
 * 2018-07-10
 */
public class TeacherAttendTemplet {
	
	/**
	 * 当考勤组新增第一条周期时自动插入到模板里面
	 */
	
	// 自增编号
    private Long templetId;
	// 用户编号
    private Long groupId;
	// 用户编号
    private Long userId;
	// 考勤班次编号
    private Long shiftId;
	// 星期几（1星期一...7星期日）
    private Integer weekNum;

	// 考勤班次编号集合
    private String shiftIds;
	// 周期编号
    private Long cycleId;
	// 是否修改排班
    private Integer isUpdScheduling;
    
    public TeacherAttendTemplet(){};
    
    public TeacherAttendTemplet(Long userId, Long cycleId, Integer isUpdScheduling){
    	this.userId = userId;
    	this.cycleId = cycleId;
    	this.isUpdScheduling = isUpdScheduling;
    }
    
    //批量更新班次模板
    public TeacherAttendTemplet(Long shiftId, Long groupId, Integer weekNum,Integer isUpdScheduling){
    	this.shiftId = shiftId;
    	this.groupId = groupId;
    	this.weekNum = weekNum;
    	this.isUpdScheduling = isUpdScheduling;
    }
    
    public TeacherAttendTemplet(Long userId, Long groupId, Long shiftId, 
    		Integer weekNum, Integer isUpdScheduling){
    	this.userId = userId;
    	this.groupId = groupId;
    	this.shiftId = shiftId;
    	this.weekNum = weekNum;
    	this.isUpdScheduling = isUpdScheduling;
    }
    
	public Long getTempletId() {
		return templetId;
	}
	public void setTempletId(Long templetId) {
		this.templetId = templetId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getCycleId() {
		return cycleId;
	}
	public void setCycleId(Long cycleId) {
		this.cycleId = cycleId;
	}
	public Integer getIsUpdScheduling() {
		return isUpdScheduling;
	}
	public void setIsUpdScheduling(Integer isUpdScheduling) {
		this.isUpdScheduling = isUpdScheduling;
	}
	public String getShiftIds() {
		return shiftIds;
	}
	public void setShiftIds(String shiftIds) {
		this.shiftIds = shiftIds;
	}
	
}
