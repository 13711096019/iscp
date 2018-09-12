package com.cn.iscp.service.card.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.ClassMottoDao;
import com.cn.iscp.entity.card.ClassMotto;
import com.cn.iscp.service.card.ince.ClassMottoServicr;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;

@Service("classMottoServicr")
public class ClassMottoServicrImpl implements ClassMottoServicr{
	
	@Resource
	private ClassMottoDao classMottoDao;

	@Override
	public ClassMotto getByClassNum(Long classNum) {
		return classMottoDao.getByClassNum(classNum);
	}

	@Override
	public boolean handleClassMotto(ClassMotto model) {
		boolean revert = classMottoDao.handleClassMotto(model).intValue() > 0;
		if(revert){
			// 极光推送
			PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, model.getClassNum(), PushCode.CLASS_MOTTO);
			jdpust.buildPushNotAlert();
		}
		return revert;
	}

}
