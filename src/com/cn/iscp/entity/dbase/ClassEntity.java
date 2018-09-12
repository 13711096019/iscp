package com.cn.iscp.entity.dbase;

import com.cn.common._Tool;

/**
 * 班主体对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class ClassEntity {
	
	// 自增编号
    private Long classEntityId;
	// 学年编号
    private Long schoolYearId;
	// 学年度编号
    private Long termId;
	// 年级编号(基础表)
    private Long gradeId;
	// 班别编号(基础表)
    private Long classId;
	// 班别编号(当前)
    private Long classNum;
	// 班级位置编号
    private Long classRoomId;
	// 班主任编号(当前)
    private Long teacherId;
	// 状态 1=有效，0=无效（已经升级到尽头的班，林如小学 6年级无法再升到7年级）
    private Integer status;
	// 默认视频
    private Long defaultVideo;
	// 小组数量
    private Integer smallGroupCount;
	// 大组数量
    private Integer bigGroupGount;
	// 座位行数
    private Integer seatRowCount;
	// 座位列数
    private Integer seatColCount;
	// 升年级次数
    private Integer upgradeCount;
	// 是否毕业（1=毕业【不再升级】，0=未毕业）
    private Integer isFinishSchool;
	// 毕业年份
    private Integer finishYear;
	// 备注
    private String note;

	// 班级名称
    private String className;
	// 教师姓名
    private String teacherName;
	// 教师头像
    private String headPortrait;
	// 学生人数
    private Integer studentCount;
	// 固定不变的虚拟班（从t_base_class 拷贝一次，以后不能删除，也不能升级）
    private Integer isVirtual;
    
    public ClassEntity(){};
    
    public ClassEntity(Long teacherId){
    	this.teacherId = teacherId;
    }
    
    public ClassEntity(Long teacherId, Long gradeId){
    	this.teacherId = teacherId;
    	this.gradeId = gradeId;
    }
    
    public ClassEntity(Long classNum, Integer smallGroupCount){
    	this.classNum = classNum;
    	this.smallGroupCount = smallGroupCount;
    }

    public ClassEntity(Long classNum, Long classRoomId, Long teacherId, Long defaultVideo){
    	this.classNum = classNum;
    	this.classRoomId = classRoomId;
    	this.teacherId = teacherId;
    	this.defaultVideo = defaultVideo;
    }
    
    
	public Long getClassEntityId() {
		return classEntityId;
	}
	public void setClassEntityId(Long classEntityId) {
		this.classEntityId = classEntityId;
	}
	public Long getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Long schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = _Tool.toStr(className);
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = _Tool.toStr(teacherName);
	}
	public Integer getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = _Tool.toStr(headPortrait);
	}
	public Integer getSmallGroupCount() {
		return smallGroupCount;
	}
	public void setSmallGroupCount(Integer smallGroupCount) {
		this.smallGroupCount = smallGroupCount;
	}
	public Integer getBigGroupGount() {
		return bigGroupGount;
	}
	public void setBigGroupGount(Integer bigGroupGount) {
		this.bigGroupGount = bigGroupGount;
	}
	public Integer getSeatRowCount() {
		return seatRowCount;
	}
	public void setSeatRowCount(Integer seatRowCount) {
		this.seatRowCount = seatRowCount;
	}
	public Integer getSeatColCount() {
		return seatColCount;
	}
	public void setSeatColCount(Integer seatColCount) {
		this.seatColCount = seatColCount;
	}
	public Long getClassRoomId() {
		return classRoomId;
	}
	public void setClassRoomId(Long classRoomId) {
		this.classRoomId = classRoomId;
	}
	public Long getTermId() {
		return termId;
	}
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getDefaultVideo() {
		return defaultVideo;
	}
	public void setDefaultVideo(Long defaultVideo) {
		this.defaultVideo = defaultVideo;
	}
	public Integer getUpgradeCount() {
		return upgradeCount;
	}
	public void setUpgradeCount(Integer upgradeCount) {
		this.upgradeCount = upgradeCount;
	}
	public Integer getIsFinishSchool() {
		return isFinishSchool;
	}
	public void setIsFinishSchool(Integer isFinishSchool) {
		this.isFinishSchool = isFinishSchool;
	}
	public Integer getFinishYear() {
		return finishYear;
	}
	public void setFinishYear(Integer finishYear) {
		this.finishYear = finishYear;
	}
	public Integer getIsVirtual() {
		return isVirtual;
	}
	public void setIsVirtual(Integer isVirtual) {
		this.isVirtual = isVirtual;
	}
	
}
