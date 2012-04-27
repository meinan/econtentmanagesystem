package com.kingcore.cms.manager.assist;

import com.kingcore.cms.entity.assist.CmsGuestbook;
import com.kingcore.cms.entity.assist.CmsGuestbookExt;

public interface CmsGuestbookExtMng {
	public CmsGuestbookExt save(CmsGuestbookExt ext, CmsGuestbook guestbook);

	public CmsGuestbookExt update(CmsGuestbookExt ext);
}