package com.cn.iscp.entity.card;

import com.cn.unit.utils.DateUtil;


/**
 * 班级每日考勤统计表
 * @author 10011037@qq.com
 * 2017-08-15
 */
public class ClockOndayClass {

	// 自增编号
    private Long clockId;
	// 学年
    private Long schoolYearId;
	// 学年度
    private Long termId;
	// 月份
    private Integer month;
	// 动态班主体编号
    private Long classNum;
	// 打卡日期
    private String clockOnDate;
	// 位置编号（1=校门，2=班门口） 表 t_base_itemdir ，itemDirID=15(考勤打卡位置)
    private Integer clockLocationId;
	// 应打卡人数
    private Integer studentCount;
	// 实际打卡人数
    private Integer clockOnCount;
	// 准时到达人数
    private Integer arriveInTimeCount;
	// 迟到人数
    private Integer arriveLateCount;
	// 早退人数
    private Integer leaveEarlyCount;
	// 请假人数
    private Integer askForLeaveCount;
	// 旷课人数
    private Integer absenteeism;
	// 到班忘打卡人数
    private Integer clockForgetCountMorning;
	// 离班忘打卡人数
    private Integer clockForgetCountAfternoon;
    
    public ClockOndayClass(){};
    
    public ClockOndayClass(Long classNum){
    	this.classNum = classNum;
    	this.clockOnDate = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD);
    }
    
    public ClockOndayClass(Long classNum, String clockOnDate){
    	this.classNum = classNum;
    	this.clockOnDate = clockOnDate;
    }
    
    
	public Long getClockId() {
		return clockId;
	}
	public void setClockId(Long clockId) {
		this.clockId = clockId;
	}
	public Long getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Long schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Long getTermId() {
		return termId;
	}
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public String getClockOnDate() {
		return clockOnDate;
	}
	public void setClockOnDate(String clockOnDate) {
		this.clockOnDate = clockOnDate;
	}
	public Integer getClockLocationId() {
		return clockLocationId;
	}
	public void setClockLocationId(Integer clockLocationId) {
		this.clockLocationId = clockLocationId;
	}
	public Integer getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}
	public Integer getClockOnCount() {
		return clockOnCount;
	}
	public void setClockOnCount(Integer clockOnCount) {
		this.clockOnCount = clockOnCount;
	}
	public Integer getArriveInTimeCount() {
		return arriveInTimeCount;
	}
	public void setArriveInTimeCount(Integer arriveInTimeCount) {
		this.arriveInTimeCount = arriveInTimeCount;
	}
	public Integer getArriveLateCount() {
		return arriveLateCount;
	}
	public void setArriveLateCount(Integer arriveLateCount) {
		this.arriveLateCount = arriveLateCount;
	}
	public Integer getLeaveEarlyCount() {
		return leaveEarlyCount;
	}
	public void setLeaveEarlyCount(Integer leaveEarlyCount) {
		this.leaveEarlyCount = leaveEarlyCount;
	}
	public Integer getAskForLeaveCount() {
		return askForLeaveCount;
	}
	public void setAskForLeaveCount(Integer askForLeaveCount) {
		this.askForLeaveCount = askForLeaveCount;
	}
	public Integer getAbsenteeism() {
		return absenteeism;
	}
	public void setAbsenteeism(Integer absenteeism) {
		this.absenteeism = absenteeism;
	}
	public Integer getClockForgetCountMorning() {
		return clockForgetCountMorning;
	}
	public void setClockForgetCountMorning(Integer clockForgetCountMorning) {
		this.clockForgetCountMorning = clockForgetCountMorning;
	}
	public Integer getClockForgetCountAfternoon() {
		return clockForgetCountAfternoon;
	}
	public void setClockForgetCountAfternoon(Integer clockForgetCountAfternoon) {
		this.clockForgetCountAfternoon = clockForgetCountAfternoon;
	}
	
    
}
