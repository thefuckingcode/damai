package com.alibaba.gaiax.studio.third.socket.websocket;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.MainThreadResponseDelivery;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;
import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import tb.d02;
import tb.ez2;
import tb.i91;
import tb.ie0;
import tb.s02;

/* compiled from: Taobao */
public class b {
    private ez2 a;
    private WebSocketWrapper b;
    private ResponseDelivery c;
    private ReconnectManager d;
    private SocketWrapperListener e;
    private boolean f = false;
    private boolean g = false;
    private WebSocketEngine h;
    private com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.a i;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ReconnectManager.OnConnectListener {
        a() {
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager.OnConnectListener
        public void onConnected() {
            i91.d("[WSManager]", "重连成功");
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager.OnConnectListener
        public void onDisconnect() {
            i91.d("[WSManager]", "重连失败");
            b.this.a.i().onDisconnect(b.this.c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.gaiax.studio.third.socket.websocket.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0085b implements SocketWrapperListener {
        C0085b() {
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketWrapperListener
        public void onConnectFailed(Throwable th) {
            if (b.this.d != null && b.this.d.reconnecting()) {
                b.this.d.onConnectError(th);
            }
            b.this.a.i().onConnectFailed(th, b.this.c);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketWrapperListener
        public void onConnected() {
            if (b.this.d != null) {
                b.this.d.onConnected();
            }
            b.this.a.i().onConnected(b.this.c);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketWrapperListener
        public void onDisconnect() {
            b.this.a.i().onDisconnect(b.this.c);
            if (b.this.d == null || !b.this.d.reconnecting()) {
                if (!b.this.g) {
                    if (b.this.d == null) {
                        b bVar = b.this;
                        bVar.d = bVar.k();
                    }
                    b.this.d.onConnectError(null);
                    b.this.d.startReconnect();
                }
            } else if (b.this.g) {
                b.this.a.i().onDisconnect(b.this.c);
            } else {
                b.this.d.onConnectError(null);
            }
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketWrapperListener
        public void onMessage(Response response) {
            if (b.this.a.j()) {
                b.this.i.a(response, b.this.a.i(), b.this.c);
            } else {
                response.onResponse(b.this.a.i(), b.this.c);
            }
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketWrapperListener
        public void onSendDataError(Request request, int i, Throwable th) {
            ie0 b = s02.b();
            b.a(request, i, th);
            if (b.this.a.j()) {
                b.this.i.b(b, b.this.a.i(), b.this.c);
            } else {
                b.this.a.i().onSendDataError(b, b.this.c);
            }
            if (!b.this.g && i == 0) {
                i91.b("[WSManager]", "数据发送失败，网络未连接，开始重连。。。");
                b.this.n();
            }
        }
    }

    b(ez2 ez2, WebSocketEngine webSocketEngine, com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.a aVar) {
        this.a = ez2;
        this.h = webSocketEngine;
        this.i = aVar;
        ResponseDelivery h2 = ez2.h();
        this.c = h2;
        if (h2 == null) {
            this.c = new MainThreadResponseDelivery();
        }
        SocketWrapperListener m = m();
        this.e = m;
        if (this.b == null) {
            this.b = new WebSocketWrapper(this.a, m);
        }
        Log.e("[WSManager]", "WebSocketManager: " + this.b.l());
        s();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ReconnectManager k() {
        return new DefaultReconnectManager(this, new a());
    }

    private SocketWrapperListener m() {
        return new C0085b();
    }

    private void r(Request request) {
        if (this.f) {
            i91.b("[WSManager]", "This WebSocketManager is destroyed!");
        } else {
            this.h.d(this.b, request, this.e);
        }
    }

    public b h(SocketListener socketListener) {
        this.c.addListener(socketListener);
        return this;
    }

    public void i() {
        this.f = true;
        WebSocketWrapper webSocketWrapper = this.b;
        if (webSocketWrapper != null) {
            this.h.b(webSocketWrapper);
            this.h = null;
            this.b = null;
        }
        ResponseDelivery responseDelivery = this.c;
        if (responseDelivery != null) {
            if (!responseDelivery.isEmpty()) {
                this.c.clear();
            }
            this.c = null;
        }
        ReconnectManager reconnectManager = this.d;
        if (reconnectManager != null) {
            if (reconnectManager.reconnecting()) {
                this.d.stopReconnect();
            }
            this.d = null;
        }
        Log.e("[WSManager]", "destroy: 完成");
    }

    public b j() {
        this.g = true;
        if (this.f) {
            i91.b("[WSManager]", "This WebSocketManager is destroyed!");
            return this;
        }
        if (this.b.l() != 0) {
            this.h.c(this.b, this.e);
        }
        return this;
    }

    public ez2 l() {
        return this.a;
    }

    public b n() {
        this.g = false;
        if (this.d == null) {
            this.d = k();
        }
        if (!this.d.reconnecting()) {
            this.d.startReconnect();
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void o() {
        if (this.f) {
            i91.b("[WSManager]", "This WebSocketManager is destroyed!");
        } else if (this.b.l() == 0) {
            this.h.a(this.b, this.e);
        } else {
            ReconnectManager reconnectManager = this.d;
            if (reconnectManager != null) {
                reconnectManager.onConnected();
            }
            i91.b("[WSManager]", "WebSocket 已连接，请勿重试。");
        }
    }

    public b p(SocketListener socketListener) {
        this.c.removeListener(socketListener);
        return this;
    }

    public void q(String str) {
        if (!TextUtils.isEmpty(str)) {
            Request<String> a2 = d02.a();
            a2.setRequestData(str);
            r(a2);
        }
    }

    public b s() {
        if (this.b == null) {
            this.b = new WebSocketWrapper(this.a, this.e);
        }
        if (this.b.l() == 0) {
            Log.e("[WSManager]", "start: reconnect!!!!!");
            n();
        }
        return this;
    }
}
