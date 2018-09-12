package com.cn.iscp.service.pay.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.pay.ChargeConsutlDao;
import com.cn.iscp.dao.pay.ChargeConsutlItemDao;
import com.cn.iscp.entity.pay.ChargeConsutl;
import com.cn.iscp.service.pay.ince.ChargeConsutlService;

@Service("chargeConsutlService")
public class ChargeConsutlServiceImpl implements ChargeConsutlService {

	@Resource
	private ChargeConsutlDao chargeConsutlDao;
	@Resource
	private ChargeConsutlItemDao chargeConsutlItemDao;
	
	@Override
	public ChargeConsutl findConsult(ChargeConsutl model) {
		ChargeConsutl consult = chargeConsutlDao.findByStudent(model);
		if(consult != null){
			consult.setItemList(chargeConsutlItemDao.findByConsult(consult.getConsutlId()));
		}
		return consult;
	}
	
	@Override
	public ChargeConsutl updateConsutl(Map<String, Object> map) {
		return chargeConsutlDao.updateConsutl(map);
	}

}
