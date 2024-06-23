package com.xiaomi.push;

import android.content.Context;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bl;
import com.xiaomi.push.jl;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bv;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* compiled from: Taobao */
public class fh {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f355a;

    /* renamed from: a  reason: collision with other field name */
    private bl f356a = bl.a();

    /* renamed from: a  reason: collision with other field name */
    private fg f357a;

    /* renamed from: a  reason: collision with other field name */
    private String f358a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f359a = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        static final fh a = new fh();
    }

    private fa a(bl.a aVar) {
        if (aVar.f134a == 0) {
            Object obj = aVar.f135a;
            if (obj instanceof fa) {
                return (fa) obj;
            }
            return null;
        }
        fa a2 = m476a();
        a2.a(ez.CHANNEL_STATS_COUNTER.a());
        a2.c(aVar.f134a);
        a2.c(aVar.f136a);
        return a2;
    }

    private fb a(int i) {
        ArrayList arrayList = new ArrayList();
        fb fbVar = new fb(this.f358a, arrayList);
        if (!bj.e(this.f357a.f352a)) {
            fbVar.a(j.k(this.f357a.f352a));
        }
        jn jnVar = new jn(i);
        jf a2 = new jl.a().a(jnVar);
        try {
            fbVar.b(a2);
        } catch (iz unused) {
        }
        LinkedList<bl.a> a3 = this.f356a.m289a();
        while (true) {
            try {
                if (a3.size() <= 0) {
                    break;
                }
                fa a4 = a(a3.getLast());
                if (a4 != null) {
                    a4.b(a2);
                }
                if (jnVar.a_() > i) {
                    break;
                }
                if (a4 != null) {
                    arrayList.add(a4);
                }
                a3.removeLast();
            } catch (iz | NoSuchElementException unused2) {
            }
        }
        return fbVar;
    }

    public static fg a() {
        fg fgVar;
        fh fhVar = a.a;
        synchronized (fhVar) {
            fgVar = fhVar.f357a;
        }
        return fgVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static fh m474a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m475a() {
        if (this.f359a && System.currentTimeMillis() - this.f355a > ((long) this.a)) {
            this.f359a = false;
            this.f355a = 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fa m476a() {
        fa faVar;
        faVar = new fa();
        faVar.a(bj.m282a((Context) this.f357a.f352a));
        faVar.f329a = 0;
        faVar.f333b = 1;
        faVar.d((int) (System.currentTimeMillis() / 1000));
        return faVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fb m477a() {
        fb fbVar;
        fbVar = null;
        if (b()) {
            int i = FeatureFactory.PRIORITY_ABOVE_NORMAL;
            if (!bj.e(this.f357a.f352a)) {
                i = 375;
            }
            fbVar = a(i);
        }
        return fbVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m478a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.a != i2 || !this.f359a) {
                this.f359a = true;
                this.f355a = System.currentTimeMillis();
                this.a = i2;
                b.c("enable dot duration = " + i2 + " start = " + this.f355a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(fa faVar) {
        this.f356a.a(faVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f357a = new fg(xMPushService);
        this.f358a = "";
        bv.a().a(new fi(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m479a() {
        return this.f359a;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        m475a();
        return this.f359a && this.f356a.m288a() > 0;
    }
}
