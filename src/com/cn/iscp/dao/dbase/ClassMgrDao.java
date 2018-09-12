package com.cn.iscp.dao.dbase;

import java.util.List;

import com.cn.iscp.entity.dbase.ClassMgr;

public interface ClassMgrDao {
	
	List<ClassMgr> login(ClassMgr model);
	
	List<ClassMgr> verifySafePwd(ClassMgr model);
	
	ClassMgr getByClassNum(ClassMgr model);
	
	List<ClassMgr> findAll();
	
	ClassMgr findById(Long classMgrId);
	
	boolean insert(ClassMgr model);
	
	boolean updateName(ClassMgr model);
	
	boolean updateMachinePwd(ClassMgr model);
	
	boolean updateSafePwd(ClassMgr model);
	
	void updateClassNum(ClassMgr model);
	
}
