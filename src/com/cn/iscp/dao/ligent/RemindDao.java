package com.cn.iscp.dao.ligent;

import com.cn.iscp.entity.ligent.Remind;

public interface RemindDao {
	
	/**
	 * 随机获取一条数据
	 */
	Remind getByRandom();
	
	/**
	 * 根据Key获取数据
	 */
	Remind getByKey(String remindKey);
	
}
