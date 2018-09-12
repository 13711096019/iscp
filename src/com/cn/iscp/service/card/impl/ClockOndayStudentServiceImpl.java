package com.cn.iscp.service.card.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.dao.card.ClockOndayClassDao;
import com.cn.iscp.dao.card.ClockOndayStudentDao;
import com.cn.iscp.entity.card.ClockOndayClass;
import com.cn.iscp.entity.card.ClockOndayStudent;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.card.ince.ClockOndayStudentService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;

@Service("clockOndayStudentService")
public class ClockOndayStudentServiceImpl implements ClockOndayStudentService {
	
	private static Logger log = Logger.getLogger(ClockOndayStudentServiceImpl.class);
	
	@Resource
	private ClockOndayStudentDao clockOndayStudentDao;
	@Resource
	private ClockOndayClassDao clockOndayClassDao;

	@Override
	public StateModel punchTheClockOneStudent(ClockOndayStudent model) {
		return clockOndayStudentDao.insertClockOnDay(model);
	}

	@Override
	public StateModel punchTheClockManyStudent(Long classNum, String json) {
		List<ClockOndayStudent> list = JSON.parseArray(json, ClockOndayStudent.class);
		Integer count = 0;
		if(list != null && list.size() > 0){
			count = list.size();
			StateModel state = null;
			for (ClockOndayStudent model : list) {
				model.setClassNum(classNum);
				model.setClockLocationId(_Const.CLOCK_LOCATION_CLASS_GATE);
				state = clockOndayStudentDao.insertClockOnDay(model);
				log.info("学生卡["+model.getStudentCardPhy()+"]\t插入状态:"+_Tool.toJson(state));
			}
		}
		log.info("动态班级编号["+classNum+"]录入["+count+"]条学生打卡信息");
		
		// 按日期统计班级考勤
		ClockOndayClass model = new ClockOndayClass(classNum);
		ClockOndayClass clockOndayClass = clockOndayClassDao.censusClassAttendance(model);
		return new StateModel(clockOndayClass);
	}
	
	@Override
	public List<ClockOndayStudent> findByDate(ClockOndayStudent model) {
		return clockOndayStudentDao.findByDate(model);
	}

	@Override
	public boolean handleClockOnDay(ClockOndayStudent model) {
		Long logId = clockOndayStudentDao.handleClockOnDay(model);
		boolean revert = logId.intValue() > 0;
		if(revert){
			Long classNum = model.getClassNum();
			// 更新班级考勤统计
			clockOndayClassDao.censusClassAttendance(new ClockOndayClass(classNum));
			// 推送班牌终端
			PushInvite invite = new PushInvite(PushKey.CODE_TERMINAL, classNum, PushCode.CLASS_CLOCKONDAY);
			invite.buildPushNotAlert();
		}
		return revert;
	}

}
