package com.cn.iscp.service.ligent;

import java.util.ArrayList;
import java.util.List;

import com.cn.common._Const;
import com.cn.iscp.model.Artascope;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;

public class BaseSericel {
	
	/**
	 * 把结果集转换为状态对象
	 * @param list 结果集
	 * @return 状态对象
	 */
	public StateModel getMapByState(List<List<?>> list){
		StateModel stateMobile = null;
		if(list == null || list.size() == 0){
			return stateMobile;
		}
		if(list.size() < 2){
			return (StateModel) list.get(0);
		}
		// 遍历结果集
		for (List<?> modelList : list) {
			if(modelList == null){
				continue;
			}
			// 判断结果对象
			for (Object value : modelList) {
				if (value instanceof StateModel){
					// 状态对象
					stateMobile = (StateModel) value;
					// 如果返回码为0,跳出本次循环,获取下级会员列表并返回；否则返回空
					if(stateMobile.getStatusCode() == _Const.STATE_SUCCESS){
						break;
					}else{
						return stateMobile;
					}
				}else{
					// 集合
					stateMobile.setData(modelList);
					break;
				}
			}
		}
		return stateMobile;
	}
	
	/**
	 * 把结果集转换为分页对象
	 * @param list 结果集
	 * @return 分页对象
	 */
	public PageModel getMapByPage(List<List<?>> list){
		PageModel pageBase = new PageModel();
		if(list == null || list.size() == 0){
			return pageBase;
		}
		for (List<?> modelList : list) {
			if(modelList == null){
				continue;
			}
			// 判断结果对象
			for (Object value : modelList) {
				if (value instanceof Artascope){
					// 状态对象
					Artascope artascope = (Artascope) value;
					Integer recordsCount = artascope.getRecordsCount();
					pageBase.setITotalRecords(recordsCount);
					pageBase.setITotalDisplayRecords(recordsCount);
					break;
				}else{
					// 集合
					pageBase.setAaData(modelList);
					break;
				}
			}
		}
		if(pageBase.getAaData()==null){
			pageBase.setAaData(new ArrayList<Object>());
		}
		return pageBase;
	}
}
