package com.alibaba.gaiax.studio.third.socket.websocket.dispatcher;

import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import java.nio.ByteBuffer;
import tb.ie0;

/* compiled from: Taobao */
public interface IResponseDispatcher {
    void onConnectFailed(Throwable th, ResponseDelivery responseDelivery);

    void onConnected(ResponseDelivery responseDelivery);

    void onDisconnect(ResponseDelivery responseDelivery);

    void onMessage(String str, ResponseDelivery responseDelivery);

    void onMessage(ByteBuffer byteBuffer, ResponseDelivery responseDelivery);

    void onPing(Framedata framedata, ResponseDelivery responseDelivery);

    void onPong(Framedata framedata, ResponseDelivery responseDelivery);

    void onSendDataError(ie0 ie0, ResponseDelivery responseDelivery);
}
