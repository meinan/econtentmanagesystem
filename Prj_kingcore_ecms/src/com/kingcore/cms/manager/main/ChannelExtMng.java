package com.kingcore.cms.manager.main;

import com.kingcore.cms.entity.main.Channel;
import com.kingcore.cms.entity.main.ChannelExt;

public interface ChannelExtMng {
	public ChannelExt save(ChannelExt ext, Channel channel);

	public ChannelExt update(ChannelExt ext);
}