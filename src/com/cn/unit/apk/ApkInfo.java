package com.cn.unit.apk;

import java.util.List;

/**
 * APK信息类
 * @author Adonis_1111@163.com
 * 2016-10-16
 */
public class ApkInfo {
	
	private Integer versionCode;
	private String versionNum;
	private String apkPackage;
	private String minSdkVersion;
	private String apkName;
	private List<?> uses_permission;
	
	
	public ApkInfo(Integer versionCode, String versionNum, String apkPackage) {
		this.versionCode = versionCode;
		this.versionNum = versionNum;
		this.apkPackage = apkPackage;
	}
	

	public ApkInfo() {
		versionCode = null;
		versionNum = null;
		apkPackage = null;
		minSdkVersion = null;
		apkName = null;
		uses_permission = null;
	}

	public Integer getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}

	public String getApkPackage() {
		return apkPackage;
	}

	public void setApkPackage(String apkPackage) {
		this.apkPackage = apkPackage;
	}

	public String getMinSdkVersion() {
		return minSdkVersion;
	}

	public void setMinSdkVersion(String minSdkVersion) {
		this.minSdkVersion = minSdkVersion;
	}

	public String getApkName() {
		return apkName;
	}

	public void setApkName(String apkName) {
		this.apkName = apkName;
	}

	public List<?> getUses_permission() {
		return uses_permission;
	}

	public void setUses_permission(List<?> uses_permission) {
		this.uses_permission = uses_permission;
	}

	public String toString() {
            return (new StringBuilder("&version="+versionNum+"&versioncode="+versionCode)).toString();
	}
	
}
