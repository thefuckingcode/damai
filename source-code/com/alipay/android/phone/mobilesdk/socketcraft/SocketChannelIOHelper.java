package com.alipay.android.phone.mobilesdk.socketcraft;

import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* compiled from: Taobao */
public class SocketChannelIOHelper {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[SYNTHETIC] */
    public static boolean batch(WebSocketImpl webSocketImpl, ByteChannel byteChannel) {
        WrappedByteChannel wrappedByteChannel;
        ByteBuffer peek = webSocketImpl.outQueue.peek();
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
            if (webSocketImpl.outQueue.isEmpty() && webSocketImpl.isFlushAndClose() && webSocketImpl.getDraft() != null && webSocketImpl.getDraft().getRole() != null && webSocketImpl.getDraft().getRole() == WebSocket.Role.SERVER) {
                synchronized (webSocketImpl) {
                    webSocketImpl.closeConnection();
                }
            }
            if (wrappedByteChannel == null || !((WrappedByteChannel) byteChannel).isNeedWrite()) {
                return true;
            }
            return false;
        }
        wrappedByteChannel = null;
        synchronized (webSocketImpl) {
        }
    }

    public static boolean read(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, ByteChannel byteChannel) {
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

    public static boolean readMore(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, WrappedByteChannel wrappedByteChannel) {
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
