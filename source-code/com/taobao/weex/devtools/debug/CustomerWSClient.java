package com.taobao.weex.devtools.debug;

import android.os.HandlerThread;
import com.taobao.weex.devtools.WeexInspector;
import com.taobao.weex.devtools.debug.IWebSocketClient;
import com.taobao.weex.devtools.debug.SocketClient;
import java.io.IOException;

/* compiled from: Taobao */
public class CustomerWSClient extends SocketClient {
    private IWebSocketClient webSocketClient = WeexInspector.getCustomerWSClient();

    public CustomerWSClient(DebugServerProxy debugServerProxy) {
        super(debugServerProxy);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.debug.SocketClient
    public void close() {
        IWebSocketClient iWebSocketClient = this.webSocketClient;
        if (iWebSocketClient != null) {
            iWebSocketClient.close();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.debug.SocketClient
    public void connect(String str) {
        IWebSocketClient iWebSocketClient = this.webSocketClient;
        if (iWebSocketClient != null) {
            iWebSocketClient.connect(str, new IWebSocketClient.WSListener() {
                /* class com.taobao.weex.devtools.debug.CustomerWSClient.AnonymousClass1 */

                @Override // com.taobao.weex.devtools.debug.IWebSocketClient.WSListener
                public void onClose() {
                    HandlerThread handlerThread = CustomerWSClient.this.mHandlerThread;
                    if (handlerThread != null && handlerThread.isAlive()) {
                        CustomerWSClient.this.mHandler.sendEmptyMessage(3);
                    }
                }

                @Override // com.taobao.weex.devtools.debug.IWebSocketClient.WSListener
                public void onFailure(Throwable th) {
                    SocketClient.Callback callback = CustomerWSClient.this.mConnectCallback;
                    if (callback != null) {
                        callback.onFailure(th);
                        CustomerWSClient.this.mConnectCallback = null;
                    }
                }

                @Override // com.taobao.weex.devtools.debug.IWebSocketClient.WSListener
                public void onMessage(String str) {
                    try {
                        CustomerWSClient.this.mProxy.handleMessage(str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.taobao.weex.devtools.debug.IWebSocketClient.WSListener
                public void onOpen() {
                    SocketClient.Callback callback = CustomerWSClient.this.mConnectCallback;
                    if (callback != null) {
                        callback.onSuccess(null);
                    }
                }
            });
        }
    }

    public boolean isAvailed() {
        return this.webSocketClient != null;
    }

    @Override // com.taobao.weex.devtools.websocket.SimpleSession, com.taobao.weex.devtools.debug.SocketClient
    public boolean isOpen() {
        IWebSocketClient iWebSocketClient = this.webSocketClient;
        return iWebSocketClient != null && iWebSocketClient.isOpen();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.debug.SocketClient
    public void sendProtocolMessage(int i, String str) {
        IWebSocketClient iWebSocketClient = this.webSocketClient;
        if (iWebSocketClient != null) {
            iWebSocketClient.sendMessage(i, str);
        }
    }
}
