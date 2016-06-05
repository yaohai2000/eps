package com.bhz.eps.test;

import com.bhz.eps.util.Converts;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class PosConnectMessage extends AbstractPosMessage{

	@Override
	public byte[] generateMessage() {
		byte[] posCode = "RS80031243".getBytes();
		byte[] posPsam = Converts.str2Bcd("60015000001234567891");
		ByteBuf bb = Unpooled.buffer();
		byte[] macByte = new byte[4];
		long size = 20;
		bb.writeBytes(genTPDUHeader(8 + size + 4));
		bb.writeBytes(genBizHeader(1));
		bb.writeBytes(posCode);
		bb.writeBytes(posPsam);
		bb.writeBytes(macByte);
		ByteBuf r = bb.copy(0, bb.readableBytes());
		return r.array();
	}
	
}
