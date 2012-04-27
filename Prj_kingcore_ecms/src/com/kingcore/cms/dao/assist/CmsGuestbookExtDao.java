package com.kingcore.cms.dao.assist;

import com.kingcore.cms.entity.assist.CmsGuestbookExt;
import com.kingcore.common.hibernate3.Updater;

public interface CmsGuestbookExtDao {
	public CmsGuestbookExt findById(Integer id);

	public CmsGuestbookExt save(CmsGuestbookExt bean);

	public CmsGuestbookExt updateByUpdater(Updater<CmsGuestbookExt> updater);

	public CmsGuestbookExt deleteById(Integer id);
}