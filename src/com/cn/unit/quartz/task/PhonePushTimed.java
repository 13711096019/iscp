package com.cn.unit.quartz.task;

import java.util.List;

import org.apache.log4j.Logger;

import com.cn.common._Tool;
import com.cn.iscp.entity.ligent.Push;
import com.cn.iscp.model.PushModel;
import com.cn.iscp.service.ligent.impl.PushSericelImpl;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 手机推送定时器
 * @author 10011037@qq.com
 * 2017-07-18
 */
public class PhonePushTimed {

	private static Logger log = Logger.getLogger(PhonePushTimed.class);
	
	/**
	 * 老师收到学生请假通知
	 */
	public static void PushLeaveTeacher(String teacherKey, Long leaveId){
		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_STUDENT_LEAVE, false);
		if(push != null){
			push.setKeyId(_Tool.toStr(leaveId));
			log.info("[老师收到学生请假通知"+push.getPushCode()+"]极光推送：用户类型：2\t用户账号" + teacherKey);
			PushInvite jdpust = new PushInvite(teacherKey, push, null);
			try {
				jdpust.buildPushHasExtra();
			} catch (Exception e) {
				log.info("[老师收到学生请假通知]推送失败！");
			}
		}
	}
	
	/**
	 * 家长收到老师查阅请假通知
	 */
	public static void PushLeavePatriarch(String userKey, Long leaveId){
		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_TEACHER_CONSULT_LEAVE, false);
		if(push != null){
			push.setKeyId(_Tool.toStr(leaveId));
			log.info("[家长收到老师查阅请假通知"+push.getPushCode()+"]极光推送：用户类型：1\t用户账号" + userKey);
			PushInvite jdpust = new PushInvite(userKey, push, null);
			try {
				jdpust.buildPushHasExtra();
			} catch (Exception e) {
				log.info("[家长收到老师查阅请假通知]推送失败！");
			}
		}
	}
	
	/**
	 * 出勤报表
	 */
	public static void PushDailyStatistics(){
		// 获取所有老师
		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
		List<PushModel> codeList = pushSericel.findAllTeacher();
		
		Push push = BasePushTimed.handleInvalidRecords(PushCode.ATTEND_DAILY_STATISTICS, false);
		Integer pushCount = 0;
		for (PushModel pushModel : codeList) {
			log.info("[出勤报表"+push.getPushCode()+"]极光推送：用户账号" + pushModel.getUserKey());
			PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
			try {
				pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
			} catch (Exception e) {
				continue;
			}
		}
		log.info("出勤报表推送数量:"+pushCount);
	}
	
	/**
	 * 提醒老师上课
	 
	public static void PushAttendClassTeacher(){
		// 获取5分钟后的时间(09:00)
	 	String schoolTime = DateUtil.getDifferentTime(5, DateUtil.H_M, "minute");
		String newDate = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD);
	 	String sessionTime = null;
		// 班次业务逻辑
		SessionServiceImpl sessionService = (SessionServiceImpl) SpringBeanFactoryUtil.getBean("sessionService");
		List<Session> sessionList = sessionService.findAll();
		for (Session session : sessionList) {
			Long sessionId = session.getSessionId();
			sessionTime = DateUtil.getStrByStr(newDate+" "+session.getStartTime(), DateUtil.H_M);
			Integer pushCode = null;
			if(schoolTime.equals(sessionTime)){
				pushCode = PushCode.REMIND_TEACHERCLASS;
			}
			
			if(_Tool.isValid(pushCode)){
				// 获取下节课老师列表
				PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
				List<PushModel> codeList = pushSericel.findTeacherByNextClass(sessionId);
				
				if(codeList == null || codeList.size() < 1)
					break;
				
				// 获取推送对象
				Push push = pushSericel.getPushByCode(pushCode);
				
				Integer pushCount = 0;
				for (PushModel pushModel : codeList) {
					log.info("[提醒老师上课"+pushCode+"]极光推送：用户账号" + pushModel.getUserKey());
					PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
					try {
						pushCount = jdpust.buildPushHasAlert(0) ? (pushCount+1) : pushCount;
					} catch (Exception e) {
						continue;
					}
				}
				log.info("[提醒老师上课]共推送:"+pushCount+"条");
				break;
			}
		}
		log.info("[提醒老师上课]没到推送时间");
	}*/
	
	/**
	 * 日程提醒
	 
	public static void PushCalendar(){
		// 日程逻辑层
		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
		List<PushModel> codeList = pushSericel.findUserByCurrent();
		
		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_CALENDAR, false);
		Integer pushCount = 0;
		for (PushModel pushModel : codeList) {
			int pushKey = pushModel.getUserType().intValue() == 1 ? PushKey.CODE_PATRIARCH : PushKey.CODE_TEACHER;
			push.setPushKey(pushKey);
			push.setKeyId(_Tool.toStr(pushModel.getKeyId()));
			log.info("[日程提醒"+push.getPushCode()+"]极光推送：用户账号" + pushModel.getUserKey());
			PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
			try {
				pushCount = jdpust.buildPushHasExtra() ? (pushCount+1) : pushCount;
			} catch (Exception e) {
				continue;
			}
		}
	}*/
	
	/**
	 * 边教边研推送
	 
	public static void PushResearchTeacher(Long researchId, Long createUserId, boolean isCircular){
		// 获取边教边研讨论老师
		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("researchId", researchId);
		map.put("createUserId", createUserId);
		List<PushModel> codeList = pushSericel.findTeacherByResearch(map);
		
		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_RESEARCH, false);
		if(push != null){
			Integer pushCount = 0;
			for (PushModel pushModel : codeList) {
				push.setKeyId(_Tool.toStr(researchId));
				log.info("[边教边研"+push.getPushCode()+"]极光推送：用户账号" + pushModel.getUserKey());
				PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
				try {
					if(isCircular){
						pushCount = jdpust.buildPushHasExtra() ? (pushCount+1) : pushCount;
					}else{
						pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
	}*/
	
	/**
	 * 群聊信息更新推送
	 
	public static void PushGroupChatUser(String groupId, String groupName){
		// 获取边教边研讨论老师
		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
		List<PushModel> codeList = pushSericel.findGroupChatUser(groupId);
		
		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_GROUPCHAT, false);
		Integer pushCount = 0;
		for (PushModel pushModel : codeList) {
			int pushKey = pushModel.getUserType().intValue() == 1 ? PushKey.CODE_PATRIARCH : PushKey.CODE_TEACHER;
			push.setPushKey(pushKey);
			push.setKeyId(groupId);
			log.info("[群聊信息更新"+push.getPushCode()+"]极光推送：用户账号" + pushModel.getUserKey());
			PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, groupName);
			try {
				pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
			} catch (Exception e) {
				continue;
			}
		}
	}*/
	
	/**
	 * 校信通知推送
	 
	public static void PushNotifyUser(Long notifyId, boolean isCircular){
		// 获取边教边研讨论老师
		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
		List<PushModel> codeList = pushSericel.findUserByNotify(notifyId);
		
		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_NOTIFY, false);
		if(push != null){
			Integer pushCount = 0;
			for (PushModel pushModel : codeList) {
				int pushKey = pushModel.getUserType().intValue() == 1 ? PushKey.CODE_PATRIARCH : PushKey.CODE_TEACHER;
				push.setPushKey(pushKey);
				push.setKeyId(_Tool.toStr(notifyId));
				log.info("[校信通知"+push.getPushCode()+"]极光推送：用户类型："+pushModel.getUserType()+"\t"+pushKey+"用户账号" + pushModel.getUserKey());
				PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
				try {
					if(isCircular){
						pushCount = jdpust.buildPushHasExtra() ? (pushCount+1) : pushCount;
					}else{
						pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
	}*/
	
	/**
	 * 没查看作业的家长推送
	 
	public static void PushNotCheckHomeworkPatriarch(Long homeworkId){
		// 获取边教边研讨论老师
		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
		List<PushModel> codeList = pushSericel.findPatriarchByNotCheckHomework(homeworkId);
		
		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_NOTCHECKHOMEWORK, false);
		if(push != null){
			Integer pushCount = 0;
			for (PushModel pushModel : codeList) {
				push.setKeyId(_Tool.toStr(homeworkId));
				log.info("[校信通知"+push.getPushCode()+"]极光推送：用户类型："+pushModel.getUserType()+"\t用户账号" + pushModel.getUserKey());
				PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
				try {
					pushCount = jdpust.buildPushHasExtra() ? (pushCount+1) : pushCount;
				} catch (Exception e) {
					continue;
				}
			}
		}
	}*/
	
}
