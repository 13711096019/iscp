package com.cn.iscp.service.ligent.ince;

import com.cn.iscp.entity.ligent.Remind;

public interface RemindService {
	
	/**
	 * 随机获取一条数据
	 */
	Remind getByRandom();
	
	/**
	 * 根据Key获取数据
	 */
	Remind getByKey(String remindKey);
	
}
