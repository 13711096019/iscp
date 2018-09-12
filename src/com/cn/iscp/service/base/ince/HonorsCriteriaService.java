package com.cn.iscp.service.base.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Honors;
import com.cn.iscp.entity.base.HonorsCriteria;

public interface HonorsCriteriaService {
	
	List<HonorsCriteria> findByHonors(Long honorsId);
	
	List<Honors> findHonorsCriteria();
	
	//pc操作界面部分
	List<HonorsCriteria> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
		
	HonorsCriteria findById(Long criteriaId);
		
	HonorsCriteria findFinal();
		
	boolean insert(HonorsCriteria model);
		
	boolean update(HonorsCriteria model);
}
