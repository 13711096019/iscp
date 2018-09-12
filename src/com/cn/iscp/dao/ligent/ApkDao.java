package com.cn.iscp.dao.ligent;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.ligent.Apk;

public interface ApkDao {
    
	List<Apk> findPage(Map<String, Object> map);
	
	Long getPageCount();
	
	Apk findById(Long apkId);
	
	Apk getModleByNum(String versionNum);
	
	Apk getLastModle(Integer versionType);
	
	boolean insert(Apk model);
	
}
