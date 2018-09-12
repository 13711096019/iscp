package com.cn.paas.jiguang.push;

import com.cn.unit.quartz.task.BasePushTimed;

public class Test {

	public static void main(String[] args) {
		/**
		 * 演讲固定测试日期
		 * p_dbase_findSubjectByTeacher
		 * p_card_getCurrentLesson
		 */
		PushInvite jdpust = null;
		
		BasePushTimed.PushMachine(16020, false, null, null);
		
		/*// 开启考试模式
		jdpust = new PushInvite(PushKey.CODE_TERMINAL, "0E7RGDRDYR", PushCode.PATTERN_EXAM);
		jdpust.buildPushNotAlert();*/
		
		// 关闭考试模式
		/*jdpust = new PushInvite(PushKey.CODE_TERMINAL, "0E7RGDRDYR", PushCode.PATTERN_EXAM*10);
		jdpust.buildPushNotAlert();*/
		
		/*// 创文(t_card_createcivilization_classscore)
		jdpust = new PushInvite(PushKey.CODE_TERMINAL, "0E7RGDRDYR", PushCode.CIVILIZED);
		jdpust.buildPushNotAlert();*/
		
		/*// 启动课堂信息(p_card_getCurrentLesson)
		jdpust = new PushInvite(PushKey.CODE_TERMINAL, "0E7RGDRDYR", PushCode.CLASS_ROOM);
		jdpust.buildPushNotAlert();*/

		/*// 关闭课堂信息
		jdpust = new PushInvite(PushKey.CODE_TERMINAL, "0E7RGDRDYR", PushCode.CLASS_ROOM*10);
		jdpust.buildPushNotAlert();*/
		
		/*// 手机端上课提醒
		Push push = new Push(3702, PushCode.REMIND_TEACHERCLASS, 
				"/iscp/mt/card/course/findSubjectList",
				"还有5分钟就要上课了，别忘记准备哦！",
				"老师上课提醒");
		jdpust = new PushInvite("13679797665", push);
		jdpust.buildPushHasAlert();*/
		
		/*// 终端版本更新
		Map<String, Object> content = new HashMap<String, Object>();
    	content.put("keyNum", PushCode.VERSION_APK);
    	content.put("nozzle", PushCode.INTERFACE_PATH.get(PushCode.VERSION_APK));
    	content.put("apkId", 9);
		jdpust = new PushInvite(PushKey.CODE_TERMINAL, "0E7RGDRDYR", content);
		jdpust.buildPushNotAlert();*/
	}

}
