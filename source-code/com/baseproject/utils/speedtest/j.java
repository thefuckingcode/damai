package com.baseproject.utils.speedtest;

import com.alibaba.fastjson.JSON;
import com.baseproject.utils.speedtest.SpeedTestRequest;
import com.taobao.tlog.adapter.AdapterForTLog;
import java.util.concurrent.ExecutorService;
import tb.i63;
import tb.j63;
import tb.n23;

/* compiled from: Taobao */
public class j implements SpeedTestRequest.a {
    private ExecutorService a;
    private SpeedTestRequest b;
    private a c;
    private String d;
    private int e;
    private volatile boolean f = true;
    private g g;
    private h h;

    /* compiled from: Taobao */
    public static class a {
        public n23 a;
        public a b;
        public long c;
    }

    static {
        new j();
    }

    private j() {
    }

    private void d(int i) {
        i63 i63 = new i63();
        i63.a = i;
        g(i63);
        g gVar = this.g;
        if (gVar != null) {
            gVar.a(i63);
        }
        j63.a(i63);
    }

    /* access modifiers changed from: private */
    public int e() {
        int i;
        com.youku.b.a.a.a("SpeedTest", "request cmd info");
        AdapterForTLog.loge("SpeedTest", "request cmd info");
        b bVar = new b();
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = this.c;
        if (aVar != null) {
            i = bVar.a(this.d, aVar);
            this.c.c = System.currentTimeMillis() - currentTimeMillis;
        } else {
            i = -999;
        }
        if (i < 0) {
            d(i);
            c();
            return i;
        }
        com.youku.b.a.a.a("SpeedTest", "cmd info received");
        AdapterForTLog.loge("SpeedTest", "cmd info received");
        if (this.c.b.d != null) {
            this.e = 0;
            i();
            return 0;
        }
        com.youku.b.a.a.a("SpeedTest", "cmd task is empty");
        c();
        return -2005;
    }

    private void g(i63 i63) {
        n23 n23;
        a aVar = this.c;
        if (aVar != null && (n23 = aVar.a) != null) {
            i63.j = n23.p;
            i63.k = n23.q;
            i63.l = n23.r;
            i63.o = n23.t;
            i63.m = n23.s;
            i63.n = aVar.c;
        }
    }

    private void i() {
        this.a.execute(new SpeedTest$2(this));
    }

    static /* synthetic */ int k(j jVar) {
        int i = jVar.e;
        jVar.e = i + 1;
        return i;
    }

    @Override // com.baseproject.utils.speedtest.SpeedTestRequest.a
    public void a(i63 i63) {
        if (!this.f) {
            g(i63);
            g gVar = this.g;
            if (gVar != null) {
                gVar.a(i63);
            }
            j63.a(i63);
            com.youku.b.a.a.a("SpeedTest", JSON.toJSONString(i63));
            i();
        }
    }

    public void c() {
        com.youku.b.a.a.a("SpeedTest", "cancel!");
        AdapterForTLog.loge("SpeedTest", "cancel!");
        this.f = true;
        SpeedTestRequest speedTestRequest = this.b;
        if (speedTestRequest != null && speedTestRequest.k()) {
            this.b.j();
        }
        h hVar = this.h;
        if (hVar != null) {
            hVar.a();
        }
        this.a.shutdown();
    }
}
