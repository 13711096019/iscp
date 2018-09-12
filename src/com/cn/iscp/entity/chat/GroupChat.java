package com.cn.iscp.entity.chat;

import java.util.List;

import com.cn.iscp.entity.auth.User;


/**
 * 群聊对象
 * @author xz
 * 2018-01-08
 */
public class GroupChat {
	
	// 自增编号
    private Long groupchatId;
    // 群编号
    private String groupId;
	// 群名称
    private String groupName;
	// 群成员
    private String userIds;
    // 群公告
    private String flockNotice;
    // 是否允许群成员邀请进群
    private Integer allowInvite;
    
    // 群成员列表
    private List<User> userlist;
    
    /**
     * 无参构造函数
     */
	public GroupChat(){}
	
    /**
     * 新增
     */
	public GroupChat(String groupId, String groupName, String userIds, 
			String flockNotice, Integer allowInvite){
		this.groupId = groupId;
		this.groupName = groupName;
		this.userIds = userIds;
		this.flockNotice = flockNotice;
		this.allowInvite = allowInvite;
	}
	
	/**
     * 更新
     */
	public GroupChat(String groupName,String userIds, String flockNotice){
		this.groupName = groupName;
		this.userIds = userIds;
		this.flockNotice = flockNotice;
	}
	
	 /**
     * 删除
     */
	public GroupChat(String groupId){
		this.groupId = groupId;
	}
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public Long getGroupchatId() {
		return groupchatId;
	}
	public void setGroupchatId(Long groupchatId) {
		this.groupchatId = groupchatId;
	}
	public String getGroupName() {
		return groupName;
	}
	public String getFlockNotice() {
		return flockNotice;
	}
	public void setFlockNotice(String flockNotice) {
		this.flockNotice = flockNotice;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public Integer getAllowInvite() {
		return allowInvite;
	}
	public void setAllowInvite(Integer allowInvite) {
		this.allowInvite = allowInvite;
	}
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

}
