package com.alibaba.gaiax.studio.third.socket.java_websocket.util;

import androidx.annotation.Keep;
import java.nio.ByteBuffer;

@Keep
/* compiled from: Taobao */
public class ByteBufferUtils {
    private ByteBufferUtils() {
    }

    public static ByteBuffer getEmptyByteBuffer() {
        return ByteBuffer.allocate(0);
    }

    public static int transferByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer == null || byteBuffer2 == null) {
            throw new IllegalArgumentException();
        }
        int remaining = byteBuffer.remaining();
        int remaining2 = byteBuffer2.remaining();
        if (remaining > remaining2) {
            int min = Math.min(remaining, remaining2);
            byteBuffer.limit(min);
            byteBuffer2.put(byteBuffer);
            return min;
        }
        byteBuffer2.put(byteBuffer);
        return remaining;
    }
}
