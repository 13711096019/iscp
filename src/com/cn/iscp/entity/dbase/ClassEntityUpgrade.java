package com.cn.iscp.entity.dbase;

import com.cn.common._Tool;

/**
 * 班主体动态年级对象
 * @author 10011037@qq.com
 * 2017-07-10
 */
public class ClassEntityUpgrade {
	
	// 自增编号
    private Long classNum;
	// 班主体编号
    private Long classEntityId;
	// 学年编号
    private Long schoolYearId;
	// 学年度编号
    private Long termId;
	// 年级编号（历史）
    private Long gradeId;
	// 班别编号（历史）
    private Long classId;
	// 班主任编号（历史）
    private Long teacherId;
	// 状态
    private Integer status;
	// 备注
    private String note;
	// 学生人数
    private Integer totalCount;
	// 男生人数
    private Integer maleCount;
	// 女生人数
    private Integer femaleCount;
	// 小组数量
    private Integer smallGroupCount;
	// 大组数量
    private Integer bigGroupGount;
	// 座位行数
    private Integer seatRowCount;
	// 座位列数
    private Integer seatColCount;
	// 
    private Integer isUpdating;

	// 班级名称
    private String className;
	// 学年度名称
    private String termName;
	// 班主任名字
    private String teacherName;
	// 班主任电话
    private String teacherMobile;
	// 班主任头像
    private String headPortrait;
	// 是否为文明班(1是,0否)
    private Integer isCivilizedClass;
	// 文明班排名
    private Integer honorsSort;
	// 系统更新编号
    private Long apkId;
    
    public ClassEntityUpgrade(){};
    
    public ClassEntityUpgrade(Long classNum, Long classEntityId){
    	this.classNum = classNum;
    	this.classEntityId = classEntityId;
    }
    
	
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
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
	public Long getTermId() {
		return termId;
	}
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
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
		this.note = _Tool.toStr(note);
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = _Tool.toStr(className);
	}
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = _Tool.toStr(termName);
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = _Tool.toStr(teacherName);
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
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getMaleCount() {
		return maleCount;
	}
	public void setMaleCount(Integer maleCount) {
		this.maleCount = maleCount;
	}
	public Integer getFemaleCount() {
		return femaleCount;
	}
	public void setFemaleCount(Integer femaleCount) {
		this.femaleCount = femaleCount;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = _Tool.toStr(headPortrait);
	}
	public String getTeacherMobile() {
		return teacherMobile;
	}
	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = _Tool.toStr(teacherMobile);
	}
	public Integer getIsCivilizedClass() {
		return isCivilizedClass;
	}
	public void setIsCivilizedClass(Integer isCivilizedClass) {
		this.isCivilizedClass = isCivilizedClass;
	}
	public Integer getHonorsSort() {
		return honorsSort;
	}
	public void setHonorsSort(Integer honorsSort) {
		this.honorsSort = honorsSort;
	}
	public Long getApkId() {
		return apkId;
	}
	public void setApkId(Long apkId) {
		this.apkId = apkId;
	}
	public Integer getIsUpdating() {
		return isUpdating;
	}
	public void setIsUpdating(Integer isUpdating) {
		this.isUpdating = isUpdating;
	}
	
}
