package com.cn.unit.quartz.task;

import java.util.List;

import org.apache.log4j.Logger;

import com.cn.common._Tool;
import com.cn.iscp.entity.dbase.ClassEntityUpgrade;
import com.cn.iscp.entity.ligent.Push;
import com.cn.iscp.model.PushModel;
import com.cn.iscp.service.dbase.impl.ClassEntityServiceImpl;
import com.cn.iscp.service.ligent.impl.PushSericelImpl;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 推送方式
 * @author 10011037@qq.com
 * 2017-09-06
 */
public class BasePushTimed {
	
	private static Logger log = Logger.getLogger(BasePushTimed.class);
	
	
	/**
	 * 推送班牌机器码
	 * @param pushCode 推送码
	 * @param isQuartz 是否过滤过期数据
	 * @param gradeId 年级编号(存在推送该年级的班牌)
	 * @param calssNum 班级编号(存在推送该班级对应年级的班牌)
	 */
	public static void PushMachine(Integer pushCode, boolean isQuartz, Long gradeId, Long calssNum){
		Push push = handleInvalidRecords(pushCode, isQuartz);
		if(push == null){
			return;
		}
		String pushNick = "["+push.getPushNick()+"]";
		
		
		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
		List<PushModel> codeList = null;
		
		if(_Tool.isLong(calssNum)){
			// 根据动态班级编号获取年级编号
			ClassEntityServiceImpl classEntityService = (ClassEntityServiceImpl) SpringBeanFactoryUtil.getBean("classEntityService");
			ClassEntityUpgrade classes = classEntityService.getClassEntityUpgradeByKeyId(calssNum, null);
			gradeId = classes.getGradeId();
		}
		
		if(_Tool.isLong(gradeId)){
			// 根据年级推送所有班牌机器码
			codeList = pushSericel.findByGrade(gradeId);
		}else{
			// 获取所有班牌终端机器码
			codeList = pushSericel.findAllMachineCode();
		}
		
		// 推送班牌终端
		Integer pushCount = 0;
		for (PushModel pushModel : codeList) {
			log.info(pushNick+"极光推送：动态班级编号"+pushModel.getClassNum()+",机器码"+pushModel.getMachineCode());
			PushInvite jdpust = new PushInvite(pushModel.getMachineCode(), push, null);
			pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
		}
		log.info(pushNick+"共推送:"+pushCount+"条");
	}
	
	/**
	 * 过滤所有过期数据
	 * @param pushCode 推送码
	 * @param isQuartz 是否过滤过期数据
	 */
	public static Push handleInvalidRecords(Integer pushCode, boolean isQuartz){
		// 获取所有班牌终端机器码
		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
		// 获取推送对象
		Push push = pushSericel.getPushByCode(pushCode);
		if(isQuartz){
			String pushNick = "["+push.getPushNick()+"]";
			// 更新过期数据返回行数
			Integer rowCount = pushSericel.handleInvalidRecords(pushCode);
			if(!_Tool.isValid(rowCount)){
				log.info(pushNick+"没有更新的数据");
				return null;
			}
			log.info(pushNick+"更新数据"+rowCount+"条");
		}
		return push;
	}
	
}
