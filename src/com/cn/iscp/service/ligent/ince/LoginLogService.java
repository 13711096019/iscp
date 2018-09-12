package com.cn.iscp.service.ligent.ince;

import com.cn.iscp.model.Artascope;

public interface LoginLogService {
	
	/**
	 * 处理登录记录
	 */
	void handleLoginLog(Long userId, Integer logType);

	/**
	 * 获取在线人数
	 */
	Artascope findOnlineCount();
	
}
