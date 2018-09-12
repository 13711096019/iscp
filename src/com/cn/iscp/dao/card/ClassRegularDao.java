package com.cn.iscp.dao.card;

import com.cn.iscp.entity.card.ClassRegular;

public interface ClassRegularDao {
	
	/**
	 * PC-根据动态班级编号获取班级公约
	 */
	ClassRegular findByClass(Long classNum);
	
	/**
	 * PC-处理班级公约
	 */
	ClassRegular handleClassRegular(ClassRegular model);
	
}
