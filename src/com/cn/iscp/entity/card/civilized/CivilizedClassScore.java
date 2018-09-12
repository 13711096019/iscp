package com.cn.iscp.entity.card.civilized;

import java.util.List;

import com.cn.common._Tool;

/**
 * 班级创文得分表
 * @author 10011037@qq.com
 * 2017-09-08
 */
public class CivilizedClassScore {
	
	// 自增编号
    private Long scoreId;
	// 动态班级编号
    private Long classNum;
	// 创文评比周期(1=月评，2=周评，3=日评)
    private Integer periodType;
	// 学年
    private Integer year;
	// 学期
    private Integer termId;
	// 第几月
    private Integer month;
	// 第几周
    private Integer week;
	// 星期几
    private Integer weekDay;
	// 评分日期
    private String studyDate;
    
	// 卫生保洁
    private Double sanitaryCleaning;
	// 课室容貌
    private Double classroomAppearance ;
	// 文明礼仪
    private Double residentsCivility;
	// 课间纪律
    private Double playtimeDiscipline;
	// 两操两放
    private Double playgroundDiscipline;
	// 早餐午餐
    private Double eatDiscipline;
	// 公物水电
    private Double publicUtilities;
	// 仪容仪表
    private Double looksAppearance;
	// 乘车纪律
    private Double ridingDiscipline;
	// 校外纪律
    private Double outsideDiscipline;
	// 早读升旗
    private Double morningReading;
	// 加减分
    private Double adjust;
    
	// 总分
    private Double total;
	// 排名
    private Integer ranking;
	// 备注
    private String note;
    
	// 周期
    private Integer period;
	// 班级名称
    private String className;
	// 周期(年-月)
    private String cycle;
	// 年级阶段
    private Integer loopIndex;
    
    private List<CivilizedClassScore> scoreList;
    
    public CivilizedClassScore(){};
    
    public CivilizedClassScore(Long classNum, Integer periodType){
    	this.classNum = classNum;
    	this.periodType = periodType;
    }
    
    public CivilizedClassScore(Long classNum, Integer periodType, 
    		String studyDate, Integer week, String cycle){
    	this.classNum = classNum;
    	this.periodType = periodType;
    	this.studyDate = studyDate;
    	this.week = week;
    	this.cycle = cycle;
    }
    
    
	public Long getScoreId() {
		return scoreId;
	}
	public void setScoreId(Long scoreId) {
		this.scoreId = scoreId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Integer getPeriodType() {
		return periodType;
	}
	public void setPeriodType(Integer periodType) {
		this.periodType = periodType;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Integer getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(Integer weekDay) {
		this.weekDay = weekDay;
	}
	public String getStudyDate() {
		return studyDate;
	}
	public void setStudyDate(String studyDate) {
		this.studyDate = studyDate;
	}
	public Double getSanitaryCleaning() {
		return sanitaryCleaning;
	}
	public void setSanitaryCleaning(Double sanitaryCleaning) {
		this.sanitaryCleaning = sanitaryCleaning;
	}
	public Double getClassroomAppearance() {
		return classroomAppearance;
	}
	public void setClassroomAppearance(Double classroomAppearance) {
		this.classroomAppearance = classroomAppearance;
	}
	public Double getResidentsCivility() {
		return residentsCivility;
	}
	public void setResidentsCivility(Double residentsCivility) {
		this.residentsCivility = residentsCivility;
	}
	public Double getPlaytimeDiscipline() {
		return playtimeDiscipline;
	}
	public void setPlaytimeDiscipline(Double playtimeDiscipline) {
		this.playtimeDiscipline = playtimeDiscipline;
	}
	public Double getPlaygroundDiscipline() {
		return playgroundDiscipline;
	}
	public void setPlaygroundDiscipline(Double playgroundDiscipline) {
		this.playgroundDiscipline = playgroundDiscipline;
	}
	public Double getEatDiscipline() {
		return eatDiscipline;
	}
	public void setEatDiscipline(Double eatDiscipline) {
		this.eatDiscipline = eatDiscipline;
	}
	public Double getPublicUtilities() {
		return publicUtilities;
	}
	public void setPublicUtilities(Double publicUtilities) {
		this.publicUtilities = publicUtilities;
	}
	public Double getLooksAppearance() {
		return looksAppearance;
	}
	public void setLooksAppearance(Double looksAppearance) {
		this.looksAppearance = looksAppearance;
	}
	public Double getRidingDiscipline() {
		return ridingDiscipline;
	}
	public void setRidingDiscipline(Double ridingDiscipline) {
		this.ridingDiscipline = ridingDiscipline;
	}
	public Double getOutsideDiscipline() {
		return outsideDiscipline;
	}
	public void setOutsideDiscipline(Double outsideDiscipline) {
		this.outsideDiscipline = outsideDiscipline;
	}
	public Double getMorningReading() {
		return morningReading;
	}
	public void setMorningReading(Double morningReading) {
		this.morningReading = morningReading;
	}
	public Double getAdjust() {
		return adjust;
	}
	public void setAdjust(Double adjust) {
		this.adjust = adjust;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getRanking() {
		return ranking;
	}
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = _Tool.toStr(className);
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = _Tool.toStr(cycle);
	}
	public List<CivilizedClassScore> getScoreList() {
		return scoreList;
	}
	public void setScoreList(List<CivilizedClassScore> scoreList) {
		this.scoreList = scoreList;
	}
	public Integer getLoopIndex() {
		return loopIndex;
	}
	public void setLoopIndex(Integer loopIndex) {
		this.loopIndex = loopIndex;
	}
    
}
