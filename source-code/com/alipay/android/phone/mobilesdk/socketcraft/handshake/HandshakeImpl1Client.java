package com.alipay.android.phone.mobilesdk.socketcraft.handshake;

import tb.jl1;

/* compiled from: Taobao */
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {
    private String c = jl1.MUL;

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshake
    public String getResourceDescriptor() {
        return this.c;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshakeBuilder
    public void setResourceDescriptor(String str) {
        if (str != null) {
            this.c = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}
