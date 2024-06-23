package anetwork.channel.unified;

import android.os.Looper;
import android.text.TextUtils;
import anet.channel.fulltrace.IFullTraceAnalysisV3;
import anet.channel.monitor.BandWidthSampler;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.entity.Repeater;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.interceptor.Interceptor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import tb.b02;
import tb.e21;
import tb.fe0;
import tb.he;
import tb.if1;
import tb.jl1;
import tb.sh1;
import tb.sn0;
import tb.w6;
import tb.yy0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class UnifiedRequestTask {
    protected b a;

    /* compiled from: Taobao */
    class a implements Interceptor.Chain {
        private int a = 0;
        private anet.channel.request.a b = null;
        private Callback c = null;

        a(int i, anet.channel.request.a aVar, Callback callback) {
            this.a = i;
            this.b = aVar;
            this.c = callback;
        }

        @Override // anetwork.channel.interceptor.Interceptor.Chain
        public Callback callback() {
            return this.c;
        }

        @Override // anetwork.channel.interceptor.Interceptor.Chain
        public Future proceed(anet.channel.request.a aVar, Callback callback) {
            if (UnifiedRequestTask.this.a.d.get()) {
                ALog.f("anet.UnifiedRequestTask", "request canneled or timeout in processing interceptor", aVar.n(), new Object[0]);
                return null;
            } else if (this.a < e21.c()) {
                a aVar2 = new a(this.a + 1, aVar, callback);
                Interceptor b2 = e21.b(this.a);
                UnifiedRequestTask.this.a.a.f.lastInterceptor = String.valueOf(b2.getClass());
                return b2.intercept(aVar2);
            } else {
                UnifiedRequestTask.this.a.a.r(aVar);
                b bVar = UnifiedRequestTask.this.a;
                bVar.b = callback;
                ALog.e("anet.UnifiedRequestTask", "start task", bVar.c, new Object[0]);
                Cache c2 = sh1.p() ? he.c(UnifiedRequestTask.this.a.a.h(), UnifiedRequestTask.this.a.a.d()) : null;
                b bVar2 = UnifiedRequestTask.this.a;
                bVar2.e = c2 != null ? new CacheTask(bVar2, c2) : new NetworkTask(bVar2, null, null);
                if (c2 == null) {
                    UnifiedRequestTask.this.f();
                }
                UnifiedRequestTask.this.a.e.run();
                UnifiedRequestTask.this.d();
                return null;
            }
        }

        @Override // anetwork.channel.interceptor.Interceptor.Chain
        public anet.channel.request.a request() {
            return this.b;
        }
    }

    public UnifiedRequestTask(b02 b02, Repeater repeater) {
        repeater.k(b02.i);
        this.a = new b(b02, repeater);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d() {
        this.a.g = ThreadPoolExecutorFactory.j(new Runnable() {
            /* class anetwork.channel.unified.UnifiedRequestTask.AnonymousClass4 */

            public void run() {
                if (UnifiedRequestTask.this.a.d.compareAndSet(false, true)) {
                    RequestStatistic requestStatistic = UnifiedRequestTask.this.a.a.f;
                    if (requestStatistic.isDone.compareAndSet(false, true)) {
                        requestStatistic.statusCode = -202;
                        requestStatistic.msg = fe0.b(-202);
                        requestStatistic.rspEnd = System.currentTimeMillis();
                        anet.channel.fulltrace.a.f().log(requestStatistic.span, "netRspRecvEnd", null);
                        ALog.e("anet.UnifiedRequestTask", "task time out", UnifiedRequestTask.this.a.c, "rs", requestStatistic);
                        w6.b().commitStat(new ExceptionStatistic(-202, null, requestStatistic, null));
                    }
                    UnifiedRequestTask.this.a.b();
                    UnifiedRequestTask.this.a.a();
                    UnifiedRequestTask.this.a.b.onFinish(new DefaultFinishEvent(-202, (String) null, UnifiedRequestTask.this.a.a.b()));
                }
            }
        }, (long) this.a.a.i(), TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f() {
        if (sh1.s() && sh1.w() && NetworkStatusHelper.d() != null) {
            if ((sh1.t(this.a.a.b().c()) && "picture".equalsIgnoreCase(this.a.a.c())) || sh1.x(this.a.a.e())) {
                this.a.f = new MultiPathTask(this.a);
                ThreadPoolExecutorFactory.j(new Runnable() {
                    /* class anetwork.channel.unified.UnifiedRequestTask.AnonymousClass1 */

                    public void run() {
                        if (!UnifiedRequestTask.this.a.d.get()) {
                            ALog.e("anet.UnifiedRequestTask", "[submitMultiPathTask]request is in multi path white list.", null, new Object[0]);
                            if (UnifiedRequestTask.this.a.f != null) {
                                ThreadPoolExecutorFactory.c(UnifiedRequestTask.this.a.f);
                            }
                        }
                    }
                }, sh1.b(), TimeUnit.MILLISECONDS);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.a.d.compareAndSet(false, true)) {
            yy0 e = this.a.a.e();
            ALog.e("anet.UnifiedRequestTask", "task cancelled", this.a.c, "URL", e.l());
            RequestStatistic requestStatistic = this.a.a.f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.ret = 2;
                requestStatistic.statusCode = fe0.ERROR_REQUEST_CANCEL;
                requestStatistic.msg = fe0.b(fe0.ERROR_REQUEST_CANCEL);
                requestStatistic.rspEnd = System.currentTimeMillis();
                anet.channel.fulltrace.a.f().log(requestStatistic.span, "netRspRecvEnd", null);
                w6.b().commitStat(new ExceptionStatistic(fe0.ERROR_REQUEST_CANCEL, null, requestStatistic, null));
                if (requestStatistic.recDataSize > 102400) {
                    BandWidthSampler.f().i(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.recDataSize);
                }
            }
            this.a.b();
            this.a.a();
            this.a.c();
            this.a.b.onFinish(new DefaultFinishEvent((int) fe0.ERROR_REQUEST_CANCEL, (String) null, this.a.a.b()));
        }
    }

    public Future e() {
        long currentTimeMillis = System.currentTimeMillis();
        this.a.a.f.reqServiceTransmissionEnd = currentTimeMillis;
        this.a.a.f.start = currentTimeMillis;
        b02 b02 = this.a.a;
        b02.f.isReqSync = b02.o();
        this.a.a.f.isReqMain = Looper.myLooper() == Looper.getMainLooper();
        this.a.a.f.multiPathOpened = sh1.w() ? 1 : 0;
        try {
            b02 b022 = this.a.a;
            b022.f.netReqStart = Long.valueOf(b022.g("f-netReqStart")).longValue();
        } catch (Exception unused) {
        }
        IFullTraceAnalysisV3.ISpan createRequest = anet.channel.fulltrace.a.f().createRequest(this.a.a.f());
        if (createRequest != null) {
            this.a.a.f.span = createRequest;
            anet.channel.fulltrace.a.f().log(createRequest, "netReqStart", "url=" + this.a.a.h());
        }
        String g = this.a.a.g("f-traceId");
        if (!TextUtils.isEmpty(g)) {
            this.a.a.f.falcoId = g;
        }
        String g2 = this.a.a.g("f-reqProcess");
        b02 b023 = this.a.a;
        RequestStatistic requestStatistic = b023.f;
        requestStatistic.process = g2;
        requestStatistic.pTraceId = b023.g("f-pTraceId");
        b bVar = this.a;
        ALog.e("anet.UnifiedRequestTask", "[falcoId:" + g + jl1.ARRAY_END_STR + "start", bVar.c, if1.DIMEN_BIZ, bVar.a.b().c(), "processFrom", g2, "url", this.a.a.h());
        if (sh1.G(this.a.a.e())) {
            DegradeTask degradeTask = new DegradeTask(this.a);
            this.a.e = degradeTask;
            degradeTask.cancelable = new sn0(ThreadPoolExecutorFactory.c(new Runnable() {
                /* class anetwork.channel.unified.UnifiedRequestTask.AnonymousClass2 */

                public void run() {
                    UnifiedRequestTask.this.a.e.run();
                }
            }), this.a.a.b().n());
            d();
            return new a(this);
        }
        ThreadPoolExecutorFactory.g(new Runnable() {
            /* class anetwork.channel.unified.UnifiedRequestTask.AnonymousClass3 */

            public void run() {
                UnifiedRequestTask unifiedRequestTask = UnifiedRequestTask.this;
                new a(0, unifiedRequestTask.a.a.b(), UnifiedRequestTask.this.a.b).proceed(UnifiedRequestTask.this.a.a.b(), UnifiedRequestTask.this.a.b);
            }
        }, ThreadPoolExecutorFactory.b.a);
        return new a(this);
    }
}
