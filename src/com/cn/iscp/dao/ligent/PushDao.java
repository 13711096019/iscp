package com.cn.iscp.dao.ligent;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.ligent.Push;
import com.cn.iscp.model.PushModel;

public interface PushDao {
	
	/**
	 * 修改过期数据状态
	 */
	Integer handleInvalidRecords(Integer pushCode);
	
	/**
	 * 获取推送对象
	 */
	Push getPushByCode(Integer pushCode);
	
	/**
	 * 所有班牌终端
	 */
	List<PushModel> findAllMachineCode();

	/**
	 * 根据年级获取班级列表
	 */
	List<PushModel> findByGrade(Long gradeId);
	
	/**
	 * 通知
	 */
	List<PushModel> findByNotice();
	
	/**
	 * 表扬
	 */
	List<PushModel> findByPraise();
	
	/**
	 * 视频
	 */
	List<PushModel> findByVideo();
	
	/**
	 * 获取所有老师
	 */
	List<PushModel> findAllTeacher();
	
	/**
	 * 提醒老师上课
	 */
	List<PushModel> findTeacherByNextClass(Long sessionId);
	
	/**
	 * 倒计时 
	 */
	List<PushModel> findByCountdown();
	
	/**
	 * 获取边教边研讨论老师
	 */
	List<PushModel> findTeacherByResearch(Map<String, Object> map);
	
	/**
	 * 获取群聊用户列表
	 */
	List<PushModel> findGroupChatUser(String groupId);
	
	/**
	 * 校信通知
	 */
	List<PushModel> findUserByNotify(Long notifyId);
	
	/**
	 * 获取没查看作业的家长列表
	 */
	List<PushModel> findPatriarchByNotCheckHomework(Long homeworkId);
	
	/**
	 * 获取当前需要提醒的日程提醒列表
	 */
	List<PushModel> findUserByCurrent();
	
	/**
	 * 老师请假推送
	 */
	List<PushModel> findTeacherByTeacherLeave(Map<String, Object> map);
	
	
}
