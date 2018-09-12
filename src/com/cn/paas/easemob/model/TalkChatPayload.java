package com.cn.paas.easemob.model;

import java.util.List;

public class TalkChatPayload {
	
	private TalkChatExt ext;
	
	private List<TalkChatBody> bodies;

	public TalkChatExt getExt() {
		return ext;
	}

	public void setExt(TalkChatExt ext) {
		this.ext = ext;
	}

	public List<TalkChatBody> getBodies() {
		return bodies;
	}

	public void setBodies(List<TalkChatBody> bodies) {
		this.bodies = bodies;
	}

}
