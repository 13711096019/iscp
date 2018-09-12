package com.cn.iscp.service.ligent.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.ligent.PushDao;
import com.cn.iscp.entity.ligent.Push;
import com.cn.iscp.model.PushModel;
import com.cn.iscp.service.ligent.ince.PushSericel;

@Service("pushSericel")
public class PushSericelImpl implements PushSericel {
	
	@Resource
	private PushDao pushDao;

	@Override
	public Integer handleInvalidRecords(Integer pushCode) {
		return pushDao.handleInvalidRecords(pushCode);
	}

	@Override
	public Push getPushByCode(Integer pushCode) {
		return pushDao.getPushByCode(pushCode);
	}

	@Override
	public List<PushModel> findAllMachineCode() {
		return pushDao.findAllMachineCode();
	}

	@Override
	public List<PushModel> findByGrade(Long gradeId) {
		return pushDao.findByGrade(gradeId);
	}

	@Override
	public List<PushModel> findByNotice() {
		return pushDao.findByNotice();
	}

	@Override
	public List<PushModel> findByPraise() {
		return pushDao.findByPraise();
	}

	@Override
	public List<PushModel> findByVideo() {
		return pushDao.findByVideo();
	}

	@Override
	public List<PushModel> findTeacherByNextClass(Long sessionId) {
		return pushDao.findTeacherByNextClass(sessionId);
	}

	@Override
	public List<PushModel> findByCountdown() {
		return pushDao.findByCountdown();
	}

	@Override
	public List<PushModel> findAllTeacher() {
		return pushDao.findAllTeacher();
	}

	@Override
	public List<PushModel> findTeacherByResearch(Map<String, Object> map) {
		return pushDao.findTeacherByResearch(map);
	}

	@Override
	public List<PushModel> findGroupChatUser(String groupId) {
		return pushDao.findGroupChatUser(groupId);
	}

	@Override
	public List<PushModel> findUserByNotify(Long notifyId) {
		return pushDao.findUserByNotify(notifyId);
	}

	@Override
	public List<PushModel> findPatriarchByNotCheckHomework(Long homeworkId) {
		return pushDao.findPatriarchByNotCheckHomework(homeworkId);
	}

	@Override
	public List<PushModel> findUserByCurrent() {
		return pushDao.findUserByCurrent();
	}

	@Override
	public List<PushModel> findTeacherByTeacherLeave(Long leaveId, Long loginUserId, Integer isAuditor) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("leaveId", leaveId);
		map.put("loginUserId", loginUserId);
		map.put("isAuditor", isAuditor);
		return pushDao.findTeacherByTeacherLeave(map);
	}

}
