package com.alibaba.gaiax.studio.third.socket.websocket;

import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import java.nio.ByteBuffer;
import tb.ie0;

/* compiled from: Taobao */
public interface SocketListener {
    void onConnectFailed(Throwable th);

    void onConnected();

    void onDisconnect();

    <T> void onMessage(String str, T t);

    <T> void onMessage(ByteBuffer byteBuffer, T t);

    void onPing(Framedata framedata);

    void onPong(Framedata framedata);

    void onSendDataError(ie0 ie0);
}
