package com.cn.iscp.entity.card;


/**
 * 班级作业确认对象
 * @author xz
 * 2017-09-01
 */
public class HomeworkScore {
	
	// 自增编号
    private Long homeworkscoreId;
	// 班主体动态年级编号
    private Long classEntityUpgradeId;
	// 学生编号
    private Long studentId;
	// 作业编号
    private Long homeworkId;
	// 完成标志（1是为完成2是已经完成）
    private Long finishMark;
	// 完成时间
    private String finishTime;
	// 确认时间
    private String confirmTime;
	// 家长名称
    private String parentName;
	// 分数
    private String score;
    // 备注
    private String note;
    
    public HomeworkScore(){}
    
    //确认（新增）
    public HomeworkScore(Long homeworkscoreId, Long classEntityUpgradeId, Long studentId, Long homeworkId,Long finishMark,String finishTime,String confirmTime,String parentName,String note){
    	this.homeworkscoreId = homeworkscoreId;
    	this.classEntityUpgradeId = classEntityUpgradeId;
    	this.studentId = studentId;
    	this.homeworkId = homeworkId;
    	this.finishMark = finishMark;
    	this.finishTime = finishTime;
    	this.confirmTime = confirmTime;
    	this.parentName = parentName;
    	this.note=note;
    }

	public Long getHomeworkscoreId() {
		return homeworkscoreId;
	}

	public void setHomeworkscoreId(Long homeworkscoreId) {
		this.homeworkscoreId = homeworkscoreId;
	}

	public Long getClassEntityUpgradeId() {
		return classEntityUpgradeId;
	}

	public void setClassEntityUpgradeId(Long classEntityUpgradeId) {
		this.classEntityUpgradeId = classEntityUpgradeId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(Long homeworkId) {
		this.homeworkId = homeworkId;
	}

	public Long getFinishMark() {
		return finishMark;
	}

	public void setFinishMark(Long finishMark) {
		this.finishMark = finishMark;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(String confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	};

    
    
}
