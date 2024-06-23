package com.alibaba.gaiax.studio.third.socket.websocket;

/* compiled from: Taobao */
public interface ReconnectManager {

    /* compiled from: Taobao */
    public interface OnConnectListener {
        void onConnected();

        void onDisconnect();
    }

    void destroy();

    void onConnectError(Throwable th);

    void onConnected();

    boolean reconnecting();

    void startReconnect();

    void stopReconnect();
}
