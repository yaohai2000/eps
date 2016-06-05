package com.bhz.eps.test;


import com.bhz.eps.util.Converts;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

public class EPSPosEmulator {
	private void connect(String host, int port, byte[] msg) throws Exception{
		EventLoopGroup worker = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		try{
			b.group(worker)
			.channel(NioSocketChannel.class)
			.option(ChannelOption.SO_KEEPALIVE, true)
			.handler(new ChannelInitializer<Channel>() {

				@Override
				protected void initChannel(Channel ch) throws Exception {
					ch.pipeline().addLast(new EPSClientHandler(msg));
				}
				
			});
			ChannelFuture f = b.connect(host, port).sync();
			f.channel().closeFuture().sync();
		}finally{
			worker.shutdownGracefully();
		}
	}
	public static void main(String[] args) throws Exception{
		EPSPosEmulator ec = new EPSPosEmulator();
		PosConnectMessage connMsg = new PosConnectMessage();
		
		ec.connect("localhost", 4088, connMsg.generateMessage());
	}
	
	
}

class EPSClientHandler extends SimpleChannelInboundHandler<ByteBuf>{
	
	final byte[] msg;
	
	public EPSClientHandler(byte[] msg) {
		super();
		this.msg = msg;
	}

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		System.out.println(msg.toString(CharsetUtil.UTF_8));
		ctx.channel().close();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Sending message to server: " + Converts.bytesToHexString(msg));
		ByteBuf bb = Unpooled.buffer(msg.length);
		bb.writeBytes(msg);
		ctx.writeAndFlush(bb);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
	
}
