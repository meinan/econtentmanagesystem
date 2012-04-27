package com.kingcore.cms.dao.main;

import com.kingcore.cms.entity.main.ChannelTxt;
import com.kingcore.common.hibernate3.Updater;

public interface ChannelTxtDao {
	public ChannelTxt findById(Integer id);

	public ChannelTxt save(ChannelTxt bean);

	public ChannelTxt updateByUpdater(Updater<ChannelTxt> updater);
}