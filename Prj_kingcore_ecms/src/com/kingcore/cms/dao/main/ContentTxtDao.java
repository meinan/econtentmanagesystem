package com.kingcore.cms.dao.main;

import com.kingcore.cms.entity.main.ContentTxt;
import com.kingcore.common.hibernate3.Updater;

public interface ContentTxtDao {
	public ContentTxt findById(Integer id);

	public ContentTxt save(ContentTxt bean);

	public ContentTxt updateByUpdater(Updater<ContentTxt> updater);
}