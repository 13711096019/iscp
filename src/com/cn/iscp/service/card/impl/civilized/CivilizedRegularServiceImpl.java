package com.cn.iscp.service.card.impl.civilized;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.civilized.CivilizedRegularDao;
import com.cn.iscp.entity.card.civilized.CivilizedGiveScore;
import com.cn.iscp.entity.card.civilized.CivilizedRegular;
import com.cn.iscp.service.card.ince.civilized.CivilizedRegularService;

@Service("civilizedRegularService")
public class CivilizedRegularServiceImpl implements CivilizedRegularService {
	
	@Resource
	private CivilizedRegularDao civilizedRegularDao;

	@Override
	public List<CivilizedRegular> findByItem(Long bigItemId) {
		return civilizedRegularDao.findByItem(bigItemId);
	}

	@Override
	public CivilizedRegular findById(Long smallItemId) {
		return civilizedRegularDao.findById(smallItemId);
	}

	@Override
	public List<CivilizedRegular> findScoreRegular(CivilizedGiveScore model) {
		return civilizedRegularDao.findScoreRegular(model);
	}

	@Override
	public List<CivilizedRegular> findRegular() {
		return civilizedRegularDao.findRegular();
	}

}
