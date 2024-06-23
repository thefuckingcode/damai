package com.alibaba.gaiax.studio.third.socket.java_websocket.handshake;

import androidx.annotation.Keep;
import tb.jl1;

@Keep
/* compiled from: Taobao */
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {
    private String resourceDescriptor = jl1.MUL;

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ClientHandshake
    public String getResourceDescriptor() {
        return this.resourceDescriptor;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ClientHandshakeBuilder
    public void setResourceDescriptor(String str) {
        if (str != null) {
            this.resourceDescriptor = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}
