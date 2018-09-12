package com.cn.paas.easemob.tool;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cn.paas.wechat.utils.WeixinConfigUtil;

public class _Global {

	private static final Log log = LogFactory.getLog(_Global.class);
	// 文件路径
	private static final String FILENAME = "/easemob/app.properties";
	
	public static int APP_PAGE_SIZE = 1;
	
	// 测试服务器
	public static String APP_KEY;
	public static String APP_CLIENT_ID;
	public static String APP_CLIENT_SECRET;
	
	static {
		try{
			InputStream is = WeixinConfigUtil.class.getResourceAsStream(FILENAME);
			Properties properties = new Properties();
			properties.load(is);
			APP_KEY = properties.getProperty("key_");
			APP_CLIENT_ID = properties.getProperty("client_id");
			APP_CLIENT_SECRET = properties.getProperty("client_secret");
		}catch(Exception ex){
			log.debug("加载配置文件："+ex.getMessage());
		}
	}
	
	// TODO 以上参数需相应修改
	public static final int HTTP_METHOD_GET = 1;
	public static final int HTTP_METHOD_POST = 2;
	public static final int HTTP_METHOD_PUT = 3;
	public static final int HTTP_METHOD_DELETE = 4;
	public static final String URL_HOST = "http://a1.easemob.com/"+APP_KEY.replace("#","/")+"/";
	public static final String URR_TOKEN = URL_HOST+"token";
	public static final String URL_CHAT = URL_HOST+"chatmessages";
	public static final String URL_GROUP = URL_HOST+"chatgroups";
	public static final String URL_FILE = URL_HOST+"chatfiles";
	public static final String URL_ROOM = URL_HOST+"chatrooms";
	public static final String URL_MESSAGES = URL_HOST+"messages";
	public static final String URL_USER = URL_HOST+"users";
	
}