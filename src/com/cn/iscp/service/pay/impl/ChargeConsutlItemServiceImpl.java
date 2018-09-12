package com.cn.iscp.service.pay.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.pay.ChargeConsutlItemDao;
import com.cn.iscp.entity.pay.ChargeConsutlItem;
import com.cn.iscp.service.pay.ince.ChargeConsutlItemService;

@Service("chargeConsutlItemService")
public class ChargeConsutlItemServiceImpl implements ChargeConsutlItemService {

	@Resource
	private ChargeConsutlItemDao chargeConsutlItemDao;
	
	@Override
	public List<ChargeConsutlItem> findByConsult(Long consutlId) {
		return chargeConsutlItemDao.findByConsult(consutlId);
	}

}
