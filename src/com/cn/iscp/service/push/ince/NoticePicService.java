package com.cn.iscp.service.push.ince;

import java.util.List;

import com.cn.iscp.entity.push.NoticePic;

public interface NoticePicService {
	
	NoticePic findById(Long picId);
	
	List<NoticePic> findByNotice(Long noticeId);
	
	boolean insert(NoticePic model);
	
	boolean delete(Long picId);
	
}
