package com.cn.iscp.service.card.impl.civilized;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.civilized.CivilizedGiveScoreDao;
import com.cn.iscp.entity.card.civilized.CivilizedClassScore;
import com.cn.iscp.entity.card.civilized.CivilizedGiveScore;
import com.cn.iscp.service.card.ince.civilized.CivilizedGiveScoreService;

@Service("civilizedGiveScoreService")
public class CivilizedGiveScoreServiceImpl implements CivilizedGiveScoreService {
	
	@Resource
	private CivilizedGiveScoreDao civilizedGiveScoreDao;

	@Override
	public CivilizedGiveScore insertGiveScore(CivilizedGiveScore model) {
		return civilizedGiveScoreDao.insertGiveScore(model);
	}

	@Override
	public List<CivilizedGiveScore> findDetail(CivilizedClassScore model) {
		return civilizedGiveScoreDao.findDetail(model);
	}

	@Override
	public void deleteGiveScore(Long scoreId) {
		civilizedGiveScoreDao.deleteGiveScore(scoreId);
	}

}
