package com.taobao.weex.devtools.debug;

/* compiled from: Taobao */
public interface IWebSocketClient {

    /* compiled from: Taobao */
    public interface WSListener {
        void onClose();

        void onFailure(Throwable th);

        void onMessage(String str);

        void onOpen();
    }

    void close();

    void connect(String str, WSListener wSListener);

    boolean isOpen();

    void sendMessage(int i, String str);
}
