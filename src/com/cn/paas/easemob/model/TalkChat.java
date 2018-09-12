package com.cn.paas.easemob.model;

public class TalkChat {
	
	private String uuid;
	private String type;
	private Long created;
	private Long modified;
	private Long timestamp;
	private String from;
	private String groupId;
	private String msg_id;
	private String to;
	private String chat_type;
	private TalkChatPayload payload;
	
	public String getChat_type() {
		return chat_type;
	}
	public void setChat_type(String chat_type) {
		this.chat_type = chat_type;
	}
	public Long getCreated() {
		return created;
	}
	public void setCreated(Long created) {
		this.created = created;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public Long getModified() {
		return modified;
	}
	public void setModified(Long modified) {
		this.modified = modified;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public TalkChatPayload getPayload() {
		return payload;
	}
	public void setPayload(TalkChatPayload payload) {
		this.payload = payload;
	}

}
