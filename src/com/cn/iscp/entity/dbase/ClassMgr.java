package com.cn.iscp.entity.dbase;

import com.cn.common._Const;
import com.cn.common._Tool;

/**
 * 班牌机器信息
 * @author 10011037@qq.com
 * 2017-07-11
 */
public class ClassMgr {
	
	// 自增编号
    private Long classMgrId;
	// 机器名称
    private String machineName;
	// 机器编码
    private String machineCode;
	// 机器密码
    private String machinePwd;
	// 安全密码
    private String safePwd;
	// 动态班别编号
    private Long classNum;
	// 班主体编号
    private Long classEntityId;
	// 状态
    private Integer status;
    
	// 班别名称(基础表)
    private String className;
    
    public ClassMgr(){};
    
    public ClassMgr(Long classNum){
    	this.classNum = classNum;
    }
    
    public ClassMgr(String machineCode, String machinePwd, String safePwd){
    	this.machineCode = machineCode;
    	this.machinePwd = machinePwd;
    	this.safePwd = safePwd;
    }
    
    public ClassMgr(String machineCode, Long classNum){
    	this.machineCode = machineCode;
    	this.classNum = classNum;
    }
    
    public ClassMgr(String machineName, String machineCode, Long classNum, Long classEntityId){
    	this.machineName = machineName;
    	this.machineCode = machineCode;
    	this.classNum = classNum;
    	this.classEntityId = classEntityId;
    	this.machinePwd = "e10adc3949ba59abbe56e057f20f883e";
    	this.safePwd = "e10adc3949ba59abbe56e057f20f883e";
    	this.status = _Const.STATE_SUCCESS;
    }
    
    public ClassMgr(String machineCode){
    	this.machineCode = machineCode;
    	this.machinePwd = "e10adc3949ba59abbe56e057f20f883e";
    	this.safePwd = "e10adc3949ba59abbe56e057f20f883e";
    	this.status = _Const.STATE_SUCCESS;
    }
    
    public ClassMgr(Long classMgrId, String machineName, String machinePwd, String safePwd){
    	this.classMgrId = classMgrId;
    	this.machineName = machineName;
    	this.machinePwd = machinePwd;
    	this.safePwd = safePwd;
    }
    
    public ClassMgr(Long classMgrId, Long classNum){
    	this.classMgrId = classMgrId;
    	this.classNum = classNum;
    }
    
	public Long getClassMgrId() {
		return classMgrId;
	}
	public void setClassMgrId(Long classMgrId) {
		this.classMgrId = classMgrId;
	}
	public String getMachineCode() {
		return machineCode;
	}
	public void setMachineCode(String machineCode) {
		this.machineCode = _Tool.toStr(machineCode);
	}
	public String getMachinePwd() {
		return machinePwd;
	}
	public void setMachinePwd(String machinePwd) {
		this.machinePwd = machinePwd;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = _Tool.toStr(className);
	}
	public String getSafePwd() {
		return safePwd;
	}
	public void setSafePwd(String safePwd) {
		this.safePwd = safePwd;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = _Tool.toStr(machineName);
	}
	public Long getClassEntityId() {
		return classEntityId;
	}
	public void setClassEntityId(Long classEntityId) {
		this.classEntityId = classEntityId;
	}
    
}
