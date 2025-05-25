package org.client.handlers;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.server.data.RequestData;

// Обробник, який надсилатиме запит і отримуватиме
// відповідь від сервера.
public class ClientHandler extends ChannelInboundHandlerAdapter {

    String productName;
    int productQuota;
    ChannelFuture future;

    public ClientHandler(String productName, int productQuota) {
        this.productName = productName;
        this.productQuota = productQuota;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        RequestData msg = new RequestData();
        msg.setIntValue(productQuota);
        msg.setStringValue(productName);
        future = ctx.writeAndFlush(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(msg);
        ctx.close();
    }
}
