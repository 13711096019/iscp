package com.cn.iscp.dao.card;

import com.cn.iscp.entity.card.ClassMotto;

public interface ClassMottoDao {
	
	/**
	 * 终端-获取班级班风班训
	 */
	ClassMotto getByClassNum(Long classNum);
	
	/**
	 * PC-处理班风班训
	 */
	Long handleClassMotto(ClassMotto model);
	
}
