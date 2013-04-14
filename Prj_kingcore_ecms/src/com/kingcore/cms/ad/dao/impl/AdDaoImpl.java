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

package com.kingcore.cms.ad.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.kingcore.cms.ad.dao.AdDao;
import com.kingcore.cms.base.dao.impl.CmsBaseDaoImpl;
import com.kingcore.cms.entity.main.Content;
import com.kingcore.cms.entity.main.ContentCheck;
import com.kingcore.common.hibernate3.Finder;

/**
 * <p>java类文件的说明...</p>
 * @author Zeven/wzw on Apr 14, 2013
 * @version	1.0
 * @see		Object#equals(java.lang.Object)
 * @since	JDK5
 */

@Repository
public class AdDaoImpl extends CmsBaseDaoImpl 
   implements AdDao {


	@SuppressWarnings("unchecked")
	public List<Content> getListBySiteIdsForTag(Integer[] siteIds,
			Integer[] typeIds, Boolean titleImg, Boolean recommend,
			String title, int orderBy, Integer first, Integer count) {
		Finder f = bySiteIds(siteIds, typeIds, titleImg, recommend, title,
				orderBy);
		if (first != null) {
			f.setFirstResult(first);
		}
		if (count != null) {
			f.setMaxResults(count);
		}
		f.setCacheable(true);
		return find(f);
	}
	
	@Override
	protected Class<Content> getEntityClass() {
		return Content.class;
	}
	
	private Finder bySiteIds(Integer[] siteIds, Integer[] typeIds,
			Boolean titleImg, Boolean recommend, String title, int orderBy) {
		Finder f = Finder.create("select bean from Content bean");
		f.append(" join bean.contentExt as ext where 1=1");
		if (titleImg != null) {
			f.append(" and bean.hasTitleImg=:titleImg");
			f.setParam("titleImg", titleImg);
		}
		if (recommend != null) {
			f.append(" and bean.recommend=:recommend");
			f.setParam("recommend", recommend);
		}
		appendReleaseDate(f);
		appendTypeIds(f, typeIds);
		appendSiteIds(f, siteIds);
		f.append(" and bean.status=" + ContentCheck.CHECKED);
		if (!StringUtils.isBlank(title)) {
			f.append(" and bean.contentExt.title like :title");
			f.setParam("title", "%" + title + "%");
		}
		appendOrder(f, orderBy);
		return f;
	}

	private void appendReleaseDate(Finder f) {
		f.append(" and ext.releaseDate<:currentDate");
		f.setParam("currentDate", new Date());
	}

	private void appendTypeIds(Finder f, Integer[] typeIds) {
		int len;
		if (typeIds != null) {
			len = typeIds.length;
			if (len == 1) {
				f.append(" and bean.type.id=:typeId");
				f.setParam("typeId", typeIds[0]);
			} else if (len > 1) {
				f.append(" and bean.type.id in (:typeIds)");
				f.setParamList("typeIds", typeIds);
			}
		}
	}

	private void appendChannelIds(Finder f, Integer[] channelIds) {
		int len;
		if (channelIds != null) {
			len = channelIds.length;
			if (len == 1) {
				f.append(" and bean.channel.id=:channelId");
				f.setParam("channelId", channelIds[0]);
			} else if (len > 1) {
				f.append(" and bean.channel.id in (:channelIds)");
				f.setParamList("channelIds", channelIds);
			}
		}
	}

	private void appendSiteIds(Finder f, Integer[] siteIds) {
		int len;
		if (siteIds != null) {
			len = siteIds.length;
			if (len == 1) {
				f.append(" and bean.site.id=:siteId");
				f.setParam("siteId", siteIds[0]);
			} else if (len > 1) {
				f.append(" and bean.site.id in (:siteIds)");
				f.setParamList("siteIds", siteIds);
			}
		}
	}

	private void appendOrder(Finder f, int orderBy) {
		switch (orderBy) {
		case 1:
			// ID升序
			f.append(" order by bean.id asc");
			break;
		case 2:
			// 发布时间降序
			f.append(" order by bean.sortDate desc");
			break;
		case 3:
			// 发布时间升序
			f.append(" order by bean.sortDate asc");
			break;
		case 4:
			// 固顶级别降序、发布时间降序
			f.append(" order by bean.topLevel desc, bean.sortDate desc");
			break;
		case 5:
			// 固顶级别降序、发布时间升序
			f.append(" order by bean.topLevel desc, bean.sortDate asc");
			break;
		case 6:
			// 日访问降序
			f.append(" order by bean.viewsDay desc, bean.id desc");
			break;
		case 7:
			// 周访问降序
			f.append(" order by bean.contentCount.viewsWeek desc");
			f.append(", bean.id desc");
			break;
		case 8:
			// 月访问降序
			f.append(" order by bean.contentCount.viewsMonth desc");
			f.append(", bean.id desc");
			break;
		case 9:
			// 总访问降序
			f.append(" order by bean.contentCount.views desc");
			f.append(", bean.id desc");
			break;
		case 10:
			// 日评论降序
			f.append(" order by bean.commentsDay desc, bean.id desc");
			break;
		case 11:
			// 周评论降序
			f.append(" order by bean.contentCount.commentsWeek desc");
			f.append(", bean.id desc");
			break;
		case 12:
			// 月评论降序
			f.append(" order by bean.contentCount.commentsMonth desc");
			f.append(", bean.id desc");
			break;
		case 13:
			// 总评论降序
			f.append(" order by bean.contentCount.comments desc");
			f.append(", bean.id desc");
			break;
		case 14:
			// 日下载降序
			f.append(" order by bean.downloadsDay desc, bean.id desc");
			break;
		case 15:
			// 周下载降序
			f.append(" order by bean.contentCount.downloadsWeek desc");
			f.append(", bean.id desc");
			break;
		case 16:
			// 月下载降序
			f.append(" order by bean.contentCount.downloadsMonth desc");
			f.append(", bean.id desc");
			break;
		case 17:
			// 总下载降序
			f.append(" order by bean.contentCount.downloads desc");
			f.append(", bean.id desc");
			break;
		case 18:
			// 日顶降序
			f.append(" order by bean.upsDay desc, bean.id desc");
			break;
		case 19:
			// 周顶降序
			f.append(" order by bean.contentCount.upsWeek desc");
			f.append(", bean.id desc");
			break;
		case 20:
			// 月顶降序
			f.append(" order by bean.contentCount.upsMonth desc");
			f.append(", bean.id desc");
			break;
		case 21:
			// 总顶降序
			f.append(" order by bean.contentCount.ups desc, bean.id desc");
			break;
		default:
			// 默认： ID降序
			f.append(" order by bean.id desc");
		}
	}

	public int countByChannelId(int channelId) {
		String hql = "select count(*) from Content bean"
				+ " join bean.channel channel,Channel parent"
				+ " where channel.lft between parent.lft and parent.rgt"
				+ " and channel.site.id=parent.site.id"
				+ " and parent.id=:parentId";
		Query query = getSession().createQuery(hql);
		query.setParameter("parentId", channelId);
		return ((Number) (query.iterate().next())).intValue();
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
