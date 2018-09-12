package com.cn.iscp.service.push.ince;

import java.util.List;

import com.cn.iscp.entity.push.Pattern;

public interface PatternService {
	
	/**
	 * 推送-获取最紧急一条模式
	 */
	Pattern getMostUrgentPattern(Long classNum);
	
	/**
	 * PC-获取唯一模式对象
	 */
	Pattern getOnlyPattern(Integer screenMode);
	
	/**
	 * PC-根据编号获取模式对象
	 */
	Pattern findById(Long patternId);
	
	/**
	 * PC-编辑升旗模式
	 */
	Pattern editFlagPattern(Pattern model);
	
	/**
	 * PC-根据模式类型获取当前有效模式列表
	 */
	List<Pattern> findValidPattern(Integer screenMode);
	
	/**
	 * PC-根据模式类型获取历史模式列表
	 */
	List<Pattern> findInvalidPattern(Integer screenMode);

	/**
	 * PC-新增紧急通知模式
	 */
	Pattern addPattern(Pattern model);

	/**
	 * PC-编辑紧急通知模式
	 */
	Pattern editPattern(Pattern model);

	/**
	 * PC-删除紧急通知模式
	 */
	boolean delPattern(Pattern model);
	
}
