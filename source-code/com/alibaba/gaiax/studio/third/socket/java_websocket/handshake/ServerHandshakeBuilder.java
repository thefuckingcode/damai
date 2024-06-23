package com.alibaba.gaiax.studio.third.socket.java_websocket.handshake;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public interface ServerHandshakeBuilder extends HandshakeBuilder, ServerHandshake {
    void setHttpStatus(short s);

    void setHttpStatusMessage(String str);
}
