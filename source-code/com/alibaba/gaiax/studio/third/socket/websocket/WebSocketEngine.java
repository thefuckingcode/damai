package com.alibaba.gaiax.studio.third.socket.websocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;
import java.util.ArrayDeque;
import java.util.Queue;
import tb.i91;

/* compiled from: Taobao */
public class WebSocketEngine {
    private OptionThread a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class OptionThread extends Thread {
        private b mHandler;

        private OptionThread() {
        }

        public void run() {
            super.run();
            Looper.prepare();
            this.mHandler = new b();
            Looper.loop();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class ReRunnable implements Runnable {
        private static Queue<ReRunnable> POOL = new ArrayDeque(10);
        private Request request;
        private int type;
        private WebSocketWrapper webSocketWrapper;

        private ReRunnable() {
        }

        static ReRunnable obtain() {
            ReRunnable poll = POOL.poll();
            return poll == null ? new ReRunnable() : poll;
        }

        /* access modifiers changed from: package-private */
        public void release() {
            POOL.offer(this);
        }

        public void run() {
            int i;
            try {
                WebSocketWrapper webSocketWrapper2 = this.webSocketWrapper;
                if (webSocketWrapper2 != null && ((i = this.type) != 0 || this.request != null)) {
                    if (i == 0) {
                        webSocketWrapper2.v(this.request);
                    } else if (i == 1) {
                        webSocketWrapper2.t();
                    } else if (i == 2) {
                        webSocketWrapper2.k();
                    } else if (i == 3) {
                        webSocketWrapper2.j();
                    }
                    this.webSocketWrapper = null;
                    this.request = null;
                    release();
                }
            } finally {
                this.webSocketWrapper = null;
                this.request = null;
                release();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b extends Handler {
        private b() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    WebSocketEngine() {
        OptionThread optionThread = new OptionThread();
        this.a = optionThread;
        optionThread.start();
    }

    /* access modifiers changed from: package-private */
    public void a(WebSocketWrapper webSocketWrapper, SocketWrapperListener socketWrapperListener) {
        if (this.a.mHandler == null) {
            socketWrapperListener.onConnectFailed(new Exception("WebSocketEngine not start!"));
            return;
        }
        ReRunnable obtain = ReRunnable.obtain();
        obtain.type = 1;
        obtain.webSocketWrapper = webSocketWrapper;
        this.a.mHandler.post(obtain);
    }

    /* access modifiers changed from: package-private */
    public void b(WebSocketWrapper webSocketWrapper) {
        if (this.a.mHandler != null) {
            ReRunnable obtain = ReRunnable.obtain();
            obtain.type = 3;
            obtain.webSocketWrapper = webSocketWrapper;
            this.a.mHandler.post(obtain);
            return;
        }
        i91.b("WSWebSocketEngine", "WebSocketEngine not start!");
    }

    /* access modifiers changed from: package-private */
    public void c(WebSocketWrapper webSocketWrapper, SocketWrapperListener socketWrapperListener) {
        if (this.a.mHandler != null) {
            ReRunnable obtain = ReRunnable.obtain();
            obtain.type = 2;
            obtain.webSocketWrapper = webSocketWrapper;
            this.a.mHandler.post(obtain);
            return;
        }
        i91.b("WSWebSocketEngine", "WebSocketEngine not start!");
    }

    /* access modifiers changed from: package-private */
    public void d(WebSocketWrapper webSocketWrapper, Request request, SocketWrapperListener socketWrapperListener) {
        if (this.a.mHandler == null) {
            socketWrapperListener.onSendDataError(request, 2, null);
            return;
        }
        ReRunnable obtain = ReRunnable.obtain();
        obtain.type = 0;
        obtain.request = request;
        obtain.webSocketWrapper = webSocketWrapper;
        this.a.mHandler.post(obtain);
    }
}
