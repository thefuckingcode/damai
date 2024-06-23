package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cj;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class cc implements Runnable {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f152a;

    public cc(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.f152a = weakReference;
    }

    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f152a;
        if (weakReference != null && (context = weakReference.get()) != null) {
            if (cp.a(this.a) > cb.f150a) {
                cf a2 = cf.a(this.a);
                ce a3 = ce.a(this.a);
                a2.a(a3);
                a3.a(cd.a(context, this.a, 1000));
                cj.a(context).a((cj.a) a2);
                return;
            }
            b.b("=====> do not need clean db");
        }
    }
}
