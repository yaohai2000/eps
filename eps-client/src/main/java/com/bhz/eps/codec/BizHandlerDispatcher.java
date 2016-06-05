package com.bhz.eps.codec;

import com.bhz.eps.entity.BizMessageType;
import com.bhz.eps.pdu.TPDU;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class BizHandlerDispatcher extends ChannelHandlerAdapter {

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		TPDU tpdu = (TPDU)msg;
		switch(tpdu.getBody().getHeader().getCmd()){
			case BizMessageType.CONN:
				ctx.pipeline().addLast("ClientConn",new POSConnectionHandler());
				ctx.fireChannelRead(msg);
				break;
			case BizMessageType.HEARTBEAT:
				
				break;
			case BizMessageType.FP_INFO:
				break;
			case BizMessageType.FP_ORDERLIST:
				break;
			case BizMessageType.LOCK_ORDER:
				break;
			case BizMessageType.GET_TRANS_DETAIL:
				break;
			case BizMessageType.ORDER_PAY_COMPLETE:
				break;
			case BizMessageType.UNLOCK_ORDER:
				break;
				
		}
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		ctx.channel().close();
		System.out.println("Channel Inactive");
		return;
	}
	
	
	
}
