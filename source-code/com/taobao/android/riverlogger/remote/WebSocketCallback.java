package com.taobao.android.riverlogger.remote;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public interface WebSocketCallback {
    void onSocketClose(int i, String str);

    void onSocketError(String str);

    void onSocketMessage(String str);
}
