package com.bhz.eps.test;

import com.bhz.eps.util.Converts;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public abstract class AbstractPosMessage implements POSMessage {

	@Override
	public abstract byte[] generateMessage();
	
	public byte[] genTPDUHeader(long tpduLength){
		ByteBuf bb = Unpooled.buffer(10);
		bb.writeByte(0x10).writeByte(0x10);
		bb.writeInt((int)tpduLength);
		bb.writeByte(0x01);
		bb.writeShort(0x0000);
		bb.writeByte(0);
		return bb.array();
	}
	
	public byte[] genBizHeader(int cmd){
		ByteBuf bb = Unpooled.buffer(8);
		byte[] stationId = Converts.str2Bcd("1010202030");
		bb.writeBytes(stationId);
		bb.writeShort(cmd);
		bb.writeByte(0x01);
		return bb.array();
	}

}
