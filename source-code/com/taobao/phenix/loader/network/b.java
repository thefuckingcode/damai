package com.taobao.phenix.loader.network;

import android.text.TextUtils;
import com.taobao.phenix.loader.network.HttpLoader;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import com.taobao.rxm.request.RequestCancelListener;
import com.taobao.rxm.schedule.PairingThrottlingScheduler;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import java.util.Map;
import java.util.concurrent.Future;
import tb.cs1;
import tb.ln0;
import tb.pd0;
import tb.qd0;
import tb.r02;
import tb.vr2;
import tb.ye2;

/* compiled from: Taobao */
public class b extends BaseChainProducer<qd0, r02, com.taobao.phenix.request.a> implements RequestCancelListener<com.taobao.phenix.request.a> {
    private HttpLoader j;

    /* compiled from: Taobao */
    class a implements HttpLoader.FinishCallback {
        final /* synthetic */ long a;
        final /* synthetic */ Consumer b;
        final /* synthetic */ com.taobao.phenix.request.a c;

        a(long j, Consumer consumer, com.taobao.phenix.request.a aVar) {
            this.a = j;
            this.b = consumer;
            this.c = aVar;
        }

        @Override // com.taobao.phenix.loader.network.HttpLoader.FinishCallback
        public void onError(Exception exc) {
            b.this.K(((com.taobao.phenix.request.a) this.b.getContext()).d());
            this.b.onFailure(exc);
        }

        @Override // com.taobao.phenix.loader.network.HttpLoader.FinishCallback
        public void onFinished(r02 r02) {
            boolean z = this.a != Thread.currentThread().getId();
            com.taobao.phenix.request.a aVar = (com.taobao.phenix.request.a) this.b.getContext();
            aVar.t("inner_is_async_http", Boolean.toString(z));
            if (aVar.i()) {
                vr2.n("Phenix", "request is cancelled before consuming response data", this.c);
                this.b.onCancellation();
                r02.release();
                b.this.K(aVar.d());
                return;
            }
            vr2.n("Phenix", "Network Connect Finished.", this.c);
            b.this.n(this.b, true);
            if (z) {
                b.this.z(this.b, true, r02, false);
            } else {
                b.this.consumeNewResult(this.b, true, r02);
            }
        }
    }

    public b(HttpLoader httpLoader) {
        super(2, 0);
        cs1.c(httpLoader);
        this.j = httpLoader;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void K(int i) {
        Scheduler consumeScheduler = getConsumeScheduler();
        if (consumeScheduler instanceof PairingThrottlingScheduler) {
            ((PairingThrottlingScheduler) consumeScheduler).c(i);
        }
    }

    /* renamed from: J */
    public void consumeNewResult(Consumer<qd0, com.taobao.phenix.request.a> consumer, boolean z, r02 r02) {
        q(consumer, z);
        com.taobao.phenix.request.a context = consumer.getContext();
        vr2.n("Phenix", "Network Read Started.", context);
        ln0.j(context.U());
        if (context.i()) {
            vr2.q("Network", context, "request is cancelled before reading response stream", new Object[0]);
            consumer.onCancellation();
            r02.release();
            return;
        }
        ye2 ye2 = new ye2(consumer, r02.b, context.R());
        try {
            pd0 c = pd0.c(r02, ye2);
            if (!ye2.d()) {
                context.U().A(c.b);
                if (!c.g) {
                    vr2.m("Network", context, "miss bytes while reading response[type:%d], read=%d, content=%d", Integer.valueOf(r02.a), Integer.valueOf(ye2.b()), Integer.valueOf(ye2.d));
                    consumer.onFailure(new IncompleteResponseException());
                    return;
                }
                context.s(this);
                com.taobao.phenix.request.b G = context.G();
                p(consumer, true, z);
                vr2.n("Phenix", "Network Read Finished.", context);
                consumer.onNewResult(new qd0(c, G.k(), 1, false, G.i()), z);
            }
        } catch (Exception e) {
            vr2.m("Network", context, "transform data from response[type:%d] error, read=%d, content=%d, throwable=%s", Integer.valueOf(r02.a), Integer.valueOf(ye2.b()), Integer.valueOf(ye2.d), e);
            consumer.onFailure(e);
        }
    }

    /* renamed from: L */
    public void onCancel(com.taobao.phenix.request.a aVar) {
        K(aVar.d());
        vr2.n("Phenix", "received cancellation.", aVar);
        Future<?> B = aVar.B();
        if (B != null) {
            aVar.k0(null);
            try {
                B.cancel(true);
                vr2.k("Network", aVar, "cancelled blocking future(%s), result=%b", B, Boolean.valueOf(B.isCancelled()));
            } catch (Exception e) {
                vr2.m("Network", aVar, "cancel blocking future error=%s", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.qg
    public boolean b(Consumer<qd0, com.taobao.phenix.request.a> consumer, ScheduledAction scheduledAction) {
        Map<String, String> H;
        String str;
        com.taobao.phenix.request.a context = consumer.getContext();
        long id = Thread.currentThread().getId();
        o(consumer);
        vr2.n("Phenix", "Network Connect Started.", context);
        context.t("inner_network_start_time", String.valueOf(System.currentTimeMillis()));
        context.l(this);
        if (!TextUtils.isEmpty(context.U().q)) {
            context.t("f-traceId", context.U().q);
        }
        context.k0(this.j.load(context.N(), context.H(), new a(id, consumer, context)));
        if (scheduledAction != null && ((H = context.H()) == null || (str = H.get("inner_is_async_http")) == null || Boolean.valueOf(str).booleanValue())) {
            scheduledAction.notConsumeAction(true);
        }
        return true;
    }
}
