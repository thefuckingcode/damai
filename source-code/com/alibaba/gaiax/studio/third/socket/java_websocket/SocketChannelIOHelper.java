package com.alibaba.gaiax.studio.third.socket.java_websocket;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Role;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

@Keep
/* compiled from: Taobao */
public class SocketChannelIOHelper {
    private SocketChannelIOHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean batch(WebSocketImpl webSocketImpl, ByteChannel byteChannel) throws IOException {
        if (webSocketImpl == null) {
            return false;
        }
        ByteBuffer peek = webSocketImpl.outQueue.peek();
        WrappedByteChannel wrappedByteChannel = null;
        if (peek != null) {
            do {
                byteChannel.write(peek);
                if (peek.remaining() > 0) {
                    return false;
                }
                webSocketImpl.outQueue.poll();
                peek = webSocketImpl.outQueue.peek();
            } while (peek != null);
        } else if (byteChannel instanceof WrappedByteChannel) {
            wrappedByteChannel = (WrappedByteChannel) byteChannel;
            if (wrappedByteChannel.isNeedWrite()) {
                wrappedByteChannel.writeMore();
            }
        }
        if (webSocketImpl.outQueue.isEmpty() && webSocketImpl.isFlushAndClose() && webSocketImpl.getDraft() != null && webSocketImpl.getDraft().getRole() != null && webSocketImpl.getDraft().getRole() == Role.SERVER) {
            webSocketImpl.closeConnection();
        }
        if (wrappedByteChannel == null || !((WrappedByteChannel) byteChannel).isNeedWrite()) {
            return true;
        }
        return false;
    }

    public static boolean read(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, ByteChannel byteChannel) throws IOException {
        byteBuffer.clear();
        int read = byteChannel.read(byteBuffer);
        byteBuffer.flip();
        if (read == -1) {
            webSocketImpl.eot();
            return false;
        } else if (read != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean readMore(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, WrappedByteChannel wrappedByteChannel) throws IOException {
        byteBuffer.clear();
        int readMore = wrappedByteChannel.readMore(byteBuffer);
        byteBuffer.flip();
        if (readMore != -1) {
            return wrappedByteChannel.isNeedRead();
        }
        webSocketImpl.eot();
        return false;
    }
}
