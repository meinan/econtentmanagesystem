package com.kingcore.cms.dao.main.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.kingcore.cms.dao.main.CmsTopicDao;
import com.kingcore.cms.entity.main.CmsTopic;
import com.kingcore.common.hibernate3.Finder;
import com.kingcore.common.hibernate3.HibernateBaseDao;
import com.kingcore.common.page.Pagination;

@Repository
public class CmsTopicDaoImpl extends HibernateBaseDao<CmsTopic, Integer>
		implements CmsTopicDao {
	@SuppressWarnings("unchecked")
	public List<CmsTopic> getList(Integer siteId,Integer channelId, boolean recommend,
			Integer count, boolean cacheable) {
		Finder f = Finder.create("from CmsTopic bean where 1=1");
		if (siteId != null) {
			f.append(" and bean.siteId=:siteId" );  //:siteId
			f.setParam("siteId", siteId);
		}
		if (channelId != null) {
			f.append(" and bean.channel.id=:channelId");
			f.setParam("channelId", channelId);
		}
		if (recommend) {
			f.append(" and bean.recommend=true");
		}
		f.append(" order by bean.priority asc,bean.id desc");
		if (count != null) {
			f.setMaxResults(count);
		}
		f.setCacheable(cacheable);
		return find(f);
	}

	public Pagination getPage(Integer siteId, Integer channelId, boolean recommend, int pageNo,
			int pageSize, boolean cacheable) {
		Finder f = Finder.create("from CmsTopic bean where 1=1");
		if (siteId != null) {
			f.append(" and bean.siteId=:siteId" );
			f.setParam("siteId", siteId);
		}
		if (channelId != null) {
			f.append(" and bean.channel.id=:channelId");
			f.setParam("channelId", channelId);
		}
		if (recommend) {
			f.append(" and bean.recommend=true");
		}
		f.append(" order by bean.priority asc,bean.id desc");
		return find(f, pageNo, pageSize);
	}

	/**
	 * mod by wzw
	 * //		return getSession().createQuery(hql)
//				.setParameterList("ids", channelIds)
//				.setParameter("siteId", siteId).list();
	 */
	@SuppressWarnings("unchecked")
	public List<CmsTopic> getListByChannelIds(Integer siteId, Integer[] channelIds) {
		String hql = "from CmsTopic bean where bean.channel.id in (:ids)";
		if (siteId!=null) {
			hql += " and bean.siteId=:siteId";
		}
		hql += " order by bean.id asc";
		Query query = getSession().createQuery(hql);
		query.setParameterList("ids", channelIds);
		if (siteId != null) {
			query.setParameter("siteId", siteId);
		}
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	public List<CmsTopic> getListByChannelId(Integer channelId) {
		String hql = "select bean from CmsTopic bean inner join bean.channel as node,Channel parent"
				+ " where node.lft between parent.lft and parent.rgt"
				+ " and parent.id=?"
				+ " order by bean.priority asc,bean.id desc";
		return find(hql, channelId);
	}

	@SuppressWarnings("unchecked")
	public List<CmsTopic> getGlobalTopicList() {
		String hql = "from CmsTopic bean where bean.channel.id is null"
				+ " order by bean.priority asc,bean.id desc";
		return find(hql);
	}

	public CmsTopic findById(Integer id) {
		CmsTopic entity = get(id);
		return entity;
	}

	public CmsTopic save(CmsTopic bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsTopic deleteById(Integer id) {
		CmsTopic entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	public int deleteContentRef(Integer id) {
		Query query = getSession().getNamedQuery("CmsTopic.deleteContentRef");
		return query.setParameter(0, id).executeUpdate();
	}

	public int countByChannelId(Integer channelId) {
		String hql = "select count(*) from CmsTopic bean"
				+ " where bean.channel.id=:channelId";
		Query query = getSession().createQuery(hql);
		query.setParameter("channelId", channelId);
		return ((Number) query.iterate().next()).hashCode();
	}

	@Override
	protected Class<CmsTopic> getEntityClass() {
		return CmsTopic.class;
	}
}