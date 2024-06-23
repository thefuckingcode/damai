package com.amap.api.mapcore.util;

import java.net.Proxy;

/* renamed from: com.amap.api.mapcore.util.if  reason: invalid class name */
/* compiled from: Taobao */
public class Cif {
    private ig a;
    private ii b;

    /* renamed from: com.amap.api.mapcore.util.if$a */
    /* compiled from: Taobao */
    public interface a {
        void onDownload(byte[] bArr, long j);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    public Cif(ii iiVar) {
        this(iiVar, 0, -1);
    }

    public void a(a aVar) {
        this.a.a(this.b.getURL(), this.b.c(), this.b.isIPRequest(), this.b.getIPDNSName(), this.b.getRequestHead(), this.b.getParams(), this.b.getEntityBytes(), aVar, ig.a(2, this.b));
    }

    public Cif(ii iiVar, long j, long j2) {
        this(iiVar, j, j2, false);
    }

    public Cif(ii iiVar, long j, long j2, boolean z) {
        this.b = iiVar;
        Proxy proxy = iiVar.c;
        ig igVar = new ig(iiVar.a, iiVar.b, proxy == null ? null : proxy, z);
        this.a = igVar;
        igVar.b(j2);
        this.a.a(j);
    }

    public void a() {
        this.a.a();
    }
}
