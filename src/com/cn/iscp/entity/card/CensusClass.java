package com.cn.iscp.entity.card;

/**
 * 班级统计
 * @author 10011037@qq.com
 * 2017-08-05
 */
public class CensusClass {

	// 自增编号
    private Long statisticId;
    // 动态班级编号
    private Long classNum;
    // 学年编号
    private Long schoolYearId;
	// 新生
    private Integer newCount;
	// 在校生
    private Integer onSchoolCount;
	// 少先队员/团员
    private Integer pioneerCount;
	// 达标锻炼标准
    private Integer meetPhisicalTargetCount;
	// 完全健康
    private Integer healthyCount;
	// 符合领减免金
    private Integer fitWaiverCount;
	// 砂眼
    private Integer trachomaCount;
	// 近视眼
    private Integer myopicEyeCount;
	// 患特殊疾病
    private Integer specialDiseaseCount;
	// 午、晚放(两放)
    private Integer noonEveningLeaveCount;
	// 晚放(单放)
    private Integer eveningLeaveCount;
	// 家长接送
    private Integer shuttleModeParent;
	// 车送
    private Integer shuttleModeBus;
	// 早餐
    private Integer breadfastCount;
	// 晚餐
    private Integer lunchCount;
    
    
    
	public Long getStatisticId() {
		return statisticId;
	}
	public void setStatisticId(Long statisticId) {
		this.statisticId = statisticId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Integer getNewCount() {
		return newCount;
	}
	public void setNewCount(Integer newCount) {
		this.newCount = newCount;
	}
	public Integer getOnSchoolCount() {
		return onSchoolCount;
	}
	public void setOnSchoolCount(Integer onSchoolCount) {
		this.onSchoolCount = onSchoolCount;
	}
	public Integer getPioneerCount() {
		return pioneerCount;
	}
	public void setPioneerCount(Integer pioneerCount) {
		this.pioneerCount = pioneerCount;
	}
	public Integer getMeetPhisicalTargetCount() {
		return meetPhisicalTargetCount;
	}
	public void setMeetPhisicalTargetCount(Integer meetPhisicalTargetCount) {
		this.meetPhisicalTargetCount = meetPhisicalTargetCount;
	}
	public Integer getHealthyCount() {
		return healthyCount;
	}
	public void setHealthyCount(Integer healthyCount) {
		this.healthyCount = healthyCount;
	}
	public Integer getTrachomaCount() {
		return trachomaCount;
	}
	public void setTrachomaCount(Integer trachomaCount) {
		this.trachomaCount = trachomaCount;
	}
	public Integer getMyopicEyeCount() {
		return myopicEyeCount;
	}
	public void setMyopicEyeCount(Integer myopicEyeCount) {
		this.myopicEyeCount = myopicEyeCount;
	}
	public Integer getSpecialDiseaseCount() {
		return specialDiseaseCount;
	}
	public void setSpecialDiseaseCount(Integer specialDiseaseCount) {
		this.specialDiseaseCount = specialDiseaseCount;
	}
	public Integer getNoonEveningLeaveCount() {
		return noonEveningLeaveCount;
	}
	public void setNoonEveningLeaveCount(Integer noonEveningLeaveCount) {
		this.noonEveningLeaveCount = noonEveningLeaveCount;
	}
	public Integer getEveningLeaveCount() {
		return eveningLeaveCount;
	}
	public void setEveningLeaveCount(Integer eveningLeaveCount) {
		this.eveningLeaveCount = eveningLeaveCount;
	}
	public Integer getShuttleModeParent() {
		return shuttleModeParent;
	}
	public void setShuttleModeParent(Integer shuttleModeParent) {
		this.shuttleModeParent = shuttleModeParent;
	}
	public Integer getShuttleModeBus() {
		return shuttleModeBus;
	}
	public void setShuttleModeBus(Integer shuttleModeBus) {
		this.shuttleModeBus = shuttleModeBus;
	}
	public Integer getBreadfastCount() {
		return breadfastCount;
	}
	public void setBreadfastCount(Integer breadfastCount) {
		this.breadfastCount = breadfastCount;
	}
	public Integer getLunchCount() {
		return lunchCount;
	}
	public void setLunchCount(Integer lunchCount) {
		this.lunchCount = lunchCount;
	}
	public Integer getFitWaiverCount() {
		return fitWaiverCount;
	}
	public void setFitWaiverCount(Integer fitWaiverCount) {
		this.fitWaiverCount = fitWaiverCount;
	}
	public Long getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Long schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
	
}
