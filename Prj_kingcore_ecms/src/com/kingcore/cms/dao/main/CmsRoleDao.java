package com.kingcore.cms.dao.main;

import java.util.List;

import com.kingcore.cms.entity.main.CmsRole;
import com.kingcore.common.hibernate3.Updater;

public interface CmsRoleDao {
	public List<CmsRole> getList();

	public CmsRole findById(Integer id);

	public CmsRole save(CmsRole bean);

	public CmsRole updateByUpdater(Updater<CmsRole> updater);

	public CmsRole deleteById(Integer id);
}