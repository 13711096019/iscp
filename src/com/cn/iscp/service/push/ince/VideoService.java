package com.cn.iscp.service.push.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.push.Video;

public interface VideoService {
	
	/**
	 * 根据班级获取播放视频
	 */
	List<Video> findByClass(Long classNum, Integer getCount);
	
	/**
	 * 根据编号获取视频对象
	 */
	Video findById(Long videoId);

	/**
	 * 获取班级默认视频
	 */
	Video findByDefault(Long classNum);
	
	/**
	 * 获取全部有效视频列表
	 */
	List<Video> findAll();

	/**
	 * PC-新增视频
	 */
	Video insertVideo(Video model);

	/**
	 * PC-编辑视频
	 */
	Video updateVideo(Video model);
	
}
