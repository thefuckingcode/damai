package com.meizu.cloud.pushsdk.d.e.a;

import com.meizu.cloud.pushsdk.d.b.a.b;
import com.meizu.cloud.pushsdk.d.e.a;
import com.meizu.cloud.pushsdk.d.f.c;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
public class a extends com.meizu.cloud.pushsdk.d.e.a {
    private static final String n = "a";
    private static ScheduledExecutorService o;

    public a(a.C0190a aVar) {
        super(aVar);
        b.a(this.k);
        c();
    }

    @Override // com.meizu.cloud.pushsdk.d.e.a
    public void a(final com.meizu.cloud.pushsdk.d.c.b bVar, final boolean z) {
        b.a(new Runnable() {
            /* class com.meizu.cloud.pushsdk.d.e.a.a.AnonymousClass2 */

            public void run() {
                a.super.a(bVar, z);
            }
        });
    }

    public void c() {
        if (o == null && this.i) {
            c.b(n, "Session checking has been resumed.", new Object[0]);
            final com.meizu.cloud.pushsdk.d.e.b bVar = this.d;
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            o = newSingleThreadScheduledExecutor;
            AnonymousClass1 r2 = new Runnable() {
                /* class com.meizu.cloud.pushsdk.d.e.a.a.AnonymousClass1 */

                public void run() {
                    bVar.b();
                }
            };
            long j = this.j;
            newSingleThreadScheduledExecutor.scheduleAtFixedRate(r2, j, j, this.l);
        }
    }
}
