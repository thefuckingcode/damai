package com.alibaba.gaiax.studio.third.socket.websocket;

import com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import tb.i91;

/* compiled from: Taobao */
public class DefaultReconnectManager implements ReconnectManager {
    private final Object a = new Object();
    private b b;
    private ReconnectManager.OnConnectListener c;
    private volatile boolean d;
    private volatile boolean e;
    private volatile boolean f = false;
    private volatile boolean g = false;
    private final ExecutorService h = Executors.newSingleThreadExecutor();
    private int i = 1;
    private int j = 1;

    public DefaultReconnectManager(b bVar, ReconnectManager.OnConnectListener onConnectListener) {
        this.b = bVar;
        this.c = onConnectListener;
        this.d = false;
        this.e = false;
    }

    static /* synthetic */ int e(DefaultReconnectManager defaultReconnectManager) {
        int i2 = defaultReconnectManager.i;
        defaultReconnectManager.i = i2 + 1;
        return i2;
    }

    static /* synthetic */ int l(DefaultReconnectManager defaultReconnectManager) {
        int i2 = defaultReconnectManager.j;
        defaultReconnectManager.j = i2 + 1;
        return i2;
    }

    private Runnable m() {
        return new Runnable() {
            /* class com.alibaba.gaiax.studio.third.socket.websocket.DefaultReconnectManager.AnonymousClass1 */

            public void run() {
                if (DefaultReconnectManager.this.e || DefaultReconnectManager.this.f) {
                    DefaultReconnectManager.this.d = false;
                    return;
                }
                i91.a("WSDefaultRM", "开始重连:" + DefaultReconnectManager.this.i);
                DefaultReconnectManager.e(DefaultReconnectManager.this);
                DefaultReconnectManager.this.d = true;
                DefaultReconnectManager.this.g = false;
                try {
                    int g = DefaultReconnectManager.this.b.l().g();
                    int i = 0;
                    while (true) {
                        if (i >= g) {
                            break;
                        }
                        i++;
                        i91.d("WSDefaultRM", String.format("第%s次重连", Integer.valueOf(i)));
                        DefaultReconnectManager.this.b.o();
                        synchronized (DefaultReconnectManager.this.a) {
                            try {
                                DefaultReconnectManager.this.a.wait((long) DefaultReconnectManager.this.b.l().a());
                                if (DefaultReconnectManager.this.g) {
                                    i91.d("WSDefaultRM", "reconnectOnce success!");
                                    DefaultReconnectManager.this.c.onConnected();
                                    i91.a("WSDefaultRM", "重连结束:" + DefaultReconnectManager.this.j);
                                    DefaultReconnectManager.l(DefaultReconnectManager.this);
                                    DefaultReconnectManager.this.d = false;
                                    i91.d("WSDefaultRM", "reconnecting = false");
                                    return;
                                } else if (DefaultReconnectManager.this.f) {
                                }
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                    i91.d("WSDefaultRM", "reconnectOnce failed!");
                    DefaultReconnectManager.this.c.onDisconnect();
                } finally {
                    i91.a("WSDefaultRM", "重连结束:" + DefaultReconnectManager.this.j);
                    DefaultReconnectManager.l(DefaultReconnectManager.this);
                    DefaultReconnectManager.this.d = false;
                    i91.d("WSDefaultRM", "reconnecting = false");
                }
            }
        };
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public void destroy() {
        this.e = true;
        stopReconnect();
        this.b = null;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public void onConnectError(Throwable th) {
        this.g = false;
        synchronized (this.a) {
            i91.d("WSDefaultRM", "onConnectError(Throwable)->BLOCK.notifyAll()");
            this.a.notifyAll();
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public void onConnected() {
        this.g = true;
        synchronized (this.a) {
            i91.d("WSDefaultRM", "onConnected()->BLOCK.notifyAll()");
            this.a.notifyAll();
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public boolean reconnecting() {
        return this.d;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public void startReconnect() {
        if (this.d) {
            i91.d("WSDefaultRM", "Reconnecting, do not call again.");
        } else if (this.e) {
            i91.b("WSDefaultRM", "ReconnectManager is destroyed!!!");
        } else {
            this.f = false;
            this.d = true;
            try {
                this.h.execute(m());
            } catch (RejectedExecutionException e2) {
                i91.c("WSDefaultRM", "线程队列已满，无法执行此次任务。", e2);
                this.d = false;
            }
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public void stopReconnect() {
        this.f = true;
        ExecutorService executorService = this.h;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }
}
