package com.cn.iscp.entity.chat;

/**
 * 校信通知
 * @author 10011037@qq.com
 * 2018-04-13
 */
public class Notify {

	// 自增编号
    private Long notifyId;
	// 通知类型(1全校通知,2老师通知,3家长通知)
    private Integer notifyType;
	// 通知标题
    private String notifyTitle;
	// 通知内容
    private String notifyContent;
	// 通知落款
    private String notifyInscribe;
	// 接收用户编号集合
    private String userIds;
	// 发布人编号
    private Long createUserId;
	// 发起时间
    private String createTime;
	// 状态
    private Integer status;

	// 发布人姓名
    private String createUserName;
    
	// 用户Key
    private String userKey;
	// 分页查询-第几页
    private Integer pageCount;
    
    public Notify(){};

    /**
     * 查询
     */
    public Notify(String userKey, Integer pageCount){
    	this.userKey = userKey;
    	this.pageCount = pageCount;
    }

    /**
     * 新增
     */
    public Notify(Integer notifyType, String notifyTitle, String notifyContent, 
    		String notifyInscribe, String userIds, Long createUserId){
    	this.notifyType = notifyType;
    	this.notifyTitle = notifyTitle;
    	this.notifyContent = notifyContent;
    	this.notifyInscribe = notifyInscribe;
    	this.userIds = userIds;
    	this.createUserId = createUserId;
    }
    
    /**
     * 编辑
     */
    public Notify(Long notifyId, String notifyTitle, String notifyContent){
    	this.notifyId = notifyId;
    	this.notifyTitle = notifyTitle;
    	this.notifyContent = notifyContent;
    }
    
    /**
     * 删除
     */
    public Notify(Long notifyId, Long createUserId){
    	this.notifyId = notifyId;
    	this.createUserId = createUserId;
    }
    
	public Long getNotifyId() {
		return notifyId;
	}
	public void setNotifyId(Long notifyId) {
		this.notifyId = notifyId;
	}
	public Integer getNotifyType() {
		return notifyType;
	}
	public void setNotifyType(Integer notifyType) {
		this.notifyType = notifyType;
	}
	public String getNotifyTitle() {
		return notifyTitle;
	}
	public void setNotifyTitle(String notifyTitle) {
		this.notifyTitle = notifyTitle;
	}
	public String getNotifyContent() {
		return notifyContent;
	}
	public void setNotifyContent(String notifyContent) {
		this.notifyContent = notifyContent;
	}
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public Long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getNotifyInscribe() {
		return notifyInscribe;
	}
	public void setNotifyInscribe(String notifyInscribe) {
		this.notifyInscribe = notifyInscribe;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
	
}
