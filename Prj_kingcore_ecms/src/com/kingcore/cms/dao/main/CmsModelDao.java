package com.kingcore.cms.dao.main;

import java.util.List;

import com.kingcore.cms.entity.main.CmsModel;
import com.kingcore.common.hibernate3.Updater;

public interface CmsModelDao {
	public List<CmsModel> getList(boolean containDisabled);

	public CmsModel getDefModel();

	public CmsModel findById(Integer id);

	public CmsModel save(CmsModel bean);

	public CmsModel updateByUpdater(Updater<CmsModel> updater);

	public CmsModel deleteById(Integer id);
}