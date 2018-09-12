package com.cn.iscp.service.base.ince;

import com.cn.iscp.entity.base.Qualification;

public interface QualificationService {
	
	Qualification getQualification(Long teacherId);
	
	boolean handleQualification(Qualification model);
	
}
