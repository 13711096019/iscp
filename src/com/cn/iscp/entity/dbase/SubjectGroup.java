package com.cn.iscp.entity.dbase;

/**
 * 科组
 * @author 10011037@qq.com
 * 2017-11-17
 */
public class SubjectGroup {

	// 自增编号
    private Long groupId;
	// 年级编号
    private Long gradeId;
	// 科目编号
    private Long subjectId;
	// 老师编号
    private Long teacherId;
	// 是否科组长
    private Integer isLeader;

    // 老师编号列表
    private String teacherIds;
    // 年级名称
    private String gradeName;
    // 科目名称
    private String subjectName;
    // 老师姓名
    private String teacherName;
    // 老师电话
    private String teacherMobile;
    
    public SubjectGroup(){};
    
    public SubjectGroup(Long teacherId){
    	this.teacherId = teacherId;
    }
    
    public SubjectGroup(Long gradeId, Long subjectId, Long teacherId){
    	this.gradeId = gradeId;
    	this.subjectId = subjectId;
    	this.teacherId = teacherId;
    }
    
    public SubjectGroup(String teacherIds, Long gradeId, Long subjectId){
    	this.gradeId = gradeId;
    	this.subjectId = subjectId;
    	this.teacherIds = teacherIds;
    }
    
    public SubjectGroup(Long gradeId, Long subjectId, Long teacherId, Integer isLeader){
    	this.gradeId = gradeId;
    	this.subjectId = subjectId;
    	this.teacherId = teacherId;
    	this.isLeader = isLeader;
    }

	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(Integer isLeader) {
		this.isLeader = isLeader;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherMobile() {
		return teacherMobile;
	}
	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}
	public String getTeacherIds() {
		return teacherIds;
	}
	public void setTeacherIds(String teacherIds) {
		this.teacherIds = teacherIds;
	}
    
}
