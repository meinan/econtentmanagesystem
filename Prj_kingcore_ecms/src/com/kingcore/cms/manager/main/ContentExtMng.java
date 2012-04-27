package com.kingcore.cms.manager.main;

import com.kingcore.cms.entity.main.Content;
import com.kingcore.cms.entity.main.ContentExt;

public interface ContentExtMng {
	public ContentExt save(ContentExt ext, Content content);

	public ContentExt update(ContentExt ext);
}