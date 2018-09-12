package com.cn.iscp.entity.card;

/**
 * 值日标兵对象
 * @author xz
 * 2018-01-11
 */
public class OndutyExample {
	
	// 自增编号
    private Long exampleId;
	// 班级值日对象ID
    private Long ondutyId;
	// 周
    private Integer week;
	// 学生编号集合
    private String studentIds;
    // 学生名字集合
    private String studentNames;
    // 学生编号集合
    private String studyDate;
    
    
    public OndutyExample(){}
    
    public OndutyExample(Long ondutyId,String studentIds){
    	this.ondutyId = ondutyId;
    	this.studentIds = studentIds;
    }
    
	public Long getExampleId() {
		return exampleId;
	}

	public void setExampleId(Long exampleId) {
		this.exampleId = exampleId;
	}

	public Long getOndutyId() {
		return ondutyId;
	}

	public void setOndutyId(Long ondutyId) {
		this.ondutyId = ondutyId;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public String getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(String studentIds) {
		this.studentIds = studentIds;
	}

	public String getStudentNames() {
		return studentNames;
	} 
	
	public void setStudentNames(String studentNames) {
		this.studentNames = studentNames;
	}
	
	public String getStudyDate() {
		return studyDate;
	}
	
	public void setStudyDate(String studyDate) {
		this.studyDate = studyDate;
	}
    
    
    
}
