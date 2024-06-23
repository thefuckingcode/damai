package com.alibaba.gaiax.studio.third.socket.java_websocket;

import androidx.annotation.Keep;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

@Keep
/* compiled from: Taobao */
public interface WrappedByteChannel extends ByteChannel {
    boolean isBlocking();

    boolean isNeedRead();

    boolean isNeedWrite();

    int readMore(ByteBuffer byteBuffer) throws IOException;

    void writeMore() throws IOException;
}
