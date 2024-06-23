package com.alibaba.gaiax.studio.third.socket.websocket.dispatcher;

import android.text.TextUtils;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.websocket.SocketListener;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import tb.ie0;
import tb.tk2;

/* compiled from: Taobao */
public class MainThreadResponseDelivery implements ResponseDelivery {
    private static final Object b = new Object();
    private static Queue<CallbackRunnable> c;
    private final List<SocketListener> a = new ArrayList();

    /* compiled from: Taobao */
    enum RUNNABLE_TYPE {
        NON,
        CONNECTED,
        CONNECT_FAILED,
        DISCONNECT,
        SEND_ERROR,
        STRING_MSG,
        BYTE_BUFFER_MSG,
        PING,
        PONG
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[RUNNABLE_TYPE.values().length];
            a = iArr;
            iArr[RUNNABLE_TYPE.CONNECTED.ordinal()] = 1;
            a[RUNNABLE_TYPE.CONNECT_FAILED.ordinal()] = 2;
            a[RUNNABLE_TYPE.DISCONNECT.ordinal()] = 3;
            a[RUNNABLE_TYPE.SEND_ERROR.ordinal()] = 4;
            a[RUNNABLE_TYPE.STRING_MSG.ordinal()] = 5;
            a[RUNNABLE_TYPE.BYTE_BUFFER_MSG.ordinal()] = 6;
            a[RUNNABLE_TYPE.PING.ordinal()] = 7;
            a[RUNNABLE_TYPE.PONG.ordinal()] = 8;
        }
    }

    private CallbackRunnable c() {
        if (c == null) {
            c = new ArrayDeque(5);
        }
        CallbackRunnable poll = c.poll();
        return poll == null ? new CallbackRunnable(null) : poll;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery
    public void addListener(SocketListener socketListener) {
        if (socketListener != null && !this.a.contains(socketListener)) {
            synchronized (b) {
                this.a.add(socketListener);
            }
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery
    public void clear() {
        if (!this.a.isEmpty()) {
            synchronized (b) {
                this.a.clear();
            }
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onConnectFailed(Throwable th) {
        if (!isEmpty()) {
            if (tk2.b()) {
                synchronized (b) {
                    for (SocketListener socketListener : this.a) {
                        socketListener.onConnectFailed(th);
                    }
                }
                return;
            }
            CallbackRunnable c2 = c();
            c2.type = RUNNABLE_TYPE.CONNECT_FAILED;
            c2.connectErrorCause = th;
            c2.mSocketListenerList = this.a;
            tk2.c(c2);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onConnected() {
        if (!isEmpty()) {
            if (tk2.b()) {
                synchronized (b) {
                    for (SocketListener socketListener : this.a) {
                        socketListener.onConnected();
                    }
                }
                return;
            }
            CallbackRunnable c2 = c();
            c2.type = RUNNABLE_TYPE.CONNECTED;
            c2.mSocketListenerList = this.a;
            tk2.c(c2);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onDisconnect() {
        if (!isEmpty()) {
            if (tk2.b()) {
                synchronized (b) {
                    for (SocketListener socketListener : this.a) {
                        socketListener.onDisconnect();
                    }
                }
                return;
            }
            CallbackRunnable c2 = c();
            c2.type = RUNNABLE_TYPE.DISCONNECT;
            c2.mSocketListenerList = this.a;
            tk2.c(c2);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public <T> void onMessage(String str, T t) {
        if (!(isEmpty() || str == null)) {
            if (tk2.b()) {
                synchronized (b) {
                    for (SocketListener socketListener : this.a) {
                        socketListener.onMessage(str, t);
                    }
                }
                return;
            }
            CallbackRunnable c2 = c();
            c2.type = RUNNABLE_TYPE.STRING_MSG;
            c2.textResponse = str;
            c2.formattedData = t;
            c2.mSocketListenerList = this.a;
            tk2.c(c2);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onPing(Framedata framedata) {
        if (!isEmpty()) {
            if (tk2.b()) {
                synchronized (b) {
                    for (SocketListener socketListener : this.a) {
                        socketListener.onPing(framedata);
                    }
                }
                return;
            }
            CallbackRunnable c2 = c();
            c2.type = RUNNABLE_TYPE.PING;
            c2.framedataResponse = framedata;
            c2.mSocketListenerList = this.a;
            tk2.c(c2);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onPong(Framedata framedata) {
        if (!isEmpty()) {
            if (tk2.b()) {
                synchronized (b) {
                    for (SocketListener socketListener : this.a) {
                        socketListener.onPong(framedata);
                    }
                }
                return;
            }
            CallbackRunnable c2 = c();
            c2.type = RUNNABLE_TYPE.PONG;
            c2.framedataResponse = framedata;
            c2.mSocketListenerList = this.a;
            tk2.c(c2);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onSendDataError(ie0 ie0) {
        if (!(isEmpty() || ie0 == null)) {
            if (tk2.b()) {
                synchronized (b) {
                    for (SocketListener socketListener : this.a) {
                        socketListener.onSendDataError(ie0);
                    }
                }
                return;
            }
            CallbackRunnable c2 = c();
            c2.type = RUNNABLE_TYPE.SEND_ERROR;
            c2.errorResponse = ie0;
            c2.mSocketListenerList = this.a;
            tk2.c(c2);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery
    public void removeListener(SocketListener socketListener) {
        if (socketListener != null && !isEmpty() && this.a.contains(socketListener)) {
            synchronized (b) {
                this.a.remove(socketListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class CallbackRunnable<T> implements Runnable {
        ByteBuffer byteResponse;
        Throwable connectErrorCause;
        ie0 errorResponse;
        T formattedData;
        Framedata framedataResponse;
        List<SocketListener> mSocketListenerList;
        String textResponse;
        RUNNABLE_TYPE type;

        private CallbackRunnable() {
            this.type = RUNNABLE_TYPE.NON;
        }

        public void run() {
            List<SocketListener> list;
            RUNNABLE_TYPE runnable_type;
            try {
                if (!(this.type == RUNNABLE_TYPE.NON || (list = this.mSocketListenerList) == null)) {
                    if (!list.isEmpty()) {
                        RUNNABLE_TYPE runnable_type2 = this.type;
                        if (!(runnable_type2 == RUNNABLE_TYPE.CONNECT_FAILED && this.connectErrorCause == null) && (!(runnable_type2 == RUNNABLE_TYPE.SEND_ERROR && this.errorResponse == null) && ((runnable_type2 != RUNNABLE_TYPE.STRING_MSG || !TextUtils.isEmpty(this.textResponse)) && !(((runnable_type = this.type) == RUNNABLE_TYPE.BYTE_BUFFER_MSG && this.byteResponse == null) || ((runnable_type == RUNNABLE_TYPE.PING && this.framedataResponse == null) || (runnable_type == RUNNABLE_TYPE.PONG && this.framedataResponse == null)))))) {
                            synchronized (MainThreadResponseDelivery.b) {
                                switch (a.a[this.type.ordinal()]) {
                                    case 1:
                                        for (SocketListener socketListener : this.mSocketListenerList) {
                                            socketListener.onConnected();
                                        }
                                        break;
                                    case 2:
                                        for (SocketListener socketListener2 : this.mSocketListenerList) {
                                            socketListener2.onConnectFailed(this.connectErrorCause);
                                        }
                                        break;
                                    case 3:
                                        for (SocketListener socketListener3 : this.mSocketListenerList) {
                                            socketListener3.onDisconnect();
                                        }
                                        break;
                                    case 4:
                                        for (SocketListener socketListener4 : this.mSocketListenerList) {
                                            socketListener4.onSendDataError(this.errorResponse);
                                        }
                                        break;
                                    case 5:
                                        for (SocketListener socketListener5 : this.mSocketListenerList) {
                                            socketListener5.onMessage(this.textResponse, this.formattedData);
                                        }
                                        break;
                                    case 6:
                                        for (SocketListener socketListener6 : this.mSocketListenerList) {
                                            socketListener6.onMessage(this.byteResponse, this.formattedData);
                                        }
                                        break;
                                    case 7:
                                        for (SocketListener socketListener7 : this.mSocketListenerList) {
                                            socketListener7.onPing(this.framedataResponse);
                                        }
                                        break;
                                    case 8:
                                        for (SocketListener socketListener8 : this.mSocketListenerList) {
                                            socketListener8.onPong(this.framedataResponse);
                                        }
                                        break;
                                }
                                this.mSocketListenerList = null;
                                this.errorResponse = null;
                                this.connectErrorCause = null;
                                this.textResponse = null;
                                this.byteResponse = null;
                                this.framedataResponse = null;
                                this.formattedData = null;
                            }
                            MainThreadResponseDelivery.c.offer(this);
                        }
                    }
                }
            } finally {
                MainThreadResponseDelivery.c.offer(this);
            }
        }

        /* synthetic */ CallbackRunnable(a aVar) {
            this();
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public <T> void onMessage(ByteBuffer byteBuffer, T t) {
        if (!(isEmpty() || byteBuffer == null)) {
            if (tk2.b()) {
                synchronized (b) {
                    for (SocketListener socketListener : this.a) {
                        socketListener.onMessage(byteBuffer, t);
                    }
                }
                return;
            }
            CallbackRunnable c2 = c();
            c2.type = RUNNABLE_TYPE.BYTE_BUFFER_MSG;
            c2.byteResponse = byteBuffer;
            c2.formattedData = t;
            c2.mSocketListenerList = this.a;
            tk2.c(c2);
        }
    }
}
