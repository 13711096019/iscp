package com.cn.iscp.service.pay.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Tool;
import com.cn.iscp.dao.pay.ChargeBillDao;
import com.cn.iscp.entity.pay.ChargeBill;
import com.cn.iscp.service.pay.ince.ChargeBillService;

@Service("chargeBillService")
public class ChargeBillServiceImpl implements ChargeBillService{
	
	@Resource
	private ChargeBillDao chargeBillDao;

	@Override
	public List<ChargeBill> findByStudent(ChargeBill model) {
		return chargeBillDao.findByStudent(model);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return chargeBillDao.getPageCount(map);
	}

	@Override
	public ChargeBill findById(Long chargeBillId) {
		return chargeBillDao.findById(chargeBillId);
	}

	@Override
	public List<Map<String, Object>> findClassStudentCountCensus(Long chargeTypeId) {
		return chargeBillDao.findClassStudentCountCensus(chargeTypeId);
	}

	@Override
	public List<Map<String, Object>> findTypeStudentCountCensus(Long classNum) {
		return chargeBillDao.findTypeStudentCountCensus(classNum);
	}

	@Override
	public List<Map<String, Object>> findTypeStudentDetails(Long classNum) {
		return chargeBillDao.findTypeStudentDetails(classNum);
	}

	@Override
	public List<Map<String, Object>> findByDate(String payDate) {
		// 小学学杂费
		List<ChargeBill> smallTuitionList = new ArrayList<ChargeBill>();
		// 中学学杂费
		List<ChargeBill> centreTuitionList = new ArrayList<ChargeBill>();
		// 车费
		List<ChargeBill> fareList = new ArrayList<ChargeBill>();
		// 餐费
		List<ChargeBill> mealsList = new ArrayList<ChargeBill>();
		// 校服
		List<ChargeBill> uniformList = new ArrayList<ChargeBill>();
		// 通讯费
		List<ChargeBill> messageList = new ArrayList<ChargeBill>();
		
		int count[] = new int[100];
		List<ChargeBill> billList = chargeBillDao.findByDate(payDate);
		for (ChargeBill bill : billList) {
			int typeId = bill.getChargeTypeId().intValue();
			count[typeId] = count[typeId] + 1;
			if(typeId == 0){
				smallTuitionList.add(bill);
			}else if(typeId == 1){
				centreTuitionList.add(bill);
			}else if(typeId == 2){
				fareList.add(bill);
			}else if(typeId == 3){
				mealsList.add(bill);
			}else if(typeId == 5){
				uniformList.add(bill);
			}else if(typeId == 6){
				messageList.add(bill);
			}
		}
		
		// 获取最大值
		int max = count[0];
        for(int i=0; i<count.length; i++) {
            if(count[i]>max)
                max = count[i];
        }
		
        // 声明返回list
        List<Map<String, Object>> revertList = new ArrayList<Map<String,Object>>();
        Map<String, Object> tmpMap = null;
        ChargeBill tmpBill = null;
        for (int i = 0; i < max; i++) {
        	tmpMap = new HashMap<String, Object>();
        	tmpBill = null;
        	if(smallTuitionList.size() > i){
        		tmpBill =  smallTuitionList.get(i);
        	}
        	if(tmpBill!=null && tmpBill.getPayCount().intValue() > 0){
	    		tmpMap.put("smallTuitionCount", tmpBill.getPayCount());
	    		tmpMap.put("smallTuitionPrice", _Tool.toInt(tmpBill.getTotalPrice()));
        	}
	    	tmpBill = null;
        	if(centreTuitionList.size() > i){
        		tmpBill = centreTuitionList.get(i);
        	}
        	if(tmpBill!=null && tmpBill.getPayCount().intValue() > 0){
	    		tmpMap.put("centreTuitionCount", tmpBill.getPayCount());
	    		tmpMap.put("centreTuitionPrice", _Tool.toInt(tmpBill.getTotalPrice()));
        	}
        	tmpBill = null;
        	if(fareList.size() > i){
        		tmpBill = fareList.get(i);
        	}
        	if(tmpBill!=null && tmpBill.getPayCount().intValue() > 0){
	    		tmpMap.put("fareCount", tmpBill.getPayCount());
	    		tmpMap.put("farePrice", _Tool.toInt(tmpBill.getTotalPrice()));
        	}
        	tmpBill = null;
        	if(mealsList.size() > i){
        		tmpBill = mealsList.get(i);
        	}
        	if(tmpBill!=null && tmpBill.getPayCount().intValue() > 0){
	    		tmpMap.put("mealsCount", tmpBill.getPayCount());
	    		tmpMap.put("mealsPrice", _Tool.toInt(tmpBill.getTotalPrice()));
        	}
        	tmpBill = null;
        	if(uniformList.size() > i){
        		tmpBill = uniformList.get(i);
        	}
        	if(tmpBill!=null && tmpBill.getPayCount().intValue() > 0){
	    		tmpMap.put("uniformCount", tmpBill.getPayCount());
	    		tmpMap.put("uniformPrice", _Tool.toInt(tmpBill.getTotalPrice()));
        	}
        	tmpBill = null;
        	if(messageList.size() > i){
        		tmpBill = messageList.get(i);
        	}
        	if(tmpBill!=null && tmpBill.getPayCount().intValue() > 0){
        		tmpMap.put("messageCount", tmpBill.getPayCount());
        		tmpMap.put("messagePrice", _Tool.toInt(tmpBill.getTotalPrice()));
        	}
        	revertList.add(tmpMap);
		}
		return revertList;
	}

}
