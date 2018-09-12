package com.cn.iscp.service.card.impl.honors;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.honors.HonorsCollectiveDao;
import com.cn.iscp.entity.card.honors.HonorsCollective;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.card.ince.honors.HonorsCollectiveService;
import com.cn.iscp.service.ligent.BaseSericel;

@Service("honorsCollectiveService")
public class HonorsCollectiveServiceImpl extends BaseSericel implements HonorsCollectiveService {
	
	@Resource
	private HonorsCollectiveDao honorsCollectiveDao;
	
	@Override
	public PageModel findPage(Map<String, Object> map) {
		List<List<?>> list = honorsCollectiveDao.findPage(map);
		return getMapByPage(list);
	}
	
	@Override
	public HonorsCollective findById(Long collectiveId) {
		return honorsCollectiveDao.findById(collectiveId);
	}
	
	@Override
	public List<HonorsCollective> findByFresh(Integer dataCount) {
		return honorsCollectiveDao.findByFresh(dataCount);
	}
	
	@Override
	public HonorsCollective insertHonors(HonorsCollective model) {
		return honorsCollectiveDao.insertHonors(model);
	}
	
	@Override
	public HonorsCollective updateHonors(HonorsCollective model) {
		return honorsCollectiveDao.updateHonors(model);
	}
	
	@Override
	public StateModel deleteHonors(Long collectiveId) {
		return honorsCollectiveDao.deleteHonors(collectiveId);
	}
	
}
