package com.cn.iscp.entity.auth;

import java.util.List;

/**
 * 登录账户对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class CatalogTree {

	// 系统编号
    private Long systemId;
	// 菜单编号
    private Long menuId;
	// 栏目编号
    private Long catalogId;
	// 栏目代码
    private String catalogCode;
	// 栏目名称
    private String catalogName;
	// 栏目标题
    private String catalogTitle;
	// 父级栏目编号
    private Long parentId;
	// 页面路径
    private String pagePath;
	// 创建日期
    private String createDate;
	// 对象类型(1一级页面,2二级页面,3上面按钮,4中间按钮,5下面按钮)
    private Integer objectTypeId;
	// 对象层次
    private Integer objectLevel;
	// 是否可用
    private Integer inUsed;
	// 点击事件关键字
    private String eventKey;
	// 排序
    private Integer sort;
	// 显示图标
    private String icon;
	// 备注
    private String note;

	// 登录账号
	private String userAccount;
	// 子菜单
	private List<CatalogTree> childList;
    
	public CatalogTree(){};
	
	/**
	 * 获取权限列表
	 */
	public CatalogTree(String userAccount, Integer objectLevel, String catalogCode){
		this.userAccount = userAccount;
		this.objectLevel = objectLevel;
		this.catalogCode = catalogCode;
	}
	 
    
	public Long getSystemId() {
		return systemId;
	}
	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Long getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}
	public String getCatalogCode() {
		return catalogCode;
	}
	public void setCatalogCode(String catalogCode) {
		this.catalogCode = catalogCode;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public String getCatalogTitle() {
		return catalogTitle;
	}
	public void setCatalogTitle(String catalogTitle) {
		this.catalogTitle = catalogTitle;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getPagePath() {
		return pagePath;
	}
	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getObjectTypeId() {
		return objectTypeId;
	}
	public void setObjectTypeId(Integer objectTypeId) {
		this.objectTypeId = objectTypeId;
	}
	public Integer getObjectLevel() {
		return objectLevel;
	}
	public void setObjectLevel(Integer objectLevel) {
		this.objectLevel = objectLevel;
	}
	public Integer getInUsed() {
		return inUsed;
	}
	public void setInUsed(Integer inUsed) {
		this.inUsed = inUsed;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public List<CatalogTree> getChildList() {
		return childList;
	}
	public void setChildList(List<CatalogTree> childList) {
		this.childList = childList;
	}
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
    
	
}
