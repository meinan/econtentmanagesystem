package com.kingcore.cms.manager.assist;

import java.util.Collection;

import com.kingcore.cms.entity.assist.CmsVoteItem;
import com.kingcore.cms.entity.assist.CmsVoteTopic;
import com.kingcore.common.page.Pagination;

public interface CmsVoteItemMng {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsVoteItem findById(Integer id);

	public Collection<CmsVoteItem> save(Collection<CmsVoteItem> items,
			CmsVoteTopic topic);

	public Collection<CmsVoteItem> update(Collection<CmsVoteItem> items,
			CmsVoteTopic topic);

	public CmsVoteItem deleteById(Integer id);

	public CmsVoteItem[] deleteByIds(Integer[] ids);
}