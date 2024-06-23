package com.alibaba.gaiax.studio.third.socket.java_websocket.handshake;

import androidx.annotation.Keep;
import java.util.Iterator;

@Keep
/* compiled from: Taobao */
public interface Handshakedata {
    byte[] getContent();

    String getFieldValue(String str);

    boolean hasFieldValue(String str);

    Iterator<String> iterateHttpFields();
}
