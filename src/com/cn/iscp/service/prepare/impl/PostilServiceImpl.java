package com.cn.iscp.service.prepare.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Tool;
import com.cn.iscp.dao.prepare.PostilDao;
import com.cn.iscp.dao.prepare.PostilIndexDao;
import com.cn.iscp.entity.prepare.Postil;
import com.cn.iscp.entity.prepare.PostilIndex;
import com.cn.iscp.service.prepare.ince.PostilService;

@Service("PostilService")
public class PostilServiceImpl implements PostilService{
	
    @Resource
    private PostilDao postilDao;
	@Resource
    private PostilIndexDao postilIndexDao;

	@Override
	public Postil insertPostil(Postil model) {
		model = postilDao.insertPostil(model);
		if(model == null){
			return model;
		}
		/*for (int i = 0; i < startIndexArray.length; i++) {
			if(startIndex.intValue() > endIndexArray[i].intValue()){
				// 加：本次开始下标>结束下标
				sIndexArray[i] = startIndexArray[i];
			}else if(endIndex.intValue() < startIndexArray[i].intValue()){
				// 加：本次结束下标>开始下标
				sIndexArray[i] = startIndexArray[i];
			}else if(startIndex.intValue() > startIndexArray[i].intValue()){
				// 换开始下标：本次开始下标<开始下标
				startIndex = startIndexArray[i].intValue();
			}else if(endIndex.intValue() < endIndexArray[i].intValue()){
				// 换结束下标：本次结束下标>结束下标
				endIndex = endIndexArray[i].intValue();
			}else if(startIndex.intValue() >= startIndexArray[i].intValue() && endIndex.intValue() <= endIndexArray[i].intValue()){
				// 包含
				break;
			}
		}*/
		
		Long includeIndex = null;
		Integer[] sIndexArray = null;
		Integer[] eIndexArray = null;
		Integer startIndex = model.getStartIndex();
		Integer endIndex = model.getEndIndex();
		List<PostilIndex> postilList = postilIndexDao.findByContent(model.getContentId());
		if(postilList != null && postilList.size() > 0){
			// 声明最终下标数组
			sIndexArray = new Integer[postilList.size()+1];
			eIndexArray = new Integer[postilList.size()+1];
			for (int i = 0; i < postilList.size(); i++) {
				Integer itemStartIndex = postilList.get(i).getStartIndex();
				Integer itemEndIndex = postilList.get(i).getEndIndex();
				if(startIndex.intValue() >= itemStartIndex && endIndex.intValue() <= itemEndIndex){
					// XX包含本次下标范围
					includeIndex = postilList.get(i).getIndexId();
					break;
				}else if(startIndex.intValue() > itemEndIndex){
					// 加：本次开始下标>XX结束下标
					sIndexArray[i] = itemStartIndex;
					eIndexArray[i] = itemEndIndex;
				}else if(endIndex.intValue() < itemStartIndex){
					// 加：本次结束下标>XX开始下标
					sIndexArray[i] = itemStartIndex;
					eIndexArray[i] = itemEndIndex;
				}else if(startIndex.intValue() > itemStartIndex || startIndex.intValue() == itemEndIndex){
					// 换开始下标：本次开始下标<XX开始下标 || 本次开始下标=XX结束下标
					startIndex = itemStartIndex;
				}else if(endIndex.intValue() < itemEndIndex || endIndex.intValue() == itemStartIndex){
					// 换结束下标：本次结束下标>XX结束下标 || 本次结束下标=XX开始下标
					endIndex = itemEndIndex;
				}else{
					// 本次下标范围包含XX
				}
			}
		}else{
			sIndexArray = new Integer[]{startIndex};
			eIndexArray = new Integer[]{endIndex};
		}
		
		// 处理批注范围指数
		if(_Tool.isLong(includeIndex)){
			// 存在下标指数范围包含本次标注范围，直接更新
			model.setIndexId(includeIndex);
			postilDao.updateIndex(model);
		}else{
			sIndexArray[postilList.size()] = startIndex;
			eIndexArray[postilList.size()] = endIndex;
			// 先删除该内容所有批注范围指数
			postilIndexDao.deleteByContent(model.getContentId());
			// 循环插入新的批注范围指数
			PostilIndex index = new PostilIndex(model.getDetailId(), model.getContentId());
			for (int i = 0; i < sIndexArray.length; i++) {
				if(_Tool.isInt(sIndexArray[i]) && _Tool.isInt(eIndexArray[i])){
					index.setStartIndex(sIndexArray[i]);
					index.setEndIndex(eIndexArray[i]);
					postilIndexDao.insertIndex(index);
				}
			}
			// 更新所有批注对应的批注范围指数编号
			postilDao.updateIndexs(model.getContentId());
		}
		return model;
	}

	@Override
	public boolean deletePostil(Long postilId) {
		Postil postil = postilDao.findById(postilId);
		if(postil == null){
			return true;
		}
		// 先删除标注指数范围(SQL已判断如果只有一条标注才删除)
		postilIndexDao.deleteById(postil.getIndexId());
		// 删除标注
		postil = new Postil(postilId);
		return postilDao.deletePostil(postil);
	}

	@Override
	public List<Postil> findByIndex(Long indexId) {
		return postilDao.findByIndex(indexId);
	}
    
	@Override
	public List<Postil> findPage(Map<String, Object> map) {
		return postilDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return postilDao.getPageCount(map);
	}

	@Override
	public Postil findById(Map<String, Object> map) {
		return postilDao.findById(map);
	}

	@Override
	public boolean insert(Postil model) {
		return postilDao.insert(model);
	}

	@Override
	public boolean update(Postil model) {
		return postilDao.update(model);
	}

}
