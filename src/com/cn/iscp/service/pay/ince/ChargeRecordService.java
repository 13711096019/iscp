package com.cn.iscp.service.pay.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.pay.ChargeRecord;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;

public interface ChargeRecordService {

	/**
	 * 分页获取缴费记录
	 */
	PageModel findByPage(Map<String, Object> map);
	
	/**
	 * 根据编号获取对象
	 */
	ChargeRecord findById(Long recordId);
	
	/**
	 * 缴费预支付
	 */
	StateModel insertChargeRecord(ChargeRecord model);
	
	/**
	 * 处理缴费支付账单
	 */
	StateModel handleChargeRecord(ChargeRecord model);
	
	/**
	 * 根据学生获取收据
	 */
	List<ChargeRecord> findReceipt(ChargeRecord model);

	/**
	 * 修改缴费记录信息
	 */
	ChargeRecord updateReceipt(ChargeRecord model);
	
}
