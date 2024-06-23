package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.connection.i;
import okhttp3.internal.http.a;
import okhttp3.internal.http.b;
import okhttp3.internal.http.c;
import okhttp3.internal.http.d;
import okio.o;
import tb.oq1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class RealCall implements Call {
    final OkHttpClient client;
    private boolean executed;
    final boolean forWebSocket;
    final o originalRequest;
    private i transmitter;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: package-private */
        public AtomicInteger callsPerHost() {
            return this.callsPerHost;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[Catch:{ IOException -> 0x0055, all -> 0x0028, all -> 0x0053 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[Catch:{ IOException -> 0x0055, all -> 0x0028, all -> 0x0053 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x007a A[Catch:{ IOException -> 0x0055, all -> 0x0028, all -> 0x0053 }] */
        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            boolean z;
            IOException e;
            Throwable th;
            RealCall.this.transmitter.q();
            try {
                z = true;
                try {
                    this.responseCallback.onResponse(RealCall.this, RealCall.this.getResponseWithInterceptorChain());
                } catch (IOException e2) {
                    e = e2;
                    if (!z) {
                    }
                    RealCall.this.client.dispatcher().f(this);
                } catch (Throwable th2) {
                    th = th2;
                    RealCall.this.cancel();
                    if (!z) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
                if (!z) {
                    oq1 j = oq1.j();
                    j.q(4, "Callback failure for " + RealCall.this.toLoggableString(), e);
                } else {
                    this.responseCallback.onFailure(RealCall.this, e);
                }
                RealCall.this.client.dispatcher().f(this);
            } catch (Throwable th3) {
                RealCall.this.client.dispatcher().f(this);
                throw th3;
            }
            RealCall.this.client.dispatcher().f(this);
        }

        /* access modifiers changed from: package-private */
        public void executeOn(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                RealCall.this.transmitter.l(interruptedIOException);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                RealCall.this.client.dispatcher().f(this);
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().f(this);
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.originalRequest.i().m();
        }

        /* access modifiers changed from: package-private */
        public o request() {
            return RealCall.this.originalRequest;
        }

        /* access modifiers changed from: package-private */
        public void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            this.callsPerHost = asyncCall.callsPerHost;
        }
    }

    private RealCall(OkHttpClient okHttpClient, o oVar, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = oVar;
        this.forWebSocket = z;
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, o oVar, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, oVar, z);
        realCall.transmitter = new i(okHttpClient, realCall);
        return realCall;
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.transmitter.d();
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.transmitter.b();
        this.client.dispatcher().a(new AsyncCall(callback));
    }

    @Override // okhttp3.Call
    public q execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.transmitter.q();
        this.transmitter.b();
        try {
            this.client.dispatcher().b(this);
            return getResponseWithInterceptorChain();
        } finally {
            this.client.dispatcher().g(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a5  */
    public q getResponseWithInterceptorChain() throws IOException {
        Throwable th;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(new d(this.client));
        arrayList.add(new a(this.client.cookieJar()));
        arrayList.add(new okhttp3.internal.cache.a(this.client.internalCache()));
        arrayList.add(new okhttp3.internal.connection.a(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new b(this.forWebSocket));
        boolean z = false;
        try {
            q proceed = new c(arrayList, this.transmitter, null, 0, this.originalRequest, this, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
            if (!this.transmitter.i()) {
                this.transmitter.l(null);
                return proceed;
            }
            okhttp3.internal.a.g(proceed);
            throw new IOException("Canceled");
        } catch (IOException e) {
            throw this.transmitter.l(e);
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (!z) {
            }
            throw th;
        }
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.transmitter.i();
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    /* access modifiers changed from: package-private */
    public String redactedUrl() {
        return this.originalRequest.i().A();
    }

    @Override // okhttp3.Call
    public o request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public o timeout() {
        return this.transmitter.o();
    }

    /* access modifiers changed from: package-private */
    public String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    @Override // okhttp3.Call, java.lang.Object
    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
