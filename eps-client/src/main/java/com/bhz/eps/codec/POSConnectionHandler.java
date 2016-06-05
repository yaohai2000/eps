package com.bhz.eps.codec;

import com.bhz.eps.pdu.TPDU;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class POSConnectionHandler extends ChannelHandlerAdapter {

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println(this.getClass().getName());
		TPDU pdu = (TPDU)msg;
		ctx.writeAndFlush(new String(pdu.getBody().getData().getContent()));
	}

}
