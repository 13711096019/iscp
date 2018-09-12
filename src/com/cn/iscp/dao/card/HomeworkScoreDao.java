package com.cn.iscp.dao.card;

import com.cn.iscp.entity.card.HomeworkScore;

public interface HomeworkScoreDao {
	/**
	 * 家长确认完成作业
	 */
	Long handleHomeworkScore(HomeworkScore model);
}
