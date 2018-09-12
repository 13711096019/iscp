package com.cn.iscp.service.prepare.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.prepare.ContentDao;
import com.cn.iscp.dao.prepare.PostilDao;
import com.cn.iscp.dao.prepare.PostilIndexDao;
import com.cn.iscp.entity.prepare.Content;
import com.cn.iscp.entity.prepare.PostilIndex;
import com.cn.iscp.service.prepare.ince.ContentService;

@Service("contentService")
public class ContentServiceImpl implements ContentService {
	
	@Resource
	private ContentDao contentDao;
	@Resource
	private PostilDao postilDao;
	@Resource
	private PostilIndexDao postilIndexDao;
	
	@Override
	public Content findByDetail(Content model) {
		return contentDao.findByDetail(model);
	}

	@Override
	public Content findById(Long contentId) {
		// 获取相对于栏目的备课内容
		Content content = contentDao.findById(contentId);
		if(content != null){
			contentId = content.getContentId();
			// 获取下标指数列表
			List<PostilIndex> indexList = postilIndexDao.findByContent(contentId);
			for (PostilIndex index : indexList) {
				// 根据下标指数获取标注列表
				index.setPostilList(postilDao.findByIndex(index.getIndexId()));
			}
			content.setIndexList(indexList);
		}
		return content;
	}
	
}
