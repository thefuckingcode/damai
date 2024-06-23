package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.d;
import okhttp3.m;
import okhttp3.o;
import okio.AsyncTimeout;
import tb.f21;
import tb.oq1;

/* compiled from: Taobao */
public final class i {
    private final OkHttpClient a;
    private final f b;
    private final Call c;
    private final EventListener d;
    private final AsyncTimeout e;
    @Nullable
    private Object f;
    private o g;
    private d h;
    public e i;
    @Nullable
    private c j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;

    /* compiled from: Taobao */
    class a extends AsyncTimeout {
        a() {
        }

        /* access modifiers changed from: protected */
        @Override // okio.AsyncTimeout
        public void timedOut() {
            i.this.d();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b extends WeakReference<i> {
        final Object a;

        b(i iVar, Object obj) {
            super(iVar);
            this.a = obj;
        }
    }

    public i(OkHttpClient okHttpClient, Call call) {
        a aVar = new a();
        this.e = aVar;
        this.a = okHttpClient;
        this.b = f21.a.i(okHttpClient.connectionPool());
        this.c = call;
        this.d = okHttpClient.eventListenerFactory().create(call);
        aVar.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    private okhttp3.a e(m mVar) {
        d dVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (mVar.n()) {
            SSLSocketFactory sslSocketFactory = this.a.sslSocketFactory();
            hostnameVerifier = this.a.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            dVar = this.a.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            dVar = null;
        }
        return new okhttp3.a(mVar.m(), mVar.x(), this.a.dns(), this.a.socketFactory(), sSLSocketFactory, hostnameVerifier, dVar, this.a.proxyAuthenticator(), this.a.proxy(), this.a.protocols(), this.a.connectionSpecs(), this.a.proxySelector());
    }

    @Nullable
    private IOException j(@Nullable IOException iOException, boolean z) {
        e eVar;
        Socket n2;
        boolean z2;
        boolean z3;
        synchronized (this.b) {
            if (z) {
                if (this.j != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            eVar = this.i;
            n2 = (eVar == null || this.j != null || (!z && !this.o)) ? null : n();
            if (this.i != null) {
                eVar = null;
            }
            z2 = true;
            z3 = this.o && this.j == null;
        }
        okhttp3.internal.a.h(n2);
        if (eVar != null) {
            this.d.i(this.c, eVar);
        }
        if (z3) {
            if (iOException == null) {
                z2 = false;
            }
            iOException = r(iOException);
            if (z2) {
                this.d.c(this.c, iOException);
            } else {
                this.d.b(this.c);
            }
        }
        return iOException;
    }

    @Nullable
    private IOException r(@Nullable IOException iOException) {
        if (this.n || !this.e.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        if (this.i == null) {
            this.i = eVar;
            eVar.o.add(new b(this, this.f));
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        this.f = oq1.j().n("response.body().close()");
        this.d.d(this.c);
    }

    public boolean c() {
        return this.h.f() && this.h.e();
    }

    public void d() {
        c cVar;
        e eVar;
        synchronized (this.b) {
            this.m = true;
            cVar = this.j;
            d dVar = this.h;
            if (dVar == null || dVar.a() == null) {
                eVar = this.i;
            } else {
                eVar = this.h.a();
            }
        }
        if (cVar != null) {
            cVar.b();
        } else if (eVar != null) {
            eVar.c();
        }
    }

    public void f() {
        synchronized (this.b) {
            if (!this.o) {
                this.j = null;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return j(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r7;
     */
    @Nullable
    public IOException g(c cVar, boolean z, boolean z2, @Nullable IOException iOException) {
        boolean z3;
        synchronized (this.b) {
            c cVar2 = this.j;
            if (cVar != cVar2) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.k;
                this.k = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.l) {
                    z3 = true;
                }
                this.l = true;
            }
            if (!this.k || !this.l || !z3) {
                z4 = false;
            } else {
                cVar2.c().l++;
                this.j = null;
            }
        }
    }

    public boolean h() {
        boolean z;
        synchronized (this.b) {
            z = this.j != null;
        }
        return z;
    }

    public boolean i() {
        boolean z;
        synchronized (this.b) {
            z = this.m;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public c k(Interceptor.Chain chain, boolean z) {
        synchronized (this.b) {
            if (this.o) {
                throw new IllegalStateException("released");
            } else if (this.j != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        c cVar = new c(this, this.c, this.d, this.h, this.h.b(this.a, chain, z));
        synchronized (this.b) {
            this.j = cVar;
            this.k = false;
            this.l = false;
        }
        return cVar;
    }

    @Nullable
    public IOException l(@Nullable IOException iOException) {
        synchronized (this.b) {
            this.o = true;
        }
        return j(iOException, false);
    }

    public void m(o oVar) {
        o oVar2 = this.g;
        if (oVar2 != null) {
            if (okhttp3.internal.a.E(oVar2.i(), oVar.i()) && this.h.e()) {
                return;
            }
            if (this.j != null) {
                throw new IllegalStateException();
            } else if (this.h != null) {
                j(null, true);
                this.h = null;
            }
        }
        this.g = oVar;
        this.h = new d(this, this.b, e(oVar.i()), this.c, this.d);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Socket n() {
        int i2 = 0;
        int size = this.i.o.size();
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.i.o.get(i2).get() == this) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            e eVar = this.i;
            eVar.o.remove(i2);
            this.i = null;
            if (!eVar.o.isEmpty()) {
                return null;
            }
            eVar.p = System.nanoTime();
            if (this.b.d(eVar)) {
                return eVar.socket();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    public okio.o o() {
        return this.e;
    }

    public void p() {
        if (!this.n) {
            this.n = true;
            this.e.exit();
            return;
        }
        throw new IllegalStateException();
    }

    public void q() {
        this.e.enter();
    }
}
