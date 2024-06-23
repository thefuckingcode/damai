package com.alibaba.gaiax.studio.third.socket.websocket.dispatcher;

import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import java.util.ArrayDeque;
import java.util.Queue;
import tb.ie0;

/* compiled from: Taobao */
public class a {
    private EngineThread a;

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0086a {
        private static Queue<C0086a> f = new ArrayDeque(10);
        boolean a;
        Response b;
        ie0 c;
        IResponseDispatcher d;
        ResponseDelivery e;

        C0086a() {
        }

        static C0086a a() {
            C0086a poll = f.poll();
            return poll == null ? new C0086a() : poll;
        }

        static void b(C0086a aVar) {
            f.offer(aVar);
        }
    }

    public a() {
        EngineThread engineThread = new EngineThread();
        this.a = engineThread;
        engineThread.start();
    }

    public void a(Response response, IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        if (response != null && iResponseDispatcher != null && responseDelivery != null) {
            C0086a a2 = C0086a.a();
            a2.d = iResponseDispatcher;
            a2.e = responseDelivery;
            a2.a = false;
            a2.b = response;
            a2.c = null;
            this.a.add(a2);
        }
    }

    public void b(ie0 ie0, IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        if (ie0 != null && iResponseDispatcher != null && responseDelivery != null) {
            C0086a a2 = C0086a.a();
            a2.d = iResponseDispatcher;
            a2.e = responseDelivery;
            a2.a = true;
            a2.c = ie0;
            a2.b = null;
            this.a.add(a2);
        }
    }
}
