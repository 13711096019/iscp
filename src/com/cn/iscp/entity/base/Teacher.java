package com.cn.iscp.entity.base;

import java.util.List;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.entity.dbase.SubjectGroup;
import com.cn.iscp.entity.dbase.TeacherSubject;
import com.cn.iscp.entity.ligent.Position;
import com.cn.iscp.model.BasisModel;

/**
 * 教员对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class Teacher extends BasisModel{
	
	// 自增编号
    private Long teacherId;
	// 老师姓名
    private String teacherName;
	// 性别
    private Integer sexId;
	// 出生日期
    private String birthday;
	// 联系电话
    private String mobile;
	// 电子邮箱
    private String email;
	// 头像
    private String headPortrait;
	// 备注
    private String note;
	// 老师标签
    private String teacherLabel;
	// 描述
    private String teacherDesc;
	// 职称
    private String vocation;
	// 教学特色
    private String feature;
	// 工作经历
    private String undergo;
	// 教育理念
    private String idea;

	// 用户唯一标识
    private String userKey;
	// 用户密码
    private String passWord;
	// 胜任课程编号集合
    private String subjectIds;
	// 最小角色等级
    private Integer roleRank;
	// 角色编号
    private String roleIds;
	// 角色名称
    private String roleNames;
	// 班级名称
    private String className;
    // 班级列表
    private List<TeacherSubject> classList;
    // 科组列表
    private List<SubjectGroup> groupList;
    // 职位对象
    private Position position;
    
    
    /**
     * 无参构造函数
     */
	public Teacher(){};
	
	/**
     * 删除
     */
	public Teacher(Long teacherId){
		super(_Const.STATE_ERROR);
    	this.teacherId = teacherId;
	}
	
	/**
	 * 更新时间戳
	 */
	public Teacher(Long teacherId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.teacherId = teacherId;
	}
	
	/**
	 * 更新头像
	 */
	public Teacher(Long teacherId, String headPortrait){
		super.flagtime = System.currentTimeMillis();
    	this.teacherId = teacherId;
    	this.headPortrait = headPortrait;
	}
    
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = _Tool.toStr(teacherName);
	}
	public Integer getSexId() {
		return sexId;
	}
	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = _Tool.toStr(birthday);
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = _Tool.toStr(mobile);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = _Tool.toStr(email);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getSubjectIds() {
		return subjectIds;
	}
	public void setSubjectIds(String subjectIds) {
		this.subjectIds = _Tool.toStr(subjectIds);
	}
	public String getTeacherLabel() {
		return teacherLabel;
	}
	public void setTeacherLabel(String teacherLabel) {
		this.teacherLabel = _Tool.toStr(teacherLabel);
	}
	public String getTeacherDesc() {
		return teacherDesc;
	}
	public void setTeacherDesc(String teacherDesc) {
		this.teacherDesc = _Tool.toStr(teacherDesc);
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<TeacherSubject> getClassList() {
		return classList;
	}
	public void setClassList(List<TeacherSubject> classList) {
		if(classList == null || classList.size() < 1){
			classList = null;
		}
		this.classList = classList;
	}
	public List<SubjectGroup> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<SubjectGroup> groupList) {
		if(groupList == null || groupList.size() < 1){
			groupList = null;
		}
		this.groupList = groupList;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getUndergo() {
		return undergo;
	}
	public void setUndergo(String undergo) {
		this.undergo = undergo;
	}
	public String getIdea() {
		return idea;
	}
	public void setIdea(String idea) {
		this.idea = idea;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public Integer getRoleRank() {
		return roleRank;
	}
	public void setRoleRank(Integer roleRank) {
		this.roleRank = roleRank;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
}