package netty.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

/**
 * Created by dell on 2015/6/17.
 */
public class TimeClient {
    public static void main(String[] args) throws Exception {
        String host = "192.168.31.230";
        int port = 8080;
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.TCP_NODELAY, true) ; // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
                    ch.pipeline().addLast(new HttpResponseDecoder());
                    // 客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    ch.pipeline().addLast("aaa", new TimeClientHandler())
                            .addLast("bbbb", new TimeClientSendRequestHandler());
                }
            });
            // Start the client.
//            ChannelFuture f = b.connect(host, port); // (5)
            Channel channel = b.connect(host, port).sync().channel();
            DefaultFullHttpRequest request = new DefaultFullHttpRequest( HttpVersion.HTTP_1_1, HttpMethod.POST ,"/sdf" );
            request.content().writeBytes( "123".getBytes() );
            request.headers().add( "SeqNum" , String.valueOf(1 ) );
            request.headers().add( "Content-Length"  , String.valueOf("123".getBytes().length));
            channel.writeAndFlush(request);
//            f.channel().close().syncUninterruptibly();
            // Wait until the connection is closed.
            channel.closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
