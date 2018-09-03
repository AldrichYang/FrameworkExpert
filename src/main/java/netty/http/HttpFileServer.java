package netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created by yh on 2018/7/10.
 */
public class HttpFileServer {

    private static final String DEFAULT_URL = "/src/main/java/netty";

    public void run(int port, String url) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap s = new ServerBootstrap();
            s.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
//                            HttpObjectAggregator解码器，它的作用是将多个消息转换成单一的FullHttpRequest或者FullHttpResponse.
//                            因为HTTP解码器在每个HTTP消息中会生成多个消息对象：1. HttpRequest/HttpResponse 2. HttpContent 3. LastHttpContent
                            ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                            ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
//                          Chunked Handler主要作用：支持异步发送大的码流(例如大的文件传输)，但不占用过大的内存，防止发生Java内存溢出错误
                            ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
//                            文件服务的业务逻辑处理类
                            ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));
                        }
                    });
            ChannelFuture future = s.bind("127.0.0.1", port).sync();
            System.out.println("HTTP文件目录服务器启动，网址是:" + "http://127.0.0.1:" + port + url);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        String url = DEFAULT_URL;
        if (args.length > 1) {
            url = args[1];
        }
        new HttpFileServer().run(port, url);

    }
}
