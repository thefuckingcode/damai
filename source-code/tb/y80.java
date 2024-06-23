package tb;

import android.text.TextUtils;
import com.taobao.phenix.cache.disk.DiskCacheKeyValueStore;
import com.taobao.phenix.cache.disk.DiskCacheSupplier;
import com.taobao.phenix.cache.disk.OnlyCacheFailedException;
import com.taobao.phenix.request.a;
import com.taobao.phenix.request.b;
import com.taobao.rxm.consume.Consumer;

/* compiled from: Taobao */
public class y80 extends z9<qd0, qd0> {
    private DiskCacheKeyValueStore k;

    public y80(DiskCacheSupplier diskCacheSupplier, DiskCacheKeyValueStore diskCacheKeyValueStore) {
        super(1, 0, diskCacheSupplier);
        this.k = diskCacheKeyValueStore;
    }

    private boolean M(a aVar) {
        DiskCacheKeyValueStore diskCacheKeyValueStore = this.k;
        return diskCacheKeyValueStore != null && diskCacheKeyValueStore.isTTLDomain(aVar.N());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x017f  */
    @Override // tb.qg
    public boolean a(Consumer<qd0, a> consumer) {
        boolean z;
        String str;
        pd0 pd0;
        boolean z2;
        boolean z3;
        Exception e;
        a context = consumer.getContext();
        if (context.d0()) {
            return false;
        }
        o(consumer);
        vr2.n("Phenix", "DiskCacheRead Started.", context);
        b G = context.G();
        String D = context.D();
        int C = context.C();
        int[] iArr = new int[1];
        iArr[0] = G.b() ? context.z() : 1;
        pd0 J = J(context, D, C, iArr);
        boolean z4 = J != null && J.a();
        if (z4 && M(context)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String str2 = this.k.get(D + C);
                if (!TextUtils.isEmpty(str2) && TextUtils.isDigitsOnly(str2) && this.k.getCurrentTime() - Long.valueOf(str2).longValue() > 0) {
                    try {
                        vr2.n("Phenix", "DiskCacheRead TTL Expired", context);
                        z4 = false;
                    } catch (Exception e2) {
                        e = e2;
                        z4 = false;
                        kg0.c("TTL", "ttl get error=%s", e);
                        String N = context.N();
                        if (!z4) {
                        }
                        consumer.onProgressUpdate(1.0f);
                        context.U().t(z4);
                        if (!z4) {
                        }
                        str = N;
                        pd0 = J;
                        z2 = false;
                        n(consumer, z);
                        vr2.n("Phenix", "DiskCacheReader Finished.", context);
                        if (z4) {
                        }
                        if (!z) {
                        }
                        return z;
                    }
                }
                context.U().z = System.currentTimeMillis() - currentTimeMillis;
            } catch (Exception e3) {
                e = e3;
                kg0.c("TTL", "ttl get error=%s", e);
                String N2 = context.N();
                if (!z4) {
                }
                consumer.onProgressUpdate(1.0f);
                context.U().t(z4);
                if (!z4) {
                }
                str = N2;
                pd0 = J;
                z2 = false;
                n(consumer, z);
                vr2.n("Phenix", "DiskCacheReader Finished.", context);
                if (z4) {
                }
                if (!z) {
                }
                return z;
            }
        }
        String N22 = context.N();
        z = !z4 && iArr[0] != 2;
        if (z && context.R() > 0) {
            consumer.onProgressUpdate(1.0f);
        }
        context.U().t(z4);
        if (!z4 || context.T() == null) {
            str = N22;
            pd0 = J;
            z2 = false;
        } else {
            String k2 = context.T().k();
            String f = context.T().f();
            int e4 = context.T().e();
            iArr[0] = 1;
            pd0 = J(context, f, e4, iArr);
            boolean z5 = pd0 != null && pd0.a();
            if (z5) {
                context.x();
                z3 = true;
            } else {
                z3 = false;
            }
            context.U().t(z5);
            vr2.k("DiskCache", context, "secondary read result=%B, isLast=false, secondaryKey=%s, secondaryCatalog=%d", Boolean.valueOf(z5), f, Integer.valueOf(e4));
            str = k2;
            z4 = z5;
            z2 = z3;
        }
        n(consumer, z);
        vr2.n("Phenix", "DiskCacheReader Finished.", context);
        if (z4) {
            if (z) {
                context.U().A(pd0.b);
                context.U().x = (long) pd0.b;
                ln0.j(context.U());
            }
            qd0 qd0 = new qd0(pd0, str, iArr[0], true, G.i());
            qd0.p = z2;
            qd0.n = G.m();
            qd0.o = G.h();
            consumer.onNewResult(qd0, z);
        }
        if (!z || !context.a0()) {
            return z;
        }
        consumer.onFailure(new OnlyCacheFailedException("DiskCache"));
        return true;
    }
}
