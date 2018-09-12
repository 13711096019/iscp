package com.cn.iscp.entity.base;

import java.util.List;

import com.cn.iscp.model.BasisModel;

/**
 * 家长对象
 * @author 10011037@qq.com
 * 2018-01-24
 */
public class Patriarch extends BasisModel{
	
	// 自增编号
    private Long patriarchId;
	// 老师姓名
    private String patriarchName;
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
    private String motto;
	// 老师账号
    private String logAccount;
	// 老师密码
    private String logPassword;
    

	// 学生编号
    private Long studentId;
	// 学生姓名
    private String studentName;
	// 学生身份证
    private String studentIdCard;
	// 年级名称
    private String gradeName;
	// 班级名称
    private String className;
    // 学生列表
    private List<Student> studentList;
    
    public Patriarch(){};

    /**
     * 家长登录
     */
    public Patriarch(String logAccount, String logPassword){
    	this.logAccount = logAccount;
    	this.logPassword = logPassword;
    }
    
    /**
     * 家长绑定学生信息(手机端)
     */
    public Patriarch(String studentName, String studentIdCard, 
    		String logAccount, String logPassword, String headPortrait){
    	this.studentName = studentName;
    	this.studentIdCard = studentIdCard;
    	this.logAccount = logAccount;
    	this.logPassword = logPassword;
    	this.headPortrait = headPortrait;
    }
    
    /**
     * 修改头像
     */
    public Patriarch(Long patriarchId, String headPortrait){
    	this.flagtime = System.currentTimeMillis();
    	this.patriarchId = patriarchId;
    	this.headPortrait = headPortrait;
    }
    
    
	public Long getPatriarchId() {
		return patriarchId;
	}
	public void setPatriarchId(Long patriarchId) {
		this.patriarchId = patriarchId;
	}
	public String getPatriarchName() {
		return patriarchName;
	}
	public void setPatriarchName(String patriarchName) {
		this.patriarchName = patriarchName;
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
		this.birthday = birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentIdCard() {
		return studentIdCard;
	}
	public void setStudentIdCard(String studentIdCard) {
		this.studentIdCard = studentIdCard;
	}
	public String getLogAccount() {
		return logAccount;
	}
	public void setLogAccount(String logAccount) {
		this.logAccount = logAccount;
	}
	public String getLogPassword() {
		return logPassword;
	}
	public void setLogPassword(String logPassword) {
		this.logPassword = logPassword;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
    
	
}