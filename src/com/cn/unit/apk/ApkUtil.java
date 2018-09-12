package com.cn.unit.apk;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

import com.cn.common._Tool;

/**
 * 获取APK信息工具类
 * @author Adonis_1111@163.com
 * 2016-10-16
 */
public class ApkUtil {
	
	private static final Namespace NS = Namespace.getNamespace("http://schemas.android.com/apk/res/android");
	
	public static ApkInfo getApkInfo(String apkPath){
		ApkInfo apkInfo = new ApkInfo();
		SAXBuilder builder = new SAXBuilder();
		Document document = null;
		try{
			document = builder.build(getXmlInputStream(apkPath));
		}catch (Exception e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();//跟节点-->manifest
		apkInfo.setVersionCode(_Tool.toInt(root.getAttributeValue("versionCode",NS)));
		apkInfo.setVersionNum(root.getAttributeValue("versionName", NS));
		apkInfo.setApkPackage(root.getAttributeValue("package", NS));
		Element elemUseSdk = root.getChild("uses-sdk");//子节点-->uses-sdk
		apkInfo.setMinSdkVersion(elemUseSdk.getAttributeValue("minSdkVersion", NS));
		List<?> listPermission = root.getChildren("uses-permission");//子节点是个集合
		List<String> permissions = new ArrayList<String>();
		for(Object object : listPermission){
			String permission = ((Element)object).getAttributeValue("name", NS);
			permissions.add(permission);
		}
		apkInfo.setUses_permission(permissions);
		
		String s = root.getAttributes().toString();
		String c[] = s.split(",");
		Integer versionCode = null;
		String versionNum = null;
		String packageName = null;
		for(String a: c){
			if(a.contains("versionCode")){
				versionCode = _Tool.toInt(a.substring(a.indexOf("versionCode=\"")+13, a.lastIndexOf("\"")));
			}
			if(a.contains("versionName")){
				versionNum = a.substring(a.indexOf("versionName=\"")+13, a.lastIndexOf("\""));
			}
			if(a.contains("package")){
				packageName = a.substring(a.indexOf("package=\"")+9, a.lastIndexOf("\""));
			}
		}
		ApkInfo model = new ApkInfo(versionCode, versionNum, packageName);
		return model;
	}

	private static InputStream getXmlInputStream(String apkPath) {
		InputStream inputStream = null;
		InputStream xmlInputStream = null;
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(apkPath);
			ZipEntry zipEntry = new ZipEntry("AndroidManifest.xml");
			inputStream = zipFile.getInputStream(zipEntry);
			AXMLPrinter xmlPrinter = new AXMLPrinter();
			xmlPrinter.startPrinf(inputStream);
			xmlInputStream = new ByteArrayInputStream(xmlPrinter.getBuf().toString().getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
			try {
				inputStream.close();
				zipFile.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return xmlInputStream;
	}
	
	/**
     * 获取指定文件大小
     * @param f
     * @return
     * @throws Exception
     */
    @SuppressWarnings("resource")
	public static long getFileSize(File file) {
        long size = 0;
        try {
            if (file.exists()) {
                FileInputStream fis = null;
				fis = new FileInputStream(file);
	            size = fis.available();
	    		// 转换MB:(float)getFileSize(file)/(float)1024/(float)1024+"MB"
            } else {
                file.createNewFile();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return size;
    }
}
