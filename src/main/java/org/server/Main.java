package org.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.server.coders.RequestDecoder;
import org.server.coders.ResponseDataEncoder;
import org.server.handlers.ProcessingHandler;

public class Main {
    private final int port;

    public Main(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {

        int port = args.length > 0
                ? Integer.parseInt(args[0]) : 8080;
        new Main(port).run();
    }

        public void run() throws Exception {

            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workerGroup = new NioEventLoopGroup();

            try {

                ServerBootstrap b = new ServerBootstrap();
                b.group(bossGroup, workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            public void initChannel(SocketChannel ch) {
                                // Визначаємо вхідні та вихідні обробники,
                                // які будуть обробляти запити та
                                // виводити у правильному порядку.
                                ch.pipeline().addLast(new RequestDecoder(),
                                        new ResponseDataEncoder(),
                                        new ProcessingHandler());
                            }
                        }).option(ChannelOption.SO_BACKLOG, 128)
                        .childOption(ChannelOption.SO_KEEPALIVE, true);

                // Прив'язання та початок приймання вхідних з'єднаннь.
                // Стартує сервер.
                ChannelFuture f = b.bind(port).sync();
                System.out.println("Server started. Ready for client.");
                // Дочікування закриття сокету сервера.
                f.channel().closeFuture().sync();
            } finally {
                // Завершуються всі цикли обробки подій,
                // щоб завершити всі потоки.
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
            }
        }
}