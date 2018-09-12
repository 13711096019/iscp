package com.cn.iscp.service.card.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.common._Url;
import com.cn.iscp.dao.card.CampusNewsDao;
import com.cn.iscp.entity.card.CampusNews;
import com.cn.iscp.service.card.ince.CampusNewsService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.unit.quartz.task.BasePushTimed;

@Service("campusNewsService")
public class CampusNewsServiceImpl implements CampusNewsService {
	
	@Resource
	private CampusNewsDao campusNewsDao;

	@Override
	public List<CampusNews> findPage(Map<String, Object> map) {
		return campusNewsDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return campusNewsDao.getPageCount(map);
	}

	@Override
	public CampusNews findById(Long newsId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newsId", newsId);
		map.put("itemCordNewsType", _Const.ITEMCORD_NEWS_TYPE);
		return campusNewsDao.findById(map);
	}

	@Override
	public boolean insert(CampusNews model) {
		boolean revert = campusNewsDao.insert(model);
		if(revert){
			// 修改链接地址
			Long newsId = model.getNewsId();
			model.setLink(_Url.LINK_NEWINFO + newsId);
			this.update(model);
			
			// 推送
			/*Integer newsMold = model.getNewsMold();
			Integer pushCode = newsMold == 1 ? PushCode.CAMPUS_NEWS : (newsMold == 2 ? PushCode.CAMPUS_ALLUSION : PushCode.CAMPUS_KNOWLEDGE);
			BasePushTimed.PushMachine(pushCode, false, null);*/

			if(model.getNewsMold().intValue() == _Const.NEWS_MOLD_ADMINISTRIVIA){
				Integer pushCode = PushCode.CAMPUS_NEWS;
				BasePushTimed.PushMachine(pushCode, false, null, null);
			}
		}
		return revert;
	}

	@Override
	public boolean update(CampusNews model) {
		boolean revert = campusNewsDao.update(model);
		if(revert){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("newsId", model.getNewsId());
			map.put("itemCordNewsType", _Const.ITEMCORD_NEWS_TYPE);
			model = campusNewsDao.findById(map);
			// 推送
			/*Integer newsMold = model.getNewsMold();
			Integer pushCode = newsMold == 1 ? PushCode.CAMPUS_NEWS : (newsMold == 2 ? PushCode.CAMPUS_ALLUSION : PushCode.CAMPUS_KNOWLEDGE);
			BasePushTimed.PushMachine(pushCode, false, null);*/
			
			if(model.getNewsMold().intValue() == _Const.NEWS_MOLD_ADMINISTRIVIA){
				Integer pushCode = PushCode.CAMPUS_NEWS;
				BasePushTimed.PushMachine(pushCode, false, null, null);
			}
			
		}
		return revert;
	}

	@Override
	public List<CampusNews> findNewsBySix(Integer newsMold) {
		return campusNewsDao.findNewsBySix(newsMold);
	}
	
	@Override
	public List<CampusNews> findNewsByEight(Integer newsMold) {
		return campusNewsDao.findNewsByEight(newsMold);
	}

	@Override
	public List<CampusNews> findNewsByAll(Integer newsMold) {
		return campusNewsDao.findNewsByAll(newsMold);
	}

	@Override
	public List<CampusNews> findNewsByMold(Integer newsMold) {
		return campusNewsDao.findNewsByMold(newsMold);
	}

}
