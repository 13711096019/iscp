package com.cn.iscp.entity.card.exam;

import com.cn.common._Const;
import com.cn.unit.utils.DateUtil;

/**
 * 考试信息表
 * @author 10011037@qq.com
 * 2018-01-08
 */
public class ExamInfo {

	// 自增编号
	private Long examInfoId;
	// 考试座位表模板编号
	private Long tempId;
	// 学年编号
    private Long schoolYearId;
	// 学年度
	private Integer termId;
	// 月份
	private Integer month;
	// 考试月份
	private String examMonth;
	// 试卷类型(1=月考、2=期末考、3=中段考、4=平时测验)
	private Long examType;
	// 年级编号
	private Long gradeId;
	// 试卷标题
	private String title;
	// 允许推送本次考试提醒到班牌上(1=需要推送，0=不需要推送)
	private Integer allowPush;
	// 提前X分钟推送提醒(allowPush=1时有效)
	private Integer minutesCountInAdvance;
	// 创建时间
	private String createTime;
	// 备注
	private String note;
	// 上传人
    private Long uploadUserId;
	// 满分
    private Integer fullScore;
	// 优良分
    private Integer excellentScore;
	// 及格分
    private Integer passScore;
	// 试卷状态(1统计完毕,2待考试,3待评卷,4待统计)
	private Integer examInfoState;
	// 试卷状态
	private Integer status;
	
	// 年级名称
    private String gradeName;
	// 试卷类型名称
    private String examTypeName;
	// 座位表模板标题
    private String tempTitle;
    
    public ExamInfo(){};
    
    public ExamInfo(Long examInfoId){
    	this.examInfoId = examInfoId;
    	this.status = _Const.STATE_ERROR;
    }
    
    public ExamInfo(Long examType, Long gradeId, String examMonth){
    	this.examType = examType;
    	this.gradeId = gradeId;
    	this.examMonth = examMonth;
    	this.month = DateUtil.getGoalFormat(examMonth+"-01", "month");
    }
    
	
	public Long getExamInfoId() {
		return examInfoId;
	}
	public void setExamInfoId(Long examInfoId) {
		this.examInfoId = examInfoId;
	}
	public Long getTempId() {
		return tempId;
	}
	public void setTempId(Long tempId) {
		this.tempId = tempId;
	}
	public Long getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Long schoolYearId) {
		this.schoolYearId = schoolYearId;
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
	public Long getExamType() {
		return examType;
	}
	public void setExamType(Long examType) {
		this.examType = examType;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Long getUploadUserId() {
		return uploadUserId;
	}
	public void setUploadUserId(Long uploadUserId) {
		this.uploadUserId = uploadUserId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	public String getTempTitle() {
		return tempTitle;
	}
	public void setTempTitle(String tempTitle) {
		this.tempTitle = tempTitle;
	}
	public Integer getAllowPush() {
		return allowPush;
	}
	public void setAllowPush(Integer allowPush) {
		this.allowPush = allowPush;
	}
	public Integer getMinutesCountInAdvance() {
		return minutesCountInAdvance;
	}
	public void setMinutesCountInAdvance(Integer minutesCountInAdvance) {
		this.minutesCountInAdvance = minutesCountInAdvance;
	}
	public Integer getExamInfoState() {
		return examInfoState;
	}
	public void setExamInfoState(Integer examInfoState) {
		this.examInfoState = examInfoState;
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
	public String getExamMonth() {
		return examMonth;
	}
	public void setExamMonth(String examMonth) {
		this.examMonth = examMonth;
	}
	
}
