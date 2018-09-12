package com.cn.iscp.dao.ligent;

import java.util.List;

import com.cn.iscp.entity.ligent.Promo;

public interface PromoDao {
	
	/**
	 * 根据类型获取宣传图片
	 */
	List<Promo> findByType(Integer promoType);
	
	/**
	 * 新增宣传图片
	 */
	Promo insertPromo(Promo model);
	
}
