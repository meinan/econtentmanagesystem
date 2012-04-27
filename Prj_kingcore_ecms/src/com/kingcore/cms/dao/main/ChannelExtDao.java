package com.kingcore.cms.dao.main;

import com.kingcore.cms.entity.main.ChannelExt;
import com.kingcore.common.hibernate3.Updater;

public interface ChannelExtDao {
	public ChannelExt save(ChannelExt bean);

	public ChannelExt updateByUpdater(Updater<ChannelExt> updater);
}