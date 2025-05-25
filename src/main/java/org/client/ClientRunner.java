package org.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.client.coders.RequestDataEncoder;
import org.client.coders.ResponseDataDecoder;
import org.client.handlers.ClientHandler;

// Запуск клієнта
public class ClientRunner {

     public void runClient(String productName, int productQuota) throws Exception {
        String host = "localhost";
        int port = 8080;
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            // Встановлення EventLoopGroup для обробки всіх подій клієнта
            b.group(workerGroup);
            // Використання NIO для отримання нових підключень
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);

            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) {
                    ch.pipeline().addLast(new RequestDataEncoder(),
                            new ResponseDataDecoder(),
                            new ClientHandler(productName, productQuota));
                }
            });
            // Клієнт стартує
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
