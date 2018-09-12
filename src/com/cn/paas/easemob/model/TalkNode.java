package com.cn.paas.easemob.model;

import java.util.List;
import java.util.Map;

public class TalkNode {

	// 获取授权管理员 token 值
	private String access_token;
	// 请求方式
	private String action;
	// 当前 APP 的 UUID 值
	private String application;
	// 
	private String applicationName;
	// 返回的数量
	private Long count;
	// 游标，用于分页查询
	private String cursor;
	// 
	private Integer duration;
	// token 有效时间，以秒为单位，在有效期内不需要重复获取
	private Long expires_in;
	// 
	private String organization;
	// 请求路径后缀
	private String path;
	// 
	private Integer statusCode;
	// 时间戳(消息发送时间)
	private Long timestamp;
	// 请求路径
	private String uri;
	// 查询语句
	private Map<String, Object> params;
	// 
	private TalkUser user;
	// 
	private List<TalkUser> entities;
	// 
	private String[] data_array;
	// 
	private Map<String, String> data_map;
	// 
	private List<Map<String, Object>> data_list;
	// 聊天记录列表
	// private List<TalkMsg>data_chat_list;
	private List<TalkChat> data_chat_list;
	// 
	private TalkRoom data_room;
	// 
	private List<TalkRoom> data_room_list;
	// 
	private TalkRoomRedo data_room_rodo;
	// 
	private List<TalkRoomRedo> data_room_redo_list;
	// 
	private TalkGroup data_group;
	// 
	private TalkGroupMember data_group_update;
	// 
	private TalkGroupMember data_group_owner;
	// 
	private List<TalkGroup> data_group_list;
	// 
	private List<TalkGroupMember> data_group_list_member;
	// 
	private List<TalkGroupNew> data_group_list_new;
	// 
	private TalkGroupFriend data_group_friend;
	// 
	private List<TalkGroupFriend> data_group_friend_list;

	public TalkNode() {
	}

	public TalkNode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public TalkUser getUser() {
		return user;
	}

	public void setUser(TalkUser user) {
		this.user = user;
	}

	public List<TalkUser> getEntities() {
		return entities;
	}

	public void setEntities(List<TalkUser> entities) {
		this.entities = entities;
	}

	public String[] getData_array() {
		return data_array;
	}

	public void setData_array(String[] data_array) {
		this.data_array = data_array;
	}

	public Map<String, String> getData_map() {
		return data_map;
	}

	public void setData_map(Map<String, String> data_map) {
		this.data_map = data_map;
	}

	public List<Map<String, Object>> getData_list() {
		return data_list;
	}

	public void setData_list(List<Map<String, Object>> data_list) {
		this.data_list = data_list;
	}

	public List<TalkChat> getData_chat_list() {
		return data_chat_list;
	}

	public void setData_chat_list(List<TalkChat> data_chat_list) {
		this.data_chat_list = data_chat_list;
	}

	public TalkRoom getData_room() {
		return data_room;
	}

	public void setData_room(TalkRoom data_room) {
		this.data_room = data_room;
	}

	public List<TalkRoom> getData_room_list() {
		return data_room_list;
	}

	public void setData_room_list(List<TalkRoom> data_room_list) {
		this.data_room_list = data_room_list;
	}

	public TalkRoomRedo getData_room_rodo() {
		return data_room_rodo;
	}

	public void setData_room_rodo(TalkRoomRedo data_room_rodo) {
		this.data_room_rodo = data_room_rodo;
	}

	public List<TalkRoomRedo> getData_room_redo_list() {
		return data_room_redo_list;
	}

	public void setData_room_redo_list(List<TalkRoomRedo> data_room_redo_list) {
		this.data_room_redo_list = data_room_redo_list;
	}

	public TalkGroup getData_group() {
		return data_group;
	}

	public void setData_group(TalkGroup data_group) {
		this.data_group = data_group;
	}

	public TalkGroupMember getData_group_update() {
		return data_group_update;
	}

	public void setData_group_update(TalkGroupMember data_group_update) {
		this.data_group_update = data_group_update;
	}

	public TalkGroupMember getData_group_owner() {
		return data_group_owner;
	}

	public void setData_group_owner(TalkGroupMember data_group_owner) {
		this.data_group_owner = data_group_owner;
	}

	public List<TalkGroup> getData_group_list() {
		return data_group_list;
	}

	public void setData_group_list(List<TalkGroup> data_group_list) {
		this.data_group_list = data_group_list;
	}

	public List<TalkGroupMember> getData_group_list_member() {
		return data_group_list_member;
	}

	public void setData_group_list_member(
			List<TalkGroupMember> data_group_list_member) {
		this.data_group_list_member = data_group_list_member;
	}

	public List<TalkGroupNew> getData_group_list_new() {
		return data_group_list_new;
	}

	public void setData_group_list_new(List<TalkGroupNew> data_group_list_new) {
		this.data_group_list_new = data_group_list_new;
	}

	public TalkGroupFriend getData_group_friend() {
		return data_group_friend;
	}

	public void setData_group_friend(TalkGroupFriend data_group_friend) {
		this.data_group_friend = data_group_friend;
	}

	public List<TalkGroupFriend> getData_group_friend_list() {
		return data_group_friend_list;
	}

	public void setData_group_friend_list(
			List<TalkGroupFriend> data_group_friend_list) {
		this.data_group_friend_list = data_group_friend_list;
	}
}