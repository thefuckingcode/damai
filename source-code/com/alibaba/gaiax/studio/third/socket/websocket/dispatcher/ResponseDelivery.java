package com.alibaba.gaiax.studio.third.socket.websocket.dispatcher;

import com.alibaba.gaiax.studio.third.socket.websocket.SocketListener;

/* compiled from: Taobao */
public interface ResponseDelivery extends SocketListener {
    void addListener(SocketListener socketListener);

    void clear();

    boolean isEmpty();

    void removeListener(SocketListener socketListener);
}
