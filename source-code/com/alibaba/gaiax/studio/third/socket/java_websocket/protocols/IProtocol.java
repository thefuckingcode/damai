package com.alibaba.gaiax.studio.third.socket.java_websocket.protocols;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public interface IProtocol {
    boolean acceptProvidedProtocol(String str);

    IProtocol copyInstance();

    String getProvidedProtocol();

    String toString();
}
