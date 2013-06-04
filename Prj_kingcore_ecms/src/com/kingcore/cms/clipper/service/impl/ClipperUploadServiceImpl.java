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

package com.kingcore.cms.clipper.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingcore.cms.base.service.impl.CmsBaseServiceImpl;
import com.kingcore.cms.clipper.service.ClipperUploadService;
import com.kingcore.cms.dao.main.ChannelDao;
import com.kingcore.cms.entity.main.Channel;

/**
 * <p>java类文件的说明...</p>
 * @author Zeven/wzw on Apr 30, 2013
 * @version	1.0
 * @see		Object#equals(java.lang.Object)
 * @since	JDK5
 */

@Service
@Transactional
public class ClipperUploadServiceImpl extends CmsBaseServiceImpl<Channel> 
                                implements ClipperUploadService {

	@Autowired
	private ChannelDao dao;
	
	@Transactional(readOnly = true)
	public List<Channel> getAllChannelList(Integer siteId, boolean hasContentOnly) {
		List<Channel> allList = new ArrayList<Channel>();
		List<Channel> topList = dao.getTopList(siteId, hasContentOnly, true, false);
		for (Channel channel : topList) {
			List<Channel> list2 = dao.getChildList(channel.getId(), true, true, true);
			if (list2!=null && list2.size()>0) {
				//channel.getChannelExt().setName("&lt;font color='#C0C0C0'&gt;"+channel.getChannelExt().getName()+"&lt;/font&gt;");
				channel.getChannelExt().setName("-----"+channel.getChannelExt().getName() );
			}
			allList.add(channel); //先添加本层
			for (Channel channel2 : list2) {
				List<Channel> list3 = dao.getChildList(channel2.getId(), true, true, true);
				channel2.getChannelExt().setName("&nbsp;>"+channel2.getChannelExt().getName());
				if (list3!=null && list3.size()>0) {
					channel2.getChannelExt().setName("-----"+channel2.getChannelExt().getName() );
				}
				allList.add(channel2); //先添加本层
				for (Channel channel3 : list3) {
					channel3.getChannelExt().setName("&nbsp;&nbsp;>"+channel3.getChannelExt().getName());
					allList.add(channel3); //先添加本层,对多先支持3层，没有用迭代方式					
				}
			}
		}
		return allList;
	}
	
	/**
	 * <p>java方法的说明...</p>
	 * @author Zeven on Apr 30, 2013
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
