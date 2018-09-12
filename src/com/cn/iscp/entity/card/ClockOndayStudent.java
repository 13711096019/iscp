package com.cn.iscp.entity.card;

import com.cn.common._Tool;

/**
 * 学生每日考勤统计表
 * @author 10011037@qq.com
 * 2017-08-15
 */
public class ClockOndayStudent {

	// 自增编号
    private Long clockId;
	// 学年
    private Long schoolYearId;
	// 学期度
    private Long termId;
	// 月份
    private Integer month;
	// 动态班主体编号
    private Long classNum;
	// 学生编号
    private Long studentId;
	// 打卡日期
    private String clockOnDate;
	// 位置编号（1=校门，2=班门口） 表 t_base_itemdir ，itemDirID=15(考勤打卡位置)
    private Integer clockLocationId;
	// 课程节次
    private Integer sessionId;
	// 打卡次序
    private Integer clockSort;
	// 打卡时间
    private String clockOnArrivalTime;
	// 打卡状态（1=准时，2=迟到，3=未知）
    private Integer clockOnStatus;
	// 判决状态
    private Integer judgeStatus;
	// 记录状态
    private Integer status;
	// 备注
    private String note;

	// 考勤卡编号（物理卡号，依靠读卡器）
    private String studentCardPhy;
	// 学生姓名
    private String studentName;
	// 学生头像
    private String headPortrait;
	// 判决状态名称
    private String judgeStatusName;
    
    public ClockOndayStudent(){};
    
    /**
     * PC-获根据考勤状态获取学生信息
     */
    public ClockOndayStudent(Long classNum, String clockOnDate, Integer judgeStatus){
    	this.classNum = classNum;
    	this.clockOnDate = clockOnDate;
    	this.judgeStatus = judgeStatus;
    }
    
    /**
     * PC-特殊情况录入(忘打卡6,旷课4,早退5)
     */
    public ClockOndayStudent(Long classNum, Long studentId, String clockOnDate, 
    		Integer clockOnStatus, String note){
    	this.classNum = classNum;
    	this.studentId = studentId;
    	this.clockOnDate = clockOnDate;
    	this.clockOnStatus = clockOnStatus;
    	this.note = note;
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
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getClockOnDate() {
		return clockOnDate;
	}
	public void setClockOnDate(String clockOnDate) {
		this.clockOnDate = _Tool.toStr(clockOnDate);
	}
	public Integer getClockLocationId() {
		return clockLocationId;
	}
	public void setClockLocationId(Integer clockLocationId) {
		this.clockLocationId = clockLocationId;
	}
	public Integer getSessionId() {
		return sessionId;
	}
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}
	public Integer getClockSort() {
		return clockSort;
	}
	public void setClockSort(Integer clockSort) {
		this.clockSort = clockSort;
	}
	public String getClockOnArrivalTime() {
		return clockOnArrivalTime;
	}
	public void setClockOnArrivalTime(String clockOnArrivalTime) {
		this.clockOnArrivalTime = _Tool.toStr(clockOnArrivalTime);
	}
	public Integer getClockOnStatus() {
		return clockOnStatus;
	}
	public void setClockOnStatus(Integer clockOnStatus) {
		this.clockOnStatus = clockOnStatus;
	}
	public Integer getJudgeStatus() {
		return judgeStatus;
	}
	public void setJudgeStatus(Integer judgeStatus) {
		this.judgeStatus = judgeStatus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getStudentCardPhy() {
		return studentCardPhy;
	}
	public void setStudentCardPhy(String studentCardPhy) {
		this.studentCardPhy = studentCardPhy;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = _Tool.toStr(studentName);
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = _Tool.toStr(headPortrait);
	}
	public String getJudgeStatusName() {
		return judgeStatusName;
	}
	public void setJudgeStatusName(String judgeStatusName) {
		this.judgeStatusName = _Tool.toStr(judgeStatusName);
	}
	
}
