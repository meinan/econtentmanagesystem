package com.kingcore.cms.dao.assist;

import com.kingcore.cms.entity.assist.CmsVoteTopic;
import com.kingcore.common.hibernate3.Updater;
import com.kingcore.common.page.Pagination;

public interface CmsVoteTopicDao {
	public Pagination getPage(Integer siteId, int pageNo, int pageSize);

	public CmsVoteTopic getDefTopic(Integer siteId);

	public CmsVoteTopic findById(Integer id);

	public CmsVoteTopic save(CmsVoteTopic bean);

	public CmsVoteTopic updateByUpdater(Updater<CmsVoteTopic> updater);

	public CmsVoteTopic deleteById(Integer id);
}