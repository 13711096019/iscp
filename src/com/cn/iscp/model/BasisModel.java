package com.cn.iscp.model;

import com.cn.common._Const;

public class BasisModel {
	
	// 状态(0删除,1正常)
    protected Integer status;
	// 时间戳
    protected Long flagtime;
    
    /**
     * 无参构造函数
     */
    public BasisModel(){};
    
    /**
     * 删除构造函数
     */
    public BasisModel(Integer status){
    	this.status = status;
    	this.flagtime = System.currentTimeMillis();
    }
	
    /**
     * 新增
     */
	public void setInsert() {
    	this.status = _Const.STATE_SUCCESS;
    	this.flagtime = System.currentTimeMillis();
	}
	
    /**
     * 更新
     */
	public void setUpdate() {
    	this.status = _Const.STATE_SUCCESS;
    	this.flagtime = System.currentTimeMillis();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getFlagtime() {
		return flagtime;
	}

	public void setFlagtime(Long flagtime) {
		this.flagtime = flagtime;
	}
    
}
