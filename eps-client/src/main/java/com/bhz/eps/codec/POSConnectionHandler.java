package com.bhz.eps.codec;

import com.bhz.eps.Boot;
import com.bhz.eps.entity.PosRegInfo;
import com.bhz.eps.pdu.TPDU;
import com.bhz.eps.service.PosRegService;
import com.bhz.eps.util.Converts;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler;

@ChannelHandler.Sharable
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
		byte[] cnt = pdu.getBody().getData().getContent();
		byte[] posCodeArr = new byte[10];
		System.arraycopy(cnt, 0, posCodeArr, 0, posCodeArr.length);
		byte[] psamCodeArr = new byte[10];
		System.arraycopy(cnt, 10, psamCodeArr, 0, psamCodeArr.length);
		PosRegInfo pos = new PosRegInfo();
		pos.setPosCode(new String(posCodeArr));
		pos.setPsamNum(Converts.bcd2Str(psamCodeArr));
		pos.setStatus(1);
		PosRegService pss = Boot.appctx.getBean("posRegService",PosRegService.class);
		pss.regist(pos);
		ctx.writeAndFlush(pdu.getBody().getData().getContent());
	}

}
