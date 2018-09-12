package com.cn.iscp.dao.card;

import java.util.List;

import com.cn.iscp.entity.card.CookBook;

public interface CookBookDao {
	
	/**
	 * PC-根据学年获取菜谱
	 */
	List<CookBook> findByTerm();
	
	/**
	 * PC-根据编号获取菜谱对象
	 */
	CookBook findById(Long cookId);
	
	/**
	 * PC-修改菜谱
	 */
	CookBook editCookBook(CookBook model);
	
}
