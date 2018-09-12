package com.cn.iscp.service.attend.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.attend.BusSplitCensusDao;
import com.cn.iscp.dao.ligent.PushDao;
import com.cn.iscp.entity.attend.BusSplitCensus;
import com.cn.iscp.entity.ligent.Push;
import com.cn.iscp.service.attend.ince.BusSplitCensusService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;

@Service("busSplitCensusService")
public class BusSplitCensusServiceImpl implements BusSplitCensusService {
	
	@Resource
	private BusSplitCensusDao busSplitCensusDao;
	@Resource
	private PushDao pushDao;
	
	@Override
	public void handleStudentSplit(String studentCardPhys, String attendTimes, Integer attendType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentCardPhys", studentCardPhys);
		map.put("attendTimes", attendTimes);
		map.put("attendType", attendType);
		List<BusSplitCensus> splitList = busSplitCensusDao.handleStudentSplit(map);
		if(splitList != null && splitList.size() > 0){
			String pushDesc = null;
			for (BusSplitCensus item : splitList) {
				pushDesc = String.format(item.getPushContent(attendType), item.getUserName());
				Push push = pushDao.getPushByCode(PushCode.REMIND_STUDENT_ATTEND);
				push.setPushDesc(pushDesc);
				PushInvite invite = new PushInvite(item.getUserKey(), push, null);
				invite.buildPushHasExtra();
			}
		}
	}
	
}
