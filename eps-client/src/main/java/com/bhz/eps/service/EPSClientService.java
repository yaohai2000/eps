package com.bhz.eps.service;

import com.bhz.eps.entity.BizMessage;

import io.netty.channel.ChannelHandlerContext;

public interface EPSClientService {
	public void onReceiveHeartbeat();
	public void onBizMessage(ChannelHandlerContext ctx, BizMessage message);
}
