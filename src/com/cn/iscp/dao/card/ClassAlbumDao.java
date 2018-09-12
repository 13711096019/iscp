package com.cn.iscp.dao.card;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.card.ClassAlbum;

public interface ClassAlbumDao {
	
	/**
	 * PC-根据编号获取对象
	 */
	ClassAlbum findById(Long albumId);
	
	/**
	 * PC-获取班级图片列表
	 * @param classNum 动态班级编号
	 * @return 班级图片列表
	 */
	List<ClassAlbum> findAllPictures(Long classNum);
	
	/**
	 * 终端-获取班级图片列表
	 * @param classNum 动态班级编号
	 * @return 班级图片列表
	 */
	List<ClassAlbum> findPictures(Map<String, Object> map);
	
	/**
	 * PC-新增图片
	 * @param model 图片对象
	 * @return 新增状态
	 */
	boolean insert(ClassAlbum model);
	
	/**
	 * PC-编辑图片
	 * @param model 图片对象
	 * @return 编辑状态
	 */
	boolean update(ClassAlbum model);
	
}
