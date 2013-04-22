package com.kingcore.cms.manager.main.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingcore.cms.dao.main.CmsTopicDao;
import com.kingcore.cms.entity.main.Channel;
import com.kingcore.cms.entity.main.CmsTopic;
import com.kingcore.cms.manager.main.ChannelMng;
import com.kingcore.cms.manager.main.CmsTopicMng;
import com.kingcore.cms.service.ChannelDeleteChecker;
import com.kingcore.common.hibernate3.Updater;
import com.kingcore.common.page.Pagination;

@Service
@Transactional
public class CmsTopicMngImpl implements CmsTopicMng, ChannelDeleteChecker {
	@Transactional(readOnly = true)
	public List<CmsTopic> getListForTag(Integer siteId, Integer channelId, boolean recommend,
			Integer count) {
		return dao.getList(siteId, channelId, recommend, count, true);
	}

	@Transactional(readOnly = true)
	public Pagination getPageForTag(Integer siteId, Integer channelId, boolean recommend,
			int pageNo, int pageSize) {
		return dao.getPage(siteId, channelId, recommend, pageNo, pageSize, true);
	}

	@Transactional(readOnly = true)
	public Pagination getPage(Integer siteId, int pageNo, int pageSize) {
		Pagination page = dao.getPage(siteId, null, false, pageNo, pageSize, false);
		return page;
	}

	/**
	 * mod by wzw
	 */
	@Transactional(readOnly = true)
	public List<CmsTopic> getListByChannel(Integer siteId, Integer channelId) {
		List<CmsTopic> list = dao.getGlobalTopicList();
		Channel c = channelMng.findById(channelId);
		list.addAll(dao.getListByChannelIds(siteId, c.getNodeIds()));
		return list;
	}

	@Transactional(readOnly = true)
	public CmsTopic findById(Integer id) {
		CmsTopic entity = dao.findById(id);
		return entity;
	}

	public CmsTopic save(CmsTopic bean, Integer channelId) {
		if (channelId != null) {
			bean.setChannel(channelMng.findById(channelId));
		}
		bean.init();
		dao.save(bean);
		return bean;
	}

	public CmsTopic update(CmsTopic bean, Integer channelId) {
		Updater<CmsTopic> updater = new Updater<CmsTopic>(bean);
		CmsTopic entity = dao.updateByUpdater(updater);
		if (channelId != null) {
			entity.setChannel(channelMng.findById(channelId));
		} else {
			entity.setChannel(null);
		}
		entity.blankToNull();
		return entity;
	}

	public CmsTopic deleteById(Integer id) {
		dao.deleteContentRef(id);
		CmsTopic bean = dao.deleteById(id);
		return bean;
	}

	public CmsTopic[] deleteByIds(Integer[] ids) {
		CmsTopic[] beans = new CmsTopic[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	public CmsTopic[] updatePriority(Integer[] ids, Integer[] priority) {
		int len = ids.length;
		CmsTopic[] beans = new CmsTopic[len];
		for (int i = 0; i < len; i++) {
			beans[i] = findById(ids[i]);
			beans[i].setPriority(priority[i]);
		}
		return beans;
	}

	public String checkForChannelDelete(Integer channelId) {
		if (dao.countByChannelId(channelId) > 0) {
			return "cmsTopic.error.cannotDeleteChannel";
		} else {
			return null;
		}
	}

	private ChannelMng channelMng;
	private CmsTopicDao dao;

	@Autowired
	public void setDao(CmsTopicDao dao) {
		this.dao = dao;
	}

	@Autowired
	public void setChannelMng(ChannelMng channelMng) {
		this.channelMng = channelMng;
	}
}