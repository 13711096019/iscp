package com.cn.paas.easemob.service.impl;

import java.io.File;
import java.util.Map;

import com.cn.paas.easemob.model.Authentic;
import com.cn.paas.easemob.model.TalkNode;
import com.cn.paas.easemob.service.TalkHttpService;

public class TalkHttpServiceImplJersey implements TalkHttpService {
	
	public TalkNode request(String url, int method, Object param, Authentic auth, String[][] field) throws Exception {
		//TODO 另一个http请求的实现
		return null;
	}
	public TalkNode upload(String url, File file, Authentic auth, String[][] equal) throws Exception {
		//TODO 另一个http请求的实现
		return null;
	}
	public void downLoad(String url, File file, Authentic auth, Map<String,String> header) throws Exception {
		//TODO 另一个http请求的实现
	}
	
}