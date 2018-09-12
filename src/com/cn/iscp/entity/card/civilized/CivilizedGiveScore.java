package com.cn.iscp.entity.card.civilized;

import com.cn.common._Tool;

/**
 * 班级创文评分表
 * @author 10011037@qq.com
 * 2017-09-08
 */
public class CivilizedGiveScore {
	
	// 自增编号
    private Long scoreId;
	// 动态班级编号
    private Long classNum;
	// 评分人类别(1=行政，2=值日老师，3=值日学生)【3类人评分然后取平均值，才是当然某班的各项的得分值】
    private Integer raterType;
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
	// 创文评分大项编号
    private Long bigItemId;
	// 创文评分细项编号
    private Long smallItemId;
	// 创文评分细项排序
    private Integer smallItemSort;
	// 各项排序
    private Integer allItemSort;
	// 评分值
    private Double score;
	// 是否被一票否决（1=是，0=否）,只要有一项，则本次评分为0
    private Integer isOneNoteVeto;
	// 备注
    private String note;
	// 上传时间
    private String uploadTime;
	// 上传人
    private Long uploadUserId;

	// 公告编号
    private Long noticeId;
	// 根规则
    private String bigItem;
	// 子规则
    private String smallItem;
	// 上传老师姓名
    private String teacherName;
    
    public CivilizedGiveScore(){};
    
    /**
     * 老师端-获取所有创文评分规则
     */
    public CivilizedGiveScore(Long classNum, Integer raterType, String studyDate){
    	this.classNum = classNum;
    	this.raterType = raterType;
    	this.studyDate = studyDate;
    }
    
    /**
     * 老师端-添加评分信息
     */
    public CivilizedGiveScore(Long classNum, Integer raterType, String studyDate, 
    		Long smallItemId, Double score, Long uploadUserId){
    	this.classNum = classNum;
    	this.raterType = raterType;
    	this.studyDate = studyDate;
    	this.smallItemId = smallItemId;
    	this.score = score;
    	this.uploadUserId = uploadUserId;
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
	public Integer getRaterType() {
		return raterType;
	}
	public void setRaterType(Integer raterType) {
		this.raterType = raterType;
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
	public Long getBigItemId() {
		return bigItemId;
	}
	public void setBigItemId(Long bigItemId) {
		this.bigItemId = bigItemId;
	}
	public Long getSmallItemId() {
		return smallItemId;
	}
	public void setSmallItemId(Long smallItemId) {
		this.smallItemId = smallItemId;
	}
	public Integer getSmallItemSort() {
		return smallItemSort;
	}
	public void setSmallItemSort(Integer smallItemSort) {
		this.smallItemSort = smallItemSort;
	}
	public Integer getAllItemSort() {
		return allItemSort;
	}
	public void setAllItemSort(Integer allItemSort) {
		this.allItemSort = allItemSort;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public Long getUploadUserId() {
		return uploadUserId;
	}
	public void setUploadUserId(Long uploadUserId) {
		this.uploadUserId = uploadUserId;
	}
	public String getBigItem() {
		return bigItem;
	}
	public void setBigItem(String bigItem) {
		this.bigItem = bigItem;
	}
	public String getSmallItem() {
		return smallItem;
	}
	public void setSmallItem(String smallItem) {
		this.smallItem = smallItem;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Integer getIsOneNoteVeto() {
		return isOneNoteVeto;
	}
	public void setIsOneNoteVeto(Integer isOneNoteVeto) {
		this.isOneNoteVeto = isOneNoteVeto;
	}
	public Long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}
	
    
}
