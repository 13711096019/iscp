package com.cn.paas.easemob.model;

public class TalkChatBody {
	private String action;
	
	// 文本类型消息(msg,type)
	private String msg;
	private String type;

	// 语音类型消息(filename,length,file_length,secret,type,url)
	private Long length;
	
	// 图片类型消息(filename,size,file_length,secret,thumbFilename,type,url)
	private String filename;
	private PicModel size;
	private Long file_length;
	private String secret;
	private String thumbFilename;
	private String url;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public PicModel getSize() {
		return size;
	}
	public void setSize(PicModel size) {
		this.size = size;
	}
	public Long getFile_length() {
		return file_length;
	}
	public void setFile_length(Long file_length) {
		this.file_length = file_length;
	}
	public String getThumbFilename() {
		return thumbFilename;
	}
	public void setThumbFilename(String thumbFilename) {
		this.thumbFilename = thumbFilename;
	}


}
