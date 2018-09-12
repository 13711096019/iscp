package com.cn.iscp.entity.card.exam;

import com.cn.common._Tool;

/**
 * 测验成绩信息表
 * @author 10011037@qq.com
 * 2017-07-31
 */
public class ExamScoreInput {

	// 自增编号
    private Long scoreId;
	// 考试编号
    private Long examInfoId;
	// 试卷编号
    private Long examPaperId;
	/*// 测验编号
    private Long examId;*/
	// 学生编号
    private Long studentId;
	// 考试成绩
    private Double examResult;
	// 备注
    private String note;
    
	// 学生姓名
    private String studentName;
	// 学生编号
    private String studentNum;
	// 动态班级编号
    private Long classNum;
	// 成绩列表
    private String examResults;
    
    public ExamScoreInput(){};
    
    public ExamScoreInput(Long classNum, Long examPaperId, String examResults){
    	this.classNum = classNum;
    	this.examPaperId = examPaperId;
    	this.examResults = examResults;
    }
    
	public Long getScoreId() {
		return scoreId;
	}
	public void setScoreId(Long scoreId) {
		this.scoreId = scoreId;
	}
	/*public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}*/
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Double getExamResult() {
		return examResult;
	}
	public void setExamResult(Double examResult) {
		this.examResult = examResult;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = _Tool.toStr(studentName);
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = _Tool.toStr(studentNum);
	}
	public String getExamResults() {
		return examResults;
	}
	public void setExamResults(String examResults) {
		this.examResults = _Tool.toStr(examResults);
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
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	
}
