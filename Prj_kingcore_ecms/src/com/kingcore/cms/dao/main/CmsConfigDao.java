package com.kingcore.cms.dao.main;

import com.kingcore.cms.entity.main.CmsConfig;
import com.kingcore.common.hibernate3.Updater;

public interface CmsConfigDao {
	public CmsConfig findById(Integer id);

	public CmsConfig updateByUpdater(Updater<CmsConfig> updater);
}