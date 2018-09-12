package com.cn.iscp.service.card.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.CookBookDao;
import com.cn.iscp.entity.card.CookBook;
import com.cn.iscp.service.card.ince.CookBookService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.unit.quartz.task.BasePushTimed;

@Service("cookBookService")
public class CookBookServiceImpl implements CookBookService {
	
	@Resource
	private CookBookDao cookBookDao;

	@Override
	public List<CookBook> findByTerm() {
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		List<CookBook> list = cookBookDao.findByTerm();
		for (CookBook cookBook : list) {
			cookBook.setWeekName(weekDays[cookBook.getWeekDay()-1]);
		}
		return list;
	}

	@Override
	public CookBook findById(Long cookId) {
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		CookBook cookbook = cookBookDao.findById(cookId);
		cookbook.setWeekName(weekDays[cookbook.getWeekDay()-1]);
		return cookbook;
	}

	@Override
	public CookBook update(CookBook model) {
		CookBook cookBook = cookBookDao.editCookBook(model);
		// 极光推送
		BasePushTimed.PushMachine(PushCode.COOK_BOOK, false, null, null);
		return cookBook;
	}

}
