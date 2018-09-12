package com.cn.common;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cn.paas.wechat.utils.WeixinConfigUtil;

public class _Url {
	
	private static final Log log = LogFactory.getLog(_Url.class);
	// 文件路径
	private static final String FILENAME = "/config/iscp.properties";

	/**
	 * 目录
	 */
	/* 域名 */
	public static String PROJECT_REALM;
	/* 项目名 */
	public static String PROJECT_NAME;
	
	static {
		try{
			InputStream is = WeixinConfigUtil.class.getResourceAsStream(FILENAME);
			Properties properties = new Properties();
			properties.load(is);
			PROJECT_REALM = properties.getProperty("project_realm");
			PROJECT_NAME = properties.getProperty("project_name");
		}catch(Exception ex){
			log.debug("加载配置文件："+ex.getMessage());
		}
	}
	
	/* 临时路径 */
	public static final String FILE_PATH_TMP = "document/temp/";
	/* 安卓安卓包路径 */
	public static final String FILE_PATH_APK = "document/apk/";
	/* 学生头像 */
	public static final String FILE_PATH_STUDENT = "document/student/";
	/* 教员头像 */
	public static final String FILE_PATH_TEACHER = "document/teacher/";
	/* 家长头像 */
	public static final String FILE_PATH_PATRIARCH = "document/patriarch/";
	/* 文件夹图标 */
	public static final String FILE_HEAD_FILETYPE = "document/file/typeicon/";
	/* 班级荣誉图标头像路径 */
	public static final String FILE_PATH_HONORS = "document/honors/";
	/* 风采作品图片路径 */
	public static final String FILE_PATH_CAMPUS = "document/campusworks/";
	/* 视频文件 */
	public static final String FILE_PATH_VIDEO = "document/video/";
	/* 班级相册 */
	public static final String FILE_PATH_ALBUM = "document/album/";
	/* 教员资格证书 */
	public static final String FILE_PATH_QUALIFICATION = "document/qualification/";
	/* 班级动态 */
	public static final String FILE_PATH_DYNAMIC = "document/dynamic/";
	/* 校园作品 */
	public static final String FILE_PATH_CAMPUSWORKS = "document/campusworks/";
	/* 通知图片 */
	public static final String FILE_PATH_NOTICE = "document/notice/";
	/* 三风简讯 */
	public static final String FILE_PATH_SPIRIT = "document/spirit/";
	/* 导入文档路径 */
	public static final String FILE_PATH_EXCEL = "document//excel/";
	/* 新闻封面图 */
	public static final String FILE_PATH_NEWSCOVER = "document/news/cover/";
	/* 硬盘储存 */
	public static final String FILE_PATH_CALICHE = "document/caliche/";
	/* 边教边研 */
	public static final String FILE_PATH_RESEARCH = "document/research/";
	/* APP图片 */
	public static final String FILE_PATH_PROMO = "document/promo/";
	/* 收费征询签名 */
	public static final String FILE_PATH_CONSUTL = "document/consutl/";
	/* 文件模板目录 */
	public static final String FILE_TEMPLATE_PATH = "document/template/";
	
	/**
	 * 默认头像
	 */
	public static final String HEAD_PORTRAIT_STUDENT = PROJECT_NAME + FILE_PATH_STUDENT + "10011037.jpg";
	public static final String HEAD_PORTRAIT_TEACHER = PROJECT_NAME + FILE_PATH_TEACHER + "10011037.jpg";
	public static final String HEAD_PORTRAIT_PATRIARCH = PROJECT_NAME + FILE_PATH_PATRIARCH + "10011037.jpg";
	/* 班级荣誉默认头像 */
	public static final String HONORS_HEAD_PORTRAIT = "10011037.jpg";
	/* 风采作品默认图片 */
	public static final String CAMP_HEAD_PORTRAIT = "class_001.png";
	/* 文件夹默认图片 */
	public static final String FILE_HEAD_PORTRAIT = "isco.png";
	/* 视频封面默认图片 */
	public static final String VIDEO_HEAD_PORTRAIT = PROJECT_REALM + PROJECT_NAME + FILE_PATH_VIDEO + "video.jpg";
	
	/**
	 * 链接
	 */
	/* 班牌终端新闻详细链接 */
	public static final String LINK_NEWINFO = PROJECT_REALM + PROJECT_NAME + "card/news/view?keyId=";
	/* 班牌终端班级公约链接 */
	public static final String LINK_REGULAR = PROJECT_NAME + "card/regular/view?classNum=";
	/* apk下载 */
	public static final String LINK_APK_DOW = PROJECT_NAME + "mt/apk/dowApk";
	
	
	
}
