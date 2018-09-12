package com.cn.iscp.entity.base;

import com.cn.iscp.model.BasisModel;

/**
 * 学生监护人对象
 * @author 10011037@qq.com
 * 2017-08-02
 */
public class Guardian extends BasisModel {

	// 自增编号
	private Long guardianId;
	// 学生编号
	private Long studentId;
	// 父母姓名
	private String guardianName;
	// 关系编号（1父亲，2母亲）
	private Integer relationId;
	// 身份证
	private String idCard;
	
	public Long getGuardianId() {
		return guardianId;
	}
	public void setGuardianId(Long guardianId) {
		this.guardianId = guardianId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public Integer getRelationId() {
		return relationId;
	}
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}