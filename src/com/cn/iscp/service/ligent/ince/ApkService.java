package com.cn.iscp.service.ligent.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.ligent.Apk;
import com.cn.iscp.model.StateModel;

public interface ApkService {
    
	List<Apk> findPage(Map<String, Object> map);
	
	Long getPageCount();
	
	boolean insert(String pathName, Apk model);
	
	StateModel getPushContent(String apkId, Integer versionType);
	
	Apk getModle(String apkId, Integer versionType);
	
}
