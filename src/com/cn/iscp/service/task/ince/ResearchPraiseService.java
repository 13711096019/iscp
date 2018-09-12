package com.cn.iscp.service.task.ince;

import com.cn.iscp.entity.task.ResearchPraise;

public interface ResearchPraiseService {
	
	/**
	 * 新增(边教边研评论)点赞
	 */
	ResearchPraise insertPraise(ResearchPraise model);
	
}
