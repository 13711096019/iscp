package com.cn.iscp.service.prepare.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.prepare.PostilIndexDao;
import com.cn.iscp.entity.prepare.PostilIndex;
import com.cn.iscp.service.prepare.ince.PostilIndexService;

@Service("postilIndexService")
public class PostilIndexServiceImpl implements PostilIndexService {
    
	@Resource
    private PostilIndexDao postilIndexDao;

	@Override
	public List<PostilIndex> findByContent(Long contentId) {
		return postilIndexDao.findByContent(contentId);
	}
	
}
