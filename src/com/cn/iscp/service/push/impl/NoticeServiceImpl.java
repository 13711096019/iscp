package com.cn.iscp.service.push.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.dao.push.NoticeDao;
import com.cn.iscp.dao.push.NoticePicDao;
import com.cn.iscp.entity.push.Notice;
import com.cn.iscp.service.push.ince.NoticeService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.unit.quartz.task.BasePushTimed;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Resource
	private NoticeDao noticeDao;
	@Resource
	private NoticePicDao noticePicDao;
	
	@Override
	public Notice findById(Long noticeId) {
		return noticeDao.findById(noticeId);
	}

	@Override
	public List<Notice> findThreeByClass(Long classNum, Integer noticeType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("classNum", classNum);
		String noticeTypes = null;
		if(_Tool.isValid(noticeType)){
			noticeTypes = noticeType.intValue()==_Const.MESSAGE_NOTICE ? _Tool.toStr(noticeType) :
				_Const.MESSAGE_AFFICHE + "," + _Const.MESSAGE_INSPECT;
		}else{
			noticeTypes = _Const.MESSAGE_NOTICE + ","+_Const.MESSAGE_AFFICHE + "," + _Const.MESSAGE_INSPECT;
		}
		map.put("noticeTypes", noticeTypes);
		List<Notice> noticeList = noticeDao.findThreeByClass(map);
		// 公告时判断是否存在清洁巡查公告
		if(noticeList != null && noticeList.size() > 0){
			for (Notice notice : noticeList) {
				if(notice.getNoticeType().intValue()==_Const.MESSAGE_INSPECT){
					notice.setPicList(noticePicDao.findByNotice(notice.getNoticeId()));
				}
			}
		}
		return noticeList;
	}

	@Override
	public List<Notice> findAllByClass(Long classNum, Integer noticeType) {
		String noticeTypes = null;
		if(_Tool.isValid(noticeType)){
			noticeTypes = noticeType.intValue()==_Const.MESSAGE_NOTICE ? _Tool.toStr(noticeType) :
				_Const.MESSAGE_AFFICHE + "," + _Const.MESSAGE_INSPECT;
		}else{
			noticeTypes = _Const.MESSAGE_NOTICE + ","+_Const.MESSAGE_AFFICHE + "," + _Const.MESSAGE_INSPECT;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("classNum", classNum);
		map.put("noticeTypes", noticeTypes);
		List<Notice> noticeList = noticeDao.findAllByClass(map);
		// 公告时判断是否存在清洁巡查公告
		if(noticeList != null && noticeList.size() > 0){
			for (Notice notice : noticeList) {
				if(notice.getNoticeType().intValue()==_Const.MESSAGE_INSPECT){
					notice.setPicList(noticePicDao.findByNotice(notice.getNoticeId()));
				}
			}
		}
		return noticeList;
	}

	@Override
	public List<Notice> findByValid(Map<String, Object> map) {
		return noticeDao.findByValid(map);
	}

	@Override
	public List<Notice> findByInvalid(Map<String, Object> map) {
		return noticeDao.findByInvalid(map);
	}
	
	@Override
	public Notice insertNotice(Notice model) {
		model.setSchoolId(_Const.SCHOOL_ID);
		model = noticeDao.insertNotice(model);
		if(model != null && model.getNoticeType().intValue() != _Const.MESSAGE_INSPECT){
			Long gradeId = null;
			if(_Tool.isInt(model.getScopeType()) && model.getScopeType().intValue()==_Const.SCOPE_CLASS){
				gradeId = _Tool.toLong(model.getGradeIds());
			}
			// 极光推送
			BasePushTimed.PushMachine(PushCode.SPIRIT, false, gradeId, null);
		}
		return model;
	}

	@Override
	public boolean updateNotice(Notice model) {
		boolean revert = noticeDao.updateNotice(model);
		if(revert){
			model = this.findById(model.getNoticeId());
			Long gradeId = null;
			if(_Tool.isInt(model.getScopeType()) && model.getScopeType().intValue()==_Const.SCOPE_CLASS){
				gradeId = _Tool.toLong(model.getGradeIds());
			}
			// 极光推送
			BasePushTimed.PushMachine(PushCode.SPIRIT, false, gradeId, null);
		}
		return revert;
	}
	
}
