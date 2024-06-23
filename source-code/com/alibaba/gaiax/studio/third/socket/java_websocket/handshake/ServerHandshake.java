package com.alibaba.gaiax.studio.third.socket.java_websocket.handshake;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public interface ServerHandshake extends Handshakedata {
    short getHttpStatus();

    String getHttpStatusMessage();
}
