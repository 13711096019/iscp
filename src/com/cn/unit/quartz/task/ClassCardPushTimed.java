package com.cn.unit.quartz.task;

import java.util.List;

import org.apache.log4j.Logger;

import com.cn.common._Tool;
import com.cn.iscp.entity.base.Session;
import com.cn.iscp.model.PushModel;
import com.cn.iscp.service.base.impl.SessionServiceImpl;
import com.cn.iscp.service.ligent.impl.PushSericelImpl;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.utils.DateUtil;

/**
 * 班牌推送定时器
 * @author 10011037@qq.com
 * 2017-07-18
 */
public class ClassCardPushTimed {
	
	private static Logger log = Logger.getLogger(ClassCardPushTimed.class);

	/**
	 * 推送课堂信息
	 
	public static void PushCurrentLesson(){
		String nowTime = DateUtil.getStrByDate(null, DateUtil.H_M);
		String nowDate = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD);
		// 班次业务逻辑
		SessionServiceImpl sessionService = (SessionServiceImpl) SpringBeanFactoryUtil.getBean("sessionService");
		List<Session> sessionList = sessionService.findAll();
		for (Session session : sessionList) {
			Integer pushCode = null;
			if(nowTime.equals(DateUtil.getStrByStr(nowDate+" "+session.getStartTime(), DateUtil.H_M))){
				pushCode = PushCode.CLASS_ROOM;
			}else if(nowTime.equals(DateUtil.getStrByStr(nowDate+" "+session.getEndTime(), DateUtil.H_M))){
				pushCode = PushCode.CLASS_ROOM * 10;
			}
			if(_Tool.isValid(pushCode)){
				// 所有有效班牌机器码
				PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
				List<PushModel> codeList = pushSericel.findAllMachineCode();
				
				// 没有课程直接推送关闭
				CourseTableServiceImpl courseTableService = (CourseTableServiceImpl) SpringBeanFactoryUtil.getBean("courseTableService");
				StateModel state = courseTableService.getCurrentLesson(codeList.get(0).getClassNum());
				if(state.getData()==null){
					pushCode = PushCode.CLASS_ROOM * 10;
				}
				
				Integer pushCount = 0;
				for (PushModel pushModel : codeList) {
					log.info("[课堂"+pushCode+"]极光推送：动态班级编号" + pushModel.getClassNum() + ",机器码" + pushModel.getMachineCode());
					PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, pushModel.getMachineCode(), pushCode);
					pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
				}
				log.info("[课堂]共推送:"+pushCount+"条");
				break;
			}
		}
		log.info("[课堂]没到推送时间");
	}*/


	/**
	 * 推送表扬
	 */
	/*public static void PushPraise(boolean isQuartz){
		// 表扬业务逻辑
		PraiseServiceImpl praiseService = (PraiseServiceImpl) SpringBeanFactoryUtils.getBean("praiseService");
		if(isQuartz){
			// 表扬规则业务逻辑
			PraiseRuleServiceImpl praiseRuleService = (PraiseRuleServiceImpl) SpringBeanFactoryUtils.getBean("praiseRuleService");
			// 获取默认表扬规则
			PraiseRule rule = praiseRuleService.getPraiseRule();
			if(rule == null){
				log.info("[表扬]没设置默认规则!");
				return;
			}

			String carouselTime = rule.getCarouselTime();
			String newTime = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD_HH_MM_SS);
			String distTime = null;
			if(rule.getAllowCarousel().intValue() == 0){
				log.info("[表扬]轮播方式：非轮播!");
				if(rule.getAlreadyPlayed().intValue()==1){
					log.info("[表扬]该规则已经播放!");
					return;
				}
				distTime = newTime;
			}else{
				log.info("[表扬]轮播方式：轮播!");
				int cycleUnit = Tool.toInt(rule.getCycleUnit()).intValue();
				String mark = cycleUnit==1 ? "second" : (cycleUnit==2 ? "minute" : (cycleUnit==3 ? "hour" : (cycleUnit==4 ? "date" : "month")));
				distTime = DateUtil.getDifferentTime(-rule.getInteral(), DateUtil.YYYY_MM_DD_HH_MM_SS, mark);
			}
			if(!Tool.isEmpty(carouselTime) && DateUtil.compareDate(distTime, carouselTime)){
				log.info("[表扬]还没到轮播时间!");
				return;
			}
			
			// 修改规则时间
			Long ruleId = rule.getRuleId();
			rule = new PraiseRule(ruleId, newTime, 1);
			praiseRuleService.updCarouselTime(rule);
			
			// 更新过期表扬状态
			if(!praiseService.updInvalidPraise()){
				log.info("[表扬]没有更新的表扬");
				return;
			}
		}
		
		// 获取需要推送的机器码
		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtils.getBean("pushSericel");
		// List<PushModel> codeList = pushSericel.findByPraise();
		List<PushModel> codeList = pushSericel.findAllMachineCode();
		// 推送数量
		Integer pushCount = 0;
		Integer pushCode = PushCode.CLASS_PRAISE;
		for (PushModel pushModel : codeList) {
			// 极光推送
			log.info("[表扬"+pushCode+"]极光推送：动态班级编号" + pushModel.getClassNum() + ",机器码" + pushModel.getMachineCode());
			PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, pushModel.getMachineCode(), pushCode);
			pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
		}
		log.info("[表扬]共推送:"+pushCount+"条");
	}*/
	
