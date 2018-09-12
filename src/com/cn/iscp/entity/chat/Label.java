package com.cn.iscp.entity.chat;

import java.util.List;

import com.cn.common._Tool;
import com.cn.iscp.entity.auth.User;

/**
 * 通讯录标签对象
 * @author 10011037@qq.com
 * 2017-11-10
 */
public class Label {
	
	// 自增编号
    private Long labelId;
	// 用户编号
    private Long userId;
	// 标签名称
    private String labelName;
	// 创建时间
    private String createTime;
    
    // 朋友编号列表
    private String friendIds;
    // 朋友姓名列表
    private String friendNames;
    // 朋友数量
    private Integer friendCount;
    // 用户列表
    private List<User> userList;
    
    public Label(){};
    
    /**
     * 新增
     */
    public Label(Long userId, String labelName, String friendIds){
    	this.userId = userId;
    	if(!_Tool.isEmpty(labelName)){
        	this.labelName = labelName.trim();
    	}
    	this.friendIds = friendIds;
    }
    
    /**
     * 编辑
     */
    public Label(String labelName, Long labelId, String friendIds){
    	this.labelId = labelId;
    	this.labelName = labelName;
    	this.friendIds = friendIds;
    }
    
    /**
     * 删除
     */
    public Label(Long labelId){
    	this.labelId = labelId;
    }
    
	public Long getLabelId() {
		return labelId;
	}
	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getFriendIds() {
		return friendIds;
	}
	public void setFriendIds(String friendIds) {
		this.friendIds = friendIds;
	}
	public String getFriendNames() {
		return friendNames;
	}
	public void setFriendNames(String friendNames) {
		this.friendNames = friendNames;
	}
	public Integer getFriendCount() {
		return friendCount;
	}
	public void setFriendCount(Integer friendCount) {
		this.friendCount = friendCount;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
    
    
}
