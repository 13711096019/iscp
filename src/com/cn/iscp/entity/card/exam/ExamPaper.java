package com.cn.iscp.entity.card.exam;

import java.util.List;


/**
 * 考试试卷信息表
 * @author 10011037@qq.com
 * 2018-01-08
 */
public class ExamPaper {

	// 自增编号
	private Long examPaperId;
	// 考试编号
	private Long examInfoId;
	// 学年编号
    private Long gradeId;
	// 学年编号
    private Long subjectId;
	// 试卷标题
    private String title;
	// 监考老师
    private String moniterTeach;
	// 满分
    private Integer fullScore;
	// 优良分
    private Integer excellentScore;
	// 及格分
    private Integer passScore;
	// 考试日期
	private String examTime;
	// 开始时间
	private String startTime;
	// 结束时间
	private String endTime;
	// 考试时长(分钟)
    private Integer minutesCountOfExam;
	// 创建时间
	private String createTime;
	// 试卷状态(1统计完毕,2待分配,3待考试,4待评卷,5待统计)
	private Integer examPaperState;
	// 删除状态
	private Integer status;
	// 备注
	private String note;

	// 允许推送本次考试提醒到班牌上(1=需要推送，0=不需要推送)
	private Integer allowPush;
	// 年级名称
    private String gradeName;
	// 科目名称
    private String subjectName;
	// 试卷类型
    private String examTypeName;
	// 考试试室编号
    private String classNo;
    // 座位表
    List<ExamDescSeating> seatingList;
    
    
    
	public Long getExamPaperId() {
		return examPaperId;
	}
	public void setExamPaperId(Long examPaperId) {
		this.examPaperId = examPaperId;
	}
	public Long getExamInfoId() {
		return examInfoId;
	}
	public void setExamInfoId(Long examInfoId) {
		this.examInfoId = examInfoId;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public Integer getFullScore() {
		return fullScore;
	}
	public void setFullScore(Integer fullScore) {
		this.fullScore = fullScore;
	}
	public Integer getExcellentScore() {
		return excellentScore;
	}
	public void setExcellentScore(Integer excellentScore) {
		this.excellentScore = excellentScore;
	}
	public Integer getPassScore() {
		return passScore;
	}
	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
		this.note = note;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public Integer getMinutesCountOfExam() {
		return minutesCountOfExam;
	}
	public void setMinutesCountOfExam(Integer minutesCountOfExam) {
		this.minutesCountOfExam = minutesCountOfExam;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getExamPaperState() {
		return examPaperState;
	}
	public void setExamPaperState(Integer examPaperState) {
		this.examPaperState = examPaperState;
	}
	public String getMoniterTeach() {
		return moniterTeach;
	}
	public void setMoniterTeach(String moniterTeach) {
		this.moniterTeach = moniterTeach;
	}
	public Integer getAllowPush() {
		return allowPush;
	}
	public void setAllowPush(Integer allowPush) {
		this.allowPush = allowPush;
	}
	public List<ExamDescSeating> getSeatingList() {
		return seatingList;
	}
	public void setSeatingList(List<ExamDescSeating> seatingList) {
		this.seatingList = seatingList;
	}
    
}
