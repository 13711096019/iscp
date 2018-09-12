package com.cn.iscp.service.card.impl.exam;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.exam.ExamDescSeatingDao;
import com.cn.iscp.entity.card.exam.ExamDescSeating;
import com.cn.iscp.service.card.ince.exam.ExamDescSeatingService;

@Service("examDescSeatingService")
public class ExamDescSeatingServiceImpl implements ExamDescSeatingService {
	
	@Resource
	private ExamDescSeatingDao examDescSeatingDao;
	
	@Override
	public List<ExamDescSeating> findByClass(ExamDescSeating model) {
		return examDescSeatingDao.findByClass(model);
	}

	@Override
	public void handleSeatingChart(ExamDescSeating model) {
		examDescSeatingDao.handleSeatingChart(model);
		// 推送到终端
		//PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, model.getClassNum(), PushCode.CLASS_SEATING);
		//jdpust.buildPushNotAlert();
	}

}
