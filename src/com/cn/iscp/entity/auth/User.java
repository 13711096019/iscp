package com.cn.iscp.entity.auth;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 登录账户对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class User extends BasisModel{
	
	// 自增编号(老师/学生可以根据自增编号关联)
    private Long userId;
	// 帐号(老师)
    private String account;
	// 用户唯一标识(环信注册账号)
    private String userKey;
	// 姓名
    private String userName;
	// 昵称
    private String nickName;
	// 手机(老师/家长可以根据手机号关联)
    private String mobile;
	// 密码(老师)
    private String password;
	// 登录帐号类型
    private Integer accountType;
	// 用户角色(1学生，2老师)
    private Integer userType;
    //用户集合
    private String userNames;
    
	// 头像
    private String headPortrait;
	// 用户性别
    private Integer sexId;
	// 标签列表
    private String labelNames;
    
    /**
     * 无参构造函数
     */
	public User(){};
	
	/**
     * 删除
     */
	public User(Long userId){
		super(_Const.STATE_ERROR);
    	this.userId = userId;
	}
	
	/**
	 * 更新时间戳
	 */
	public User(Long userId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.userId = userId;
	}
	
	/**
	 * 更新密码
	 */
	public User(Long userId, String account, String password){
		this.userId = userId;
		this.account = account;
    	this.password = password;
	}
	
	/**
	 * 更新
	 */
	public User(Long userId, String userName, Integer status){
		super.status = status;
		super.flagtime = System.currentTimeMillis();
    	this.userId = userId;
    	this.userName = userName;
    	this.nickName = userName;
	}
    
	public String getUserNames() {
		return userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = _Tool.toStr(userName);
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = _Tool.toStr(nickName);
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = _Tool.toStr(mobile);
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = _Tool.toStr(password);
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public Integer getSexId() {
		return sexId;
	}
	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}
	public String getLabelNames() {
		return labelNames;
	}
	public void setLabelNames(String labelNames) {
		this.labelNames = labelNames;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
    
}
