package com.cn.iscp.dao.ligent;

import com.cn.iscp.entity.ligent.LoginLog;
import com.cn.iscp.model.Artascope;

public interface LoginLogDao {
	
	/**
	 * 处理登录记录
	 */
	void handleLoginLog(LoginLog model);

	/**
	 * 获取在线人数
	 */
	Artascope findOnlineCount();
	
}
