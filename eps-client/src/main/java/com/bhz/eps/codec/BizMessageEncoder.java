package com.bhz.eps.codec;

import com.bhz.eps.pdu.TPDU;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class BizMessageEncoder extends MessageToByteEncoder<TPDU> {

	@Override
	protected void encode(ChannelHandlerContext ctx, TPDU msg, ByteBuf out) throws Exception {
		System.out.println(this.getClass().getName());
	}

}
