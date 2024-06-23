package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.j.c;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.u.l;
import com.alipay.sdk.m.u.n;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class AuthTask {
    public static final Object c = h.class;
    public Activity a;
    public com.alipay.sdk.m.x.a b;

    /* compiled from: Taobao */
    public class a implements h.g {
        public a() {
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void a() {
            AuthTask.this.c();
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void b() {
        }
    }

    public AuthTask(Activity activity) {
        this.a = activity;
        b.d().a(this.a);
        this.b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.k);
    }

    private String b(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        String[] c2 = bVar.c();
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        Intent intent = new Intent(this.a, H5AuthActivity.class);
        intent.putExtras(bundle);
        a.C0134a.a(aVar, intent);
        this.a.startActivity(intent);
        Object obj = c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String d = com.alipay.sdk.m.j.b.d();
        return TextUtils.isEmpty(d) ? com.alipay.sdk.m.j.b.a() : d;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private h.g d() {
        return new a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    private String e(Activity activity, String str, com.alipay.sdk.m.s.a aVar) {
        f();
        c cVar = null;
        try {
            List<com.alipay.sdk.m.r.b> a2 = com.alipay.sdk.m.r.b.a(new com.alipay.sdk.m.q.a().a(aVar, activity, str).c().optJSONObject(com.alipay.sdk.m.l.c.c).optJSONObject(com.alipay.sdk.m.l.c.d));
            c();
            for (int i = 0; i < a2.size(); i++) {
                if (a2.get(i).a() == com.alipay.sdk.m.r.a.WapPay) {
                    String b2 = b(aVar, a2.get(i));
                    c();
                    return b2;
                }
            }
            c();
        } catch (IOException e) {
            c b3 = c.b(c.NETWORK_ERROR.b());
            com.alipay.sdk.m.k.a.a(aVar, "net", e);
            cVar = b3;
        } catch (Throwable th) {
            c();
            throw th;
        }
        if (cVar == null) {
            cVar = c.b(c.FAILED.b());
        }
        return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
        c();
        if (cVar == null) {
        }
        return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
    }

    private void f() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public synchronized String auth(String str, boolean z) {
        return innerAuth(new com.alipay.sdk.m.s.a(this.a, str, "auth"), str, z);
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        com.alipay.sdk.m.s.a aVar;
        aVar = new com.alipay.sdk.m.s.a(this.a, str, "authV2");
        return l.a(aVar, innerAuth(aVar, str, z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00bf, code lost:
        if (com.alipay.sdk.m.m.a.D().s() != false) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00c1, code lost:
        com.alipay.sdk.m.m.a.D().a(r7, r6.a, false, 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ca, code lost:
        c();
        com.alipay.sdk.m.k.a.b(r6.a, r7, r8, r7.d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006b, code lost:
        if (com.alipay.sdk.m.m.a.D().s() == false) goto L_0x00c1;
     */
    public synchronized String innerAuth(com.alipay.sdk.m.s.a aVar, String str, boolean z) {
        String a2;
        if (z) {
            f();
        }
        b.d().a(this.a);
        a2 = com.alipay.sdk.m.j.b.a();
        com.alipay.sdk.m.j.a.a("");
        try {
            a2 = a(this.a, str, aVar);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, l.a(a2, l.a) + "|" + l.a(a2, l.b));
        } catch (Exception e) {
            e.a(e);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, l.a(a2, l.a) + "|" + l.a(a2, l.b));
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, l.a(a2, l.a) + "|" + l.a(a2, l.b));
            if (!com.alipay.sdk.m.m.a.D().s()) {
                com.alipay.sdk.m.m.a.D().a(aVar, this.a, false, 1);
            }
            c();
            com.alipay.sdk.m.k.a.b(this.a, aVar, str, aVar.d);
            throw th;
        }
        return a2;
    }

    private String a(Activity activity, String str, com.alipay.sdk.m.s.a aVar) {
        String a2 = aVar.a(str);
        List<a.b> l = com.alipay.sdk.m.m.a.D().l();
        if (!com.alipay.sdk.m.m.a.D().h || l == null) {
            l = com.alipay.sdk.m.j.a.d;
        }
        if (n.a(aVar, (Context) this.a, l, true)) {
            h hVar = new h(activity, aVar, d());
            String a3 = hVar.a(a2, false);
            hVar.a();
            if (!TextUtils.equals(a3, "failed") && !TextUtils.equals(a3, h.k)) {
                return TextUtils.isEmpty(a3) ? com.alipay.sdk.m.j.b.a() : a3;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
            return e(activity, a2, aVar);
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
        return e(activity, a2, aVar);
    }
}
