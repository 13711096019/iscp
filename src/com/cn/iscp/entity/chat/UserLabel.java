package com.cn.iscp.entity.chat;


/**
 * 通讯录好友标签关系对象
 * @author 10011037@qq.com
 * 2017-11-10
 */
public class UserLabel {
	
	// 自增编号
    private Long tlId;
	// 标签编号
    private Long labelId;
	// 用户编号
    private Long userId;
	// 好友编号
    private Long friendId;
	// 创建时间
    private String createTime;
    
	// 标签列表
    private String labelIds;
    
    public UserLabel(){};
    
    public UserLabel(Long labelId, Long userId){
    	this.labelId = labelId;
    	this.userId = userId;
    }
    
    public UserLabel(Long userId, Long friendId, String labelIds){
    	this.userId = userId;
    	this.friendId = friendId;
    	this.labelIds = labelIds;
    }
    
    /*public TeacherLabel(Long labelId, Long teacherId, Long friendId){
    	this.labelId = labelId;
    	this.teacherId = teacherId;
    	this.friendId = friendId;
    	this.createTime = DateUtil.getStrByDate(null, null);
    }*/
    
	public Long getTlId() {
		return tlId;
	}
	public void setTlId(Long tlId) {
		this.tlId = tlId;
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
	public Long getFriendId() {
		return friendId;
	}
	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLabelIds() {
		return labelIds;
	}
	public void setLabelIds(String labelIds) {
		this.labelIds = labelIds;
	}
    
}
