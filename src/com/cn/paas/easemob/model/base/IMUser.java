package com.cn.paas.easemob.model.base;

public class IMUser {
	
	private String userNum;
	private String userName;
	private String password;
	
	/**
	 * 修改密码
	 */
	public IMUser(String userNum, String password) {
		this.userNum = userNum;
		this.password = password;
	}

	/**
	 * 新增用户
	 */
	public IMUser(String userNum, String userName, String password) {
		this.userNum = userNum;
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
