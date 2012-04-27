package com.kingcore.cms.dao.main;

import com.kingcore.cms.entity.main.CmsUserExt;
import com.kingcore.common.hibernate3.Updater;

public interface CmsUserExtDao {
	public CmsUserExt findById(Integer id);

	public CmsUserExt save(CmsUserExt bean);

	public CmsUserExt updateByUpdater(Updater<CmsUserExt> updater);
}