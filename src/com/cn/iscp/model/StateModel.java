package com.cn.iscp.model;

import java.util.ArrayList;
import java.util.List;

import com.cn.common._Const;
import com.cn.common._Tool;

/**
 * 状态对象
 * @author 10011037@qq.com
 * 2017-05-23
 */
public class StateModel {
	
	// 执行的结果码
	private Integer statusCode;
	// 结果提示信息
	private String statusHint;
	// 编号
	private Long keyId;
	// 用户Key
	private String userKey;
	// 数据集合
	private List<?> data;
	
	public StateModel(){};
	
	/**
	 * 请求失败
	 * @param statusHint 失败原因
	 */
	public StateModel(String statusHint){
		this.statusCode = _Const.STATECODE_ERROR;
		this.statusHint = statusHint;
	}
	
	public StateModel(boolean mark) {
		if(mark){
			this.statusCode = _Const.STATECODE_SUCCESS;
			this.statusHint = _Const.STATECODE_SUCCESS_HINT;
		}else{
			this.statusCode = _Const.STATECODE_ERROR;
			this.statusHint = _Const.STATECODE_ERROR_HINT;
		}
	}
	
	public StateModel(List<?> data) {
		this.statusCode = _Const.STATECODE_SUCCESS;
		this.statusHint = _Const.STATECODE_SUCCESS_HINT;
		if(data == null || data.isEmpty() || data.size() < 1){
			data = null;
		}
		this.data = data;
	}
	
	public StateModel(String statusHint, Object data) {
		this.statusCode = _Const.STATECODE_SUCCESS;
		this.statusHint = statusHint;
		if(!_Tool.isEmpty(data)){
			List<Object> list = new ArrayList<Object>();
			list.add(data);
			this.data = list;
		}
	}
	
	public StateModel(Object data) {
		this.statusCode = _Const.STATECODE_SUCCESS;
		this.statusHint = _Const.STATECODE_SUCCESS_HINT;
		if(!_Tool.isEmpty(data)){
			List<Object> list = new ArrayList<Object>();
			list.add(data);
			this.data = list;
		}
	}
	
	public StateModel(Integer statusCode, String statusHint){
		this.statusCode = statusCode;
		this.statusHint = statusHint;
	}
	
	public StateModel(Integer statusCode, String statusHint, Object data){
		this.statusCode = statusCode;
		this.statusHint = statusHint;
		if(!_Tool.isEmpty(data)){
			List<Object> list = new ArrayList<Object>();
			list.add(data);
			this.data = list;
		}
	}

	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusHint() {
		return statusHint;
	}
	public void setStatusHint(String statusHint) {
		this.statusHint = statusHint;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public Long getKeyId() {
		return keyId;
	}
	public void setKeyId(Long keyId) {
		this.keyId = keyId;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
}
