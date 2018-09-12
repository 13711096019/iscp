package com.cn.iscp.service.pay.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.pay.ChargeBill;

/**
 * 收费统计
 * @author xz
 * 2018-03-14
 */

public interface ChargeBillService {
	
	/**
	 * 获取收据凭证数据
	 */
	List<ChargeBill> findByStudent(ChargeBill model);

	/**
	 * 分页获取列表总数
	 */
	Long getPageCount(Map<String, Object> map);
		
	/**
	 * 根据编号获取列表
	 */
	ChargeBill findById(Long chargeBillId);
	
	/**
	 * 统计-全校班级缴费人数统计
	 */
	List<Map<String, Object>> findClassStudentCountCensus(Long chargeTypeId);
	
	/**
	 * 统计-全校类型统计
	 */
	List<Map<String, Object>> findTypeStudentCountCensus(Long classNum);
	
	/**
	 * 统计-根据班级学生缴费情况
	 */
	List<Map<String, Object>> findTypeStudentDetails(Long classNum);
	
	/**
	 * 统计-每日收入汇总表
	 */
	List<Map<String, Object>> findByDate(String payDate);

}
