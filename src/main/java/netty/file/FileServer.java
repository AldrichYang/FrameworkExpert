package netty.file;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * Created by yh on 2018/7/23.
 */
public class FileServer {
//    具体场景如下。
//
//            （1）Netty文件服务器启动，绑定8080作为内部监听端口；
//
//            （2）在CMD控制台，通过telnet和文件服务器建立TCP连接；
//
//            （3）控制台输入需要下载的文件绝对路径；
//
//            （4）文件服务器接收到请求消息后进行合法性判断，如果文件存在，则将文件发送给CMD控制台；
//
//            （5）CMD控制台打印文件名和文件内容

    public void run(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .childHandler(new ChannelInitializer() {
                        public void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(
                                    //它的作用是将文件内容编码为字符串
                                    new StringEncoder(CharsetUtil.UTF_8),
                                    //在ChannelPipeline中添加了LineBasedFrameDecoder，它能够按照回车换行符对数据报进行解码。
                                    new LineBasedFrameDecoder(1024),
                                    //新增StringDecoder，它的作用是将数据报解码成为字符串，两个解码器组合起来就是文本换行解码器。
                                    new StringDecoder(CharsetUtil.UTF_8),
                                    new FileServerHandler());
                        }
                    });
            ChannelFuture f = b.bind(port).sync();
            System.out.println("Start file server at port : " + port);
            f.channel().closeFuture().sync();
        } finally {
            // 优雅停机
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        new FileServer().run(port);
    }
}
