package com.cn.iscp.service.card.impl.civilized;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.civilized.CivilizedClassScoreDao;
import com.cn.iscp.entity.card.civilized.CivilizedClassScore;
import com.cn.iscp.service.card.ince.civilized.CivilizedClassScoreService;
import com.cn.unit.utils.FieldSortingUtil;

@Service("civilizedClassScoreService")
public class CivilizedClassScoreServiceImpl implements CivilizedClassScoreService {
	
	@Resource
	private CivilizedClassScoreDao civilizedClassScoreDao;
	
	@Override
	public List<CivilizedClassScore> findClassScoreByStage(CivilizedClassScore model) {
		List<CivilizedClassScore> list = civilizedClassScoreDao.findClassScoreByStage(model);
		// 日评,固定周一到周五5条数据
		if(model.getPeriodType().intValue() == 3){
			if(list == null || list.size() < 1){
				list = new ArrayList<CivilizedClassScore>();
			}
			Integer[] weekNum = new Integer[]{1, 2, 3, 4, 5};
			for (Integer week : weekNum) {
				boolean isExist = false;
				for (CivilizedClassScore item : list) {
					if(item.getPeriod().intValue()==week.intValue()){
						isExist = true;
					}
				}
				if(!isExist){
					CivilizedClassScore civilizedClassScore = new CivilizedClassScore();
					civilizedClassScore.setPeriod(week);
					list.add(civilizedClassScore);
				}
			}
			// 重新根据星期排序
			FieldSortingUtil<CivilizedClassScore> sortList = new FieldSortingUtil<CivilizedClassScore>(); 
	        sortList.Sort(list, "getPeriod", "period");
		}  
		return list;
	}
	
	@Override
	public CivilizedClassScore findClasssSore(CivilizedClassScore model) {
		List<List<?>> list = civilizedClassScoreDao.findClasssSore(model);
		CivilizedClassScore score = (CivilizedClassScore) list.get(0).get(0);
		@SuppressWarnings("unchecked")
		List<CivilizedClassScore> scoreList = (List<CivilizedClassScore>) list.get(1);
		score.setScoreList(scoreList);
		return score;
	}

	@Override
	public void censusClassScore() {
		civilizedClassScoreDao.censusClassScore();
	}

	@Override
	public void censusClassScoreByDay(String studyDate) {
		civilizedClassScoreDao.censusClassScoreByDay(studyDate);
	}

}
