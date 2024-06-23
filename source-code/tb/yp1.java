package tb;

import android.text.TextUtils;
import com.taobao.phenix.cache.memory.MemOnlyFailedException;
import com.taobao.phenix.chain.ImageDecodingListener;
import com.taobao.phenix.chain.PhenixProduceListener;
import com.taobao.phenix.decode.DecodeException;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.phenix.intf.event.IRetryHandlerOnFailure;
import com.taobao.phenix.loader.network.HttpCodeResponseException;
import com.taobao.phenix.request.ImageFlowMonitor;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.phenix.request.a;
import com.taobao.phenix.request.b;
import com.taobao.rxm.consume.BaseConsumer;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.ProducerListener;
import com.taobao.rxm.schedule.Scheduler;
import com.taobao.rxm.schedule.SchedulerSupplier;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class yp1 extends BaseConsumer<so1, a> {
    private final vp1 e;
    private final ImageFlowMonitor f;
    private final SchedulerSupplier g;

    public yp1(a aVar, vp1 vp1, ImageFlowMonitor imageFlowMonitor, SchedulerSupplier schedulerSupplier, ImageDecodingListener imageDecodingListener) {
        super(aVar);
        this.e = vp1;
        this.f = imageFlowMonitor;
        this.g = schedulerSupplier;
        aVar.p(new PhenixProduceListener(aVar, vp1.s(), imageDecodingListener));
    }

    private void l(long j) {
        if (this.f != null) {
            ImageStatistics U = ((a) getContext()).U();
            U.w(m(j, false, true, ((a) getContext()).d()));
            this.f.onSuccess(U);
        }
    }

    private Map<String, Integer> m(long j, boolean z, boolean z2, int i) {
        StringBuilder sb;
        HashMap hashMap = null;
        if (!(z || z2)) {
            return null;
        }
        int S = (int) (j - ((a) getContext()).S());
        int V = ((a) getContext()).V() <= 0 ? 0 : (int) (j - ((a) getContext()).V());
        if (z) {
            sb = new StringBuilder(150);
            sb.append("User-Callback: ");
            sb.append(System.currentTimeMillis() - j);
            sb.append('\n');
            sb.append("Total-Time: ");
            sb.append(S);
            sb.append('\n');
            sb.append("Wait-Main: ");
            sb.append(V);
            sb.append('\n');
        } else {
            sb = null;
        }
        if (z2) {
            hashMap = new HashMap();
        }
        int i2 = 0;
        for (Map.Entry<String, Long> entry : ((a) getContext()).Q().entrySet()) {
            String key = entry.getKey();
            int intValue = entry.getValue().intValue();
            if (z) {
                sb.append(key);
                sb.append(": ");
                if (intValue < 0) {
                    sb.append("Unknown(cause interrupted)");
                } else {
                    sb.append(intValue);
                }
                sb.append('\n');
            }
            if (intValue >= 0) {
                i2 += intValue;
                if (z2) {
                    hashMap.put(key, Integer.valueOf(intValue));
                }
            }
        }
        int i3 = i2 + V;
        if (S < i3) {
            S = i3;
        }
        int i4 = (S - i2) - V;
        if (z2) {
            hashMap.put(ImageStatistics.KEY_TOTAL_TIME, Integer.valueOf(S));
            hashMap.put(ImageStatistics.KEY_SCHEDULE_TIME, Integer.valueOf(i4));
            ImageFlowMonitor imageFlowMonitor = this.f;
            if (!(imageFlowMonitor == null || this.g == null || i4 < imageFlowMonitor.getMinimumScheduleTime2StatWaitSize())) {
                hashMap.put(ImageStatistics.KEY_MASTER_WAIT_SIZE, Integer.valueOf(this.g.forCpuBound().getQueueSize()));
                hashMap.put(ImageStatistics.KEY_NETWORK_WAIT_SIZE, Integer.valueOf(this.g.forNetwork().getQueueSize()));
                hashMap.put(ImageStatistics.KEY_DECODE_WAIT_SIZE, Integer.valueOf(this.g.forDecode().getQueueSize()));
            }
            hashMap.put(ImageStatistics.KEY_WAIT_FOR_MAIN, Integer.valueOf(V));
        }
        if (z) {
            sb.append("Schedule-Time: ");
            sb.append(i4);
            vr2.k("PhenixConsumer", (a) getContext(), "Detail-Cost:\n%s\n", sb.substring(0));
        }
        vr2.c("Phenix", "requestId=%d,UI_QUEUE_SIZE=%d", Integer.valueOf(i), Integer.valueOf(this.g.forUiThread().getQueueSize()));
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x0025;
     */
    private boolean n(a aVar, Throwable th) {
        if (aVar.c0()) {
            return false;
        }
        String str = null;
        String k = aVar.G().k();
        IRetryHandlerOnFailure u = this.e.u();
        if (u != null) {
            str = u.getRetryUrl(this.e, th);
        }
        if (th instanceof DecodeException) {
            DecodeException decodeException = (DecodeException) th;
            b G = ((a) getContext()).G();
            if (decodeException.isDataFromDisk() && DecodeException.DecodedError.UNLINK_SO_ERROR != decodeException.getDecodedError() && !G.n()) {
                aVar.s0();
                str = k;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        aVar.i0(str);
        vr2.x("PhenixConsumer", aVar, "retry to load when received failure=%s, raw=%s", th, k);
        this.e.n();
        return true;
    }

    @Override // com.taobao.rxm.consume.BaseConsumer, com.taobao.rxm.consume.Consumer
    public Consumer<so1, a> consumeOn(Scheduler scheduler) {
        super.consumeOn(scheduler);
        ProducerListener g2 = ((a) getContext()).g();
        if (g2 != null) {
            ((PhenixProduceListener) g2).h(scheduler);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.rxm.consume.BaseConsumer
    public void e() {
        String N = ((a) getContext()).N();
        vr2.k("PhenixConsumer", (a) getContext(), "received cancellation, cost=%dms", Long.valueOf(System.currentTimeMillis() - ((a) getContext()).S()));
        ln0.g(((a) getContext()).U());
        ln0.i(((a) getContext()).U());
        if (this.e.q() != null) {
            this.e.q().onHappen(new wp1(N, ((a) getContext()).P()));
        }
        ln0.h(((a) getContext()).U());
        ImageFlowMonitor imageFlowMonitor = this.f;
        if (imageFlowMonitor != null) {
            imageFlowMonitor.onCancel(((a) getContext()).U());
        }
        kg0.b(6, "Phenix", "Cancelled | requestId:" + ((a) getContext()).d() + "| url:" + N);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.rxm.consume.BaseConsumer
    public void f(Throwable th) {
        a aVar = (a) getContext();
        if (!n(aVar, th)) {
            if (th instanceof MemOnlyFailedException) {
                vr2.k("PhenixConsumer", (a) getContext(), "ignored MemOnlyFailedException(%s)", th);
                return;
            }
            vr2.m("PhenixConsumer", (a) getContext(), "received failure=%s", th);
            if (kg0.g(3) && th != null) {
                th.printStackTrace();
            }
            ln0.i(((a) getContext()).U());
            if (this.e.r() != null) {
                qg0 qg0 = new qg0(aVar.P());
                if (th != null && (th instanceof HttpCodeResponseException)) {
                    HttpCodeResponseException httpCodeResponseException = (HttpCodeResponseException) th;
                    qg0.g(httpCodeResponseException.getHttpCode());
                    qg0.h(httpCodeResponseException.getMessage());
                }
                qg0.i(404);
                qg0.c(((a) getContext()).N());
                this.e.r().onHappen(qg0);
            }
            ln0.h(((a) getContext()).U());
            ImageFlowMonitor imageFlowMonitor = this.f;
            if (imageFlowMonitor != null) {
                imageFlowMonitor.onFail(aVar.U(), th);
            }
        }
    }

    @Override // com.taobao.rxm.consume.BaseConsumer
    public void h(float f2) {
        if (this.e.t() != null) {
            gt1 gt1 = new gt1(((a) getContext()).P(), f2);
            gt1.c(((a) getContext()).N());
            this.e.t().onHappen(gt1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void g(so1 so1, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        vr2.n("Phenix", "UI Thread Process CallBack Started.", (a) getContext());
        IPhenixListener<ug2> w = this.e.w();
        vr2.k("PhenixConsumer", (a) getContext(), "received new result=%s, isLast=%b", so1, Boolean.valueOf(z));
        ln0.i(((a) getContext()).U());
        if (w != null) {
            ug2 ug2 = new ug2(((a) getContext()).P());
            ug2.j(so1);
            ug2.c(((a) getContext()).N());
            ug2.k(so1.h());
            ug2.l(!z);
            ug2.d(so1.g());
            ug2.e(so1.i());
            w.onHappen(ug2);
        }
        vr2.n("Phenix", "UI Thread Process CallBack End.", (a) getContext());
        ln0.h(((a) getContext()).U());
        if (z) {
            l(currentTimeMillis);
        }
    }
}
