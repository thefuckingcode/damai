package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.a;
import okhttp3.internal.connection.h;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.s;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class d {
    private final i a;
    private final a b;
    private final f c;
    private final Call d;
    private final EventListener e;
    private h.a f;
    private final h g;
    private e h;
    private boolean i;
    private s j;

    d(i iVar, f fVar, a aVar, Call call, EventListener eventListener) {
        this.a = iVar;
        this.c = fVar;
        this.b = aVar;
        this.d = call;
        this.e = eventListener;
        this.g = new h(aVar, fVar.e, call, eventListener);
    }

    private e c(int i2, int i3, int i4, int i5, boolean z) throws IOException {
        e eVar;
        Socket socket;
        Socket n;
        e eVar2;
        boolean z2;
        s sVar;
        boolean z3;
        List<s> list;
        h.a aVar;
        synchronized (this.c) {
            if (!this.a.i()) {
                this.i = false;
                i iVar = this.a;
                eVar = iVar.i;
                socket = null;
                n = (eVar == null || !eVar.j) ? null : iVar.n();
                i iVar2 = this.a;
                eVar2 = iVar2.i;
                if (eVar2 != null) {
                    eVar = null;
                } else {
                    eVar2 = null;
                }
                if (eVar2 == null) {
                    if (this.c.h(this.b, iVar2, null, false)) {
                        eVar2 = this.a.i;
                        sVar = null;
                        z2 = true;
                    } else {
                        sVar = this.j;
                        if (sVar != null) {
                            this.j = null;
                        } else if (g()) {
                            sVar = this.a.i.route();
                        }
                        z2 = false;
                    }
                }
                sVar = null;
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        okhttp3.internal.a.h(n);
        if (eVar != null) {
            this.e.i(this.d, eVar);
        }
        if (z2) {
            this.e.h(this.d, eVar2);
        }
        if (eVar2 != null) {
            return eVar2;
        }
        if (sVar != null || ((aVar = this.f) != null && aVar.b())) {
            z3 = false;
        } else {
            this.f = this.g.d();
            z3 = true;
        }
        synchronized (this.c) {
            if (!this.a.i()) {
                if (z3) {
                    list = this.f.a();
                    if (this.c.h(this.b, this.a, list, false)) {
                        eVar2 = this.a.i;
                        z2 = true;
                    }
                } else {
                    list = null;
                }
                if (!z2) {
                    if (sVar == null) {
                        sVar = this.f.c();
                    }
                    eVar2 = new e(this.c, sVar);
                    this.h = eVar2;
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.e.h(this.d, eVar2);
            return eVar2;
        }
        eVar2.d(i2, i3, i4, i5, z, this.d, this.e);
        this.c.e.a(eVar2.route());
        synchronized (this.c) {
            this.h = null;
            if (this.c.h(this.b, this.a, list, true)) {
                eVar2.j = true;
                socket = eVar2.socket();
                eVar2 = this.a.i;
                this.j = sVar;
            } else {
                this.c.g(eVar2);
                this.a.a(eVar2);
            }
        }
        okhttp3.internal.a.h(socket);
        this.e.h(this.d, eVar2);
        return eVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0.l(r9) != false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return r0;
     */
    private e d(int i2, int i3, int i4, int i5, boolean z, boolean z2) throws IOException {
        while (true) {
            e c2 = c(i2, i3, i4, i5, z);
            synchronized (this.c) {
                if (c2.l == 0 && !c2.m()) {
                    return c2;
                }
            }
            c2.p();
        }
    }

    private boolean g() {
        e eVar = this.a.i;
        return eVar != null && eVar.k == 0 && okhttp3.internal.a.E(eVar.route().a().l(), this.b.l());
    }

    /* access modifiers changed from: package-private */
    public e a() {
        return this.h;
    }

    public ExchangeCodec b(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            return d(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).n(okHttpClient, chain);
        } catch (RouteException e2) {
            h();
            throw e2;
        } catch (IOException e3) {
            h();
            throw new RouteException(e3);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        synchronized (this.c) {
            boolean z = true;
            if (this.j != null) {
                return true;
            }
            if (g()) {
                this.j = this.a.i.route();
                return true;
            }
            h.a aVar = this.f;
            if (aVar == null || !aVar.b()) {
                if (!this.g.b()) {
                    z = false;
                }
            }
            return z;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        boolean z;
        synchronized (this.c) {
            z = this.i;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        synchronized (this.c) {
            this.i = true;
        }
    }
}
