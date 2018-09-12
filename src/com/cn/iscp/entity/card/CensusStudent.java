package com.cn.iscp.entity.card;

import com.cn.common._Tool;

/**
 * 学生每学期状态登记
 * @author 10011037@qq.com
 * 2017-08-05
 */
public class CensusStudent {
	
	// 自增编号
    private Long registryId;
    // 动态班级编号
    private Long classNum;
    // 学生编码
    private Long studentId;
	// 新生(通过入校来定）1=本学期新生， 0=非新生
    private Integer isNew;
	// 在校生（勾选）1=在校生 ，0=非在校生
    private Integer isOnSchool;
	// 少先队员(3值状态值，1=少先队、2=团员、0=普通学生）【下拉选择】
    private Integer isPioneer;
	// 达到锻炼标准（勾选）1=达标，0=未达标
    private Integer isMeetPhisicalTarget;
	// 患砂眼(1是,0否)
    private Integer isTrachoma;
	// 近视眼(1是,0否)
    private Integer isMyopicEye;
	// 是否完全健康(1是,0否)
    private Integer isHealthy;
	// 符合减免金补贴条件(1是,0否)
    private Integer isFitWaiver;
	// 健康状态列表（多选）
    private String healthStatusList;
	// 放学方式（下拉）1=午晚放 ，2=晚放
    private Integer leaveSchoolMode;
	// 接送方式（下拉选择）【1=家长接送，2=校车接送】
    private Integer shuttleMode;
	// 在校早餐（勾选）1=在校吃早餐，0=不吃早餐
    private Integer isBreadfast;
	// 晚餐（勾选）1=在校吃午餐，0=不吃午餐
    private Integer isLunch;
	// 备注
    private String note;
    
    
    
	public Long getRegistryId() {
		return registryId;
	}
	public void setRegistryId(Long registryId) {
		this.registryId = registryId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Integer getIsNew() {
		return isNew;
	}
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	public Integer getIsOnSchool() {
		return isOnSchool;
	}
	public void setIsOnSchool(Integer isOnSchool) {
		this.isOnSchool = isOnSchool;
	}
	public Integer getIsPioneer() {
		return isPioneer;
	}
	public void setIsPioneer(Integer isPioneer) {
		this.isPioneer = isPioneer;
	}
	public Integer getIsMeetPhisicalTarget() {
		return isMeetPhisicalTarget;
	}
	public void setIsMeetPhisicalTarget(Integer isMeetPhisicalTarget) {
		this.isMeetPhisicalTarget = isMeetPhisicalTarget;
	}
	public Integer getIsTrachoma() {
		return isTrachoma;
	}
	public void setIsTrachoma(Integer isTrachoma) {
		this.isTrachoma = isTrachoma;
	}
	public Integer getIsMyopicEye() {
		return isMyopicEye;
	}
	public void setIsMyopicEye(Integer isMyopicEye) {
		this.isMyopicEye = isMyopicEye;
	}
	public String getHealthStatusList() {
		return healthStatusList;
	}
	public void setHealthStatusList(String healthStatusList) {
		this.healthStatusList = _Tool.toStr(healthStatusList);
	}
	public Integer getLeaveSchoolMode() {
		return leaveSchoolMode;
	}
	public void setLeaveSchoolMode(Integer leaveSchoolMode) {
		this.leaveSchoolMode = leaveSchoolMode;
	}
	public Integer getShuttleMode() {
		return shuttleMode;
	}
	public void setShuttleMode(Integer shuttleMode) {
		this.shuttleMode = shuttleMode;
	}
	public Integer getIsBreadfast() {
		return isBreadfast;
	}
	public void setIsBreadfast(Integer isBreadfast) {
		this.isBreadfast = isBreadfast;
	}
	public Integer getIsLunch() {
		return isLunch;
	}
	public void setIsLunch(Integer isLunch) {
		this.isLunch = isLunch;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public Integer getIsHealthy() {
		return isHealthy;
	}
	public void setIsHealthy(Integer isHealthy) {
		this.isHealthy = isHealthy;
	}
	public Integer getIsFitWaiver() {
		return isFitWaiver;
	}
	public void setIsFitWaiver(Integer isFitWaiver) {
		this.isFitWaiver = isFitWaiver;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
    
}
