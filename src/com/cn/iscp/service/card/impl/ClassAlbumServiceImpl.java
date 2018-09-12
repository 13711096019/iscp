package com.cn.iscp.service.card.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.ClassAlbumDao;
import com.cn.iscp.entity.card.ClassAlbum;
import com.cn.iscp.service.card.ince.ClassAlbumService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;

@Service("classAlbumService")
public class ClassAlbumServiceImpl implements ClassAlbumService {
	
	@Resource
	private ClassAlbumDao classAlbumDao;

	@Override
	public ClassAlbum findById(Long albumId) {
		return classAlbumDao.findById(albumId);
	}

	@Override
	public List<ClassAlbum> findAllPictures(Long classNum) {
		return classAlbumDao.findAllPictures(classNum);
	}

	@Override
	public List<ClassAlbum> findPictures(Long classNum, Integer getCount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("classNum", classNum);
		map.put("getCount", getCount);
		return classAlbumDao.findPictures(map);
	}

	@Override
	public boolean insert(ClassAlbum model) {
		// PC一次上传完毕才推送(/card/album/buildPushAlbum)
		return classAlbumDao.insert(model);
	}

	@Override
	public boolean update(ClassAlbum model) {
		boolean revert = classAlbumDao.update(model);
		if(revert){
			if(model.getClassNum() == null){
				model = this.findById(model.getAlbumId());
			}
			// 推送到终端
			PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, model.getClassNum(), PushCode.CLASS_PICTURE);
			jdpust.buildPushNotAlert();
		}
		return revert;
	}

}
