package com.taobao.phenix.loader.file;

import com.taobao.phenix.request.a;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import tb.i42;
import tb.ln0;
import tb.pd0;
import tb.qd0;
import tb.r02;
import tb.vr2;
import tb.ye2;

/* compiled from: Taobao */
public class b extends BaseChainProducer<qd0, qd0, a> {
    private final FileLoader j;

    public b(FileLoader fileLoader) {
        super(1, 0);
        this.j = fileLoader;
    }

    private pd0 H(Consumer<qd0, a> consumer, boolean z, i42 i42, String str) throws Exception {
        a context = consumer.getContext();
        r02 load = this.j.load(i42, str, context.H());
        int i = 0;
        if (context.i()) {
            vr2.q("LocalFile", context, "Request is cancelled before reading file", new Object[0]);
            consumer.onCancellation();
            load.release();
            return null;
        }
        int i2 = load.b;
        if (!z) {
            i = context.R();
        }
        ye2 ye2 = new ye2(consumer, i2, i);
        pd0 c = pd0.c(load, ye2);
        if (ye2.d()) {
            return null;
        }
        return c;
    }

    /* access modifiers changed from: protected */
    @Override // tb.qg
    public boolean a(Consumer<qd0, a> consumer) {
        String str;
        boolean z;
        a context = consumer.getContext();
        com.taobao.phenix.request.b G = context.G();
        com.taobao.phenix.request.b T = context.T();
        i42 l = G.l();
        boolean z2 = false;
        char c = l.a() ? 1 : (T == null || !T.l().a()) ? (char) 0 : 2;
        if (c == 0) {
            return false;
        }
        pd0 pd0 = null;
        String k = G.k();
        o(consumer);
        vr2.n("Phenix", "LocalImage started.", context);
        if (c != 1) {
            if (c == 2) {
                try {
                    k = T.k();
                    pd0 = H(consumer, true, T.l(), k);
                    consumer.getContext().x();
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(pd0 != null && pd0.a());
                    vr2.l("LocalFile", k, "load file(secondary) result=%B", objArr);
                } catch (Exception e) {
                    vr2.p("LocalFile", k, "load file(secondary) error=%s", e);
                }
            }
            str = k;
            z = false;
        } else {
            try {
                pd0 = H(consumer, false, l, k);
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(pd0 != null && pd0.a());
                vr2.l("LocalFile", k, "load file result=%B", objArr2);
            } catch (Exception e2) {
                vr2.p("LocalFile", k, "load file error=%s", e2);
                consumer.onFailure(e2);
            }
            str = k;
            z = true;
        }
        n(consumer, z);
        vr2.n("Phenix", "LocalImage Finished.", context);
        if (pd0 != null) {
            if (z) {
                context.U().A(pd0.b);
                context.U().x = (long) pd0.b;
                ln0.j(context.U());
            }
            qd0 qd0 = new qd0(pd0, str, 1, true, G.i());
            if (c == 2) {
                z2 = true;
            }
            qd0.p = z2;
            consumer.onNewResult(qd0, z);
        }
        return z;
    }
}
