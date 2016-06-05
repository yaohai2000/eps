package com.bhz.eps.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.bhz.eps.codec.BizHandlerDispatcher;
import com.bhz.eps.codec.BizMessageDecoder;
import com.bhz.eps.codec.BizMessageEncoder;
import com.bhz.eps.codec.TPDUChecker;
import com.bhz.eps.codec.TPDUDecoder;
import com.bhz.eps.codec.TPDUEncoder;
import com.bhz.eps.entity.BizMessage;
import com.bhz.eps.entity.BizMessageType;
import com.bhz.eps.service.EPSClientService;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

@Service("epsClientService")
public class EPSClientServiceImpl implements EPSClientService,InitializingBean {
	
	@Override
	public void afterPropertiesSet() throws Exception {
		EventLoopGroup acceptor = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		ServerBootstrap sb = new ServerBootstrap();
		try{
			sb.group(acceptor, worker)
			.channel(NioServerSocketChannel.class)
			.option(ChannelOption.SO_BACKLOG, 4096)
			.childOption(ChannelOption.TCP_NODELAY, true)
			.localAddress("127.0.0.1", 4088)
			.childHandler(new ChannelInitializer<SocketChannel>(){

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ChannelPipeline pipeline = ch.pipeline();
					//
					pipeline.addLast(new TPDUEncoder());
					pipeline.addLast(new BizMessageEncoder());
					pipeline.addLast("TPDULength",new LengthFieldBasedFrameDecoder(1280,2,4,4,0));
					pipeline.addLast(new TPDUDecoder());
//					pipeline.addLast(new TPDUChecker());
					pipeline.addLast("BizDispatcher",new BizHandlerDispatcher());
//					pipeline.addLast(new BizMessageDecoder());
//					pipeline.addLast(new BizHandler());
				}
				
			});
			
			ChannelFuture cf = sb.bind().sync();
			cf.addListener(new ChannelFutureListener(){

				@Override
				public void operationComplete(ChannelFuture future) throws Exception {
					System.out.println("Server is started and listening on port 4088");
				}
				
			});
			cf.channel().closeFuture().sync();
		}finally{
			worker.shutdownGracefully();
			acceptor.shutdownGracefully();
		}
	}

	@Override
	public void onReceiveHeartbeat() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onBizMessage(ChannelHandlerContext ctx, BizMessage message) {
		if(message == null) 
			return;
		switch(message.getCmd()){
			case BizMessageType.CONN:
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

}
