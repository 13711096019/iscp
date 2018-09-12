package com.cn.iscp.service.ligent.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.ligent.PromoDao;
import com.cn.iscp.entity.ligent.Promo;
import com.cn.iscp.service.ligent.ince.PromoService;

@Service("promoService")
public class PromoServiceImpl implements PromoService {

	@Resource
	private PromoDao promoDao;

	@Override
	public Promo getByType(Integer promoType) {
		List<Promo> list = promoDao.findByType(promoType);
		if(list == null)
			return null;
		return list.get(0);
	}
	
	@Override
	public List<Promo> findByType(Integer promoType) {
		return promoDao.findByType(promoType);
	}

	@Override
	public Promo insertPromo(Promo model) {
		return promoDao.insertPromo(model);
	}

}
