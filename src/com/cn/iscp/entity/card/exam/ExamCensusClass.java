package com.cn.iscp.entity.card.exam;

import com.cn.common._Tool;

/**
 * 班级测验成绩统计表
 * @author 10011037@qq.com
 * 2017-07-27
 */
public class ExamCensusClass {
	
	// 自增编号
    private Long censusId;
	// 考试编号
    private Long examInfoId;
	// 试卷编号
    private Long examPaperId;
	/*// 年级统考编号
    private Long examId;*/
	// 年份
    // private Integer year;
	// 学年编号
    private Long schoolYearId;
	// 考试月份
    private Integer month;
	// 年级编号[t_base_grade]
    private Long gradeId;
	// 动态班级编号[t_dbase_classentityupgrade]
    private Long classNum;
	// 班级总人数
    private Integer totalCount;
	// 参加考试人数
    private Integer examCount;
	// 总分
    private Double totalScore;
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
	// 及格人数(60_100)
    private Integer passScoreCount;
	// 不及格人数(0_59)
    private Integer badScoreCount;
	// 满分率%
    private Double fullScoreRate;
	// 高分率%
    private Double goodScoreRate;
	// 优秀率%
    private Double excelScoreRate;
	// 良好率%
    private Double fineScoreRate;
	// 及格率%
    private Double passScoreRate;
	// 不及格率%
    private Double badScoreRate;
	// 统计时间
    private String censusTime;
	// 备注
    private String note;
	// 班级排名
    private Integer avgScoreSort;
    

	// 班级名称
    private String className;
	// 老师姓名
    private String teacherName;
	// 试卷名称
    private String examName;
    
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
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
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
	public Double getLowestScore() {
		return lowestScore;
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
	public Double getExcelScoreRate() {
		return excelScoreRate;
	}
	public void setExcelScoreRate(Double excelScoreRate) {
		this.excelScoreRate = excelScoreRate;
	}
	public Double getFineScoreRate() {
		return fineScoreRate;
	}
	public void setFineScoreRate(Double fineScoreRate) {
		this.fineScoreRate = fineScoreRate;
	}
	public Double getBadScoreRate() {
		return badScoreRate;
	}
	public void setBadScoreRate(Double badScoreRate) {
		this.badScoreRate = badScoreRate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = _Tool.toStr(examName);
	}
	public Integer getAvgScoreSort() {
		return avgScoreSort;
	}
	public void setAvgScoreSort(Integer avgScoreSort) {
		this.avgScoreSort = avgScoreSort;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getPassScoreCount() {
		return passScoreCount;
	}
	public void setPassScoreCount(Integer passScoreCount) {
		this.passScoreCount = passScoreCount;
	}
	public Double getPassScoreRate() {
		return passScoreRate;
	}
	public void setPassScoreRate(Double passScoreRate) {
		this.passScoreRate = passScoreRate;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
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
	
	
}
