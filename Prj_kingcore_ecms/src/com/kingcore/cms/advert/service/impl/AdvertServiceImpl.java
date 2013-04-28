/**
 * Copyright (C) 2013 ChangSha XNS Science & Technology CO,.LTD. All rights reserved.
 * XNS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * Copyright (C) 2002-2013 WUZEWEN. All rights reserved.
 * WUZEWEN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * This software is the confidential and proprietary information of
 * WuZeven, Personal. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with WuZeven.
 */

package com.kingcore.cms.advert.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingcore.cms.advert.dao.AdvertDao;
import com.kingcore.cms.advert.service.AdvertService;
import com.kingcore.cms.base.service.impl.CmsBaseServiceImpl;
import com.kingcore.cms.entity.main.Content;

/**
 * <p>java类文件的说明...</p>
 * @author Zeven/wzw on Apr 14, 2013
 * @version	1.0
 * @see		Object#equals(java.lang.Object)
 * @since	JDK5
 */

@Service
@Transactional
public class AdvertServiceImpl extends CmsBaseServiceImpl implements AdvertService {


	private AdvertDao dao;

	@Transactional(readOnly = true)
	public List<Content> getListBySiteIdsForTag(Integer[] siteIds,
			Integer[] typeIds, Boolean titleImg, Boolean recommend,
			String title, int orderBy, Integer first, Integer count) {
		List<Content> list = dao.getListBySiteIdsForTag(siteIds, typeIds, titleImg,
				recommend, title, orderBy, first, count);
		List<Content> cacheList = new ArrayList<Content>();
		for (Content content : list) {
			Content cacheContent = new Content();
			cacheContent.setTitle( content.getTitle() );
			cacheContent.setUrl( content.getUrl() );
			cacheList.add(cacheContent);
		}
		return cacheList;
	}

	@Autowired
	public void setDao(AdvertDao dao) {
		this.dao = dao;
	}
	
	/**
	 * <p>java方法的说明...</p>
	 * @author Zeven on Apr 14, 2013
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
