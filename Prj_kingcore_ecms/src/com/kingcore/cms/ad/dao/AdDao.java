package com.kingcore.cms.ad.dao;

import java.util.List;

import com.kingcore.cms.base.dao.CmsBaseDao;
import com.kingcore.cms.entity.main.Content;

public interface AdDao extends CmsBaseDao{

	List<Content> getListBySiteIdsForTag(Integer[] siteIds, Integer[] typeIds,
			Boolean titleImg, Boolean recommend, String title, int orderBy,
			Integer first, Integer count);

}
