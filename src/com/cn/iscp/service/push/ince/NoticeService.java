package com.cn.iscp.service.push.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.push.Notice;

public interface NoticeService {
	
	/**
	 * PC-根据编号获取对象
	 */
	Notice findById(Long noticeId);
	
	/**
	 * 终端-根据班级获取三条通知公告列表
	 */
	List<Notice> findThreeByClass(Long classNum, Integer noticeType);
	
	/**
	 * 终端-根据班级获取全部有效通知公告列表
	 */
	List<Notice> findAllByClass(Long classNum, Integer noticeType);

	/**
	 * PC-获取全部有效通知列表
	 */
	List<Notice> findByValid(Map<String, Object> map);
	
	/**
	 * PC-获取无效通知列表
	 */
	List<Notice> findByInvalid(Map<String, Object> map);
	
	/**
	 * PC-新增通知
	 */
	Notice insertNotice(Notice model);

	/**
	 * PC-更新通知
	 */
	boolean updateNotice(Notice model);
	
}
