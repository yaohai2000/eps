package com.bhz.eps.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class TPDUEncoder extends MessageToByteEncoder<Object> {


    public TPDUEncoder() {
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
    	System.out.println(this.getClass().getName());
    	String strMsg = (String)msg;
    	out.writeBytes(strMsg.getBytes());
    }
}
