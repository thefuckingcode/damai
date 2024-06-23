package com.youku.network.call;

import anetwork.channel.Network;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.youku.android.antiflow.AntiFlowManagerImpl;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.httpcommunication.b;
import com.youku.network.a;
import com.youku.network.c;
import com.youku.network.d;
import java.util.concurrent.Future;
import tb.m50;

/* compiled from: Taobao */
public class k extends a {
    private Request e;
    private Network f;
    private Future<Response> g;
    private IAntiFlowManager h;

    @Override // com.youku.network.call.a
    public d a() {
        if (this.h.beforeCall()) {
            d a = d.a();
            a.b(420);
            return a;
        }
        return this.d.a(this.f.syncSend(this.e, null));
    }

    @Override // com.youku.network.call.a
    public void a(a aVar) {
        if (this.h.beforeCall()) {
            d a = d.a();
            a.b(420);
            a(null, aVar, a);
            return;
        }
        this.g = this.f.asyncSend(this.e, null, null, new l(aVar, this.h));
    }

    @Override // com.youku.network.call.a
    public void a(c cVar) {
        this.c = cVar;
        this.h = new AntiFlowManagerImpl(b.a, cVar.e(), cVar.M(), cVar.N());
        this.f = new m50(b.a);
        com.youku.network.a.d dVar = new com.youku.network.a.d(this.h);
        this.d = dVar;
        this.e = dVar.a(cVar);
    }

    @Override // com.youku.network.call.a
    public void b() {
        Future<Response> future = this.g;
        if (future != null) {
            future.cancel(true);
        }
    }

    @Override // com.youku.network.call.a
    public void b(a aVar) {
        if (this.h.beforeCall()) {
            d a = d.a();
            a.b(420);
            a(a.a, aVar, a);
            return;
        }
        this.g = this.f.asyncSend(this.e, null, null, new l(a.a, aVar, this.h));
    }
}
