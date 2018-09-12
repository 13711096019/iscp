package com.cn.iscp.service.push.ince;

import java.util.Map;

import com.cn.iscp.entity.push.Countdown;
import com.cn.iscp.model.PageModel;

public interface CountdownService {
	
	/**
	 * PC-分页获取倒计时任务列表
	 */
	PageModel findPage(Map<String, Object> map);

	/**
	 * PC-根据编号获取对象
	 */
	Countdown findById(Long keyId);

	/**
	 * PC-新增倒计时任务
	 */
	Countdown addCountdown(Countdown model);

	/**
	 * PC-编辑倒计时任务
	 */
	Countdown editCountdown(Countdown model);
	
	/**
	 * PC-删除倒计时任务
	 */
	Integer delCountdown(Countdown model);
	
	/**
	 * 终端-获取班级推送对象
	 */
	Countdown getByClassNum(Long classNum);
	
}
