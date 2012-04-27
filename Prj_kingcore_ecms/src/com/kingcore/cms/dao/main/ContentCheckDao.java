package com.kingcore.cms.dao.main;

import com.kingcore.cms.entity.main.ContentCheck;
import com.kingcore.common.hibernate3.Updater;

public interface ContentCheckDao {
	public ContentCheck findById(Long id);

	public ContentCheck save(ContentCheck bean);

	public ContentCheck updateByUpdater(Updater<ContentCheck> updater);
}