package com.cn.iscp.model;

import com.cn.common._Tool;

/**
 * 推送对象
 * @author 10011037@qq.com
 * 2017-08-12
 */
public class PushModel {
	
	// 动态班级编号
	private Long classNum;
	// 班牌终端机器码
	private String machineCode;
	// 用户Key
	private String userKey;
	// 用户类型(1家长,2老师)
	private Integer userType;
	// 主键编号
	private String keyId;
	
	
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public String getMachineCode() {
		return machineCode;
	}
	public void setMachineCode(String machineCode) {
		this.machineCode = _Tool.toStr(machineCode);
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = _Tool.toStr(userKey);
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	
}
