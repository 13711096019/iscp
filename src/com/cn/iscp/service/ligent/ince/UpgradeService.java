package com.cn.iscp.service.ligent.ince;

import java.util.Map;

public interface UpgradeService {

	/**
	 * 学年升级：1.基本信息升级
	 */
	void bindingBasicInfo();
	
	/**
	 * 学年升级：2.学生信息升级
	 */
	void handleStudentInfo(Map<String, Object> map);

	/**
	 * 学年升级：3.统计升级信息
	 */
	void censusHavingInfo();
	
}
