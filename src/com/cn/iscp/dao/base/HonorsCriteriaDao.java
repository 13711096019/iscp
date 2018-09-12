package com.cn.iscp.dao.base;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.HonorsCriteria;

public interface HonorsCriteriaDao {
	
	List<HonorsCriteria> findByHonors(Long honorsId);
	
    //pc操作部分
	
    List<HonorsCriteria> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	HonorsCriteria findById(Long criteriaId);
	
	HonorsCriteria findFinal();
	
    boolean insert(HonorsCriteria model);
	
	boolean update(HonorsCriteria model);
}
