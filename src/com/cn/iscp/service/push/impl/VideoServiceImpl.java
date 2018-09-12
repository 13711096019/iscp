package com.cn.iscp.service.push.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.push.VideoDao;
import com.cn.iscp.entity.push.Video;
import com.cn.iscp.service.push.ince.VideoService;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
	
	@Resource
	private VideoDao videoDao;

	@Override
	public List<Video> findByClass(Long classNum, Integer getCount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("classNum", classNum);
		map.put("getCount", getCount);
		List<Video> videoList = videoDao.findByClass(map);
		if(videoList == null || videoList.size() < 1){
			videoList = new ArrayList<Video>();
			Video video = this.findByDefault(classNum);
			videoList.add(video);
		}
		return videoList;
	}

	@Override
	public Video findById(Long videoId) {
		return videoDao.findById(videoId);
	}

	@Override
	public Video findByDefault(Long classNum) {
		return videoDao.findByDefault(classNum);
	}

	@Override
	public List<Video> findAll() {
		return videoDao.findAll();
	}

	@Override
	public Video insertVideo(Video model) {
		Video video = videoDao.insertVideo(model);
		/*Long gradeId = null;
		if(Tool.isInt(video.getScopeType()) && video.getScopeType().intValue()==Const.SCOPE_CLASS){
			gradeId = Tool.toLong(video.getGradeIds());
		}
		// 极光推送
		BasePushTimed.PushMachine(PushCode.VIDEO, false, gradeId, null);*/
		return video;
	}

	@Override
	public Video updateVideo(Video model) {
		Video video = videoDao.updateVideo(model);
		/*if(video != null){
			model = this.findById(model.getVideoId());
			Long gradeId = null;
			if(Tool.isInt(model.getScopeType()) && model.getScopeType().intValue()==Const.SCOPE_CLASS){
				gradeId = Tool.toLong(model.getGradeIds());
			}
			// 极光推送
			BasePushTimed.PushMachine(PushCode.VIDEO, false, gradeId, null);
		}*/
		return video;
	}

}
