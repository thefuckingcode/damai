package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.d.f.a;
import com.meizu.cloud.pushsdk.d.f.c;
import com.meizu.cloud.pushsdk.d.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
public class b {
    private static final String a = "b";
    private String b;
    private String c = null;
    private String d;
    private int e = 0;
    private final String f = "SQLITE";
    private final AtomicBoolean g = new AtomicBoolean(false);
    private long h;
    private final long i;
    private final long j;
    private final Context k;

    public b(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.i = timeUnit.toMillis(j2);
        this.j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.b = obj;
                this.e = intValue;
                this.c = obj2;
            } catch (Exception e2) {
                c.a(a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            c.c(a, "Tracker Session Object created.", new Object[0]);
        }
        this.b = e.b();
        d();
        g();
        c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.d = this.c;
        this.c = e.b();
        this.e++;
        String str = a;
        c.b(str, "Session information is updated:", new Object[0]);
        c.b(str, " + Session ID: %s", this.c);
        c.b(str, " + Previous Session ID: %s", this.d);
        c.b(str, " + Session Index: %s", Integer.valueOf(this.e));
        e();
    }

    private boolean e() {
        return a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.d.a.b a() {
        c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.d.a.b("client_session", c());
    }

    public void b() {
        c.b(a, "Checking and updating session information.", new Object[0]);
        if (!e.a(this.h, System.currentTimeMillis(), this.g.get() ? this.j : this.i)) {
            d();
            g();
        }
    }

    public Map c() {
        HashMap hashMap = new HashMap(8);
        hashMap.put("userId", this.b);
        hashMap.put("sessionId", this.c);
        hashMap.put("previousSessionId", this.d);
        hashMap.put("sessionIndex", Integer.valueOf(this.e));
        hashMap.put("storageMechanism", "SQLITE");
        return hashMap;
    }
}
