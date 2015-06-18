package netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by dell on 2015/6/17.
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead: "+msg);
        ctx.pipeline().write( "readed" );
//        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelReadComplete: "+ctx);
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
      /*  System.out.println("channelActive");
        final ByteBuf time = ctx.alloc().buffer(4); // (2)
        int iTmp = (int)Math.round(Math.random()*100);
        time.writeInt(iTmp);
        System.out.println("serverRandom:"+iTmp);
        final ChannelFuture f = ctx.writeAndFlush(time); // (3)*/
       /* f.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        }); */// (4)
    }
}