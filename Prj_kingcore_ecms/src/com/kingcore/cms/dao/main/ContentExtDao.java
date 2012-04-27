package com.kingcore.cms.dao.main;

import com.kingcore.cms.entity.main.ContentExt;
import com.kingcore.common.hibernate3.Updater;

public interface ContentExtDao {
	public ContentExt findById(Integer id);

	public ContentExt save(ContentExt bean);

	public ContentExt updateByUpdater(Updater<ContentExt> updater);
}