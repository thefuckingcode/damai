package com.youku.live.messagechannel.connection.Connector;

/* compiled from: Taobao */
public interface ConnectorListener {
    void onClosed();

    void onError(String str);

    void onMessage(String str, String str2, byte[] bArr);

    void onOpen();
}
