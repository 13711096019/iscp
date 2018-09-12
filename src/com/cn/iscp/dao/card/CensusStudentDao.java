package com.cn.iscp.dao.card;

import com.cn.iscp.entity.card.CensusStudent;

public interface CensusStudentDao {
	
	CensusStudent getStudentCensus(Long studentId);
	
	boolean update(CensusStudent model);
	
	boolean insert(CensusStudent model);
	
}
