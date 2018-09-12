package com.cn.iscp.service.push.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.push.NoticePicDao;
import com.cn.iscp.entity.push.NoticePic;
import com.cn.iscp.service.push.ince.NoticePicService;

@Service("noticePicService")
public class NoticePicServiceImpl implements NoticePicService {
	
	@Resource
	private NoticePicDao noticePicDao;

	@Override
	public NoticePic findById(Long picId) {
		return noticePicDao.findById(picId);
	}

	@Override
	public List<NoticePic> findByNotice(Long noticeId) {
		return noticePicDao.findByNotice(noticeId);
	}

	@Override
	public boolean insert(NoticePic model) {
		return noticePicDao.insert(model);
	}

	@Override
	public boolean delete(Long picId) {
		return noticePicDao.delete(picId);
	}

}
