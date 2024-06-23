package com.alibaba.gaiax.studio.third.socket.websocket;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket;
import com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft_6455;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.WebsocketNotConnectedException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshake;
import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import tb.ez2;
import tb.i91;
import tb.s02;

/* compiled from: Taobao */
public class WebSocketWrapper {
    private ez2 a;
    private SocketWrapperListener b;
    private WebSocketClient c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class MyWebSocketClient extends WebSocketClient {
        public MyWebSocketClient(URI uri) {
            super(uri);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient
        public void onClose(int i, String str, boolean z) {
            WebSocketWrapper.this.m(i, str, z);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient
        public void onError(Exception exc) {
            WebSocketWrapper.this.n(exc);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient
        public void onMessage(String str) {
            WebSocketWrapper.this.o(str);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient
        public void onOpen(ServerHandshake serverHandshake) {
            WebSocketWrapper.this.q(serverHandshake);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener, com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketAdapter
        public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
            super.onWebsocketPing(webSocket, framedata);
            WebSocketWrapper.this.r(framedata);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener, com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketAdapter
        public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
            super.onWebsocketPong(webSocket, framedata);
            WebSocketWrapper.this.s(framedata);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient
        public void onMessage(ByteBuffer byteBuffer) {
            WebSocketWrapper.this.p(byteBuffer);
        }

        public MyWebSocketClient(URI uri, Draft draft) {
            super(uri, draft);
        }

        public MyWebSocketClient(URI uri, Map<String, String> map) {
            super(uri, map);
        }

        public MyWebSocketClient(URI uri, Draft draft, Map<String, String> map) {
            super(uri, draft, map);
        }

        public MyWebSocketClient(URI uri, Draft draft, Map<String, String> map, int i) {
            super(uri, draft, map, i);
        }
    }

    WebSocketWrapper(ez2 ez2, SocketWrapperListener socketWrapperListener) {
        this.a = ez2;
        this.b = socketWrapperListener;
    }

    private void h() {
        if (this.f) {
            try {
                WebSocketClient webSocketClient = this.c;
                if (webSocketClient != null && !webSocketClient.isClosed()) {
                    this.c.close();
                }
                u();
                this.d = 0;
            } catch (Throwable th) {
                i91.c("[WSWrapper]", "checkDestroy(WebSocketClient)", th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m(int i, String str, boolean z) {
        this.d = 0;
        i91.a("[WSWrapper]", String.format("WebSocket closed!code=%s,reason:%s,remote:%s", Integer.valueOf(i), str, Boolean.valueOf(z)));
        SocketWrapperListener socketWrapperListener = this.b;
        if (socketWrapperListener != null) {
            socketWrapperListener.onDisconnect();
        }
        h();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n(Exception exc) {
        if (this.f) {
            h();
        } else {
            i91.c("[WSWrapper]", "WebSocketClient#onError(Exception)", exc);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(String str) {
        if (this.f) {
            h();
            return;
        }
        this.d = 2;
        if (this.b != null) {
            Response<String> e2 = s02.e();
            e2.setResponseData(str);
            i91.d("[WSWrapper]", "WebSocket received message:" + e2.toString());
            this.b.onMessage(e2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p(ByteBuffer byteBuffer) {
        if (this.f) {
            h();
            return;
        }
        this.d = 2;
        if (this.b != null) {
            Response<ByteBuffer> a2 = s02.a();
            a2.setResponseData(byteBuffer);
            i91.d("[WSWrapper]", "WebSocket received message:" + a2.toString());
            this.b.onMessage(a2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q(ServerHandshake serverHandshake) {
        if (this.f) {
            h();
            return;
        }
        this.d = 2;
        i91.d("[WSWrapper]", "WebSocket connect success");
        if (this.e) {
            k();
            return;
        }
        SocketWrapperListener socketWrapperListener = this.b;
        if (socketWrapperListener != null) {
            socketWrapperListener.onConnected();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r(Framedata framedata) {
        if (this.f) {
            h();
            return;
        }
        this.d = 2;
        if (this.b != null) {
            Response<Framedata> c2 = s02.c();
            c2.setResponseData(framedata);
            i91.d("[WSWrapper]", "WebSocket received ping:" + c2.toString());
            this.b.onMessage(c2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void s(Framedata framedata) {
        if (this.f) {
            h();
            return;
        }
        this.d = 2;
        if (this.b != null) {
            Response<Framedata> d2 = s02.d();
            d2.setResponseData(framedata);
            i91.d("[WSWrapper]", "WebSocket received pong:" + d2.toString());
            this.b.onMessage(d2);
        }
    }

    private void u() {
        if (this.b != null) {
            this.b = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Log.e("[WSWrapper]", "connect: ");
        if (!this.f) {
            this.e = false;
            if (this.d == 0) {
                this.d = 1;
                try {
                    if (this.c != null) {
                        i91.d("[WSWrapper]", "WebSocket reconnecting...");
                        this.c.reconnect();
                        if (this.e) {
                            k();
                        }
                        h();
                    } else if (!TextUtils.isEmpty(this.a.b())) {
                        Draft d2 = this.a.d();
                        if (d2 == null) {
                            d2 = new Draft_6455();
                        }
                        int a2 = this.a.a();
                        this.c = new MyWebSocketClient(new URI(this.a.b()), d2, this.a.e(), a2 <= 0 ? 0 : a2);
                        i91.d("[WSWrapper]", "WebSocket start connect...");
                        if (this.a.f() != null) {
                            this.c.setProxy(this.a.f());
                        }
                        this.c.connect();
                        this.c.setConnectionLostTimeout(this.a.c());
                        if (this.e) {
                            k();
                        }
                        h();
                    } else {
                        throw new RuntimeException("WebSocket connect url is empty!");
                    }
                } catch (Throwable th) {
                    this.d = 0;
                    i91.c("[WSWrapper]", "WebSocket connect failed:", th);
                    SocketWrapperListener socketWrapperListener = this.b;
                    if (socketWrapperListener != null) {
                        socketWrapperListener.onConnectFailed(th);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f = true;
        k();
        if (this.d == 0) {
            this.c = null;
        }
        u();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.e = true;
        if (this.d == 2) {
            i91.d("[WSWrapper]", "WebSocket disconnecting...");
            WebSocketClient webSocketClient = this.c;
            if (webSocketClient != null) {
                webSocketClient.close();
            }
            i91.d("[WSWrapper]", "WebSocket disconnected");
        }
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        this.e = false;
        if (this.d == 0) {
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void v(Request request) {
        WebSocketClient webSocketClient = this.c;
        if (webSocketClient != null) {
            if (request == null) {
                i91.b("[WSWrapper]", "send data is null!");
            } else if (this.d == 2) {
                try {
                    request.send(webSocketClient);
                    i91.d("[WSWrapper]", "send success:" + request.toString());
                } catch (WebsocketNotConnectedException e2) {
                    this.d = 0;
                    i91.c("[WSWrapper]", "ws is disconnected, send failed:" + request.toString(), e2);
                    SocketWrapperListener socketWrapperListener = this.b;
                    if (socketWrapperListener != null) {
                        socketWrapperListener.onSendDataError(request, 0, e2);
                        this.b.onDisconnect();
                    }
                } catch (Throwable th) {
                    request.release();
                    throw th;
                }
                request.release();
            } else {
                i91.b("[WSWrapper]", "WebSocket not connect,send failed:" + request.toString());
                SocketWrapperListener socketWrapperListener2 = this.b;
                if (socketWrapperListener2 != null) {
                    socketWrapperListener2.onSendDataError(request, 0, null);
                }
            }
        }
    }
}
