package com.kingcore.cms.dao.assist;

import com.kingcore.cms.entity.assist.CmsVoteItem;
import com.kingcore.common.hibernate3.Updater;
import com.kingcore.common.page.Pagination;

public interface CmsVoteItemDao {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsVoteItem findById(Integer id);

	public CmsVoteItem save(CmsVoteItem bean);

	public CmsVoteItem updateByUpdater(Updater<CmsVoteItem> updater);

	public CmsVoteItem deleteById(Integer id);
}