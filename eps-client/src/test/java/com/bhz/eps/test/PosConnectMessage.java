package com.bhz.eps.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class PosConnectMessage extends AbstractPosMessage{

	@Override
	public byte[] generateMessage() {
		String msg = "Hello World!";
		ByteBuf bb = Unpooled.buffer();
		byte[] macByte = new byte[4];
		long size = msg.length();
		bb.writeBytes(genTPDUHeader(8 + size + 4));
		bb.writeBytes(genBizHeader(1));
		bb.writeBytes(msg.getBytes());
		bb.writeBytes(macByte);
		ByteBuf r = bb.copy(0, bb.readableBytes());
		return r.array();
	}
	
}
