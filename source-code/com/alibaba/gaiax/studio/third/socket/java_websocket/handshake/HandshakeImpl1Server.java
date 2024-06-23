package com.alibaba.gaiax.studio.third.socket.java_websocket.handshake;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class HandshakeImpl1Server extends HandshakedataImpl1 implements ServerHandshakeBuilder {
    private short httpstatus;
    private String httpstatusmessage;

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshake
    public short getHttpStatus() {
        return this.httpstatus;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshake
    public String getHttpStatusMessage() {
        return this.httpstatusmessage;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshakeBuilder
    public void setHttpStatus(short s) {
        this.httpstatus = s;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshakeBuilder
    public void setHttpStatusMessage(String str) {
        this.httpstatusmessage = str;
    }
}
