package com.kingcore.cms.manager.assist;

import java.util.Date;

import com.kingcore.cms.entity.assist.CmsMessage;
import com.kingcore.common.page.Pagination;

/**
 *KingCore Software eCMS
 */
public interface CmsMessageMng {
	public Pagination getPage(Integer siteId, Integer sendUserId,
			Integer receiverUserId, String title, Date sendBeginTime,
			Date sendEndTime, Boolean status, Integer box, Boolean cacheable,
			int pageNo, int pageSize);

	public CmsMessage findById(Integer id);

	public CmsMessage save(CmsMessage bean);

	public CmsMessage update(CmsMessage bean);

	public CmsMessage deleteById(Integer id);

	public CmsMessage[] deleteByIds(Integer[] ids);
}