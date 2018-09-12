package com.cn.paas.jiguang.push;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cn.paas.wechat.utils.WeixinConfigUtil;

/**
 * 极光推送应用分配
 * @author 10011037@qq.com
 * 2016-02-12
 */
public class PushKey {

	private static final Log log = LogFactory.getLog(PushKey.class);
	// 文件路径
	private static final String FILENAME = "/jiguang/app.properties";
	
	// 班牌终端[Const.VERSION_TYPE=1]
	public static final int CODE_TERMINAL = 3701;
	// APP老师端[Const.VERSION_TYPE=2]
	public static final int CODE_TEACHER = 3702;
	// APP家长端[Const.VERSION_TYPE=3]
	public static final int CODE_PATRIARCH = 3703;
	
	// AppKey
	private String appKey;
	// Master Secret
	private String masterSecret;
	
	public PushKey(int code){
		InputStream is = WeixinConfigUtil.class.getResourceAsStream(FILENAME);
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			log.debug("加载配置文件："+e.getMessage());
		}
		
		switch (code) {
		case CODE_TERMINAL:
			// 班牌终端
			this.appKey = properties.getProperty("terminal_key");
			this.masterSecret = properties.getProperty("terminal_secret");
			break;
		case CODE_TEACHER:
			// APP老师端
			this.appKey = properties.getProperty("teacher_key");
			this.masterSecret = properties.getProperty("teacher_secret");
			break;
		case CODE_PATRIARCH:
			// APP家长端
			this.appKey = properties.getProperty("patriarch_key");
			this.masterSecret = properties.getProperty("patriarch_secret");
			break;
		default:
			break;
		}
	}
	
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getMasterSecret() {
		return masterSecret;
	}
	public void setMasterSecret(String masterSecret) {
		this.masterSecret = masterSecret;
	}
	
}
