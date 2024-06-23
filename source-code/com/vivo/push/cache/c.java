package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.g;
import com.vivo.push.util.p;
import com.vivo.push.util.w;
import com.vivo.push.util.y;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public abstract class c<T> {
    protected static final Object a = new Object();
    protected List<T> b = new ArrayList();
    protected Context c;
    private byte[] d;
    private byte[] e;

    protected c(Context context) {
        this.c = ContextDelegate.getContext(context);
        w b2 = w.b();
        b2.a(this.c);
        this.d = b2.c();
        this.e = b2.d();
        c();
    }

    private String b() {
        return y.b(this.c).a(a(), null);
    }

    private void d(String str) {
        y.b(this.c).b(a(), str);
    }

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract List<T> a(String str);

    /* access modifiers changed from: package-private */
    public abstract String b(String str) throws Exception;

    public final void c() {
        synchronized (a) {
            g.a(a());
            this.b.clear();
            c(b());
        }
    }

    /* access modifiers changed from: protected */
    public final byte[] e() {
        byte[] bArr = this.d;
        if (bArr == null || bArr.length <= 0) {
            return w.b().c();
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public final byte[] f() {
        byte[] bArr = this.e;
        if (bArr == null || bArr.length <= 0) {
            return w.b().d();
        }
        return bArr;
    }

    public final void d() {
        synchronized (a) {
            this.b.clear();
            d("");
            p.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            p.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
        } else if (str.length() > 10000) {
            p.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
        } else {
            try {
                p.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
                List<T> a2 = a(b(str));
                if (a2 != null) {
                    this.b.addAll(a2);
                }
            } catch (Exception e2) {
                d();
                p.d("CacheSettings", p.a(e2));
            }
        }
    }
}
