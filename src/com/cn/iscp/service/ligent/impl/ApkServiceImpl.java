package com.cn.iscp.service.ligent.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Tool;
import com.cn.common._Url;
import com.cn.iscp.dao.base.ItemFileDao;
import com.cn.iscp.dao.ligent.ApkDao;
import com.cn.iscp.entity.ligent.Apk;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.ligent.ince.ApkService;
import com.cn.unit.apk.ApkUtil;
import com.cn.unit.utils.DateUtil;

@Service("apkService")
public class ApkServiceImpl implements ApkService{
	
	@Resource
	private ApkDao apkDao;
	@Resource
	private ItemFileDao itemFileDao;

	@Override
	public List<Apk> findPage(Map<String, Object> map) {
		return apkDao.findPage(map);
	}

	@Override
	public Long getPageCount() {
		return apkDao.getPageCount();
	}

	@Override
	public boolean insert(String pathName, Apk model) {
		File file = new File(pathName);
		// 读取安装包信息
		//model.setApkInfo(ApkUtil.getApkInfo(file.getPath()));
		model.setVersionSize(new Long(ApkUtil.getFileSize(file)));
		model.setCreateDate(DateUtil.getStrByDate(null, null));
		
		boolean revert = apkDao.insert(model);
		/*// 推送app用户更新信息
		if(revert){
			// 获取系统类型别名
			ItemFile itemFile = new ItemFile(Const.VERSION_TYPE, model.getVersionType());
			itemFile = itemFileDao.findByFileId(itemFile);
			int code = Tool.toInt(itemFile.getItemFileNick());
			
	    	Map<String, Object> content = new HashMap<String, Object>();
	    	content.put("keyNum", PushCode.VERSION_APK);
	    	content.put("nozzle", PushCode.INTERFACE_PATH.get(PushCode.VERSION_APK));
	    	content.put("apkId", model.getApkId());
	    	
			// 推送标识码
	    	PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtils.getBean("pushSericel");
			List<PushModel> codeList = pushSericel.findAllMachineCode();
			Integer pushCount = 0;
			for (PushModel pushModel : codeList) {
		    	PushInvite jdpust = new PushInvite(code, pushModel.getMachineCode(), content);
		    	pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
			}
			System.out.println("推送成功:"+pushCount);
		}*/
		return revert;
	}

	@Override
	public StateModel getPushContent(String apkId, Integer versionType) {
		Apk model = null;
		if(_Tool.isLong(apkId)){
			// 根据编号获取版本
			model = apkDao.findById(_Tool.toLong(apkId));
		}
		if(model == null){
			// 根据类型获取更新版本
			model = apkDao.getLastModle(versionType);
		}
		if(model != null){
			model.setVersionUrl(_Url.LINK_APK_DOW+"?apkId="+model.getApkId());
		}
		return new StateModel(model);
	}

	@Override
	public Apk getModle(String apkId, Integer versionType) {
		Apk model = null;
		if(_Tool.isLong(apkId)){
			model = apkDao.findById(_Tool.toLong(apkId));
		}
		if(model == null){
			model = apkDao.getLastModle(versionType);
		}
		return model;
	}

}
