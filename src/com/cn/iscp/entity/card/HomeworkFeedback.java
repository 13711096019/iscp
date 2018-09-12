package com.cn.iscp.entity.card;

import com.cn.common._Tool;

/**
 * 家长督导作业对象
 * @author 10011037@qq.com
 * 2017-09-06
 */
public class HomeworkFeedback {
	
	// 自增编号
    private Long feedbackId;
	// 班主体动态年级编号
    private Long classNum;
	// 学年
    private Integer year;
	// 学期
    private Integer termId;
	// 功课日期
    private String studyDate;
	// 学生编号
    private Long studentId;
	// 反馈标记(1=已经反馈，0=未反馈，默认都是 1)
    private Integer feebackMark;
	// 完成标记(1=全部完成 2=部分完成 3=未做)
    private Integer finishMark;
	// 监护人姓名
    private String parentName;
	// 督导时间
    private String feebackTime;
	// 情况描述(未完成作为的原因说明)
    private String feebackNote;

	// 学生姓名
    private String studentName;
	// 学生头像
    private String headPortrait;
	// 反馈标记名称
    private String feebackName;
	// 完成标记名称
    private String finishName;
	// 学生人数
    private Integer studentCount;
    
    public HomeworkFeedback(){};
    
    public HomeworkFeedback(Long classNum, String studyDate){
    	this.classNum = classNum;
    	this.studyDate = studyDate;
    }
    
    public HomeworkFeedback(Long classNum, String studyDate, Long studentId){
    	this.classNum = classNum;
    	this.studyDate = studyDate;
    	this.studentId = studentId;
    }
    
    public HomeworkFeedback(Long classNum, String studyDate, 
    		Integer feebackMark, Integer finishMark){
    	this.classNum = classNum;
    	this.studyDate = studyDate;
    	this.feebackMark = feebackMark;
    	this.finishMark = finishMark;
    }
    
    public HomeworkFeedback(Long classNum, String studyDate, Long studentId,
    		Integer finishMark, String feebackNote, String parentName){
    	this.classNum = classNum;
    	this.studyDate = studyDate;
    	this.studentId = studentId;
    	this.finishMark = finishMark;
    	this.feebackNote = feebackNote;
    	this.parentName = parentName;
    }
    
	public Long getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
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
	public String getStudyDate() {
		return studyDate;
	}
	public void setStudyDate(String studyDate) {
		this.studyDate = _Tool.toStr(studyDate);
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Integer getFeebackMark() {
		return feebackMark;
	}
	public void setFeebackMark(Integer feebackMark) {
		this.feebackMark = feebackMark;
	}
	public Integer getFinishMark() {
		return finishMark;
	}
	public void setFinishMark(Integer finishMark) {
		this.finishMark = finishMark;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = _Tool.toStr(parentName);
	}
	public String getFeebackTime() {
		return feebackTime;
	}
	public void setFeebackTime(String feebackTime) {
		this.feebackTime = _Tool.toStr(feebackTime);
	}
	public String getFeebackNote() {
		return feebackNote;
	}
	public void setFeebackNote(String feebackNote) {
		this.feebackNote = _Tool.toStr(feebackNote);
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = _Tool.toStr(studentName);
	}
	public String getFeebackName() {
		return feebackName;
	}
	public void setFeebackName(String feebackName) {
		this.feebackName = _Tool.toStr(feebackName);
	}
	public String getFinishName() {
		return finishName;
	}
	public void setFinishName(String finishName) {
		this.finishName = _Tool.toStr(finishName);
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = _Tool.toStr(headPortrait);
	}
	public Integer getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	};
	
}
