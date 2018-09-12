package com.cn.iscp.service.pay.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.pay.ChargeBillDao;
import com.cn.iscp.dao.pay.ChargeRecordDao;
import com.cn.iscp.entity.pay.ChargeRecord;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.ligent.BaseSericel;
import com.cn.iscp.service.pay.ince.ChargeRecordService;
import com.cn.paas.wechat.WechatPayment;

@Service("chargeRecordService")
public class ChargeRecordServiceImpl extends BaseSericel implements ChargeRecordService {

	@Resource
	private ChargeRecordDao chargeRecordDao;
	@Resource
	private ChargeBillDao chargeBillDao;

	@Override
	public PageModel findByPage(Map<String, Object> map) {
		List<List<?>> list = chargeRecordDao.findByPage(map);
		return getMapByPage(list);
	}

	@Override
	public ChargeRecord findById(Long recordId) {
		return chargeRecordDao.findById(recordId);
	}
	
	@Override
	public StateModel insertChargeRecord(ChargeRecord model) {
		ChargeRecord chargeRecord = chargeRecordDao.insertChargeRecord(model);
		if(model.getPayWay().intValue() != 3){

			Double rechargeMoney = chargeRecord.getTotalPrice();
			Map<String, Object> dataMap = null;
			if(new BigDecimal(rechargeMoney).compareTo(new BigDecimal(0)) > 0){
				WechatPayment wechatPayment = new WechatPayment(chargeRecord.getTotalPrice(), 
						chargeRecord.getOrderNo(), chargeRecord.getTitle());
				dataMap = wechatPayment.wechatPayment();
				// dataMap.put("recordId", chargeRecord.getRecordId());
			}else{
				dataMap = new HashMap<String, Object>();
			}
			return new StateModel(dataMap);
		}
		return new StateModel(chargeRecord);
	}

	@Override
	public StateModel handleChargeRecord(ChargeRecord model) {
		return chargeRecordDao.handleChargeRecord(model);
	}

	@Override
	public List<ChargeRecord> findReceipt(ChargeRecord model) {
		List<ChargeRecord> receiptList = chargeRecordDao.findReceipt(model);
		for (ChargeRecord record : receiptList) {
			System.out.println(record.getRecordId());
			record.setBillList(chargeBillDao.findByRecord(record.getRecordId()));
		}
		return receiptList;
	}

	@Override
	public ChargeRecord updateReceipt(ChargeRecord model) {
		return chargeRecordDao.updateReceipt(model);
	}

}
