package com.cn.iscp.entity.base;

import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 老师资质证对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class Qualification extends BasisModel{
	
	// 自增编号
    private Long tqId;
	// 老师编号
    private Long teacherId;
	// 资格证书
    private String centificate;
	// 有效期
    private String termOfValidity;
	// 备注
    private String note;

	// 老师姓名
    private String teacherName;
	// 是否过期(1过期,0没过期)
    private Integer isExpire;
    
    
    /**
     * 无参构造函数
     */
	public Qualification(){};
	
	/**
	 * 更新时间戳
	 */
	public Qualification(Long teacherId, String centificate, String termOfValidity, String note){
    	this.teacherId = teacherId;
    	this.centificate = centificate;
    	this.termOfValidity = termOfValidity;
    	this.note = note;
		super.flagtime = System.currentTimeMillis();
	}
    
	public Long getTqId() {
		return tqId;
	}
	public void setTqId(Long tqId) {
		this.tqId = tqId;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getCentificate() {
		return centificate;
	}
	public void setCentificate(String centificate) {
		this.centificate = _Tool.toStr(centificate);
	}
	public String getTermOfValidity() {
		return termOfValidity;
	}
	public void setTermOfValidity(String termOfValidity) {
		this.termOfValidity = _Tool.toStr(termOfValidity);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = _Tool.toStr(teacherName);
	}
	public Integer getIsExpire() {
		return isExpire;
	}
	public void setIsExpire(Integer isExpire) {
		this.isExpire = isExpire;
	}

    
}