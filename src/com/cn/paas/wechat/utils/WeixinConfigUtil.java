package com.cn.paas.wechat.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 微信的配置参数
 * @author adonis_1111@163.com
 * 2016-09-07
 */
public class WeixinConfigUtil {

	private static final Log log = LogFactory.getLog(WeixinConfigUtil.class);
	// 文件路径
	private static final String FILENAME = "/wechat/app.properties";

	// key值
	public static String key;
	// 应用ID
	public static String appid;
	// 商户号
	public static String mch_id;
	// 回调地址
	public static String notify_url;
	// 安全证书
	public static String cert_path;
	// 终端IP
	public static String terminal_ip;
	

	static {
		try{
			InputStream is = WeixinConfigUtil.class.getResourceAsStream(FILENAME);
			Properties properties = new Properties();
			properties.load(is);
			key = properties.getProperty("key_");
			appid = properties.getProperty("appid");
			mch_id = properties.getProperty("mch_id");
			notify_url = properties.getProperty("notify_url");
			cert_path = properties.getProperty("cert_path");
			terminal_ip = InetAddress.getLocalHost().getHostAddress();
		}catch(Exception ex){
			log.debug("加载配置文件："+ex.getMessage());
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		InputStream is = WeixinConfigUtil.class.getResourceAsStream("/com/cn/pay/unit/resources/sys.properties");
		Properties properties = new Properties();
		properties.load(is);
		is.close();
		String appid = properties.getProperty("appid");
		String mchid = properties.getProperty("mch_id");
		String notifyurl = properties.getProperty("notify_url");
		System.out.println(appid+"\t"+mchid+"\t"+notifyurl);
	}

}
