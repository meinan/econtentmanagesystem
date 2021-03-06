package com.kingcore.cms.manager.main;

import java.util.List;

import com.kingcore.cms.entity.main.CmsTopic;
import com.kingcore.common.page.Pagination;

public interface CmsTopicMng {

	public List<CmsTopic> getListForTag(Integer siteId, Integer channelId, boolean recommend,
			Integer count);

	public Pagination getPageForTag(Integer siteId, Integer channelId, boolean recommend,
			int pageNo, int pageSize);

	public Pagination getPage(Integer siteId, int pageNo, int pageSize);

	public List<CmsTopic> getListByChannel(Integer siteId,Integer channelId);

	public CmsTopic findById(Integer id);

	public CmsTopic save(CmsTopic bean, Integer channelId);

	public CmsTopic update(CmsTopic bean, Integer channelId);

	public CmsTopic deleteById(Integer id);

	public CmsTopic[] deleteByIds(Integer[] ids);

	public CmsTopic[] updatePriority(Integer[] ids, Integer[] priority);
}