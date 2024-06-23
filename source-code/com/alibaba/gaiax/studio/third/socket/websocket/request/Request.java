package com.alibaba.gaiax.studio.third.socket.websocket.request;

import com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient;

/* compiled from: Taobao */
public interface Request<T> {
    T getRequestData();

    void release();

    void send(WebSocketClient webSocketClient);

    void setRequestData(T t);
}
