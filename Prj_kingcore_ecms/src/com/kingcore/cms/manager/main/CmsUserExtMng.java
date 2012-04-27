package com.kingcore.cms.manager.main;

import com.kingcore.cms.entity.main.CmsUser;
import com.kingcore.cms.entity.main.CmsUserExt;

public interface CmsUserExtMng {
	public CmsUserExt save(CmsUserExt ext, CmsUser user);

	public CmsUserExt update(CmsUserExt ext, CmsUser user);
}