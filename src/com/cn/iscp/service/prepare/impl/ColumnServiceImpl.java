package com.cn.iscp.service.prepare.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.prepare.ColumnDao;
import com.cn.iscp.dao.prepare.ContentDao;
import com.cn.iscp.dao.prepare.PostilDao;
import com.cn.iscp.dao.prepare.PostilIndexDao;
import com.cn.iscp.entity.prepare.Column;
import com.cn.iscp.entity.prepare.Content;
import com.cn.iscp.entity.prepare.PostilIndex;
import com.cn.iscp.service.prepare.ince.ColumnService;

@Service("columnService")
public class ColumnServiceImpl implements ColumnService {
	
	@Resource
	private ColumnDao columnDao;
	@Resource
	private ContentDao contentDao;
	@Resource
	private PostilDao postilDao;
	@Resource
	private PostilIndexDao postilIndexDao;

	@Override
	public List<Column> findAllColumn() {
		return columnDao.findAll();
	}

	@Override
	public List<Column> findAllColumnContent(Long detailId) {
		// 获取所有大类目列表
		List<Column> columnList = this.findAllColumn();
		Content content = null;
		Long contentId = null;
		List<PostilIndex> indexList = null;
		for (Column column : columnList) {
			// 获取相对于栏目的备课内容
			content = new Content(detailId, column.getColumnId());
			content = contentDao.findByDetail(content);
			if(content != null){
				contentId = content.getContentId();
				// 获取下标指数列表
				indexList = postilIndexDao.findByContent(contentId);
				for (PostilIndex index : indexList) {
					// 根据下标指数获取标注列表
					index.setPostilList(postilDao.findByIndex(index.getIndexId()));
				}
				content.setIndexList(indexList);
			}
			column.setContent(content);
		}
		return columnList;
	}

}
