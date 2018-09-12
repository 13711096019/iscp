package com.cn.iscp.entity.auth;

import java.util.List;

import com.cn.iscp.entity.base.Teacher;

/**
 * 角色对象
 * @author 10011037@qq.com
 * 2017-09-30
 */
public class Role {

	// 自增编号
    private Long roleId;
	// 角色名称
    private String roleName;
	// 角色别名
    private String roleAlias;
	// 用户类型：1=学生，2=老师；与APP客户端相关
    private Integer userType;
	// 父级编号列表
    private String parentId;
	// 角色等级
    private Integer roleRank;
	// 数据操作范围（例如发通知的范围）：1=校级，2=年级，3=班级
    private Integer scopeType;
	// 角色代码
    private Long moduleId;
	// 状态
    private Integer status;
	// 描述内容
    private String note;
	// 授权项列表
    private String authorizationIds;
    
    // 下级角色列表
    private List<Role> roleList;
    // 老师列表
    private List<Teacher> teacherList;
    
    public Role(){};
    
    public Role(String roleName, List<Teacher> teacherList){
    	this.roleName = roleName;
    	this.teacherList = teacherList;
    }
    
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getRoleRank() {
		return roleRank;
	}
	public void setRoleRank(Integer roleRank) {
		this.roleRank = roleRank;
	}
	public Integer getScopeType() {
		return scopeType;
	}
	public void setScopeType(Integer scopeType) {
		this.scopeType = scopeType;
	}
	public Long getModuleId() {
		return moduleId;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getAuthorizationIds() {
		return authorizationIds;
	}
	public void setAuthorizationIds(String authorizationIds) {
		this.authorizationIds = authorizationIds;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		if(roleList == null || roleList.size() < 1){
			roleList = null;
		}
		this.roleList = roleList;
	}
	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		if(teacherList == null || teacherList.size() < 1){
			teacherList = null;
		}
		this.teacherList = teacherList;
	}
	public String getRoleAlias() {
		return roleAlias;
	}
	public void setRoleAlias(String roleAlias) {
		this.roleAlias = roleAlias;
	}
	
}