	/**
	 * 推送模式
	 
	public static void PushPattern(){
		// 当前时间
		String newTime = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD_HH_MM_SS);
		String newDate = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD);
		// 所有有效班牌机器码
		PatternServiceImpl patternService = (PatternServiceImpl) SpringBeanFactoryUtil.getBean("patternService");
		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
		List<PushModel> codeList = pushSericel.findAllMachineCode();
		
		// 推送标识码
		Integer pushCount = 0;
		for (PushModel pushModel : codeList) {
			Long classNum = pushModel.getClassNum();
			Pattern pattern = patternService.getMostUrgentPattern(classNum);
			if(pattern == null){
				// 当前没有需要操作的模式!
				continue;
			}
			// 获取模式推送码
			Integer pushCode = _Tool.toInt(pattern.getItemFileNick());
			int startMin = DateUtil.getTimeDifferent(newDate + " " + pattern.getStartTime(), newTime, "minute");
			int endMin = DateUtil.getTimeDifferent(newDate + " " + pattern.getEndTime(), newTime, "minute");
			// 模式开关(1启动模式,0关闭模式)
			if(startMin >= 0 && startMin < 3){
				log.info("[模式]启动模式!");
			}else if(endMin >= 0 && endMin < 3){
				log.info("[模式]关闭模式!");
				pushCode = pushCode * 10;
			}else{
				// 模式已经处理
				continue;
			}
			
			log.info("[模式"+pushCode+"]极光推送：动态班级编号" + classNum + ",机器码" + pushModel.getMachineCode());
			PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, pushModel.getMachineCode(), pushCode);
			pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
		}
		log.info("[模式]共推送:"+pushCount+"条");
	}*/
	
	
	/**
	 * 提醒上传打卡记录
	 */
	public static void PushUploadPunchTheClock(){
		// 当前时间(时:分)
	 	String nowTime = DateUtil.getStrByDate(null, DateUtil.H_M);
		String sessionTime = null;
		// 班次业务逻辑
		SessionServiceImpl sessionService = (SessionServiceImpl) SpringBeanFactoryUtil.getBean("sessionService");
		List<Session> sessionList = sessionService.findAll();
		for (Session session : sessionList) {
			// 获取当前时间与上课时间两个时间差
			sessionTime = session.getStartTime();
			int difTime = DateUtil.getTimeDifferent(sessionTime, nowTime, "minute");
			// 大于10分钟或者小于1分钟不在这次提醒范围内,直接跳过
			if(difTime<=0 || difTime>10){
				continue;
			}
			// 推送标识码
			Integer pushCode = PushCode.STUDENT_PUNCH_THE_CLOCK;
			// 推送个数
			Integer pushCount = 0;
			
			// 所有有效班牌机器码
			PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
			List<PushModel> codeList = pushSericel.findAllMachineCode();
			Long classNum = null;
			int random = 0;
			for (PushModel pushModel : codeList) {
				// 分批推送,按动态班级编号的个位分批(个位为1,上课一分钟后推送;个位为2,上课两分钟后推送;如此类推)
				classNum = pushModel.getClassNum();
				random = 1 + _Tool.toInt(_Tool.toStr(classNum).substring(_Tool.toStr(classNum).length()-1));
				if(random == difTime){
					log.info("[提醒上传打卡记录"+pushCode+"]极光推送：动态班级编号[" + classNum + "],机器码[" + pushModel.getMachineCode()+"],已上课["+difTime+"]分钟");
					PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, pushModel.getMachineCode(), pushCode);
					pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
				}
			}
			log.info("[提醒上传打卡记录]共推送:["+pushCount+"]条");
			break;
		}
	}
	
}
