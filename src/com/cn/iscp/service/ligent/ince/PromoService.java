package com.cn.iscp.service.ligent.ince;

import java.util.List;

import com.cn.iscp.entity.ligent.Promo;

public interface PromoService {
	
	/**
	 * 根据类型获取宣传图片对象
	 */
	Promo getByType(Integer promoType);
	
	/**
	 * 根据类型获取宣传图片集合
	 */
	List<Promo> findByType(Integer promoType);
	
	/**
	 * 新增宣传图片
	 */
	Promo insertPromo(Promo model);
	
}
