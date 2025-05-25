package org.server.handlers;

import io.netty.channel.*;
import org.server.data.RequestData;
import org.server.data.ResponseData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcessingHandler extends ChannelInboundHandlerAdapter {
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static String clientName = "C-" + atomicInteger.incrementAndGet();
    // Список підключених клієнтських каналів.
    static final List<Channel> channels = new ArrayList<>();

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        String time = DATE_FORMAT.format(new Date());
        System.out.println(time + " [Client] " + clientName + " joined");
        channels.add(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        RequestData requestData = (RequestData) msg;
        ResponseData responseData = new ResponseData();
        // Певна логіка над даними: операція множення
        responseData.setIntValue(requestData.getIntValue());
        ChannelFuture future = ctx.writeAndFlush(responseData);
        future.addListener(ChannelFutureListener.CLOSE);
        System.out.println(requestData);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("Closing connection for client - " + clientName);
        ctx.close();
    }

}
