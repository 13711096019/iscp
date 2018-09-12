package com.cn.iscp.entity.card.exam;

import com.cn.common._Tool;

/**
 * 年级测验成绩统计表
 * @author 10011037@qq.com
 * 2017-07-27
 */
public class ExamCensusGrade {

	// 自增编号
    private Long censusId;
	// 考试编号
    private Long examInfoId;
	// 试卷编号
    private Long examPaperId;
	/*// 自增编号
    private Long examId;*/
	// 年份
    // private Integer year;
	// 学年编号
    private Long schoolYearId;
	// 考试月份
    private Integer month;
	// 年级编号
    private Long gradeId;
	// 年级总人数
    private Integer totalCount;
	// 参加考试人数
    private Integer examCount;
	// 考试率
    private Double examRate;
	// 最低考分
    private Double lowestScore;
	// 最高考分
    private Double highestScore;
	// 平均考分
    private Double averageScore;
    
	// 满分人数(100)
    private Integer fullScoreCount;
	// 高分人数(90_99)
    private Integer goodScoreCount;
	// 优秀人数(80_89)
    private Integer excelScoreCount;
	// 良好人数(60_79)
    private Integer fineScoreCount;
	// 不及格人数(0_59)
    private Integer badScoreCount;
	// 满分率%
    private Double fullScoreRate;
	// 高分率%
    private Double goodScoreRate;
	// 优秀人数(80_89)
    private Double excelScoreRate;
	// 良好率%
    private Double fineScoreRate;
	// 不及格率%
    private Double badScoreRate;
    
	// 统计时间
    private String censusTime;
	// 备注
    private String note;
    
    
	public Long getCensusId() {
		return censusId;
	}
	public void setCensusId(Long censusId) {
		this.censusId = censusId;
	}
	/*public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}*/
	public Long getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Long schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getExamCount() {
		return examCount;
	}
	public void setExamCount(Integer examCount) {
		this.examCount = examCount;
	}
	public void setLowestScore(Double lowestScore) {
		this.lowestScore = lowestScore;
	}
	public Double getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(Double highestScore) {
		this.highestScore = highestScore;
	}
	public Double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}
	public Integer getFullScoreCount() {
		return fullScoreCount;
	}
	public void setFullScoreCount(Integer fullScoreCount) {
		this.fullScoreCount = fullScoreCount;
	}
	public Integer getGoodScoreCount() {
		return goodScoreCount;
	}
	public void setGoodScoreCount(Integer goodScoreCount) {
		this.goodScoreCount = goodScoreCount;
	}
	public Integer getExcelScoreCount() {
		return excelScoreCount;
	}
	public void setExcelScoreCount(Integer excelScoreCount) {
		this.excelScoreCount = excelScoreCount;
	}
	public Integer getFineScoreCount() {
		return fineScoreCount;
	}
	public void setFineScoreCount(Integer fineScoreCount) {
		this.fineScoreCount = fineScoreCount;
	}
	public Double getFullScoreRate() {
		return fullScoreRate;
	}
	public void setFullScoreRate(Double fullScoreRate) {
		this.fullScoreRate = fullScoreRate;
	}
	public Double getGoodScoreRate() {
		return goodScoreRate;
	}
	public void setGoodScoreRate(Double goodScoreRate) {
		this.goodScoreRate = goodScoreRate;
	}
	public Double getFineScoreRate() {
		return fineScoreRate;
	}
	public void setFineScoreRate(Double fineScoreRate) {
		this.fineScoreRate = fineScoreRate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public Double getExamRate() {
		return examRate;
	}
	public void setExamRate(Double examRate) {
		this.examRate = examRate;
	}
	public Double getLowestScore() {
		return lowestScore;
	}
	public String getCensusTime() {
		return censusTime;
	}
	public void setCensusTime(String censusTime) {
		this.censusTime = _Tool.toStr(censusTime);
	}
	public Integer getBadScoreCount() {
		return badScoreCount;
	}
	public void setBadScoreCount(Integer badScoreCount) {
		this.badScoreCount = badScoreCount;
	}
	public Double getBadScoreRate() {
		return badScoreRate;
	}
	public void setBadScoreRate(Double badScoreRate) {
		this.badScoreRate = badScoreRate;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Long getExamInfoId() {
		return examInfoId;
	}
	public void setExamInfoId(Long examInfoId) {
		this.examInfoId = examInfoId;
	}
	public Long getExamPaperId() {
		return examPaperId;
	}
	public void setExamPaperId(Long examPaperId) {
		this.examPaperId = examPaperId;
	}
	public Double getExcelScoreRate() {
		return excelScoreRate;
	}
	public void setExcelScoreRate(Double excelScoreRate) {
		this.excelScoreRate = excelScoreRate;
	}
	
    
}
