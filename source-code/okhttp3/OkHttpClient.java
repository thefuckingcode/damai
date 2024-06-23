package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.WebSocket;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.f;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.l;
import okhttp3.q;
import tb.cz2;
import tb.dk1;
import tb.f21;
import tb.oq1;
import tb.tk1;

/* compiled from: Taobao */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    static final List<g> DEFAULT_CONNECTION_SPECS = okhttp3.internal.a.u(g.MODERN_TLS, g.CLEARTEXT);
    static final List<Protocol> DEFAULT_PROTOCOLS = okhttp3.internal.a.u(Protocol.HTTP_2, Protocol.HTTP_1_1);
    final Authenticator authenticator;
    @Nullable
    final c cache;
    final int callTimeout;
    final okhttp3.internal.tls.b certificateChainCleaner;
    final d certificatePinner;
    final int connectTimeout;
    final f connectionPool;
    final List<g> connectionSpecs;
    final CookieJar cookieJar;
    final h dispatcher;
    final Dns dns;
    final EventListener.Factory eventListenerFactory;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;
    @Nullable
    final InternalCache internalCache;
    final List<Interceptor> networkInterceptors;
    final int pingInterval;
    final List<Protocol> protocols;
    @Nullable
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final int writeTimeout;

    /* compiled from: Taobao */
    class a extends f21 {
        a() {
        }

        @Override // tb.f21
        public void a(l.a aVar, String str) {
            aVar.b(str);
        }

        @Override // tb.f21
        public void b(l.a aVar, String str, String str2) {
            aVar.c(str, str2);
        }

        @Override // tb.f21
        public void c(g gVar, SSLSocket sSLSocket, boolean z) {
            gVar.a(sSLSocket, z);
        }

        @Override // tb.f21
        public int d(q.a aVar) {
            return aVar.c;
        }

        @Override // tb.f21
        public boolean e(a aVar, a aVar2) {
            return aVar.d(aVar2);
        }

        @Override // tb.f21
        @Nullable
        public c f(q qVar) {
            return qVar.m;
        }

        @Override // tb.f21
        public void g(q.a aVar, c cVar) {
            aVar.k(cVar);
        }

        @Override // tb.f21
        public Call h(OkHttpClient okHttpClient, o oVar) {
            return RealCall.newRealCall(okHttpClient, oVar, true);
        }

        @Override // tb.f21
        public f i(f fVar) {
            return fVar.a;
        }
    }

    static {
        f21.a = new a();
    }

    public OkHttpClient() {
        this(new b());
    }

    private static SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext l = oq1.j().l();
            l.init(null, new TrustManager[]{x509TrustManager}, null);
            return l.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS", e);
        }
    }

    public Authenticator authenticator() {
        return this.authenticator;
    }

    @Nullable
    public c cache() {
        return this.cache;
    }

    public int callTimeoutMillis() {
        return this.callTimeout;
    }

    public d certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public f connectionPool() {
        return this.connectionPool;
    }

    public List<g> connectionSpecs() {
        return this.connectionSpecs;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    public h dispatcher() {
        return this.dispatcher;
    }

    public Dns dns() {
        return this.dns;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public InternalCache internalCache() {
        c cVar = this.cache;
        return cVar != null ? cVar.a : this.internalCache;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public b newBuilder() {
        return new b(this);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(o oVar) {
        return RealCall.newRealCall(this, oVar, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(o oVar, cz2 cz2) {
        RealWebSocket realWebSocket = new RealWebSocket(oVar, cz2, new Random(), (long) this.pingInterval);
        realWebSocket.d(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    @Nullable
    public Proxy proxy() {
        return this.proxy;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    OkHttpClient(b bVar) {
        boolean z;
        this.dispatcher = bVar.a;
        this.proxy = bVar.b;
        this.protocols = bVar.c;
        List<g> list = bVar.d;
        this.connectionSpecs = list;
        this.interceptors = okhttp3.internal.a.t(bVar.e);
        this.networkInterceptors = okhttp3.internal.a.t(bVar.f);
        this.eventListenerFactory = bVar.g;
        this.proxySelector = bVar.h;
        this.cookieJar = bVar.i;
        this.cache = bVar.j;
        this.internalCache = bVar.k;
        this.socketFactory = bVar.l;
        Iterator<g> it = list.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                g next = it.next();
                if (z || next.d()) {
                    z = true;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.m;
        if (sSLSocketFactory != null || !z) {
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = bVar.n;
        } else {
            X509TrustManager D = okhttp3.internal.a.D();
            this.sslSocketFactory = newSslSocketFactory(D);
            this.certificateChainCleaner = okhttp3.internal.tls.b.b(D);
        }
        if (this.sslSocketFactory != null) {
            oq1.j().f(this.sslSocketFactory);
        }
        this.hostnameVerifier = bVar.o;
        this.certificatePinner = bVar.p.f(this.certificateChainCleaner);
        this.proxyAuthenticator = bVar.q;
        this.authenticator = bVar.r;
        this.connectionPool = bVar.s;
        this.dns = bVar.t;
        this.followSslRedirects = bVar.u;
        this.followRedirects = bVar.v;
        this.retryOnConnectionFailure = bVar.w;
        this.callTimeout = bVar.x;
        this.connectTimeout = bVar.y;
        this.readTimeout = bVar.z;
        this.writeTimeout = bVar.A;
        this.pingInterval = bVar.B;
        if (this.interceptors.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.interceptors);
        } else if (this.networkInterceptors.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        int A;
        int B;
        h a;
        @Nullable
        Proxy b;
        List<Protocol> c;
        List<g> d;
        final List<Interceptor> e;
        final List<Interceptor> f;
        EventListener.Factory g;
        ProxySelector h;
        CookieJar i;
        @Nullable
        c j;
        @Nullable
        InternalCache k;
        SocketFactory l;
        @Nullable
        SSLSocketFactory m;
        @Nullable
        okhttp3.internal.tls.b n;
        HostnameVerifier o;
        d p;
        Authenticator q;
        Authenticator r;
        f s;
        Dns t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public b() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.a = new h();
            this.c = OkHttpClient.DEFAULT_PROTOCOLS;
            this.d = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.g = EventListener.l(EventListener.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.h = proxySelector;
            if (proxySelector == null) {
                this.h = new dk1();
            }
            this.i = CookieJar.NO_COOKIES;
            this.l = SocketFactory.getDefault();
            this.o = tk1.INSTANCE;
            this.p = d.DEFAULT;
            Authenticator authenticator = Authenticator.NONE;
            this.q = authenticator;
            this.r = authenticator;
            this.s = new f();
            this.t = Dns.SYSTEM;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        public b a(Interceptor interceptor) {
            if (interceptor != null) {
                this.e.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public OkHttpClient b() {
            return new OkHttpClient(this);
        }

        public b c(@Nullable c cVar) {
            this.j = cVar;
            this.k = null;
            return this;
        }

        public b d(long j2, TimeUnit timeUnit) {
            this.y = okhttp3.internal.a.e("timeout", j2, timeUnit);
            return this;
        }

        public b e(List<g> list) {
            this.d = okhttp3.internal.a.t(list);
            return this;
        }

        public b f(Dns dns) {
            Objects.requireNonNull(dns, "dns == null");
            this.t = dns;
            return this;
        }

        public b g(EventListener eventListener) {
            Objects.requireNonNull(eventListener, "eventListener == null");
            this.g = EventListener.l(eventListener);
            return this;
        }

        public b h(boolean z2) {
            this.v = z2;
            return this;
        }

        public b i(HostnameVerifier hostnameVerifier) {
            Objects.requireNonNull(hostnameVerifier, "hostnameVerifier == null");
            this.o = hostnameVerifier;
            return this;
        }

        public b j(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(protocol) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            } else if (arrayList.contains(protocol) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (!arrayList.contains(null)) {
                arrayList.remove(Protocol.SPDY_3);
                this.c = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        public b k(long j2, TimeUnit timeUnit) {
            this.z = okhttp3.internal.a.e("timeout", j2, timeUnit);
            return this;
        }

        public b l(boolean z2) {
            this.w = z2;
            return this;
        }

        public b m(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            Objects.requireNonNull(x509TrustManager, "trustManager == null");
            this.m = sSLSocketFactory;
            this.n = okhttp3.internal.tls.b.b(x509TrustManager);
            return this;
        }

        public b n(long j2, TimeUnit timeUnit) {
            this.A = okhttp3.internal.a.e("timeout", j2, timeUnit);
            return this;
        }

        b(OkHttpClient okHttpClient) {
            ArrayList arrayList = new ArrayList();
            this.e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f = arrayList2;
            this.a = okHttpClient.dispatcher;
            this.b = okHttpClient.proxy;
            this.c = okHttpClient.protocols;
            this.d = okHttpClient.connectionSpecs;
            arrayList.addAll(okHttpClient.interceptors);
            arrayList2.addAll(okHttpClient.networkInterceptors);
            this.g = okHttpClient.eventListenerFactory;
            this.h = okHttpClient.proxySelector;
            this.i = okHttpClient.cookieJar;
            this.k = okHttpClient.internalCache;
            this.j = okHttpClient.cache;
            this.l = okHttpClient.socketFactory;
            this.m = okHttpClient.sslSocketFactory;
            this.n = okHttpClient.certificateChainCleaner;
            this.o = okHttpClient.hostnameVerifier;
            this.p = okHttpClient.certificatePinner;
            this.q = okHttpClient.proxyAuthenticator;
            this.r = okHttpClient.authenticator;
            this.s = okHttpClient.connectionPool;
            this.t = okHttpClient.dns;
            this.u = okHttpClient.followSslRedirects;
            this.v = okHttpClient.followRedirects;
            this.w = okHttpClient.retryOnConnectionFailure;
            this.x = okHttpClient.callTimeout;
            this.y = okHttpClient.connectTimeout;
            this.z = okHttpClient.readTimeout;
            this.A = okHttpClient.writeTimeout;
            this.B = okHttpClient.pingInterval;
        }
    }
}
