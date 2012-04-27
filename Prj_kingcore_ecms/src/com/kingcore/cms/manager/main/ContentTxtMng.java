package com.kingcore.cms.manager.main;

import com.kingcore.cms.entity.main.Content;
import com.kingcore.cms.entity.main.ContentTxt;

public interface ContentTxtMng {
	public ContentTxt save(ContentTxt txt, Content content);

	public ContentTxt update(ContentTxt txt, Content content);
}