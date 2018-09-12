package com.cn.iscp.entity.auth;

/**
 * 用户角色关系对象
 * @author 10011037@qq.com
 * 2017-12-11
 */
public class RoleUser {

	// 自增编号
    private Long nexusId;
	// 角色编号
    private Long roleId;
	// 用户编号
    private Long userId;
	// 描述
    private String note;
	// (-1)用户授权列表（按t_auth_rolemgr表的 roleDataAuthType 字段，可能是空串【校级时】、年级ID列表、动态班级ID列表【要注意升级】）
    private String roleDataAuth;

	// 角色名称
    private String roleName;
	// 用户姓名
    private String userName;
    
    
    public Long getNexusId() {
		return nexusId;
	}
	public void setNexusId(Long nexusId) {
		this.nexusId = nexusId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getRoleDataAuth() {
		return roleDataAuth;
	}
	public void setRoleDataAuth(String roleDataAuth) {
		this.roleDataAuth = roleDataAuth;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
	
}
