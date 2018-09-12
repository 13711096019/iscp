package com.cn.iscp.model;

/**
 * 考试成绩
 * @author 10011037@qq.com
 * 2017-12-25
 */
public class ExamScore {

	// 序号
	private Integer rowNum;
	// 学生编号
	private Long studentId;
	// 学号
	private String studentNum;
	// 学生姓名
	private String studentName;
	// 语文成绩
	private Double chineseResult;
	// 数学成绩
	private Double mathResult;
	// 英语成绩
	private Double englishResult;
	// 品德成绩
	private Double moralityResult;
	// 历史成绩
	private Double historyResult;
	// 生物成绩
	private Double biologyResult;
	// 地理成绩
	private Double geographyResult;
	// 物理成绩
	private Double physicsResult;
	// 化学成绩
	private Double chemistryResult;
	// 总成绩
	private Double totalResult;
	// 班级排名
	private Integer rankClass;
	// 年级排名
	private Integer rankGrade;

	// 试卷编号
	private Long examInfoId;
	
	
	public Integer getRowNum() {
		return rowNum;
	}
	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Double getChineseResult() {
		return chineseResult;
	}
	public void setChineseResult(Double chineseResult) {
		this.chineseResult = chineseResult;
	}
	public Double getMathResult() {
		return mathResult;
	}
	public void setMathResult(Double mathResult) {
		this.mathResult = mathResult;
	}
	public Double getEnglishResult() {
		return englishResult;
	}
	public void setEnglishResult(Double englishResult) {
		this.englishResult = englishResult;
	}
	public Double getMoralityResult() {
		return moralityResult;
	}
	public void setMoralityResult(Double moralityResult) {
		this.moralityResult = moralityResult;
	}
	public Double getHistoryResult() {
		return historyResult;
	}
	public void setHistoryResult(Double historyResult) {
		this.historyResult = historyResult;
	}
	public Double getBiologyResult() {
		return biologyResult;
	}
	public void setBiologyResult(Double biologyResult) {
		this.biologyResult = biologyResult;
	}
	public Double getGeographyResult() {
		return geographyResult;
	}
	public void setGeographyResult(Double geographyResult) {
		this.geographyResult = geographyResult;
	}
	public Double getPhysicsResult() {
		return physicsResult;
	}
	public void setPhysicsResult(Double physicsResult) {
		this.physicsResult = physicsResult;
	}
	public Double getChemistryResult() {
		return chemistryResult;
	}
	public void setChemistryResult(Double chemistryResult) {
		this.chemistryResult = chemistryResult;
	}
	public Double getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(Double totalResult) {
		this.totalResult = totalResult;
	}
	public Integer getRankClass() {
		return rankClass;
	}
	public void setRankClass(Integer rankClass) {
		this.rankClass = rankClass;
	}
	public Integer getRankGrade() {
		return rankGrade;
	}
	public void setRankGrade(Integer rankGrade) {
		this.rankGrade = rankGrade;
	}
	public Long getExamInfoId() {
		return examInfoId;
	}
	public void setExamInfoId(Long examInfoId) {
		this.examInfoId = examInfoId;
	}
	
	
}
